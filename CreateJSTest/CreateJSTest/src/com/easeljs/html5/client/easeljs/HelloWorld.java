package com.easeljs.html5.client.easeljs;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.Canvas;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Image;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.display.Text;

/*
* author: James Tyner 
*/
public class HelloWorld implements IEasel {
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
		Text text = Text.create("Hello World!", "36px Arial", "#777");

		stage.addChild(text);

		text.setX(360);
		text.setY(200);


		stage.update();

	}

}
