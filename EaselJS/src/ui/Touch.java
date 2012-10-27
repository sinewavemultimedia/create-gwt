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



package com.sinewavemultimedia.easeljs.framework.js.ui;

import com.google.gwt.core.client.JavaScriptObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;

/*A class the represents Touch.js
* author: James Tyner 
*/
public class Touch extends JavaScriptObject {
	
	protected Touch(){}
	
	/**
	 * Returns true if touch is supported in the current browser.
	 * @method isSupported
	 * @return {Boolean} A boolean indicating whether touch is supported in the current browser.
	 * @static
	 **/	
	public final native static boolean isSupported() /*-{
		return $wnd.createjs.Touch.isSupported();
	}-*/;
	

	public final native static boolean enable(Stage stage) /*-{
		return $wnd.createjs.Touch.enable(stage);
	}-*/;
	/**
	 * Enables touch interaction for the specified EaselJS stage. Currently supports iOS (and compatible browsers, such
	 * as modern Android browsers), and IE10.
	 * Supports both single touch and multi-touch modes. Extends the EaselJS MouseEvent model, but without support for
	 * double click or over/out events. See MouseEvent.pointerID for more information.
	 * @method enable
	 * @param {Stage} stage The stage to enable touch on.
	 * @param {Boolean} singleTouch If true, only a single touch will be active at a time. Default is false.
	 * @param {Boolean} allowDefault If true, then default gesture actions (ex. scrolling, zooming) will be allowed when the user is interacting with the target canvas. Default is false.
	 * @return {Boolean} Returns true if touch was successfully enabled on the target stage.
	 * @static
	 **/
	public final native static boolean enable(Stage stage,boolean singleTouch,boolean allowDefault) /*-{
		return $wnd.createjs.Touch.enable(stage, singleTouch, allowDefault);
	}-*/;
	
	/**
	 * Removes all listeners that were set up when calling Touch.enable on a stage.
	 * @method disable
	 * @param {Stage} stage The stage to disable touch on.
	 * @static
	 **/	
	public final native static void disable(Stage stage) /*-{
		$wnd.createjs.Touch.disable(stage);
	}-*/;	

}
