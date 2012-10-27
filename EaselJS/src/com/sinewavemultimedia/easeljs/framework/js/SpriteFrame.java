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



package com.sinewavemultimedia.easeljs.framework.js;

import com.google.gwt.core.client.JavaScriptObject;

/*A Class for holding frames
* author: James Tyner 
*/
public class SpriteFrame extends JavaScriptObject {

	protected SpriteFrame(){}
	
	/*
	 * Create a new spriteFrame
	 */
	public native final static SpriteFrame create()/*-{
		return {};
	}-*/;
	
	/*
	 * Sets the FrameWidth
	 */
	public final native void setFrameWidth(double width)/*-{
		this.width = width;
	}-*/;

	/*
	 * Sets the FrameHeight
	 */
	public final native void setFrameHeight(double height)/*-{
		this.height = height;
	}-*/;

	/*
	 * Sets the regx
	 */
	public final native void setRegX(double regX)/*-{
		this.regX = regX;
	}-*/;	

	/*
	 * Sets the regy
	 */
	public final native void setRegY(double regY)/*-{
		this.regY = regY;
	}-*/;

	/*
	 * Sets the NumberofFrames
	 */
	public final native void setNumFrames(double count)/*-{
		this.count = count;
	}-*/;		
}
