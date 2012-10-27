package com.easeljs.html5.client.easeljs;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.Canvas;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.Image;
import com.sinewavemultimedia.easeljs.framework.js.SpriteFrame;
import com.sinewavemultimedia.easeljs.framework.js.SpriteSheetObject;
import com.sinewavemultimedia.easeljs.framework.js.display.BitmapAnimation;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.SpriteSheet;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.display.Text;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class SparklesFade implements IEasel {
	
	CreateJSObject createJSObject=null;
	Stage stage=null;
	Canvas canvas=null;
	int canvaswidth = 960;
	int canvasheight = 400;

	Text fpsLabel = null;
	BitmapAnimation bmpAnim = null;
	
	Image imgSeq = null;
	
	@Override
	public void load(VerticalPanel panel) {
		createJSObject = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage = createJSObject.getStage();
		canvas = createJSObject.getCanvas();
		
		panel.add(createJSObject);
	
		CallBackEvent event = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
				
					CallBackEvent mouseMove = new CallBackEvent() {
						
						@Override
						public void onSuccess(Event event) {
	
							addSparkles((int)(Math.random()*2+1), stage.getMouseX(), stage.getMouseY(),1);
						}
					};
					
					stage.onMouseMove(mouseMove);
					
					CallBackEvent mouseDown = new CallBackEvent() {
						
						@Override
						public void onSuccess(Event event) {
							addSparkles(((int)(Math.random()*200))+100, stage.getMouseX(), stage.getMouseY(),2);				
						}
					};
					
					stage.onMouseDown(mouseDown);

					Shape shape = Shape.createShape(createJSObject.Graphics().beginFill("#333").drawRect(0,0,canvaswidth+1,canvasheight));
					shape.setAlpha(0.35);
					stage.addChild(shape);
					
					stage.setAutoClear(false);
					
					JsArrayString arrayString = (JsArrayString)JavaScriptObject.createArray();
					arrayString.push("../resources/images/sparkle_21x23.png");
					SpriteSheetObject object = SpriteSheetObject.create();
					object.addImage(arrayString);
					
					SpriteFrame spriteFrame= SpriteFrame.create();
					spriteFrame.setFrameWidth(21);
					spriteFrame.setFrameHeight(23);
					spriteFrame.setRegX(10);
					spriteFrame.setRegY(11);
					object.addFrame(spriteFrame);
					
					SpriteSheet spr=SpriteSheet.create(object);
					
					bmpAnim = BitmapAnimation.create(spr);
					
					
					CallBack callBack = new CallBack() {
						@Override
						public void onSuccess() {
							int h = canvasheight;
							int w = canvaswidth;
							
							int l = stage.getNumChildren();
							for (int i=l-1; i>0; i--) {
								BitmapAnimation sparkle = (BitmapAnimation)stage.getChildAt(i);
	
								sparkle.addDoubleProperty("vY", sparkle.getDoubleProperty("vY")+2); 
								sparkle.addDoubleProperty("vX", sparkle.getDoubleProperty("vX")*0.98); 
	
								sparkle.setX(sparkle.getX()+sparkle.getDoubleProperty("vX"));
								sparkle.setY(sparkle.getY()+sparkle.getDoubleProperty("vY"));
								double dVal = sparkle.getScaleX()+sparkle.getDoubleProperty("vS");
								sparkle.setScaleX(dVal);
								sparkle.setScaleY(dVal);
								sparkle.setAlpha(sparkle.getAlpha()+sparkle.getDoubleProperty("vA"));
	
								if (sparkle.getAlpha() <= 0 || sparkle.getY() > canvasheight) {
									stage.removeChildAt(i);
								}
								if(sparkle.getY() > h){
									sparkle.addDoubleProperty("vY", sparkle.getDoubleProperty("vY")*(-(Math.random()*0.4+0.4)));
									sparkle.setY(sparkle.getY()- (sparkle.getY()%h));
								}
								if(sparkle.getX()>=w || sparkle.getX()<=0)
									sparkle.addDoubleProperty("vX", sparkle.getDoubleProperty("vX")*-1);
							}
	
							stage.update();				
							
						}
					};
					
					dotick(callBack);
					
					Ticker.setFPS(20);
					Ticker.addListener(getWindow());				
			}
		};
		
		imgSeq = Image.create();
		imgSeq.setSrc("../resources/images/sparkle_21x23.png");
		imgSeq.onLoad(event);	
		
	}

	
	private void addSparkles(int count,double x , double y ,int speed){
		for(int i=0;i<count;i++){
			BitmapAnimation sparkle= bmpAnim.BmAclone();
			sparkle.setX(x);
			sparkle.setY(y);
			sparkle.setAlpha(Math.random()*0.5+0.5);
			double ranVal = Math.random()+0.3;
			sparkle.setScaleX(ranVal);
			sparkle.setScaleY(ranVal);
			
			double a = Math.PI*2*Math.random();
			double v = (Math.random()-0.5)*30*speed;
			sparkle.addDoubleProperty("vX", Math.cos(a)*v);
			sparkle.addDoubleProperty("vY", Math.sin(a)*v);
			sparkle.addDoubleProperty("vS", (Math.random()-0.5)*0.2);
			sparkle.addDoubleProperty("vA", (-Math.random()*0.05)-0.01);
			sparkle.gotoAndPlay((int)(Math.random()*sparkle.getSpriteSheet().getNumFrames()));
			stage.addChild(sparkle);
		}
	}
	
	private static native JavaScriptObject getWindow()/*-{
		return $wnd;
	}-*/;
	
	private static native void dotick(CallBack callBack) /*-{
		$wnd.tick=function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
	}}-*/; 	
	
	
	
}
