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
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Element;
import com.sinewavemultimedia.easeljs.framework.js.AnimationReturn;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.Image;
import com.sinewavemultimedia.easeljs.framework.js.SpriteSheetObject;

/*A class the represents SpriteSheet.js
* author: James Tyner 
*/
public class SpriteSheet extends JavaScriptObject {
	
	protected SpriteSheet(){}
	
	/*
	 * return if the sprite loading is complete 
	 */
	public final native boolean complete()/*-{
		return this.complete;
	}-*/;
	
	/*
	 * CallBack method that invokes after the Sprite is loaded
	 */
	public final native void onComplete(CallBackEvent callBack)/*-{
		this.onComplete = function(event){
		 callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
		};
	}-*/;
	
	/*
	 * Creates a spritesheet object based on SpriteSheetObject.
	 */
	public final native static SpriteSheet create(SpriteSheetObject object)/*-{
		return new $wnd.createjs.SpriteSheet(object);
	}-*/;
	
	/*
	 * Returns the number of frames for the particular animationName.
	 */
	public final native int getNumFrames(String animationName)/*-{
		return this.getNumFrames(animationName);
	}-*/;

	/*
	 * Returns the number of frames.
	 */
	public final native int getNumFrames()/*-{
		return this.getNumFrames();
	}-*/;	
	
	/*
	 * List the array of animation objects
	 */
	public final native JsArray getAnimations()/*-{
		return this.getAnimations();
	}-*/;
	
	/*
	 * Returns animation object for particular Name
	 */
	public final native AnimationReturn getAnimation(String name)/*-{
		return this.getAnimation(name);
	}-*/;	
	
	/*
	 * returns the Frame of a particular Index
	 */
	public final native JavaScriptObject getFrame(int index)/*-{
		return this.getFrame(index);
	}-*/;		

	public final native SpriteSheet clone()/*-{
		return this.clone();
	}-*/;

	/*
	 * returns the Image of a particular Index
	 */	
	public final native Image getImage(int index) /*-{
		return this._images[index];
	}-*/;	

	public final native boolean isComplete()/*-{
		return this.complete
	}-*/;
}
