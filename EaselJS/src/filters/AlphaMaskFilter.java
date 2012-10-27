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


package com.sinewavemultimedia.easeljs.framework.js.filters;

import com.google.gwt.user.client.Element;
import com.sinewavemultimedia.easeljs.framework.js.Canvas2DJS;
import com.sinewavemultimedia.easeljs.framework.js.Image;

/*A class the represents AlphaMaskFilter.js
* author: James Tyner 
*/
public class AlphaMaskFilter extends Filter {
	
	protected AlphaMaskFilter(){}
	
	public final native static AlphaMaskFilter create(Image image)/*-{
		return new $wnd.createjs.AlphaMaskFilter(image);
	}-*/;
	
	/**
	 * Applies the filter to the specified context. IMPORTANT NOTE: This filter currently does not support the targetCtx,
	 * or targetX/Y parameters correctly.
	 * @method applyFilter
	 * @param ctx The 2D context to use as the source.
	 * @param x The x position to use for the source rect.
	 * @param y The y position to use for the source rect.
	 * @param width The width to use for the source rect.
	 * @param height The height to use for the source rect.
	 * @param targetCtx Optional. The 2D context to draw the result to. Defaults to the context passed to ctx.
	 * @param targetX Optional. The x position to draw the result to. Defaults to the value passed to x.
	 * @param targetY Optional. The y position to draw the result to. Defaults to the value passed to y.
	 **/	
	public final native boolean applyAlphaMaskFilter(Canvas2DJS ctx,int x,int y,int width,int height,Canvas2DJS targetCtx,int targetX,int targetY) /*-{
		return this.getBounds(ctx, x, y, width, height, targetCtx, targetX, targetY);
	}-*/;
	
	/**
	 * The image (or canvas) to use as the mask.
	 * @property mask
	 * @type Image
	 **/	
	public final native void setMask(Image mask)/*-{
		this.mask = mask;
	}-*/;
	
	public final native Image getMask()/*-{
		return this.mask;
	}-*/;
}
