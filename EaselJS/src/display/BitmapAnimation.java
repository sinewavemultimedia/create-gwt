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
import com.sinewavemultimedia.easeljs.framework.js.CallBackBitMapAnimation;
import com.sinewavemultimedia.easeljs.framework.js.Canvas2DJS;

/*A class that represents Bitmapanmimation.js
* author: James Tyner 
*/
public class BitmapAnimation extends DisplayObject {

	protected BitmapAnimation(){}
	
	/*
	 * Method used for creating instance.
	 */
	public final native static BitmapAnimation create(SpriteSheet sheet)/*-{
		return new $wnd.createjs.BitmapAnimation(sheet);
	}-*/;
	
	/*
	 * Draw method of the BitmapAnimation 
	 * Param Canvas2D object 
	 * Ignore cache 
	 */
	public final native boolean draw(Canvas2DJS object,boolean ignoreCache)/*-{
		return this.draw(object,ignoreCache);
	}-*/;
	
	/*
	 * A callback on Animation ends.
	 */
	public final native void onAnimationEnd(CallBackBitMapAnimation callBack)/*-{
		this.onAnimationEnd =function(bmpAnim,animation){
		callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackBitMapAnimation::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/display/BitmapAnimation;Ljava/lang/String;)(bmpAnim,animation);
		};
	}-*/;
	
	/*
	 * Sets the CurrentFrame of the BitmapAnimation
	 */
	public final native void setCurrentFrame(int currentFrame)/*-{
		this.currentFrame = currentFrame;
	}-*/;
	
	/*
	 * Gets the CurrentFrame of the BitmapAnimation.
	 */
	public final native int getCurrentFrame()/*-{
		return this.currentFrame;
	}-*/;
	
	/*
	 * Get the CurrentAnimation of the BitmapAnimation
	 */
	public final native String getCurrentAnimation()/*-{
		return this.currentAnimation;
	}-*/;
	
	/*
	 * Setting the Paused true to BitmapAnimation
	 */
	public final native void setPaused(boolean paused)/*-{
		this.paused = paused;
	}-*/;

	/*
	 * getting the Paused of BitmapAnimation
	 */
	public final native boolean getPaused()/*-{
		return this.paused;
	}-*/;
	
	/*
	 * Play method of the BitmapAnimation
	 */
	public final native void play()/*-{
		this.play();
	}-*/;

	/*
	 * Stop method of the BitmapAnimation
	 */
	public final native void stop()/*-{
		this.stop();
	}-*/;	
	
	/**
	 * Sets paused to false and plays the specified animation name, named frame, or frame number.
	 * @method gotoAndPlay
	 * @param {String} frameOrAnimation The frame number or animation name that the playhead should move to
	 * and begin playing.
	 **/
	public final native void gotoAndPlay(String frameOrAnimation)/*-{
		this.gotoAndPlay(frameOrAnimation);
	}-*/;
	
	/**
	 * Sets paused to false and plays the specified animation name, named frame, or frame number.
	 * @method gotoAndPlay
	 * @param {int} frameOrAnimation The frame number or animation name that the playhead should move to
	 * and begin playing.
	 **/
	public final native void gotoAndPlay(int frameOrAnimation)/*-{
		this.gotoAndPlay(frameOrAnimation);
	}-*/;
	
	/**
	 * Sets paused to true and seeks to the specified animation name, named frame, or frame number.
	 * @method gotoAndStop
	 * @param {String} frameOrAnimation The frame number or animation name that the playhead should move to
	 * and stop.
	 **/
	public final native void gotoAndStop(String frameOrAnimation)/*-{
		this.gotoAndStop(frameOrAnimation);
	}-*/;

	/**
	 * Sets paused to true and seeks to the specified animation name, named frame, or frame number.
	 * @method gotoAndStop
	 * @param {int} frameOrAnimation The frame number or animation name that the playhead should move to
	 * and stop.
	 **/
	public final native void gotoAndStop(int frameOrAnimation)/*-{
		this.gotoAndStop(frameOrAnimation);
	}-*/;
	
	/*
	 * Set the SpriteSheet of the BitmapAnimation
	 */			
	public final native void setSpriteSheet(SpriteSheet sheet)/*-{
		this.spriteSheet = sheet;
	}-*/;
	
	/*
	 * get the SpriteSheet of the BitmapAnimation
	 */			
	public final native SpriteSheet getSpriteSheet()/*-{
		return this.spriteSheet;
	}-*/;
	
	/*
	 * Set the Offset of the BitmapAnimation
	 */
	public final native void setOffset(int offset)/*-{
		this.offset = offset;
	}-*/;
	
	/*
	 * get the Offset of the BitmapAnimation
	 */
	public final native int getOffset()/*-{
		return this.offset;
	}-*/;
	
	/*
	 * Set the Current Animation Frame of the BitmapAnimation.
	 */
	public final native void setCurrentAnimationFrame(double currentAnimationFrame)/*-{
		this.currentAnimationFrame = currentAnimationFrame;
	}-*/;
	
	/*
	 * Get the Current Animation Frame of the BitmapAnimation.
	 */
	public final native int getCurrentAnimationFrame()/*-{
		return this.currentAnimationFrame;
	}-*/;
	
	/*
	 * Advances the playhead. This occurs automatically each tick by default.
	 */
	public final native void advance()/*-{
		this.advance();
	}-*/;
		
	
	public final native BitmapAnimation BmAclone()/*-{
		return this.clone();
	}-*/;	
}
