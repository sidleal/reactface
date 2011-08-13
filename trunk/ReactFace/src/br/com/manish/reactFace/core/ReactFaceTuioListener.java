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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import TUIO.TuioCursor;
import TUIO.TuioObject;
import TUIO.TuioTime;

public class ReactFaceTuioListener implements TUIO.TuioListener {

	private Map<Integer, ReactFaceObject> objectMap;
	private Set<Integer> activeFiducialsMap = new HashSet<Integer>();
	
	private Double sceneWidth;
	private Double sceneHeight;
	 
	public ReactFaceTuioListener(Map<Integer, ReactFaceObject> objectMap, Double sceneWidth, Double sceneHeight) {
		this.objectMap = objectMap;
		this.sceneWidth = sceneWidth;
		this.sceneHeight = sceneHeight;
	}
	
	private ReactFaceObject getObject(Integer id) {
		ReactFaceObject ret = objectMap.get(id);
		
		if (ret == null) {
			NumberFormat nf = new DecimalFormat("000");
			for (Integer activeId : activeFiducialsMap) {
				Integer idDep = new Integer(String.valueOf(id) + nf.format(activeId));
				if (objectMap.containsKey(idDep)) {
					ret = objectMap.get(idDep);
					break;
				}
			}
		}
		return ret;
	}
	
	@Override
	public void addTuioObject(TuioObject to) {
		ReactFaceObject obj = getObject(to.getSymbolID());
		if (obj != null) {
			obj.show(convertPointX(to.getX()), convertPointY(to.getY()), convertAngle(to.getAngle()));
			activeFiducialsMap.add(to.getSymbolID());
		}
	}

	@Override
	public void removeTuioObject(TuioObject to) {
		ReactFaceObject obj = getObject(to.getSymbolID());
		if (obj != null) {
			obj.hide();
			activeFiducialsMap.remove(to.getSymbolID());
		}
	}

	@Override
	public void updateTuioObject(TuioObject to) {
		ReactFaceObject obj = getObject(to.getSymbolID());
		if (obj != null) {
			obj.move(convertPointX(to.getX()), convertPointY(to.getY()));
			obj.rotate(convertAngle(to.getAngle()));
		}
	}
	
	private Double convertPointX(Float x) {
		return sceneWidth * x;
	}

	private Double convertPointY(Float y) {
		return sceneHeight * y;
	}

	private Double convertAngle(Float angle) {
		return 360 - (60.0 * angle);
	}

	@Override
	public void updateTuioCursor(TuioCursor arg0) {
	}
	
	@Override
	public void removeTuioCursor(TuioCursor arg0) {
	}
	
	@Override
	public void refresh(TuioTime arg0) {
	}
	
	@Override
	public void addTuioCursor(TuioCursor arg0) {
	}
}
