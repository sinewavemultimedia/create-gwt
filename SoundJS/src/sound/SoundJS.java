/* Copyright (c) 2010 gskinner.com, inc.
*  CreateGWT (c) 2012 sinewavemultimedia.com
* 
* Permission is hereby granted, free of charge, to any person
* obtaining a copy of this software and associated documentation
* files (the "Software"), to deal in the Software without
* restriction, including without limitation the rights to use,
* copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the
* Software is furnished to do so, subject to the following
* conditions:
* 
* The above copyright notice and this permission notice shall be
* included in all copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
* EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
* OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
* NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
* HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
* WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
* FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
* OTHER DEALINGS IN THE SOFTWARE.
*/



package com.sinewavemultimedia.easeljs.framework.js.sound;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/*A  class that represents SoundJS.js
* author: James Tyner 
*/

public class SoundJS extends Plugin {

	protected SoundJS(){}
	
	public static final native SoundJS plugin()/*-{
		return $wnd.createjs.SoundJS;
	}-*/;
	
	public static final native String delimiter()/*-{
		return $wnd.createjs.SoundJS.DELIMITER;
	}-*/;
	
	public static final native void delimiter(String DELIMITER)/*-{
		$wnd.createjs.SoundJS.DELIMITER = DELIMITER;
	}-*/;	
	
	public static final native double audioTimeout()/*-{
		return $wnd.createjs.SoundJS.AUDIO_TIMEOUT;
	}-*/;
	
	public static final native void audioTimeout(double audioTimeout)/*-{
		$wnd.createjs.SoundJS.AUDIO_TIMEOUT = audioTimeout;
	}-*/;	
	
	public static final native String interruptany()/*-{
		return $wnd.createjs.SoundJS.INTERRUPT_ANY;
	}-*/;
	
	public static final native void interruptany(String any)/*-{
		$wnd.createjs.SoundJS.INTERRUPT_ANY = any;
	}-*/;	

	public static final native String interruptearly()/*-{
		return $wnd.createjs.SoundJS.INTERRUPT_EARLY;
	}-*/;
	
	public static final native void interruptearly(String early)/*-{
		$wnd.createjs.SoundJS.INTERRUPT_EARLY = early;
	}-*/;	
	
	public static final native String interruptlate()/*-{
		return $wnd.createjs.SoundJS.INTERRUPT_LATE;
	}-*/;
	
	public static final native void interruptlate(String late)/*-{
		$wnd.createjs.SoundJS.INTERRUPT_LATE = late;
	}-*/;	
	
	public static final native String interruptnone()/*-{
		return $wnd.createjs.SoundJS.INTERRUPT_NONE;
	}-*/;
	
	public static final native void interruptnone(String none)/*-{
		$wnd.createjs.SoundJS.INTERRUPT_NONE = none;
	}-*/;	
	
	public static final native String playInited()/*-{
		return $wnd.createjs.SoundJS.PLAY_INITED;
	}-*/;
	
	public static final native void playInited(String playInited)/*-{
		$wnd.createjs.SoundJS.PLAY_INITED = playInited;
	}-*/;	

	public static final native String playSucceeded()/*-{
		return $wnd.createjs.SoundJS.PLAY_SUCCEEDED;
	}-*/;
	
	public static final native void playSucceeded(String playSucceeded)/*-{
		$wnd.createjs.SoundJS.PLAY_SUCCEEDED = playSucceeded;
	}-*/;	
	
	public static final native String playInterrupted()/*-{
		return $wnd.createjs.SoundJS.PLAY_INTERRUPTED;
	}-*/;
	
	public static final native void playInterrupted(String playInterrupted)/*-{
		$wnd.createjs.SoundJS.PLAY_INTERRUPTED = playInterrupted;
	}-*/;	
	
	public static final native String playFinished()/*-{
		return $wnd.createjs.SoundJS.PLAY_FINISHED;
	}-*/;
	
	public static final native void playFinished(String playFinished)/*-{
		$wnd.createjs.SoundJS.PLAY_FINISHED = playFinished;
	}-*/;	
	
	public static final native String playFailed()/*-{
		return $wnd.createjs.SoundJS.PLAY_FAILED;
	}-*/;
	
	public static final native void playFailed(String playFailed)/*-{
		$wnd.createjs.SoundJS.PLAY_FAILED = playFailed;
	}-*/;	
	
	public static final native Plugin activePlugin()/*-{
		return $wnd.createjs.SoundJS.activePlugin;
	}-*/;
	
	public static final native void activePlugin(Plugin plugin)/*-{
		return $wnd.createjs.SoundJS.activePlugin = plugin;
	}-*/;
	
	public static final native boolean getMuted()/*-{
		return $wnd.createjs.SoundJS.muted;
	}-*/;	

	public static final native boolean registerPlugins(JsArray<Plugin> plugins)/*-{
		return $wnd.createjs.SoundJS.registerPlugins(plugins);
	}-*/;	

	public static final native boolean registerPlugin(Plugin plugin)/*-{
		return $wnd.createjs.SoundJS.registerPlugin(plugin);
	}-*/;
	
	public static final native boolean isReady()/*-{
		return $wnd.createjs.SoundJS.isReady();
	}-*/;
	
	public static final native Plugin getCapabilities()/*-{
		return $wnd.createjs.SoundJS.getCapabilities();
	}-*/;
	
	public static final native SoundInstance play(String src,String interrupt,double delay,double offset,boolean loop,double volume,double pan)/*-{
		return $wnd.createjs.SoundJS.play(src,interrupt, delay, offset, loop, volume, pan);
	}-*/;
	
	public static final native SoundInstance play(String src,String interrupt,double delay,double offset,int loop,double volume,double pan)/*-{
	return $wnd.createjs.SoundJS.play(src,interrupt, delay, offset, loop, volume, pan);
}-*/;	
	
	public static final native SoundInstance play(String src,String interrupt,double delay,double offset,boolean loop,double volume)/*-{
		return $wnd.createjs.SoundJS.play(src,interrupt, delay, offset, loop, volume);
	}-*/;
	
	public static final native SoundInstance play(String src,String interrupt,double delay,double offset,int loop,double volume)/*-{
		return $wnd.createjs.SoundJS.play(src,interrupt, delay, offset, loop, volume);
	}-*/;	

	public static final native SoundInstance play(String src,String interrupt,double delay,double offset,boolean loop)/*-{
		return $wnd.createjs.SoundJS.play(src,interrupt, delay, offset, loop);
	}-*/;
	
	public static final native SoundInstance play(String src,String interrupt,double delay,double offset,int loop)/*-{
		return $wnd.createjs.SoundJS.play(src,interrupt, delay, offset, loop);
	}-*/;	

	public static final native SoundInstance play(String src,String interrupt,double delay,double offset)/*-{
		return $wnd.createjs.SoundJS.play(src,interrupt, delay, offset);
	}-*/;

	public static final native SoundInstance play(String src,String interrupt,double delay)/*-{
		return $wnd.createjs.SoundJS.play(src,interrupt, delay);
	}-*/;

	public static final native SoundInstance play(String src,String interrupt)/*-{
		return $wnd.createjs.SoundJS.play(src,interrupt);
	}-*/;
	
	public static final native SoundInstance play(String src)/*-{
		return $wnd.createjs.SoundJS.play(src);
	}-*/;	
	
	public static final native boolean playInstance(SoundChannel instance,String interrupt,double delay,double offset,boolean loop,double volume,double pan)/*-{
		return $wnd.createjs.SoundJS.playInstance(instance,interrupt, delay, offset, loop, volume, pan);
	}-*/;
	
	public static final native boolean playInstance(SoundChannel instance,String interrupt,double delay,double offset,int loop,double volume,double pan)/*-{
		return $wnd.createjs.SoundJS.playInstance(instance,interrupt, delay, offset, loop, volume, pan);
	}-*/;	
	
	public static final native boolean playInstance(SoundChannel instance,String interrupt,double delay,double offset,boolean loop,double volume)/*-{
		return $wnd.createjs.SoundJS.playInstance(instance,interrupt, delay, offset, loop, volume);
	}-*/;
	
	public static final native boolean playInstance(SoundChannel instance,String interrupt,double delay,double offset,int loop,double volume)/*-{
		return $wnd.createjs.SoundJS.playInstance(instance,interrupt, delay, offset, loop, volume);
	}-*/;	
	
	public static final native boolean playInstance(SoundChannel instance,String interrupt,double delay,double offset,boolean loop)/*-{
		return $wnd.createjs.SoundJS.playInstance(instance,interrupt, delay, offset, loop);
	}-*/;
	
	public static final native boolean playInstance(SoundChannel instance,String interrupt,double delay,double offset,int loop)/*-{
		return $wnd.createjs.SoundJS.playInstance(instance,interrupt, delay, offset, loop);
	}-*/;
	
	public static final native boolean playInstance(SoundChannel instance,String interrupt,double delay,double offset)/*-{
		return $wnd.createjs.SoundJS.playInstance(instance,interrupt, delay, offset);
	}-*/;
	
	public static final native boolean playInstance(SoundChannel instance,String interrupt,double delay)/*-{
		return $wnd.createjs.SoundJS.playInstance(instance,interrupt, delay);
	}-*/;
	
	public static final native boolean playInstance(SoundChannel instance,String interrupt)/*-{
		return $wnd.createjs.SoundJS.playInstance(instance,interrupt);
	}-*/;	
	
	public static final native boolean beginPlaying(SoundChannel instance,String interrupt,double offset,boolean loop,double volume,double pan)/*-{
		return $wnd.createjs.SoundJS.beginPlaying(instance,interrupt,  offset, loop, volume, pan);
	}-*/;
	
	public static final native boolean checkPlugin(boolean initializeDefault)/*-{
		return $wnd.createjs.SoundJS.checkPlugin(initializeDefault);
	}-*/;
	
	public static final native String getSrcFromId(String value)/*-{
		return $wnd.createjs.SoundJS.getSrcFromId(value);
	}-*/;
	
	public static final native boolean setVolume(double value,String id)/*-{
		return $wnd.createjs.SoundJS.setVolume(value,id);
	}-*/;
	
	public static final native double getMasterVolume()/*-{
		return $wnd.createjs.SoundJS.getMasterVolume();
	}-*/;	
	
	public static final native boolean setMasterVolume(double value)/*-{
		return $wnd.createjs.SoundJS.setMasterVolume(value);
	}-*/;
	
	public static final native boolean setMute(boolean isMuted)/*-{
		return $wnd.createjs.SoundJS.setMute(isMuted);
	}-*/;	
	
	public static final native boolean pause(String id)/*-{
		return $wnd.createjs.SoundJS.pause(id);
	}-*/;	
	
	public static final native boolean resume(String id)/*-{
		return $wnd.createjs.SoundJS.resume(id);
	}-*/;	
	
	public static final native boolean stop(String id)/*-{
		return $wnd.createjs.SoundJS.stop(id);
	}-*/;
	
	public static final native boolean pause()/*-{
		return $wnd.createjs.SoundJS.pause();
	}-*/;	
	
	public static final native boolean resume()/*-{
		return $wnd.createjs.SoundJS.resume();
	}-*/;	
	
	public static final native boolean stop()/*-{
		return $wnd.createjs.SoundJS.stop();
	}-*/;		
	
	public static final native SoundInstance getInstanceById(String id)/*-{
		return $wnd.createjs.SoundJS.getInstanceById(id);
	}-*/;
	
}
