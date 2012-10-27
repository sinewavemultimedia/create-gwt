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

package com.sinewavemultimedia.easeljs.framework.js.tween;

import com.google.gwt.core.client.JavaScriptObject;

/*A  class that represents CSSPlugin.js
* author: James Tyner 
*/

public class CSSPlugin extends JavaScriptObject {

	protected CSSPlugin(){}
	
	/**
	 * A TweenJS plugin for working with numeric CSS string properties (ex. top, left). To use simply call
	 * CSSPlugin.install() after TweenJS has loaded. You can adjust the CSS properties it will work with by
	 * modifying the cssSuffixMap property.
	 * @class CSSPlugin
	 * @constructor
	 **/
	public static final native JavaScriptObject cssSuffixMap()/*-{
		return {top:"px",left:"px",bottom:"px",right:"px",width:"px",height:"px",opacity:""};
	}-*/;
	
	/**
	 * Used by TweenJS to determine when to call this plugin.
	 * @property priority
	 * @protected
	 * @static
	 **/	
	public static final native int priority()/*-{
		return $wnd.createjs.CSSPlugin.priority;
	}-*/;
	
	public static final native void priority(int priority)/*-{
		$wnd.createjs.CSSPlugin.priority = priority;
	}-*/;
	
	/**
	 * Installs this plugin for use with TweenJS. Call this once, after TweenJS is loaded to enable this plugin.
	 * @method install
	 * @static
	 **/	
	public static final native void install()/*-{
		$wnd.createjs.CSSPlugin.install();
	}-*/;
	
	
	
}
