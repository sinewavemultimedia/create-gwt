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


package com.sinewavemultimedia.easeljs.framework.js.preload;

import com.google.gwt.core.client.JavaScriptObject;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;

/*A Abstract class for the loader preloader object.
* author: James Tyner 
*/
public class AbstractLoader extends JavaScriptObject {

	protected AbstractLoader(){}
	
	/**
	 * The base loader, which handles all callbacks. All loaders should extend this class.
	 * @class AbstractLoader
	 * @constructor
	 */	
	public static final native AbstractLoader createAbstractLoader()/*-{
		return $wnd.createjs.AbstractLoader();
	}-*/;
	
	/**
	 * Determine if this loader has completed already.
	 * @property loaded
	 * @type Boolean
	 * @default false
	 */	
	public final native void setLoaded(boolean loaded)/*-{
		this.loaded = loaded;
	}-*/;
	
	public final native boolean isLoaded()/*-{
		return this.loaded;
	}-*/;
	
	/**
	 * Determine if a preload instance was canceled. Canceled loads will
	 * not fire complete events. Note that PreloadJS queues should be closed
	 * instead of canceled.
	 * @property canceled
	 * @type {Boolean}
	 * @default false
	 */	
	public final native void setCanceled(boolean canceled)/*-{
		this.canceled = canceled;
	}-*/;
	
	public final native boolean isCanceled()/*-{
		return this.canceled;
	}-*/;

	/**
	 * The current load progress (percentage) for this item.
	 * @property progress
	 * @type Number
	 * @default 0
	 */	
	public final native void setProgress(double progress)/*-{
		this.progress = progress;
	}-*/;
	
	public final native double getProgress()/*-{
		return this.progress;
	}-*/;
	
	/**
	 * The callback to fire when progress changes.
	 * @event onProgress
	 */	
	public final native void onProgress(CallBackEvent callBack)/*-{
		this.onProgress = function(event){
		 	callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
		};
	}-*/;

	/**
	 * The callback to fire when a load starts.
	 * @event onLoadStart
	 */	
	public final native void onLoadStart(CallBackEvent callBack)/*-{
		this.onLoadStart = function(event){
		 	callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
		};
	}-*/;	

	/**
	 * The callback to fire when a file completes.
	 * @event onFileLoad
	 */
	public final native void onFileLoad(CallBackEvent callBack)/*-{
		this.onFileLoad = function(event){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
		};
	}-*/;

	/**
	 * The callback to fire when a file progress changes.
	 * @event onFileProgress
	 */	
	public final native void onFileProgress(CallBackEvent callBack)/*-{
		this.onFileProgress = function(event){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
		};
	}-*/;

	/**
	 * The callback to fire when all loading is complete.
	 * @event onComplete
	 */	
	public final native void onComplete(CallBackEvent callBack)/*-{
		this.onComplete = function(event){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
		};
	}-*/;
	
	public final native void onFileError(CallBackEvent callBack)/*-{
		this.onFileError = function(event){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
		};
	}-*/;	

	/**
	 * The callback to fire when the loader encounters an error. If the error was encountered
	 * by a file, the event will contain the required file data, but the target will be the loader.
	 * @event onError
	 */	
	public final native void onError(CallBackEvent callBack)/*-{
		this.onError = function(event){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
		};
	}-*/;

	/**
	 * Get a reference to the manifest item that is loaded by this loader.
	 * @return {Object} The manifest item
	 */	
	public final native JavaScriptObject getItem()/*-{
		return this.getItem();
	}-*/;

	
	
}
