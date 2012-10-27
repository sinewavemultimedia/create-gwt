package com.easeljs.html5.client.tweenjs;

import java.util.ArrayList;
import java.util.List;

import com.easeljs.html5.client.easeljs.IEasel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.CallBackTween;
import com.sinewavemultimedia.easeljs.framework.js.Canvas;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.display.Text;
import com.sinewavemultimedia.easeljs.framework.js.tween.Ease;
import com.sinewavemultimedia.easeljs.framework.js.tween.Property;
import com.sinewavemultimedia.easeljs.framework.js.tween.Tween;
import com.sinewavemultimedia.easeljs.framework.js.ui.Touch;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class TweenCircle implements IEasel {

	CreateJSObject createJSObject  = null;
	Canvas canvas = null;
	Stage stage	=	null; 
	int canvaswidth = 960;
	int canvasheight = 400;
	int circleCount = 25;
	int activeCount = 0;

	List<Property> tweens = new ArrayList<Property>();
	Text text = null;
	
	@Override
	public void load(VerticalPanel panel) {
		
		createJSObject  = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage	= createJSObject.getStage();
		canvas  = createJSObject.getCanvas();

		panel.add(createJSObject);
		stage.enableMouseOver(10);
		Touch.enable(stage);
		
        for (int i=0; i<circleCount; i++) {
            // draw the circle, and put it on stage:
            Shape circle = Shape.createShape();
            circle.setGraphics(createJSObject.Graphics().setStrokeStyle(15).beginStroke("#113355")
            		.drawCircle(0,0,(i+1)*4));
            circle.setAlpha( 1-i*0.02);
            circle.setX( Math.random()*550);
            circle.setY( Math.random()*400);
            circle.setCompositeOperation("lighter");

    		Property prps = Property.createProperty();
    		prps.addIntProperty("x",275);
    		prps.addIntProperty("y",200);

    		CallBackTween tweenComplete = new CallBackTween() {
				
				@Override
				public void onSuccess(Tween tween) {
					activeCount--;
					
				}
			};
            Tween tween = Tween.get(circle).to(prps, (0.5+i*0.04)*1500, Ease.bounceOut()).call(tweenComplete);
            Property pr = Property.createProperty();
            pr.addJavaScriptProperty("tween", tween);
            pr.addJavaScriptProperty("ref", circle);
            tweens.add(pr);
            stage.addChild(circle);
        }		
        
        activeCount = circleCount;
        CallBackEvent handleMouseUp = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
		        if (text!=null) {
		        	stage.removeChild(text);
		        	text = null;
		        }
	            for (int i=0; i<circleCount; i++) {
	                Shape ref = (Shape)tweens.get(i).getJavaScriptProperty("ref") ;
	                Tween tween = (Tween)tweens.get(i).getJavaScriptProperty("tween");
	        		Property prps = Property.createProperty();
	        		prps.addBooleanProperty("override",true);
	        		Property pp = Property.createProperty();
	        		pp.addDoubleProperty("x", stage.getMouseX());
	        		pp.addDoubleProperty("y", stage.getMouseY());
	        		CallBackTween tweenComplete = new CallBackTween() {
						
						@Override
						public void onSuccess(Tween tween) {
							activeCount--;
						}
					};
					Tween.get(ref,prps).to(pp, (0.5+i*0.04)*1500, Ease.bounceOut()).call(tweenComplete);
	            }
	            activeCount = circleCount;				
				
			}
		};
        stage.onMouseUp(handleMouseUp);

        text = Text.create("Click Anywhere to Tween", "36px Arial", "#777");
        text.setX( 350);
        text.setY( 200);
        stage.addChild(text);
        CallBack cb = new CallBack() {
			
			@Override
			public void onSuccess() {
				if (activeCount!=0) { stage.update(); }
			}
		};
        dotick(cb);
        
        Ticker.addListener(getWindow());
	}
	
	private static native JavaScriptObject getWindow()/*-{
		return $wnd;
	}-*/;
	
	private static native void dotick(CallBack callBack) /*-{
		$wnd.tick=function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
	}}-*/; 	
	

}
