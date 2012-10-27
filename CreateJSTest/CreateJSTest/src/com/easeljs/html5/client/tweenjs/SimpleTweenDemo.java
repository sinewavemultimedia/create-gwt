package com.easeljs.html5.client.tweenjs;

import com.easeljs.html5.client.easeljs.IEasel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CallBackTween;
import com.sinewavemultimedia.easeljs.framework.js.Canvas;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Graphics;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.tween.Ease;
import com.sinewavemultimedia.easeljs.framework.js.tween.Property;
import com.sinewavemultimedia.easeljs.framework.js.tween.Tween;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class SimpleTweenDemo implements IEasel{
	
	Canvas canvas = null;
	Stage stage	=	null; 
	int canvaswidth = 960;
	int canvasheight = 400;
	Graphics graphics = null;
	CreateJSObject createJSObject = null;

	@Override
	public void load(VerticalPanel panel) {
		createJSObject  = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage	= createJSObject.getStage();
		canvas  = createJSObject.getCanvas();	
		
		panel.add(createJSObject);
		stage.setAutoClear(true);
		
		Shape ball = Shape.createShape();
		ball.setGraphics(createJSObject.Graphics().setStrokeStyle(5, "round", "round").beginStroke("#000000").beginFill("#FF0000").drawCircle(0,0,50).endStroke().endFill().setStrokeStyle(1, "round", "round").beginStroke("#000000").moveTo(0,0).lineTo(0,50).endStroke());
		ball.setX(200);
		ball.setY(-50);
		
		Property prps = Property.createProperty();
		prps.addBooleanProperty("loop",true);
		
		Property pp = Property.createProperty();
		pp.addDoubleProperty("x", ball.getX());
		pp.addDoubleProperty("y", canvasheight-55);
		pp.addDoubleProperty("rotation", -360);
		
		Property pp1 = Property.createProperty();
		pp1.addDoubleProperty("x",canvaswidth-55);
		pp1.addDoubleProperty("rotation",360);
		CallBackTween callbackTween = new CallBackTween() {
			
			@Override
			public void onSuccess(Tween tween) {
				// TODO Auto-generated method stub
				
			}
		};
		Property pp2 = Property.createProperty();
		pp2.addDoubleProperty("scaleX",2);
		pp2.addDoubleProperty("scaleY",2);
		pp2.addDoubleProperty("x",canvaswidth-110);
		pp2.addDoubleProperty("y",canvasheight-110);
		
		Property pp3 = Property.createProperty();
		pp3.addDoubleProperty("scaleX",0.5);
		pp3.addDoubleProperty("scaleY",0.5);
		pp3.addDoubleProperty("x",30);
		pp3.addDoubleProperty("rotation",-360);
		pp3.addDoubleProperty("y",canvasheight-30);
		Tween tween = Tween.get(ball,prps).to(pp,1500,Ease.bounceInOut()).waitDuration(1000).to(pp1, 2500,Ease.bounceOut()).waitDuration(1000).call(callbackTween)
				.to(pp2,2500,Ease.backOut()).waitDuration(1000)
				.to(pp3,2500,Ease.bounceOut());
		
		CallBack clbk = new CallBack() {
			
			@Override
			public void onSuccess() {
				stage.update();
				
			}
		};
		dotick(clbk);
		stage.addChild(ball);
		
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
