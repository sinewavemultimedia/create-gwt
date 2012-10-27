package com.easeljs.html5.client.preloadjs;

import com.easeljs.html5.client.easeljs.IEasel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.CallBackTween;
import com.sinewavemultimedia.easeljs.framework.js.Canvas;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.Image;
import com.sinewavemultimedia.easeljs.framework.js.Manifest;
import com.sinewavemultimedia.easeljs.framework.js.display.Bitmap;
import com.sinewavemultimedia.easeljs.framework.js.display.Container;
import com.sinewavemultimedia.easeljs.framework.js.display.DisplayObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Shadow;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.preload.PreloadJS;
import com.sinewavemultimedia.easeljs.framework.js.tween.Property;
import com.sinewavemultimedia.easeljs.framework.js.tween.Tween;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class PreloadImages implements IEasel {

	PreloadJS preload = null;
	CreateJSObject createJSObject = null,loaderjsObjet = null;
	int canvaswidth = 960;
	int canvasheight = 400;
	Stage stage =null,loaderStage = null;
	Canvas canvas = null,loaderCanvas=null;	
	
	boolean update = false;
	int totalLoaded = 0, borderPadding = 10,loaderWidth = 800;
	
	Container loaderBar = null,imageContainer = null;
	Shape bar= null;
	
	@Override
	public void load(VerticalPanel panel) {
		createJSObject = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage = createJSObject.getStage();
		canvas = createJSObject.getCanvas();
	
		panel.add(createJSObject);
		loaderjsObjet = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		loaderStage = loaderjsObjet.getStage();
		loaderCanvas = loaderjsObjet.getCanvas();
		
		final JsArray<Manifest> manifest = (JsArray<Manifest>)JavaScriptObject.createArray();
		Manifest image0=Manifest.create();
		image0.addStringProperty("src", "../resources/images/image0.jpg");
		image0.addStringProperty("id", "image0");
		manifest.push(image0);		

		Manifest image1=Manifest.create();
		image1.addStringProperty("src", "../resources/images/image1.jpg");
		image1.addStringProperty("id", "image1");
		manifest.push(image1);			

		Manifest image2=Manifest.create();
		image2.addStringProperty("src", "../resources/images/image2.jpg");
		image2.addStringProperty("id", "image2");
		manifest.push(image2);	
		
		Manifest image3=Manifest.create();
		image3.addStringProperty("src", "../resources/images/image3.jpg");
		image3.addStringProperty("id", "image3");
		manifest.push(image3);
		
		int barHeight = 20;
		String loaderColor = createJSObject.Graphics().getRGB(0,0,0);
		
		loaderBar = Container.createContainer();
		bar = Shape.createShape();
		bar.setGraphics(createJSObject.Graphics().beginFill(loaderColor).drawRect(0, 0, 1, barHeight).endFill());
		
		imageContainer= Container.createContainer();
		imageContainer.setX(430);
		imageContainer.setY(200);
		
		stage.addChild(imageContainer);
		
		Shape bgBar= Shape.createShape();
		int padding = 3;
		bgBar.setGraphics(createJSObject.Graphics().setStrokeStyle(1).beginStroke(loaderColor).drawRect(-padding/2, -padding/2, loaderWidth, barHeight+padding));
		
        loaderBar.addChild(bgBar);
        loaderBar.addChild(bar);
        
        loaderBar.setX(10);
        loaderBar.setY(10);
        
        loaderStage.addChild(loaderBar);
        
        preload =PreloadJS.createPreloadJs();
        CallBackEvent progress = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {

				
			}
		};
        preload.onProgress(progress);
        CallBackEvent handleComplete = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
	            //bar.setScaleX((event*100)*(loaderWidth/100));
	            loaderStage.update();
	            if (bar.getScaleX() >= (100*(loaderWidth/100))) {
	                loaderBar.setVisible(false);
	                loaderStage.update();
	            }
				
			}
		};
        preload.onComplete(handleComplete);
        CallBackEvent handleFileLoad = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
				Container movieClip = Container.createContainer();
				
				Bitmap bmp = Bitmap.create(event.getResult());
		            double _w = bmp.getImage().getWidth();
		            double _h = bmp.getImage().getHeight();

		            bmp.setScaleX(0.75);
		            bmp.setScaleY(0.75);
		            bmp.setRegX(_w/2);
		            bmp.setRegY(_h/2);
		            CallBackEvent pressevent = new CallBackEvent() {
						@Override
						public void onSuccess(Event event) {
							final DisplayObject currentItem = ((DisplayObject)event.getTarget()).getParent();
							update  = true;
							Property prop = Property.createProperty();
							prop.addIntProperty("y", -350);
							CallBackTween compete1 = new CallBackTween() {
								
								@Override
								public void onSuccess(Tween teen) {
									imageContainer.addChildAt(currentItem,0);
									Property prop = Property.createProperty();
									prop.addIntProperty("y", 0);
									CallBackTween compete2 = new CallBackTween() {
										
										@Override
										public void onSuccess(Tween tw) {
								            stage.update();
								            update = false;
								        }
									};
									Tween tween = Tween.get(currentItem).to(prop,500).call(compete2);
									
								}
							};
							Tween tween = Tween.get(currentItem).to(prop,200).call(compete1);
							
						}
					};
		            bmp.onPress(pressevent);
		            bmp.setRotation(Math.random() * 16 - 8);

		            Shape border = Shape.createShape();
		            border.setGraphics(createJSObject.Graphics().beginFill(createJSObject.Graphics().getRGB(255,255,255)).drawRect(0, 0, _w+borderPadding, _h+borderPadding).endFill() );
		            border.setRotation(bmp.getRotation());
		            border.setRegX(_w/2);
		            border.setRegY( _h/2);
		            bmp.setX((borderPadding/2) * bmp.getScaleX());
		            bmp.setY((borderPadding/2) * bmp.getScaleX());

		            border.setScaleX(bmp.getScaleX());
		            border.setScaleY(bmp.getScaleX());

		            border.setShadow(Shadow.create("#000000", 0, 0, 2.5));

		            movieClip.addChild(border);
		            movieClip.addChild(bmp);

		            imageContainer.addChild(movieClip);
		            update = true;
		            totalLoaded += 1;

		            if (totalLoaded == manifest.length()) {
		                update = false;
		                stage.update();
		            }
				
			}
		};
        preload.onFileLoad(handleFileLoad);
        preload.loadManifest(manifest);
        
        loaderStage.update();
        stage.update();
        
        CallBack dotick = new CallBack() {
			
			@Override
			public void onSuccess() {
				if(update)
					stage.update();
				
			}
		};
		dotick(dotick);
		
        Ticker.setFPS(30);
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
