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


package com.sinewavemultimedia.easeljs.framework.js.preload;

/*A  class that represents TagLoader.js
* author: James Tyner 
*/

public class TagLoader extends AbstractLoader {

	protected TagLoader(){}

	/**
	 * The loader that handles loading items using a tag-based approach. There is a built-in
	 * fallback for XHR loading for tags that do not fire onload events, such as &lt;script&gt; and &lt;style&gt;.
	 * @class TagLoader
	 * @constructor
	 * @extends AbstractLoader
	 * @param {String | Object} item The item to load
	 * @param {String} srcAttr The attribute to use as the "source" param, since some tags use different items, such as <style>
	 * @param {Boolean} useXHR Determine if the content should be loaded via XHR before being put on the tag.
	 */	
	public static final native TagLoader createLoader(String item,String  srcAttr,boolean useXHR)/*-{
		return new $wnd.createjs.TagLoader(item,srcAttr,useXHR);
	}-*/;
	
	/*
	 * Cancel method for Tag Loading
	 */
	public final native void cancel()/*-{
		this.cancel();
	}-*/; 

	/*
	 * Load method for Tag Loading
	 */	
	public final native void load()/*-{
		this.load();
	}-*/; 

	/*
	 * LoadXHR method for Tag Loading
	 */	
	public final native void loadXHR()/*-{
		this.loadXHR();
	}-*/; 

}
