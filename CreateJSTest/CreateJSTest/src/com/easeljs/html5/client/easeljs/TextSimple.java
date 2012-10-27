package com.easeljs.html5.client.easeljs;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.display.Text;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class TextSimple implements IEasel {

	CreateJSObject createJSObject = null;
	Stage stage = null;
	int canvaswidth = 960;
	int canvasheight = 400;
	Text txt;
	Shape shape;
	int count = 0;
	
	@Override
	public void load(VerticalPanel panel) {
		createJSObject = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage = createJSObject.getStage();
		
		txt = Text.create("text on the canvas... 0!", "36px Arial", "#FFF");
		txt.setX(100);
		txt.setY(80);
		txt.setRotation(20);
		//txt.outline = true;
		stage.addChild(txt);

		// this shape will be the background for the text:
		shape = Shape.createShape();
		shape.setX(txt.getX());
		shape.setY(txt.getY());
		shape.setRotation(txt.getRotation());
		stage.addChildAt(shape,0);

		CallBack back = new CallBack() {
			
			@Override
			public void onSuccess() {
				count++;

				// update the text:
				txt.setText("text on the canvas... "+count+"!");

				// draw a vector box of the appropriate width behind the text:
				shape.setGraphics(shape.getGraphics().clear().beginFill("#F00").drawRect(-10, -10, txt.getMeasuredWidth()+20, 36+20));

				// update the stage:
				stage.update();
				
			}
		};
		
		dotick(back);
		
		// we want to do some work before we update the canvas,
		// otherwise we could use Ticker.addListener(stage);
		Ticker.setFPS(100);
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
