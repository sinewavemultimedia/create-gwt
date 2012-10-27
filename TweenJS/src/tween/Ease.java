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

/*A  class that represents Ease.js
* author: James Tyner 
*/

public class Ease extends JavaScriptObject {

	protected Ease(){}
	
	public static native final Ease createEase()/*-{
		return $wnd.createjs.Ease;
	}-*/;
	
	/** 
	 * Mimics the simple -100 to 100 easing in Flash Pro.
	 * @method get
	 * @param amount A value from -1 (ease in) to 1 (ease out) indicating the strength and direction of the ease.
	 * @static
	 **/	
	public static native final EaseFunction get(int amount)/*-{
		return $wnd.createjs.Ease.get(amount);
	}-*/;
	
	/** 
	 * Configurable exponential ease.
	 * @method getPowIn
	 * @param pow The exponent to use (ex. 3 would return a cubic ease).
	 * @static
	 **/	
	public static native final EaseFunction getPowIn(double t)/*-{
		return $wnd.createjs.Ease.getPowIn(t);
	}-*/;
	
	/** 
	 * Configurable exponential ease.
	 * @method getPowOut
	 * @param pow The exponent to use (ex. 3 would return a cubic ease).
	 * @static
	 **/	
	public static native final EaseFunction getPowOut(double t)/*-{
		return $wnd.createjs.Ease.getPowOut(t);
	}-*/;	
	
	/** 
	 * Configurable exponential ease.
	 * @method getPowInOut
	 * @param pow The exponent to use (ex. 3 would return a cubic ease).
	 * @static
	 **/	
	public static native final EaseFunction getPowInOut(double t)/*-{
		return $wnd.createjs.Ease.getPowInOut(t);
	}-*/;
	
	public static native final EaseFunction quadIn()/*-{
		return $wnd.createjs.Ease.quadIn;
	}-*/;
	
	public static native final EaseFunction quadOut()/*-{
		return $wnd.createjs.Ease.quadOut;
	}-*/;
	
	public static native final EaseFunction quadInOut()/*-{
		return $wnd.createjs.Ease.quadInOut;
	}-*/;
	
	public static native final EaseFunction linear()/*-{
		return $wnd.createjs.Ease.linear;
	}-*/;	
	
	public static native final EaseFunction cubicIn()/*-{
		return $wnd.createjs.Ease.cubicIn;
	}-*/;
	
	public static native final EaseFunction none()/*-{
		return $wnd.createjs.Ease.none;
	}-*/;
	
	public static native final EaseFunction quartInOut()/*-{
		return $wnd.createjs.Ease.quartInOut;
	}-*/;	
	
	public static native final EaseFunction cubicOut()/*-{
		return $wnd.createjs.Ease.cubicOut;
	}-*/;
	
	public static native final EaseFunction cubicInOut()/*-{
		return $wnd.createjs.Ease.cubicInOut;
	}-*/;
	
	public static native final EaseFunction quartIn()/*-{
		return $wnd.createjs.Ease.quartIn;
	}-*/;
	
	public static native final EaseFunction quartOut()/*-{
		return $wnd.createjs.Ease.quartOut;
	}-*/;
	
	public static native final EaseFunction quintInOut()/*-{
		return $wnd.createjs.Ease.quintInOut;
	}-*/;
	
	public static native final EaseFunction quintIn()/*-{
		return $wnd.createjs.Ease.quintIn;
	}-*/;	
	
	public static native final EaseFunction sineIn()/*-{
		return $wnd.createjs.Ease.sineIn;
	}-*/;
	
	public static native final EaseFunction quintOut()/*-{
		return $wnd.createjs.Ease.quintOut;
	}-*/;	
	
	public static native final EaseFunction sineOut()/*-{
		return $wnd.createjs.Ease.sineOut;
	}-*/;
	
	public static native final EaseFunction sineInOut()/*-{
		return $wnd.createjs.Ease.sineInOut;
	}-*/;
	
	public static native final EaseFunction getBackIn(double t)/*-{
		return $wnd.createjs.Ease.getBackIn(t);
	}-*/;
	
	public static native final EaseFunction backIn()/*-{
		return $wnd.createjs.Ease.backIn;
	}-*/;
	
	public static native final EaseFunction getBackOut(double t)/*-{
		return $wnd.createjs.Ease.getBackOut(t);
	}-*/;
	
	public static native final EaseFunction backOut()/*-{
		return $wnd.createjs.Ease.backOut;
	}-*/;
	
	public static native final EaseFunction getBackInOut(double t)/*-{
		return $wnd.createjs.Ease.getBackInOut(t);
	}-*/;

	public static native final EaseFunction backInOut()/*-{
		return $wnd.createjs.Ease.backInOut;
	}-*/;
	
	public static native final EaseFunction circIn()/*-{
		return $wnd.createjs.Ease.circIn;
	}-*/;
	
	public static native final EaseFunction circOut()/*-{
		return $wnd.createjs.Ease.circOut;
	}-*/;

	public static native final EaseFunction circInOut()/*-{
		return $wnd.createjs.Ease.circInOut;
	}-*/;
	
	public static native final EaseFunction bounceIn()/*-{
		return $wnd.createjs.Ease.bounceIn;
	}-*/;
	
	public static native final EaseFunction bounceOut()/*-{
		return $wnd.createjs.Ease.bounceOut;
	}-*/;
	
	public static native final EaseFunction bounceInOut()/*-{
		return $wnd.createjs.Ease.bounceInOut;
	}-*/;
	
	public static native final EaseFunction getElasticIn(double amplitude,double period)/*-{
		return $wnd.createjs.Ease.getElasticIn(amplitude,period);
	}-*/;
	
	public static native final EaseFunction elasticIn()/*-{
		return $wnd.createjs.Ease.getElasticIn;
	}-*/;	

	public static native final EaseFunction getElasticOut(double amplitude,double period)/*-{
		return $wnd.createjs.Ease.getElasticOut(amplitude,period);
	}-*/;
	
	public static native final EaseFunction elasticOut()/*-{
		return $wnd.createjs.Ease.elasticOut;
	}-*/;
	
	public static native final EaseFunction getElasticInOut(double amplitude,double period)/*-{
		return $wnd.createjs.Ease.getElasticInOut(amplitude,period);
	}-*/;
	
	public static native final EaseFunction elasticInOut()/*-{
		return $wnd.createjs.Ease.elasticInOut;
	}-*/;	

}