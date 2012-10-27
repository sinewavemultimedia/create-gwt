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


package com.sinewavemultimedia.easeljs.framework.js.utils;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayMixed;
import com.sinewavemultimedia.easeljs.framework.js.CallBackGeneric;
import com.sinewavemultimedia.easeljs.framework.js.display.DisplayObject;
import com.sinewavemultimedia.easeljs.framework.js.display.MovieClip;
import com.sinewavemultimedia.easeljs.framework.js.display.SpriteSheet;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.geom.Rectangle;

/*A class the represents SpriteSheetBuilder.js
* author: James Tyner 
*/
public class SpriteSheetBuilder extends JavaScriptObject {
	
	public static String ERR_DIMENSIONS = "frame dimensions exceed max spritesheet dimensions";
	
	public static String ERR_RUNNING = "a build is already running";
	
	protected SpriteSheetBuilder(){}
	
	public native final void setMaxWidth(double maxWidth)/*-{
		this.maxWidth = maxWidth;
	}-*/;
	
	public native final double getMaxWidth()/*-{
		return this.maxWidth;
	}-*/;
	
	public native final void setMaxHeight(double maxHeight)/*-{
		this.maxHeight = maxHeight;
	}-*/;
	
	public native final double getMaxHeight()/*-{
		return this.maxHeight;
	}-*/;
	
	public native final void setMaxHeight(SpriteSheet spriteSheet)/*-{
		this.spriteSheet = spriteSheet;
	}-*/;
	
	public native final SpriteSheet getSpriteSheet()/*-{
		return this.spriteSheet;
	}-*/;
	
	public native final void setScale(double scale)/*-{
		this.scale = scale;
	}-*/;
	
	public native final double getScale()/*-{
		return this.scale;
	}-*/;

	public native final void setPadding(double padding)/*-{
		this.padding = padding;
	}-*/;
	
	public native final double getPadding()/*-{
		return padding.scale;
	}-*/;	
	/**
	 * The SpriteSheetBuilder allows you to generate sprite sheets at run time from any display object. This can allow
	 * you to maintain your assets as vector graphics (for low file size), and render them at run time as sprite sheets
	 * for better performance.
	 * <br/><br/>
	 * Sprite sheets can be built either synchronously, or asynchronously, so that large sprite sheets can be generated
	 * without locking the UI.
	 * <br/><br/>
	 * Note that the "images" used in the generated sprite sheet are actually canvas elements, and that they will be sized
	 * to the nearest power of 2 up to the value of maxWidth or maxHeight.
	 * @class SpriteSheetBuilder
	 * @constructor
	 **/	
	public final static native SpriteSheetBuilder create() /*-{
		return new $wnd.createjs.SpriteSheetBuilder(); 
	}-*/;

	/**
	 * Adds a frame to the sprite sheet. Note that the frame will not be drawn until you call build. The optional
	 * setup params allow you to have a function run immediately before the draw occurs. For example, this allows you to
	 * add a single source multiple times, but manipulate it or it's children to change it to generate different frames.
	 * <br/><br/>
	 * Note that the source's transformations (x,y,scale,rotate,alpha) will be ignored, except for regX/Y. To apply
	 * transforms to a source object and have them captured in the sprite sheet, simply place it into a Container
	 * and pass in the Container as the source.
	 * @method addFrame
	 * @param {DisplayObject} source The source display object to draw as the frame.
	 * @param {Rectangle} sourceRect Optional. A rectangle defining the portion of the source to draw to the frame. If
	 * not specified, it will look for a getBounds method, bounds property, or nominalBounds property on the source to use.
	 * If one is not found, the frame will be skipped.
	 * @param {Number} scale Optional. The scale to draw this frame at. Default is 1.
	 * @param {Function} setupFunction Optional. A function to call immediately before drawing this frame.
	 * @param {Array} setupParams Optional. Parameters to pass to the setup function.
	 * @param {Object} setupScope Optional. The scope to call the setupFunction in.
	 * @return {Number} The index of the frame that was just added, or null if a sourceRect could not be determined.
	 **/	
	public final native int addFrame(DisplayObject source,Rectangle sourceRect,double scale,CallBackGeneric setupFunction, JsArrayMixed setupParams,JavaScriptObject setupScope)/*-{
		return this.addFrame(source, sourceRect, scale, function(scale,setupParams){
		var tscale = ""+scale;
			setupFunction.@com.sinewavemultimedia.easeljs.framework.js.CallBackGeneric::onSuccess(Ljava/lang/String;Lcom/google/gwt/core/client/JsArrayMixed;)(tscale,sourceRect);
		}, setupParams, setupScope);
	}-*/;

	public final native int addFrame(DisplayObject source,Rectangle sourceRect,double scale,CallBackGeneric setupFunction, JsArrayMixed setupParams)/*-{
		return this.addFrame(source, sourceRect, scale, function(scale,setupParams){
			var tscale = ""+scale;
			setupFunction.@com.sinewavemultimedia.easeljs.framework.js.CallBackGeneric::onSuccess(Ljava/lang/String;Lcom/google/gwt/core/client/JsArrayMixed;)(tscale,sourceRect);
		}, setupParams);
	}-*/;	

	public final native int addFrame(DisplayObject source,Rectangle sourceRect,double scale,CallBackGeneric setupFunction)/*-{
		return this.addFrame(source, sourceRect, scale, function(scale,setupParams){
		var tscale = ""+scale;
			setupFunction.@com.sinewavemultimedia.easeljs.framework.js.CallBackGeneric::onSuccess(Ljava/lang/String;Lcom/google/gwt/core/client/JsArrayMixed;)(tscale,sourceRect);
		});
	}-*/;
	
	public final native int addFrame(DisplayObject source,Rectangle sourceRect,double scale)/*-{
		return this.addFrame(source, sourceRect, scale);
	}-*/;		
	
	public final native int addFrame(DisplayObject source,Rectangle sourceRect)/*-{
		return this.addFrame(source, sourceRect);
	}-*/;		

	public final native int addFrame(DisplayObject source)/*-{
		return this.addFrame(source);
	}-*/;	
	
	/**
	 * Adds an animation that will be included in the created sprite sheet.
	 * @method addFrame
	 * @param {String} name The name for the animation.
	 * @param {Array} frames An array of frame indexes that comprise the animation. Ex. [3,6,5] would describe an animation
	 * that played frame indexes 3, 6, and 5 in that order.
	 * @param {String} next Optional. Specifies the name of the animation to continue to after this animation ends. You can
	 * also pass false to have the animation stop when it ends. By default it will loop to the start of the same animation.
	 * @param {Number} frequency Optional. Specifies a frame advance frequency for this animation. For example, a value
	 * of 2 would cause the animation to advance every second tick.
	 **/	
	public final native void addAnimation(String name,JsArrayMixed frames,boolean next,int frequency)/*-{
		this.addAnimation(name,frames,next,frequency);
	}-*/;
	
	public final native void addAnimation(String name,JsArrayMixed frames,boolean next)/*-{
		this.addAnimation(name,frames,next);
	}-*/;		
	
	public final native void addAnimation(String name,JsArrayMixed frames,String next,int frequency)/*-{
		this.addAnimation(name,frames,next,frequency);
	}-*/;
	
	public final native void addAnimation(String name,JsArrayMixed frames,String next)/*-{
		this.addAnimation(name,frames,next);
	}-*/;	
	
	public final native void addAnimation(String name,JsArrayMixed frames)/*-{
		this.addAnimation(name,frames);
	}-*/;	

	public final native void addAnimation(String name,int frames,String next,int frequency)/*-{
		this.addAnimation(name,frames,next,frequency);
	}-*/;
	
	public final native void addAnimation(String name,int frames,String next)/*-{
		this.addAnimation(name,frames,next);
	}-*/;	
	
	public final native void addAnimation(String name,int frames)/*-{
		this.addAnimation(name,frames);
	}-*/;	

	/**
	 * This will take a MovieClip, and add its frames and labels to this builder. Labels will be added as an animation
	 * running from the label index to the next label. For example, if there is a label named "foo" at frame 0 and a label
	 * named "bar" at frame 10, in a MovieClip with 15 frames, it will add an animation named "foo" that runs from frame
	 * index 0 to 9, and an animation named "bar" that runs from frame index 10 to 14.
	 * <br/><br/>
	 * Note that this will iterate through the full MovieClip with actionsEnabled set to false, ending on the last frame.
	 * @method addMovieClip
	 * @param {MovieClip} source The source MovieClip to add to the sprite sheet.
	 * @param {Rectangle} sourceRect Optional. A rectangle defining the portion of the source to draw to the frame. If
	 * not specified, it will look for a getBounds method, frameBounds array, bounds property, or nominalBounds property
	 * on the source to use. If one is not found, the MovieClip will be skipped.
	 * @param {Number} scale Optional. The scale to draw the movie clip at. Default is 1.
	 **/	
	public final native void addMovieClip(MovieClip source,Rectangle sourceRect,int scale)/*-{
		this.addMovieClip(source,sourceRect,scale);
	}-*/;
	
	/**
	 * Builds a SpriteSheet instance based on the current frames.
	 * @method build
	 * @return SpriteSheet The created SpriteSheet instance, or null if a build is already running or an error occurred.
	 **/	
	public final native SpriteSheet build()/*-{
		return this.build();
	}-*/;
	
	/**
	 * Asynchronously builds a SpriteSheet instance based on the current frames. It will run 20 times per second, using
	 * an amount of time defined by timeSlice. When it is complete it will call the specified callback.
	 * @method buildAsync
	 * @param {Function} callback Optional. The function to call when the build operation completes. It will be called
	 * with a single parameter providing a reference back to the builder.
	 * @param {Number} timeSlice Optional. A number from 0.01 to 1 that indicates what percentage of time the builder can use. This can be
	 * thought of as the number of seconds per second the builder will use. For example, with a timeSlice value of 0.3,
	 * the builder will run 20 times per second, using approximately 15ms per build (30% of available time, or 0.3s per second).
	 * Defaults to 0.3.
	 **/	
	public final native void buildAsync(JavaScriptObject callback,int timeslice)/*-{
		this.buildAsync(callback,timeslice);
	}-*/;
	
	/**
	 * Stops the current asynchronous build.
	 * @method stopAsync
	 **/	
	public final native void stopAsync()/*-{
		this.stopAsync();
	}-*/;	
	
	public final native SpriteSheetBuilder clone()/*-{
		return this.clone();
	}-*/;	
}
