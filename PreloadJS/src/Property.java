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
import com.sinewavemultimedia.easeljs.framework.js.CallBack;

/*A Class for holding the Property for the objects
* author: James Tyner 
*/
public class Property extends JavaScriptObject {

	protected Property(){}
	
	public native final static Property createProperty()/*-{
		return {};
	}-*/;
	
	public final native int getLoop()/*-{
		return this.loop;
	}-*/;
	
	public final native void setLoop(int loop)/*-{
		return this.loop = loop;
	}-*/;
	
	public final native double getUseTicks()/*-{
		return this.useTicks;
	}-*/;
	
	public final native void setUseTicks(double useTicks)/*-{
		return this.useTicks = loop;
	}-*/;
	
	public final native boolean getIgnoreGlobalPause()/*-{
		return this.ignoreGlobalPause;
	}-*/;
	
	public final native void setIgnoreGlobalPause(boolean ignoreGlobalPause)/*-{
		return this.ignoreGlobalPause = ignoreGlobalPause;
	}-*/;
	
	public final native boolean getOverride()/*-{
		return this.override;
	}-*/;
	
	public final native void setOverride(boolean override)/*-{
		return this.override = override;
	}-*/;

	public final native boolean getPaused()/*-{
		return this.paused;
	}-*/;
	
	public final native void setPaused(boolean paused)/*-{
		return this.paused = paused;
	}-*/;
	
	public final native double getPosition()/*-{
		return this.position;
	}-*/;
	
	public final native void setPosition(double position)/*-{
		return this.position = position;
	}-*/;	
	
	public final native void onChanged(CallBack callBack)/*-{
		this.onChanged=function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
		}	
	}-*/;
	
	public final native void addIntProperty(String propertyname,int value)/*-{
		var data= this;
		data[propertyname] = value;
	}-*/;
	
	
	public final native int getIntProperty(String propertyname)/*-{
		var data= this;
		return data[propertyname];
	}-*/;	
	
	public final native void addBooleanProperty(String propertyname,boolean value)/*-{
		var data= this;
		data[propertyname] = value;
	}-*/;
	
	
	public final native boolean getBooleanProperty(String propertyname)/*-{
		var data= this;
		return (data[propertyname] != null )?  data[propertyname] : false;
	}-*/;	
	
	public final native void addDoubleProperty(String propertyname,double value)/*-{
		var data= this;
		data[propertyname] = value;
	}-*/;
	
	
	public final native double getDoubleProperty(String propertyname)/*-{
		var data= this;
		return data[propertyname];
	}-*/;	
	
	public final native void addJavaScriptProperty(String propertyname,JavaScriptObject value)/*-{
		var data= this;
		data[propertyname] = value;
	}-*/;
	
	
	public final native JavaScriptObject getJavaScriptProperty(String propertyname)/*-{
		var data= this;
		return data[propertyname];
	}-*/;		
	
	
}
