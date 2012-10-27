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

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.google.gwt.core.client.JavaScriptObject;
import com.sinewavemultimedia.easeljs.framework.js.Canvas2DJS;

/*A class the represents DOMElement.js
* author: James Tyner 
*/

public class DOMElement extends JavaScriptObject {

	protected DOMElement(){}
	
	/*
	 * Method for creating instance.
	 */
	public final native static DomElement create(String htmlId)/*-{
		return new $wnd.createjs.DOMElement(htmlId);
	}-*/;
	
	/*
	 * Sets the visibility of the DOMElement
	 */
	public final native boolean isVisible()/*-{
		return this.isVisible();
	}-*/;

	/**
	 * Draws the display object into the specified context ignoring it's visible, alpha, shadow, and transform.
	 * Returns true if the draw was handled (useful for overriding functionality).
	 * NOTE: This method is mainly for internal use, though it may be useful for advanced uses.
	 * @method draw
	 * @param {CanvasRenderingContext2D} ctx The canvas 2D context object to draw into.
	 * @param {Boolean} ignoreCache Indicates whether the draw operation should ignore any current cache.
	 * For example, used for drawing the cache (to prevent it from simply drawing an existing cache back
	 * into itself).
	 **/	
	public final native boolean draw(Canvas2DJS object,boolean ignoreCache)/*-{
		return this.draw(object,ignoreCache);
	}-*/;

	public final native DOMElement clone() /*-{
		return this.clone();
	}-*/;

}
