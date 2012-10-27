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

/*A class the represents Ticker.js
* author: James Tyner 
*/
public class Ticker extends JavaScriptObject {
	
	public static boolean useRAF = false;

	protected Ticker(){}
	
	/**
	 * Indicates whether Ticker should use requestAnimationFrame if it is supported in the browser. If false, Ticker
	 * will use setTimeout. If you use RAF, it is recommended that you set the framerate to a divisor of 60 (ex. 15,
	 * 20, 30, 60).
	 * @property useRAF
	 * @static
	 * @type Boolean
	 **/	
	public static native void setUseRAF(boolean useRAF)/*-{
		$wnd.createjs.Ticker.useRAF = useRAF;
	}-*/;

	/**
	 * Adds a listener for the tick event. The listener must be either an object exposing a .tick() method,
	 * or a function. The listener will be called once each tick / interval. The interval is specified via the 
	 * .setInterval(ms) method.
	 * The tick method or function is passed two parameters: the elapsed time between the 
	 * previous tick and the current one, and a boolean indicating whether Ticker is paused.
	 * @method addListener
	 * @static
	 * @param {Object} o The object or function to add as a listener.
	 * @param {Boolean} pauseable If false, the listener will continue to have tick called 
	 * even when Ticker is paused via Ticker.pause(). Default is true.
	 **/	
	public static native void addListener(JavaScriptObject listener,boolean pauseable)/*-{
		$wnd.createjs.Ticker.addListener(listener,pauseable);
	}-*/;
	
	public static native void addListener(JavaScriptObject listener)/*-{
		$wnd.createjs.Ticker.addListener(listener,true);
	}-*/;	
	
	/**
	 * Initializes or resets the timer, clearing all associated listeners and fps measuring data, starting the tick.
	 * This is called automatically when the first listener is added.
	 * @method init
	 * @static
	 **/	
	public static native void init()/*-{
		$wnd.createjs.Ticker.init();
	}-*/;
	
	/**
	 * Removes the specified listener.
	 * @method removeListener
	 * @static
	 * @param {Object} o The object or function to remove from listening from the tick event.
	 **/	
	public static native void removeListener(JavaScriptObject listener)/*-{
		$wnd.createjs.Ticker.removeListener(listener);
	}-*/;
	
	/**
	 * Removes all listeners.
	 * @method removeAllListeners
	 * @static
	 **/	
	public static native void removeAllListeners()/*-{
		$wnd.createjs.Ticker.removeAllListeners();
	}-*/;	
	
	/**
	 * Sets the target time (in milliseconds) between ticks. Default is 50 (20 FPS).
	 * Note actual time between ticks may be more than requested depending on CPU load.
	 * @method setInterval
	 * @static
	 * @param {Number} interval Time in milliseconds between ticks. Default value is 50.
	 **/	
	public static native void setInterval(int interval)/*-{
		$wnd.createjs.Ticker.setInterval(interval);
	}-*/;
	
	/**
	 * Returns the current target time between ticks, as set with setInterval.
	 * @method getInterval
	 * @static
	 * @return {Number} The current target interval in milliseconds between tick events.
	 **/	
	public static native int getInterval()/*-{
		return $wnd.createjs.Ticker.getInterval();
	}-*/;	
	
	/**
	 * Sets the target frame rate in frames per second (FPS). For example, with an interval of 40, getFPS() will 
	 * return 25 (1000ms per second divided by 40 ms per tick = 25fps).
	 * @method setFPS
	 * @static
	 * @param {Number} value Target number of ticks broadcast per second.
	 **/	
	public static native void setFPS(int interval)/*-{
		$wnd.createjs.Ticker.setFPS(interval);
	}-*/;
	
	/**
	 * Returns the target frame rate in frames per second (FPS). For example, with an 
	 * interval of 40, getFPS() will return 25 (1000ms per second divided by 40 ms per tick = 25fps).
	 * @method getFPS
	 * @static
	 * @return {Number} The current target number of frames / ticks broadcast per second.
	 **/	
	public static native double getFPS()/*-{
		return $wnd.createjs.Ticker.getFPS();
	}-*/;		
	
	/**
	 * Returns the actual frames / ticks per second.
	 * @method getMeasuredFPS
	 * @static
	 * @param {Number} ticks Optional. The number of previous ticks over which to measure the actual 
	 * frames / ticks per second. Defaults to the number of ticks per second.
	 * @return {Number} The actual frames / ticks per second. Depending on performance, this may differ
	 * from the target frames per second.
	 **/	
	public static native double getMeasuredFPS(int ticks)/*-{
		return $wnd.createjs.Ticker.getMeasuredFPS(ticks);
	}-*/;
	
	public static native double getMeasuredFPS()/*-{
		return $wnd.createjs.Ticker.getMeasuredFPS();
	}-*/;		
	
	/**
	 * While Ticker is paused, pausable listeners are not ticked. See addListener for more information.
	 * @method setPaused
	 * @static
	 * @param {Boolean} value Indicates whether to pause (true) or unpause (false) Ticker.
	 **/	
	public static native void setPaused(boolean value)/*-{
		$wnd.createjs.Ticker.setPaused(value);
	}-*/;
	
	/**
	 * Returns a boolean indicating whether Ticker is currently paused, as set with setPaused.
	 * @method getPaused
	 * @static
	 * @return {Boolean} Whether the Ticker is currently paused.
	 **/	
	public static native void getPaused()/*-{
		return $wnd.createjs.Ticker.getPaused();
	}-*/;
	
	/**
	 * Returns the number of milliseconds that have elapsed since the first tick event listener was added to
	 * Ticker. For example, you could use this in a time synchronized animation to determine the exact amount of 
	 * time that has elapsed.
	 * @method getTime
	 * @static
	 * @param {Boolean} pauseable Indicates whether to include time elapsed
	 * while Ticker was paused. If false only time elapsed while Ticker is not paused will be returned.
	 * If true, the value returned will be total time elapsed since the first tick event listener was added.
	 * @return {Number} Number of milliseconds that have elapsed since Ticker was begun.
	 **/	
	public static native int getTime(boolean value)/*-{
		return $wnd.createjs.Ticker.getTime(value);
	}-*/;
	
	/**
	 * Returns the number of ticks that have been broadcast by Ticker.
	 * @method getTicks
	 * @static
	 * @param {Boolean} pauseable Indicates whether to include ticks that would have been broadcast
	 * while Ticker was paused. If false only tick events broadcast while Ticker is not paused will be returned.
	 * If true, tick events that would have been broadcast while Ticker was paused will be included in the return
	 * value. The default value is false.
	 * @return {Number} of ticks that have been broadcast.
	 **/	
	public static native int getTicks(boolean value)/*-{
		return $wnd.createjs.Ticker.getTicks(value);
	}-*/;	
}
