package com.easeljs.html5.client.easeljs;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.Animation;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.Canvas;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.Image;
import com.sinewavemultimedia.easeljs.framework.js.Manifest;
import com.sinewavemultimedia.easeljs.framework.js.SpriteFrame;
import com.sinewavemultimedia.easeljs.framework.js.SpriteSheetObject;
import com.sinewavemultimedia.easeljs.framework.js.display.BitmapAnimation;
import com.sinewavemultimedia.easeljs.framework.js.display.Graphics;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.SpriteSheet;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.preload.PreloadJS;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class SpriteSheetDemo implements IEasel {

	CreateJSObject createJSObject = null;
	int canvaswidth = 960;
	int canvasheight = 400;
	Stage stage =null;
	Canvas canvas = null;
	
	double runningRate = 0 , stationaryPosition=0;
	boolean isInWarp = false, isStationary= false, isPassed =false;
	SpriteSheet ss = null;
	BitmapAnimation grant = null;
	
	PreloadJS loader = null;
	JsArray<Event> assets = (JsArray<Event>)JavaScriptObject.createArray();
	
	int w = 0, h=0;
	
	Shape sky = null , ground = null , hill = null , hill2=null;
	@Override
	public void load(VerticalPanel panel) {
		createJSObject = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage = createJSObject.getStage();
		canvas = createJSObject.getCanvas();

		runningRate = 2.5;
		isInWarp = false;
		isStationary = false;
		stationaryPosition = 300;
		isPassed = false;

		panel.add(createJSObject);
		
		Animation animations =Animation.create();
		JsArrayMixed run =(JsArrayMixed)JavaScriptObject.createArray();
		run.push(0);
		run.push(25);
		animations.run(run);
		
		JsArrayMixed jump=(JsArrayMixed)JavaScriptObject.createArray();
		jump.push(26);
		jump.push(63);
		animations.jump(jump);
		
		SpriteSheetObject sheetObject=SpriteSheetObject.create();
		JsArray<Image> image = (JsArray<Image>)JavaScriptObject.createArray();
		Image img = Image.create();
		img.setSrc("../resources/images/runningGrant.png");
		image.push(img);
		sheetObject.addImage(image);
		sheetObject.addAnimations(animations);
		
		SpriteFrame frame = SpriteFrame.create();
		frame.setRegX(0);
		frame.setFrameHeight(292.5);
		frame.setNumFrames(64);
		frame.setRegY(0);
		frame.setFrameWidth(165.75);
		
		sheetObject.addFrame(frame);
		
		ss = SpriteSheet.create(sheetObject);
		grant = BitmapAnimation.create(ss);
		ss.getAnimation("run").setNext("run");
		ss.getAnimation("jump").setNext("run");
		
		grant.gotoAndPlay("run");
		
		grant.setX(-200);
		grant.setY(90);
		grant.setScaleX(0.8);
		grant.setScaleY(0.8);
		
		w = canvaswidth;
		h = canvasheight;
		
		JsArray<Manifest> manifest = (JsArray<Manifest>)JavaScriptObject.createArray();
		
		Manifest runningGrant=Manifest.create();
		runningGrant.addStringProperty("src", "../resources/images/runningGrant.png");
		runningGrant.addStringProperty("id", "grant");
		manifest.push(runningGrant);
		
		Manifest skyt=Manifest.create();
		skyt.addStringProperty("src", "../resources/images/sky.png");
		skyt.addStringProperty("id", "sky");
		manifest.push(skyt);
		
		Manifest groundt=Manifest.create();
		groundt.addStringProperty("src", "../resources/images/ground.png");
		groundt.addStringProperty("id", "ground");
		manifest.push(groundt);
		
		Manifest hillt=Manifest.create();
		hillt.addStringProperty("src", "../resources/images/parallaxHill1.png");
		hillt.addStringProperty("id", "hill");
		manifest.push(hillt);
		
		Manifest hill2t=Manifest.create();
		hill2t.addStringProperty("src", "../resources/images/parallaxHill2.png");
		hill2t.addStringProperty("id", "hill2");
		manifest.push(hill2t);
		
		loader = PreloadJS.createPreloadJs();
		loader.setUseXHR(false);
		CallBackEvent backEvent = new CallBackEvent() {
			@Override
			public void onSuccess(Event event) {
				assets.push(event);
			}
		};
		loader.onFileLoad(backEvent);
		CallBackEvent completeEvent = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
				
				for(int i =0;i<assets.length();i++){
					Event item = assets.get(i);
					String id = item.getId();
					JavaScriptObject result = item.getResult();
					
					if(id.equals("sky")){
						sky = Shape.createShape(createJSObject.Graphics().beginBitmapFill(result).drawRect(0,0,w,h));
					}
					else if(id.equals("ground")){
						ground = Shape.createShape();
						Graphics g =createJSObject.Graphics().beginBitmapFill(result).drawRect(0, 0, w+330, 79);
						ground.setGraphics(g);
						ground.setY(h-79);
					}
					else if(id.equals("hill")){
						hill = Shape.createShape(createJSObject.Graphics().beginBitmapFill(result).drawRect(0,0,282,59));
						hill.setX(Math.random() * w);
						hill.setScaleX(3);
						hill.setScaleY(3);
						hill.setY(144);
					}
					else if(id.equals("hill2")){
						hill2 = Shape.createShape(createJSObject.Graphics().beginBitmapFill(result).drawRect(0,0,212,50));
						hill2.setX(Math.random() * w);
						hill2.setScaleX(3);
						hill2.setScaleY(3);
						hill2.setY(171);
					}
				}
				if(grant==null){
					return;
				}
				stage.addChild(sky);
				stage.addChild(ground);
				stage.addChild(hill);
				stage.addChild(hill2);
				stage.addChild(grant);
				CallBackEvent mouseBackEvent = new CallBackEvent() {
					
					@Override
					public void onSuccess(Event event) {
						grant.gotoAndPlay("jump");
					}
				};
				stage.onMouseDown(mouseBackEvent);
				
				Ticker.setFPS(40);
				Ticker.addListener(getWindow());
			}
		};
		loader.onComplete(completeEvent);
		loader.loadManifest(manifest);
		
		stage.setAutoClear(false);
		CallBack tick = new CallBack() {			
			@Override
			public void onSuccess() {
				double outside= w +20;
				double position = grant.getX()+runningRate;
				double x = (position >= outside) ? -200 : position;
				grant.setX(x);
				ground.setX((ground.getX()-15)%330);
				hill.setX(hill.getX()-0.8);
				if ((hill.getX() + 838) <= 0) {
					hill.setX(outside); 
				}
				hill2.setX(hill2.getX()-1.2);
				if( (hill2.getX()+663) <=0 ){
					hill2.setX(outside);
				}
				stage.update();
			}
		};
		dotick(tick);
	}

	private static native JavaScriptObject getWindow()/*-{
		return $wnd;
	}-*/;
	
	private static native void dotick(CallBack callBack) /*-{
		$wnd.tick=function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
	}}-*/; 	

}
