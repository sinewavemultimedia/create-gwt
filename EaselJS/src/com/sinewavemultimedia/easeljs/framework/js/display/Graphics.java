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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.Element;
import com.sinewavemultimedia.easeljs.framework.js.Canvas2DJS;

/*A class the represents Graphics.js
* author: James Tyner 
*/
public class Graphics extends DisplayObject {

	public static Map<String, Integer> BASE_64;
	{
		BASE_64	=	new HashMap<String, Integer>();
		BASE_64.put("A",0);
		BASE_64.put("B",1);
		BASE_64.put("C",2);
		BASE_64.put("D",3);
		BASE_64.put("E",4);
		BASE_64.put("F",5);
		BASE_64.put("G",6);
		BASE_64.put("H",7);
		BASE_64.put("I",8);
		BASE_64.put("J",9);
		BASE_64.put("K",10);
		BASE_64.put("L",11);
		BASE_64.put("M",12);
		BASE_64.put("N",13);
		BASE_64.put("O",14);
		BASE_64.put("P",15);
		BASE_64.put("Q",16);
		BASE_64.put("R",17);
		BASE_64.put("S",18);
		BASE_64.put("T",19);
		BASE_64.put("U",20);
		BASE_64.put("V",21);
		BASE_64.put("W",22);
		BASE_64.put("X",23);
		BASE_64.put("Y",24);
		BASE_64.put("Z",25);
		BASE_64.put("a",26);
		BASE_64.put("b",27);
		BASE_64.put("c",28);
		BASE_64.put("d",29);
		BASE_64.put("e",30);
		BASE_64.put("f",31);
		BASE_64.put("g",32);
		BASE_64.put("h",33);
		BASE_64.put("i",34);
		BASE_64.put("j",35);
		BASE_64.put("k",36);
		BASE_64.put("l",37);
		BASE_64.put("m",38);
		BASE_64.put("n",39);
		BASE_64.put("o",40);
		BASE_64.put("p",41);
		BASE_64.put("q",42);
		BASE_64.put("r",43);
		BASE_64.put("s",44);
		BASE_64.put("t",45);
		BASE_64.put("u",46);
		BASE_64.put("v",47);
		BASE_64.put("w",48);
		BASE_64.put("x",49);
		BASE_64.put("y",50);
		BASE_64.put("z",51);
		BASE_64.put("0",52);
		BASE_64.put("1",53);
		BASE_64.put("2",54);
		BASE_64.put("3",55);
		BASE_64.put("4",56);
		BASE_64.put("5",57);
		BASE_64.put("6",58);
		BASE_64.put("7",59);
		BASE_64.put("8",60);
		BASE_64.put("9",61);
		BASE_64.put("+",62);
		BASE_64.put("/",63);
	}
	
	public static String STROKE_CAPS_MAP[]= {"butt", "round", "square"};
	
	public static String STROKE_JOINTS_MAP[]= {"miter", "round", "bevel"};
	
	protected Graphics(){}

	/*
	 * Returns the Graphics Instance
	 */
	public final native static Graphics createGraphics()/*-{
		return new $wnd.createjs.Graphics();
	}-*/;

	/**
	 * Returns a CSS compatible color string based on the specified RGB numeric color values in the format 
	 * "rgba(255,255,255,1.0)", or if alpha is null then in the format "rgb(255,255,255)". For example,
	 * Graphics.getRGB(50, 100, 150, 0.5) will return "rgba(50,100,150,0.5)". It also supports passing a single hex color 
	 * value as the first param, and an optional alpha value as the second param. For example, Graphics.getRGB(0xFF00FF, 0.2)
	 * will return "rgba(255,0,255,0.2)".
	 * @method getRGB
	 * @static
	 * @param {Number} r The red component for the color, between 0 and 0xFF (255).
	 * @param {Number} g The green component for the color, between 0 and 0xFF (255).
	 * @param {Number} b The blue component for the color, between 0 and 0xFF (255).
	 * @param {Number} alpha Optional. The alpha component for the color where 0 is fully transparent and 1 is fully opaque.
	 * @return A CSS compatible color string based on the specified RGB numeric color values in the format 
	 * "rgba(255,255,255,1.0)", or if alpha is null then in the format "rgb(255,255,255)".
	 **/	
	public final native static String getRGB(double r,double b ,double g,double a)/*-{
		return $wnd.createjs.Graphics.getRGB(r,b,g,a);
	}-*/;
	
	public final native static String getRGB(double r,double b ,double g)/*-{
		return $wnd.createjs.Graphics.getRGB(r,b,g);
	}-*/;
	
	public final native static String getRGB(double r,double b)/*-{
		return $wnd.createjs.Graphics.getRGB(r,b);
	}-*/;	

	/**
	 * Returns a CSS compatible color string based on the specified HSL numeric color values in the format "hsla(360,100,100,1.0)", 
	 * or if alpha is null then in the format "hsl(360,100,100)". For example, Graphics.getHSL(150, 100, 70) will return 
	 * "hsl(150,100,70)".
	 * @method getHSL
	 * @static
	 * @param {Number} hue The hue component for the color, between 0 and 360.
	 * @param {Number} saturation The saturation component for the color, between 0 and 100.
	 * @param {Number} lightness The lightness component for the color, between 0 and 100.
	 * @param {Number} alpha Optional. The alpha component for the color where 0 is fully transparent and 1 is fully opaque.
	 * @return a CSS compatible color string based on the specified HSL numeric color values in the format 
	 * "hsla(360,100,100,1.0)", or if alpha is null then in the format "hsl(360,100,100)". For example, 
	 * Graphics.getHSL(150, 100, 70) will return "hsl(150,100,70)".
	 **/	
	public final native static String getHSL(double r,double b , double g, double a)/*-{
		return $wnd.createjs.Graphics.getHSL(r,b,g,a);
	}-*/;
	
	public final native static String getHSL(double r,double b , double g)/*-{
		return  $wnd.createjs.Graphics.getHSL(r,b,g);
	}-*/;	
	
	/**
	 * Draws the display object into the specified context ignoring it's visible, alpha, shadow, and transform.
	 * Returns true if the draw was handled (useful for overriding functionality).
	 * NOTE: This method is mainly for internal use, though it may be useful for advanced uses.
	 * @method draw
	 * @param {CanvasRenderingContext2D} ctx The canvas 2D context object to draw into.
	 **/	
	public final native void draw(Canvas2DJS object)/*-{
		this.draw(object);
	}-*/;
	
	/**
	 * Draws only the path described for this Graphics instance, skipping any
	 * non-path instructions, including fill and stroke descriptions.
	 * Used by DisplayObject.clippingPath to draw the clipping path, for example.
	 * @method drawAsPath
	 * @param {CanvasRenderingContext2D} ctx The canvas 2D context object to draw into.
	 **/	
	public final native void drawAsPath(Canvas2DJS object)/*-{
		this.drawAsPath(object);
	}-*/;
	
	
	/**
	 * Moves the drawing point to the specified position.
	 * @method moveTo
	 * @param {Number} x The x coordinate the drawing point should move to.
	 * @param {Number} y The y coordinate the drawing point should move to.
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/	
	public final native Graphics moveTo(double x,double y)/*-{
		return this.moveTo(x,y);
	}-*/;
	
	/**
	 * Draws a line from the current drawing point to the specified position, which become the new current drawing point. 
	 * For detailed information, read the 
	 * <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#complex-shapes-(paths)">
	 * whatwg spec</a>.
	 * @method lineTo
	 * @param {Number} x The x coordinate the drawing point should draw to.
	 * @param {Number} y The y coordinate the drawing point should draw to.
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/	
	public final native Graphics lineTo(double x,double y)/*-{
		return this.lineTo(x,y);
	}-*/;
	
	
	/**
	 * Draws an arc with the specified control points and radius.  For detailed information, read the 
	 * <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#dom-context-2d-arcto">
	 * whatwg spec</a>.
	 * @method arcTo
	 * @param {Number} x1
	 * @param {Number} y1
	 * @param {Number} x2
	 * @param {Number} y2
	 * @param {Number} radius
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/	
	public final native Graphics arcTo(int x1,int y1,int x2,int y2,int radius)/*-{
		return this.arcTo(x1,y1,x2,y2,radius);
	}-*/;

	/**
	 * Draws an arc defined by the radius, startAngle and endAngle arguments, centered at the position (x, y). For example 
	 * arc(100, 100, 20, 0, Math.PI*2) would draw a full circle with a radius of 20 centered at (100, 100). For detailed 
	 * information, read the 
	 * <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#dom-context-2d-arc">whatwg spec</a>.
	 * @method arc
	 * @param {Number} x
	 * @param {Number} y
	 * @param {Number} radius
	 * @param {Number} startAngle Measured in radians.
	 * @param {Number} endAngle Measured in radians.
	 * @param {Boolean} anticlockwise
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/	
	public final native Graphics arc(int x,int y,int radius,int startAngle,int endAngle,int anticlockwise)/*-{
		return this.arc(x,y,radius,startAngle,endAngle,anticlockwise);
	}-*/;	
	
	/**
	 * Draws a quadratic curve from the current drawing point to (x, y) using the control point (cpx, cpy).  For detailed information, 
	 * read the <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#dom-context-2d-quadraticcurveto">
	 * whatwg spec</a>.
	 * @method quadraticCurveTo
	 * @param {Number} cpx
	 * @param {Number} cpy
	 * @param {Number} x
	 * @param {Number} y
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/	
	public final native Graphics quadraticCurveTo(double cpx,double cpy,double x,double y)/*-{
		return this.quadraticCurveTo(cpx,cpy,x,y);
	}-*/;
	
	/**
	 * Maps the familiar ActionScript curveTo() method to the functionally similar quatraticCurveTo() method.
	 * @property curveTo
	 * @type Function
	 **/	
	public final native Graphics curveTo(double cpx,double cpy,double x,double y)/*-{
		return this.curveTo(cpx,cpy,x,y);
	}-*/;	
	
	/**
	 * Maps the familiar ActionScript drawRect() method to the functionally similar rect() method.
	 * @property drawRect
	 * @type Function
	 **/	
	public final native Graphics drawRect(double cpx,double cpy,double x,double y)/*-{
		return this.drawRect(cpx,cpy,x,y);
	}-*/;	
	
	/**
	 * Draws a bezier curve from the current drawing point to (x, y) using the control points (cp1x, cp1y) and (cp2x, cp2y).  
	 * For detailed information, read the 
	 * <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#dom-context-2d-beziercurveto">
	 * whatwg spec</a>.
	 * method @bezierCurveTo
	 * @param {Number} cp1x
	 * @param {Number} cp1y
	 * @param {Number} cp2x
	 * @param {Number} cp2y
	 * @param {Number} x
	 * @param {Number} y
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/	
	public final native Graphics bezierCurveTo(double cp1x,double  cp1y,double  cp2x,double  cp2y,double  x,double  y)/*-{
		return this.bezierCurveTo(cp1x, cp1y, cp2x, cp2y, x, y);
	}-*/;
	
	
	/**
	 * Draws a rectangle at (x, y) with the specified width and height using the current fill and/or stroke.
	 *  For detailed information, read the 
	 * <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#dom-context-2d-rect">
	 * whatwg spec</a>.
	 * @method rect
	 * @param {Number} x
	 * @param {Number} y
	 * @param {Number} w Width of the rectangle
	 * @param {Number} h Height of the rectangle
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/
	
	public final native Graphics rect(int x,int  y,int  w,int  h)/*-{
		return this.rect(x, y, w, h);
	}-*/;

	/**
	 * Closes the current path, effectively drawing a line from the current drawing point to the first drawing point specified
	 * since the fill or stroke was last set.
	 * @method closePath
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/	
	public final native Graphics closePath()/*-{
		return this.closePath();
	}-*/;
	
	/**
	 * Clears all drawing instructions, effectively reseting this Graphics instance.
	 * @method clear
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/
	
	public final native Graphics clear()/*-{
		return this.clear();
	}-*/;	
	
	/**
	 * Begins a fill with the specified color. This ends the current subpath.
	 * @method beginFill
	 * @param {String} color A CSS compatible color value (ex. "#FF0000" or "rgba(255,0,0,0.5)"). Setting to null will 
	 * result in no fill.
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/
	public final native Graphics beginFill(String color)/*-{
		return this.beginFill(color);
	}-*/;

	/**
	 * Begins a radial gradient fill. This ends the current subpath. For example, the following code defines a red to blue radial 
	 * gradient centered at (100, 100), with a radius of 50, and draws a circle to display it:<br/>
	 * myGraphics.beginRadialGradientFill(["#F00","#00F"], [0, 1], 100, 100, 0, 100, 100, 50).drawCircle(100, 100, 50);
	 * @method beginRadialGradientFill
	 * @param {Array[String]} colors An array of CSS compatible color values. For example, ["#F00","#00F"] would define a gradient 
	 * drawing from red to blue.
	 * @param {Array[Number]} ratios An array of gradient positions which correspond to the colors. For example, [0.1, 0.9] would 
	 * draw the first color to 10% then interpolating to the second color at 90%.
	 * @param {Number} x0 Center position of the inner circle that defines the gradient.
	 * @param {Number} y0 Center position of the inner circle that defines the gradient.
	 * @param {Number} r0 Radius of the inner circle that defines the gradient.
	 * @param {Number} x1 Center position of the outer circle that defines the gradient.
	 * @param {Number} y1 Center position of the outer circle that defines the gradient.
	 * @param {Number} r1 Radius of the outer circle that defines the gradient.
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/
	public final native Graphics beginRadialGradientStroke(JsArrayString colors,JsArrayNumber ratios,double x0,double  y0,double r0,double  x1,double  y1,double r1)/*-{
		return this.beginRadialGradientStroke(colors, ratios, x0, y0,r0, x1, y1,r1);
	}-*/;
	
	public final native Graphics beginLinearGradientFill(JsArrayString colors,JsArrayNumber ratios,double x0,double  y0,double  x1,double  y1)/*-{
		return this.beginLinearGradientFill(colors, ratios, x0, y0, x1, y1);
	}-*/;	
	

	/**
	 * Begins a linear gradient fill defined by the line (x0, y0) to (x1, y1). This ends the current subpath. For example, the
	 * following code defines a black to white vertical gradient ranging from 20px to 120px, and draws a square to display it:<br/>
	 * myGraphics.beginLinearGradientFill(["#000","#FFF"], [0, 1], 0, 20, 0, 120).drawRect(20, 20, 120, 120);
	 * @method beginLinearGradientFill
	 * @param {Array[String]} colors An array of CSS compatible color values. For example, ["#F00","#00F"] would define a gradient 
	 * drawing from red to blue.
	 * @param {Array[Number]} ratios An array of gradient positions which correspond to the colors. For example, [0.1, 0.9] would draw 
	 * the first color to 10% then interpolating to the second color at 90%.
	 * @param {Number} x0 The position of the first point defining the line that defines the gradient direction and size.
	 * @param {Number} y0 The position of the first point defining the line that defines the gradient direction and size.
	 * @param {Number} x1 The position of the second point defining the line that defines the gradient direction and size.
	 * @param {Number} y1 The position of the second point defining the line that defines the gradient direction and size.
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/		
	public final native Graphics beginLinearGradientFill(String[] colors,double[] ratios,double x0,double  y0,double  x1,double  y1)/*-{
		return this.beginLinearGradientFill(colors, ratios, x0, y0, x1, y1);
	}-*/;	

	/**
	 * Begins a pattern fill using the specified image. This ends the current subpath.
	 * @method beginBitmapFill
	 * @param image The Image, Canvas, or Video object to use as the pattern.
	 * @param {String} repetition Optional. Indicates whether to repeat the image in the fill area. One of "repeat", "repeat-x",
	 * "repeat-y", or "no-repeat". Defaults to "repeat".
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/	
	public final native Graphics beginBitmapFill(JavaScriptObject image)/*-{
		return this.beginBitmapFill(image);
	}-*/;
	
	public final native Graphics beginBitmapFill(Element image,String repetition)/*-{
		return this.beginBitmapFill(image,repetition);
	}-*/;
	
	/**
	 * Ends the current subpath, and begins a new one with no fill. Functionally identical to beginFill(null).
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/	
	public final native Graphics endFill()/*-{
		return this.endFill();
	}-*/;
	
	/**
	 * Sets the stroke style for the current subpath. Like all drawing methods, this can be chained, so you can define the stroke style and color in a single line of code like so:
	 * myGraphics.setStrokeStyle(8,"round").beginStroke("#F00");
	 * @method setStrokeStyle
	 * @param thickness The width of the stroke.
	 * @param caps Optional. Indicates the type of caps to use at the end of lines. One of butt, round, or square. Defaults to "butt". Also accepts the values 0 (butt), 1 (round), and 2 (square) for use with the tiny API.
	 * @param joints Optional. Specifies the type of joints that should be used where two lines meet. One of bevel, round, or miter. Defaults to "miter". Also accepts the values 0 (miter), 1 (round), and 2 (bevel) for use with the tiny API.
	 * @param miter Optional. If joints is set to "miter", then you can specify a miter limit ratio which controls at what point a mitered joint will be clipped.
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/	
	public final native Graphics setStrokeStyle(double thickness,String caps,String joints,String miterLimit)/*-{
		return this.setStrokeStyle(thickness, caps, joints, miterLimit);
	}-*/;
	
	public final native Graphics setStrokeStyle(double thickness,String caps,String joints)/*-{
		return this.setStrokeStyle(thickness, caps, joints);
	}-*/;
	
	public final native Graphics setStrokeStyle(double thickness,String caps)/*-{
		return this.setStrokeStyle(thickness, caps);
	}-*/;	

	public final native Graphics setStrokeStyle(double thickness)/*-{
		return this.setStrokeStyle(thickness);
	}-*/;	
	
	/**
	 * Begins a stroke with the specified color. This ends the current subpath.
	 * @method beginStroke
	 * @param color A CSS compatible color value (ex. "#FF0000" or "rgba(255,0,0,0.5)"). Setting to null will result in no stroke.
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/	
	public final native Graphics beginStroke(String color)/*-{
		return this.beginStroke(color);
	}-*/;	
	
	/**
	 * Begins a linear gradient stroke defined by the line (x0, y0) to (x1, y1). This ends the current subpath. For example, the following code defines a black to white vertical gradient ranging from 20px to 120px, and draws a square to display it:<br/>
	 * myGraphics.setStrokeStyle(10).beginLinearGradientStroke(["#000","#FFF"], [0, 1], 0, 20, 0, 120).drawRect(20, 20, 120, 120);
	 * @method beginLinearGradientStroke
	 * @param colors An array of CSS compatible color values. For example, ["#F00","#00F"] would define a gradient drawing from red to blue.
	 * @param ratios An array of gradient positions which correspond to the colors. For example, [0.1, 0.9] would draw the first color to 10% then interpolating to the second color at 90%.
	 * @param x0 The position of the first point defining the line that defines the gradient direction and size.
	 * @param y0 The position of the first point defining the line that defines the gradient direction and size.
	 * @param x1 The position of the second point defining the line that defines the gradient direction and size.
	 * @param y1 The position of the second point defining the line that defines the gradient direction and size.
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/	
	public final native Graphics beginLinearGradientStroke(String[] colors,double[] ratios,int x0,int y0,int x1,int y1)/*-{
		return this.beginLinearGradientStroke(colors, ratios, x0, y0, x1, y1);
	}-*/;		
	
	public final native Graphics beginLinearGradientStroke(JsArrayString colors,JsArrayNumber ratios,int x0,int y0,int x1,int y1)/*-{
		return this.beginLinearGradientStroke(colors, ratios, x0, y0, x1, y1);
	}-*/;	
	
	/**
	 * Begins a radial gradient fill. This ends the current subpath. For example, the following code defines a red to blue radial 
	 * gradient centered at (100, 100), with a radius of 50, and draws a circle to display it:<br/>
	 * myGraphics.beginRadialGradientFill(["#F00","#00F"], [0, 1], 100, 100, 0, 100, 100, 50).drawCircle(100, 100, 50);
	 * @method beginRadialGradientFill
	 * @param {Array[String]} colors An array of CSS compatible color values. For example, ["#F00","#00F"] would define a gradient 
	 * drawing from red to blue.
	 * @param {Array[Number]} ratios An array of gradient positions which correspond to the colors. For example, [0.1, 0.9] would 
	 * draw the first color to 10% then interpolating to the second color at 90%.
	 * @param {Number} x0 Center position of the inner circle that defines the gradient.
	 * @param {Number} y0 Center position of the inner circle that defines the gradient.
	 * @param {Number} r0 Radius of the inner circle that defines the gradient.
	 * @param {Number} x1 Center position of the outer circle that defines the gradient.
	 * @param {Number} y1 Center position of the outer circle that defines the gradient.
	 * @param {Number} r1 Radius of the outer circle that defines the gradient.
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/	
	public final native Graphics beginRadialGradientFill(String[] colors,int[] ratios,int x0,int y0,int r0,int x1,int y1,int r1)/*-{
		return this.beginRadialGradientFill(colors, ratios, x0, y0,r0, x1, y1,r1);
	}-*/;		
	
	public final native Graphics beginRadialGradientFill(JsArrayString colors,JsArrayNumber ratios,int x0,int y0,int r0,int x1,int y1,int r1)/*-{
		return this.beginRadialGradientFill(colors, ratios, x0, y0,r0, x1, y1,r1);
	}-*/;			

	
	/**
	 * Begins a pattern fill using the specified image. This ends the current subpath.
	 * @method beginBitmapStroke
	 * @param {Image | HTMLCanvasElement | HTMLVideoElement} image The Image, Canvas, or Video object to use as the pattern.
	 * @param {String} repetition Optional. Indicates whether to repeat the image in the fill area. One of "repeat", "repeat-x",
	 * "repeat-y", or "no-repeat". Defaults to "repeat".
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)	
	 **/	
	public final native Graphics beginBitmapStroke(JavaScriptObject image)/*-{
		return this.beginBitmapStroke(image);
	}-*/;
	
	public final native Graphics beginBitmapStroke(JavaScriptObject image,String repetition)/*-{
		return this.beginBitmapStroke(image,repetition);
	}-*/;

	/**
	 * Ends the current subpath, and begins a new one with no stroke. Functionally identical to beginStroke(null).
	 * @method endStroke
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/	
	public final native Graphics endStroke()/*-{
		return this.endStroke();
	}-*/;	
	
	/**
	 * Draws a rounded rectangle with all corners with the specified radius.
	 * @method drawRoundRect
	 * @param {Number} x
	 * @param {Number} y
	 * @param {Number} w
	 * @param {Number} h
	 * @param {Number} radius Corner radius.
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/	
	public final native Graphics drawRoundRect(int x,int  y,int  w,int  h,int  radius)/*-{
		return this.drawRoundRect(x, y, w, h, radius);
	}-*/;
	
	/**
	 * Draws a rounded rectangle with different corner radii. Supports positive and negative corner radii.
	 * @method drawRoundRectComplex
	 * @param {Number} x
	 * @param {Number} y
	 * @param {Number} w
	 * @param {Number} h
	 * @param {Number} radiusTL Top left corner radius.
	 * @param {Number} radiusTR Top right corner radius.
	 * @param {Number} radiusBR Bottom right corner radius.
	 * @param {Number} radiusBL Bottom left corner radius.
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/	
	public final native Graphics drawRoundRectComplex(int x,int  y,int  w,int  h,int  radiusTL,int  radiusTR,int  radiusBR,int  radiusBL)/*-{
		return this.drawRoundRectComplex(x, y, w, h, radiusTL, radiusTR, radiusBR, radiusBL);
	}-*/;
	
	/**
	 * Draws a circle with the specified radius at (x, y).
	*
	 * <pre><code>var g = new Graphics();
	*	g.setStrokeStyle(1);
	*	g.beginStroke(Graphics.getRGB(0,0,0));
	*	g.beginFill(Graphics.getRGB(255,0,0));
	*	g.drawCircle(0,0,3);
	*
	*	var s = new Shape(g);
	*		s.x = 100;
	*		s.y = 100;
	*
	*	stage.addChild(s);
	*	stage.update();</code></pre>
	 * @method drawCircle
	 * @param {Number} x x coordinate center point of circle.
	 * @param {Number} y y coordinate center point of circle.
	 * @param {Number} radius Radius of circle.
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/	
	public final native Graphics drawCircle(double x,double  y,double  radius)/*-{
		return this.drawCircle(x, y, radius);
	}-*/;
	
	/**
	 * Draws an ellipse (oval).
	 * @method drawEllipse
	 * @param {Number} x
	 * @param {Number} y
	 * @param {Number} w
	 * @param {Number} h
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/
	public final native Graphics drawEllipse(int x,int  y,int  w,int  h,int  startAngle,int  endAngle,int  innerRadius)/*-{
		return this.drawEllipse(x, y, w, h, startAngle, endAngle, innerRadius);
	}-*/;
	
	public final native Graphics drawEllipse(int x,int  y,int  w,int  h,int  startAngle)/*-{
		return this.drawEllipse(x, y, w, h, startAngle);
	}-*/;	
	
	public final native Graphics drawEllipse(int x,int  y,int  w,int  h)/*-{
		return this.drawEllipse(x, y, w, h);
	}-*/;
	
	/**
	 * Draws a star if pointSize is greater than 0 or a regular polygon if pointSize is 0 with the specified number of points.
	 * For example, the following code will draw a familiar 5 pointed star shape centered at 100, 100 and with a radius of 50:
	 * myGraphics.beginFill("#FF0").drawPolyStar(100, 100, 50, 5, 0.6, -90); // -90 makes the first point vertical
	 * @method drawPolyStar
	 * @param {Number} x Position of the center of the shape.
	 * @param {Number} y Position of the center of the shape.
	 * @param {Number} radius The outer radius of the shape.
	 * @param {Number} sides The number of points on the star or sides on the polygon.
	 * @param {Number} pointSize The depth or "pointy-ness" of the star points. A pointSize of 0 will draw a regular polygon (no points), 
	 * a pointSize of 1 will draw nothing because the points are infinitely pointy.
	 * @param {Number} angle The angle of the first point / corner. For example a value of 0 will draw the first point directly to the 
	 * right of the center.
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/	
	public final native Graphics drawPolyStar(double x,double  y,double  radius,double sides,double pointSize,double angle)/*-{
		return this.drawPolyStar(x, y, radius, sides, pointSize, angle);
	}-*/;
	
	public final native Graphics drawPolyStar(double x,double  y,double  radius,double sides,double pointSize)/*-{
		return this.drawPolyStar(x, y, radius, sides, pointSize);
	}-*/;

	
	public final native Graphics drawPolyStar(double x,double  y,double  radius,double sides)/*-{
		return this.drawPolyStar(x, y, radius, sides);
	}-*/;
	
	/**
	 * Decodes a compact encoded path string into a series of draw instructions.
	 * This format is not intended to be human readable, and is meant for use by authoring tools.
	 * The format uses a base64 character set, with each character representing 6 bits, to define a series of draw commands.
	 * <br/><br/>
	 * Each command is comprised of a single "header" character followed by a variable number of alternating x and y position values.
	 * Reading the header bits from left to right (most to least significant): bits 1 to 3 specify the type of operation
	 * (0-moveTo, 1-lineTo, 2-quadraticCurveTo, 3-bezierCurveTo, 4-7 unused). Bit 4 indicates whether position values use 12 bits (2 characters) 
	 * or 18 bits (3 characters), with a one indicating the latter. Bits 5 and 6 are currently unused.
	 * <br/><br/>
	 * Following the header is a series of 2 (moveTo, lineTo), 4 (quadraticCurveTo), or 6 (bezierCurveTo) parameters.
	 * These parameters are alternating x/y positions represented by 2 or 3 characters (as indicated by the 4th bit in the command char).
	 * These characters consist of a 1 bit sign (1 is negative, 0 is positive), followed by an 11 (2 char) or 17 (3 char) bit integer value.
	 * All position values are in tenths of a pixel.
	 * Except in the case of move operations, this value is a delta from the previous x or y position (as appropriate).
	 * <br/><br/>
	 * For example, the string "A3cAAMAu4AAA" represents a line starting at -150,0 and ending at 150,0.
	 * A - bits 000000. First 3 bits (000) indicate a moveTo operation. 4th bit (0) indicates 2 chars per parameter.
	 * n0 - 110111011100. Absolute x position of -150.0px. First bit indicates a negative value, remaining bits indicate 1500 tenths of a pixel. 
	 * AA - 000000000000. Absolute y position of 0.
	 * I - 001100. First 3 bits (001) indicate a lineTo operation. 4th bit (1) indicates 3 chars per parameter.
	 * Au4 - 000000101110111000. An x delta of 300.0px, which is added to the previous x value of -150.0px to provide an absolute position of +150.0px.
	 * AAA - 000000000000000000. A y delta value of 0.
	 * 
	 * @method decodePath
	 * @param {String} str The path string to decode.
	 * @return {Graphics} The Graphics instance the method is called on (useful for chaining calls.)
	 **/
	public final native Graphics decodePath(String str)/*-{
		return this.decodePath(str);
	}-*/;
	
	public final native Graphics doclone()/*-{
		return this.clone();
	}-*/;
	
	public final native String getString()/*-{
		return this.toString();
	}-*/;
}
