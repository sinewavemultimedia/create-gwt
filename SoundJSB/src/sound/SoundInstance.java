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
import com.sinewavemultimedia.easeljs.framework.js.CallBack;

/*A  class that represents SoundInstance.js
* author: James Tyner 
*/

public class SoundInstance extends JavaScriptObject {

	protected SoundInstance(){}
	
	public native final boolean isDefault()/*-{
		return this.isDefault;
	}-*/;
	
	public native final boolean isPaused()/*-{
		return this.paused;
	}-*/;	
	
	public native final void pause()/*-{
		this.pause();
	}-*/;
	
	public native final void resume()/*-{
		 this.resume();
	}-*/;
	
	public native final void play()/*-{
		this.play(); 
	}-*/;
	
	public native final void beginPlaying()/*-{
		this.beginPlaying();
	}-*/;
	
	public native final void cleanUp()/*-{
		this.cleanUp();
	}-*/;
	
	public native final void interrupt()/*-{
		this.interrupt();
	}-*/;
	
	public native final void stop()/*-{
		this.stop();
	}-*/;
	
	public native final void setMasterVolume(double volume)/*-{
		this.setMasterVolume(value);
	}-*/;
	
	public native final void setVolume(double volume)/*-{
		this.setVolume(volume);
	}-*/;
	
	public native final void mute()/*-{
		this.mute();
	}-*/;
	
	public native final void setPan(double pan)/*-{
		return this.setPan(pan);
	}-*/;
	
	public native final double getPosition()/*-{
		return this.getPosition();
	}-*/;
	
	public native final boolean setPosition(double position)/*-{
		return this.setPosition(position);
	}-*/;
	
	public native final boolean isPlayFailed()/*-{
		return this.playFailed;
	}-*/;
	
	public native final int getVolume()/*-{
		return this.volume;
	}-*/;
	
	public native final int getPan()/*-{
		return this.pan;
	}-*/;
	
	public native final double getDuration()/*-{
		return this.getDuration();
	}-*/;	
	
	public native final String getPlayState()/*-{
		return this.playState;
	}-*/;
	
	public native final void endedHandler(CallBack callBack)/*-{
		this.endedHandler = function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
		}
	}-*/;
	
	public native final void onComplete(CallBack callBack)/*-{
		this.onComplete = function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
		}
	}-*/;
	
	public native final void onPlayFailed(CallBack callBack)/*-{
		this.onPlayFailed = function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
		}
	}-*/;
	
	public native final void onPlayInterrupted(CallBack callBack)/*-{
		this.onPlayInterrupted = function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
		}
	}-*/;	
	
	public native final void readyHandler(CallBack callBack)/*-{
		this.readyHandler = function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
		}
	}-*/;	

	public native final void stalledHandler(CallBack callBack)/*-{
		this.stalledHandler = function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
		}
	}-*/;	
	
	public native final void setMuted(boolean muted)/*-{
		this.muted=muted;
	}-*/;
	
	public native final boolean getMuted() /*-{
		return this.muted;
	}-*/;
	
	public native final int getRemainingLoops() /*-{
		return this.remainingLoops;
	}-*/;
	
	public native final String getSrc()/*-{
		return this.src;
	}-*/;
	
	public native final int getUniqueId()/*-{
		return this.uniqueId;
	}-*/;	
	
	public native final void setUniqueId(int uniqueId)/*-{
		this.uniqueId = uniqueId;
	}-*/;	
}
