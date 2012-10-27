package com.easeljs.html5.client.easeljs;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.display.Container;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.display.Text;

/*
* author: James Tyner 
*/
public class DoubleClick implements IEasel {

	@Override
	public void load(VerticalPanel panel) {
		int canvaswidth = 960;
		int canvasheight = 400;

		CreateJSObject createJSObject = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		Stage stage = createJSObject.getStage();
		
		Container container = Container.createContainer();
		container.setX(100);
		container.setY(80);
		
		
		Shape target = Shape.createShape();
		target.setGraphics(createJSObject.Graphics().beginFill("#F00").drawRect(-10,-10,300,60).beginFill("#FFF"));
		container.addChild(target);
		
		Text txt = Text.create("Double Click Me!", "36px Arial", "#FFF");
		txt.setTextBaseline("top");
		container.addChild(txt);
		
		stage.addChild(container);
		
		final Label  labelText = new Label();
		
		CallBackEvent callBack = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {
				labelText.setText("Double Clicked the container object");
				
			}
		};
		
		container.onDoubleClick((callBack));
		
		stage.update();
		

		
		panel.add(createJSObject);
		panel.add(labelText);
	}
	
	public final native JavaScriptObject getObject(CallBack callBack)/*-{
		return function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
		}
	}-*/;

}
