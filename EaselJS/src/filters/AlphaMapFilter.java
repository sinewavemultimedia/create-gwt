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

/*A class the represents AlphaMapFilter.js
* author: James Tyner 
*/

public class AlphaMapFilter extends Filter {
	
	protected AlphaMapFilter(){}
	
	/**
	 * The greyscale image (or canvas) to use as the alpha value for the result. This should be exactly the same
	  * dimensions as the target.
	 * @property alphaMap
	 * @type Image
	 **/	
	public final native void setAlphaMap(Element alphaMap)/*-{
		this.alphaMap = alphaMap;
	}-*/;
	
	public final native Element getAlphaMap()/*-{
		return this.alphaMap;
	}-*/;

	/**
	 * Applies a greyscale alpha map image (or canvas) to the target, such that the alpha channel of the result will
	 * be copied from the red channel of the map, and the RGB channels will be copied from the target.
	 * <br/><br/>
	 * Generally, it is recommended that you use AlphaMaskFilter, because it has much better performance.
	 * @class AlphaMapFilter
	 * @augments Filter
	 * @constructor
	 * @param {Image} alphaMap The greyscale image (or canvas) to use as the alpha value for the result. This should be exactly the same
	 * dimensions as the target.
	 **/	
	public final native static AlphaMapFilter create(Image image)/*-{
		return new $wnd.createjs.AlphaMapFilter(image);
	}-*/;
	
	/**
	 * Applies the filter to the specified context.
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
	public  final native boolean applyAlphaFilter(Canvas2DJS ctx,int x,int y,int width,int height,Canvas2DJS targetCtx,int targetX,int targetY) /*-{
		return this.getBounds(ctx, x, y, width, height, targetCtx, targetX, targetY);
	}-*/;
	
}
