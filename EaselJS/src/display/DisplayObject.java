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

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Element;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.EventTarget;
import com.sinewavemultimedia.easeljs.framework.js.filters.Filter;
import com.sinewavemultimedia.easeljs.framework.js.geom.Matrix2D;
import com.sinewavemultimedia.easeljs.framework.js.geom.Point;

/*A class that represents Displayobject.js
* author: James Tyner 
* 
*/

public class DisplayObject extends JavaScriptObject {
	
	protected DisplayObject(){}
	
	/**
	 * Suppresses errors generated when using features like hitTest, onPress/onClick, and getObjectsUnderPoint with cross
	 * domain content
	 * @property suppressCrossDomainErrors
	 * @static
	 * @type Boolean
	 * @default false
	 **/	
	public final static native void setSuppressCrossDomainErrors(boolean value)/*-{
		$wnd.createjs.DisplayObject.suppressCrossDomainErrors = value;
	}-*/; 

	public final static native boolean getSuppressCrossDomainErrors(boolean value)/*-{
		return $wnd.createjs.DisplayObject.suppressCrossDomainErrors;
	}-*/; 
	
   /*
	* Method used for creating instance. 
	*  DisplayObject is an abstract class that should not be constructed directly. Instead construct subclasses such as
	* Container, Bitmap, and Shape. DisplayObject is the base class for all display classes in the EaselJS library.
	* It defines the core properties and methods that are shared between all display objects.
	* @class DisplayObject
	* @constructor
	**/	
	public final native static DisplayObject create()/*-{
		return new $wnd.createjs.DisplayObject();
	}-*/;
	
	/**
	 * Unique ID for this display object. Makes display objects easier for some uses.
	 * @property id
	 * @type Number
	 * @default -1
	 **/	
	public final native double getId()/*-{
		return this.id;
	}-*/;	
	
	public final native void setId(double id)/*-{
		this.id = id;
	}-*/;
	
	/**
	 * If a cache is active, this returns the canvas that holds the cached version of this display object. See cache()
	 * for more information. READ-ONLY.
	 * @property cacheCanvas
	 * @type HTMLCanvasElement
	 * @default null
	 **/	
	public final native Element getCacheCanvas()/*-{
		return this.cacheCanvas;
	}-*/;	
	
	public final native void setCacheCanvas(Element cacheCanvas)/*-{
		this.cacheCanvas = cacheCanvas;
	}-*/;
	
	/**
	 * The alpha (transparency) for this display object. 0 is fully transparent, 1 is fully opaque.
	 * @property alpha
	 * @type Number
	 * @default 1
	 **/	
	public final native double getAlpha()/*-{
		return this.alpha;
	}-*/;
	
	/*
	 * Generic int propery for setting integer attribute
	 */
	public final native void addIntProperty(String propertyname,int value)/*-{
		var data= this;
		data[propertyname] = value;
	}-*/;
	
	
	/*
	 * returns the int property of the display object
	 */
	public final native int getIntProperty(String propertyname)/*-{
		var data= this;
		return data[propertyname];
	}-*/;	

	/*
	 * Generic boolean propery for setting integer attribute
	 */	
	public final native void addBooleanProperty(String propertyname,boolean value)/*-{
		var data= this;
		data[propertyname] = value;
	}-*/;
	
	/*
	 * returns the boolean property of the display object
	 */	
	public final native boolean getBooleanProperty(String propertyname)/*-{
		var data= this;
		return (data[propertyname] != null )?  data[propertyname] : false;
	}-*/;	

	/*
	 * Generic double property for setting double attribute
	 */		
	public final native void addDoubleProperty(String propertyname,double value)/*-{
		var data= this;
		data[propertyname] = value;
	}-*/;
	
	/*
	 * returns the double property of the display object
	 */		
	public final native double getDoubleProperty(String propertyname)/*-{
		var data= this;
		return data[propertyname];
	}-*/;	

	/*
	 * Generic Javascript property for setting Object attribute
	 */		
	public final native void addJavaScriptProperty(String propertyname,JavaScriptObject value)/*-{
		var data= this;
		data[propertyname] = value;
	}-*/;
	

	/*
	 * Generic Javascript property for getting Object attribute
	 */			
	public final native JavaScriptObject getJavaScriptProperty(String propertyname)/*-{
		var data= this;
		return data[propertyname];
	}-*/;		

	/*
	 * Sets the alpha of the Object.
	 */
	public final native void setAlpha(double alpha)/*-{
		this.alpha = alpha;
	}-*/;	
	
	/*
	 * sets the mouse enabled of the Object.
	 */
	public final native void setMouseEnabled(boolean mouseEnabled)/*-{
		this.mouseEnabled = mouseEnabled;
	}-*/;
	
	/*
	 * Gets the mouse enabled of the object.
	 */
	public final native boolean isMouseEnabled()/*-{
		return this.mouseEnabled();
	}-*/;
	
	
	/*
	 * Visibility of the Object
	 */
	public final native void setVisible(boolean visible)/*-{
		this.visible = visible;
	}-*/;

	
	public final native boolean isVisible()/*-{
		return this.visible;
	}-*/;
	
	public final native void setName(String name)/*-{
		this.name = name;
	}-*/;
	
	
	/*
	 * Sets the name of the Display object
	 */
	public final native boolean getName()/*-{
		return this.name;
	}-*/;	
	
	/*
	 * Sets the parent of the display object
	 */
	public final native void setParent(DisplayObject parent)/*-{
		this.parent = parent;
	}-*/;
	
	
	public final native DisplayObject getParent()/*-{
		return this.parent;
	}-*/;
	
	/*
	 * Sets the ScaleX of the object
	 */
	public final native void setScaleX(double scaleX)/*-{
		this.scaleX = scaleX;
	}-*/;
	
	
	public final native double getScaleX()/*-{
		return this.scaleX;
	}-*/;	
	
	/*
	 * Sets the ScaleY of the object
	 */
	public final native void setScaleY(double scaleY)/*-{
		this.scaleY = scaleY;
	}-*/;
	
	
	public final native double getScaleY()/*-{
		return this.scaleY;
	}-*/;
	
	/*
	 * Sets the SkewX of the object
	 */	
	public final native void setSkewX(double skewX)/*-{
		this.skewX = skewX;
	}-*/;
	
	
	public final native double getSkewX()/*-{
		return this.skewX;
	}-*/;	

	/*
	 * Sets the SkewY of the object
	 */		
	public final native void setSkewY(double skewY)/*-{
		this.skewY = skewY;
	}-*/;
	
	
	public final native double getSkewY()/*-{
		return this.skewY;
	}-*/;
	
		
	/*
	 * Sets the RegX of the object
	 */		
	public final native void setRegX(double regX)/*-{
		this.regX = regX;
	}-*/;
	
	
	public final native double getRegX()/*-{
		return this.regX;
	}-*/;	

	/*
	 * Sets the RegY of the object
	 */			
	public final native void setRegY(double regY)/*-{
		this.regY = regY;
	}-*/;
	
	
	public final native double getRegY()/*-{
		return this.regY;
	}-*/;
	
	/*
	 * Sets the Rotation of the object
	 */			
	public final native void setRotation(double rotation)/*-{
		this.rotation = rotation;
	}-*/;
	
	
	public final native double getRotation()/*-{
		return this.rotation;
	}-*/;	
	
	/*
	 * Sets the Shadow of the object
	 */			
	public final native void setShadow(Shadow shadow)/*-{
		this.shadow = shadow;
	}-*/;
	
	/*
	 * onMousePress for CallBack method of the Display Object
	 */
	public final native void onPress(CallBackEvent callBack)/*-{
		this.onPress =function(event){
		 callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
		};
	}-*/;

	/*
	 * onClick CallBack method of the Display Object
	 */	
	public final native void onClick(CallBackEvent callBack)/*-{
		this.onClick = function(event){
		 callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
		};
	}-*/;

	/*
	 * onDoubleClick CallBack method of the Display Object
	 */		
	public final native void onDoubleClick(CallBackEvent callBack)/*-{
		this.onDoubleClick = function(event){
		 callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
		};
	}-*/;	

	/*
	 * onMouseOver CallBack method of the Display Object
	 */
	public final native void onMouseOver(CallBackEvent callBack)/*-{
		this.onMouseOver = function(event){
		 callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
		};
	}-*/;

	/*
	 * onMouseOut CallBack method of the Display Object
	 */	
	public final native void onMouseOut(CallBackEvent callBack)/*-{
		this.onMouseOut = function(event){
		 callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
		};
	}-*/;	

	/*
	 * Tick Method with CallBack method of the Display Object
	 */		
	public final native void onTick(CallBackEvent callBack)/*-{
		this.onTick = function(event){
		 callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBackEvent::onSuccess(Lcom/sinewavemultimedia/easeljs/framework/js/Event;)(event);
		};
	}-*/;		
	
	/**
	 * A shadow object that defines the shadow to render on this display object. Set to null to remove a shadow. If
	 * null, this property is inherited from the parent container.
	 * @property shadow
	 * @type Shadow
	 * @default null
	 **/	
	public final native Shadow getShadow()/*-{
		return this.shadow;
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
	public final native boolean draw(Canvas object,boolean ignoreCache)/*-{
		return this.draw(object,ignoreCache);
	}-*/;
	
	/**
	 * Applies this display object's transformation, alpha, globalCompositeOperation, clipping path (mask), and shadow to the specified
	 * context. This is typically called prior to draw.
	 * @method setupContext
	 * @param {CanvasRenderingContext2D} ctx The canvas 2D to update.
	 **/	
	public final native void updateContext(Canvas object)/*-{
		this.updateContext(object);
	}-*/;
	
	/**
	 * Draws the display object into a new canvas, which is then used for subsequent draws. For complex content
	 * that does not change frequently (ex. a Container with many children that do not move, or a complex vector Shape),
	 * this can provide for much faster rendering because the content does not need to be re-rendered each tick. The
	 * cached display object can be moved, rotated, faded, etc freely, however if it's content changes, you must manually
	 * update the cache by calling updateCache() or cache() again. You must specify the cache area via the x, y, w,
	 * and h parameters. This defines the rectangle that will be rendered and cached using this display object's
	 * coordinates. For example if you defined a Shape that drew a circle at 0, 0 with a radius of 25, you could call
	 * myShape.cache(-25, -25, 50, 50) to cache the full shape.
	 * @method cache
	 * @param {Number} x The x coordinate origin for the cache region.
	 * @param {Number} y The y coordinate origin for the cache region.
	 * @param {Number} width The width of the cache region.
	 * @param {Number} height The height of the cache region.
	 * @param {Number} scale Optional. The scale at which the cache will be created. For example, if you cache a vector shape using
	 * 	myShape.cache(0,0,100,100,2) then the resulting cacheCanvas will be 200x200 px. This lets you scale and rotate
	 * 	cached elements with greater fidelity. Default is 1.
	 **/	
	public final native void cache(int x,int y,int width,int height,int scale)/*-{
		this.cache(x, y, width, height, scale);
	}-*/;

	
	public final native void cache(int x,int y,int width,int height)/*-{
		this.cache(x, y, width, height);
	}-*/;	
	
	/**
	 * Redraws the display object to its cache. Calling updateCache without an active cache will throw an error.
	 * If compositeOperation is null the current cache will be cleared prior to drawing. Otherwise the display object
	 * will be drawn over the existing cache using the specified compositeOperation.
	 * @method updateCache
	 * @param {String} compositeOperation The compositeOperation to use, or null to clear the cache and redraw it.
	 * <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#compositing">
	 * whatwg spec on compositing</a>.
	 **/	
	public final native void updateCache(String compositeOperation)/*-{
		this.updateCache(compositeOperation);
	}-*/;
	
	public final native void updateCache()/*-{
		this.updateCache();
	}-*/;	
	
	/**
	 * Clears the current cache. See cache() for more information.
	 * @method uncache
	 **/	
	public final native void uncache()/*-{
		this.uncache();
	}-*/;
	
	/**
	* Returns a data URL for the cache, or null if this display object is not cached.
	* Uses cacheID to ensure a new data URL is not generated if the cache has not changed.
	* @method getCacheDataURL.
	**/	
	public final native String getCacheDataURL()/*-{
		return this.getCacheDataURL();
	}-*/;
	
	/**
	 * Returns the stage that this display object will be rendered on, or null if it has not been added to one.
	 * @method getStage
	 * @return {Stage} The Stage instance that the display object is a descendent of. null if the DisplayObject has not
	 * been added to a Stage.
	 **/	
	public final native Stage getStage() /*-{
		return this.getStage();
	}-*/;
	
	/**
	 * Transforms the specified x and y position from the coordinate space of the display object
	 * to the global (stage) coordinate space. For example, this could be used to position an HTML label
	 * over a specific point on a nested display object. Returns a Point instance with x and y properties
	 * correlating to the transformed coordinates on the stage.
	 * @method localToGlobal
	 * @param {Number} x The x position in the source display object to transform.
	 * @param {Number} y The y position in the source display object to transform.
	 * @return {Point} A Point instance with x and y properties correlating to the transformed coordinates
	 * on the stage.
	 **/	
	public final native Point localToGlobal(double x,double y)/*-{
		return this.localToGlobal(x,y);
	}-*/;
	
	/**
	 * Transforms the specified x and y position from the global (stage) coordinate space to the
	 * coordinate space of the display object. For example, this could be used to determine
	 * the current mouse position within the display object. Returns a Point instance with x and y properties
	 * correlating to the transformed position in the display object's coordinate space.
	 * @method globalToLocal
	 * @param {Number} x The x position on the stage to transform.
	 * @param {Number} y The y position on the stage to transform.
	 * @return {Point} A Point instance with x and y properties correlating to the transformed position in the
	 * display object's coordinate space.
	 **/	
	public final native Point globalToLocal(double x,double y)/*-{
		return this.globalToLocal(x,y);
	}-*/;	
	
	public final native Point localToLocal(double x,double y,DisplayObject object)/*-{
		return this.localToLocal(x,y,object);
	}-*/;
	
	/**
	 * Shortcut method to quickly set the transform properties on the display object. All parameters are optional.
	 * Omitted parameters will have the default value set (ex. 0 for x/y, 1 for scaleX/Y).
	 * @method setTransform
	 * @param {Number} x
	 * @param {Number} y
	 * @param {Number} scaleX
	 * @param {Number} scaleY
	 * @param {Number} rotation
	 * @param {Number} skewX
	 * @param {Number} skewY
	 * @param {Number} regX
	 * @param {Number} regY
	 * @return {DisplayObject} Returns this instance. Useful for chaining commands.
	*/	
	public final native DisplayObject setTransform(double x,double  y,double  scaleX,double  scaleY,double  rotation,double  skewX,double  skewY,double  regX,double  regY)/*-{
		return this.setTransform(x, y, scaleX, scaleY, rotation, skewX, skewY, regX, regY);
	}-*/;
	
	public final native DisplayObject setTransform(double x,double  y,double  scaleX,double  scaleY,double  rotation,double  skewX,double  skewY,double  regX)/*-{
		return this.setTransform(x, y, scaleX, scaleY, rotation, skewX, skewY, regX);
	}-*/;
	
	public final native DisplayObject setTransform(double x,double  y,double  scaleX,double  scaleY,double  rotation,double  skewX,double  skewY)/*-{
		return this.setTransform(x, y, scaleX, scaleY, rotation, skewX, skewY);
	}-*/;	
	
	public final native DisplayObject setTransform(double x,double  y,double  scaleX,double  scaleY,double  rotation,double  skewX)/*-{
		return this.setTransform(x, y, scaleX, scaleY, rotation, skewX);
	}-*/;		
	
	public final native DisplayObject setTransform(double x,double  y,double  scaleX,double  scaleY,double  rotation)/*-{
		return this.setTransform(x, y, scaleX, scaleY, rotation);
	}-*/;
	
	public final native DisplayObject setTransform(double x,double  y,double  scaleX,double  scaleY)/*-{
		return this.setTransform(x, y, scaleX, scaleY);
	}-*/;	
	
	public final native DisplayObject setTransform(double x,double  y,double  scaleX)/*-{
		return this.setTransform(x, y, scaleX);
	}-*/;	
	
	public final native DisplayObject setTransform(double x,double  y)/*-{
		return this.setTransform(x, y);
	}-*/;		
	
	/**
	 * Returns a matrix based on this object's transform.
	 * @method getMatrix
	 * @param {Matrix2D} matrix Optional. A Matrix2D object to populate with the calculated values. If null, a new
	 * Matrix object is returned.
	 * @return {Matrix2D} A matrix representing this display object's transform.
	 **/	
	public final native Matrix2D getMatrix(Matrix2D object)/*-{
		return this.getMatrix(object);
	}-*/;	

	/**
	 * Generates a concatenated Matrix2D object representing the combined transform of
	 * the display object and all of its parent Containers up to the highest level ancestor
	 * (usually the stage). This can be used to transform positions between coordinate spaces,
	 * such as with localToGlobal and globalToLocal.
	 * @method getConcatenatedMatrix
	 * @param {Matrix2D} mtx Optional. A Matrix2D object to populate with the calculated values. If null, a new
	 * Matrix object is returned.
	 * @return {Matrix2D} a concatenated Matrix2D object representing the combined transform of
	 * the display object and all of its parent Containers up to the highest level ancestor (usually the stage).
	 **/	
	public final native Matrix2D getConcatenatedMatrix(Matrix2D object)/*-{
		return this.getConcatenatedMatrix(object);
	}-*/;
	
	/**
	 * Tests whether the display object intersects the specified local point (ie. draws a pixel with alpha > 0 at
	 * the specified position). This ignores the alpha, shadow and compositeOperation of the display object, and all
	 * transform properties including regX/Y.
	 * @method hitTest
	 * @param {Number} x The x position to check in the display object's local coordinates.
	 * @param {Number} y The y position to check in the display object's local coordinates.
	 * @return {Boolean} A Boolean indicting whether a visible portion of the DisplayObject intersect the specified
	 * local Point.
	*/	
	public final native boolean hitTest(int x,int y)/*-{
		return this.hitTest(x,y);
	}-*/;
	
	/**
	 * An array of Filter objects to apply to this display object. Filters are only applied / updated when cache() or
	 * updateCache() is called on the display object, and only apply to the area that is cached.
	 * @property filters
	 * @type Array[Filter]
	 * @default null
	 **/	
	public final native void setFilters(Filter[] filters)/*-{
		this.filters = filters;
	}-*/;
	

	/**
	 * A display object that will be tested when checking mouse interactions or testing getObjectsUnderPoint. The hit area
	 * will have its transformation applied relative to this display object's coordinate space (as though the hit test object were a child of this
	 * display object and relative to its regX/Y). It is NOT used for hitTest().
	 * @property hitArea
	 * @type DisplayObject
	 * @default null
	 */	
	public final native void setHitArea(DisplayObject hitArea)/*-{
		this.hitArea = hitArea;
	}-*/;
	
	public final native DisplayObject getHitArea()/*-{
		return this.hitArea;
	}-*/;	
	
	/**
	 * A Shape instance that defines a vector mask (clipping path) for this display object.  The shape's transformation
	 * will be applied relative to the display object's parent coordinates (as if it were a child of the parent).
	 * @property mask
	 * @type Shape
	 * @default null
	 */	
	public final native void setMask(Shape mask)/*-{
		this.mask = mask;
	}-*/;
	
	public final native Shape getMask()/*-{
		return this.mask;
	}-*/;	
	
	/**
	* Returns an ID number that uniquely identifies the current cache for this display object.
	* This can be used to determine if the cache has changed since a previous check.
	* @property cacheID
	* @type Number
	* @default 0
	*/	
	public final native void setCacheID(int cacheID)/*-{
		this.cacheID = cacheID;
	}-*/;
	
	public final native int getCacheID()/*-{
		return this.cacheID;
	}-*/;

	/** The y (vertical) position of the display object, relative to its parent.
	 * @property y
	 * @type Number
	 * @default 0
	 **/	
	public final native void setY(double y)/*-{
		this.y = y;
	}-*/;

	public final native double  getY()/*-{
		return this.y ? this.y : 0;
	}-*/;
	
	/**
	 * Indicates whether the display object should have it's x & y position rounded prior to drawing it to stage.
	 * Snapping to whole pixels can result in a sharper and faster draw for images (ex. Bitmap & cached objects).
	 * This only applies if the enclosing stage has snapPixelsEnabled set to true. The snapToPixel property is true
	 * by default for Bitmap and BitmapAnimation instances, and false for all other display objects.
	 * <br/><br/>
	 * Note that this applies only rounds the display object's local position. You should
	 * ensure that all of the display object's ancestors (parent containers) are also on a whole pixel. You can do this
	 * by setting the ancestors' snapToPixel property to true.
	 * @property snapToPixel
	 * @type Boolean
	 * @default false
	 **/	
	public final native void setSnapToPixel(boolean snapToPixel)/*-{
		this.snapToPixel = snapToPixel;
	}-*/;
	
	public final native boolean getSnapToPixel()/*-{
		return this.snapToPixel;
	}-*/;		
	
	/**
	 * The x (horizontal) position of the display object, relative to its parent.
	 * @property x
	 * @type Number
	 * @default 0
	 **/	
	public final native void setX(double x)/*-{
		this.x = x;
	}-*/;
	
	public final native double getX()/*-{
		return this.x ? this.x : 0 ;
	}-*/;	
	
	/**
	 * The composite operation indicates how the pixels of this display object will be composited with the elements
	 * behind it. If null, this property is inherited from the parent container. For more information, read the
	 * <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#compositing">
	 * whatwg spec on compositing</a>.
	 * @property compositeOperation
	 * @type String
	 * @default null
	 **/	
	public final native void setCompositeOperation(String compositeOperation)/*-{
		this.compositeOperation = compositeOperation;
	}-*/;
	
	public final native String getCompositeOperation()/*-{
		return compositeOperation;
	}-*/;		
	
	public final native DisplayObject clone() /*-{
		return this.clone();
	}-*/;
	
	public final native void setVelX(double velX)/*-{
		this.velX = velX;
	}-*/;
	
	public final native double getVelX()/*-{
		return this.velX ? this.velX : 0;
	}-*/;	
	
	public final native void setVelY(double velY)/*-{
		this.velY = velY;
	}-*/;
	
	public final native double getVelY()/*-{
		return this.velY ? this.velY : 0;
	}-*/;	
	
	public final native JsArray<DisplayObject> getChildren()/*-{
		return this.children;
	}-*/;
	
}
