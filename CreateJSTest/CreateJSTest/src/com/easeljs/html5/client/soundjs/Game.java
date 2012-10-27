package com.easeljs.html5.client.soundjs;

import java.util.ArrayList;
import java.util.List;

import com.easeljs.html5.client.easeljs.IEasel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.Canvas;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.Manifest;
import com.sinewavemultimedia.easeljs.framework.js.SoundNative;
import com.sinewavemultimedia.easeljs.framework.js.display.Container;
import com.sinewavemultimedia.easeljs.framework.js.display.DisplayObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Graphics;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.display.Text;
import com.sinewavemultimedia.easeljs.framework.js.geom.Rectangle;
import com.sinewavemultimedia.easeljs.framework.js.preload.PreloadJS;
import com.sinewavemultimedia.easeljs.framework.js.sound.FlashPlugin;
import com.sinewavemultimedia.easeljs.framework.js.sound.SoundJS;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class Game implements IEasel {

	PreloadJS preload = null;
	CreateJSObject createJSObject = null;
	int canvaswidth = 960;
	int canvasheight = 400;
	Stage stage =null;
	Canvas canvas = null;	
	
	Text messageField = null , scoreField = null;
	
	int loadingInterval = 0;
	
	List<SpaceRock> rockBelt = new ArrayList<SpaceRock>();
	JsArray<Shape> bulletStream = (JsArray<Shape>)JavaScriptObject.createArray();
	boolean alive = false;
	
	
	int DIFFICULTY = 2;
	int ROCK_TIME = 110;
	int SUB_ROCK_COUNT = 4;
	int BULLET_TIME = 5;
	int BULLET_ENTROPY = 100;

	int TURN_FACTOR = 7;
	int BULLET_SPEED = 17;

	int KEYCODE_ENTER = 13;
	int KEYCODE_SPACE = 32;
	int KEYCODE_UP = 38;
	int KEYCODE_LEFT = 37;
	int KEYCODE_RIGHT = 39;
	int KEYCODE_W = 87;
	int KEYCODE_A = 65;
	int KEYCODE_D = 68;	
	
	double timeToRock =0 ,nextRock = 0 , nextBullet = 0;
	
	boolean shootHeld =false,lfHeld = false,rtHeld = false,fwdHeld = false,dnHeld = false;
	
	Ship ship = null;
	@Override
	public void load(VerticalPanel panel) {
		FlashPlugin.BASE_PATH("../resources/soundjs/");
		if(SoundJS.checkPlugin(true)){

			String assetsPath ="../resources/sounds/";
			String[] array= new String[]{
					assetsPath+"Game-Spawn.mp3|"+assetsPath+"Game-Spawn.ogg",					
					assetsPath+"Game-Break.mp3|"+assetsPath+"Game-Break.ogg",
					assetsPath+"Game-Death.mp3|"+assetsPath+"Game-Death.ogg",
					assetsPath+"Game-Shot.mp3|"+assetsPath+"Game-Shot.ogg",
					assetsPath+"18-machinae_supremacy-lord_krutors_dominion.mp3|"+assetsPath+"18-machinae_supremacy-lord_krutors_dominion.ogg"
			};
			JsArray<Manifest> manifest = (JsArray<Manifest>)JavaScriptObject.createArray();
			Manifest tmanifest=Manifest.create();
			tmanifest.addStringProperty("src", array[0]);
			tmanifest.addStringProperty("id", "begin");
			manifest.push(tmanifest);
			
			Manifest tmanifest1=Manifest.create();
			tmanifest1.addStringProperty("src", array[1]);
			tmanifest1.addStringProperty("id", "break");
			tmanifest1.addIntProperty("data", 6);
			manifest.push(tmanifest1);		
			
			Manifest tmanifest2=Manifest.create();
			tmanifest2.addStringProperty("src", array[2]);
			tmanifest2.addStringProperty("id", "break");
			manifest.push(tmanifest2);	
			
			Manifest tmanifest3=Manifest.create();
			tmanifest3.addStringProperty("src", array[3]);
			tmanifest3.addStringProperty("id", "laser");
			tmanifest3.addIntProperty("data", 6);			
			manifest.push(tmanifest3);	
			
			
			Manifest tmanifest4=Manifest.create();
			tmanifest4.addStringProperty("src", array[4]);
			tmanifest4.addStringProperty("id", "music");
			manifest.push(tmanifest4);		
			
			preload= PreloadJS.createPreloadJs();
			CallBackEvent callBack = new CallBackEvent() {
				
				@Override
				public void onSuccess(Event event) {

					SoundNative.clearInterval(SoundNative.getInterval());
					scoreField = Text.create("0", "bold 12px Arial", "#FFFFFF");
					scoreField.setTextAlign("right");
					scoreField.setX(canvaswidth-10);
					scoreField.setY(22);
					scoreField.setMaxWidth(1000);
					
					messageField.setText("Welcome:  Click to play");
					SoundJS.play("music", SoundJS.interruptnone(), 0, 0, -1, 0.4);
					
					watchRestart();
				}
			};
			preload.onComplete(callBack);
			preload.installPlugin(SoundJS.plugin());
			preload.loadManifest(manifest);
			
			createJSObject = new CreateJSObject(""+canvaswidth, ""+canvasheight);
			stage = createJSObject.getStage();
			canvas = createJSObject.getCanvas();
			
			panel.add(createJSObject);
			
			messageField = Text.create("Loading", "bold 24px Arial", "#FFFFFF");
			messageField.setMaxWidth(1000);
			messageField.setTextAlign("center");
			messageField.setX(canvaswidth/2);
			messageField.setY(canvasheight/2);
			
			stage.addChild(messageField);
			stage.update();
			
			CallBack cb = new CallBack() {
				
				@Override
				public void onSuccess() {
					messageField.setText("Loading " + (preload.getProgress()*100) + "%");
					stage.update();
					
				}
			};
			
			SoundNative.setInterval(cb, 200);
			loadingInterval = SoundNative.getInterval();
		}
	}
	
	private void restart(){
		stage.removeAllChildren();
		scoreField.setText("0");
		stage.addChild(scoreField);
		
		rockBelt = new ArrayList<SpaceRock>();
		bulletStream = (JsArray<Shape>)JavaScriptObject.createArray();
		
		alive = true;
		
		ship = new Ship(createJSObject);
		ship.getShip().setX(canvaswidth/2);
		ship.getShip().setY(canvasheight/2);
		
		timeToRock = ROCK_TIME;
		nextRock = nextBullet = 0;
		
		shootHeld =false;
		lfHeld = false;
		rtHeld = false;
		fwdHeld = false;
		dnHeld = false;
		
		stage.clear();
		stage.addChild(ship.getShip());
		
		CallBack back = new CallBack() {
			
			@Override
			public void onSuccess() {
				
				if(nextBullet <= 0) {
					if(alive && shootHeld){
						nextBullet = BULLET_TIME;
						fireBullet();
					}
				} else {
					nextBullet--;
				}
				
				if(alive && lfHeld){
					ship.getShip().setRotation(ship.getShip().getRotation() - TURN_FACTOR) ;
				} else if(alive && rtHeld) {
					ship.getShip().setRotation(ship.getShip().getRotation() + TURN_FACTOR);
				}

				//handle thrust
				if(alive && fwdHeld){
					ship.accelerate();
				}
				
				if(nextRock <= 0){
					if(alive){
						timeToRock -= DIFFICULTY;
						int index = getSpaceRock(SpaceRock.LRG_ROCK);
						rockBelt.get(index).floatOnScreen(canvaswidth, canvasheight);
						nextRock = timeToRock + (timeToRock * Math.random());
					}
				}else{
					nextRock--;
				}
				
				if(alive && outOfBounds(ship.getShip(), ship.getBounds()) ){
					placeInBounds(ship.getShip(), ship.getBounds());
				}
				
				for(int i =0 ; i<bulletStream.length();i++){
					Shape o = bulletStream.get(i);
					if(o==null || o.getBooleanProperty("active") ==false ){
						continue;
					}
					if(outOfBounds(o, ship.bounds)){
						placeInBounds(o, ship.getBounds());
					}
					o.setX(o.getX()+Math.sin(o.getRotation()*(Math.PI/-180))*BULLET_SPEED);
					o.setY(o.getY()+Math.cos(o.getRotation()*(Math.PI/-180))*BULLET_SPEED);
					
					if(o.getIntProperty("entropy") <= 0){
						stage.removeChild(o);
						o.addBooleanProperty("active", false);
					}
					o.addIntProperty("entropy", o.getIntProperty("entropy"));
				}
				
				for(int i =0;i<rockBelt.size();i++){
					SpaceRock o = rockBelt.get(i);
					if(o==null || o.getActive()==false){
						continue;
					}
					if(outOfBounds(o.getShape(), o.getBounds())){
						placeInBounds(o.getShape(), o.getBounds());
					}
					o.tick();
					if(alive && o.hitRadius(ship.getShip().getX(), ship.getShip().getY(), ship.getHit())){
						alive = false;
						stage.removeChild(ship.getShip());
						messageField.setText("You're dead:  Click or hit enter to play again");
						stage.addChild(messageField);
						watchRestart();
						SoundJS.play("death",SoundJS.interruptany());
						continue;
					}
					
					for(int j=0;j<bulletStream.length();j++){
						Shape p = bulletStream.get(j);
						if(p==null || p.getBooleanProperty("active")==false){
							continue;
						}	
						if(o.hitPoint(p.getX(), p.getY())){
							int newsize = 0;
							switch(o.getSize()){
								case 40:
									newsize=SpaceRock.MED_ROCK;break;
								case 20:
									newsize=SpaceRock.SML_ROCK;break;
								case 10:
									newsize=0;break;
									
							}
							
							if(alive){
								addScore(o.getScore());
							}
							if(newsize > 0){
								int k =0, index = 0;
								double offset =0;
								for(k=0; k < SUB_ROCK_COUNT; k++){
									index = getSpaceRock(newsize);
									offset = (Math.random() * o.getSize()*2) - o.getSize();
									rockBelt.get(index).getShape().setX( o.getShape().getX() + offset);
									rockBelt.get(index).getShape().setY(o.getShape().getY()+ offset);
								}

							}
							stage.removeChild(o.getShape());
							rockBelt.get(i).setActive(false);

							stage.removeChild(p);
							bulletStream.get(j).addBooleanProperty("active",false);

							SoundJS.play("break", SoundJS.interruptlate(), 0, 0.8);
							
						}
					}
				}
				ship.doTick();
				stage.update();
			}
		};
		dotick(back);
		Ticker.addListener(getWindow());
		
		RootPanel.get().addDomHandler(new KeyDownHandler() {
			
			@Override
			public void onKeyDown(KeyDownEvent event) {
				switch(event.getNativeKeyCode()){
				case 32:shootHeld = true; return;
				case 65:
				case 37:lfHeld=true; return;
				case 68:
				case 39:rtHeld=true;return;
				case 87:
				case 38:fwdHeld=true;return;
				case 13:
				}
			}
		},KeyDownEvent.getType());
		
		RootPanel.get().addDomHandler(new KeyUpHandler() {
			
			@Override
			public void onKeyUp(KeyUpEvent event) {
				switch(event.getNativeKeyCode()){
				case 32:shootHeld = false; return;
				case 65:
				case 37:lfHeld=false; return;
				case 68:
				case 39:rtHeld=false;return;
				case 87:
				case 38:fwdHeld=true;return;
				}
			}
		},KeyUpEvent.getType());		
	}
	
	
	private void addScore(int value) {
		scoreField.setText( ""+(Integer.parseInt(scoreField.getText()) +value));
	}

	
	private boolean outOfBounds(DisplayObject o,double bounds){
		double x = o.getX();
		double y = o.getY();
		return ( x< bounds*-2 || y < bounds*-2 || x > (canvaswidth+bounds*2) || (y > canvasheight+bounds*2));
	}
	
	private void placeInBounds(DisplayObject o,double bounds){
		double x = o.getX();
		double y = o.getY();
		if(x > canvaswidth+bounds*2) {
			o.setX(bounds*-2);
		} else if(x < bounds*-2) {
			o.setX(canvaswidth+bounds*2);
		}

		if(y> canvasheight+bounds*2) {
			o.setY(bounds*-2);
		} else if(y < bounds*-2) {
			o.setY(canvasheight+bounds*2);
		}		
	}
	
	private void watchRestart(){
		stage.addChild(messageField);
		stage.update();
		CallBackEvent backEvent = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
				canvas.onclick(null);
				stage.removeChild(messageField);
				SoundJS.play("begin");
				restart();
			}
		};
		canvas.onclick(backEvent);
	}
	
	public int getSpaceRock(int size) {
		int i = 0;
		int len = rockBelt.size();

		//pooling approach
		while(i <= len){
			if(rockBelt.size() <=i) {
				rockBelt.add(new SpaceRock(size,createJSObject));
				break;
			} else if(rockBelt.get(i).getActive()==false) {
				rockBelt.get(i).activate(size,createJSObject);
				break;
			} else {
				i++;
			}
		}

		if(len == 0) {
			rockBelt.set(0, new SpaceRock(size,createJSObject));
		}

		stage.addChild(rockBelt.get(i).getShape());
		return i;
	}	
	
	public int getBullet(){
		int i = 0;
		int len = bulletStream.length();

		//pooling approach
		while(i <= len){
			if(bulletStream.get(i)==null) {
				bulletStream.set(i, Shape.createShape());
				break;
			} else if(bulletStream.get(i).getBooleanProperty("active") ==false) {
				bulletStream.get(i).addBooleanProperty("active", true);
				break;
			} else {
				i++;
			}
		}

		if(len == 0) {
			bulletStream.set(0, Shape.createShape());
		}

		stage.addChild(bulletStream.get(i));
		return i;		
	}
	
	public void fireBullet(){
		Shape o = bulletStream.get(getBullet());
		o.setX(ship.getShip().getX());
		o.setY(ship.getShip().getY());
		o.setRotation(ship.getShip().getRotation());
		o.addIntProperty("entropy", BULLET_ENTROPY);
		o.addBooleanProperty("active", true);
		Graphics graphics = o.getGraphics();
		if(graphics==null)
			graphics = createJSObject.Graphics();
		
		o.setGraphics(graphics.beginStroke("#FFFFFF").moveTo(-1, 0).lineTo(1, 0));
		SoundJS.play("laser",SoundJS.interruptlate());
	}
	
	
	private static native JavaScriptObject getWindow()/*-{
		return $wnd;
	}-*/;
	
	private static native void dotick(CallBack callBack) /*-{
		$wnd.tick=function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
	}}-*/; 	

}
