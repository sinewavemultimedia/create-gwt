package com.easeljs.html5.client.easeljs;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.display.DisplayObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.display.Text;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;
/*
* author: James Tyner 
*/
public class Cache implements IEasel {

	int canvaswidth = 960;
	int canvasheight = 350;
	CreateJSObject createJSObject = null;
	int circleRadius=30 ,rings = 30;
	Stage stage = null;
	Shape shape = null;
	Text fpsLabel = null;
	
	@Override
	public void load(VerticalPanel panel) {
		createJSObject =new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage = createJSObject.getStage();
		
		CallBack callBack = new CallBack() {
			
			@Override
			public void onSuccess() {
				int w = canvaswidth;
				int h = canvasheight;
				int l = stage.getNumChildren()-1;
				
				for(int i=1; i< l; i++){
					Shape shape = (Shape)stage.getChildAt(i);
					double shapeX = shape.getX();
					double shapeY = shape.getY();
					double velX   = shape.getVelX();
					double velY   = shape.getVelY();
					shape.setX( (shapeX+velX+w) % w );
					shape.setY( (shapeY+velY+h) % h );
				}
				
				fpsLabel.setText(Math.round(Ticker.getMeasuredFPS())+" fps");
				
				stage.update();
			}
		};
		dotick(callBack);		
		
		String array[] =new String[]{"#828b20","#b0ac31","#cbc53d","#fad779","#f9e4ad","#faf2db","#563512","#9b4a0b","#d36600","#fe8a00","#f9a71f"};
		
		
		for(int i=0;i<200;i++){
			shape = Shape.createShape();
			for(int j=rings;j>0;j--){
				int location = (int)( ((float)Math.random())*array.length);
				if(j==rings)
					shape.setGraphics(createJSObject.Graphics().beginFill(array[location]).drawCircle(0, 0, circleRadius * j /rings));
				else
					shape.setGraphics(shape.getGraphics().beginFill(array[location]).drawCircle(0, 0, circleRadius * j /rings));
			}
			shape.setX(Math.random()* canvaswidth);
			shape.setY(Math.random()*canvaswidth );
			shape.setVelX( (Math.random()*10)-5);
			shape.setVelY( (Math.random()*10)-5);
			shape.setSnapToPixel(true);
			
			stage.addChild(shape);
			

		}
		
		fpsLabel = Text.create("-- fps","bold 18px Arial","#FFF");
		stage.addChild(fpsLabel);
		fpsLabel.setX(10);
		fpsLabel.setY(20);
		
		Ticker.setFPS(50);
		Ticker.addListener(getWindow(),true);			
		final CheckBox box = new CheckBox();
		box.setText("Cache enabled");
		box.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				toggleCache(box.getValue());
				
			}
		});

		final CheckBox box1 = new CheckBox();
		box1.setText("snapToPixel enabled");
		box1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				stage.setSnapToPixel(box1.getValue());
				
			}
		});		
		
		HorizontalPanel hp = new HorizontalPanel();
		hp.setSpacing(2);
		
		
		hp.add(box);
		hp.add(box1);
		panel.add(hp);
		panel.add(createJSObject);
	}
	
	private void toggleCache(boolean value){
		int l =stage.getNumChildren()-1;
		for(int i =0 ;i< l ; i++){
			Shape shape = (Shape)stage.getChildAt(i);
			if(value){
				shape.cache(-circleRadius, -circleRadius, circleRadius*2, circleRadius*2);
			}
			else{
				shape.uncache();
			}
				
		}
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
