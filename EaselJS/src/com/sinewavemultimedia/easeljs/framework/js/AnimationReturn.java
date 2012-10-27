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

/*An Animation instance class. Part of SpriteSheet.js
* author: James Tyner 
*/
public class AnimationReturn extends JavaScriptObject {
	
	protected AnimationReturn(){}
	
	/*
	 * Returns the list of frames for a particular animation
	 */
	public final native JsArray<AnimationFrame> getFrames()/*-{
		return this._frames;
	}-*/; 
	
	/*
	 * Returns the frequency at which the animation is getting updated
	 */
	public final native double getFrequency()/*-{
		return this.frequency;
	}-*/; 	

	/*
	 * A frequency for updating on the specified no of ticks.
	 * for example setting a frequency 8 it updates at every 8 ticks
	 */

	public final native void setFrequency(double frequency)/*-{
		this.frequency = frequency;
	}-*/; 		
	
	/*
	 * Gets the name of the animation (e.g.) jump
	 */
	public final native String getName()/*-{
		return this.name;
	}-*/;

	/*
	 * sets the name of the animation (e.g.) jump
	 */
	public final native void setName(String name)/*-{
		this.name = name;
	}-*/;	

	/*
	 * Returns the next animation name that will be executed
	 */
	public final native String getNext()/*-{
		return this.next;
	}-*/;	
	
	public final native void setNext(String next)/*-{
		this.next = next;
	}-*/;		

}
