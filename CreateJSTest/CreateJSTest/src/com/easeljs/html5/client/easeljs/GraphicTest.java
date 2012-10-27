package com.easeljs.html5.client.easeljs;

import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.Canvas;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.Image;
import com.sinewavemultimedia.easeljs.framework.js.display.Container;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;

/*
* author: James Tyner 
*/
public class GraphicTest implements IEasel {

	int canvaswidth = 960;
	int canvasheight = 400;
	Image img=null;
	Stage stage =null;
	Canvas canvas = null;
	CreateJSObject createJSObject = null;
	
	@Override
	public void load(final VerticalPanel panel) {
		createJSObject  = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage = createJSObject.getStage();
		canvas = createJSObject.getCanvas();

		CallBackEvent callBack = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
	            int padding = 5;
	            int _width = 155;
	            int _height = 155;
	            int cols = 4;
	            int space = 0;
	            
	            Container border = createBorder();
				Container tile1 = createStar();
				tile1.setX(42+(_width + padding) *(0%cols));
				tile1.setY(42+(0/cols ) * (_height+padding));
				stage.addChild(tile1);
				
				Container tile2 = createHex();
				tile2.setX(42+(_width + padding) *(1%cols));
				tile2.setY(42+(1/cols ) * (_height+padding));
				stage.addChild(tile2);		
				
				Container tile3 = createLineTo();
				tile3.setX(42+(_width + padding) *(2%cols));
				tile3.setY(42+(2/cols ) * (_height+padding));
				stage.addChild(tile3);		
				
				Container tile4 = createRadialGradientFill();
				tile4.setX(42+(_width + padding) *(3%cols));
				tile4.setY(42+(3/cols ) * (_height+padding));
				stage.addChild(tile4);	
				
				Container tile5 = createEllipse();
				tile5.setX(42+(_width + padding) *(4%cols));
				tile5.setY(42+(4/cols ) * (_height+padding));
				stage.addChild(tile5);				
	
				Container tile6 = createRectGradientFill();
				tile6.setX(42+(_width + padding) * (5%cols));
				tile6.setY(42+(5/cols ) * (_height+padding));
				stage.addChild(tile6);	
				
				Container tile7 = createBitmapFill();
				tile7.setX(42+(_width + padding) * (6%cols));
				tile7.setY(42+(6/cols ) * (_height+padding));
				stage.addChild(tile7);						
				
	            stage.addChild(border);
	            stage.update();
			}
		};
		panel.add(createJSObject);
		img = Image.create();
		img.setSrc("../resources/images/daisy.png");
		img.onLoad(callBack);
	}
	
	private Container createBitmapFill(){
		Container container = createTile();
		Shape s = Shape.createShape();
		JsArrayString array =(JsArrayString)JsArrayString.createArray();
		array.push("#FFF");
		array.push("#000");	
		JsArrayNumber arrayNumber = (JsArrayNumber)JsArrayNumber.createArray();
		arrayNumber.push(0);
		arrayNumber.push(1);		
		s.setGraphics(createJSObject.Graphics().beginBitmapFill(img).setStrokeStyle(8).beginRadialGradientStroke(array,arrayNumber,0,0,0,0,30,130).drawRect(0, 0, 130, 130));
		s.setX(12);
		s.setY(10);
		container.addChild(s);
		return container;			
	}
	
	private Container createRectGradientFill(){
		Container container = createTile();
		Shape s = Shape.createShape();
		JsArrayString array =(JsArrayString)JsArrayString.createArray();
		array.push("#FFF");
		array.push("#000");		
		JsArrayNumber arrayNumber = (JsArrayNumber)JsArrayNumber.createArray();
		arrayNumber.push(0);
		arrayNumber.push(1);		
		s.setGraphics(createJSObject.Graphics().beginLinearGradientFill(array,arrayNumber,0,0,0,130).drawRect(0,0,130,130));
		s.setX(12);
		s.setY(10);
		container.addChild(s);
		return container;		
	}
	
	private Container createEllipse(){
		Container container = createTile();
		Shape s = Shape.createShape();
		JsArrayString array =(JsArrayString)JsArrayString.createArray();
		array.push("#F00");
		array.push("#000");		
		JsArrayNumber arrayNumber = (JsArrayNumber)JsArrayNumber.createArray();
		arrayNumber.push(0);
		arrayNumber.push(1);
		s.setGraphics(createJSObject.Graphics().beginFill(createJSObject.Graphics().getRGB(0,102,153,0.5)).setStrokeStyle(4).beginLinearGradientStroke(array,arrayNumber,0,0,70,140).drawEllipse(0,0,70,140,8));
		s.setX(40);
		s.setY(10);
		container.addChild(s);
		return container;			
	}
	
	private Container createRadialGradientFill(){
		Container container = createTile();
		Shape s = Shape.createShape();
		JsArrayString array =(JsArrayString)JsArrayString.createArray();
		array.push("#FFF");
		array.push("#0FF");		
		JsArrayNumber arrayNumber = (JsArrayNumber)JsArrayNumber.createArray();
		arrayNumber.push(0);
		arrayNumber.push(1);		
		s.setGraphics(createJSObject.Graphics().setStrokeStyle(8).beginStroke("#f0f").beginRadialGradientFill(array,arrayNumber,0,0,0,0,0,40).drawCircle(0,0,40));
		s.setX(80);
		s.setY(80);
		container.addChild(s);
		return container;		
	}
	
	private Container createLineTo(){
		Container container = createTile();
		Shape s = Shape.createShape();
		s.setGraphics(createJSObject.Graphics().setStrokeStyle(16, "round", "round").beginStroke("#f90").moveTo(20,10).lineTo(90,90).lineTo(90,140));
		container.addChild(s);
		return container;		
	}
	
	private Container createHex(){
		Container container= createTile();
		Shape s = Shape.createShape();
		s.setGraphics(createJSObject.Graphics().beginFill("#0F0").drawPolyStar(0,0,40,6).drawPolyStar(0,75,40,6));
		s.setX(80);
		s.setY(40);
		container.addChild(s);
		return container;
	}
	
	private Container createBorder(){
		Container container = Container.createContainer();
		Shape s = Shape.createShape();
		s.setGraphics(createJSObject.Graphics().beginBitmapStroke(img).setStrokeStyle(32).drawRect(20,20,920,360));
		container.addChild(s);
		return container;
	}
	
	private Container createStar(){
		Container container= createTile();
		Shape s = Shape.createShape();
		s.setGraphics(createJSObject.Graphics().setStrokeStyle(1).beginStroke(createJSObject.Graphics().getRGB(255, 255, 0)).beginFill("#FF0").endStroke().drawPolyStar(0,0,80,5,0.6,-90));
		s.setX(80);
		s.setY(85);
		container.addChild(s);
		return container;
	}
	
	private Container createTile(){
		Container container = Container.createContainer();
		Shape bg = Shape.createShape();
		bg.setGraphics(createJSObject.Graphics().beginFill("#CCCCCC").drawRect(0, 0, 155, 155).endFill());
		bg.setAlpha(0.25);
		container.addChild(bg);
		
		return container;
	}

}
