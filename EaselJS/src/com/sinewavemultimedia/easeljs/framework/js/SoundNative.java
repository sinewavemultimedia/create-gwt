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

/*A class for holding sound Native
* author: James Tyner 
*/
public class SoundNative extends JavaScriptObject {

	protected SoundNative(){}
	
	/*
	 * Calls the clear Interval of the Browser
	 */
	public static final native void clearInterval(int positionInterval)/*-{
		$wnd.clearInterval(positionInterval);
	}-*/;

	/*
	 * Callback of the the clear Interval of the Browser
	 */
	public static final native void setInterval(CallBack callBack)/*-{
		$wnd.positionIntervalValue= $wnd.setInterval(function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
		});
	}-*/;
	
	/*
	 * Callback of the the set Interval of the Browser
	 */
	public static final native void setInterval(CallBack callBack,int duration)/*-{
		$wnd.positionIntervalValue= $wnd.setInterval(function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
		},duration);
	}-*/;	
	
	
	public static final native int getInterval()/*-{
	   if($wnd.positionIntervalValue)
	   		return $wnd.positionIntervalValue;
	   	else
	   		return 0;
	}-*/;
}
