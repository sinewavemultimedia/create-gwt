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
public class GlobalToLocalA implements IEasel {

	Canvas canvas = null;
	Stage stage	=	null; 
	int canvaswidth = 960;
	int canvasheight = 400;
	Graphics graphics = null;
	Container spin1 = null ,spin2 = null;
	Shape shape = null;
	
	int _mouseX,_mouseY , count=0; 
	boolean _mouseIsDown = false;
	
	Text text = null;
	
	Point lastPt = null; 
	
	int canvasoffsettop = 100;
	
	
	@Override
	public void load(final VerticalPanel panel) {
		CreateJSObject createJSObject  = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage	= createJSObject.getStage();
		canvas  = createJSObject.getCanvas();
		
		CallBack back = new CallBack() {
			
			@Override
			public void onSuccess() {
				spin1.setRotation(spin1.getRotation()+10);
				spin2.setRotation(spin2.getRotation()-7);
				shape.setRotation(shape.getRotation()+3);
				
				if(_mouseIsDown){
					String color = Graphics.getHSL(Math.cos((count++)*0.01) * 180, 100, 50,1.0);
					graphics =shape.getGraphics();
					graphics.setStrokeStyle(Math.random()*20+2,"round").beginStroke(color);
					
					double lstx = lastPt.getX();
					double lsty = lastPt.getY();

					// start the line at the last position:
					graphics.moveTo(lstx,lsty);

					// calculate the new position in the shape's local coordinate space:
					lastPt = shape.globalToLocal(_mouseX,_mouseY);

					// draw the line, and close the path:
					graphics.lineTo(lastPt.getX(),lastPt.getY());
					shape.setGraphics(graphics);
				}
				

				shape.cache(-800,-800,1600,1600);
				stage.update();
			}
		};
		
		dotick(back);		
		
		CallBackEvent mouseMove = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
				_mouseX= (int)event.getPageX()-0;
				_mouseY= (int)event.getPageY()-canvasoffsettop;
				
			}
		};
		
		CallBackEvent mouseDown = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
				stage.removeChild(text);
				_mouseIsDown = true;
				double pagex =event.getPageX();
				double pagey = event.getPageY();
				double canvasx = 0;
				double canvasy = canvasoffsettop;
				double x =pagex-canvasx;
				double y = pagey-canvasy;
				lastPt= shape.globalToLocal(x, y);
				
				double lpx = lastPt.getX();
				double lpy = lastPt.getY();
				stage.uncache();
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

		// shape to draw vector data into:
		shape = Shape.createShape();
		shape.setGraphics(createJSObject.Graphics());
		shape.setX(41);		//position in parent container
		graphics = shape.getGraphics();

		// middle spinner:
		spin2 =Container.createContainer();
		spin2.addChild(shape);
		spin2.setX(303);		//position in parent container

		// outside spinner:
		spin1 = Container.createContainer();
		spin1.addChild(spin2);

		// center it on the stage:
		spin1.setX(canvaswidth/2);
		spin1.setY(canvasheight/2);
		stage.addChild(spin1);

		// start the tick and point it at the window so we can do some work before updating the stage:
		Ticker.setFPS(30);
		Ticker.addListener(getWindow());	
		
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
