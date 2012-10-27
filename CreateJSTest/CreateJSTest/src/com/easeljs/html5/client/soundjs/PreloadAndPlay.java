package com.easeljs.html5.client.soundjs;

import com.easeljs.html5.client.easeljs.IEasel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.Manifest;
import com.sinewavemultimedia.easeljs.framework.js.preload.PreloadJS;
import com.sinewavemultimedia.easeljs.framework.js.sound.FlashPlugin;
import com.sinewavemultimedia.easeljs.framework.js.sound.SoundJS;

/*
* author: James Tyner 
*/
public class PreloadAndPlay implements IEasel {

	PreloadJS queue = null;
	
	@Override
	public void load(VerticalPanel panel) {
		FlashPlugin.BASE_PATH("../resources/soundjs/");
		if(SoundJS.checkPlugin(true)){
			String assetPath ="../resources/sounds/";
			String[] array = new String[]{
					assetPath+"18-machinae_supremacy-lord_krutors_dominion.mp3|"+assetPath+"18-machinae_supremacy-lord_krutors_dominion.ogg"
			};
			
			JsArray<Manifest> manifest = (JsArray<Manifest>)JavaScriptObject.createArray();
			Manifest tmanifest=Manifest.create();
			tmanifest.addStringProperty("src", array[0]);
			tmanifest.addStringProperty("id", "music");
			manifest.push(tmanifest);
			
			queue = PreloadJS.createPreloadJs();
			queue.installPlugin(SoundJS.plugin());
			CallBackEvent complete = new CallBackEvent() {
				
				@Override
				public void onSuccess(Event event) {
					playSound("music");
				}
			};
			queue.onComplete(complete);
			
			CallBackEvent fileerror = new CallBackEvent() {
				
				@Override
				public void onSuccess(Event event) {
					Window.alert("File error ");
				}
			};
			queue.onFileError(fileerror);
			
			CallBackEvent progress = new CallBackEvent() {
				
				@Override
				public void onSuccess(Event event) {
					// TODO Auto-generated method stub
					
				}
			};
			queue.onProgress(progress);
			queue.loadFile(tmanifest, true);
		}
	}

	
	private void playSound(String name){
		SoundJS.play(name);
	}
}
