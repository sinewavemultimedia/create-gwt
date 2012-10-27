package com.easeljs.html5.client.easeljs;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.Animation;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.Image;
import com.sinewavemultimedia.easeljs.framework.js.SpriteFrame;
import com.sinewavemultimedia.easeljs.framework.js.SpriteSheetObject;
import com.sinewavemultimedia.easeljs.framework.js.display.SpriteSheet;
import com.sinewavemultimedia.easeljs.framework.js.utils.SpriteSheetUtils;

/*
* author: James Tyner 
*/
public class ExtractFrame implements IEasel {

	Image img;
	
	@Override
	public void load(final VerticalPanel panel) {
		CallBackEvent callBack = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
				Animation animation = Animation.create();
				JsArrayMixed walkUpRight= (JsArrayMixed)JavaScriptObject.createArray();
				walkUpRight.push(0);
				walkUpRight.push(19);
				animation.walkUpRight(walkUpRight);
				JsArrayMixed walkDownRight= (JsArrayMixed)JavaScriptObject.createArray();
				walkDownRight.push(20);
				walkDownRight.push(40);
				animation.walkDownRight(walkDownRight);
				
				JsArrayMixed walkRight= (JsArrayMixed)JavaScriptObject.createArray();
				walkRight.push(41);
				walkRight.push(59);
				animation.walkRight(walkRight);
				
				SpriteFrame frame = SpriteFrame.create();
				frame.setFrameWidth(64);
				frame.setFrameHeight(68);
				
				SpriteSheetObject object = SpriteSheetObject.create();
				
				JsArray<Image> imageArray = (JsArray<Image>)JavaScriptObject.createArray();
				imageArray.push(img);
				
				object.addImage(imageArray);
				object.addFrame(frame);
				object.addAnimations(animation);
				
				SpriteSheet sheet = SpriteSheet.create(object);
				
				Image image = SpriteSheetUtils.extractFrame(sheet, "walkRight");
				
				com.google.gwt.user.client.ui.Image image2=new com.google.gwt.user.client.ui.Image();
				image2.setUrl(img.getSrc());
				
				String imagSrc = image.getSrc();
				
				com.google.gwt.user.client.ui.Image image3=new com.google.gwt.user.client.ui.Image();
				image3.setUrl(imagSrc);				
				
				panel.add(image2);
				panel.add(image3);
				
				
			}
		};
		
		img = Image.create();
		img.setSrc("../resources/images/testSeq.png");
		img.onLoad(callBack);
		
	}

}
