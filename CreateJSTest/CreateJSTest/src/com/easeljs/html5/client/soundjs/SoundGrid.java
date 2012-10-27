package com.easeljs.html5.client.soundjs;

import com.easeljs.html5.client.easeljs.IEasel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.Manifest;
import com.sinewavemultimedia.easeljs.framework.js.preload.PreloadJS;
import com.sinewavemultimedia.easeljs.framework.js.sound.FlashPlugin;
import com.sinewavemultimedia.easeljs.framework.js.sound.SoundChannel;
import com.sinewavemultimedia.easeljs.framework.js.sound.SoundInstance;
import com.sinewavemultimedia.easeljs.framework.js.sound.SoundJS;

/*
* author: James Tyner 
*/
public class SoundGrid implements IEasel {

	PreloadJS preload = null;
	int loc = 0;
	@Override
	public void load(VerticalPanel panel) {
		FlashPlugin.BASE_PATH("../resources/soundjs/");
		HorizontalPanel horizontalPanel = new HorizontalPanel();

		if(SoundJS.checkPlugin(true)){
			String assetsPath ="../resources/sounds/";
			String[] array = new String[]{
					assetsPath+"Game-Break.mp3|"+assetsPath+"Game-Break.ogg",
					assetsPath+"Game-Spawn.mp3|"+assetsPath+"Game-Spawn.ogg",
					assetsPath+"Game-Shot.mp3|"+assetsPath+"Game-Shot.ogg",
					assetsPath+"GU-StealDaisy.mp3|"+assetsPath+"GU-StealDaisy.ogg",
					assetsPath+"Humm.mp3|"+assetsPath+"Humm.ogg",
					assetsPath+"R-Damage.mp3|"+assetsPath+"R-Damage.ogg",
					assetsPath+"Thunder1.mp3|"+assetsPath+"Thunder1.ogg",
					assetsPath+"S-Damage.mp3|"+assetsPath+"S-Damage.ogg",
					assetsPath+"U-CabinBoy3.mp3|"+assetsPath+"U-CabinBoy3.ogg",
					assetsPath+"ToneWobble.mp3|"+assetsPath+"ToneWobble.ogg",
					assetsPath+"Game-Death.mp3|"+assetsPath+"Game-Death.ogg",
					assetsPath+"Game-Break.mp3|"+assetsPath+"Game-Break.ogg"
			};
			JsArray<Manifest> manifest = (JsArray<Manifest>)JavaScriptObject.createArray();
			for(int i =0;i<array.length;i++){
				Manifest tmanifest=Manifest.create();
				tmanifest.addStringProperty("src", array[i]);
				tmanifest.addIntProperty("id", i+1);
				tmanifest.addIntProperty("data:", 1);
				manifest.push(tmanifest);

				Button button1 = new Button("Play "+(i+1));
				button1.setStylePrimaryName(""+(i+1));
				loc = i+1;
				button1.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						Button button1 = (Button)event.getSource();
						playSound(button1.getStylePrimaryName());
					}
				});
				horizontalPanel.add(button1);

			}
			preload = PreloadJS.createPreloadJs();
			preload.installPlugin(SoundJS.plugin());
			CallBackEvent backEvent = new CallBackEvent() {
				
				@Override
				public void onSuccess(Event event) {
					
				}
			};
			preload.onFileLoad(backEvent);
			preload.loadManifest(manifest,true);
			
			panel.add(horizontalPanel);
		}
		else{
			Window.alert("Plugin Error");
		}
	}

	private void playSound(String target){
		SoundInstance instance= SoundJS.play(target, SoundJS.interruptnone(),0, 0, false, 1);
		if(instance==null || instance.getPlayState().equals(SoundJS.playFailed()))
			return;
		
		
	}
}
