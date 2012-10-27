package com.easeljs.html5.client.easeljs;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Graphics;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class CacheUpdate implements IEasel {

	int canvaswidth = 960;
	int canvasheight = 400;
	
	CreateJSObject createJSObject = null;

	Stage stage = null;
	Shape starfield =null, sky = null, moon = null;
	
	@Override
	public void load(VerticalPanel panel) {
		createJSObject =new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage = createJSObject.getStage();
		
		CallBack back = new CallBack() {
			
			@Override
			public void onSuccess() {
				starfield.setGraphics(starfield.getGraphics().beginFill(Graphics.getRGB(0xFFFFFF,Math.random())).drawPolyStar(Math.random()*canvaswidth, Math.random()*canvasheight, Math.random()*4+1, 5, 0.93, Math.random()*360));
				starfield.updateCache("source-overlay");
				
				starfield.getGraphics().clear();
				
				sky.setAlpha(sky.getAlpha()-0.0005);
				
				double w = canvaswidth +200;
				moon.setX( (moon.getX() + 100 + 1 + w) % w - 100 ) ;
				
				moon.setY( 250 - Math.sin(moon.getX()/w*Math.PI) * 150 );
				
				stage.update();
			}
		};
		
		dotick(back);
		
		sky = Shape.createShape();
		JsArrayString stringarray = (JsArrayString)JsArrayString.createArray();
		stringarray.push("#204");
		stringarray.push("#003");
		stringarray.push("#000");
		JsArrayNumber arrayNumber = (JsArrayNumber)JsArrayNumber.createArray();
		arrayNumber.push(0);
		arrayNumber.push(0.15);
		arrayNumber.push(0.6);
		sky.setGraphics(createJSObject.Graphics().beginLinearGradientFill(stringarray,arrayNumber,0,canvasheight,0,0));
		sky.setGraphics(sky.getGraphics().drawRect(0,0, canvaswidth, canvasheight));
		
		stage.addChild(sky);
	
		starfield = Shape.createShape();
		stage.addChild(starfield);
		starfield.cache(0, 0, canvaswidth, canvasheight);
		
		moon = Shape.createShape();
		moon.setGraphics(createJSObject.Graphics().beginFill("#CCF").drawCircle(0,0,60));
		moon.setGraphics(moon.getGraphics().beginFill("#000").drawEllipse(-35,-57,96,114));
		
		moon.setRotation(-30);
		
		stage.addChild(moon);
		
		panel.add(createJSObject);
		
		Ticker.setFPS(30);
		Ticker.addListener(getWindow(),true);	
	}
	
	private static native JavaScriptObject getWindow()/*-{
		return $wnd;
	}-*/;
	
	private static native void dotick(CallBack callBack) /*-{
		$wnd.tick=function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
		}
	}-*/; 	

}
