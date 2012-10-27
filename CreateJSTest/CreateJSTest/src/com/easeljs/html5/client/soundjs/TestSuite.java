package com.easeljs.html5.client.soundjs;

import java.util.List;

import com.easeljs.html5.client.easeljs.IEasel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.Manifest;
import com.sinewavemultimedia.easeljs.framework.js.preload.PreloadJS;
import com.sinewavemultimedia.easeljs.framework.js.sound.FlashPlugin;
import com.sinewavemultimedia.easeljs.framework.js.sound.HTMLAudioPlugin;
import com.sinewavemultimedia.easeljs.framework.js.sound.Plugin;
import com.sinewavemultimedia.easeljs.framework.js.sound.SoundInstance;
import com.sinewavemultimedia.easeljs.framework.js.sound.SoundJS;

/*
* author: James Tyner 
*/
public class TestSuite implements IEasel {

	PreloadJS preload = null;
	@Override
	public void load(VerticalPanel panel) {
		final ListBox interrupt = new ListBox();
		
		final ListBox list = new ListBox(true);
		

		interrupt.addItem("Any","any");
		interrupt.addItem("None","none");
		interrupt.addItem("Early","early");
		interrupt.addItem("Late","late");
		
		panel.add(list);
		panel.add(interrupt);
		
		FlashPlugin.BASE_PATH("../resources/soundjs/");
		if(SoundJS.checkPlugin(true)){
			JsArray<Plugin> plugins =(JsArray<Plugin>)JavaScriptObject.createArray();
			plugins.push(HTMLAudioPlugin.plugin());
			plugins.push(FlashPlugin.plugin());
			
			preload = PreloadJS.createPreloadJs();
			preload.installPlugin(SoundJS.plugin());
			CallBackEvent fileload= new CallBackEvent() {
				@Override
				public void onSuccess(Event event) {
					list.addItem(event.getId(),event.getId());
				}
			};
			preload.onFileLoad(fileload);
			
			CallBackEvent progress = new CallBackEvent() {
				@Override
				public void onSuccess(Event event) {					
				}
			};
			preload.onProgress(progress);
			
			CallBackEvent complete = new CallBackEvent() {
				
				@Override
				public void onSuccess(Event event) {

				}
			};
			
			preload.onComplete(complete);
			
			String assetPath ="../resources/sounds/";
			JsArray<Manifest> manifest = (JsArray<Manifest>)JavaScriptObject.createArray();
			Manifest Music=Manifest.create();
			Music.addStringProperty("src", assetPath + "M-GameBG.mp3");
			Music.addStringProperty("id", "music");
			Music.addIntProperty("data", 2);
			manifest.push(Music);
			
			Manifest hummMp3=Manifest.create();
			hummMp3.addStringProperty("src", assetPath + "Humm.mp3");
			hummMp3.addStringProperty("id", "Humm (mp3)");
			hummMp3.addIntProperty("data", 2);
			manifest.push(hummMp3);
			
			Manifest hummOgg=Manifest.create();
			hummOgg.addStringProperty("src", assetPath + "Humm.ogg");
			hummOgg.addStringProperty("id", "Humm (ogg)");
			hummOgg.addIntProperty("data", 2);
			manifest.push(hummOgg);
			
			Manifest Thunder1=Manifest.create();
			Thunder1.addStringProperty("src", assetPath + "Thunder1.mp3|"+assetPath+"Thunder1.ogg");
			Thunder1.addStringProperty("id", "Thunder");
			Thunder1.addIntProperty("data", 2);
			manifest.push(Thunder1);			
			
			Manifest ToneWobble=Manifest.create();
			ToneWobble.addStringProperty("src", assetPath + "ToneWobble.mp3|"+assetPath+"ToneWobble.ogg");
			ToneWobble.addStringProperty("id", "Tone wobble");
			ToneWobble.addStringProperty("type", "sound");
			manifest.push(ToneWobble);			
			
			Manifest ratDamge=Manifest.create();
			ratDamge.addStringProperty("src", assetPath + "R-Damage.mp3");
			ratDamge.addStringProperty("id", "Rat Damage");
			ratDamge.addStringProperty("type", "sound");
			manifest.push(ratDamge);			
			
			Manifest seaGullDamage=Manifest.create();
			seaGullDamage.addStringProperty("src", assetPath + "S-Damage.mp3");
			seaGullDamage.addStringProperty("id", "Damage");
			seaGullDamage.addStringProperty("type", "sound");
			manifest.push(seaGullDamage);			
						
			Manifest cabinBoy=Manifest.create();
			cabinBoy.addStringProperty("src", assetPath + "U-CabinBoy3.mp3");
			cabinBoy.addStringProperty("id", "CabinBoy");
			cabinBoy.addStringProperty("type", "sound");
			cabinBoy.addIntProperty("data", 1);
			manifest.push(cabinBoy);
			
			preload.loadManifest(manifest);
			
			Button stopSound = new Button("Stop");
			stopSound.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					SoundJS.stop();
				}
			});
			
			Button playButton = new Button("Play");
			playButton.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					String id =list.getValue(list.getSelectedIndex());
					//SoundInstance instance =  SoundJS.getInstanceById(id);
					String interrput = interrupt.getValue(interrupt.getSelectedIndex());
					
					SoundInstance instance= SoundJS.play(id,interrput);
					CallBack playIntterrupted = new CallBack() {
						
						@Override
						public void onSuccess() {
							Window.alert("called");
						}
					};
					instance.onPlayInterrupted(playIntterrupted);
				}
			});
			panel.add(playButton);
			panel.add(stopSound);
		}
	}

	private void enableSet(String name,boolean enabled){
		if(name.equals("sound")){
			
		}
		else if(name.equals("instance")){
			
		}
	}
	
	private void enableItems(String name,boolean value,List controls){
		
	}
}
