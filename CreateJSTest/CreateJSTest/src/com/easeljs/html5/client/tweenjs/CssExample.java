package com.easeljs.html5.client.tweenjs;

import com.easeljs.html5.client.easeljs.IEasel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBackTween;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.tween.CSSPlugin;
import com.sinewavemultimedia.easeljs.framework.js.tween.Property;
import com.sinewavemultimedia.easeljs.framework.js.tween.Tween;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

public class CssExample implements IEasel {

	@Override
	public void load(VerticalPanel panel) {
		CSSPlugin.install();
		Ticker.setFPS(20);
		int count = 600;
		while(--count>=0){
			CreateJSObject box = new CreateJSObject();
			DOM.setStyleAttribute(box.getElement(), "width", "6px");
			DOM.setStyleAttribute(box.getElement(), "height", "2px");
			DOM.setStyleAttribute(box.getElement(), "position", "absolute");
			DOM.setStyleAttribute(box.getElement(), "borderRadius", "2px");
			DOM.setStyleAttribute(box.getElement(), "backgroundColor", "#0F0");
			RootPanel.get().add(box);
			
			double a = (Math.random()*Math.PI*2*16)/16;
			DOM.setStyleAttribute(box.getElement(), "webkitTransform", "rotate("+a+"rad)");
			double d = 30;
			DOM.setStyleAttribute(box.getElement(), "left", 1024/2+Math.cos(a-0.2-Math.random())*d+"px");
			DOM.setStyleAttribute(box.getElement(), "top", 768/2+Math.sin(a-0.2-Math.random())*d+"px");
			d = (Math.min(1024,768)-16)/2*(Math.random()*0.3+0.7);
			double x = 1024/2+Math.cos(a)*d;
			double y = 768/2+Math.sin(a)*d;
			
            Property loop = Property.createProperty();
            loop.addBooleanProperty("loop", true);
            
            Property opacity = Property.createProperty();
            opacity.addIntProperty("opacity", 0);            

            CallBackTween updateColor = new CallBackTween() {
				
				@Override
				public void onSuccess(Tween tween) {
					//tween.getTarget().geSstyle.backgroundColor = "hsl("+(Math.random()*60+colorSeed|0)+",100%,50%)";
					
				}
			};
			Property tot = Property.createProperty();
			tot.addDoubleProperty("top", y);
			tot.addDoubleProperty("left", x);
			tot.addDoubleProperty("width", 16);
			tot.addDoubleProperty("height", 4);
			tot.addDoubleProperty("opacity", 1);
		    //Tween.get(box, loop, true).set(opacity,DOM.getAttribute(box.getElement(), "style")).wait(Math.random()*1000+1).call(updateColor).to(tot,Math.random()*1500+1000,easeIn);			
			
		}
		
		
	}
	

}
