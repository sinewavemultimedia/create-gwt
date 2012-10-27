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
import com.google.gwt.user.client.Element;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;

/*A class the represents Stage.js
* author: James Tyner 
*/
public class Stage extends Container {

	protected Stage(){}
	
	/**
	 * The canvas the stage will render to. Multiple stages can share a single canvas, but you must disable autoClear for all but the
	 * first stage that will be ticked (or they will clear each other's render).
	 * @property canvas
	 * @type HTMLCanvasElement
	 **/
	
	public final native void setCanvas(Element canvas)/*-{
		this.canvas = canvas;
	}-*/;
	
	public final native Element getCanvas()/*-{
		return this.canvas;
	}-*/;

	/**
	 * READ-ONLY. The current mouse X position on the canvas. If the mouse leaves the canvas, this will indicate the most recent
	 * position over the canvas, and mouseInBounds will be set to false.
	 * @property mouseX
	 * @type Number
	 **/	
	public final native void setMouseX(double mouseX)/*-{
		this.mouseX = mouseX;
	}-*/;
	
	public final native double getMouseX()/*-{
		return this.mouseX;
	}-*/;

	/**
	 * READ-ONLY. The current mouse Y position on the canvas. If the mouse leaves the canvas, this will indicate the most recent
	 * position over the canvas, and mouseInBounds will be set to false.
	 * @property mouseY
	 * @type Number
	 **/	
	public final native void setMouseY(double mouseY)/*-{
		this.mouseY = mouseY;
	}-*/;
	
	public final native double getMouseY()/*-{
		return this.mouseY;
	}-*/;

	/**
	 * The onMouseMove callback is called when the user moves the mouse over the canvas.  The handler is passed a single param
	 * containing the corresponding MouseEvent instance.
	 * @event onMouseMove
	 * @param {MouseEvent} event A MouseEvent instance with information about the current mouse event.
	 **/	
	public final native void onMouseMove(CallBackEvent callBack)/*-{
		this.onMouseMove = function(event){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
		};
	}-*/;
	
	/**
	 * The onMouseUp callback is called when the user releases the mouse button anywhere that the page can detect it.  The handler
	 * is passed a single param containing the corresponding MouseEvent instance.
	 * @event onMouseUp
	 * @param {MouseEvent} event A MouseEvent instance with information about the current mouse event.
	 **/	
	public final native void onMouseUp(CallBackEvent callBack)/*-{
		this.onMouseUp =  function(event){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
		};
	}-*/;

	/**
	 * The onMouseDown callback is called when the user presses the mouse button over the canvas.  The handler is passed a single
	 * param containing the corresponding MouseEvent instance.
	 * @event onMouseDown
	 * @param {MouseEvent} event A MouseEvent instance with information about the current mouse event.
	 **/	
	public final native void onMouseDown(CallBackEvent callBack)/*-{
		this.onMouseDown =  function(event){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
		};
	}-*/;
		
	/**
	 * Indicates whether this stage should use the snapToPixel property of display objects when rendering them. See
	 * DisplayObject.snapToPixel for more information.
	 * @property snapToPixelEnabled
	 * @type Boolean
	 * @default false
	 **/	
	public final native void setSnapToPixelEnabled(boolean mouseY)/*-{
		this.snapToPixelEnabled = snapToPixelEnabled;
	}-*/;
	
	public final native boolean getSnapToPixelEnabled()/*-{
		return this.snapToPixelEnabled;
	}-*/;

	/**
	 * Indicates whether the mouse is currently within the bounds of the canvas.
	 * @property mouseInBounds
	 * @type Boolean
	 * @default false
	 **/	
	public final native void setMouseInBounds(boolean mouseInBounds)/*-{
		this.mouseInBounds = mouseInBounds;
	}-*/;
	
	public final native boolean getMouseInBounds()/*-{
		return this.mouseInBounds;
	}-*/;
	
	/**
	 * If false, tick callbacks will be called on all display objects on the stage prior to rendering to the canvas.
	 * @property tickOnUpdate
	 * @type Boolean
	 * @default false
	 **/
	public final native void setTickOnUpdate(boolean tickOnUpdate)/*-{
		this.tickOnUpdate = tickOnUpdate;
	}-*/;
	
	/**
	 * If true, onMouseMove handlers will continue to be called when the mouse leaves the target canvas. See
	 * mouseInBounds, and MouseEvent.x/y/rawX/rawY.
	 * @property tickOnUpdate
	 * @type mouseMoveOutside
	 * @default false
	 **/	
	public final native boolean getTickOnUpdate()/*-{
		return this.tickOnUpdate;
	}-*/;

	/**
	 * If true, onMouseMove handlers will continue to be called when the mouse leaves the target canvas. See
	 * mouseInBounds, and MouseEvent.x/y/rawX/rawY.
	 * @property tickOnUpdate
	 * @type mouseMoveOutside
	 * @default false
	 **/
	public final native void setMouseMoveOutside(boolean mouseMoveOutside)/*-{
		this.mouseMoveOutside = mouseMoveOutside;
	}-*/;
	
	public final native boolean getMouseMoveOutside()/*-{
		return this.mouseMoveOutside;
	}-*/;

	
	/*
	 * Need to overload this method
	 */
	public final native void update()/*-{
		this.update();
	}-*/;
	
	/*
	 * Clear method of the Stage
	 */
	public final native void clear()/*-{
		this.clear();
	}-*/;	

	/**
	 * Indicates whether the stage should automatically clear the canvas before each render. You can set this to false to manually
	 * control clearing (for generative art, or when pointing multiple stages at the same canvas for example).
	 * @property autoClear
	 * @type Boolean
	 * @default true
	 **/	
	public final native void setAutoClear(boolean autoClear)/*-{
		this.autoClear = autoClear;
	}-*/;	
	
	
	public final native void getAutoClear()/*-{
		return this.autoClear;
	}-*/;	
	
	/**
	 * Returns a data url that contains a Base64 encoded image of the contents of the stage. The returned data url can be
	 * specified as the src value of an image element.
	 * @method toDataURL
	 * @param {String} backgroundColor The background color to be used for the generated image. The value can be any value HTML color
	 * value, including HEX colors, rgb and rgba. The default value is a transparent background.
	 * @param {String} mimeType The MIME type of the image format to be create. The default is "image/png". If an unknown MIME type
	 * is passed in, or if the browser does not support the specified MIME type, the default value will be used.
	 * @return {String} a Base64 encoded image.
	 **/	
	public final native String toDataURL(String backgroundColor,String mimeType)/*-{
		return this.toDataURL(backgroundColor,mimeType);
	}-*/;	

	/**
	 * Enables or disables (by passing a frequency of 0) mouse over handlers (onMouseOver and onMouseOut) for this stage's display
	 * list. These events can be expensive to generate, so they are disabled by default, and the frequency of the events
	 * can be controlled independently of mouse move events via the optional frequency parameter.
	 * @method enableMouseOver
	 * @param {Number} frequency Optional param specifying the maximum number of times per second to broadcast mouse over/out events. Set to 0 to disable mouse
	 * over events completely. Maximum is 50. A lower frequency is less responsive, but uses less CPU. Default is 20.
	 **/	
	public final native void enableMouseOver(int frequency)/*-{
		this.enableMouseOver(frequency);
	}-*/;
	
	protected final native void enableMouseEvents()/*-{
		this._enableMouseEvents();
	}-*/;
	
	protected final native PointerData getPointerData(int id)/*-{
		this._getPointerData(id);
	}-*/;
}
