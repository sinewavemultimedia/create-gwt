package com.easeljs.html5.client.easeljs;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Container;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.display.Text;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;
/*
* author: James Tyner 
*/
public class BarGraph implements IEasel {

	int canvaswidth = 960;
	int canvasheight = 400;
	int maxValue = 50;
	int barValues[] , barHeight = 0 ,barPadding = 7;
	Text label;
	
	int count = 0;
	private Stage stage= null;
	
	CreateJSObject createJSObject = null;
	Container[] bars;
	Label labelText = null;
	@Override
	public void load(VerticalPanel panel) {
		createJSObject =new CreateJSObject(""+canvaswidth, ""+canvasheight);
		CallBack callBack = new CallBack() {
			
			@Override
			public void onSuccess() {
				if (--count == 1){ Ticker.removeListener(getWindow()); }

				// animate the bars in one at a time:
				int c = bars.length*10-count;
				int index = c/10|0;
				Container bar = bars[index];
				drawBar(bar, ((float)(c%10+1)/10)*barValues[index]);

				stage.update();
				
			}
		};
		dotick(callBack);
		labelText = new Label();
		panel.add(createJSObject);
		panel.add(labelText);
		stage = createJSObject.getStage();
		
		int numBars = (int)Math.random()*6+4;
		int max = 0;
		
		barValues = new int[numBars];
		for (int i=0; i<numBars; i++) {
			int val = (int)(Math.random()*maxValue+1);
			if (val > max) { max = val; }
			barValues[i] = val;
		}		
		
		int barWidth = (canvaswidth-150-(numBars-1)*barPadding)/numBars;
		barHeight = canvasheight-150;		
		
		Shape bg = Shape.createShape();
		
		stage.addChild(bg);
		
		bg.setGraphics(createJSObject.Graphics().beginStroke("#444")
				.moveTo(40, canvasheight-69.5)
				.lineTo(canvaswidth-70, canvasheight-69.5)
				.endStroke()
				.beginFill("#222")
				.moveTo(canvaswidth-70, canvasheight-70)
				.lineTo(canvaswidth-60, canvasheight-80)
				.lineTo(50, canvasheight-80)
				.lineTo(40, canvasheight-70)
				.closePath());
		
		for (int i=0; i<9; i++) {
			bg.setGraphics(createJSObject.Graphics().beginStroke( (i % 2)==0 ? "#333" : "#444")
				.moveTo(50,(canvasheight-80-i/8*barHeight|0)+0.5)
				.lineTo(canvaswidth-60,(canvasheight-80-i/8*barHeight|0)+0.5));
		}
	
		label = Text.create("Bar Graph Example", "bold 30px Arial", "#FFF");
		label.setTextAlign("center");
		label.setX(canvaswidth/2);
		label.setY(20);
		stage.addChild(label);
		
		bars = new Container[numBars];
		for (int i=0; i<numBars; i++) {
			Container bar = Container.createContainer();

			int hue = (int)(((float)i/numBars)*360);
			bar.setHue(hue);

			Shape front = Shape.createShape();
			String s1 = ""+createJSObject.Graphics().getHSL(hue,100,60,0.9);
			String s2 = ""+createJSObject.Graphics().getHSL(hue,100,20,0.75);
			JsArrayString array =(JsArrayString)JsArrayString.createArray();
			array.push(s1);
			array.push(s2);
			
			JsArrayNumber arrayNumber = (JsArrayNumber)JsArrayNumber.createArray();
			arrayNumber.push(0);
			arrayNumber.push(1);
			front.setGraphics(createJSObject.Graphics().beginLinearGradientFill(array,arrayNumber,0,-100,	barWidth,0).drawRect(0,-100,barWidth+1,	100));

			Shape top = Shape.createShape();
			top.setGraphics(createJSObject.Graphics().beginFill(createJSObject.Graphics().getHSL(hue,100,70,0.9))
				.moveTo(10,-10).lineTo(10+barWidth,-10).lineTo(barWidth,0).lineTo(0,0).closePath());

			if (barValues[i] == max) {
				top.setGraphics(createJSObject.Graphics().beginFill("rgba(0,0,0,0.45)").drawPolyStar(barWidth/2, 31, 7, 5, 0.6, -90).closePath());
			}

			Shape right = Shape.createShape();
			right.setX(barWidth-0.5);


			Text label = Text.create("Label "+i, "16px Arial", "#FFF");
			label.setTextAlign("center");
			label.setX(barWidth/2);
			label.setMaxWidth(barWidth);
			label.setY(12);
			label.setAlpha(0.5);

			Shape tab = Shape.createShape();
			tab.setGraphics(createJSObject.Graphics().beginFill(createJSObject.Graphics().getHSL(hue,100,20))
				.drawRoundRectComplex(0,1,barWidth,38,0,0,10,10));

			Text value = Text.create("foo","bold 14px Arial","#000");
			value.setTextAlign("center");
			value.setX(barWidth/2);
			value.setAlpha(0.45);

			bar.addChild(right);
			bar.addChild(front);
			bar.addChild(top);
			bar.addChild(value);
			bar.addChild(tab);
			bar.addChild(label);

			bar.setX(i*(barWidth+barPadding)+60);
			bar.setY(canvasheight-70);

			stage.addChild(bar);
			bars[i]=bar;

			drawBar(bar, 0);
		}		
		
		count = numBars*10;

		
		Ticker.setUseRAF(true);
		Ticker.setFPS(30);
		Ticker.addListener(getWindow(),true);		
		
	}
	
	private void drawBar(final Container bar,float value){
		labelText.setText(" value is "+ value);
		double h = value/maxValue*barHeight;


		Text val = (Text)bar.getChildAt(3);
		val.setText(""+value);
		val.setVisible(h>28);
		val.setY(-h+10);

		((Shape)bar.getChildAt(1)).setScaleY(h/100);
		((Shape)bar.getChildAt(2)).setY(-h+0.5); 

		Shape right = (Shape)bar.getChildAt(0);
		
		right.setGraphics(createJSObject.Graphics().clear().beginFill(createJSObject.Graphics().getHSL(bar.getHue(),90,15,0.7))
			.moveTo(0,0)
			.lineTo(0,-h)
			.lineTo(10,-h-10)
			.lineTo(10,-10)
			.closePath());
	}
	
	
	private static native void dotick(CallBack callBack) /*-{
		$wnd.tick=function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
		}
	}-*/; 
	
	private static native JavaScriptObject getWindow()/*-{
		return $wnd;
	}-*/;
	
}
