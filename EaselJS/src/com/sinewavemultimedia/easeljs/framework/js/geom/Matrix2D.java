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




package com.sinewavemultimedia.easeljs.framework.js.geom;

import com.google.gwt.core.client.JavaScriptObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Shadow;

/*A class the represents Matrix2D.js
* author: James Tyner 
*/
public class Matrix2D extends JavaScriptObject {
	
	protected Matrix2D(){}

	
	public final native static void setNative(Matrix2D identity)/*-{
		$wnd.createjs.Matrix2D.identity= identity;
	}-*/;

	public final native static Matrix2D getNative()/*-{
		return $wnd.createjs.Matrix2D.identity;
	}-*/;
	
	public final native static void setDegToRad(double degToRad)/*-{
		$wnd.createjs.Matrix2D.DEG_TO_RAD= degToRad;
	}-*/;
	
	public final native static double getDegToRad()/*-{
		return $wnd.createjs.Matrix2D.DEG_TO_RAD;
	}-*/;	
	
	public final native void setA(double a)/*-{
		this.a=a;
	}-*/;
	
	public final native double getA()/*-{
		return this.a;
	}-*/;
	
	public final native void setB(double b)/*-{
		this.b=b;
	}-*/;
	
	public final native double getB()/*-{
		return this.b;
	}-*/;
	
	public final native void setC(double c)/*-{
		this.c=c;
	}-*/;
	
	public final native double getC()/*-{
		return this.c;
	}-*/;
	
	public final native void setD(double d)/*-{
		this.d=d;
	}-*/;
	
	public final native double getD()/*-{
		return this.d;
	}-*/;
	
	public final native void setTx(double tx)/*-{
		this.tx=tx;
	}-*/;
	
	public final native double getTx()/*-{
		return this.tx;
	}-*/;

	public final native void setTy(double ty)/*-{
		this.ty=ty;
	}-*/;
	
	public final native double getTy()/*-{
		return this.ty;
	}-*/;
	
	public final native void setAlpha(double alpha)/*-{
		this.alpha=alpha;
	}-*/;
	
	public final native double getAlpha()/*-{
		return this.alpha;
	}-*/;	

	public final native void setShadow(Shadow shadow)/*-{
		this.shadow=shadow;
	}-*/;
	
	public final native double getShadow()/*-{
		return this.shadow;
	}-*/;	
	
	public final native void setCompositeOperation(String compositeOperation)/*-{
		this.compositeOperation=compositeOperation;
	}-*/;
	
	public final native String getCompositeOperation()/*-{
		return this.compositeOperation;
	}-*/;	
	
	/**
	* Represents an affine transformation matrix, and provides tools for constructing and concatenating matrixes.
	* @class Matrix2D
	* @constructor
	* @param {Number} a Specifies the a property for the new matrix.
	* @param {Number} b Specifies the b property for the new matrix.
	* @param {Number} c Specifies the c property for the new matrix.
	* @param {Number} d Specifies the d property for the new matrix.
	* @param {Number} tx Specifies the tx property for the new matrix.
	* @param {Number} ty Specifies the ty property for the new matrix.
	**/	
	public final native static Matrix2D create(int a,int b,int c,int d,int tx,int ty)/*-{
		return new $wnd.createjs.Matrix2D(a,b,c,d,tx,ty);
	}-*/;

	/**
	 * Concatenates the specified matrix properties with this matrix. All parameters are required.
	 * @method prepend
	 * @param {Number} a
	 * @param {Number} b
	 * @param {Number} c
	 * @param {Number} d
	 * @param {Number} tx
	 * @param {Number} ty
	 * @return {Matrix2D} This matrix. Useful for chaining method calls.
	 **/	
	public final native Matrix2D prepend(int a,int b,int c,int d,int tx,int ty)/*-{
		return this.prepend(a,b,c,d,tx,ty);
	}-*/;
	
	/**
	 * Appends the specified matrix properties with this matrix. All parameters are required.
	 * @method append
	 * @param {Number} a
	 * @param {Number} b
	 * @param {Number} c
	 * @param {Number} d
	 * @param {Number} tx
	 * @param {Number} ty
	 * @return {Matrix2D} This matrix. Useful for chaining method calls.
	 **/	
	public final native Matrix2D append(int a,int b,int c,int d,int tx,int ty)/*-{
		return this.append(a,b,c,d,tx,ty);
	}-*/;
	
	/**
	 * Prepends the specified matrix with this matrix.
	 * @method prependMatrix
	 * @param {Matrix2D} matrix
	 **/	
	public final native Matrix2D prependMatrix(Matrix2D matrix)/*-{
		return this.prependMatrix(matrix);
	}-*/;
	
	/**
	 * Appends the specified matrix with this matrix.
	 * @method appendMatrix
	 * @param {Matrix2D} matrix
	 * @return {Matrix2D} This matrix. Useful for chaining method calls.
	 **/	
	public final native Matrix2D appendMatrix(Matrix2D matrix)/*-{
		return this.appendMatrix(matrix);
	}-*/;
	
	/**
	 * Generates matrix properties from the specified display object transform properties, and prepends them with this matrix.
	 * For example, you can use this to generate a matrix from a display object: var mtx = new Matrix2D();
	 * mtx.prependTransform(o.x, o.y, o.scaleX, o.scaleY, o.rotation);
	 * @method prependTransform
	 * @param {Number} x
	 * @param {Number} y
	 * @param {Number} scaleX
	 * @param {Number} scaleY
	 * @param {Number} rotation
	 * @param {Number} skewX
	 * @param {Number} skewY
	 * @param {Number} regX Optional.
	 * @param {Number} regY Optional.
	 * @return {Matrix2D} This matrix. Useful for chaining method calls.
	 **/	
	public final native Matrix2D prependTransform(int x,int y,int scaleX,int scaleY,int rotation,int skewX,int skewY,int regX,int regY)/*-{
		return this.prependTransform(x, y, scaleX, scaleY, rotation, skewX, skewY, regX, regY);
	}-*/;
	
	/**
	 * Generates matrix properties from the specified display object transform properties, and appends them with this matrix.
	 * For example, you can use this to generate a matrix from a display object: var mtx = new Matrix2D();
	 * mtx.appendTransform(o.x, o.y, o.scaleX, o.scaleY, o.rotation);
	 * @method appendTransform
	 * @param {Number} x
	 * @param {Number} y
	 * @param {Number} scaleX
	 * @param {Number} scaleY
	 * @param {Number} rotation
	 * @param {Number} skewX
	 * @param {Number} skewY
	 * @param {Number} regX Optional.
	 * @param {Number} regY Optional.
	 * @return {Matrix2D} This matrix. Useful for chaining method calls.
	 **/	
	public final native Matrix2D appendTransform(int x,int y,int scaleX,int scaleY,int rotation,int skewX,int skewY,int regX,int regY)/*-{
		return this.appendTransform(x, y, scaleX, scaleY, rotation, skewX, skewY, regX, regY);
	}-*/;
	
	/**
	 * Applies a rotation transformation to the matrix.
	 * @method rotate
	 * @param {Number} angle The angle in degrees.
	 * @return {Matrix2D} This matrix. Useful for chaining method calls.
	 **/	
	public final native Matrix2D rotate(int angle)/*-{
		return this.rotate(angle);
	}-*/;
	
	/**
	 * Applies a skew transformation to the matrix.
	 * @method skew
	 * @param {Number} skewX The amount to skew horizontally in degrees.
	 * @param {Number} skewY The amount to skew vertically in degrees.
	 * @return {Matrix2D} This matrix. Useful for chaining method calls.
	*/	
	public final native Matrix2D skew(int skewX,int skewY)/*-{
		return this.skew(skewX,skewY);
	}-*/;
	
	/**
	 * Applies a scale transformation to the matrix.
	 * @method scale
	 * @param {Number} x
	 * @param {Number} y
	 * @return {Matrix2D} This matrix. Useful for chaining method calls.
	 **/	
	public final native Matrix2D scale(int skewX,int skewY)/*-{
		return this.scale(skewX,skewY);
	}-*/;
	
	/**
	 * Translates the matrix on the x and y axes.
	 * @method translate
	 * @param {Number} x
	 * @param {Number} y
	 * @return {Matrix2D} This matrix. Useful for chaining method calls.
	 **/	
	public final native Matrix2D translate(int skewX,int skewY)/*-{
		return this.translate(skewX,skewY);
	}-*/;
	
	/**
	 * Sets the properties of the matrix to those of an identity matrix (one that applies a null transformation).
	 * @method identity
	 * @return {Matrix2D} This matrix. Useful for chaining method calls.
	 **/	
	public final native Matrix2D identity()/*-{
		return this.identity();
	}-*/;
	
	/**
	 * Inverts the matrix, causing it to perform the opposite transformation.
	 * @method invert
	 * @return {Matrix2D} This matrix. Useful for chaining method calls.
	 **/	
	public final native Matrix2D invert()/*-{
		return this.invert();
	}-*/;
	
	/**
	 * Returns true if the matrix is an identity matrix.
	 * @method isIdentity
	 * @returns Boolean
	 **/	
	public final native boolean isIdentity()/*-{
		return this.isIdentity();
	}-*/;	
	
	/**
	 * Decomposes the matrix into transform properties (x, y, scaleX, scaleY, and rotation). Note that this these values
	 * may not match the transform properties you used to generate the matrix, though they will produce the same visual
	 * results.
	 * @method decompose
	 * @param {Object} target The object to apply the transform properties to. If null, then a new object will be returned.
	 * @return {Matrix2D} This matrix. Useful for chaining method calls.
	*/	
	public final native Matrix2D decompose(Matrix2D object)/*-{
		return this.decompose(object);
	}-*/;
	
	/**
	 * Reinitializes all matrix properties to those specified.
	 * @method appendProperties
	 * @param {Number} a
	 * @param {Number} b
	 * @param {Number} c
	 * @param {Number} d
	 * @param {Number} tx
	 * @param {Number} ty
	 * @param {Number} alpha desired alpha value
	 * @param {Shadow} shadow desired shadow value
	 * @param {String} compositeOperation desired composite operation value
	 * @return {Matrix2D} This matrix. Useful for chaining method calls.
	*/	
	public final native Matrix2D reinitialize(int a,int b,int c,int d,int tx,int ty,int alpha,Shadow shadow,String compositeOperation)/*-{
		return this.reinitialize(a,b,c,d,tx,ty,alpha,shadow,compositeOperation);
	}-*/;
	
	/**
	 * Appends the specified visual properties to the current matrix.
	 * @method appendProperties
	 * @param {Number} alpha desired alpha value
	 * @param {Shadow} shadow desired shadow value
	 * @param {String} compositeOperation desired composite operation value
	 * @return {Matrix2D} This matrix. Useful for chaining method calls.
	*/	
	public final native Matrix2D appendProperties(int alpha,Shadow shadow,String compositeOperation)/*-{
		return this.appendProperties(alpha,shadow,compositeOperation);
	}-*/;
	
	/**
	 * Prepends the specified visual properties to the current matrix.
	 * @method prependProperties
	 * @param {Number} alpha desired alpha value
	 * @param {Shadow} shadow desired shadow value
	 * @param {String} compositeOperation desired composite operation value
	 * @return {Matrix2D} This matrix. Useful for chaining method calls.
	*/	
	public final native Matrix2D prependProperties(int alpha,Shadow shadow,String compositeOperation)/*-{
		return this.prependProperties(alpha,shadow,compositeOperation);
	}-*/;
	
	public final native Matrix2D clone()/*-{
		return this.clone();
	}-*/;
}
