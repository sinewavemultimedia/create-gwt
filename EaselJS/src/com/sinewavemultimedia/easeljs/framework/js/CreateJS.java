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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RequiresResize;
import com.google.gwt.user.client.ui.Widget;


import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.JavaScriptObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Container;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;

/*A Test Class.
* author: James Tyner 
*/

public class CreateJS extends Widget implements RequiresResize {

	private Stage stage;
	private Container container;
	private float panX = 0f;
	private float panY = 0f;
	private Element canvas;

	public CreateJS() {
		this(Window.getClientWidth(), Window.getClientHeight());
	}

	public CreateJS(int width, int height) {
		super();
		Element div = DOM.createDiv();
		canvas = DOM.createElement("canvas");
		canvas.setAttribute("width", ""+width);
		canvas.setAttribute("height", ""+height);
		canvas.setAttribute("style", "background-color: #cccccc;");
		div.appendChild(canvas);
		setElement(div);



		stage.addChild(container);
	}

	/**
	 * Gets the canvas element.
	 * 
	 * @return
	 */
	public Element getCanvasElement() {
		return canvas;
	}

	/**
	 * Gets the main container.
	 * 
	 * @return
	 */
	public Container getContainer() {
		return container;
	}

	/**
	 * Gets the stage.
	 * 
	 * @return
	 */
	public Stage getStage() {
		return stage;
	}

	@Override
	public void onResize() {
		int width = getOffsetWidth();
		int height = getOffsetHeight();

		canvas.setAttribute("width", ""+width);
		canvas.setAttribute("height", ""+height);

		
	}

	public float getPanX() {
		return panX;
	}

	public void setPanX(float panX) {
		this.panX = panX;
	}

	public float getPanY() {
		return panY;
	}

	public void setPanY(float panY) {
		this.panY = panY;
	}
}