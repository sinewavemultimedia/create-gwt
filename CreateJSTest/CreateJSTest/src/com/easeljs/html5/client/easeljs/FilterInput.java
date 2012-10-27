package com.easeljs.html5.client.easeljs;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Slider;
/*import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.Slider;
*/import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.Image;
import com.sinewavemultimedia.easeljs.framework.js.display.Bitmap;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.filters.BoxBlurFilter;
import com.sinewavemultimedia.easeljs.framework.js.filters.ColorFilter;
import com.sinewavemultimedia.easeljs.framework.js.filters.ColorMatrix;
import com.sinewavemultimedia.easeljs.framework.js.filters.ColorMatrixFilter;
import com.sinewavemultimedia.easeljs.framework.js.filters.Filter;

/*
* author: James Tyner 
*/
public class FilterInput implements IEasel {

	Image img;
	
	int canvaswidth = 960;
	int canvasheight = 250;
	CreateJSObject createJSObject = null;
	Stage stage = null;
	int brightnessValue=0,contrastValue=0,saturationValue=0,hueValue=0,blurXValue=0,blurYValue=0,redChannelvalue=255,greenChannelValue=255,blueChannelValue=255;
	
	ColorMatrix cm = null;
	
	ColorMatrixFilter colorFilter = null;
	BoxBlurFilter blurFilter = null;
	ColorFilter redChannelFilter = null, greenChannelFilter = null,blueChannelFilter=null;
	
	Bitmap bmp = null;
	
	@Override
	public void load(final VerticalPanel panel) {
		
		CallBackEvent callBack = new CallBackEvent() {
			@Override
			public void onSuccess(Event event) {
				createJSObject =new CreateJSObject(""+canvaswidth, ""+canvasheight);
				stage	=	createJSObject.getStage();
				
				bmp = Bitmap.create(img);
				bmp.setScaleX(2);
				bmp.setScaleY(2);
				bmp.cache(0,0,img.getWidth(),img.getHeight());
	            stage.addChild(bmp);
	            
	            HorizontalPanel horizontalPanel = new HorizontalPanel();
	            

	            
	            
	            Slider brightness = new Slider();
	            brightness.setMinValue(-100);
	            brightness.setMaxValue(100);
	            brightness.setValue(0);
	            brightness.setWidth(150);
	            brightness.setIncrement(1);
	            brightness.addListener(Events.Change, new Listener<BaseEvent>() {

					@Override
					public void handleEvent(BaseEvent be) {
						Slider slider = (Slider)be.getSource();
						
						brightnessValue = slider.getValue();
						applyEffect();
					}
				});
	            horizontalPanel.add(new Label("Brightness"));
	            horizontalPanel.add(brightness);
	            
	            Slider saturation = new Slider();
	            saturation.setMinValue(-100);
	            saturation.setMaxValue(100);
	            saturation.setValue(0);
	            saturation.setWidth(150);
	            saturation.setIncrement(1);
	            saturation.addListener(Events.Change, new Listener<BaseEvent>() {

					@Override
					public void handleEvent(BaseEvent be) {
						Slider slider = (Slider)be.getSource();
						saturationValue = slider.getValue();
						
						applyEffect();
					}
				});
	            horizontalPanel.add(new Label("Saturation"));
	            horizontalPanel.add(saturation);	            
	            

	         
	            Slider contrast = new Slider();
	            contrast.setMinValue(-100);
	            contrast.setMaxValue(100);
	            contrast.setValue(0);
	            contrast.setWidth(150);
	            contrast.setIncrement(1);
	            contrast.addListener(Events.Change, new Listener<BaseEvent>() {

					@Override
					public void handleEvent(BaseEvent be) {
						Slider slider = (Slider)be.getSource();
						contrastValue= slider.getValue();
						applyEffect();
						
					}
				});
	            horizontalPanel.add(new Label("Contrast"));
	            horizontalPanel.add(contrast);	
	            
	            Slider hue = new Slider();
	            hue.setMinValue(-100);
	            hue.setMaxValue(100);
	            hue.setValue(0);
	            hue.setWidth(150);
	            hue.setIncrement(1);
	            hue.addListener(Events.Change, new Listener<BaseEvent>() {

					@Override
					public void handleEvent(BaseEvent be) {
						Slider slider = (Slider)be.getSource();
						
						hueValue = slider.getValue();
						applyEffect();
					}
				});
	            horizontalPanel.add(new Label("Hue"));
	            horizontalPanel.add(hue);	
	            
	            
	            HorizontalPanel horizontalPanel1 = new HorizontalPanel();
	            Slider blurx = new Slider();
	            blurx.setMinValue(0);
	            blurx.setMaxValue(30);
	            blurx.setValue(0);
	            blurx.setWidth(150);
	            blurx.setIncrement(1);
	            blurx.addListener(Events.Change, new Listener<BaseEvent>() {

					@Override
					public void handleEvent(BaseEvent be) {
						Slider slider = (Slider)be.getSource();
						
						blurXValue = slider.getValue();
						applyEffect();
					}
				});
	            horizontalPanel1.add(new Label("Blur X"));
	            horizontalPanel1.add(blurx);	  
	            
	            Slider blury = new Slider();
	            blury.setMinValue(0);
	            blury.setMaxValue(30);
	            blury.setValue(0);
	            blury.setWidth(150);
	            blury.setIncrement(1);
	            blury.addListener(Events.Change, new Listener<BaseEvent>() {

					@Override
					public void handleEvent(BaseEvent be) {
						Slider slider = (Slider)be.getSource();
						
						blurYValue = slider.getValue();
						applyEffect();
					}
				});
	            horizontalPanel1.add(new Label("Blur Y"));
	            horizontalPanel1.add(blury);		            
	            
	            Slider redchannel = new Slider();
	            redchannel.setMinValue(0);
	            redchannel.setMaxValue(255);
	            redchannel.setValue(255);
	            redchannel.setWidth(150);
	            redchannel.setIncrement(1);
	            redchannel.addListener(Events.Change, new Listener<BaseEvent>() {

					@Override
					public void handleEvent(BaseEvent be) {
						Slider slider = (Slider)be.getSource();
						
						redChannelvalue= slider.getValue();
						applyEffect();
					}
				});
	            horizontalPanel1.add(new Label("Red Channel"));
	            horizontalPanel1.add(redchannel);	
	            
	            Slider greenchannel = new Slider();
	            greenchannel.setMinValue(0);
	            greenchannel.setMaxValue(255);
	            greenchannel.setValue(255);
	            greenchannel.setWidth(150);
	            greenchannel.setIncrement(1);
	            greenchannel.addListener(Events.Change, new Listener<BaseEvent>() {

					@Override
					public void handleEvent(BaseEvent be) {
						Slider slider = (Slider)be.getSource();
						greenChannelValue= slider.getValue();
						
						applyEffect();
					}
				});
	            horizontalPanel1.add(new Label("Green Channel"));
	            horizontalPanel1.add(greenchannel);		  
	            
	            Slider bluechannel = new Slider();
	            bluechannel.setMinValue(0);
	            bluechannel.setMaxValue(255);
	            bluechannel.setValue(255);
	            bluechannel.setWidth(150);
	            bluechannel.setIncrement(1);
	            bluechannel.addListener(Events.Change, new Listener<BaseEvent>() {

					@Override
					public void handleEvent(BaseEvent be) {
						Slider slider = (Slider)be.getSource();
						
						blueChannelValue = slider.getValue();
						applyEffect();
					}
				});
	            horizontalPanel1.add(new Label("Blue Channel"));
	            horizontalPanel1.add(bluechannel);			            
	            
	            panel.add(createJSObject);
	            panel.add(horizontalPanel);	            
	            panel.add(horizontalPanel1);         
	            stage.update();
			}
		};
		img = Image.create();
		img.setSrc("../resources/images/flowers_small.jpg");
		img.onLoad(callBack);
	}
	
	private void applyEffect(){
		cm = ColorMatrix.create(brightnessValue, contrastValue, saturationValue, hueValue);
		//cm = cm.adjustColor(brightnessValue, contrastValue, saturationValue, hueValue);
		
		colorFilter = ColorMatrixFilter.create(cm);
        blurFilter = BoxBlurFilter.create(blurXValue,  blurYValue, 2);
        redChannelFilter = ColorFilter.create(redChannelvalue/255,1,1,1);
        greenChannelFilter = ColorFilter.create(1,greenChannelValue/255,1,1);
        blueChannelFilter = ColorFilter.create(1,1,blueChannelValue/255,1);

        bmp.setFilters( new Filter[]{colorFilter, blurFilter, redChannelFilter, greenChannelFilter, blueChannelFilter} );
        bmp.updateCache();
        stage.update();
        
	}

}
