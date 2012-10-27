package com.easeljs.html5.client.easeljs;

import com.google.gwt.core.client.JavaScriptObject;
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
import com.sinewavemultimedia.easeljs.framework.js.display.Text;
import com.sinewavemultimedia.easeljs.framework.js.geom.Point;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;


/*
* author: James Tyner 
*/
public class GlobalToLocalB implements IEasel {

	Canvas canvas = null;
	Stage stage	=	null; 
	int canvaswidth = 960;
	int canvasheight = 400;
	Graphics graphics = null;
	Container spin1 = null ,spin2 = null;
	Shape shape  = null, fade = null;
	
	int _mouseX,_mouseY , count=0; 
	boolean _mouseIsDown = false;
	
	Text text = null;
	
	Point lastPt = null; 
	
	double colorOffset =0;
	
	
	@Override
	public void load(final VerticalPanel panel) {
		CreateJSObject createJSObject  = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage	= createJSObject.getStage();
		stage.setAutoClear(false);
		canvas  = createJSObject.getCanvas();
		
		CallBack back = new CallBack() {
			
			@Override
			public void onSuccess() {
				spin1.setRotation(spin1.getRotation()+10.7);
				spin2.setRotation(spin2.getRotation()-7.113);
				shape.setRotation(shape.getRotation()+ 1.77);
				
				if(_mouseIsDown){
					String color = Graphics.getHSL(Math.cos((count++)*0.01) * 30 + colorOffset, 100, 50,0.8);
					graphics.setStrokeStyle(Math.random()*20+2,"round").beginStroke(color);

					// start the line at the last position:
					graphics.moveTo(0,0);

					// calculate the new position in the shape's local coordinate space:
					lastPt = shape.globalToLocal(_mouseX,_mouseY);

					// draw the line, and close the path:
					graphics.lineTo(lastPt.getX(),lastPt.getY());
					shape.cache(-800,-800,1600,1600);
					stage.update();
					graphics.clear();
				}

			}
		};
		
		dotick(back);		
		
		CallBackEvent mouseMove = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
				_mouseX= (int)event.getPageX()-canvas.getOffsetLeft();
				_mouseY= (int)event.getPageY()-canvas.getOffsetTop();
				
			}
		};
		
		CallBackEvent mouseDown = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
				stage.removeChild(text);
				_mouseIsDown = true;
				lastPt= shape.globalToLocal(event.getPageX()-canvas.getOffsetLeft(), event.getPageY()-canvas.getOffsetTop());
				
				colorOffset = Math.random()*360;
			}
		};
		
		CallBackEvent mouseUp = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
	
				_mouseIsDown = false;
				shape.cache(-800,-800,1600,1600);
				
			}
		};
		
		canvas.onmousemove(mouseMove);
		canvas.onmousedown(mouseDown);
		canvas.onmouseup(mouseUp);
		
		text =Text.create("Click and Drag", "36px Arial", "#777777");
		
		text.setX(360);
		text.setY(200);
		stage.addChild(text);
		
		fade = Shape.createShape();
		fade.setGraphics(createJSObject.Graphics().beginFill("#333333").drawRect(0,0,canvaswidth, canvasheight));
		fade.setAlpha(0.02);
		stage.addChild(fade);
		
		shape = Shape.createShape();
		shape.setGraphics(createJSObject.Graphics());
		shape.setY(276);	
		graphics = shape.getGraphics();

		// middle spinner:
		spin2 =Container.createContainer();
		spin2.addChild(shape);
		spin2.setX(391);		//position in parent container

		// outside spinner:
		spin1 = Container.createContainer();
		spin1.addChild(spin2);
		spin1.setX(canvaswidth/2);
		spin1.setY(canvasheight/2);
		stage.addChild(spin1);

		// start the tick and point it at the window so we can do some work before updating the stage:
		Ticker.setFPS(30);
		Ticker.addListener(getWindow(),true);	
		
		panel.add(createJSObject);
		
	}

	private static native JavaScriptObject getWindow()/*-{
		return $wnd;
	}-*/;
	
	private static native void dotick(CallBack callBack) /*-{
		$wnd.tick=function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
	}}-*/; 	
	
	
}
