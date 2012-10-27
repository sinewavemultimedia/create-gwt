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

import com.google.gwt.core.client.JavaScriptObject;

/*A class the represents ColorMatrix.js
* author: James Tyner 
*/
public class ColorMatrix extends JavaScriptObject {
	
	public static double[]  DELTA_INDEX={0, 0.01, 0.02, 0.04, 0.05, 0.06, 0.07, 0.08, 0.1,  0.11,
			0.12, 0.14, 0.15, 0.16, 0.17, 0.18, 0.20, 0.21, 0.22, 0.24,
			0.25, 0.27, 0.28, 0.30, 0.32, 0.34, 0.36, 0.38, 0.40, 0.42,
			0.44, 0.46, 0.48, 0.5,  0.53, 0.56, 0.59, 0.62, 0.65, 0.68, 
			0.71, 0.74, 0.77, 0.80, 0.83, 0.86, 0.89, 0.92, 0.95, 0.98,
			1.0,  1.06, 1.12, 1.18, 1.24, 1.30, 1.36, 1.42, 1.48, 1.54,
			1.60, 1.66, 1.72, 1.78, 1.84, 1.90, 1.96, 2.0,  2.12, 2.25, 
			2.37, 2.50, 2.62, 2.75, 2.87, 3.0,  3.2,  3.4,  3.6,  3.8,
			4.0,  4.3,  4.7,  4.9,  5.0,  5.5,  6.0,  6.5,  6.8,  7.0,
			7.3,  7.5,  7.8,  8.0,  8.4,  8.7,  9.0,  9.4,  9.6,  9.8, 
			10.0};
	
	public static int[] IDENTITY_MATRIX={
	                             		1,0,0,0,0,
	                            		0,1,0,0,0,
	                            		0,0,1,0,0,
	                            		0,0,0,1,0,
	                            		0,0,0,0,1
	};
	
	protected ColorMatrix(){}
	
	/**
	* Allows you to carry out complex color operations such as modifying saturation, brightness, or inverting.
	* @class ColorMatrixFilter
	* @constructor
	* @augments Filter
	* @param matrix A 4x5 matrix describing the color operation to perform. See also the ColorMatrix class.
	**/	
	public final native static ColorMatrix create(double brightness,double contrast,double saturation,double hue) /*-{
		return new $wnd.createjs.ColorMatrix(brightness,contrast,saturation,hue);
	}-*/;
	
	public final native static ColorMatrix create() /*-{
		return new $wnd.createjs.ColorMatrix();
	}-*/;	
	
	/**
	 * Resets the matrix to identity values.
	 * @method reset
	 * @return {ColorMatrix} The ColorMatrix instance the method is called on (useful for chaining calls.)
	 */
	public  final native void reset()/*-{
		this.reset();
	}-*/;
	
	/**
	 * Shortcut method to adjust brightness, contrast, saturation and hue.
	 * Equivalent to calling adjustHue(hue), adjustContrast(contrast),
	 * adjustBrightness(brightness), adjustSaturation(saturation), in that order.
	 * @param {Number} brightness
	 * @param {Number} contrast
	 * @param {Number} saturation
	 * @param {Number} hue
	 * @return {ColorMatrix} The ColorMatrix instance the method is called on (useful for chaining calls.)
	 **/	
	public  final  native ColorMatrix adjustColor(double brightness,double contrast,double saturation,double hue) /*-{
		return this.adjustColor(brightness,contrast,saturation,hue);
	}-*/;	

	/**
	 * Adjusts the brightness of pixel color by adding the specified value to the red, green and blue channels.
	 * Positive values will make the image brighter, negative values will make it darker.
	 * @param {Number} value A value between -255 & 255 that will be added to the RGB channels.
	 * @return {ColorMatrix} The ColorMatrix instance the method is called on (useful for chaining calls.)
	 **/	
	public final  native ColorMatrix adjustBrightness(double brightness) /*-{
		return this.adjustBrightness(brightness);
	}-*/;
	
	/**
	 * Adjusts the contrast of pixel color.
	 * Positive values will increase contrast, negative values will decrease contrast.
	 * @param {Number} value A value between -100 & 100.
	 * @return {ColorMatrix} The ColorMatrix instance the method is called on (useful for chaining calls.)
	 **/	
	public final  native ColorMatrix adjustContrast(double contrast) /*-{
		return this.adjustContrast(contrast);
	}-*/;	
	
	/**
	 * Adjusts the color saturation of the pixel.
	 * Positive values will increase saturation, negative values will decrease saturation (trend towards greyscale).
	 * @param {Number} value A value between -100 & 100.
	 * @return {ColorMatrix} The ColorMatrix instance the method is called on (useful for chaining calls.)
	 **/	
	public final  native ColorMatrix adjustSaturation(double saturation) /*-{
		return this.adjustSaturation(saturation);
	}-*/;	
	
	/**
	 * Adjusts the hue of the pixel color.
	 * @param {Number} value A value between -180 & 180.
	 * @return {ColorMatrix} The ColorMatrix instance the method is called on (useful for chaining calls.)
	 **/	
	public  final native ColorMatrix adjustHue(double hue) /*-{
		return this.adjustHue(hue);
	}-*/;
	
	/**
	 * Concatenates (multiplies) the specified matrix with this one.
	 * @param {Array} matrix An array or ColorMatrix instance.
	 * @return {ColorMatrix} The ColorMatrix instance the method is called on (useful for chaining calls.)
	 **/	
	public  final native ColorMatrix concat(double[] matrix) /*-{
		return this.concat(matrix);
	}-*/;
	
	/**
	 * Returns a clone of this ColorMatrix.
	 * @return {ColorMatrix} A clone of this ColorMatrix.
	 **/	
	public final  native ColorMatrix clone() /*-{
		return this.clone();
	}-*/;	
	
	/**
	 * Return a length 25 (5x5) array instance containing this matrix's values.
	 * @return {Array} An array holding this matrix's values.
	 **/	
	public final  native double[] toArray() /*-{
		return this.toArray();
	}-*/;
	
	/**
	 * Copy the specified matrix's values to this matrix.
	 * @param {Array} matrix An array or ColorMatrix instance.
	 * @return {ColorMatrix} The ColorMatrix instance the method is called on (useful for chaining calls.)
	 **/	
	public final  native double[] copyMatrix(double[] matrix) /*-{
		return this.copyMatrix(matrix);
	}-*/;	
}
