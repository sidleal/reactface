package br.com.manish.reactFace.example;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import br.com.manish.reactFace.core.ReactFaceApplication;

public class EllipseTest extends ReactFaceApplication {
	
	private ScaleTransition scaleTransition;
	private FadeTransition fadeTransition;
	
	@Override
	public void start() {
		
		//Initial JavaFX configs
		setTitle("ReactFace Example - Ellipses");
        setWidth(800.0);
        setHeight(600.0);
        
        MyEllipse blue = new MyEllipse(); //Creating a first object
        addObject(38, blue); //Adding on group root and putting on fiducials map

        MyEllipse red = new MyEllipse(Color.RED); //Creating a second object
        addObject(41, red); //Adding on group root and putting on fiducials map
        
        scaleTransition = new ScaleTransition(Duration.valueOf("4s"), blue);
        scaleTransition.setToX(3.0f);
        scaleTransition.setToY(3.0f);
        scaleTransition.setCycleCount(Timeline.INDEFINITE);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();
        
        fadeTransition = new FadeTransition(Duration.valueOf("500ms"), red);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.2f);
        fadeTransition.setCycleCount(Timeline.INDEFINITE);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();
        
	}
	
	public static void main(String[] args) {
		Application.launch(EllipseTest.class, args);
	}
}
