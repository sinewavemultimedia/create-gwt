package com.easeljs.html5.client.soundjs;

import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Container;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;

/*
* author: James Tyner 
*/
public class Ship  {
	
	Container container = null;

	public Ship(CreateJSObject createJSObject){
		this.createJSObject = createJSObject;
		container = Container.createContainer();
		shipFlame = Shape.createShape();
		shipBody = Shape.createShape();
		container.addChild(shipFlame);
		container.addChild(shipBody);
		makeShape();		
	}

	Shape shipFlame = null;
	Shape shipBody = null;
	CreateJSObject createJSObject = null;
	double TOGGLE = 60;
	double MAX_THRUST = 2;
	double MAX_VELOCITY = 5;
	double vX = 0, vY = 0, thrust = 0;
	int timeout = 0;
	double bounds = 0 , hit = 0;
	
	
	public void doTick(){
		container.setX(container.getX()+vX);
		container.setY(container.getY()+vY);
		
		if(thrust > 0){
			timeout = timeout+1;
			shipFlame.setAlpha(1);
			if(timeout >TOGGLE){
				timeout = 0;
				if(shipFlame.getScaleX()==1){
					shipFlame.setScaleX(0.5);
					shipFlame.setScaleY(0.5);
				}else{
					shipFlame.setScaleX(1);
					shipFlame.setScaleY(1);						
				}
			}
			thrust = thrust-0.5;
		}else{
			shipFlame.setAlpha(0);
			thrust = 0;
		}		
	}
	
	public void accelerate(){
//doubt		this.thrust += this.thrust + 0.6;
		
		thrust += thrust+0.6;

		if(thrust >= MAX_THRUST) {
			thrust = MAX_THRUST;
		}
		this.vX += Math.sin(container.getRotation()*(Math.PI/-180))*this.thrust;
		this.vY += Math.cos(container.getRotation()*(Math.PI/-180))*this.thrust;
		this.vX = Math.min(MAX_VELOCITY, Math.max(-MAX_VELOCITY, this.vX));
		this.vY = Math.min(MAX_VELOCITY, Math.max(-MAX_VELOCITY, this.vY));

		
	}
	
	private void makeShape(){
		shipBody.setGraphics(createJSObject.Graphics().clear().beginStroke("#FFFFFF").moveTo(0, 10).lineTo(5, -6).lineTo(0, -2).lineTo(-5, -6).closePath());
		shipFlame.setScaleX(0.5);
		shipFlame.setScaleY(0.5);
		shipFlame.setY(-5);
		shipFlame.setGraphics(createJSObject.Graphics().clear().beginStroke("#FFFFFF").moveTo(2, 0).lineTo(4, -3).lineTo(2, -2).lineTo(0, -5).lineTo(-2, -2).lineTo(-4, -3).lineTo(-2, -0));
		bounds = 10;
		hit = bounds;
	}
	
	public double getBounds(){
		return this.bounds;
	}
	
	public double getHit(){
		return this.hit;
	}
	
	public Container getShip(){
		return this.container;
	}
}
