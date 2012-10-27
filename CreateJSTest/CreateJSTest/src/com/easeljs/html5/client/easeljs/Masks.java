package com.easeljs.html5.client.easeljs;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.Canvas;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.Image;
import com.sinewavemultimedia.easeljs.framework.js.display.Bitmap;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.filters.BoxBlurFilter;
import com.sinewavemultimedia.easeljs.framework.js.filters.ColorMatrix;
import com.sinewavemultimedia.easeljs.framework.js.filters.ColorMatrixFilter;
import com.sinewavemultimedia.easeljs.framework.js.filters.Filter;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class Masks implements IEasel {

	int canvaswidth = 960;
	int canvasheight = 400;
	Image img;
	Shape star = null;
	Stage stage = null;
	CreateJSObject createJSObject = null;
	Canvas canvas = null;
	@Override
	public void load(final VerticalPanel panel) {
		createJSObject = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		panel.add(createJSObject);

		CallBack back= new CallBack() {
			
			@Override
			public void onSuccess() {
				star.setRotation(star.getRotation()+5);
				stage.update();
				
			}
		};
		dotick(back);
		CallBackEvent backEvent = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
				stage = createJSObject.getStage();
				canvas = createJSObject.getCanvas();
				star = Shape.createShape();
				
				star.setX(img.getWidth()/2);
				star.setY(img.getHeight()/2);
				
				star.setGraphics(createJSObject.Graphics().beginStroke("#FF0").setStrokeStyle(5).drawPolyStar(0,0,img.getHeight()/2-15,5,0.6).closePath());
				
				Bitmap bg = Bitmap.create(img);
				BoxBlurFilter blurFilter = BoxBlurFilter.create(2,2,2);
				ColorMatrix matrix = ColorMatrix.create(0,0,-100,0);
				ColorMatrixFilter colorMatrixFilter = ColorMatrixFilter.create(matrix);
				bg.setFilters(new Filter[]{blurFilter,colorMatrixFilter});
				bg.cache(0,0,img.getWidth(),img.getHeight());
				stage.addChild(bg);
				
				Bitmap bmp = Bitmap.create(img);
				stage.addChild(bmp);
				bmp.setMask(star);
				
				stage.addChild(star);
				
				Ticker.addListener(getWindow());
			}
		};
	
		img = Image.create();
		img.setSrc("../resources/images/photo.jpg");
		img.onLoad(backEvent);
	}
	
	private static native JavaScriptObject getWindow()/*-{
		return $wnd;
	}-*/;

	private static native void dotick(CallBack callBack) /*-{
		$wnd.tick=function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
	}}-*/; 	

	
}
