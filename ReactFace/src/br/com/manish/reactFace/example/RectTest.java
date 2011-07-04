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
import javafx.application.Application;
import javafx.scene.paint.Color;
import br.com.manish.reactFace.core.ReactFaceApplication;

public class RectTest extends ReactFaceApplication {

	@Override
	public void start() {
		
		//Initial JavaFX configs
		setTitle("ReactFace Example - Rectangles");
        setWidth(800.0);
        setHeight(600.0);
        
        MyRect blue = new MyRect(); //Creating a first object
        addObject(39, blue); //Adding on group root and putting on fiducials map

        MyRect red = new MyRect(Color.RED); //Creating a second object
        addObject(40, red); //Adding on group root and putting on fiducials map
        
	}
	
	public static void main(String[] args) {
		Application.launch(RectTest.class, args);
	}
}