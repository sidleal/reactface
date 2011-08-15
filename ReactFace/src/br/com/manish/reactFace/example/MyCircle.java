//  ReactFace - A Simple reacTIVision JavaFX API
//  Copyright (C) 2011 Manish TI (www.manish.com.br)
//
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
//  (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
//
//  You should have received a copy of the GNU General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.

package br.com.manish.reactFace.example;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import br.com.manish.reactFace.core.ReactFaceObject;

public class MyCircle extends Circle implements ReactFaceObject {
	private static final Double radius = 60.0;
	
	public MyCircle (Color color) {
        super(80,80,radius);
        RadialGradient gradient = new RadialGradient(0, 0, 0.4, 0.4, 1, true, CycleMethod.NO_CYCLE, new Stop[] {
            new Stop(0, color),
            new Stop(1, Color.BLACK)
        });
        setStroke(color);
        setFill(gradient);
        setVisible(false);
	}
	public MyCircle() {
		this(Color.DODGERBLUE);
	}

	@Override
	public void move(Double x, Double y) {
		setTranslateX(x - (radius/2));
		setTranslateY(y - (radius/2));		
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
