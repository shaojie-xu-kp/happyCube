package it.shaojiexu.www.model;

import org.springframework.stereotype.Service;




@Service
public class CubeFactory {
	
	public Cube getCubeByColor(String color){
		
		
		switch(color.toUpperCase()) {
			case "BLUE" : return getBlueCube();
			case "RED" : return getRedCube();
			default: return null;
		}
		
	}
	
	private Cube getRedCube() {
		
		int[][] piece1 = {
				{0,0,0,1,1},
				{0,1,1,1,0},
				{1,1,1,1,1},
				{0,1,1,1,0},
				{0,1,0,1,1}
		};
		int[][] piece2 = {
				{0,1,0,1,0},
				{1,1,1,1,0},
				{0,1,1,1,1},
				{1,1,1,1,0},
				{0,1,0,0,0}
		};
		int[][] piece3 = {
				{0,1,1,0,1},
				{1,1,1,1,1},
				{0,1,1,1,0},
				{1,1,1,1,1},
				{1,0,0,1,1}
		};
		int[][] piece4 = {
				{0,0,1,0,0},
				{1,1,1,1,0},
				{0,1,1,1,1},
				{1,1,1,1,0},
				{0,0,1,0,0}
		};
		int[][] piece5 = {
				{0,0,1,1,0},
				{1,1,1,1,1},
				{0,1,1,1,0},
				{1,1,1,1,1},
				{1,0,1,0,0}
		};
		int[][] piece6 = {
				{0,1,1,0,0},
				{0,1,1,1,0},
				{1,1,1,1,1},
				{0,1,1,1,0},
				{1,1,0,1,1}
		};
		
		Cube cubeBlue = new Cube(piece1,piece2,piece3,piece4,piece5,piece6);
		return cubeBlue;
	}
	
	private Cube getBlueCube() {
		
		int[][] piece1 = {
				{0,0,1,0,0},
				{0,1,1,1,0},
				{1,1,1,1,1},
				{0,1,1,1,0},
				{0,0,1,0,0}
		};
		int[][] piece2 = {
				{1,0,1,0,1},
				{1,1,1,1,1},
				{0,1,1,1,0},
				{1,1,1,1,1},
				{1,0,1,0,1}
		};
		int[][] piece3 = {
				{0,0,1,0,0},
				{0,1,1,1,1},
				{1,1,1,1,0},
				{0,1,1,1,1},
				{0,0,1,0,0}
		};
		int[][] piece4 = {
				{0,1,0,1,0},
				{1,1,1,1,0},
				{0,1,1,1,1},
				{1,1,1,1,0},
				{1,1,0,1,0}
		};
		int[][] piece5 = {
				{0,1,0,1,0},
				{1,1,1,1,1},
				{0,1,1,1,0},
				{1,1,1,1,1},
				{1,0,1,0,0}
		};
		int[][] piece6 = {
				{0,1,0,1,0},
				{0,1,1,1,1},
				{1,1,1,1,0},
				{0,1,1,1,1},
				{1,1,0,1,1}
		};
		
		Cube cubeBlue = new Cube(piece1,piece2,piece3,piece4,piece5,piece6);
		return cubeBlue;
	}



}
