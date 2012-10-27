package com.easeljs.html5.client.easeljs;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.Animation;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.Image;
import com.sinewavemultimedia.easeljs.framework.js.SpriteFrame;
import com.sinewavemultimedia.easeljs.framework.js.SpriteSheetObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Bitmap;
import com.sinewavemultimedia.easeljs.framework.js.display.SpriteSheet;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.filters.BoxBlurFilter;
import com.sinewavemultimedia.easeljs.framework.js.filters.ColorFilter;
import com.sinewavemultimedia.easeljs.framework.js.filters.ColorMatrixFilter;
import com.sinewavemultimedia.easeljs.framework.js.filters.Filter;
import com.sinewavemultimedia.easeljs.framework.js.geom.Rectangle;
import com.sinewavemultimedia.easeljs.framework.js.utils.SpriteSheetUtils;

/*
* author: James Tyner 
*/
public class Filters implements IEasel {

	Image img;
	
	int canvaswidth = 960;
	int canvasheight = 400;
	CreateJSObject createJSObject = null;
	Stage stage = null;
	
	@Override
	public void load(final VerticalPanel panel) {
		CallBackEvent callBack = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
				createJSObject =new CreateJSObject(""+canvaswidth, ""+canvasheight);
				stage	=	createJSObject.getStage();
				
				Bitmap bitmap = Bitmap.create(img);
				bitmap.setX((canvaswidth-2*img.getWidth())/3);
				bitmap.setY((canvasheight-2*img.getHeight())/3);
				
				stage.addChild(bitmap);
				
				BoxBlurFilter blurFilter = BoxBlurFilter.create(32, 2, 2);
				Rectangle margins = blurFilter.getBounds();
				
				Bitmap bitmap1 = (Bitmap)bitmap.clone();
				bitmap1.setFilters(new Filter[]{blurFilter});
				int marx =margins.getX();
				int mary =margins.getY();
				int marw=img.getWidth()+margins.getWidth();
				int marh=img.getHeight()+margins.getHeight();
				bitmap1.cache(marx,mary ,marw ,marh );
				bitmap1.setX(bitmap1.getX()+img.getWidth());
				
				stage.addChild(bitmap1);
				
				
				ColorMatrixFilter colorMatrixFilter = ColorMatrixFilter.create(new double[]{0.33,0.33,0.33,0,0,0.33,0.33,0.33,0,0,0.33,0.33,0.33,0,0,0,0,0,1,0});
				Bitmap bitmap2 = (Bitmap)bitmap1.clone();
				
				bitmap2.setFilters(new Filter[]{colorMatrixFilter});
				bitmap2.cache(0,0,img.getWidth(),img.getHeight());
				bitmap2.setY(bitmap2.getY()+img.getHeight());
				stage.addChild(bitmap2);				
				
				ColorFilter removeRedFilter = ColorFilter.create(0,1,1,1);
				Bitmap bitmap3 = (Bitmap)bitmap2.clone();
				bitmap3.setFilters(new Filter[]{removeRedFilter});
				bitmap3.cache(0,0,img.getWidth(),img.getHeight());
				bitmap3.setX((canvaswidth-2*img.getWidth())/3);
				stage.addChild(bitmap3);
				
				panel.add(createJSObject);
				
				stage.update();
			}
		};
		
		img = Image.create();
		img.setSrc("../resources/images/photo.jpg");
		img.onLoad(callBack);
		
	}

}
