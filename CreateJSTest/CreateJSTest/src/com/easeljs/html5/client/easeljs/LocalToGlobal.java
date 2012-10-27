package com.easeljs.html5.client.easeljs;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.Canvas;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.display.Container;
import com.sinewavemultimedia.easeljs.framework.js.display.Graphics;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.geom.Point;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class LocalToGlobal implements IEasel {

	int canvaswidth = 960;
	int canvasheight = 400;
	Stage stage =null;
	Canvas canvas = null;
	CreateJSObject createJSObject = null;
	Shape bar1 = null , bar2 = null , bar3 = null;
	
	Container arm1 = null , arm2 = null;

	@Override
	public void load(final VerticalPanel panel) {
		createJSObject  = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage = createJSObject.getStage();
		canvas = createJSObject.getCanvas();

		panel.add(createJSObject);
		final Button whee = new Button("wheeeeee!");
		panel.add(whee);
		
		CallBack backEvent = new CallBack() {
			
			@Override
			public void onSuccess() {
				double arm1rot = arm1.getRotation()+1.9;
				arm1.setRotation(arm1rot);
				double arm2rot = arm2.getRotation()-2.7;
				arm2.setRotation(arm2rot);
				double bar3rot= bar3.getRotation()+4.4;
				bar3.setRotation(bar3rot);
				
				Point pt = bar3.localToGlobal(0, 130);
				double x = pt.getX();
				double y = pt.getY();
				double canleft=canvas.getOffsetLeft()-10;
				double cantop =canvas.getOffsetTop()-10+136;
				double styleLeft = Math.round(x+canleft);
				double styleTop = Math.round(y+cantop);
				DOM.setStyleAttribute(whee.getElement(), "left", styleLeft+"px");
				DOM.setStyleAttribute(whee.getElement(), "position", "absolute");
				DOM.setStyleAttribute(whee.getElement(), "top", styleTop+"px");
				
				stage.update();
			}
		};
		
		dotick(backEvent);
		
		bar3 = Shape.createShape();
		Graphics g= createJSObject.Graphics();
		bar3.setGraphics(g.beginFill("#8B2222").drawRect(-3,-3,6,130));
		bar3.setRegY(20);
		bar3.setY(105);
		
		bar2 = Shape.createShape();
		bar2.setGraphics(createJSObject.Graphics().beginFill("#228B22").drawRect(-5,-5,10,110));
		
		arm2 = Container.createContainer();
		arm2.addChild(bar2);
		arm2.addChild(bar3);
		arm2.setRegY(20);
		arm2.setY(72);
		
		bar1 = Shape.createShape();
		bar1.setGraphics(createJSObject.Graphics().beginFill("#22228B").drawRect(-8,-8,16,80));
		
		arm1 = Container.createContainer();
		arm1.addChild(bar1);
		arm1.addChild(arm2);
		
		arm1.setX(canvaswidth/2);
		arm1.setY(canvasheight/2);
		stage.addChild(arm1);
		
		Ticker.setInterval(20);
		Ticker.addListener(getWindow());
		
		
		
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
