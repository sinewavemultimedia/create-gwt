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

/*A  class that represents FlashPlugin.js
* author: James Tyner 
*/
public class FlashPlugin extends Plugin {

	protected FlashPlugin(){}
	
	public static final native String BASE_PATH()/*-{
		return $wnd.createjs.FlashPlugin.BASE_PATH;
	}-*/;
	
	public static final native void BASE_PATH(String BASE_PATH)/*-{
		$wnd.createjs.FlashPlugin.BASE_PATH = BASE_PATH;
	}-*/;	

	/**
	 * Play sounds using a Flash instance. This plugin requires swfObject.as
	 * as well as the FlashAudioPlugin.swf. Ensure that FlashPlugin.BASE_PATH
	 * is set when using this plugin, so that the script can find the swf.
	 * @class FlashPlugin
	 * @constructor
	 */	
	public final static  native FlashPlugin create()/*-{
		return new $wnd.createjs.FlashPlugin();
	}-*/;
	
	public final static  native FlashPlugin plugin()/*-{
		return new $wnd.createjs.FlashPlugin;
	}-*/;

	/**
	 * The capabilities of the plugin.
	 * @property capabilities
	 * @type Object
	 * @default null
	 * @static
	 */	
	public final static native void setCapabilities(JavaScriptObject capabilities)/*-{
		$wnd.createjs.FlashPlugin.capabilities = capabilities;
	}-*/;
	
	public final static native JavaScriptObject getCapabilities()/*-{
		return $wnd.createjs.FlashPlugin.capabilities;
	}-*/;	

	public final static native void setLastId(double lastId)/*-{
		$wnd.createjs.FlashPlugin.lastId = lastId;
	}-*/;
	
	public final static native double getLastId()/*-{
		return $wnd.createjs.FlashPlugin.lastId;
	}-*/;	
	
	/**
	 * Determine if the plugin can be used.
	 * @method isSupported
	 * @return {Boolean} If the plugin can be initialized.
	 * @static
	 */	
	public final static native boolean isSupported()/*-{
		return $wnd.createjs.FlashPlugin.isSupported();
	}-*/;
	
	/**
	 * Determine the capabilities of the plugin.
	 * @method generateCapabiities
	 * @static
	 */	
	public final static native void generateCapabilities()/*-{
		$wnd.createjs.FlashPlugin.generateCapabilities();
	}-*/;	
	
	/*
	 * Init method for initializing the FlashPlugin
	 */
	public final native void init()/*-{
		$wnd.createjs.FlashPlugin.init();
	}-*/;
	
	/**
	 * A developer flag to output all flash events to the console.
	 * @property showOutput
	 * @type Boolean
	 * @default false
	 */	
	public final native boolean isShowOutput()/*-{
		return $wnd.createjs.FlashPlugin.showOutput;
	}-*/;	

	public final native boolean setShowOutput(boolean showOutput)/*-{
		$wnd.createjs.FlashPlugin.showOutput = showOutput;
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
}
