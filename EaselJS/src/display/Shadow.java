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

/*A class the represents Shadow.js
* author: James Tyner 
*/
public class Shadow extends JavaScriptObject {
	
	protected Shadow(){}
	
	/**
	* Encapsulates the properties required to define a shadow to apply to a DisplayObject via it's .shadow property.
	* @class Shadow
	* @constructor
	* @param {String} color The color of the shadow.
	* @param {Number} offsetX The x offset of the shadow.
	* @param {Number} offsetY The y offset of the shadow.
	* @param {Number} blur The size of the blurring effect.
	**/	
	public final native static Shadow create(String color,int offsetX,int offsetY,double blur) /*-{
		return new $wnd.createjs.Shadow(color,offsetX,offsetY,blur);
	}-*/;

	/**
	 * An identity shadow object (all properties are set to 0). Read-only.
	 * @property identity
	 * @type Shadow
	 * @static
	 * @final
	 **/	
	public final native static Shadow getIdentity()/*-{
		return $wnd.createjs.Shadow.identity;
	}-*/;
	
	public final native static void setIdentity(Shadow shadow)/*-{
		$wnd.createjs.Shadow.identity=shadow;
	}-*/;
	
	/** The color of the shadow.
	 * property color
	 * @type String
	 * @default null
	*/	
	public final native void setColor(String color)/*-{
		this.color = color;
	}-*/;
	
	public final native String getColor()/*-{
		return this.color;
	}-*/;	
	
	/** The x offset of the shadow.
	 * property offsetX
	 * @type Number
	 * @default 0
	*/	
	public final native double getOffsetX()/*-{
		return this.offsetX;
	}-*/;
	
	public final native void setOffsetX(double offsetX)/*-{
		this.offsetX = offsetX;
	}-*/;	
	
	/** The y offset of the shadow.
	 * property offsetY
	 * @type Number
	 * @default 0
	*/	
	public final native double getOffsetY()/*-{
		return this.offsetY;
	}-*/;
	
	public final native void setOffsetY(double offsetY)/*-{
		this.offsetY = offsetY;
	}-*/;		

	/** The blur of the shadow.
	 * property blur
	 * @type Number
	 * @default 0
	*/	
	public final native double getBlur()/*-{
		return this.blur;
	}-*/;
	
	public final native void setBlur(double blur)/*-{
		this.blur = blur;
	}-*/;		
			
	public final native Shadow clone()/*-{
		return this.clone();
	}-*/;
}
