package com.easeljs.html5.client.soundjs;

import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;

/*
* author: James Tyner 
*/
public class SpaceRock{

	double  bounds = 0 ,hit = 0 , spin =0 ,  vX =0 , vY = 0 ;

	boolean active = false;
	public static int LRG_ROCK = 40;
	public static int MED_ROCK = 20;
	public static int SML_ROCK = 10;
	int score = 0 ,size = 0 ;
	Shape shape = null;
	
	
	public SpaceRock(int size,CreateJSObject createJSObject){
		shape = Shape.createShape();
		activate(size,createJSObject);				
	}
	
	private void getShape(int size,CreateJSObject createJSObject){
		double angle = 0;
		double radius = size;
		this.size =  size;
		this.hit = size;
		
		shape.setGraphics(createJSObject.Graphics().clear().beginStroke("#FFFFFF").moveTo(0, size));
		
		while(angle < (Math.PI*2 - 0.5)){
			angle += (0.25+((Math.random()*100)/500));
			radius = size+(size/2*Math.random());
			shape.setGraphics(shape.getGraphics().lineTo(Math.sin(angle)*radius, Math.cos(angle)*radius));
			
			if(radius > this.bounds) { this.bounds = radius; }
			this.hit = (this.hit + radius) / 2;	

		}
		shape.setGraphics(shape.getGraphics().closePath());
		this.hit *= 1.1;
		
	}
	
	public void activate(int size,CreateJSObject createJSObject){
		this.getShape(size,createJSObject);	
		double angle = Math.random()*(Math.PI*2);
		this.vX = Math.sin(angle)*(5 - size/10);
		this.vY = Math.cos(angle)*(5 - size/10);
		this.spin = (Math.random() + 0.2 )* this.vX;
		this.score = (5 - size/10) * 100;
		this.active = true;
		
	}
	
	public void tick(){
		shape.setRotation(shape.getRotation()+this.spin);
		double x = shape.getX();
		double y = shape.getY();
		shape.setX(x+this.vX);
		shape.setY(y+this.vY);		
	}
	
	public void floatOnScreen(double width,double height){
		double random = Math.random();
		double totWidth = (random*(width+height));
		if( totWidth > width) {
			if(this.vX > 0) {
				shape.setX(-2 * this.bounds);
			} else {
				shape.setX((2 * this.bounds) + width);
			}

			if(this.vY > 0) {
				shape.setY(Math.random()*height*0.5);
			} else {
				shape.setY((Math.random()*height*0.5) + (0.5*height));
			}

		} else {

			if(this.vY > 0) {
				shape.setY(-2 * this.bounds);
			} else {
				shape.setY((2 * this.bounds) + height);
			}

			if(this.vX > 0) {
				shape.setX(Math.random()*width*0.5);
			} else {
				shape.setX((Math.random()*width*0.5) + (0.5*width));

			}
		}
	}
	
	public boolean hitPoint(double tX,double tY){
		return hitRadius(tX, tY, 0);
	}
	
	public boolean hitRadius(double tX,double tY,double tHit){

		if(tX - tHit > shape.getX() + this.hit) { return false; }
		if(tX + tHit < shape.getX() - this.hit) { return false; }
		if(tY - tHit > shape.getY() + this.hit) { return false; }
		if(tY + tHit < shape.getY()- this.hit) { return false; }
		return (this.hit + tHit) > Math.sqrt(Math.pow(Math.abs(shape.getX() - tX),2) + Math.pow(Math.abs(shape.getY() - tY),2));
		
	}
	
	public double getBounds(){
		return this.bounds;
	}
	
	public int getSize(){
		return this.size;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public boolean getActive(){
		return active;
	}
	public void setActive(boolean active){
		this.active = active;
	}
	
	public Shape getShape(){
		return this.shape;
	}
}
