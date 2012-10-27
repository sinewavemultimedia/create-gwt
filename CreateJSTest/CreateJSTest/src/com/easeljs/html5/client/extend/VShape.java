package com.easeljs.html5.client.extend;

import com.sinewavemultimedia.easeljs.framework.js.display.Shape;

/*
 * An example class for the shape implementation . Use addProperties in Displayobject 
* author: James Tyner 
*/
@Deprecated
public class VShape extends Shape {
	
	protected VShape(){}
	
	public final static native VShape createVShape()/*-{
		 return new $wnd.createjs.Shape();
	}-*/;
	
	public final native void set_X(double _x)/*-{
		this._x = _x;
	}-*/;
	
	public final native double get_X()/*-{
		return this._x;
	}-*/;
	
	public final native void setPerX(double perX)/*-{
		this.perX = perX;
	}-*/;
	
	public final native double getPerX()/*-{
		return this.perX;
	}-*/;

	public final native void setOffX(double offX)/*-{
		this.offX = offX;
	}-*/;
	
	public final native double getOffX()/*-{
		return this.offX;
	}-*/;
	
	public final native void setAmpX(double ampX)/*-{
		this.ampX = ampX;
	}-*/;
	
	public final native double getAmpX()/*-{
		return this.ampX;
	}-*/;	
}
