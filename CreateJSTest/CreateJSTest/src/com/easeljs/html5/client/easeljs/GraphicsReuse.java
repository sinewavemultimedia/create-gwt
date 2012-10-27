package com.easeljs.html5.client.easeljs;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.Canvas;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.display.Graphics;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.geom.Point;

/*
* author: James Tyner 
*/
public class GraphicsReuse implements IEasel {

	int canvaswidth = 960;
	int canvasheight = 400;
	Canvas canvas =null;
	Stage stage = null;
	CreateJSObject createJSObject = null;
	Graphics g = null;
	@Override
	public void load(final VerticalPanel panel) {
		createJSObject = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage	= createJSObject.getStage();
		canvas  = createJSObject.getCanvas();
	    panel.add(createJSObject);
		CallBackEvent callBackEvent = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
				stage.removeAllChildren();
				layoutSmiley(createJSObject);
			}
		};
		stage.onMouseDown(callBackEvent);
		layoutSmiley(createJSObject);
	    stage.update();

	}
	
	private Graphics drawSmiley(String fillColor,String lineColor){
		g = createJSObject.Graphics();
	    Point pt1 = Point.create(138, 300);
	    Point pt2 = Point.create(309, 310);
	    Point pt3 = Point.create(337, 170);
	    Point pt4 = Point.create(360, 170);
	    Point pt5 = Point.create(374, 234);
	    Point pt6 = Point.create(388, 220);
	    Point pt7 = Point.create(75, 240);
	    Point pt8 = Point.create(63, 230);
	    Point pt9 = Point.create(100, 178);
	    Point pt10 = Point.create(115, 181);

	    //Left Eye
	    Point pt11 = Point.create(169, 119);
	    Point pt12 = Point.create(198, 115);
	    Point pt13 = Point.create(175, 153);
	    Point pt14 = Point.create(205, 148);

	    Point pt11a = Point.create(169, 105);
	    Point pt12a = Point.create(188, 100);
	    Point pt13a = Point.create(183, 173);
	    Point pt14a = Point.create(205, 169);

	    //Right Eye
	    Point pt15 = Point.create(251, 109);
	    Point pt16 = Point.create(279, 115);
	    Point pt17 = Point.create(244, 148);
	    Point pt18 = Point.create(273, 152);
	    Point pt15a = Point.create(261, 97);
	    Point pt16a = Point.create(272, 99);
	    Point pt17a = Point.create(249, 166);
	    Point pt18a = Point.create(263, 168);

	    //Head
	    g= g.setStrokeStyle(20);
	    g= g.beginStroke(lineColor);
	    g= g.beginFill(fillColor);
	    g= g.drawCircle(225, 223, 200);
	    g= g.endFill();

	    //Left Eye
	    g= g.setStrokeStyle(1, "round", "round");
	    g= g.beginStroke(lineColor);
	    g= g.beginFill(lineColor);
	    g= g.moveTo(169,119);
	    g= g.lineTo(175,153);
	    g= g.bezierCurveTo(pt13a.getX(), pt13a.getY(), pt14a.getX(), pt14a.getY(), 205, 148);
	    g=  g.lineTo(198,115);
	    g=  g.bezierCurveTo(pt12a.getX(), pt12a.getY(), pt11a.getX(), pt11a.getY(), 169, 119);
	    g=  g.endFill();

	    //Right Eye
	    g= g.setStrokeStyle(1, "round", "round");
	    g= g.beginFill(lineColor);
	    g= g.beginStroke(lineColor);
	    g= g.moveTo(251,109);
	    g= g.lineTo(244, 148);
	    g=  g.bezierCurveTo(pt17a.getX(), pt17a.getY(), pt18a.getX(), pt18a.getY(), 273, 152);
	    g= g.lineTo(279, 115);
	    g= g.bezierCurveTo(pt16a.getX(), pt16a.getY(), pt15a.getX(), pt15a.getY(), 251, 109);
	    g= g.endFill();

	    //Mouth
	    g=  g.setStrokeStyle(1, "round", "round");
	    g= g.beginStroke(lineColor);
	    g= g.beginFill(lineColor);
	    g= g.moveTo(100, 210);
	    g=  g.bezierCurveTo(pt1.getX(), pt1.getY(), pt2.getX(), pt2.getY(), 351, 205);
	    g=  g.lineTo(340, 187);
	    g= g.bezierCurveTo(pt3.getX(), pt3.getY(), pt4.getX(), pt4.getY(), 360, 178);
	    g= g.lineTo(383, 210);
	    g=  g.bezierCurveTo(pt6.getX(), pt6.getY(), pt5.getX(), pt5.getY(), 365, 222);
	    g=  g.bezierCurveTo(pt2.getX()-30, pt2.getY()+50, pt1.getX()+30, pt1.getY()+50, 90, 228);
	    g= g.bezierCurveTo(pt7.getX(), pt7.getY(), pt8.getX(), pt8.getY(), 73, 210);
	    g= g.lineTo(93, 182);
	    g=  g.bezierCurveTo(pt9.getX(), pt9.getY(), pt10.getX(), pt10.getY(), 109, 197);
	    g= g.lineTo(100, 210);
	    g= g.endFill();
	    
	    return g;
	}
	
	private void layoutSmiley(CreateJSObject createJSObject){
		Graphics g =drawSmiley(createJSObject.Graphics().getRGB((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)),
				createJSObject.Graphics().getRGB((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
	    for(int i=0;i<100;i++) {
	        Shape shape = Shape.createShape(g);
	        double scale = (Math.random() * 0.05 + 0.15);
	        shape.setScaleX(scale);
	        shape.setScaleY(scale);
	        shape.setX(Math.random()*(960 - (350 * shape.getScaleX())));
	        shape.setY(Math.random()*(400 - (350 * shape.getScaleX())));
	        shape.setRotation((Math.random()*90)-45);
	        stage.addChild(shape);
	    }

	    stage.update();
	}

}
