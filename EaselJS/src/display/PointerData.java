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


package com.sinewavemultimedia.easeljs.framework.js.display;

import com.google.gwt.core.client.JavaScriptObject;

/*A class the represents PointData in Stage class.
* author: James Tyner 
*/

public class PointerData extends JavaScriptObject {

	protected PointerData(){}
	
	/*
	 * Returns the X position of the Points
	 */
	public final native int getX()/*-{
		return this.x;
	}-*/;

	/*
	 * Returns the Y position of the Points
	 */	
	public final native int getY()/*-{
		return this.y;
	}-*/;

	/*
	 * Returns the Target of the Points
	 */	
	public final native JavaScriptObject getTarget()/*-{
		return this.target;
	}-*/;

	/*
	 * Returns the Event of the Points
	 */
	public final native JavaScriptObject getEvent()/*-{
		return this.event;
	}-*/;

	/*
	 * Returns the OverTarget of the Points
	 */	
	public final native JavaScriptObject getOverTarget()/*-{
		return this.overTarget;
	}-*/;
		
	/*
	 * Returns the OverX of the Points
	 */		
	public final native int getOverX()/*-{
		return this.overX;
	}-*/;
	
	/*
	 * Returns the OverY of the Points
	 */		
	public final native int getOverY()/*-{
		return this.overY;
	}-*/;
}
