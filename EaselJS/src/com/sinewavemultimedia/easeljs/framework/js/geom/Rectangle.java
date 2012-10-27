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



package com.sinewavemultimedia.easeljs.framework.js.geom;

import com.google.gwt.core.client.JavaScriptObject;

/*A class the represents Rectangle.js
* author: James Tyner 
*/
public class Rectangle extends JavaScriptObject {
	
	protected Rectangle(){}
	
	public final native static Rectangle create(int x,int y,int width,int height)/*-{
		return new $wnd.createjs.Rectangle(x,y,width,height);
	}-*/;
	
	public final native Rectangle clone()/*-{
		return this.clone();
	}-*/;
	
	public final native void setY(int y)/*-{
		this.y = y;
	}-*/;	

	/** 
	 * X position. 
	 * @property x
	 * @type Number
	 **/	
	public final native void setX(int x)/*-{
		this.x = x;
	}-*/;
	
	public final native int getX()/*-{
		return this.x;
	}-*/;
	
	/** 
	 * Y position. 
	 * @property y
	 * @type Number
	 **/	
	public final native int getY()/*-{
		return this.y;
	}-*/;	

	/** 
	 * Width.
	 * @property width
	 * @type Number
	 **/	
	public final native void setWidth(int width)/*-{
		this.width = width;
	}-*/;
	
	public final native int getWidth()/*-{
		return this.width;
	}-*/;

	/** 
	 * Height.
	 * @property height
	 * @type Number
	 **/	
	public final native void setHeight(int height)/*-{
		this.height = height;
	}-*/;
	
	public final native int getHeight()/*-{
		return this.height;
	}-*/;
	
}
