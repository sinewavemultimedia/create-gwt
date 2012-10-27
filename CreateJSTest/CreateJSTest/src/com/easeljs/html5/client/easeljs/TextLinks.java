package com.easeljs.html5.client.easeljs;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.TextLink;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.display.Text;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class TextLinks implements IEasel {

	CreateJSObject createJSObject = null;
	Stage stage = null;
	int canvaswidth = 960;
	int canvasheight = 400;
	
	
	@Override
	public void load(VerticalPanel panel) {
		createJSObject = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage = createJSObject.getStage();
		stage.enableMouseOver(20);
		
		panel.add(createJSObject);
		String []links = new String[]{"yellow", "blue", "green", "red", "purple", "orange"};
		for(int i =0 ; i < links.length ; i++){
			TextLink link = TextLink.createLink(links[i]+" link!", "36px Arial", links[i], "#FFF");
			link.setX(100);
			link.setY(50 + i * 50);
			CallBackEvent backEvent = new CallBackEvent() {
				
				@Override
				public void onSuccess(Event event) {
					Window.alert("You clicked on: "+((Text)event.getTarget()).getText());
					
				}
			};
			link.onClick(backEvent);
			
			stage.addChild(link);
		}
		
		Ticker.addListener(stage);


	}

}
