package com.easeljs.html5.client.easeljs;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.Canvas;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Graphics;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;

/*
* author: James Tyner 
*/
public class GraphicsSimple implements IEasel {

	int canvaswidth = 960;
	int canvasheight = 400;
	Canvas canvas =null;
	Stage stage = null;
	@Override
	public void load(final VerticalPanel panel) {
		CreateJSObject createJSObject  = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage	= createJSObject.getStage();
		canvas  = createJSObject.getCanvas();
		
		Shape s = drawSmiley(createJSObject);
		
		s.setX((960-350)/2);
		s.setY(20);
	    stage.addChild(s);
	    panel.add(createJSObject);
	    stage.update();

	}
	
	private Shape drawSmiley(CreateJSObject createJSObject){
		Shape shape = Shape.createShape();
		shape.setGraphics(createJSObject.Graphics());
		Graphics g = shape.getGraphics();
		
	    //Head
	    g.setStrokeStyle(15, "round", "round");
	    g.beginStroke("#000");
	    g.beginFill("#F00");
	    g.drawCircle(170, 170, 170); //55,53
	    g.endFill();
	    g.setStrokeStyle(1, "round", "round");

	    //Right eye
	    g.setStrokeStyle(5, "round", "round");
	    g.beginStroke("#000");
	    g.beginFill("#000");
	    g.drawRoundRect(125, 64, 20, 50, 10);
	    g.endFill();

	    //Left eye
	    g.setStrokeStyle(5, "round", "round");
	    g.beginStroke("#000");
	    g.beginFill("#000");
	    g.drawRoundRect(200, 64, 20, 50, 10);
	    g.endFill();

	    //Mouth
	    g.setStrokeStyle(15, "round", "round");
	    g.beginStroke("#000");
	    g.moveTo(45, 155);
	    g.bezierCurveTo(83, 307, 254, 317, 296, 152);
	    shape.setGraphics(g);
		return shape;
	}

}
