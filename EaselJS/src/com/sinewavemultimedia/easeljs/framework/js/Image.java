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

/*A class for represting Image
* author: James Tyner 
*/
public class Image extends JavaScriptObject {
	
	protected Image(){}
	
	/*
	 * Creates a new object of the Image
	 */
	public static final native Image create()/*-{
		return new Image();
	}-*/;
	
	/*
	 * Sets the ImageString or the Url of the Image object
	 */
	public final native void setSrc(String src)/*-{
		this.src = src;
	}-*/;
	
	/*
	 * Returns the source of the images . Either url or the Image of the object.
	 */
	public final native String getSrc()/*-{
		return this.src ;
	}-*/;	

	/*
	 * Returns the width of the Image
	 */
	public final native int getWidth()/*-{
		return this.width;
	}-*/;

	/*
	 * Returns the height of the Image
	 */
	public final native int getHeight()/*-{
		return this.height;
	}-*/;
	
	/*
	 * Mapping a load event of the Image.	
	 */
	public final native void onLoad(CallBackEvent callBack)/*-{
		this.onload = function(event){
		 callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
		};
	}-*/;
	

	
}
