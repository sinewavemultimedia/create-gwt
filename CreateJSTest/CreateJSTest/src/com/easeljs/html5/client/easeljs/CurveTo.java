package com.easeljs.html5.client.easeljs;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.display.Graphics;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.display.Text;
import com.sinewavemultimedia.easeljs.framework.js.geom.Point;
import com.sinewavemultimedia.easeljs.framework.js.ui.Touch;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class CurveTo implements IEasel {

	int canvaswidth = 960;
	int canvasheight = 400;
	double oldMidX, oldMidY, oldX, oldY;
	
	CreateJSObject createJSObject = null;
	
	Stage stage = null;
	Shape currentShape = null;
	
	Text txt = null;
	
	boolean isMouseDown = false;
	
	@Override
	public void load(VerticalPanel panel) {
		createJSObject =new CreateJSObject(""+canvaswidth, ""+canvasheight);
		
		stage = createJSObject.getStage();
		
		CallBack back = new CallBack() {
			
			@Override
			public void onSuccess() {
				if(isMouseDown){
				
					Point pt = Point.create(stage.getMouseX(), stage.getMouseY());
					
					int pointx = (int)oldX+(int)pt.getX();
					pointx = pointx>> 1;
					int pointy = (int)oldY+(int)pt.getY();
					pointy = pointy>> 1;
					Point midPoint = Point.create(pointx, pointy);
					int midPointX= (int)midPoint.getX();
					int midPintY = (int)midPoint.getY();
					currentShape.setGraphics(currentShape.getGraphics().moveTo(midPointX, midPintY ));
					currentShape.setGraphics(currentShape.getGraphics().curveTo(oldX, oldY, oldMidX, oldMidY));
					
					
					
	                oldX = pt.getX();
	                oldY = pt.getY();

	                oldMidX = midPoint.getX();
	                oldMidY = midPoint.getY();

	                stage.update();
				}
			}
		};
		
		dotick(back);
		
		
		txt = Text.create("Click and Drag to Draw", "36px Arial", "#777777");
		txt.setX(300);
		txt.setY(200);
		
		stage.setAutoClear(true);
		
		CallBackEvent mouseDownCallBack = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
	            isMouseDown = true;
	            stage.removeChild(txt);

	            Shape s = Shape.createShape();
	            oldX = stage.getMouseX();
	            oldY = stage.getMouseY();
	            oldMidX = stage.getMouseX();
	            oldMidY = stage.getMouseY();
	            Graphics g = createJSObject.Graphics();
	            double thickness = Math.random() * 30 + 10;
	            g.setStrokeStyle(thickness + 1, "round", "round");
	            String color = createJSObject.Graphics().getRGB((int)(Math.random()*255),(int)(Math.random()*255) ,(int)(Math.random()*255) );
	            g.beginStroke(color);
	            s.setGraphics(g);
	            stage.addChild(s);
	            currentShape = s;
				
			}
		};
		
		stage.onMouseDown(mouseDownCallBack);
		
		CallBackEvent mouseUpCallBack = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
				isMouseDown = false;
				
			}
		};
		
		stage.onMouseUp(mouseUpCallBack);
		
		Touch.enable(stage);
		
		stage.addChild(txt);
		stage.update();
		
		panel.add(createJSObject);
		
		Ticker.addListener(getWindow(),true);
	}
	
	public final native JavaScriptObject getObject(CallBack callBack)/*-{
		return function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
		}
	}-*/;

	private static native JavaScriptObject getWindow()/*-{
		return $wnd;
	}-*/;
	
	private static native void dotick(CallBack callBack) /*-{
		$wnd.tick=function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
		}
	}-*/; 	

	
}
