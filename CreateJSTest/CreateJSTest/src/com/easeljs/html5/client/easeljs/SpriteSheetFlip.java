package com.easeljs.html5.client.easeljs;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.Animation;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.Image;
import com.sinewavemultimedia.easeljs.framework.js.SpriteFrame;
import com.sinewavemultimedia.easeljs.framework.js.SpriteSheetObject;
import com.sinewavemultimedia.easeljs.framework.js.display.SpriteSheet;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.utils.SpriteSheetUtils;

/*
* author: James Tyner 
*/
public class SpriteSheetFlip implements IEasel {

	CreateJSObject createJSObject = null;
	Stage stage = null;
	int canvaswidth = 960;
	int canvasheight = 400;
	
	Image imgSeq  = null;
	
	@Override
	public void load(final VerticalPanel panel) {
		createJSObject = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage = createJSObject.getStage();
		

		
		CallBackEvent callBack = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
					
				JsArrayMixed arrayNumber = (JsArrayMixed)JavaScriptObject.createArray();
				arrayNumber.push(0);
				arrayNumber.push(15);
				Animation animation = Animation.create();
				animation.run(arrayNumber);
				JsArrayString image = (JsArrayString)JavaScriptObject.createArray();
				image.push("../resources/images/runningGrantSmall.png");
				SpriteFrame frame = SpriteFrame.create();
				frame.setRegX(0);
				frame.setRegY(0);
				frame.setFrameWidth(51);
				frame.setFrameHeight(90);
				frame.setNumFrames(16);
				SpriteSheetObject sheetObject = SpriteSheetObject.create();
				sheetObject.addAnimations(animation);
				sheetObject.addFrame(frame);
				sheetObject.addImage(image);
				
				SpriteSheet spriteSheet = SpriteSheet.create(sheetObject);
				
				SpriteSheetUtils.addFlippedFrames(spriteSheet, true, false, false);
				
				Image imagSrc = spriteSheet.getImage(1);
				
				com.google.gwt.user.client.ui.Image image3=new com.google.gwt.user.client.ui.Image();
				image3.setUrl(imagSrc.getSrc());				
				
				panel.add(image3);
			}
		};
		
		imgSeq = Image.create();
		imgSeq.setSrc("../resources/images/runningGrantSmall.png");
		imgSeq.onLoad(callBack);

		//panel.add(createJSObject);
		com.google.gwt.user.client.ui.Image image2=new com.google.gwt.user.client.ui.Image();
		image2.setUrl(imgSeq.getSrc());	
		panel.add(image2);
		
	}

}
