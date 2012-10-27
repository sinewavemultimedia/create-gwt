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
import com.sinewavemultimedia.easeljs.framework.js.display.DisplayObject;

/*An instance object which is part of CallBackMethod
* author: James Tyner 
*/
public class Event extends JavaScriptObject {
	
	protected Event(){}
	
	/*
	 * Returns the ID of the source that generated the event.
	 */
	public final native String getId()/*-{
		return this.id;
	}-*/;
	
	/*
	 * The source that generated this event
	 */
	
	public final native String getSrc()/*-{
		return this.src;
	}-*/;

	/*
	 * The data or the object that is associated with this event.
	 */
	public final native String getData()/*-{
		return this.data;
	}-*/;	
	
	
	/*
	 * Returns true if is a bubbles.
	 */
	public final native boolean getBubbles()/*-{
		return this.bubbles;
	}-*/;

	
	public final native boolean getCancelBubble()/*-{
		return this.cancelBubble;
	}-*/;
	
	/*
	 * Return the current Target on which the event is generated. This can be any DisplayObject
	 */
	public final native JavaScriptObject getCurrentTarget()/*-{
		return this.currentTarget;
	}-*/;	
	
	/*
	 * Returns the phase of the event.
	 */
	public final native int getEventPhase()/*-{
		return this.eventPhase;
	}-*/;
	
	/*
	 * Returns the Object which generated this event. It will be a DisplayObject
	 */
	public final native JavaScriptObject getSrcElement()/*-{
		return this.srcElement;
	}-*/;		

	/*
	 * Retuns the target. It will be a DisplayObject
	 */
	public final native JavaScriptObject getTarget()/*-{
		return this.target;
	}-*/;	
	
	/*
	 * Method to attach the mousemove event.
	 */
	public final native void onMouseMove(JavaScriptObject event)/*-{
		this.onMouseMove = event;
	}-*/;

	/*
	 * Method to attach the mouseup event.
	 */
	public final native void onMouseUp(JavaScriptObject event)/*-{
		this.onMouseUp = event;
	}-*/;	

	/*
	 * Returns the rawx  of the event
	 */
	public final native double getRawX()/*-{
		return this.rawX;
	}-*/;	

	/*
	 * Returns the rawy  of the event
	 */
	public final native double getRawY()/*-{
		return this.rawY;
	}-*/;	

	/*
	 * Returns the Stagex of the event
	 */
	public final native double getStageX()/*-{
		return this.stageX;
	}-*/;	
	

	/*
	 * Returns the Stagey of the event
	 */
	public final native double getStageY()/*-{
		return this.stageY;
	}-*/;
	
	/*
	 * Returns the type of the object which generated the event.
	 */
	public final native String getType()/*-{
		return this.type;
	}-*/;

	/*
	 * Returns the pagex of the object which generated the event.
	 */
	public final native double getPageX()/*-{
		return this.pageX;
	}-*/;

	/*
	 * Returns the pagey of the object which generated the event.
	 */
	public final native double getPageY()/*-{
		return this.pageY;
	}-*/;
	
	public final native Event getEvent()/*-{
		return $wnd.event;
	}-*/;
	
	/*
	 * Returns the Result of the object which generated the event.
	 */
	public final native JavaScriptObject getResult()/*-{
		return this.result;
	}-*/;
}
