package it.shaojiexu.www.service;

import it.shaojiexu.www.model.Cube;
import it.shaojiexu.www.model.CubePiece;

import org.springframework.stereotype.Service;




@Service
public class CubeFactory {
	
	public Cube getCubeByColor(String color){
		
		switch(color.toUpperCase()) {
			case "BLUE" : return new Cube(CubePiece.blueCubePieces);
			case "RED" : return new Cube(CubePiece.redCubePieces);
			case "PURPLE" : return new Cube(CubePiece.purpleCubePieces);
			case "YELLOW" : return new Cube(CubePiece.yellowCubePieces);
			default: return null;
		}
		
	}
	



}
