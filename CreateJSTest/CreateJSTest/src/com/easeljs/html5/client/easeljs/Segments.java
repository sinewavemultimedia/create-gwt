package com.easeljs.html5.client.easeljs;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.Canvas;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Container;
import com.sinewavemultimedia.easeljs.framework.js.display.Graphics;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.utils.Segment;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class Segments implements IEasel {

	Canvas canvas = null;
	Stage stage	=	null; 
	int canvaswidth = 960;
	int canvasheight = 400;
	Graphics graphics = null;
	int offset = 100;
	CreateJSObject createJSObject = null;
	Segment body = null, rightArm=null,leftArm=null,loader=null,rightForeArm=null,leftForeArm=null,rightThigh=null,right=null,leftThigh=null;
	Segment rightFoot = null,left=null,leftFoot=null;
	Container container = null;
	
	double rate = 0.0;
	
	boolean isAutomate = false;
	
	@Override
	public void load(final VerticalPanel panel) {
		createJSObject = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage = createJSObject.getStage();
		canvas = createJSObject.getCanvas();
		
		panel.add(createJSObject);
		
		body =Segment.createSegment(120, 30, "#FFFF99");
		body.setRotation(90);
		body.setY(-120);
		
		rightArm = Segment.createSegment(85, 25, "#FFFF99");
		rightArm.setX(body.getPoint().getX());
		rightArm.setY(body.getY());
		rightArm.setRotation(90);
		
		rightForeArm=Segment.createSegment(80, 20, "#FFFF99");
		rightForeArm.setX(rightArm.getPoint().getX());
		rightForeArm.setY(rightArm.getPoint().getY());
		rightForeArm.setRotation(90);
		
		leftArm=Segment.createSegment(85, 25, "#FFFF99");
		leftArm.setX(body.getPoint().getX());
		leftArm.setY(body.getY());
		leftArm.setRotation(90);
		
		leftForeArm=Segment.createSegment(80, 20, "#FFFF99");
		leftForeArm.setX(rightArm.getPoint().getX());
		leftForeArm.setY(rightArm.getPoint().getY());
		leftForeArm.setRotation(90);
		
        rightThigh = Segment.createSegment(95, 20, "#FFFF99");
        rightThigh.setX(body.getPoint().getX());
        rightThigh.setY(body.getPoint().getY());
        rightThigh.setRotation(90);

        right =  Segment.createSegment(110, 30, "#FFFF99");
        right.setX(rightThigh.getPoint().getX());
        right.setY(rightThigh.getPoint().getY());
        right.setRotation(90);

        leftThigh = Segment.createSegment(95, 20, "#FFFF99");
        leftThigh.setX(body.getPoint().getX());
        leftThigh.setY(body.getPoint().getY());
        leftThigh.setRotation(90);

        rightFoot =  Segment.createSegment(45, 40, "#FFFF99");
        rightFoot.setX(right.getPoint().getX());
        rightFoot.setY(right.getPoint().getY());

        left =  Segment.createSegment(110, 30, "#FFFF99");
        left.setX(leftThigh.getPoint().getX());
        left.setY(leftThigh.getPoint().getY());
        left.setRotation(90);

        leftFoot =  Segment.createSegment(45, 40, "#FFFF99");
        leftFoot.setX(left.getPoint().getX());
        leftFoot.setY(left.getPoint().getY());
        
        container = Container.createContainer();
        container.addChild(leftArm);
        container.addChild(leftForeArm);
        container.addChild(leftThigh);
        container.addChild(leftFoot);
        container.addChild(left);
        container.addChild(body);
        container.addChild(right);
        container.addChild(rightThigh);
        container.addChild(rightFoot);
        container.addChild(rightForeArm);
        container.addChild(rightArm);
		
        container.setX(275);
        container.setY(137);
        
        stage.addChild(container);
        stage.update();
        
        CallBack callBack = new CallBack() {
			
			@Override
			public void onSuccess() {
				rate += 0.1;
				
	           move(rightThigh, right, rightFoot, rate);
	           move(leftThigh, left, leftFoot, rate*2);

	           moveUpperBody(leftArm, leftForeArm, rate*2.5);
	           moveUpperBody(rightArm, rightForeArm, rate*1.5);

	           stage.update();				
			}
		};
        
        dotick(callBack);
        
        Ticker.addListener(getWindow());
	}

	
    private void move(Segment segA,Segment segB,Segment segC,double p_rate) {
        double angleA = Math.sin(p_rate) * 45 + 90;
        double angleB = Math.sin(p_rate + offset) * 45 + 45;
        double angleC = Math.sin(p_rate) * 90 - 50;

        segA.setRotation(angleA);
        segB.setRotation(segA.getRotation()+ angleB);
        segC.setRotation(segB.getRotation()+ angleC);

        segB.setX(segA.getPoint().getX());
        segB.setY(segA.getPoint().getY());

        segC.setX(segB.getPoint().getX());
        segC.setY(segB.getPoint().getY());
     }

    private void moveUpperBody(Segment segA,Segment segB,double p_rate) {
         double angleA = Math.sin(p_rate) * 45 + 90;
         double angleB = Math.sin(p_rate + offset) * 45 - 35;

         segA.setRotation( angleA);
         segB.setRotation( segA.getRotation() + angleB);

         segB.setX(segA.getPoint().getX());
         segB.setY(segA.getPoint().getY());
     }
	
	private static native JavaScriptObject getWindow()/*-{
		return $wnd;
	}-*/;
	
	private static native void dotick(CallBack callBack) /*-{
		$wnd.tick=function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
	}}-*/; 	

	
}
