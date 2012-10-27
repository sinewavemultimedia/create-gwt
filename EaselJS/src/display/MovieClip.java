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




package com.sinewavemultimedia.easeljs.framework.js.display;

import com.google.gwt.core.client.JavaScriptObject;
import com.sinewavemultimedia.easeljs.framework.js.Canvas2DJS;

/*A class the represents Movieclip.js
* author: James Tyner 
*/
public class MovieClip extends Container {
	
	protected MovieClip(){}
	
	/**
	 * The MovieClip class associates a TweenJS Timeline with an EaselJS Container. It allows you to create objects which
	 * encapsulate timeline animations, state changes, and synched actions. Due to the complexities inherent in correctly
	 * setting up a MovieClip, it is largely intended for tool output and is not included in the main EaselJS library.
	 * <br/><br/>
	 * Currently MovieClip only works properly if it is tick based (as opposed to time based) though some concessions have
	 * been made to support time based timelines in the future.
	 * @class MovieClip
	 * @extends Container
	 * @constructor
	 * @param {String} mode Initial value for the mode property. One of MovieClip.INDEPENDENT, MovieClip.SINGLE_FRAME, or MovieClip.SYNCHED.
	 * @param {Number} startPosition Initial value for the startPosition property.
	 * @param {Boolean} loop Initial value for the loop property.
	 * @param {Object} labels A hash of labels to pass to the timeline instance associated with this MovieClip.
	 **/	
	public final static native MovieClip create(String mode,int startPosition,boolean loop,JavaScriptObject labels)/*-{
		return new $wnd.createjs.MovieClip(mode,startPosition,loop,labels);
	}-*/;

	
	public final native DisplayObject removeMovieChild(DisplayObject object)/*-{
		return this.removeChild(object);
	}-*/;	
	
	
	public final native boolean draw(Canvas2DJS object,boolean ignoreCache,JavaScriptObject _mtx)/*-{
		return this.draw(object,ignoreCache,_mtx);
	}-*/;	

	public final native void play()/*-{
		this.play();
	}-*/;
	
	public final native void stop()/*-{
		this.stop();
	}-*/;	
	
	public final native void gotoAndPlay(String frameOrAnimation)/*-{
		this.gotoAndPlay(frameOrAnimation);
	}-*/;
	
	public final native void gotoAndPlay(int frameOrAnimation)/*-{
		this.gotoAndPlay(frameOrAnimation);
	}-*/;
	
	public final native void gotoAndStop(String frameOrAnimation)/*-{
		this.gotoAndStop(frameOrAnimation);
	}-*/;
	
	public final native void gotoAndStop(int frameOrAnimation)/*-{
		this.gotoAndStop(frameOrAnimation);
	}-*/;
	
	public final native MovieClip Movieclone() /*-{
		return this.clone();
	}-*/;	

}
