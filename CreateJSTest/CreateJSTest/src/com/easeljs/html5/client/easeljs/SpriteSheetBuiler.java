package com.easeljs.html5.client.easeljs;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBackGeneric;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Image;
import com.sinewavemultimedia.easeljs.framework.js.display.BitmapAnimation;
import com.sinewavemultimedia.easeljs.framework.js.display.Container;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.SpriteSheet;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.display.Text;
import com.sinewavemultimedia.easeljs.framework.js.geom.Rectangle;
import com.sinewavemultimedia.easeljs.framework.js.utils.SpriteSheetBuilder;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class SpriteSheetBuiler implements IEasel {

	CreateJSObject createJSObject = null;
	Stage stage = null;
	int canvaswidth = 960;
	int canvasheight = 400;
	@Override
	public void load(VerticalPanel panel) {
		createJSObject = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage = createJSObject.getStage();
		
		panel.add(createJSObject);
		
		Shape circle = Shape.createShape();
		circle.setGraphics(createJSObject.Graphics().beginFill("#F00").drawCircle(0,0,30).beginFill("#C00").drawCircle(0,0,10));
		circle.setTransform(100,90);
		
		Container square = Container.createContainer(); 
		Shape squareBg = (Shape)square.addChild(Shape.createShape());
		squareBg.setGraphics(createJSObject.Graphics().beginFill("#00F").drawRect(0,0,80,80));
		
		final Text squareFld = (Text)square.addChild(Text.create("1", "bold 72px Arial", "#9BF"));
		squareFld.setTextBaseline("top");
		squareFld.setTextAlign("center");
		squareFld.setX(40);
		square.setTransform(150, 50);
				
		square.addJavaScriptProperty("bounds",Rectangle.create(0,0,80,80));
		
		stage.addChild(circle);
		stage.addChild(square);
		
		SpriteSheetBuilder builder = SpriteSheetBuilder.create();
		int index =builder.addFrame(circle, Rectangle.create(-30,-30,60,60));
		
		builder.addAnimation("circle", index);
		
		JsArrayMixed frames = (JsArrayMixed)JavaScriptObject.createArray();
		
		for(int i =0 ;i < 5 ;i++){
			CallBackGeneric backGeneric = new CallBackGeneric() {
				@Override
				public void onSuccess(String scale, JsArrayMixed setupParams) {
					squareFld.setText(scale);
					
				}
			};
			JsArrayMixed tJsArray = (JsArrayMixed)JavaScriptObject.createArray();
			tJsArray.push(i);
			index = builder.addFrame(square, null,1,backGeneric,tJsArray);
			frames.push(index);
		}
		builder.addAnimation("square", frames, true, 8);
		
		SpriteSheet spriteSheet = builder.build();
		
		BitmapAnimation circle2 = BitmapAnimation.create(spriteSheet);
		circle2.gotoAndPlay("circle");
		circle2.setTransform(100,90+100);
		stage.addChild(circle2);
		
		BitmapAnimation square2 = BitmapAnimation.create(spriteSheet);
		square2.gotoAndPlay("square");
		square2.setTransform(150,50+100);
		stage.addChild(square2);
		
	/*	Image img = spriteSheet.getImage(0);
		String src =img.getSrc();
		com.google.gwt.user.client.ui.Image image3=new com.google.gwt.user.client.ui.Image();
		image3.setUrl(src);				
		
		panel.add(image3);
	*/	
		Ticker.addListener(stage);

	}

}
