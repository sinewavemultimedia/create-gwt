package com.easeljs.html5.client.easeljs;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Slider;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.Canvas;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.Manifest;
import com.sinewavemultimedia.easeljs.framework.js.display.Bitmap;
import com.sinewavemultimedia.easeljs.framework.js.display.Container;
import com.sinewavemultimedia.easeljs.framework.js.display.DisplayObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Graphics;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.filters.ColorMatrix;
import com.sinewavemultimedia.easeljs.framework.js.filters.ColorMatrixFilter;
import com.sinewavemultimedia.easeljs.framework.js.filters.Filter;
import com.sinewavemultimedia.easeljs.framework.js.preload.PreloadJS;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class Transform implements IEasel {

	CreateJSObject createJSObject  = null;
	Canvas canvas = null;
	Stage stage	=	null; 
	int canvaswidth = 960;
	int canvasheight = 400;
	Graphics graphics = null;
	Container imageContainer = null;
	List<Event> images = null;
	int image_width = 149, image_height = 370;
	
	PreloadJS preloadjs = null;
	
	@Override
	public void load(VerticalPanel panel) {
		createJSObject  = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage	= createJSObject.getStage();
		canvas  = createJSObject.getCanvas();
		imageContainer = Container.createContainer();
		images = new ArrayList<Event>();
		
		panel.add(createJSObject);
		Slider slider = new Slider();
		slider.setMinValue(-30);
		slider.setMaxValue(30);
		slider.setWidth(150);
		slider.setIncrement(1);
		slider.addListener(Events.Change,new Listener<BaseEvent>() {

			@Override
			public void handleEvent(BaseEvent be) {
				Slider slider = (Slider)be.getSource();
				int value = slider.getValue();
				if(value==0) return;
	            int l = images.size();
	            for(int i=0;i<l;i++) {
	                DisplayObject bmp1 = imageContainer.getChildAt(i);

	                if (i%2==0) {
	                    bmp1.setSkewY(value);
	                } else {
	                    bmp1.setSkewY(-1*value);
	                    bmp1.setY(-(150) * Math.sin(bmp1.getSkewY()/180*Math.PI));
	                }

	                double sx = ((image_width - 1)*i) * Math.cos(bmp1.getSkewY()/180*Math.PI);
	                bmp1.setX(sx);
	                
	                
	                Filter []filters= new Filter[]{getColorMatrixFilter(bmp1.getSkewY())};
	                bmp1.setFilters(filters) ;
	                bmp1.setSnapToPixel(true);
	                bmp1.updateCache();
	            }

	            double _scale = (value > 0) ? ((double)1/value) * 20 : -1*(((double)1/value) * 20);
	            imageContainer.setRotation((value > 0) ? value>>1 : - 1*value>>1);
	            imageContainer.setScaleX((_scale <= 1) ? _scale : 1);
	            imageContainer.setScaleY((_scale <= 1) ? _scale : 1);

	            imageContainer.setX((canvaswidth- (image_width*l)) >> 1);
	            imageContainer.setY((canvasheight - image_height) >> 1);

	            stage.update();			
			}
		});
		
		panel.add(slider);
		
		final JsArray<Manifest> manifest = (JsArray<Manifest>)JavaScriptObject.createArray();
		Manifest image0=Manifest.create();
		image0.addStringProperty("src", "../resources/images/image_1_1.png");
		image0.addStringProperty("id", "image0");
		manifest.push(image0);		
		
		Manifest image1=Manifest.create();
		image1.addStringProperty("src", "../resources/images/image_1_2.png");
		image1.addStringProperty("id", "image1");
		manifest.push(image1);
		
		Manifest image2=Manifest.create();
		image2.addStringProperty("src", "../resources/images/image_1_3.png");
		image2.addStringProperty("id", "image2");
		manifest.push(image2);
		
		Manifest image3=Manifest.create();
		image3.addStringProperty("src", "../resources/images/image_1_4.png");
		image3.addStringProperty("id", "image3");
		manifest.push(image3);
		
		preloadjs = PreloadJS.createPreloadJs();
		preloadjs.setUseXHR(false);
		CallBackEvent progress = new CallBackEvent() {
			@Override
			public void onSuccess(Event event) {
				
			}
		};
		preloadjs.onProgress(progress);
		CallBackEvent complete = new CallBackEvent() {
			@Override
			public void onSuccess(Event event) {
	            int l = images.size();
	            for(int i=0;i<l;i++) {
	                String id = images.get(i).getId();
	                Bitmap bmp = Bitmap.create(preloadjs.getResult(id).getJavaScriptProperty("result"));
	                imageContainer.addChild(bmp);
	            }

	            displayImages();				
			}
		};		
		preloadjs.onComplete(complete);
		
		CallBackEvent fileLoad = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
				images.add(event);
			}
		};
		preloadjs.onFileLoad(fileLoad);
		
		stage.addChild(imageContainer);
		
		CallBack back = new CallBack() {
			
			@Override
			public void onSuccess() {
				stage.update();
			}
		};
		preloadjs.loadManifest(manifest);
		 dotick(back);
		 
		 Ticker.addListener(getWindow());
	}
	private Filter getColorMatrixFilter(double value){
		ColorMatrix cm = ColorMatrix.create();
        cm.adjustBrightness(value*0.75);
        return ColorMatrixFilter.create(cm);
	}

	private void displayImages() {
        int l = images.size();
        for(int i=0;i<l;i++) {
            DisplayObject bmp = imageContainer.getChildAt(i);
            bmp.cache(0,0, image_width, image_height);
            bmp.setX((image_width) * i);
            bmp.setSnapToPixel(true);
        }

        imageContainer.setX(canvaswidth - (image_width*l) >> 1);
        imageContainer.setY(canvasheight - image_height >> 1);

        stage.update();
    }
	
	private static native JavaScriptObject getWindow()/*-{
		return $wnd;
	}-*/;
	
	private static native void dotick(CallBack callBack) /*-{
		$wnd.tick=function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
	}}-*/; 	
	
}
