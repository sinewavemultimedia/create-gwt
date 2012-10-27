package com.easeljs.html5.client.easeljs;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.Animation;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.Canvas;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.Image;
import com.sinewavemultimedia.easeljs.framework.js.SpriteFrame;
import com.sinewavemultimedia.easeljs.framework.js.SpriteSheetObject;
import com.sinewavemultimedia.easeljs.framework.js.display.BitmapAnimation;
import com.sinewavemultimedia.easeljs.framework.js.display.SpriteSheet;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class ICons implements IEasel {

	int canvaswidth = 960;
	int canvasheight = 400;
	Image img=null;
	Stage stage =null;
	Canvas canvas = null;
	CreateJSObject createJSObject = null;
	
	@Override
	public void load(VerticalPanel panel) {

		createJSObject  = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage = createJSObject.getStage();
		canvas = createJSObject.getCanvas();
		
		CallBackEvent callBack = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {

				SpriteFrame frame = SpriteFrame.create();
				frame.setFrameWidth(80);
				frame.setFrameHeight(80);
				
				JsArray<Image> imageArray = (JsArray<Image>)JavaScriptObject.createArray();
				imageArray.push(img);

				Animation animations = Animation.create();
				animations.addIntProperty("trash", 0);
				animations.addIntProperty("male", 1);
				animations.addIntProperty("wait", 2);
				animations.addIntProperty("library", 3);
				animations.addIntProperty("female", 4);
				animations.addIntProperty("hanger", 5);
				animations.addIntProperty("stairs", 6);
				animations.addIntProperty("noparking", 7);
				
				
				SpriteSheetObject object = SpriteSheetObject.create();
				
				object.addImage(imageArray);
				object.addFrame(frame);
				//object.addAnimations(animations)
				
				SpriteSheet spriteSheet = SpriteSheet.create(object);
				
				BitmapAnimation icon1 = BitmapAnimation.create(spriteSheet);
				icon1.setX(90);
				icon1.setY(100);
				
				icon1.gotoAndStop(2);
				stage.addChild(icon1);
				
				BitmapAnimation icon2 = icon1.BmAclone();
				icon2.setX(icon2.getX()+ 120);
				icon2.gotoAndStop(5);
				stage.addChild(icon2);

				SpriteSheetObject data = SpriteSheetObject.create();
				data.addImage(imageArray);
				data.addFrame(frame);
				data.addAnimations(animations);
				
				SpriteSheet sheet =SpriteSheet.create(data);
				
			    BitmapAnimation icon3 = icon2.BmAclone();
			    icon3.setSpriteSheet(sheet);
			    icon3.setX(icon3.getX()+120);

			    // we can reference frames by name now:
			    icon3.gotoAndStop("male");
			    stage.addChild(icon3);

			    BitmapAnimation icon4 = icon3.BmAclone();
			    icon4.gotoAndStop("female");
			    icon4.setX(icon4.getX()+120);
			    stage.addChild(icon4);

			    BitmapAnimation icon5 = icon4.BmAclone();
			    icon5.gotoAndStop("trash");
			    icon5.setX(icon5.getX()+120);
			    stage.addChild(icon5);

			    BitmapAnimation  icon6 = icon1.BmAclone();
			    icon6.setX(icon5.getX() + 190);
			    icon6.gotoAndPlay(0);
			    stage.addChild(icon6);

				Ticker.setFPS(3);
				Ticker.addListener(stage);
				

			}
		};
		
		panel.add(createJSObject);
		img = Image.create();
		img.setSrc("../resources/images/icons.png");
		img.onLoad(callBack);
	}

}
