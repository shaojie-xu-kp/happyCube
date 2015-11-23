package it.shaojiexu.www.model;

import org.springframework.stereotype.Service;




@Service
public class CubeFactory {
	
	
	public Cube getCube(String color) {
		
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
