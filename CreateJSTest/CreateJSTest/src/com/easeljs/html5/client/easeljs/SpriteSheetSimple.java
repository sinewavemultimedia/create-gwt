package com.easeljs.html5.client.easeljs;

//import org.apache.tools.ant.taskdefs.Java;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.Animation;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.SpriteFrame;
import com.sinewavemultimedia.easeljs.framework.js.SpriteSheetObject;
import com.sinewavemultimedia.easeljs.framework.js.display.BitmapAnimation;
import com.sinewavemultimedia.easeljs.framework.js.display.SpriteSheet;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class SpriteSheetSimple implements IEasel {

	CreateJSObject createJSObject = null;
	Stage stage = null;
	int canvaswidth = 960;
	int canvasheight = 400;
	
	
	@Override
	public void load(VerticalPanel panel) {
		createJSObject = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage = createJSObject.getStage();
		
		panel.add(createJSObject);
		
		SpriteSheetObject object = SpriteSheetObject.create();
		
		JsArrayMixed arrayMixedJump = (JsArrayMixed)JavaScriptObject.createArray();
		arrayMixedJump.push(0);
		arrayMixedJump.push(25);
		arrayMixedJump.push("jump");
		Animation animation = Animation.create();
		animation.run(arrayMixedJump);
		
		JsArrayMixed arrayMixedRun = (JsArrayMixed)JavaScriptObject.createArray();
		arrayMixedRun.push(26);
		arrayMixedRun.push(63);
		arrayMixedRun.push("run");
		animation.jump(arrayMixedRun);
		object.addAnimations(animation);
		
		JsArrayString image = (JsArrayString)JavaScriptObject.createArray();
		image.push("../resources/images/runningGrant.png");
		object.addImage(image);
		SpriteFrame frame = SpriteFrame.create();
		frame.setNumFrames(64);
		frame.setFrameHeight(292.5);
		frame.setFrameWidth(165.75);
		frame.setRegX(0);
		frame.setRegY(0);
		object.addFrame(frame);
		
		SpriteSheet sheet = SpriteSheet.create(object);
		
		BitmapAnimation grant =BitmapAnimation.create(sheet);
		grant.setX(360);
		grant.setY(22);
		grant.gotoAndPlay("run");
		stage.addChild(grant);
		Ticker.setFPS(60);
		Ticker.addListener(stage);
	}

}
