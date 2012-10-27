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

import com.sinewavemultimedia.easeljs.framework.js.Canvas2DJS;
import com.sinewavemultimedia.easeljs.framework.js.geom.Rectangle;

/*A class the represents BoxBlurFilter.js
* author: James Tyner 
*/
public class BoxBlurFilter extends Filter {
	
	protected BoxBlurFilter(){}
	
	/**
	 * Horizontal blur radius
	 * @property blurX
	 * @type Number
	 **/	
	public final native void setBlurX(int blurX)/*-{
		this.blurX = blurX;
	}-*/;
	
	public final native int getBlurX()/*-{
		return this.blurX;
	}-*/;	
	
	/**
	 * Number of blur iterations. For example, a value of 1 will produce a rough blur.
	 * A value of 2 will produce a smoother blur, but take twice as long to run.
	 * @property quality
	 * @type Number
	 **/	
	public final native void setQuality(int quality)/*-{
		this.quality = quality;
	}-*/;
	
	public final native int getQuality()/*-{
		return this.quality;
	}-*/;	
	
	/**
	 * Vertical blur radius
	 * @property blurY
	 * @type Number
	 **/	
	public final native void setBlurY(int blurY)/*-{
		this.blurY = blurY;
	}-*/;
	
	public final native int getBlurY()/*-{
		return this.blurY;
	}-*/;	
	
	/*
	 * Create a instance of BoxBlurFilter
	 */
	public final native static BoxBlurFilter create(int blurX,int blurY,int quality)/*-{
		return new $wnd.createjs.BoxBlurFilter(blurX,blurY,quality);
	}-*/;
	
	/**
	 * Returns a rectangle with values indicating the margins required to draw the filter.
	 * For example, a filter that will extend the drawing area 4 pixels to the left, and 7 pixels to the right
	 * (but no pixels up or down) would return a rectangle with (x=-4, y=0, width=11, height=0).
	 * @method getBounds
	 * @return {Rectangle} a rectangle object indicating the margins required to draw the filter.
	 **/	
	public final native Rectangle getRectBounds() /*-{
		return this.getBounds();
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
	public final native boolean applyRectFilter(Canvas2DJS ctx,int x,int y,int width,int height,Canvas2DJS targetCtx,int targetX, int targetY)/*-{
		return this.applyFilter(ctx, x, y, width, height, targetCtx, targetX, targetY);
	}-*/;
	
}