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
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.Canvas2DJS;

/*A class that represents Container.js
* author: James Tyner 
*/

public class Container extends DisplayObject {

	protected Container(){}
	
	/*
	 * Method used for creating instance of the Container. 
	 */
	public final static native Container createContainer()/*-{
		return new $wnd.createjs.Container();
	}-*/;
	

	/**
	 * Draws the display object into the specified context ignoring it's visible, alpha, shadow, and transform.
	 * Returns true if the draw was handled (useful for overriding functionality).
	 * NOTE: This method is mainly for internal use, though it may be useful for advanced uses.
	 * @method draw
	 * @param {CanvasRenderingContext2D} ctx The canvas 2D context object to draw into.
	 * @param {Boolean} ignoreCache Indicates whether the draw operation should ignore any current cache.
	 * For example, used for drawing the cache (to prevent it from simply drawing an existing cache back
	 * into itself).
	 **/	
	public final native boolean draw(Canvas2DJS object,boolean ignoreCache)/*-{
		return this.draw(object,ignoreCache);
	}-*/;
	
	/**
	 * Adds a child to the top of the display list. You can also add multiple children, such as "addChild(child1, child2, ...);".
	 * Returns the child that was added, or the last child if multiple children were added.
	 * @method addChild
	 * @param {DisplayObject} child The display object to add.
	 * @return {DisplayObject} The child that was added, or the last child if multiple children were added.
	 **/	
	public final native DisplayObject addChild(DisplayObject object)/*-{
		return this.addChild(object);
	}-*/;
	
	/**
	 * Adds a child to the display list at the specified index, bumping children at equal or greater indexes up one, and setting
	 * its parent to this Container. You can also add multiple children, such as "addChildAt(child1, child2, ..., index);". The
	 * index must be between 0 and numChildren. For example, to add myShape under otherShape in the display list, you could use:
	 * container.addChildAt(myShape, container.getChildIndex(otherShape)). This would also bump otherShape's index up by one.
	 * Returns the last child that was added, or the last child if multiple children were added. Fails silently if the index 
	 * is out of range.
	 * @method addChildAt
	 * @param {DisplayObject} child The display object to add.
	 * @param {Number} index The index to add the child at.
	 * @return {DisplayObject} The child that was added, or the last child if multiple children were added.
	 **/	
	public final native DisplayObject addChildAt(DisplayObject object,int index)/*-{
		return this.addChildAt(object,index);
	}-*/;
	
	/**
	 * Removes the specified child from the display list. Note that it is faster to use removeChildAt() if the index is already
	 * known. You can also remove multiple children, such as "removeChild(child1, child2, ...);". Returns true if the child
	 * (or children) was removed, or false if it was not in the display list.
	 * @method removeChild
	 * @param {DisplayObject} child The child to remove.
	 * @return {Boolean} true if the child (or children) was removed, or false if it was not in the display list.
	 **/	
	public final native boolean removeChild(DisplayObject object)/*-{
		return this.removeChild(object);
	}-*/;	
	
	/**
	 * Removes the child at the specified index from the display list, and sets its parent to null. You can also remove multiple
	 * children, such as "removeChildAt(2, 7, ...);". Returns true if the child (or children) was removed, or false if any index
	 * was out of range.
	 * @param {Number} index The index of the child to remove.
	 * @return true if the child (or children) was removed, or false if any index was out of range.
	 **/	
	public final native boolean removeChildAt(int index)/*-{
		return this.removeChildAt(index);
	}-*/;
	
	/**
	 * Removes all children from the display list.
	 * @method removeAllChildren
	 **/	
	public final native void removeAllChildren()/*-{
		this.removeAllChildren();
	}-*/;	
	
	/**
	 * Returns the child at the specified index.
	 * @method getChildAt
	 * @param {Number} index The index of the child to return.
	 * @return {DisplayObject} The child at the specified index.
	 **/	
	public final native DisplayObject getChildAt(int index)/*-{
		return this.getChildAt(index);
	}-*/;
	
	/**
	 * Performs an array sort operation on the child list.
	 * @method sortChildren
	 * @param {Function} sortFunction the function to use to sort the child list. See javascript's Array.sort documentation
	 * for details.
	 **/	
	public final native void sortChildren(JavaScriptObject object)/*-{
		return this.sortChildren(object);
	}-*/;
	
	/**
	 * Returns the index of the specified child in the display list, or -1 if it is not in the display list.
	 * @method getChildIndex
	 * @param {DisplayObject} child The child to return the index of.
	 * @return {Number} The index of the specified child. -1 if the child is not found.
	 **/	
	public final native void getChildIndex(int index)/*-{
		return this.getChildIndex(index);
	}-*/;
	
	
	/**
	 * Returns the number of children in the display list.
	 * @method getNumChildren
	 * @return {Number} The number of children in the display list.
	 **/	
	public final native int getNumChildren()/*-{
		return this.getNumChildren();
	}-*/;
	
	/**
	 * Swaps the children at the specified indexes. Fails silently if either index is out of range.
	 * @param index1
	 * @param index2
	 * @method swapChildrenAt
	 **/	
	public final native int swapChildrenAt(int index1,int index2)/*-{
		return this.swapChildrenAt(index1,index2);
	}-*/;	
	
	/**
	 * Swaps the specified children's depth in the display list. Fails silently if either child is not a child of this Container.
	 * @param child1
	 * @param child2
	 * @method swapChildren
	 **/	
	public final native int swapChildren(DisplayObject object1,DisplayObject object2)/*-{
		return this.swapChildren(object1,object2);
	}-*/;	
	
	/**
	 * Changes the depth of the specified child. Fails silently if the child is not a child of this container, or the index is out of range.
	 * @param child
	 * @param index
	 * @method setChildIndex
	 **/	
	public final native int setChildIndex(DisplayObject object1,int index)/*-{
		return this.setChildIndex(object1,index);
	}-*/;
	
	/**
	 * Returns true if the specified display object either is this container or is a descendent.
	 * (child, grandchild, etc) of this container.
	 * @method contains
	 * @param {DisplayObject} child The DisplayObject to be checked.
	 * @return {Boolean} true if the specified display object either is this container or is a descendent.
	 **/	
	public final native boolean contains(DisplayObject object1)/*-{
		return this.contains(object1);
	}-*/;	
	
	
	/**
	 * Returns an array of all display objects under the specified coordinates that are in this container's display list.
	 * This routine ignores any display objects with mouseEnabled set to false. The array will be sorted in order of visual
	 * depth, with the top-most display object at index 0. This uses shape based hit detection, and can be an expensive operation
	 * to run, so it is best to use it carefully. For example, if testing for objects under the mouse, test on tick (instead of on
	 * mousemove), and only if the mouse's position has changed.
	 * @method getObjectsUnderPoint
	 * @param {Number} x The x position in the container to test.
	 * @param {Number} y The y position in the container to test.
	 * @return {Array[DisplayObject]} An Array of DisplayObjects under the specified coordinates.
	 **/	
	public final native JsArray<DisplayObject> getObjectsUnderPoint(int x,int y)/*-{
		return this.getObjectsUnderPoint(x,y);
	}-*/;
	
	/**
	 * Similar to getObjectsUnderPoint(), but returns only the top-most display object. This runs significantly faster than
	 * getObjectsUnderPoint(), but is still an expensive operation. See getObjectsUnderPoint() for more information.
	 * @method getObjectUnderPoint
	 * @param {Number} x The x position in the container to test.
	 * @param {Number} y The y position in the container to test.
	 * @return {DisplayObject} The top-most display object under the specified coordinates.
	 **/	
	public final native DisplayObject getObjectUnderPoint(int x,int y)/*-{
		return this.getObjectUnderPoint(x,y);
	}-*/;
	
	/*
	 * Sets the Hue of the Container
	 */
	public final native void setHue(int hue)/*-{
		this.hue = hue;
	}-*/;
	
	/*
	 * gets the Hue of the Container
	 */
	public final native int getHue()/*-{
		return this.hue;
	}-*/;
	
	/*
	 * Callback for the method tick
	 */
	public final native void doTick(CallBack callBack)/*-{
		this.tick = function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
		}
	}-*/;
	
	/*
	 * Generic callback for the property.
	 */
	public final native void addJavaScriptCallBack(String propertyname,CallBack callBack)/*-{
		var data= this;
		data[propertyname] = function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
		};
	}-*/;
	
}
