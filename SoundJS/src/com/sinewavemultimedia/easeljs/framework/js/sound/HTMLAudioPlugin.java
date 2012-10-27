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

/*A  class that represents HTMLAudioPlugin.js
* author: James Tyner 
*/

public class HTMLAudioPlugin extends Plugin {

	protected HTMLAudioPlugin(){}
	
	/**
	 * Play sounds using HTML <audio> tags in the browser.
	 * @class HTMLAudioPlugin
	 * @constructor
	 */	
	public static final native HTMLAudioPlugin create()/*-{
		return $wnd.createjs.HTMLAudioPlugin();
	}-*/; 
	
	public static final native HTMLAudioPlugin plugin()/*-{
		return $wnd.createjs.HTMLAudioPlugin;
	}-*/;
	
	public static final native int maxInstances()/*-{
		return $wnd.createjs.HTMLAudioPlugin.MAX_INSTANCES;
	}-*/;
	
	public static final native void setMaxInstances(int n)/*-{
		$wnd.createjs.HTMLAudioPlugin.MAX_INSTANCES = n;
	}-*/;
	
	/**
	 * The capabilities of the plugin.
	 * @property capabilities
	 * @type Object
	 * @default null
	 * @static
	 */	
	public final static native void setCapabilities(JavaScriptObject capabilities)/*-{
		$wnd.createjs.HTMLAudioPlugin.capabilities = capabilities;
	}-*/;
	
	public final static native JavaScriptObject getCapabilities()/*-{
		return $wnd.createjs.HTMLAudioPlugin.capabilities;
	}-*/;	
	
	
	/**
	 * Determine if the plugin can be used.
	 * @method isSupported
	 * @return {Boolean} If the plugin can be initialized.
	 * @static
	 */	
	public final static native boolean isSupported()/*-{
		return $wnd.createjs.HTMLAudioPlugin.isSupported();
	}-*/;
	
	/**
	 * Determine the capabilities of the plugin.
	 * @method generateCapabiities
	 * @static
	 */	
	public final static native void generateCapabilities()/*-{
		$wnd.createjs.HTMLAudioPlugin.generateCapabilities();
	}-*/;	
	
	/*
	 * Init method for initializing the FlashPlugin
	 */
	public final native void init()/*-{
		$wnd.createjs.HTMLAudioPlugin.init();
	}-*/;
	
	
	/**
	 * Pre-register a sound instance when preloading/setup.
	 * Note that the FlashPlugin will return a SoundLoader instance for preloading
	 * since Flash can not access the browser cache consistently.
	 * @method register
	 * @param {String} src The source of the audio
	 * @param {Number} instances The number of concurrently playing instances to allow for the channel at any time.
	 * @return {Object} A result object, containing a tag for preloading purposes.
	 */	
	public final native JavaScriptObject register(String src,double instances)/*-{
		return this.register(src,instances);
	}-*/;
	
	/**
	 * Create a sound instance.
	 * @method create
	 * @param {String} src The source to use.
	 * @return {SoundInstance} A sound instance for playback and control.
	 */	
	public final native SoundInstance create(String src)/*-{
		return this.create(src);
	}-*/;
	
	/**
	 * Create a sound instance.
	 * @method create
	 * @param {String} src The source to use.
	 * @return {Audio } Tag A sound instance for playback and control.
	 */	
	public final native JavaScriptObject createTag(String src)/*-{
		return this.createTag(src);
	}-*/;
	
	
}
