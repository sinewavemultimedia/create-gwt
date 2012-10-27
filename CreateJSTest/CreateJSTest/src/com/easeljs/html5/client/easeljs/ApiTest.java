package com.easeljs.html5.client.easeljs;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.Animation;
import com.sinewavemultimedia.easeljs.framework.js.CallBackEvent;
import com.sinewavemultimedia.easeljs.framework.js.CreateJSObject;
import com.sinewavemultimedia.easeljs.framework.js.Event;
import com.sinewavemultimedia.easeljs.framework.js.Image;
import com.sinewavemultimedia.easeljs.framework.js.SpriteFrame;
import com.sinewavemultimedia.easeljs.framework.js.SpriteSheetObject;
import com.sinewavemultimedia.easeljs.framework.js.display.Bitmap;
import com.sinewavemultimedia.easeljs.framework.js.display.BitmapAnimation;
import com.sinewavemultimedia.easeljs.framework.js.display.Graphics;
import com.sinewavemultimedia.easeljs.framework.js.display.Shape;
import com.sinewavemultimedia.easeljs.framework.js.display.SpriteSheet;
import com.sinewavemultimedia.easeljs.framework.js.display.Stage;
import com.sinewavemultimedia.easeljs.framework.js.display.Text;
import com.sinewavemultimedia.easeljs.framework.js.filters.BoxBlurFilter;
import com.sinewavemultimedia.easeljs.framework.js.filters.ColorFilter;
import com.sinewavemultimedia.easeljs.framework.js.filters.ColorMatrixFilter;
import com.sinewavemultimedia.easeljs.framework.js.filters.Filter;
import com.sinewavemultimedia.easeljs.framework.js.geom.Rectangle;
import com.sinewavemultimedia.easeljs.framework.js.utils.Ticker;

/*
* author: James Tyner 
*/
public class ApiTest implements IEasel {
	
	final private String STROKE_COLOR = "rgba(255,255,255,1)";
	final private String FILL_COLOR = "rgba(255,255,255,1)";
	Image img;

	@Override
	public void load(final VerticalPanel panel) {

		CallBackEvent callBack = new CallBackEvent() {
			
			@Override
			public void onSuccess(Event event) {

				//Sprite Sheet is pending..
				
				VerticalPanel verticalPanel = new VerticalPanel();
				verticalPanel.setSpacing(2);
				
				HorizontalPanel hplineto = new HorizontalPanel();
				hplineto.setSpacing(2);
				
				CreateJSObject lineto =new CreateJSObject("150","150");
				hplineto.add(new Label("Line To"));
				hplineto.add(lineto);
				
				CreateJSObject arcto =new CreateJSObject("150","150");
				hplineto.add(new Label("Arc To"));
				hplineto.add(arcto);
				
				CreateJSObject quadraticCurveTo =new CreateJSObject("150","150");
				hplineto.add(new Label("quadraticCurve To"));
				hplineto.add(quadraticCurveTo);

				CreateJSObject bezierCurve =new CreateJSObject("150","150");
				hplineto.add(new Label("quadraticCurve To"));
				hplineto.add(bezierCurve);


				HorizontalPanel hpline2 = new HorizontalPanel();
				hpline2.setSpacing(2);
				
				CreateJSObject benlinierGrad =new CreateJSObject("150","150");
				hpline2.add(new Label("Linear Gradient"));
				hpline2.add(benlinierGrad);

				CreateJSObject drawRect =new CreateJSObject("150","150");
				hpline2.add(new Label("DrawRect"));
				hpline2.add(drawRect);		

				CreateJSObject drawRoundRect =new CreateJSObject("150","150");
				hpline2.add(new Label("DrawRoundRect"));
				hpline2.add(drawRoundRect);		
				
				CreateJSObject roundRectWithGrad =new CreateJSObject("150","150");
				hpline2.add(new Label("GradientFill RoundRect"));
				hpline2.add(roundRectWithGrad);		
				
				HorizontalPanel hpline3 = new HorizontalPanel();
				hpline3.setSpacing(2);
				
				CreateJSObject drawCircle =new CreateJSObject("150","150");
				hpline3.add(new Label("Draw circle"));
				hpline3.add(drawCircle);		

				CreateJSObject drawGraidCircle =new CreateJSObject("150","150");
				hpline3.add(new Label("Draw Gradi circle"));
				hpline3.add(drawGraidCircle);		
				
				CreateJSObject drawEllipse =new CreateJSObject("150","150");
				hpline3.add(new Label("Draw Elipse"));
				hpline3.add(drawEllipse);
				
				CreateJSObject hexPolyStart =new CreateJSObject("150","150");
				hpline3.add(new Label("Hexagon PolyStar"));
				hpline3.add(hexPolyStart);
				
				HorizontalPanel hpline4 = new HorizontalPanel();
				hpline4.setSpacing(2);		

				CreateJSObject starPolyStar =new CreateJSObject("150","150");
				hpline4.add(new Label("Start PolyStar"));
				hpline4.add(starPolyStar);
				
				CreateJSObject bitmapstrk =new CreateJSObject("150","150");
				hpline4.add(new Label("BitMapStroke Rect"));
				hpline4.add(bitmapstrk);
				
				CreateJSObject roundRectcplx =new CreateJSObject("150","150");
				hpline4.add(new Label("Rounded Rect complex"));
				hpline4.add(roundRectcplx);	

				CreateJSObject circleBitMap =new CreateJSObject("150","150");
				hpline4.add(new Label("Circle With Bit Map fill"));
				hpline4.add(circleBitMap);	
			
				HorizontalPanel hpline5 = new HorizontalPanel();
				hpline5.setSpacing(2);	
				
				CreateJSObject textBitMp =new CreateJSObject("150","150");
				Stage stage =textBitMp.getStage();
				
				Text text = Text.create("Hello CreateJS!", "15px Arial", "#FFF");
				text.setY(45);
				stage.addChild(text);
				stage.update();				
				

				CreateJSObject bitmapAnimationDemo =new CreateJSObject("150","150");
				Stage stagebmADem =textBitMp.getStage();
				
				JsArrayMixed run= (JsArrayMixed)JavaScriptObject.createArray();
				run.push(0);
				run.push(25);
				JsArrayMixed jump= (JsArrayMixed)JavaScriptObject.createArray();
				jump.push(26);
				jump.push(63);				
				
				Animation animation = Animation.create();
				animation.run(run);
				animation.jump(jump);
				
				JsArrayString images=(JsArrayString)JavaScriptObject.createArray();
				images.push("../resources/images/runningGrant.png");
				SpriteFrame frame = SpriteFrame.create();
				frame.setRegX(0);
				frame.setRegY(0);
				frame.setFrameHeight(292.5);
				frame.setFrameWidth(165.75);
				frame.setNumFrames(64);
				
				SpriteSheetObject object = SpriteSheetObject.create();
				object.addImage(images);
				object.addAnimations(animation);
				object.addFrame(frame);
				
				SpriteSheet ss = SpriteSheet.create(object);
				ss.getAnimation("run").setFrequency(2);
				ss.getAnimation("run").setNext("jump");
				ss.getAnimation("jump").setNext("run");
				
				BitmapAnimation bitmapAnimation = BitmapAnimation.create(ss);
				stagebmADem.addChild(bitmapAnimation);
				bitmapAnimation.setScaleX(0.4);
				bitmapAnimation.setScaleY(0.4);
				bitmapAnimation.gotoAndPlay("run");
				Ticker.setFPS(60);
				Ticker.addListener(stagebmADem);
				
				CreateJSObject blurFilter =new CreateJSObject("150","150");
				Stage blurFilterStage= blurFilter.getStage();
				BoxBlurFilter boxBlurFilter = BoxBlurFilter.create(5, 2, 2);
				Rectangle margins= boxBlurFilter.getBounds();
				
				CreateJSObject colorFilter = new CreateJSObject("150", "150");
				Stage colorFilterStage = colorFilter.getStage();
				ColorFilter colFilter = ColorFilter.create(0, 1, 1, 1);

				CreateJSObject colorMatrixFilter = new CreateJSObject("150", "150");
				Stage colorMatrixFilterStage = colorMatrixFilter.getStage();
				ColorMatrixFilter colMatrixFilter = ColorMatrixFilter.create(new double[]{0.33,0.33,0.33,0,0,0.33,0.33,0.33,0,0,0.33,0.33,0.33,0,0,0,0,0,1,0});

				CreateJSObject MaskFilter = new CreateJSObject("150", "150");
				Stage maskStage = MaskFilter.getStage();
				Shape maskShape = Shape.createShape(MaskFilter.Graphics().beginStroke(STROKE_COLOR).beginBitmapFill(img).drawCircle(35,25,20).endStroke());
				
				hpline5.add(textBitMp);
				hpline5.add(blurFilter);
				hpline5.add(colorFilter);
				hpline5.add(colorMatrixFilter);
				hpline5.add(MaskFilter);
				
				verticalPanel.add(hplineto);
				verticalPanel.add(hpline2);
				verticalPanel.add(hpline3);
				verticalPanel.add(hpline4);
				verticalPanel.add(hpline5);
				panel.add(verticalPanel);


				
				Graphics linetoGraphics = lineto.Graphics().beginStroke(STROKE_COLOR).moveTo(5, 35).lineTo(110, 75).endStroke();
				Graphics arcToGraphics = arcto.Graphics().beginStroke(STROKE_COLOR).moveTo(50,20).arcTo(150,20,150,70,50).endStroke();
				Graphics quadraticCurveToGrpahics= quadraticCurveTo.Graphics().beginStroke(STROKE_COLOR).moveTo(0, 25).quadraticCurveTo(45,50,35,25).endStroke();
				Graphics bezierCurveToGrpahics = bezierCurve.Graphics().beginStroke(STROKE_COLOR).moveTo(5, 75).bezierCurveTo(45,90,75,75,-25,-25).endStroke();
				JsArrayString array1 =(JsArrayString)JsArrayString.createArray();
				array1.push(STROKE_COLOR);
				array1.push("rgba(50, 50, 50, 1)");		
				JsArrayNumber arrayNumber1 = (JsArrayNumber)JsArrayNumber.createArray();
				arrayNumber1.push(0);
				arrayNumber1.push(0.4);				
				Graphics gradientTo = benlinierGrad.Graphics().beginLinearGradientStroke(array1,arrayNumber1,0,0,70,140).moveTo(5, 25).lineTo(110,25).endStroke(); 
				Graphics drawRectTo  = drawRect.Graphics().beginFill(FILL_COLOR).rect(5,5,80,80);
				Graphics drawRoundRectTo  = drawRoundRect.Graphics().beginFill(FILL_COLOR).drawRoundRect(0,0, 120, 120, 5);
				JsArrayString array =(JsArrayString)JsArrayString.createArray();
				array.push(FILL_COLOR);
				array.push("rgba(0,0,0,1)");
				JsArrayNumber arrayNumber = (JsArrayNumber)JsArrayNumber.createArray();
				arrayNumber.push(0);
				arrayNumber.push(1);				
				Graphics roundRectWithGradTo = roundRectWithGrad.Graphics().beginLinearGradientFill(array,arrayNumber,0,0,0,130).drawRoundRect(0,0, 120, 120, 5);
				Graphics drawCircleTo =drawCircle.Graphics().beginFill(FILL_COLOR).drawCircle(40,40,40);
				Graphics drawGraidCircleTo =drawGraidCircle.Graphics().beginRadialGradientFill(array,arrayNumber,0,0,0,0,0,60).drawCircle(40,40,40);
				Graphics drawEllipseTo = drawEllipse.Graphics().beginFill(FILL_COLOR).drawEllipse(5,5,60,120);
				Graphics hexPolyStartTo = hexPolyStart.Graphics().beginFill(FILL_COLOR).drawPolyStar(60,60,60,6,0,45);
				Graphics starPolyStarTo = starPolyStar.Graphics().beginFill(FILL_COLOR).drawPolyStar(80,80,70,5,0.6,-90);
				Graphics bitmapstrkTo = bitmapstrk.Graphics().setStrokeStyle(25).beginBitmapStroke(img).rect(5,5,100,100);;
				Graphics roundRectcplxTo= roundRectcplx.Graphics().beginFill(FILL_COLOR).drawRoundRectComplex(5,5,70,70,5,10,15,25);
				Graphics circleBitMapTo= circleBitMap.Graphics().beginStroke(STROKE_COLOR).beginBitmapFill(img).drawCircle(30,30,30).endStroke();

				CreateGraphics(lineto,linetoGraphics);
				CreateGraphics(arcto,arcToGraphics);
				CreateGraphics(quadraticCurveTo,quadraticCurveToGrpahics);
				CreateGraphics(bezierCurve,bezierCurveToGrpahics);
	//			CreateGraphics(benlinierGrad,gradientTo);
				CreateGraphics(drawRect,drawRectTo);
				CreateGraphics(drawRoundRect,drawRoundRectTo);
				CreateGraphics(roundRectWithGrad,roundRectWithGradTo);
				CreateGraphics(drawCircle,drawCircleTo);
				CreateGraphics(drawGraidCircle,drawGraidCircleTo);
				CreateGraphics(drawEllipse,drawEllipseTo);
				CreateGraphics(hexPolyStart,hexPolyStartTo);
				CreateGraphics(starPolyStar,starPolyStarTo);
				CreateGraphics(bitmapstrk,bitmapstrkTo);
				CreateGraphics(roundRectcplx,roundRectcplxTo);
				CreateGraphics(circleBitMap,circleBitMapTo);
				
				Bitmap image = Bitmap.create(img);
				image.setFilters(new Filter[]{boxBlurFilter});
				int x = margins.getX();
				int y = margins.getY();
				int mw= margins.getWidth();
				int mh= margins.getHeight();
				int iw= img.getWidth();
				int ih= img.getHeight();
				image.cache(x, y, iw+mw, ih+mh);
				image.setX(image.getX()+image.getX());
				
				blurFilterStage.addChild(image);
				blurFilterStage.update();
				
				Bitmap colorFilterMap = Bitmap.create(img);
				colorFilterMap.setFilters(new Filter[]{colFilter});
				colorFilterMap.cache(0, 0, img.getWidth(), img.getHeight());
				colorFilterStage.addChild(colorFilterMap);
				colorFilterStage.update();
				
				Bitmap colorMatrixFilterMap = Bitmap.create(img);
				colorMatrixFilterMap.setFilters(new Filter[]{colMatrixFilter});
				colorMatrixFilterMap.cache(0, 0, img.getWidth(), img.getHeight());
				colorMatrixFilterStage.addChild(colorFilterMap);
				colorMatrixFilterStage.update();
				
				Bitmap maxImage  = Bitmap.create(img);
				maxImage.setMask(maskShape);
				maskStage.addChild(maxImage);
				maskStage.update();
				
			}
		};
		
		img = Image.create();
		img.setSrc("../resources/images/daisy.png");
		img.onLoad(callBack);

		
		/*//Need to implement Sprite Sheet
		CreateJSObject animiation =new CreateJSObject("300","300");
		Stage animationStage= animiation.getStage();
		SpriteSheetBuilder builder = SpriteSheetBuilder.create();
		//builder.addAnimation(name, frames, next, frequency)*/

		
	}
	
	private void CreateGraphics(CreateJSObject div,Graphics graphics){
		Stage stage = div.getStage();
		Shape shape = div.Shape(graphics);
		stage.addChild(shape);
		stage.update();
	}
	
}
