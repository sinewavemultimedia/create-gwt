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
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.Property;
import com.sinewavemultimedia.easeljs.framework.js.Manifest;

/*A  class that represents PreloadJS.js
* author: James Tyner 
*/
public class PreloadJS extends AbstractLoader {

	protected PreloadJS(){}

	public static final native String IMAGE()/*-{
		return $wnd.createjs.PreloadJS.IMAGE;
	}-*/;
	
	public static final native void IMAGE(String image)/*-{
		$wnd.createjs.PreloadJS.IMAGE =image;
	}-*/;	
	
	public static final native String SVG()/*-{
		return $wnd.createjs.PreloadJS.SVG;
	}-*/;
	
	public static final native void SVG(String svg)/*-{
		$wnd.createjs.PreloadJS.SVG =svg;
	}-*/;	
	
	public static final native String SOUND()/*-{
		return $wnd.createjs.PreloadJS.SOUND;
	}-*/;
	
	public static final native void SOUND(String sound)/*-{
		$wnd.createjs.PreloadJS.SOUND =sound;
	}-*/;
	
	public static final native String JSON()/*-{
		return $wnd.createjs.PreloadJS.JSON;
	}-*/;
	
	public static final native void JSON(String json)/*-{
		$wnd.createjs.PreloadJS.JSON =json;
	}-*/;	
	
	public static final native String JAVASCRIPT()/*-{
		return $wnd.createjs.PreloadJS.JAVASCRIPT;
	}-*/;
	
	public static final native void JAVASCRIPT(String javascript)/*-{
		$wnd.createjs.PreloadJS.JAVASCRIPT = javascript;
	}-*/;	
	
	public static final native String CSS()/*-{
		return $wnd.createjs.PreloadJS.CSS;
	}-*/;
	
	public static final native void CSS(String css)/*-{
		$wnd.createjs.PreloadJS.CSS=css;
	}-*/;	
	
	public static final native String XML()/*-{
		return $wnd.createjs.PreloadJS.XML;
	}-*/;
	
	public static final native String XML(String xml)/*-{
		$wnd.createjs.PreloadJS.XML = xml;
	}-*/;	
	
	public static final native String TEXT()/*-{
		return $wnd.createjs.PreloadJS.TEXT;
	}-*/;

	public static final native String TEXT(String text)/*-{
		$wnd.createjs.PreloadJS.TEXT =text;
	}-*/;
	
	public static final native int TIMEOUTTIME()/*-{
		return $wnd.createjs.PreloadJS.TIMEOUT_TIME;
	}-*/;
	
	public static final native int TIMEOUTTIME(int timeout)/*-{
		$wnd.createjs.PreloadJS.TIMEOUT_TIME =timeout;
	}-*/;	
	
	/**
	 * PreloadJS provides a consistent way to preload content for use in HTML applications.
	 * @class PreloadJS
	 * @param {Boolean} useXHR2 Determines whether the preload instance will use XHR (XML HTTP Requests), or fall back on tag loading.
	 * @constructor
	 * @extends AbstractLoader
	 */
	public static final native PreloadJS createPreloadJs()/*-{
		return new $wnd.createjs.PreloadJS();
	}-*/;	
	
	public static final native PreloadJS createPreloadJs(boolean useXHR2)/*-{
		return new $wnd.createjs.PreloadJS(useXHR2);
	}-*/;
	
	/**
	 * Use XMLHttpRequest when possible.
	 * @property useXHR
	 * @type Boolean
	 * @default true
	 */	
	public final native void setUseXHR(boolean useXHR)/*-{
		this.useXHR = useXHR;
	}-*/;
	
	public final native boolean getUseXHR()/*-{
		return this.useXHR;
	}-*/;
	
	/**
	 * Stop processing the current queue when an error is encountered.
	 * @property stopOnError
	 * @type Boolean
	 * @default false
	 */	
	public final native void setStopOnError(boolean stopOnError)/*-{
		this.stopOnError = stopOnError;
	}-*/;
	
	public final native boolean getStopOnError()/*-{
		return this.stopOnError;
	}-*/;
	
	/**
	 * Ensure loaded scripts "complete" in the order they are specified.
	 * @property maintainScriptOrder
	 * @type Boolean
	 * @default true
	 */	
	public final native void setMaintainScriptOrder(boolean maintainScriptOrder)/*-{
		this.maintainScriptOrder = maintainScriptOrder;
	}-*/;
	
	public final native boolean getMaintainScriptOrder()/*-{
		return this.maintainScriptOrder;
	}-*/;
	
	/**
	 * The next preload queue to process when this one is complete.
	 * @property next
	 * @type PreloadJS
	 * @default null
	 */	
	public final native void setNext(PreloadJS preloadJS)/*-{
		this.preloadJS = preloadJS;
	}-*/;
	
	public final native PreloadJS getNext()/*-{
		return this.preloadJS;
	}-*/;
	
	/**
	 * Register a plugin. Plugins can map to both load types (sound, image, etc), or can map to specific
	 * extensions (png, mp3, etc). Only one plugin can currently exist per suffix/type.
	 * Plugins must return an object containing:
	 *  * callback: The function to call
	 *  * types: An array of types to handle
	 *  * extensions: An array of extensions to handle. This is overriden by type handlers
	 * @method installPlugin
	 * @param {Function} plugin The plugin to install
	 */	
	public final native void installPlugin(JavaScriptObject javaScriptObject)/*-{
		this.installPlugin(javaScriptObject);
	}-*/;
	
	/**
	 * Set the maximum number of concurrent connections.
	 * @method setMaxConnections
	 * @param {Number} value The number of concurrent loads to allow. By default, only a single connection is open at any time.
	 * Note that browsers and servers may have a built-in maximum number of open connections
	 */	
	public final native void setMaxConnections(double value)/*-{
		this.setMaxConnections(value);
	}-*/;

	/**
	 * Load a single file. Note that calling loadFile appends to the current queue, so it can be used multiple times to
	 * add files. Use <b>loadManifest()</b> to add multiple files at onces. To clear the queue first use the <b>close()</b> method.
	 * @method loadFile
	 * @param {Object | String} file The file object or path to load. A file can be either
     * <ol>
     *     <li>a path to a resource (string). Note that this kind of load item will be
     *     converted to an object (next item) in the background.</li>
     *     <li>OR an object that contains:<ul>
     *         <li>src: The source of the file that is being loaded. This property is <b>required</b>. The source can either be a string (recommended), or an HTML tag.</li>
     *         <li>type: The type of file that will be loaded (image, sound, json, etc).
     *         PreloadJS does auto-detection of types using the extension. Supported types are defined on PreloadJS, such as PreloadJS.IMAGE.
	 *         It is recommended that a type is specified when a non-standard file URI (such as a php script) us used.</li>
     *         <li>id: A string indentifier which can be used to reference the loaded object.</li>
     *         <li>data: An arbitrary data object, which is included with the loaded object</li>
     *     </ul>
     * </ol>
	 * @param {Boolean} loadNow Kick off an immediate load (true) or wait for a load call (false). The default value is true. If the queue is paused, and this value
	 * is true, the queue will resume.
	 */	
	public final native void loadFile(String file,boolean loadNow)/*-{
		this.loadFile(file,loadNow);
	}-*/;
	
	public final native void loadFile(Manifest file,boolean loadNow)/*-{
		this.loadFile(file,loadNow);
	}-*/;

	/**
	 * Load a manifest. This is a shortcut method to load a group of files. To load a single file, use the loadFile method.
	 * Note that calling loadManifest appends to the current queue, so it can be used multiple times to add files. To clear
	 * the queue first, use the <b>close()</b> method.
	 * @method loadManifest
	 * @param {Array} manifest The list of files to load. Each file can be either
	 * <ol>
	 *     <li>a path to a resource (string). Note that this kind of load item will be
	 *     converted to an object (next item) in the background.</li>
	 *     <li>OR an object that contains:<ul>
	 *         <li>src: The source of the file that is being loaded. This property is <b>required</b>.
	 *         The source can either be a string (recommended), or an HTML tag. </li>
	 *         <li>type: The type of file that will be loaded (image, sound, json, etc).
	 *         PreloadJS does auto-detection of types using the extension. Supported types are defined on PreloadJS, such as PreloadJS.IMAGE.
	 *         It is recommended that a type is specified when a non-standard file URI (such as a php script) us used.</li>
	 *         <li>id: A string indentifier which can be used to reference the loaded object.</li>
	 *         <li>data: An arbitrary data object, which is included with the loaded object</li>
	 *     </ul>
	 * </ol>
	 * @param {Boolean} loadNow Kick off an immediate load (true) or wait for a load call (false). The default value is true. If the queue is paused, and this value
	 * is true, the queue will resume.
	 */	
	public final native void loadManifest(JsArray<Manifest> manifest,boolean loadNow)/*-{
		this.loadManifest(manifest,loadNow);
	}-*/;
	
	public final native void loadManifest(JsArray<Manifest> manifest)/*-{
		this.loadManifest(manifest);
	}-*/;	
	
	/**
	 * Begin loading the queued items.
	 * @method load
	 */	
	public final native void load()/*-{
		this.load();
	}-*/;
	
	/**
	 * Lookup a loaded item using either the "id" or "src" that was specified when loading it.
	 * @method getResult
	 * @param {String} value The "id" or "src" of the loaded item.
	 * @return {Object} A result object containing the contents of the object that was initially requested using loadFile or loadManifest, including:
     * <ol>
     *     <li>src: The source of the file that was requested.</li>
     *     <li>type: The type of file that was loaded. If it was not specified, this is auto-detected by PreloadJS using the file extension.</li>
     *     <li>id: The id of the loaded object. If it was not specified, the ID will be the same as the "src" property.</li>
     *     <li>data: Any arbitrary data that was specified, otherwise it will be undefined.
	 *     <li>result: The loaded object. PreloadJS provides usable tag elements when possible:<ul>
	 *          <li>An HTMLImageElement tag (&lt;image /&gt;) for images</li>
	 *          <li>An HTMLAudioElement tag (&lt;audio &gt;) for audio</li>
	 *          <li>A script tag for JavaScript (&lt;script&gt;&lt;/script&gt;)</li>
	 *          <li>A style tag for CSS (&lt;style&gt;&lt;/style&gt;)</li>
	 *          <li>Raw text for JSON or any other kind of loaded item</li>
	 *     </ul></li>
     * </ol>
     * This object is also returned via the "onFileLoad" callback, although a "target" will be included, which is a reference to the PreloadJS instance.
	 */	
	public final native Property getResult(String value)/*-{
		return this.getResult(value);
	}-*/; 
	
	/**
	 * Pause or resume the current load. The active item will not cancel, but the next
	 * items in the queue will not be processed.
	 * @method setPaused
	 * @param {Boolean} value Whether the queue should be paused or not.
	 */	
	public final native void setPaused(boolean value)/*-{
		this.setPaused(value);
	}-*/;
	
	public final native void close()/*-{
		this.close();
	}-*/;

}
