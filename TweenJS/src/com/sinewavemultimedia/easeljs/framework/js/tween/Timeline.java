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



package com.sinewavemultimedia.easeljs.framework.js.tween;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;

/*A  class that represents Timeline.js
* author: James Tyner 
*/

public class Timeline extends JavaScriptObject {

	protected Timeline(){}
	
	public static native final Timeline createTimeLine(JsArray<Tween> tweens,String labels,Property props)/*-{
		return new $wnd.createjs.Timeline(tweens,labels,props);
	}-*/;
	
	/**
	 * Causes this timeline to continue playing when a global pause is active.
	 * @property ignoreGlobalPause
	 * @type Boolean
	 **/	
	public native final boolean getIgnoreGlobalPause()/*-{
		return this.ignoreGlobalPause;
	}-*/;
	
	public native final void setIgnoreGlobalPause(boolean ignoreGlobalPause)/*-{
		this.ignoreGlobalPause = ignoreGlobalPause;
	}-*/;
	
	/**
	 * Read-only property specifying the total duration of this timeline in milliseconds (or ticks if useTicks is true).
	 * This value is usually automatically updated as you modify the timeline. See updateDuration for more information.
	 * @property duration
	 * @type Number
	 **/	
	public native final double getDuration()/*-{
		return this.duration;
	}-*/;
	
	/**
	 * If true, the timeline will loop when it reaches the end. Can be set via the props param.
	 * @property loop
	 * @type Boolean
	 **/

	public native final boolean getLoop()/*-{
		return this.loop;
	}-*/;
	
	public native final void setLoop(boolean loop)/*-{
		this.loop = loop;
	}-*/;

	/**
	 * Called, with a single parameter referencing this timeline instance, whenever the timeline's position changes.
	 * @property onChange
	 * @type Function
	 **/	
	public final native void onChange(CallBack callBack)/*-{
		this.onChange=function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
		}	
	}-*/;
	
	/**
	 * Read-only. The current normalized position of the timeline. This will always be a value between 0 and duration.
	 * Changing this property directly will have no effect.
	 * @property position
	 * @type Object
	 **/	
	public native final double getPosition()/*-{
		return this.position;
	}-*/;
	
	/** 
	 * Adds one or more tweens (or timelines) to this timeline. The tweens will be paused (to remove them from the normal ticking system)
	 * and managed by this timeline. Adding a tween to multiple timelines will result in unexpected behaviour.
	 * @method addTween
	 * @param tween The tween(s) to add. Accepts multiple arguments.
	 * @return Tween The first tween that was passed in.
	 **/	
	public final native Tween addTween(Tween tween)/*-{
		return this.addTween(tween);
	}-*/;
	
	/** 
	 * Removes one or more tweens from this timeline.
	 * @method removeTween
	 * @param tween The tween(s) to remove. Accepts multiple arguments.
	 * @return Boolean Returns true if all of the tweens were successfully removed.
	 **/	
	public final native boolean removeTween(Tween tween)/*-{
		return this.removeTween(tween);
	}-*/;
	
	/** 
	 * Adds a label that can be used with gotoAndPlay/Stop.
	 * @method addLabel
	 * @param label The label name.
	 * @param position The position this label represents.
	 **/	
	public final native void addLabel(String label,double position)/*-{
		this.addLabel(label,position);
	}-*/;
	
	/** 
	 * Defines labels for use with gotoAndPlay/Stop. Overwrites any previously set labels.
	 * @method addLabel
	 * @param o An object defining labels for using gotoAndPlay/Stop in the form {labelName:time} where time is in ms (or ticks if useTicks is true).
	 **/	
	public final native void setLabels(String label)/*-{
		this.setLabels(label);
	}-*/;
	
	/** 
	 * Unpauses this timeline and jumps to the specified position or label.
	 * @method gotoAndPlay
	 * @param positionOrLabel The position in milliseconds (or ticks if useTicks is true) or label to jump to.
	 **/	
	public final native void gotoAndPlay(String positionOrLabel)/*-{
		this.gotoAndPlay(positionOrLabel);
	}-*/;
	
	/** 
	 * Pauses this timeline and jumps to the specified position or label.
	 * @method gotoAndStop
	 * @param positionOrLabel The position in milliseconds (or ticks if useTicks is true) or label to jump to.
	 **/	
	public final native void gotoAndStop(String positionOrLabel)/*-{
		this.gotoAndStop(positionOrLabel);
	}-*/;
	
	/** 
	 * Advances the timeline to the specified position.
	 * @method setPosition
	 * @param value The position to seek to in milliseconds (or ticks if useTicks is true).
	 * @param actionsMode Optional parameter specifying how actions are handled. See Tween.setPosition for more details.
	 * @return Boolean Returns true if the timeline is complete (ie. the full timeline has run & loop is false).
	 **/	
	public final native void setPosition(double value,int actionsMode)/*-{
		this.setPosition(value,actionsMode);
	}-*/;
	
	/** 
	 * Pauses or plays this timeline.
	 * @method setPaused
	 * @param value Indicates whether the tween should be paused (true) or played (false).
	 **/	
	public final native void setPaused(boolean value)/*-{
		this.setPaused(value);
	}-*/;
	
	/** 
	 * Recalculates the duration of the timeline.
	 * The duration is automatically updated when tweens are added or removed, but this method is useful 
	 * if you modify a tween after it was added to the timeline.
	 * @method updateDuration
	 **/	
	public final native void updateDuration()/*-{
		this.updateDuration();
	}-*/;
	
	/** 
	 * Advances this timeline by the specified amount of time in milliseconds (or ticks if useTicks is true).
	 * This is normally called automatically by the Tween engine (via Tween.tick), but is exposed for advanced uses.
	 * @method tick
	 * @param delta The time to advance in milliseconds (or ticks if useTicks is true).
	 **/	
	public final native void tick(double delta)/*-{
		this.tick(delta);
	}-*/;	
	
	/** 
	 * If a numeric position is passed, it is returned unchanged. If a string is passed, the position of the
	 * corresponding frame label will be returned, or null if a matching label is not defined.
	 * @method resolve
	 * @param positionOrLabel A numeric position value or label string.
	 **/	
	public final native double resolve(String positionOrLabel)/*-{
		return this.resolve(positionOrLabel);
	}-*/;
}
