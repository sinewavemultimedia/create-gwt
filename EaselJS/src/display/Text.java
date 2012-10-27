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
import com.sinewavemultimedia.easeljs.framework.js.Canvas2DJS;

/*A class the represents Text.js
* author: James Tyner 
*/
public class Text extends DisplayObject {
	
	protected Text(){}

	/**
	* Allows you to display one or more lines of dynamic text (not user editable) in the display list.
	* Line wrapping support (using the lineWidth is very basic, wrapping on spaces and tabs only. Note
	* that as an alternative to Text, you can position HTML text above or below the canvas relative to 
	* items in the display list using the localToGlobal() method.
	* @class Text
	* @extends DisplayObject
	* @constructor
	* @param {String} text Optional. The text to display.
	* @param {String} font Optional. The font style to use. Any valid value for the CSS font attribute is 
	* acceptable (ex. "bold 36px Arial").
	* @param {String} color Optional. The color to draw the text in. Any valid value for the CSS color attribute
	* is acceptable (ex. "#F00").
	**/	
	public final native static Text create(String text,String font,String color)/*-{
		return new $wnd.createjs.Text(text,font,color);
	}-*/;
	
	public final native static Text create(String text,String font)/*-{
		return new $wnd.createjs.Text(text,font);
	}-*/;	
	
	/**
	 * Draws the Text into the specified context ignoring it's visible, alpha, shadow, and transform.
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
	
	/**
	 * Returns the measured, untransformed width of the text without wrapping.
	 * @method getMeasuredWidth
	 * @return {Number} The measured, untransformed width of the text.
	 **/	
	public final native int getMeasuredWidth()/*-{
		return this.getMeasuredWidth();
	}-*/;
	
	/**
	 * Returns an approximate line height of the text, ignoring the lineHeight property. This is based 
	 * on the measured width of a "M" character multiplied by 1.2, which approximates em for most fonts.
	 * @method getMeasuredLineHeight
	 * @return {Number} an approximate line height of the text, ignoring the lineHeight property. This is 
	 * based on the measured width of a "M" character multiplied by 1.2, which approximates em for most fonts.
	 **/	
	public final native int getMeasuredLineHeight()/*-{
		return this.getMeasuredLineHeight();
	}-*/;	

	/**
	 * Returns the approximate height of multiline text by multiplying the number of lines against
	 * either the lineHeight (if specified) or getMeasuredLineHeight(). Note that this operation
	 * requires the text flowing logic to run, which has an associated CPU cost.
	 * @method getMeasuredHeight
	 * @return {Number} The approximate height of the drawn multiline text.
	 **/	
	public final native int getMeasuredHeight()/*-{
		return this.getMeasuredHeight();
	}-*/;	
	
	/**
	 * The text to display.
	 * @property text
	 * @type String
	 **/	
	public final native void setText(String text)/*-{
		this.text = text;
	}-*/;
	
	public final native String getText()/*-{
		return this.text;
	}-*/;
	
	/**
	 * The font style to use. Any valid value for the CSS font attribute is acceptable (ex. "bold 36px Arial"). 
	 * @property font
	 * @type String
	 **/	
	public final native void setFont(String font)/*-{
		this.font = font;
	}-*/;
	
	public final native String getFont()/*-{
		return this.font;
	}-*/;	
	
	/**
	 * The color to draw the text in. Any valid value for the CSS color attribute is acceptable (ex. "#F00"). Default is "#000".
	 * @property color
	 * @type String
	 **/
	public final native void setColor(String color)/*-{
		this.color = color;
	}-*/;
	
	public final native String getColor()/*-{
		return this.color;
	}-*/;
	
	/**
	 * The horizontal text alignment. Any of "start", "end", "left", "right", and "center". For detailed 
	 * information view the 
	 * <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#text-styles">
	 * whatwg spec</a>. Default is "left".
	 * @property textAlign
	 * @type String
	 **/	
	public final native void setTextAlign(String textAlign)/*-{
		this.textAlign = textAlign;
	}-*/;
	
	public final native String getTextAlign()/*-{
		return this.textAlign;
	}-*/;	
	
	/** The vertical alignment point on the font. Any of "top", "hanging", "middle", "alphabetic", 
	 * "ideographic", or "bottom". For detailed information view the 
	 * <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#text-styles">
	 * whatwg spec</a>. Default is "top".
	 * @property textBaseline
	 * @type String
	*/	
	public final native void setTextBaseline(String textBaseline)/*-{
		this.textBaseline = textBaseline;
	}-*/;
	
	public final native String getTextBaseline()/*-{
		return this.textBaseline;
	}-*/;	
	
	/** The maximum width to draw the text. If maxWidth is specified (not null), the text will be condensed or 
	 * shrunk to make it fit in this width. For detailed information view the 
	 * <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#text-styles">
	 * whatwg spec</a>.
	 * @property maxWidth
	 * @type Number
	*/
	public final native void setMaxWidth(int maxWidth)/*-{
		this.maxWidth = maxWidth;
	}-*/;
	
	public final native int getMaxWidth()/*-{
		return this.maxWidth;
	}-*/;	
	
	/** If true, the text will be drawn as a stroke (outline). If false, the text will be drawn as a fill.
	 * @property outline
	 * @type Boolean
	 **/	
	public final native void setOutline(boolean outline)/*-{
		this.outline = outline;
	}-*/;
	
	public final native boolean getOutline()/*-{
		return this.outline;
	}-*/;		
	
	/** Indicates the line height (vertical distance between baselines) for multi-line text. If null or 0, 
	 * the value of getMeasuredLineHeight is used.
	 * @property lineHeight
	 * @type Number
	 **/	
	public final native void setLineHeight(int lineHeight)/*-{
		this.lineHeight = lineHeight;
	}-*/;
	
	public final native int getLineHeight()/*-{
		return this.lineHeight;
	}-*/;	
	
	/**
	 * Indicates the maximum width for a line of text before it is wrapped to multiple lines. If null, 
	 * the text will not be wrapped.
	 * @property lineWidth
	 * @type Number
	 **/	
	public final native void setLineWidth(int lineWidth)/*-{
		this.lineWidth = lineWidth;
	}-*/;
	
	public final native int getLineWidth()/*-{
		return this.lineWidth;
	}-*/;
		
}
