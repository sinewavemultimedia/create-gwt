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

/*A instance object part of Callback attributes. A test class
* author: James Tyner 
*/
public class EventTarget extends JavaScriptObject {

	protected EventTarget(){}
	
	public final native String getId()/*-{
		return this.id;
	}-*/;
	
	public final native EventTarget getParent()/*-{
		return this.parent;
	}-*/;
	
	public final native EventTarget getRegX()/*-{
		return this.regX;
	}-*/;
	
	public final native EventTarget getRegY()/*-{
		return this.regY;
	}-*/;
	
	public final native double getRotation()/*-{
		return this.rotation;
	}-*/;
	
	public final native double getScaleX()/*-{
		return this.scaleX;
	}-*/;
	
	public final native double getScaleY()/*-{
		return this.scaleY;
	}-*/;
	
	public final native double getX()/*-{
		return this.x;
	}-*/;
	
	public final native double getY()/*-{
		return this.y;
	}-*/;
	
	public final native JavaScriptObject getImage()/*-{
		return this.image;
	}-*/;
	
	public final native JsArray<EventTarget> getChildren()/*-{
		return this.children;
	}-*/;
	
}
