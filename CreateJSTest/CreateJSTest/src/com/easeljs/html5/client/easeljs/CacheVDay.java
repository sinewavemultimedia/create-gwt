package com.easeljs.html5.client.easeljs;

import com.easeljs.html5.client.extend.VShape;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Container;
import com.sinewavemultimedia.easeljs.framework.js.display.Graphics;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.display.Text;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class CacheVDay implements IEasel {
	
	int canvaswidth = 960;
	int canvasheight = 400;
	int captureIndex= 0;
	CreateJSObject createJSObject = null;
	Container container = null;
	Stage stage = null;
	
	Container captureContainers[] = new Container[100];

	
	@Override
	public void load(VerticalPanel panel) {
		createJSObject =new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage = createJSObject.getStage();
		
		
		CallBack back = new CallBack() {
			
			@Override
			public void onSuccess() {
				int w = canvaswidth;
				int h = canvasheight;
				int l = container.getNumChildren();
				
				captureIndex = (captureIndex+1)% captureContainers.length;
				stage.removeChildAt(0);

				Container captureContainer = captureContainers[captureIndex];
				stage.addChildAt(captureContainer, 0);
				
				captureContainer.addChild(container);
				
				for (int i=0; i<l; i++) {
					VShape heart = (VShape)container.getChildAt(i);
					if (heart.getY() < -50) {
						heart.set_X(Math.random()*w);
						heart.setY(h*(1+Math.random())+50);
						heart.setPerX((1+Math.random())*h);
						heart.setOffX(Math.random()*h);
						heart.setAmpX(heart.getPerX()*0.1*(0.2+Math.random()));
						heart.setVelY(-Math.random()*2-2);
						double randomValue = Math.random()+1;
						heart.setScaleX(randomValue);
						heart.setScaleY(randomValue);
						heart.setRotation(Math.random()*40-20);
						heart.setAlpha(Math.random());
					}
					double getY = heart.getY() + heart.getVelY();
					double _x   = heart.get_X();
					double offx = heart.getOffX();
					double y = heart.getY();
					double perX= heart.getPerX();
					double ampx = heart.getAmpX();
					double getX =  _x + Math.cos((offx+y)/perX*Math.PI*2)*ampx;
					heart.setY(getY);
					heart.setX(getX);
				}

				captureContainer.updateCache("source-over");
				stage.update();				
			}
		};
		
		dotick(back);
		
		int w = canvaswidth;
		int h = canvasheight;
		
		container = Container.createContainer();
		
		stage.addChild(container);
		
		for (int i=0; i<50; i++) {
			VShape heart = (VShape)VShape.createVShape();
			heart.setGraphics(createJSObject.Graphics().beginFill(Graphics.getHSL(Math.random()*30-45, 100, 50+Math.random()*30)));
			heart.setGraphics(heart.getGraphics().moveTo(0,-9).quadraticCurveTo(0,-20,8,-20).quadraticCurveTo(16,-20,16,-10).quadraticCurveTo(16,0,0,12));
			heart.setGraphics(heart.getGraphics().quadraticCurveTo(-16,0,-16,-10).quadraticCurveTo(-16,-20,-8,-20).quadraticCurveTo(0,-20,0,-9));
			heart.setY(-100);

			container.addChild(heart);
		}		
		
		Text text = Text.create("the longer I'm with you\nthe more I love you", "bold 24px Arial", "#312");
		text.setTextAlign("center");
		text.setX(w/2);
		text.setY(h/2);
		
		stage.addChild(text);
		
		for (int i=0; i<100; i++) {
			Container captureContainer = Container.createContainer();
			captureContainer.cache(0,0,w,h);
			captureContainers[i] = captureContainer;
		}
		
		panel.add(createJSObject);
		
		Ticker.setFPS(30);
		Ticker.addListener(getWindow(),true);	
	}
	
	private static native JavaScriptObject getWindow()/*-{
		return $wnd;
	}-*/;
	
	private static native void dotick(CallBack callBack) /*-{
		$wnd.tick=function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
		}
	}-*/; 	

}
