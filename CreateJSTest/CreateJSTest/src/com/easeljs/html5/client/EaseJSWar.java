package com.easeljs.html5.client;

//import com.easeljs.framework.js.Canvas;
import com.easeljs.html5.client.easeljs.ApiTest;
import com.easeljs.html5.client.easeljs.BarGraph;
import com.easeljs.html5.client.easeljs.BitmapAnimation;
import com.easeljs.html5.client.easeljs.Cache;
import com.easeljs.html5.client.easeljs.CacheUpdate;
import com.easeljs.html5.client.easeljs.CacheVDay;
import com.easeljs.html5.client.easeljs.CurveTo;
import com.easeljs.html5.client.easeljs.DoubleClick;
import com.easeljs.html5.client.easeljs.DragAndDrop;
import com.easeljs.html5.client.easeljs.DragAndDropHitArea;
import com.easeljs.html5.client.easeljs.ExtractFrame;
import com.easeljs.html5.client.easeljs.FilterInput;
import com.easeljs.html5.client.easeljs.Filters;
import com.easeljs.html5.client.easeljs.GlobalToLocalA;
import com.easeljs.html5.client.easeljs.GlobalToLocalB;
import com.easeljs.html5.client.easeljs.GraphicTest;
import com.easeljs.html5.client.easeljs.GraphicsReuse;
import com.easeljs.html5.client.easeljs.GraphicsSimple;
import com.easeljs.html5.client.easeljs.HelloWorld;
import com.easeljs.html5.client.easeljs.HtmlElemnts;
import com.easeljs.html5.client.easeljs.ICons;
import com.easeljs.html5.client.easeljs.IEasel;
import com.easeljs.html5.client.easeljs.LocalToGlobal;
import com.easeljs.html5.client.easeljs.Masks;
import com.easeljs.html5.client.easeljs.Segments;
import com.easeljs.html5.client.easeljs.Sparkles;
import com.easeljs.html5.client.easeljs.SparklesFade;
import com.easeljs.html5.client.easeljs.SpriteSheetBuiler;
import com.easeljs.html5.client.easeljs.SpriteSheetDemo;
import com.easeljs.html5.client.easeljs.SpriteSheetFlip;
import com.easeljs.html5.client.easeljs.SpriteSheetSimple;
import com.easeljs.html5.client.easeljs.TextLinks;
import com.easeljs.html5.client.easeljs.TextMultiLine;
import com.easeljs.html5.client.easeljs.TextSimple;
import com.easeljs.html5.client.easeljs.Transform;
import com.easeljs.html5.client.easeljs.TransformSimple;
import com.easeljs.html5.client.preloadjs.PreloadImages;
import com.easeljs.html5.client.soundjs.Game;
import com.easeljs.html5.client.soundjs.MediaPlayer;
import com.easeljs.html5.client.soundjs.PreloadAndPlay;
import com.easeljs.html5.client.soundjs.SoundGrid;
import com.easeljs.html5.client.soundjs.TestSuite;
import com.easeljs.html5.client.tweenjs.Example;
import com.easeljs.html5.client.tweenjs.SimpleTweenDemo;
import com.easeljs.html5.client.tweenjs.SparkTable;
import com.easeljs.html5.client.tweenjs.TweenCircle;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sinewavemultimedia.easeljs.framework.js.Image;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 * author: James Tyner
 * selected Example for the Easel JS framework
 */
public class EaseJSWar implements EntryPoint {

	
	final private String STROKE_COLOR = "rgba(255,255,255,1)";
	final private String FILL_COLOR = "rgba(255,255,255,1)";
	Image img;
	
	public void onModuleLoad() {

		
		RootPanel.get().clear();
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(2);
		
		HorizontalPanel horizontalPanel1 = new HorizontalPanel();
		horizontalPanel1.setSpacing(2);		
		
		HorizontalPanel horizontalPanel2 = new HorizontalPanel();
		horizontalPanel2.setSpacing(2);				
		
		HorizontalPanel horizontalPanel3 = new HorizontalPanel();
		horizontalPanel3.setSpacing(2);				

		HorizontalPanel horizontalPanel4 = new HorizontalPanel();
		horizontalPanel4.setSpacing(2);				

		final VerticalPanel testPanel = new VerticalPanel();
		
		final Button apiTest = new Button("Api Test");
		apiTest.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new ApiTest();
				object.load(testPanel);
				
			}
		});
		
		final Button barGrpah = new Button("Bar Graph");
		barGrpah.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new BarGraph();
				object.load(testPanel);
				
			}
		});	
		
		final Button cache = new Button("Cache");
		cache.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new Cache();
				object.load(testPanel);
				
			}
		});			
		
		final Button updateCache = new Button(" Update Cache");
		updateCache.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new CacheUpdate();
				object.load(testPanel);
				
			}
		});			
		
		final Button vdayCache = new Button(" vDay Cache");
		vdayCache.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new CacheVDay();
				object.load(testPanel);
				
			}
		});				
				
		final Button curveTo = new Button(" Curve to");
		curveTo.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new CurveTo();
				object.load(testPanel);
				
			}
		});
		
		final Button doubleClick = new Button(" Double Click");
		doubleClick.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new DoubleClick();
				object.load(testPanel);
				
			}
		});		
		
		final Button dragandDrop = new Button(" Drag and Drop ");
		dragandDrop.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new DragAndDrop();
				object.load(testPanel);
				
			}
		});	
		
		final Button dragandDropHitArea = new Button(" Drag and Drop Hit Area");
		dragandDropHitArea.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new DragAndDropHitArea();
				object.load(testPanel);
				
			}
		});
		
		final Button extractFrame = new Button(" Extract Frame ");
		extractFrame.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new ExtractFrame();
				object.load(testPanel);
				
			}
		});	
		
		final Button filters = new Button(" Filters ");
		filters.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new Filters();
				object.load(testPanel);
				
			}
		});	
		
		
		final Button filtersInput = new Button(" Filter Input ");
		filtersInput.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new FilterInput();
				object.load(testPanel);
				
			}
		});	
		
		final Button globaltolocal1 = new Button(" Global to local 1 ");
		globaltolocal1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new GlobalToLocalA();
				object.load(testPanel);
				
			}
		});			
		
		final Button globaltolocal2 = new Button(" Global to local 2 ");
		globaltolocal2.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new GlobalToLocalB();
				object.load(testPanel);
				
			}
		});	
		
		final Button simpleGrpahics = new Button(" Graphics Simple ");
		simpleGrpahics.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new GraphicsSimple();
				object.load(testPanel);
				
			}
		});	
		
		final Button GraphicsReuse = new Button(" Graphics Reuse ");
		GraphicsReuse.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new GraphicsReuse();
				object.load(testPanel);
				
			}
		});	
		
		final Button GraphicsTest = new Button(" Graphics Test ");
		GraphicsTest.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new GraphicTest();
				object.load(testPanel);
				
			}
		});			
		
		final Button helloworld = new Button(" Hello World ");
		helloworld.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new HelloWorld();
				object.load(testPanel);
				
			}
		});		
		

		final Button htmlElements = new Button(" HTML Elements ");
		htmlElements.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new HtmlElemnts();
				object.load(testPanel);
				
			}
		});	
		

		final Button icons = new Button(" ICONS ");
		icons.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new ICons();
				object.load(testPanel);
				
			}
		});	


		final Button localToGlobal = new Button(" Local to Global ");
		localToGlobal.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new LocalToGlobal();
				object.load(testPanel);
				
			}
		});	

		final Button masks= new Button(" Masks ");
		masks.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new Masks();
				object.load(testPanel);
				
			}
		});			

		final Button Segments= new Button(" Segments ");
		Segments.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new Segments();
				object.load(testPanel);
				
			}
		});			
		
		final Button sparkles= new Button(" Sparkles ");
		sparkles.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new Sparkles();
				object.load(testPanel);
				
			}
		});	

		final Button sparkleFade= new Button(" Sparkle Fade ");
		sparkleFade.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new SparklesFade();
				object.load(testPanel);
				
			}
		});	
		

		final Button SpriteSheetsimple= new Button(" Sprite Sheet Simple ");
		SpriteSheetsimple.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new SpriteSheetSimple();
				object.load(testPanel);
				
			}
		});	
		
		final Button spriteSheetbuilder= new Button(" Sprite Sheet Builder ");
		spriteSheetbuilder.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new SpriteSheetBuiler();
				object.load(testPanel);
				
			}
		});			
		
		final Button spriteSheetFlip= new Button(" Sprite Sheet Flip ");
		spriteSheetFlip.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new SpriteSheetFlip();
				object.load(testPanel);
				
			}
		});					
		
		final Button textlinks= new Button(" Text Links ");
		textlinks.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new TextLinks();
				object.load(testPanel);
				
			}
		});					
		
		final Button textMultiLine= new Button(" Text Multi Line ");
		textMultiLine.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new TextMultiLine();
				object.load(testPanel);
				
			}
		});				
		

		final Button txtSimple= new Button(" Text Simple Line ");
		txtSimple.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new TextSimple();
				object.load(testPanel);
				
			}
		});		

		final Button transformSimple= new Button(" Transform Simple ");
		transformSimple.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new TransformSimple();
				object.load(testPanel);
				
			}
		});	
		
		final Button bitmapAnimation= new Button(" BitMap Animation ");
		bitmapAnimation.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new BitmapAnimation();
				object.load(testPanel);
				
			}
		});	


		final Button game = new Button("Game");
		game.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new Game();
				object.load(testPanel);
				
			}
		});
		
		final Button spriteSheetDemo = new Button("Sprite Sheet");
		spriteSheetDemo.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel ssdemo = new SpriteSheetDemo();
				ssdemo.load(testPanel);
			}
		});
		
		final Button transform = new Button("Transform");
		transform.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel ssdemo = new Transform();
				ssdemo.load(testPanel);
			}
		});		
		
		
		final Button soundGrid= new Button(" Sound Grid ");
		soundGrid.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new SoundGrid();
				object.load(testPanel);
				
			}
		});	

		final Button mediaPlayer= new Button(" Media Player ");
		mediaPlayer.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new MediaPlayer();
				object.load(testPanel);
				
			}
		});
		
		final Button preloadandPlay= new Button(" Preload and Play");
		preloadandPlay.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new PreloadAndPlay();
				object.load(testPanel);
				
			}
		});
		
		final Button testSuite= new Button(" Test Suite");
		testSuite.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new TestSuite();
				object.load(testPanel);
				
			}
		});	
		
		final Button sparkTable= new Button(" Spark Table");
		sparkTable.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new SparkTable();
				object.load(testPanel);
				
			}
		});			
		
		final Button tweencircle= new Button(" Tween Circle");
		tweencircle.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new TweenCircle();
				object.load(testPanel);
				
			}
		});

		final Button example= new Button(" Example");
		example.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new Example();
				object.load(testPanel);
				
			}
		});
		
		
		final Button simpleTweenDemo= new Button(" Simple Tween Demo");
		simpleTweenDemo.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new SimpleTweenDemo();
				object.load(testPanel);
				
			}
		});		
		
		final Button preloadImage= new Button(" Pre load Image");
		preloadImage.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				testPanel.clear();
				IEasel object = new PreloadImages();
				object.load(testPanel);
				
			}
		});		

		
		horizontalPanel.add(apiTest);
		horizontalPanel.add(barGrpah);
		horizontalPanel.add(cache);
		horizontalPanel.add(updateCache);
		horizontalPanel.add(vdayCache);
		horizontalPanel.add(curveTo);
		horizontalPanel.add(doubleClick);
		horizontalPanel.add(dragandDrop);
		horizontalPanel.add(dragandDropHitArea);		
		horizontalPanel.add(extractFrame);
		horizontalPanel.add(filters);
		horizontalPanel.add(filtersInput);
		horizontalPanel.add(globaltolocal1);
		horizontalPanel1.add(globaltolocal2);
		horizontalPanel1.add(simpleGrpahics);
		horizontalPanel1.add(GraphicsReuse);
		horizontalPanel1.add(GraphicsTest);
		horizontalPanel1.add(helloworld);
		horizontalPanel1.add(htmlElements);
		horizontalPanel1.add(icons);
		horizontalPanel1.add(localToGlobal);
		horizontalPanel1.add(masks);
		horizontalPanel1.add(Segments);
		horizontalPanel1.add(sparkles);
		horizontalPanel1.add(sparkleFade);
		horizontalPanel1.add(SpriteSheetsimple);
		horizontalPanel2.add(spriteSheetbuilder);
		horizontalPanel2.add(spriteSheetFlip);
		horizontalPanel2.add(textlinks);
		horizontalPanel2.add(textMultiLine);
		horizontalPanel2.add(txtSimple);
		horizontalPanel2.add(transformSimple);
		horizontalPanel2.add(bitmapAnimation);
		horizontalPanel2.add(game);
		horizontalPanel2.add(spriteSheetDemo);
		horizontalPanel2.add(transform);
		
		horizontalPanel3.add(soundGrid);
		horizontalPanel3.add(mediaPlayer);
		horizontalPanel3.add(preloadandPlay);
		horizontalPanel3.add(testSuite);
		horizontalPanel3.add(preloadImage);
		
		horizontalPanel4.add(sparkTable);
		horizontalPanel4.add(tweencircle);
		horizontalPanel4.add(simpleTweenDemo);
		horizontalPanel4.add(example);
		
		VerticalPanel panel = new VerticalPanel();
		panel.add(horizontalPanel);
		panel.add(horizontalPanel1);
		panel.add(horizontalPanel2);
		panel.add(horizontalPanel3);
		panel.add(horizontalPanel4);
		
		panel.add(testPanel);
		
		RootPanel.get().add(panel);

		
	}
	

}
