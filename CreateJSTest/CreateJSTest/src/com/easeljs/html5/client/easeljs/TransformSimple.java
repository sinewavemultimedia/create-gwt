package com.easeljs.html5.client.easeljs;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.Image;
import com.sinewavemultimedia.easeljs.framework.js.display.Bitmap;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.display.Text;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class TransformSimple implements IEasel {

	CreateJSObject createJSObject = null;
	Stage stage = null;
	int canvaswidth = 960;
	int canvasheight = 400;
	Text txt;
	Shape shape;
	int count = 0;
	double angle = 0 ;
	Image img = null;
	Bitmap bmp = null;
	
	@Override
	public void load(VerticalPanel panel) {
		createJSObject = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage = createJSObject.getStage();
		panel.add(createJSObject);
		angle = 0;
		img = Image.create();
		CallBackEvent callBack = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
				stage.setAutoClear(true);
				bmp = Bitmap.create(img);
				int regX = img.getWidth() >> 1;
				int regY = img.getHeight() >> 1 ;
				bmp.setRegX(regX);
				bmp.setRegY(regY);
				
				int setXshift = (canvaswidth -(img.getWidth()/2))>>1;
				int setYShift = ((140+canvasheight-img.getHeight()/2)>>1);
	            bmp.setX(setXshift);
	            bmp.setY(setYShift);
	            bmp.setScaleX(0.1);
	            bmp.setScaleY(0.1);
	            stage.addChild(bmp);
	            stage.update();
	            
	            CallBack callback = new CallBack() {
					
					@Override
					public void onSuccess() {
						angle += 0.025;
						double value = (Math.sin(angle) * 360);
			            bmp.setTransform (bmp.getX(), bmp.getY() , bmp.getScaleX(), bmp.getScaleY(), value/2 , bmp.getSkewX() , bmp.getSkewY() , bmp.getRegX() , bmp.getRegY() );
			            bmp.setScaleX(( (value)/360) + 0.25);
			            bmp.setScaleY(((value)/360) + 0.25);
			            stage.update();
						
					}
				};
	            
	            dotick(callback);
	            
	            Ticker.addListener(getWindow());
				
			}
		};
		img.setSrc("../resources/images/rotateDemoBot.png");
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
