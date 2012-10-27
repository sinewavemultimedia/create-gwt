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



package com.sinewavemultimedia.easeljs.framework.js;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RequiresResize;
import com.google.gwt.user.client.ui.Widget;
import com.sinewavemultimedia.easeljs.framework.js.display.Container;
import com.sinewavemultimedia.easeljs.framework.js.display.Graphics;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;

/*A class for creating canvas. Which is represented as Widget
* author: James Tyner 
*/
public class CreateJSObject extends Widget implements RequiresResize  {
	
	private Stage stage;

	private Element ecanvas;
	
	/*
	* Method used for creating Canvas
	* Width of the canvas
	* Height of the canvas 
	*/
	public CreateJSObject(String width,String height){
		Element div = DOM.createDiv();
		ecanvas = DOM.createElement("canvas");
		ecanvas.setAttribute("width", width);
		ecanvas.setAttribute("height", height);
		ecanvas.setAttribute("style", "background-color: transparent;");
		div.appendChild(ecanvas);
		setElement(div);
		
		stage = Stage(ecanvas);
	}
	
	/*
	* Method used for creating div. 
	*/
	public CreateJSObject(){
		Element div = DOM.createDiv();
		setElement(div);
	}	
	
	/*
	 * Returns the canvas
	 */
	public Canvas getCanvas(){
		return Canvas.getCanvas(ecanvas);
	}

	/*
	 * Returns the stage associated with the canvas
	 */
	public Stage getStage(){
		return stage;
	}

	/*
	 * Returns the stage associated with the canvas based on id
	 */
	private final native Stage Stage(Element id)/*-{
		return new $wnd.createjs.Stage(id);

	}-*/;	
	
	/*
	 * Return a new Graphics object
	 */
	public final native Graphics Graphics()/*-{
		return new $wnd.createjs.Graphics();
	}-*/;
	
	/*
	 * Create a shape with a Graphics object.
	 */
	public final native Shape Shape(Graphics object) /*-{
		return new $wnd.createjs.Shape(object);

	}-*/;

	@Override
	public void onResize() {
		// TODO Auto-generated method stub
		
	}		
}
