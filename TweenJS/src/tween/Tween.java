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
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CallBackTween;
import com.sinewavemultimedia.easeljs.framework.js.display.DisplayObject;
import com.sinewavemultimedia.easeljs.framework.js.sound.Plugin;

/*A  class that represents Tween.js
* author: James Tyner 
*/

public class Tween extends JavaScriptObject {

	protected Tween(){}
	
	/** 
	 * Constant defining the none actionsMode for use with setPosition.
	 * @property NONE
	 * @type Number
	 * @static
	 **/	
	public static native final int NONE()/*-{
		return $wnd.createjs.Tween.NONE;
	}-*/;
	
	public static native final void NONE(int NONE)/*-{
		$wnd.createjs.Tween.NONE = NONE;
	}-*/;
	
	/** 
	 * Constant defining the loop actionsMode for use with setPosition.
	 * @property LOOP
	 * @type Number
	 * @static
	 **/	
	public static native final int LOOP()/*-{
		return $wnd.createjs.Tween.LOOP;
	}-*/;
	
	public static native final void LOOP(int LOOP)/*-{
		$wnd.createjs.Tween.LOOP = LOOP;
	}-*/;
	
	/** 
	 * Constant defining the reverse actionsMode for use with setPosition.
	 * @property REVERSE
	 * @type Number
	 * @static
	 **/	
	public static native final int REVERSE()/*-{
		return $wnd.createjs.Tween.REVERSE;
	}-*/;
	
	public static native final void REVERSE(int REVERSE)/*-{
		$wnd.createjs.Tween.REVERSE = REVERSE;
	}-*/;
	
	/**
	 * Advances all tweens. This typically uses the Ticker class (available in the EaselJS library), but you can call it manually if you prefer to use
	 * your own "heartbeat" implementation.
	 * @method tick
	 * @static
	 * @param delta The change in time in milliseconds since the last tick. Required unless all tweens have useTicks set to true.
	 * @param paused Indicates whether a global pause is in effect. Tweens with ignoreGlobalPause will ignore this, but all others will pause if this is true.
	 **/	
	public static native final void tick(double delta,boolean paused)/*-{
		$wnd.createjs.Tween.tick(delta,paused);
	}-*/;

	/** 
	 * Removes all existing tweens for a target. This is called automatically by new tweens if the "override" prop is true.
	 * @method removeTweens
	 * @static
	 * @param target The target object to remove existing tweens from.
	 **/	
	public static native final void removeTweens(DisplayObject target)/*-{
		$wnd.createjs.Tween.removeTweens(target);
	}-*/;
	
	/** 
	 * Indicates whether there are any active tweens on the target object (if specified) or in general.
	 * @method hasActiveTweens
	 * @static
	 * @param target Optional. If not specified, the return value will indicate if there are any active tweens on any target.
	 * @return Boolean A boolean indicating whether there are any active tweens.
	 **/
	
	public static native final boolean hasActiveTweens(DisplayObject target)/*-{
		return $wnd.createjs.Tween.hasActiveTweens(target);
	}-*/;	
	
	/** 
	 * Installs a plugin, which can modify how certain properties are handled when tweened.
	 * See the CSSPlugin for an example of how to write TweenJS plugins.
	 * @method installPlugin
	 * @static
	 * @param plugin
	 * @param properties
	 **/	
	public static native final void installPlugin(JavaScriptObject plugin,Property properties)/*-{
		$wnd.createjs.Tween.installPlugin(plugin,properties);
	}-*/;
	
	/**
	 * Returns a new tween instance. This is functionally identical to using "new Tween(...)", but looks cleaner
	 * with the chained syntax of TweenJS.
	 * @method get
	 * @static
	 * @param target The target object that will have its properties tweened.
	 * @param props The configuration properties to apply to this tween instance (ex. {loop:true, paused:true}). All properties default to false. Supported props are:<UL>
	 *    <LI> loop: sets the loop property on this tween.</LI>
	 *    <LI> useTicks: uses ticks for all durations instead of milliseconds.</LI>
	 *    <LI> ignoreGlobalPause: sets the ignoreGlobalPause property on this tween.</LI>
	 *    <LI> override: if true, Tween.removeTweens(target) will be called to remove any other tweens with the same target.
	 *    <LI> paused: indicates whether to start the tween paused.</LI>
	 *    <LI> position: indicates the initial position for this tween.</LI>
	 *    <LI> onChanged: specifies an onChange handler for this tween.</LI>
	 * </UL>
	 **/	
	public native static final Tween get(DisplayObject target,Property property)/*-{
		return $wnd.createjs.Tween.get(target,property);
	}-*/;
	
	public native static final Tween get(DisplayObject target)/*-{
		return $wnd.createjs.Tween.get(target);
	}-*/;	
	
	public native static final Tween get(DisplayObject target,Property property,JavaScriptObject pluginData)/*-{
		return $wnd.createjs.Tween.get(target,property,pluginData);
	}-*/;
	
	public native static final Tween get(DisplayObject target,Property property,boolean pluginData)/*-{
		return $wnd.createjs.Tween.get(target,property,pluginData);
	}-*/;	
	
	/**
	 * Causes this tween to continue playing when a global pause is active. For example, if TweenJS is using Ticker,
	 * then setting this to true (the default) will cause this tween to be paused when Ticker.setPaused(true) is called.
	 * See Tween.tick() for more info. Can be set via the props param.
	 * @property ignoreGlobalPause
	 * @type Boolean
	 **/	
	public native final boolean ignoreGlobalPause()/*-{
		return this.ignoreGlobalPause;
	}-*/;
	
	public native final void setIgnoreGlobalPause(boolean ignoreGlobalPause)/*-{
		return this.ignoreGlobalPause = ignoreGlobalPause;
	}-*/;
	
	/**
	 * If true, the tween will loop when it reaches the end. Can be set via the props param.
	 * @property loop
	 * @type Boolean
	 **/	
	public native final boolean loop()/*-{
		return this.loop;
	}-*/;
	
	public native final void setLoop(boolean loop)/*-{
		return this.loop = loop;
	}-*/;
	
	/**
	 * Read-only. Specifies the total duration of this tween in milliseconds (or ticks if useTicks is true).
	 * This value is automatically updated as you modify the tween. Changing it directly could result in unexpected
	 * behaviour.
	 * @property duration
	 * @type Number
	 **/	
	public native final double getDuration()/*-{
		return this.duration;
	}-*/;
	
	public native final void setDuration(double duration)/*-{
		return this.duration = duration;
	}-*/;
	
	/**
	 * Allows you to specify data that will be used by installed plugins. Each plugin uses this differently, but in general
	 * you specify data by setting it to a property of pluginData with the same name as the plugin class.<br/>
	 * Ex. myTween.pluginData.PluginClassName = data;<br/>
	 * <br/>
	 * Also, most plugins support a property to enable or disable them. This is typically the plugin class name followed by "_enabled".<br/>
	 * Ex. myTween.pluginData.PluginClassName_enabled = false;<br/>
	 * <br/>
	 * Some plugins also store instance data in this object, usually in a property named _PluginClassName.
	 * See the documentation for individual plugins for more details.
	 * @property pluginData
	 * @type Object
	 **/	
	public native final Plugin getPluginData()/*-{
		return this.pluginData;
	}-*/;
	
	public native final void setPluginData(Plugin pluginData)/*-{
		return this.pluginData = pluginData;
	}-*/;	

	/**
	 * Called whenever the tween's position changes with a single parameter referencing this tween instance.
	 * @property onChange
	 * @type Function
	 **/	
	public final native void onChange(CallBack callBack)/*-{
		this.onChange=function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
		}	
	}-*/;

	/**
	 * Read-only. The target of this tween. This is the object on which the tweened properties will be changed. Changing 
	 * this property after the tween is created will not have any effect.
	 * @property target
	 * @type Object
	 **/	
	public native final DisplayObject getTarget()/*-{
		return this.target;
	}-*/;
	
	/**
	 * Read-only. The current normalized position of the tween. This will always be a value between 0 and duration.
	 * Changing this property directly will have no effect.
	 * @property position
	 * @type Object
	 **/	
	public native final int getPosition()/*-{
		return this.position;
	}-*/;	
	
	
	/** 
	 * Queues a wait (essentially an empty tween).
	 * @method wait
	 * @param duration The duration of the wait in milliseconds (or in ticks if useTicks is true).
	 * @return Tween This tween instance (for chaining calls).
	 **/	
	public native final Tween waitDuration(double duration)/*-{
		return this.wait(duration);
	}-*/;

	/** 
	 * Queues a tween from the current values to the target properties. Set duration to 0 to jump to these value.
	 * Numeric properties will be tweened from their current value in the tween to the target value. Non-numeric
	 * properties will be set at the end of the specified duration.
	 * @method to
	 * @param props An object specifying property target values for this tween (Ex. {x:300} would tween the x property of the target to 300).
	 * @param duration Optional. The duration of the wait in milliseconds (or in ticks if useTicks is true). Defaults to 0.
	 * @param ease Optional. The easing function to use for this tween. Defaults to a linear ease.
	 * @return Tween This tween instance (for chaining calls).
	 **/	
	public native final Tween to(Property props)/*-{
		return this.to(props);
	}-*/;
	
	public native final Tween to(Property props,double duration)/*-{
		return this.to(props,duration);
	}-*/;
	
	public native final Tween to(Property props,double duration,EaseFunction ease)/*-{
		return this.to(props,duration,ease);
	}-*/;

	public native final Tween to(Property props,double duration,double ease)/*-{
		return this.to(props,duration,ease);
	}-*/;

	/** 
	 * Queues an action to call the specified function. For example: myTween.wait(1000).call(myFunction); would call myFunction() after 1s.
	 * @method call
	 * @param callback The function to call.
	 * @param params Optional. The parameters to call the function with. If this is omitted, then the function will be called with a single param pointing to this tween.
	 * @param scope Optional. The scope to call the function in. If omitted, it will be called in the target's scope.
	 * @return Tween This tween instance (for chaining calls).
	 **/	
	public native final Tween call(CallBackTween callback)/*-{
		var callbackfunc = function(tween){
			callback.@com.sinewavemultimedia.easeljs.framework.js.CallBackTween::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/tween/Tween;)(tween);
		}	
		return this.call(callbackfunc);
	}-*/;

	/** 
	 * Queues an action to set the specified props on the specified target. If target is null, it will use this tween's target. Ex. myTween.wait(1000).set({visible:false},foo);
	 * @method set
	 * @param props The properties to set (ex. {visible:false}).
	 * @param target Optional. The target to set the properties on. If omitted, they will be set on the tween's target.
	 * @return Tween This tween instance (for chaining calls).
	 **/	
	public native final Tween set(Property props,DisplayObject target)/*-{
		return this.set(props,target);
	}-*/;
	
	public native final Tween set(Property props)/*-{
		return this.set(props);
	}-*/;
	
	/** 
	 * Queues an action to to play (unpause) the specified tween. This enables you to sequence multiple tweens. Ex. myTween.to({x:100},500).play(otherTween);
	 * @method play
	 * @param tween The tween to play.
	 * @return Tween This tween instance (for chaining calls).
	 **/	
	public native final Tween play(Tween tween)/*-{
		return this.play(tween);
	}-*/;
	
	/** 
	 * Queues an action to to pause the specified tween.
	 * @method pause
	 * @param tween The tween to play. If null, it pauses this tween.
	 **/	
	public native final Tween pause(Tween tween)/*-{
		return this.pause(tween);
	}-*/;	
	
	/** 
	 * Advances the tween to a specified position.
	 * @method setPosition
	 * @param value The position to seek to in milliseconds (or ticks if useTicks is true).
	 * @param actionsMode Optional parameter specifying how actions are handled (ie. call, set, play, pause): Tween.NONE (0) - run no actions. Tween.LOOP (1) - if new position is less than old, then run all actions between old and duration, then all actions between 0 and new. Defaults to LOOP. Tween.REVERSE (2) - if new position is less than old, run all actions between them in reverse. 
	 * @return Boolean Returns true if the tween is complete (ie. the full tween has run & loop is false).
	 **/	
	public native final boolean setPosition(double value,int actionsMode)/*-{
		return this.setPosition(value,actionsMode);
	}-*/;
		
	/** 
	 * Advances this tween by the specified amount of time in milliseconds (or ticks if useTicks is true).
	 * This is normally called automatically by the Tween engine (via Tween.tick), but is exposed for advanced uses.
	 * @method tick
	 * @param delta The time to advance in milliseconds (or ticks if useTicks is true).
	 **/	
	public native final void tick(double delta)/*-{
		return this.tick(delta);
	}-*/;	

	/** 
	 * Pauses or plays this tween.
	 * @method setPaused
	 * @param value Indicates whether the tween should be paused (true) or played (false).
	 **/	
	public native final Tween setPaused(boolean value)/*-{
		return this.setPaused(value);
	}-*/;	
}
