package com.easeljs.html5.client.easeljs;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.Canvas;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Container;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.display.Text;

/*
* author: James Tyner 
*/
public class HtmlElemnts implements IEasel {

	int canvaswidth = 960;
	int canvasheight = 400;

	Stage stage =null;
	Canvas canvas = null;
	CreateJSObject createJSObject = null;
	@Override
	public void load(VerticalPanel panel) {
		createJSObject  = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage = createJSObject.getStage();
		canvas = createJSObject.getCanvas();
		panel.add(createJSObject);
		Container container = Container.createContainer();
		stage.addChild(container);
		
		Shape frame =  Shape.createShape();
		frame.setGraphics(createJSObject.Graphics().beginFill("#00F").drawRect(0,0,340,280));
		frame.setRegX(170);
		frame.setRegY(140);
		
		Text text = Text.create("Hello! I'm an HTML div.", "36px Arial", "#777");
		text.setRegX(165);
		text.setRegY(135);

		stage.addChild(text);

		container.addChild(frame);
		container.addChild(text);
		container.setX(300);
		container.setY(200);
		container.setAlpha(0.8);
		container.setRotation(25);
		container.setScaleX(1.5);


		stage.update();

	}


}
