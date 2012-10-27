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

/*A  class that represents Plugin.js
* author: James Tyner 
*/

public class Plugin extends JavaScriptObject {

	protected Plugin(){}
	
	public native final boolean isPanning()/*-{
		return this.panning;
	}-*/;

	public native final boolean isVolume()/*-{
		return this.volume;
	}-*/;

	public native final boolean isMp3()/*-{
		return this.mp3;
	}-*/;
	
	public native final boolean isOgg()/*-{
		return this.ogg;
	}-*/;
		
	public native final boolean isWav()/*-{
		return this.wav;
	}-*/;	
	
	public native final boolean isMpeg()/*-{
		return this.mpeg;
	}-*/;
	
	public native final double getChannels()/*-{
		return this.channels;
	}-*/;	
}
