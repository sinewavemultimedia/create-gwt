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

/*A class the represents ColorFilter.js
* author: James Tyner 
*/
public class ColorFilter extends Filter {
	
	protected ColorFilter(){}

	/**
	* Applies color transforms.
	* @class ColorFilter
	* @constructor
	* @augments Filter
	* @param {Number} redMultiplier
	* @param {Number} greenMultiplier
	* @param {Number} blueMultiplier
	* @param {Number} alphaMultiplier
	* @param {Number} redOffset
	* @param {Number} greenOffset
	* @param {Number} blueOffset
	* @param {Number} alphaOffset
	**/	
	public final native static ColorFilter create(int redMultiplier,int greenMultiplier,int blueMultiplier,int alphaMultiplier) /*-{
		return new $wnd.createjs.ColorFilter(redMultiplier, greenMultiplier, blueMultiplier, alphaMultiplier);
	}-*/;
	
	public final native static ColorFilter create(int redMultiplier,int greenMultiplier,int blueMultiplier,int alphaMultiplier,int redOffset,int greenOffset,int blueOffset,int alphaOffset) /*-{
		return new $wnd.createjs.ColorFilter(redMultiplier, greenMultiplier, blueMultiplier, alphaMultiplier, redOffset, greenOffset, blueOffset, alphaOffset);
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
	public final native boolean applyColorFilter(Canvas2DJS ctx,int x,int y,int width,int height,Canvas2DJS targetCtx,int targetX, int targetY)/*-{
		return this.applyFilter(ctx, x, y, width, height, targetCtx, targetX, targetY);
	}-*/;

	/**
	 * Red channel multiplier.
	 * @property redMultiplier
	 * @type Number
	 **/	
	public final native void setRedMultiplier(int redMultiplier)/*-{
		this.redMultiplier = redMultiplier;
	}-*/;
	
	public final native int getRedMultiplier()/*-{
		return this.redMultiplier;
	}-*/;
	
	/** 
	 * Green channel multiplier.
	 * @property greenMultiplier
	 * @type Number
	 **/	
	public final native void setGreenMultiplier(int greenMultiplier)/*-{
		this.greenMultiplier = greenMultiplier;
	}-*/;
	
	public final native int getGreenMultiplier()/*-{
		return this.greenMultiplier;
	}-*/;
	
	/**
	 * Blue channel multiplier.
	 * @property blueMultiplier
	 * @type Number
	 **/	
	public final native void setBlueMultiplier(int blueMultiplier)/*-{
		this.blueMultiplier = blueMultiplier;
	}-*/;
	
	public final native int getBlueMultiplier()/*-{
		return this.blueMultiplier;
	}-*/;
	
	/**
	 * Alpha channel multiplier.
	 * @property redMultiplier
	 * @type Number
	 **/	
	public final native void setAlphaMultiplier(int alphaMultiplier)/*-{
		this.alphaMultiplier = alphaMultiplier;
	}-*/;
	
	public final native int getAlphaMultiplier()/*-{
		return this.alphaMultiplier;
	}-*/;	
	
	/**
	 * Red channel offset (added to value).
	 * @property redOffset
	 * @type Number
	 **/	
	public final native void setRedOffset(int redOffset)/*-{
		this.redOffset = redOffset;
	}-*/;
	
	public final native int getRedOffset()/*-{
		return this.redOffset;
	}-*/;

	/**
	 * Green channel offset (added to value).
	 * @property greenOffset
	 * @type Number
	 **/
	public final native void setGreenOffset(int greenOffset)/*-{
		this.greenOffset = greenOffset;
	}-*/;
	
	public final native int getGreenOffset()/*-{
		return this.greenOffset;
	}-*/;
		
	/**
	 * Blue channel offset (added to value).
	 * @property blueOffset
	 * @type Number
	 **/
	public final native void setBlueOffset(int blueOffset)/*-{
		this.blueOffset = blueOffset;
	}-*/;
	
	public final native int getBlueOffset()/*-{
		return this.blueOffset;
	}-*/;

	/**
	 * Alpha channel offset (added to value).
	 * @property alphaOffset
	 * @type Number
	 **/
	public final native void setAlphaOffset(int alphaOffset)/*-{
		this.alphaOffset = alphaOffset;
	}-*/;
	
	public final native int getAlphaOffset()/*-{
		return this.alphaOffset;
	}-*/;
}
