package com.easeljs.html5.client.tweenjs;

import java.util.ArrayList;
import java.util.List;

import com.easeljs.html5.client.easeljs.IEasel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.CallBack;
import com.sinewavemultimedia.easeljs.framework.js.CallBackTween;
import com.sinewavemultimedia.easeljs.framework.js.Canvas;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Container;
import com.sinewavemultimedia.easeljs.framework.js.display.Graphics;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.geom.Point;
import com.sinewavemultimedia.easeljs.framework.js.tween.Ease;
import com.sinewavemultimedia.easeljs.framework.js.tween.EaseFunction;
import com.sinewavemultimedia.easeljs.framework.js.tween.Property;
import com.sinewavemultimedia.easeljs.framework.js.tween.Tween;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class SparkTable implements IEasel {
	
	class Functions{
		String label;
		EaseFunction function;
		public Functions(EaseFunction function,String label){
			this.label = label;
			this.function = function;
		}
		
		public String getLabel(){
			return this.label;
		}
		
		public EaseFunction getEaseFunction(){
			return this.function;
		}
	}

	CreateJSObject createJSObject  = null;
	Canvas canvas = null;
	Stage stage	=	null; 
	int canvaswidth = 960;
	int canvasheight = 400;
	
	boolean resetRuninng = false;
	Graphics graphics = null;
	
	Container container = null;
	
	Point prevPoint = null;
	Shape bar = null,currentClip = null;
	List<Shape> clips = new ArrayList<Shape>();
	List<Functions> functions = new ArrayList<SparkTable.Functions>();
	boolean update = false;
	
	double oldX = 0;
	
	double count = 0;
	
	double dd = 0;
	double selectedIndex = 0;
	int dataProviderlength = 30;
	
	@Override
	public void load(VerticalPanel panel) {
		createJSObject  = new CreateJSObject(""+canvaswidth, ""+canvasheight);
		stage	= createJSObject.getStage();
		canvas  = createJSObject.getCanvas();

		graphics = Graphics.createGraphics();
		final Ease ease = Ease.createEase();
		
		CallBack back = new CallBack() {
			
			@Override
			public void onSuccess() {
				if (bar.getX() != oldX && !resetRuninng) {
					Graphics g = currentClip.getGraphics();
					Point pt = Point.create(container.getX()+prevPoint.getX(), container.getY()+prevPoint.getY());

					g.moveTo(pt.getX(), pt.getY());

					count++;
					prevPoint.setX(bar.getX());
					prevPoint.setY((count*11));

					g.setStrokeStyle(1, "round", "round");
					double hue = (selectedIndex/dataProviderlength) * 360;

					g.beginStroke(Graphics.getHSL(hue,50,50));
					g.lineTo(container.getX()+prevPoint.getX(), container.getY()+prevPoint.getY());
					g.beginStroke(Graphics.getHSL(hue, 100, 50));
					g.beginFill(Graphics.getHSL(hue, 100, 50));
					g.drawCircle(pt.getX(), pt.getY(), 2);
					g.endFill();
					
					currentClip.setGraphics(g);

					stage.update();
				} else if (resetRuninng) {
					stage.update();
				}
				oldX = bar.getX();
				
			}
		};
		
		dotick(back);
		
		Ticker.addListener(getWindow());
		
		container= Container.createContainer();
		container.setX(20);
		container.setY(20);
		
		stage.addChild(container);
		
		prevPoint = Point.create(212, 0);
		bar = Shape.createShape();
		
		bar.setGraphics(createJSObject.Graphics().beginFill("#FFFFFF").setStrokeStyle(1).drawRect(2, 330, 4, 15).endFill().setStrokeStyle(1).beginFill("#FFFFFF").drawRect(3, 10, 2, 320));
		bar.setAlpha(0.7);
		container.addChild(bar);
		
		Shape bounds = Shape.createShape();
		bounds.setGraphics(createJSObject.Graphics().setStrokeStyle(1).beginStroke("#FFFFFF").moveTo(0, 0).lineTo(0, 350).lineTo(700, 350).lineTo(700, 0));
		bounds.setAlpha(0.7);
		container.addChild(bounds);
		
		functions.add(new Functions(Ease.backIn(),"backIn"));
		functions.add(new Functions(Ease.backInOut(),"backInOut"));
		functions.add(new Functions(Ease.backOut(),"backOut"));
		functions.add(new Functions(Ease.bounceIn(),"bounceIn"));
		functions.add(new Functions(Ease.bounceInOut(),"bounceInOut"));
		functions.add(new Functions(Ease.bounceOut(),"bounceOut"));
		functions.add(new Functions(Ease.circIn(),"circIn"));
		functions.add(new Functions(Ease.circInOut(),"circInOut"));
		functions.add(new Functions(Ease.circOut(),"circOut"));
		functions.add(new Functions(Ease.cubicIn(),"cubicIn"));
		functions.add(new Functions(Ease.cubicInOut(),"cubicInOut"));
		functions.add(new Functions(Ease.cubicOut(),"cubicOut"));
		functions.add(new Functions(Ease.elasticIn(),"elasticIn"));
		functions.add(new Functions(Ease.elasticInOut(),"elasticInOut"));
		functions.add(new Functions(Ease.elasticOut(),"elasticOut"));
		functions.add(new Functions(Ease.linear(),"linear"));
		functions.add(new Functions(Ease.none(),"none"));
		functions.add(new Functions(Ease.quadIn(),"quadIn"));
		functions.add(new Functions(Ease.quadInOut(),"quadInOut"));
		functions.add(new Functions(Ease.quadOut(),"quadOut"));
		functions.add(new Functions(Ease.quartIn(),"quartIn"));
		functions.add(new Functions(Ease.quartInOut(),"quartInOut"));
		functions.add(new Functions(Ease.quartOut(),"quartOut"));
		functions.add(new Functions(Ease.quintIn(),"quintIn"));
		functions.add(new Functions(Ease.quintInOut(),"quintInOut"));
		functions.add(new Functions(Ease.quintOut(),"quintOut"));
		functions.add(new Functions(Ease.sineIn(),"sineIn"));
		functions.add(new Functions(Ease.sineInOut(),"sineInOut"));
		functions.add(new Functions(Ease.sineOut(),"sineOut"));
		functions.add(new Functions(Ease.getBackIn(2.5),"getBackIn"));
		functions.add(new Functions(Ease.getBackInOut(2.5),"getBackInOut"));
		functions.add(new Functions(Ease.getBackOut(2.5),"getBackOut"));
		functions.add(new Functions(Ease.getElasticIn(2,5),"getElasticIn"));
		functions.add(new Functions(Ease.getElasticInOut(2,5),"getElasticInOut"));
		functions.add(new Functions(Ease.getElasticOut(2,5),"getElasticOut"));
		functions.add(new Functions(Ease.getPowIn(2.5),"getPowIn"));
		functions.add(new Functions(Ease.getPowInOut(20.5),"getPowInOut"));
		functions.add(new Functions(Ease.getPowOut(2.5),"getPowOut"));		
		
		HorizontalPanel hp = new HorizontalPanel();
		
		for(int i=0;i<functions.size();i++){
		
		Button backIn = new Button(functions.get(i).label);
		backIn.setStylePrimaryName(""+i);
		backIn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Button b = (Button)event.getSource();
				int a = Integer.parseInt(b.getStylePrimaryName());
				EaseFunction backin = functions.get(a).function;
				selectItem(backin);
			}
		});
		hp.add(backIn);
		}
		
		panel.add(createJSObject);
		panel.add(hp);
		
		stage.update();
		
		run(null);
		
		
	}
	
	
	public void run(EaseFunction easeType){
		currentClip = Shape.createShape();
		currentClip.setId(dd++);
		clips.add(currentClip);
		stage.addChild(currentClip);
		update = true;
		oldX = 0;
		prevPoint.setX(0);
		prevPoint.setY(0);

		Property prps = Property.createProperty();
		prps.addBooleanProperty("override",true);
		
		Property pp = Property.createProperty();
		pp.addDoubleProperty("x", 700);
		Tween.get(bar, prps).to(pp, 1500, easeType);
		
	}
	
	private boolean selectItem(final EaseFunction selectedFunction) {
		if (clips.size()> 0) {
			fade();
		}

		Property prps = Property.createProperty();
		prps.addBooleanProperty("override",true);
		
		Property pp = Property.createProperty();
		pp.addDoubleProperty("x", 0);
		pp.addDoubleProperty("y", 0);

		resetRuninng = true;
		CallBackTween resetComplete = new CallBackTween() {
			
			@Override
			public void onSuccess(Tween tween) {
				count = 0;
				bar.setX(0);
				resetRuninng = false;
				currentClip = null;
				
				run(selectedFunction);				
			}
		};
		Tween.get(bar, prps).to(pp, 500).call(resetComplete);
		return false;
	}	
	
	private void fade() {	
		for(int i=0;i<clips.size();i++) {
			Shape clip = clips.get(i);
			Property prps = Property.createProperty();
			prps.addBooleanProperty("override",true);

			Property pp = Property.createProperty();
			pp.addDoubleProperty("alpha", clip.getAlpha()-0.4);

			CallBackTween fadeTweenComplete = new CallBackTween() {
				
				@Override
				public void onSuccess(Tween tween) {
					Shape clip = (Shape)tween.getTarget();
					double id = clip.getId();
					if(clip.getAlpha() <=0){
						stage.removeChild(clip);
						int i =0;
						for(Shape shape :clips){
							if(shape.getId()==id){
								clips.remove(i);
								break;
							}
							i++;
						}
					}
				}
			};
			
			Tween.get(clip, prps).to(pp, 1000).call(fadeTweenComplete);
		}
	}
	
	
	private static native JavaScriptObject getWindow()/*-{
		return $wnd;
	}-*/;
	
	private static native void dotick(CallBack callBack) /*-{
		$wnd.tick=function(){
			callBack.@com.sinewavemultimedia.easeljs.framework.js.CallBack::onSuccess()();
	}}-*/; 	
	

}
