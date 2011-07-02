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
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import TUIO.TuioClient;
import br.com.manish.reactFace.core.ReactFaceObject;
import br.com.manish.reactFace.core.ReactFaceTuioListener;

public class CircleTest extends Application {
    private static final Double width = 800.0;
    private static final Double height = 600.0;
	private TuioClient tuio;

	public CircleTest() {
		super();
	}
    
	public static void main(String[] args) {
		Application.launch(CircleTest.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		//Initial JavaFX configs
		stage.setTitle("ReactFace Example - Circles");
        stage.setResizable(false);
        Group root = new Group();
        Scene scene = new Scene(root, width, height);
        stage.setScene(scene);
        stage.setVisible(true);
        
        //A map to hold the fiducials id's and javafx equivalent objects
        Map<Integer, ReactFaceObject> mapa = new HashMap<Integer, ReactFaceObject>();

        //Creating our object
        MyCircle bola = new MyCircle();
        
        //Adding on group root
        root.getChildren().add(bola);
        
        //Putting on fiducials map
        mapa.put(40, bola);
        
        //Creating a new TuioClient
        tuio = new TuioClient();
        
        //Adding our Listener implementation
        tuio.addTuioListener(new ReactFaceTuioListener(mapa, width, height));
        
        //This tells TuioClient to listen udp port for any inputs
        tuio.connect();
        
	}

}