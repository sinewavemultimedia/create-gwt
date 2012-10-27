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


package com.sinewavemultimedia.easeljs.framework.js.utils;

import com.google.gwt.core.client.JavaScriptObject;
import com.sinewavemultimedia.easeljs.framework.js.Canvas;
import com.sinewavemultimedia.easeljs.framework.js.Image;
import com.sinewavemultimedia.easeljs.framework.js.display.SpriteSheet;

/*A class the represents SpriteSheetUtils.js
* author: James Tyner 
*/
public class SpriteSheetUtils extends JavaScriptObject {
	
	protected SpriteSheetUtils(){}

	/**
	 * <b>This is an experimental method, and is likely to be buggy. Please report issues.</b><br/><br/>
	 * Extends the existing sprite sheet by flipping the original frames either horizontally, vertically, or both,
	 * and adding appropriate animation & frame data.
	 * @method flip
	 * @static
	 * @param {Image} spriteSheet The sprite sheet to use as the source.
	 * @param {Object} flipData A generic object that specifies which frames will be flipped, what to name the
	 * flipped result, and how to flip the frames (horizontally, vertically, or both). Each property name
	 * indicates the name of a new sequence to create, and should reference an array where the first index is
	 * the name of the original sequence to flip, the second index indicates whether to flip it horizontally,
	 * the third index indicates whether to flip it vertically, and the fourth indicates what the "next" value
	 * for the resulting frame data should be. For example, the following would create a new sequence named
	 * "walk_left" consisting of the frames from the original "walk_right" sequence flipped
	 * horizontally: &#123;walk_left: ["walk_right", true, false]&#125;
	 **/	
	public native static void addFlippedFrames(SpriteSheet sheet,boolean horizontal, boolean vertical,boolean both ) /*-{
		$wnd.createjs.SpriteSheetUtils.addFlippedFrames(sheet,horizontal,vertical,both);
	}-*/;
	
	/**
	 * Returns a single frame of the specified sprite sheet as a new PNG image.
	 * @method extractFrame
	 * @static
	 * @param {Image} spriteSheet The SpriteSheet instance to extract a frame from.
	 * @param {Number} frame The frame number or animation name to extract. If an animation
	 * name is specified, only the first frame of the animation will be extracted.
	 * @return {Image} a single frame of the specified sprite sheet as a new PNG image.
	*/	
	public native static Image extractFrame(SpriteSheet sheet,int number) /*-{
		return $wnd.createjs.SpriteSheetUtils.extractFrame(sheet,number);
	}-*/;
	
	public native static Image extractFrame(SpriteSheet sheet,String frame) /*-{
		return $wnd.createjs.SpriteSheetUtils.extractFrame(sheet,frame);
	}-*/;
	
	
	/**
	 * Merges the rgb channels of one image with the alpha channel of another. This can be used to combine a compressed
	 * JPEG image containing color data with a PNG32 monochromatic image containing alpha data. With certain types of
	 * images (those with detail that lend itself to JPEG compression) this can provide significant file size savings
	 * versus a single RGBA PNG32. This method is very fast (generally on the order of 1-2 ms to run).
	 * @method mergeAlpha
	 * @static
	 * @param {Image} rbgImage The image (or canvas) containing the RGB channels to use.
	 * @param {Image} alphaImage The image (or canvas) containing the alpha channel to use.
	 * @param {Canvas} canvas Optional. If specified, this canvas will be used and returned. If not, a new canvas will be created.
	 * @return {Canvas} A canvas with the combined image data. This can be used as a source for Bitmap or SpriteSheet.
	*/	
	public native static Canvas mergeAlpha(Image rgbImage,Image alphaImage,Canvas canvas)/*-{
		return $wnd.createjs.SpriteSheetUtils.mergeAlpha(rgbImage,alphaImage,canvas);
	}-*/;

}
