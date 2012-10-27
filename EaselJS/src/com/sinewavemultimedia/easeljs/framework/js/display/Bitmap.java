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
import com.google.gwt.user.client.Element;
import com.sinewavemultimedia.easeljs.framework.js.Canvas2DJS;
import com.sinewavemultimedia.easeljs.framework.js.Image;
import com.sinewavemultimedia.easeljs.framework.js.geom.Rectangle;

/*A class that represents Bitmap.js
* author: James Tyner 
*/
public class Bitmap extends DisplayObject {
	
	protected Bitmap(){}
	
	/*
	 * Retuns the Image of the Bitmap 
	 */
	public final native Image getImage()/*-{
		return this.image;
	}-*/;

	/*
	 * Sets the Image of the Bitmap
	 */
	public final native Image setImage(Image image)/*-{
		this.image = image;
	}-*/;	
	
	/*
	 * Returns the Source Rectangle of the Bitmap
	 */
	public final native Rectangle getSourceRect()/*-{
		return this.sourceRect;
	}-*/;
	
	/*
	 * Sets the Source Rectangle of the Bitmap
	 */	
	public final native void setSourceRect(Rectangle sourceRect)/*-{
		this.sourceRect = sourceRect;
	}-*/;		
			
	/*
	 * Create a bitmap using the Image object
	 */
	public final static native Bitmap create(Image object)/*-{
		return new $wnd.createjs.Bitmap(object);
	}-*/;
	
	/*
	 * Method used for creating instance. The parameter is mostly Image object.
	 */
	public final static native Bitmap create(JavaScriptObject object)/*-{
		return new $wnd.createjs.Bitmap(object);
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
	
	/*
	 * Returns the scale of the bitmap
	 */
	public final native double getScale()/*-{
		return this.scale;
	}-*/;	
	
	/*
	 * Sets the scale of the bitmap.
	 */
	public final native void setScale(double scale)/*-{
		this.scale = scale;
	}-*/;	
}
