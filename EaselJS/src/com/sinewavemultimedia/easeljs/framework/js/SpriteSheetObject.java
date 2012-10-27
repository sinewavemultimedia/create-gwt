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
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

/*A complex class the represents SpriteSheet attributes
* author: James Tyner 
*/
public class SpriteSheetObject extends JavaScriptObject {
	
	protected SpriteSheetObject(){}
	
	/*
	 * Creats a SpriteSheetObject
	 */
	public final native static SpriteSheetObject create()/*-{
		return {};
	}-*/;

	/*
	 * Add a Array of Imgaes to the SpriteFrameObject
	 */
	public final native void addImage(JsArray<Image> image)/*-{
		this.images = image;
	}-*/;

	/*
	 * Add a Image to the SpriteFrameObject
	 */
	public final native void addImage(JsArrayString image)/*-{
		this.images = image;
	}-*/;

	/*
	 * Add a Frames to the SpriteFrameObject
	 */
	public final native void addFrames(JsArray<JavaScriptObject> frames)/*-{
		this.frames = frames;
	}-*/;
	
	/*
	 * Add a Frame to the SpriteFrameObject
	 */
	public final native void addFrame(SpriteFrame frame)/*-{
		this.frames = frame;
	}-*/;

	/*
	 * Add a Animation to the SpriteFrameObject
	 */	
	public final native void addAnimations(Animation animation)/*-{
		this.animations = animation;
	}-*/;	
}
