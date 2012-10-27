package com.easeljs.html5.client.tweenjs;

import com.easeljs.html5.client.easeljs.IEasel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.Canvas;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Graphics;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.display.Text;
import com.sinewavemultimedia.easeljs.framework.js.tween.Ease;
import com.sinewavemultimedia.easeljs.framework.js.tween.Property;
import com.sinewavemultimedia.easeljs.framework.js.tween.Tween;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class Example implements IEasel {

	Canvas canvas = null;
	Stage stage	=	null; 
	int canvaswidth = 960;
	int canvasheight = 400;
	Graphics graphics = null;
	CreateJSObject createJSObject = null;
	@Override
	public void load(VerticalPanel panel) {
		createJSObject  = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage	= createJSObject.getStage();
		canvas  = createJSObject.getCanvas();	

		panel.add(createJSObject);
		
		Shape circle = Shape.createShape();
		circle.setGraphics(createJSObject.Graphics().beginFill("#FF0000").drawCircle(0,0,50));
		
		Shape highlight = Shape.createShape();
		highlight.setGraphics(createJSObject.Graphics().beginFill("#FFFF66").drawRect(-50,-5,100,30));
		
		highlight.setX(250);
		highlight.setY(250);
		
		Text txt = Text.create("TweenJS", "bold 20px Arial","white");
		txt.setTextAlign("center");
		txt.setX(250);
		txt.setY(250);
		
		stage.addChild(circle);
		stage.addChild(highlight);
		stage.addChild(txt);
		
		Property prps = Property.createProperty();
		prps.addBooleanProperty("loop",true);

		Property pp2 = Property.createProperty();
		pp2.addDoubleProperty("scaleX",0.2);
		pp2.addDoubleProperty("scaleY",0.2);

		Property pp3 = Property.createProperty();
		pp3.addDoubleProperty("scaleX",1);
		pp3.addDoubleProperty("scaleY",1);

		Tween.get(circle,prps).waitDuration(1000).to(pp2).waitDuration(1000).to(pp3,1000,Ease.bounceInOut());

		Property pp9 = Property.createProperty();
		pp9.addDoubleProperty("x",500);
		pp9.addDoubleProperty("y",200);
		pp9.addDoubleProperty("alpha",0.1);

		Property pp10 = Property.createProperty();
		pp10.addDoubleProperty("x",0);
		
		Property pp11 = Property.createProperty();
		pp11.addDoubleProperty("y",400);

		Property pp12 = Property.createProperty();
		pp12.addDoubleProperty("y",0);
		pp12.addDoubleProperty("alpha",1);
		
		Tween.get(circle, prps, true).to(pp9,1000,Ease.get(1)).to(pp10,1000,Ease.get(-1)).to(pp11).waitDuration(800).to(pp12,300) ;

		Property prps1 = Property.createProperty();
		prps1.addBooleanProperty("loop",true);
		prps1.addBooleanProperty("ignoreGlobalPause",true);

		Property pp4 = Property.createProperty();
		pp4.addStringProperty("text","the new javascript tweening engine");
		
		Property pp5 = Property.createProperty();
		pp5.addBooleanProperty("visible",false);
		
		Property pp6 = Property.createProperty();
		pp6.addStringProperty("text","by Grant Skinner, gskinner.com");
		
		Property pp7 = Property.createProperty();
		pp7.addStringProperty("text","TweenJS");		

		Property pp8 = Property.createProperty();
		pp8.addBooleanProperty("visible",true);
		
		Tween.get(txt,prps1).to(pp4,1500).set(pp5,highlight).to(pp6,1500).to(pp7,1500).set(pp8,highlight);
		
		Ticker.setFPS(20);
		
		Ticker.addListener(stage, false);
		
	}

}
