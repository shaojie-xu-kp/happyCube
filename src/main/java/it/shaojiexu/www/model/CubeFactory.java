package it.shaojiexu.www.model;

import org.springframework.stereotype.Service;




@Service
public class CubeFactory {
	
	public Cube getCubeByColor(String color){
		
		switch(color.toUpperCase()) {
			case "BLUE" : return new Cube(CubePiece.blueCublePieces);
			case "RED" : return new Cube(CubePiece.redCublePieces);
			default: return null;
		}
		
	}
	



}
