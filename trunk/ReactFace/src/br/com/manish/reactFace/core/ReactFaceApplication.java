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

package br.com.manish.reactFace.core;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import TUIO.TuioClient;

public abstract class ReactFaceApplication extends Application {
    private Double width = 800.0;
    private Double height = 600.0;
    private Color backgroundColor = Color.WHITE;
	private TuioClient tuio;
	private Stage stage;
	private Group root = new Group();
	private Scene scene;

	/**A map to hold the fiducials id's and javafx equivalent objects.*/
	private Map<Integer, ReactFaceObject> objectMap = new HashMap<Integer, ReactFaceObject>();
	
	public ReactFaceApplication() {
		super();
	}
    
	protected abstract void start();
	
	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
        
		start();

        stage.setResizable(false);

		scene = new Scene(root, width, height);
		scene.setFill(backgroundColor);
        stage.setScene(scene);
        stage.setVisible(true);
        
        //Creating a new TuioClient
        tuio = new TuioClient();
        
        //Adding our Listener implementation
        tuio.addTuioListener(new ReactFaceTuioListener(objectMap, width, height));
        
        //This tells TuioClient to listen udp port for any inputs
        tuio.connect();
        
	}

	protected void addObject(Integer id, Node obj) {
		getChildren().add(obj);
		putObjectOnMap(id, (ReactFaceObject) obj);
	}
	
	public void setTitle(String title) {
		stage.setTitle(title);
	}
	
	public ObservableList<Node> getChildren() {
		return root.getChildren();
	}
	
	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public TuioClient getTuio() {
		return tuio;
	}

	public void setTuio(TuioClient tuio) {
		this.tuio = tuio;
	}

	public Group getRoot() {
		return root;
	}

	public void setRoot(Group root) {
		this.root = root;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Map<Integer, ReactFaceObject> getObjectMap() {
		return objectMap;
	}

	public void setObjectMap(Map<Integer, ReactFaceObject> objectMap) {
		this.objectMap = objectMap;
	}
	
	public void putObjectOnMap(Integer id, ReactFaceObject obj) {
		objectMap.put(id, obj);
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	@Override
	public void stop() throws Exception {
		System.out.println("stopped");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroyed");
	}
	
	

}