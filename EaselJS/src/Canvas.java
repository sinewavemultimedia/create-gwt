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
import com.google.gwt.user.client.Element;

/*A Canvas object. Holds the reference of the Canvas DOM.
* author: James Tyner 
*/
public class Canvas extends Element {

	protected Canvas(){}
	
	/*
	 * Pass a DOM element and get the Canvas Object
	 */
	public final native static Canvas getCanvas(JavaScriptObject object)/*-{
		return object;
	}-*/;
	
	/*
	 * Register mousemove event
	 * Param CallBackEvent
	 */
	public final native void onmousemove(CallBackEvent callBack)/*-{
		if(callBack!=null){
			this.onmousemove=function(event){
				callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
			};
		}
		else
			this.onmousemove = null;
	}-*/;

	/*
	 * Register mousedown event
	 * Param CallBackEvent
	 */
	public final native void onmousedown(CallBackEvent callBack)/*-{
		if(callBack!=null){
			this.onmousedown=function(event){
				callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
			};
		}
		else
			this.onmousedown = null;
	}-*/;

	/*
	 * Register mouseup event
	 * Param CallBackEvent
	 */
	public final native void onmouseup(CallBackEvent callBack)/*-{
		if(callBack!=null){
			this.onmouseup=function(event){
				callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
			};
		}
		else{
			this.onmouseup = null;
		}
		
	}-*/;	
	
	/*
	 * Register click event
	 * Param CallBackEvent
	 */
	public final native void onclick(CallBackEvent callBack)/*-{
		if(callBack!=null){
			this.onclick=function(event){
				callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
			};
		}
		else{
			this.onclick = null;
		}	
	}-*/;		
}

