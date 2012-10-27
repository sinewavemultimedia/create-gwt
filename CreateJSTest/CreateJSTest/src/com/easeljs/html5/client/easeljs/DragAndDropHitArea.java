package com.easeljs.html5.client.easeljs;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.Image;
import com.sinewavemultimedia.easeljs.framework.js.display.Bitmap;
import com.sinewavemultimedia.easeljs.framework.js.display.Container;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.ui.Touch;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class DragAndDropHitArea implements IEasel {

	CreateJSObject canvas = null;
	int canvaswidth = 960;
	int canvasheight = 400;
	Stage stage = null;
	boolean updated = true;
	
	@Override
	public void load(VerticalPanel panel) {
		canvas = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage = canvas.getStage();
		
		Touch.enable(stage);
		
		stage.enableMouseOver(10);
		//stage.setMouseMoveOutside(true);
		
		CallBack back = new CallBack() {
			
			@Override
			public void onSuccess() {
				if (updated) {
					updated = false; // only update once
					stage.update();
				}
				
			}
		};
		
		dotick(back);
		
		CallBackEvent backEvent = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
				Image image = (Image)event.getTarget();
				final Container container = Container.createContainer();
				stage.addChild(container);
				
				final Shape hitArea = Shape.createShape();
				hitArea.setGraphics(canvas.Graphics().beginFill("#FFF").drawEllipse(-11,-14,24,18));
				
				for(int i =0 ;i<100;i++){
					Bitmap bitmap = Bitmap.create(image);
					container.addChild(bitmap);
					bitmap.setX(canvaswidth * Math.random());
					bitmap.setY(canvasheight * Math.random());
					bitmap.setRotation(360*Math.random());
					bitmap.setRegX(bitmap.getImage().getWidth()/2);
					bitmap.setRegY(bitmap.getImage().getHeight()/2);
					double randomValue = Math.random()*0.4+0.6;
					bitmap.setScaleX(randomValue);
					bitmap.setScaleY(randomValue);
					bitmap.setScale(randomValue);
					bitmap.setName("bmp_"+i);
					bitmap.setHitArea(hitArea);
					
					CallBackEvent onPressEvent = new CallBackEvent() {
						
						@Override
						public void onSuccess(Event event) {
							final Bitmap target = (Bitmap)event.getTarget();
							container.addChild(target);
							
							final double offsetX= target.getX() - event.getStageX();
							final double offsetY= target.getY() - event.getStageY();
							
							CallBackEvent onMouseMoveEvent = new CallBackEvent() {
								
								@Override
								public void onSuccess(Event event) {
									double doX= event.getStageX() + offsetX;
									double doY= event.getStageY() + offsetY;
									target.setX(doX);
									target.setY(doY);
									updated = true;
								}
							};
							
							event.onMouseMove(getObject(onMouseMoveEvent));
						}
					};
					
					bitmap.onPress(onPressEvent);
					
					
					CallBackEvent onMouseOverEvent = new CallBackEvent() {
						
						@Override
						public void onSuccess(Event event) {
							Bitmap target = (Bitmap)event.getTarget();
							double targetScale = target.getScale() * 1.2;
							target.setScaleX(targetScale);
							target.setScaleY(targetScale);
							updated = true;
						}
					};
					
					bitmap.onMouseOver(onMouseOverEvent);
					
					CallBackEvent onMouseOutEvent = new CallBackEvent() {
						
						@Override
						public void onSuccess(Event event) {
							Bitmap target = (Bitmap)event.getTarget();
							double targetScale = target.getScale();
							target.setScaleX(targetScale);
							target.setScaleY(targetScale);
							updated = true;
						}
					};
					bitmap.onMouseOut(onMouseOutEvent);
				}
				
			}
		};
		
		Image img = Image.create();
		img.setSrc("../resources/images/daisy.png");
		img.onLoad(backEvent);
		
		panel.add(canvas);
		
		Ticker.addListener(getWindow(),true);
	}
	
	private static native JavaScriptObject getWindow()/*-{
		return $wnd;
	}-*/;	
	public final native JavaScriptObject getObject(CallBackEvent callBack)/*-{
		return function(event){
		 callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
		};
	}-*/;
	
	private static native void dotick(CallBack callBack) /*-{
		$wnd.tick=function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
		}
	}-*/; 	
}
