package br.com.manish.reactFace.example;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import br.com.manish.reactFace.core.ReactFaceObject;


public class MyEllipse extends Ellipse implements ReactFaceObject{
	
	public MyEllipse (Color color) {
        super(90, 45);
        LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop[] {
            new Stop(0, color),
            new Stop(1, Color.BLACK)
        });
        setStroke(color);
        setFill(gradient);
        setVisible(false);
	}
	public MyEllipse() {
		this(Color.DODGERBLUE);
	}

	@Override
	public void move(Double x, Double y) {
		setTranslateX(x);
		setTranslateY(y);		
	}

	@Override
	public void show(Double x, Double y, Double angle) {
		setVisible(true);
	}

	@Override
	public void hide() {
		setVisible(false);
	}
	
	@Override
	public void rotate(Double angle) {
		setRotate(angle);
	}
	@Override
	public void setDependency(ReactFaceObject obj) {
	}
	@Override
	public void stopMusic() {
	}
	@Override
	public void startMusic() {
	}
	
}



