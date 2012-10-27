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
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayMixed;

/*
 * An Animation  class. Part of Spritesheet.js
* author: James Tyner 
*/
public class Animation extends JavaScriptObject {

	protected Animation(){}
	
	/*
	 * Method used for creating instance.
	 */
	public final native static Animation create()/*-{
		return {};
	}-*/;
	
    /*
     * An attribute that represents walkupright
     * for example, {walkUpRight:[0,19]} defines an animation sequence called "walkUpRight" that will play back frames 0 to 19 inclusive
     */
	public final native void walkUpRight(JsArrayMixed arrayNumber)/*-{
		this.walkUpRight = arrayNumber;
	}-*/;
	
    /*
     * An attribute that represents walkDownRight
     * for example, {walkUpRight:[0,19]} defines an animation sequence called "walkDownRight" that will play back frames 0 to 19 inclusive
     */
	public final native void walkDownRight(JsArrayMixed arrayNumber)/*-{
		this.walkDownRight = arrayNumber;
	}-*/;	

    /*
     * An attribute that represents walkRight
     * for example, {walkRight:[0,19]} defines an animation sequence called "walkRight" that will play back frames 0 to 19 inclusive
     */
	public final native void walkRight(JsArrayMixed arrayNumber)/*-{
		this.walkRight = arrayNumber;
	}-*/;	


    /*
     * An generic method that represents animationSequenceName
     * for example, addMixedArrayProperty("walkRight",[0,19]) defines an animation sequence called "walkRight" that will play back frames 0 to 19 inclusive
     */
	
	public final native void addMixedArrayProperty(String propertyname,JsArrayMixed value)/*-{
		var data= this;
		data[propertyname] = value;
	}-*/;
	
	
	/*
	 * Returns the value of the animationSeuence for the generic property
	 * for example, getMixedArrayProperty("walkRight")
	 */
	public final native JsArrayMixed getMixedArrayProperty(String propertyname)/*-{
		var data= this;
		return data[propertyname];
	}-*/;
	

	/*
     * An generic method that adds a int property
     * for example, addMixedArrayProperty("test",10) 
     */
	public final native void addIntProperty(String propertyname,int value)/*-{
		var data= this;
		data[propertyname] = value;
	}-*/;

	/*
	 * Returns the integer value of the for the generic property
	 * for example, getIntProperty("walkRight")
	 */
	public final native int getIntProperty(String propertyname)/*-{
		var data= this;
		return data[propertyname];
	}-*/;

    /*
     * An attribute that represents run
     * for example, {run:[0,19]} defines an animation sequence called "run" that will play back frames 0 to 19 inclusive
     */
	public final native void run(JsArrayMixed arrayNumber)/*-{
		this.run = arrayNumber;
	}-*/;
	
    /*
     * An attribute that represents jump
     * for example, {jump:[0,19]} defines an animation sequence called "jump" that will play back frames 0 to 19 inclusive
     */
	public final native void jump(JsArrayMixed arrayNumber)/*-{
		this.jump = arrayNumber;
	}-*/;	

	
	/*
	 * A frequency for updating on the specified no of ticks.
	 * for example setting a frequency 8 it updates at every 8 ticks
	 */
	public final native void setFrequency(int frequency)/*-{
		this.frequency = frequency;
	}-*/;
}
