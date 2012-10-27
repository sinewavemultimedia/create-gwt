package com.easeljs.html5.client.easeljs;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.display.Text;

/*
* author: James Tyner 
*/
public class TextMultiLine implements IEasel {

	CreateJSObject createJSObject = null;
	Stage stage = null;
	int canvaswidth = 960;
	int canvasheight = 400;
	
	
	@Override
	public void load(VerticalPanel panel) {
		createJSObject = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage = createJSObject.getStage();
		
		Text txt = Text.create("", "17px Arial", "#FFF");
		
		txt.setText( "This text is rendered in canvas using the Text Object:\n\n");
		txt.setText(txt.getText() +"The API is loosely based on Flash's display list, and should be easy to pick up for both JS and AS3 developers. The key classes are:\n\n");
		txt.setText(txt.getText() + "DisplayObject\nAbstract base class for all display elements in Easel. Exposes all of the display properties (ex. x, y, rotation, scaleX, scaleY, alpha, shadow, etc) that are common to all display objects.\n\n");
		txt.setText(txt.getText() + "Stage\nThe root level display container for display elements. Each time tick() is called on Stage, it will update and render the display list to its associated canvas.\n\n");
		txt.setText(txt.getText() + "Container\nA nestable display container, which lets you aggregate display objects and manipulate them as a group.\n\n");
		txt.setText(txt.getText() + "Text\nRenders text in the context of the display list.");
		txt.setLineWidth(800);
		txt.setTextBaseline("top");
		txt.setTextAlign("left");
		txt.setX(30);
		txt.setY(50);
		stage.addChild(txt);
		
		int pad = 10;
		Shape bg = Shape.createShape();
		bg.setGraphics(createJSObject.Graphics().beginFill("#114").drawRect(txt.getX()-pad, txt.getY()-pad, txt.getLineWidth()+pad*2, txt.getMeasuredHeight()+pad*2));
		stage.addChildAt(bg,0);

		stage.update();		
		panel.add(createJSObject);


	}

}
