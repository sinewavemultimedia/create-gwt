package com.easeljs.html5.client.soundjs;

import com.easeljs.html5.client.easeljs.IEasel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Slider;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.Manifest;
import com.sinewavemultimedia.easeljs.framework.js.SoundNative;
import com.sinewavemultimedia.easeljs.framework.js.preload.PreloadJS;
import com.sinewavemultimedia.easeljs.framework.js.sound.FlashPlugin;
import com.sinewavemultimedia.easeljs.framework.js.sound.SoundInstance;
import com.sinewavemultimedia.easeljs.framework.js.sound.SoundJS;

/*
* author: James Tyner 
*/
public class MediaPlayer implements IEasel {

	PreloadJS preloadjs = null;
	SoundInstance instance = null;
	int positionInterval = 0;
	Label label = null;
	Slider sl =null;
	@Override
	public void load(VerticalPanel panel) {
		label = new Label();
		panel.add(label);
		
		final Button button = new Button(" Pause ");
		button.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				if(instance.getPlayState().equals(SoundJS.playFinished())){
					instance.play();
					trackTime();
					button.setText(" Pause ");
				}
				else{
					if(instance.isPaused()){
						instance.resume();
						button.setText(" Pause ");						
					}
					else {
						instance.pause();
						button.setText(" Play ");
					}
				}
			}
		});
		
		panel.add(button);
		
		final Button buttonStop = new Button(" Stop ");
		buttonStop.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				instance.stop();
				SoundNative.clearInterval(SoundNative.getInterval());
				button.setText("Play ");
			}
		});		
		
		panel.add(buttonStop);
		
		sl = new Slider();
		sl.setWidth(100);
		sl.setIncrement(1);
		
		FlashPlugin.BASE_PATH("../resources/soundjs/");
		if(SoundJS.checkPlugin(true)){
			String assetPath ="../resources/sounds/";
			String[] array = new String[]{
					assetPath+"M-GameBG.mp3|"+assetPath+"M-GameBG.ogg"
			};
			JsArray<Manifest> manifest = (JsArray<Manifest>)JavaScriptObject.createArray();
			Manifest tmanifest=Manifest.create();
			tmanifest.addStringProperty("src", array[0]);
			tmanifest.addStringProperty("id", "music");
			manifest.push(tmanifest);
			
			preloadjs = PreloadJS.createPreloadJs();
			preloadjs.installPlugin(SoundJS.plugin());
			preloadjs.loadManifest(manifest);
			
			CallBackEvent backEvent = new CallBackEvent() {
				
				@Override
				public void onSuccess(Event event) {
					instance = SoundJS.play("music");
					
					CallBack callBack = new CallBack() {
						
						@Override
						public void onSuccess() {
							SoundNative.clearInterval(positionInterval);
							button.setText("Play");
						}
					};
					instance.onComplete(callBack);
					
					
				}
			};
			panel.add(sl);
			
			preloadjs.onComplete(backEvent);
			trackTime();
			
		}else{
			return;
		}
	}
	
	public void trackTime(){
		sl.setMinValue(0);
		CallBack callBack = new CallBack() {
			
			@Override
			public void onSuccess() {
				sl.setMaxValue((int)instance.getDuration());				
				sl.setValue((int)instance.getPosition());
				label.setText("  " + ( instance.getPosition()/instance.getDuration()));
			}
		};
		SoundNative.setInterval(callBack);
	}

}
