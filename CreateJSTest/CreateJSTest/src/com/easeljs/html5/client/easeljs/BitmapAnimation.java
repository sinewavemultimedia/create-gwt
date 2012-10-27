package com.easeljs.html5.client.easeljs;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.Animation;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CallBackBitMapAnimation;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.Image;
import com.sinewavemultimedia.easeljs.framework.js.SpriteFrame;
import com.sinewavemultimedia.easeljs.framework.js.SpriteSheetObject;
import com.sinewavemultimedia.easeljs.framework.js.display.SpriteSheet;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.utils.SpriteSheetUtils;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;
/*
* author: James Tyner 
*/
public class BitmapAnimation implements IEasel {

	int canvaswidth = 960;
	int canvasheight = 400;
	CreateJSObject createJSObject = null;
	Stage stage = null;
	Image img = null;
	JsArray<com.sinewavemultimedia.easeljs.framework.js.display.BitmapAnimation> bmpAnimList = null;
	@Override
	public void load(VerticalPanel panel) {
		createJSObject =new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage = createJSObject.getStage();
		
		panel.add(createJSObject);
		CallBackEvent callBack = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
				int w = canvaswidth;
				int h = canvasheight;
				Animation animations = Animation.create();
				JsArrayMixed walkUpRt = (JsArrayMixed)JavaScriptObject.createArray();
				walkUpRt.push(0);
				walkUpRt.push(19);
				walkUpRt.push("walkRt");
				animations.addMixedArrayProperty("walkUpRt", walkUpRt);
				
				JsArrayMixed walkDnRt = (JsArrayMixed)JavaScriptObject.createArray();
				walkDnRt.push(20);
				walkDnRt.push(39);
				walkDnRt.push("walkUpRt");
				animations.addMixedArrayProperty("walkDnRt", walkDnRt);
				
				JsArrayMixed walkRt = (JsArrayMixed)JavaScriptObject.createArray();
				walkRt.push(41);
				walkRt.push(59);
				walkRt.push("walkDnRt");
				animations.addMixedArrayProperty("walkRt", walkRt);				
				

				SpriteSheetObject object = SpriteSheetObject.create();
				
				JsArray<Image> images = (JsArray<Image>)JavaScriptObject.createArray();
				images.push(img);
				
				SpriteFrame frame = SpriteFrame.create();
				frame.setFrameWidth(64);
				frame.setFrameHeight(68);
				frame.setRegX(32);
				frame.setRegY(34);
				
				object.addImage(images);
				object.addFrame(frame);
				object.addAnimations(animations);
				
				SpriteSheet spriteSheet = SpriteSheet.create(object);
				SpriteSheetUtils.addFlippedFrames(spriteSheet, true, false, false);
				
				com.sinewavemultimedia.easeljs.framework.js.display.BitmapAnimation bmpAnim = com.sinewavemultimedia.easeljs.framework.js.display.BitmapAnimation.create(spriteSheet);
				bmpAnim.gotoAndPlay("walkRt");
				
				CallBackBitMapAnimation docallBack = new CallBackBitMapAnimation() {
					
					@Override
					public void onSuccess(com.sinewavemultimedia.easeljs.framework.js.display.BitmapAnimation bmpAnim, String animation) {
						bmpAnim.addDoubleProperty("direction", bmpAnim.getDoubleProperty("direction") -60);
						double direction = bmpAnim.getDoubleProperty("direction");
						double angle = direction * (Math.PI/180);
						double speed = bmpAnim.getDoubleProperty("speed");
						bmpAnim.addDoubleProperty("vX", Math.sin(angle) * speed );
						bmpAnim.addDoubleProperty("vY", Math.cos(angle) * speed );
						Map<String, String> nextMap = new HashMap<String, String>();
						nextMap.put("walkRt","walkDnRt");
						nextMap.put("walkDnRt","walkDnRt_h");
						nextMap.put("walkDnRt_h","walkRt_h");
						nextMap.put("walkRt_h","walkUpRt_h"); 
						nextMap.put("walkUpRt_h","walkUpRt");
						nextMap.put("walkUpRt","walkRt");
						bmpAnim.gotoAndPlay(nextMap.get(animation));
					}
				};
				
				bmpAnim.onAnimationEnd(docallBack );				
				
				int l =50;
				bmpAnimList = (JsArray<com.sinewavemultimedia.easeljs.framework.js.display.BitmapAnimation>) JavaScriptObject.createArray();
				for(int i=0;i<l;i++){
					bmpAnim.setName("rat"+i);
					bmpAnim.addDoubleProperty("speed", (Math.random()*6)+2);
					bmpAnim.addDoubleProperty("direction", 90);
					bmpAnim.addDoubleProperty("vX",bmpAnim.getDoubleProperty("speed"));
					bmpAnim.addDoubleProperty("vY",0);
					bmpAnim.setX((Math.random()*(w-220))+60);
					bmpAnim.setY((Math.random()*(h-220)));
					bmpAnim.setCurrentAnimationFrame(Math.random()*spriteSheet.getNumFrames("walkRt"));
					stage.addChild(bmpAnim);
					bmpAnimList.push(bmpAnim);
					if (i < l-1) { 
						bmpAnim = bmpAnim.BmAclone(); 
					}
				}
				
				CallBack callBack = new CallBack() {
					
					@Override
					public void onSuccess() {
						int l = bmpAnimList.length();
						for (int i=0; i<l; i++) {
							com.sinewavemultimedia.easeljs.framework.js.display.BitmapAnimation bmpAnim = (com.sinewavemultimedia.easeljs.framework.js.display.BitmapAnimation)bmpAnimList.get(i);
							double vx = bmpAnim.getDoubleProperty("vX");
							double vy = bmpAnim.getDoubleProperty("vY");
							double setx = bmpAnim.getX() + vx;
							double sety = bmpAnim.getY()+ vy;
							bmpAnim.setX(setx) ;
							bmpAnim.setY(sety);
						}

						stage.update();						
					}
				};
				
				dotick(callBack);
				
				Ticker.addListener(getWindow());

			
			}
		};
		
		img = Image.create();
		img.setSrc("../resources/images/testSeq.png");
		img.onLoad(callBack);

	}

	private static native JavaScriptObject getWindow()/*-{
		return $wnd;
	}-*/;
	
	private static native void dotick(CallBack callBack) /*-{
		$wnd.tick=function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
	}}-*/; 	
	
}
