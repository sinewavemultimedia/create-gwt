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

/*A class for holding manifest objects
* author: James Tyner 
*/
public class Manifest extends JavaScriptObject {

	protected Manifest(){}

	/*
	 * Create a new manifest object.
	 */
	public static final native Manifest create()/*-{
		return {};
	}-*/;
	
	/*
	 * Add a integer attribute to the Manifest object
	 */
	public final native void addIntProperty(String propertyname,int value)/*-{
		var data= this;
		data[propertyname] = value;
	}-*/;
	
	/*
	 * Returns  a integer attribute of the Manifest object
	 */	
	public final native int getIntProperty(String propertyname)/*-{
		var data= this;
		return data[propertyname];
	}-*/;
	
	/*
	 * Add a double attribute to the Manifest object
	 */
	public final native void addDoubleProperty(String propertyname,double value)/*-{
		var data= this;
		data[propertyname] = value;
	}-*/;
	
	/*
	 * Return a double attribute to the Manifest object
	 */	
	public final native double getDoubleProperty(String propertyname)/*-{
		var data= this;
		return data[propertyname];
	}-*/;
	
	/*
	 * Add a String attribute to the Manifest object
	 */
	public final native void addStringProperty(String propertyname,String value)/*-{
		var data= this;
		data[propertyname] = value;
	}-*/;
	
	/*
	 * Returns a String attribute to the Manifest object
	 */	
	public final native String getStringProperty(String propertyname)/*-{
		var data= this;
		return data[propertyname];
	}-*/;	
	
}
