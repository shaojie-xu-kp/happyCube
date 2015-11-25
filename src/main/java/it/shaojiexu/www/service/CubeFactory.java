package it.shaojiexu.www.service;

import it.shaojiexu.www.model.Cube;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;



@Service
public class CubeFactory {
	
	/**
	 * factory to get the pieces of a cube based on the color
	 * @param color
	 * @return
	 */
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

interface CubePiece {
	

	
	int[][] bluePiece1 = {
			{0,0,1,0,0},
			{0,1,1,1,0},
			{1,1,1,1,1},
			{0,1,1,1,0},
			{0,0,1,0,0}
	};
	int[][] bluePiece2 = {
			{1,0,1,0,1},
			{1,1,1,1,1},
			{0,1,1,1,0},
			{1,1,1,1,1},
			{1,0,1,0,1}
	};
	int[][] bluePiece3 = {
			{0,0,1,0,0},
			{0,1,1,1,1},
			{1,1,1,1,0},
			{0,1,1,1,1},
			{0,0,1,0,0}
	};
	int[][] bluePiece4 = {
			{0,1,0,1,0},
			{1,1,1,1,0},
			{0,1,1,1,1},
			{1,1,1,1,0},
			{1,1,0,1,0}
	};
	int[][] bluePiece5 = {
			{0,1,0,1,0},
			{1,1,1,1,1},
			{0,1,1,1,0},
			{1,1,1,1,1},
			{1,0,1,0,0}
	};
	int[][] bluePiece6 = {
			{0,1,0,1,0},
			{0,1,1,1,1},
			{1,1,1,1,0},
			{0,1,1,1,1},
			{1,1,0,1,1}
	};
	
	int[][] redPiece1 = {
			{0,0,0,1,1},
			{0,1,1,1,0},
			{1,1,1,1,1},
			{0,1,1,1,0},
			{0,1,0,1,1}
	};
	int[][] redPiece2 = {
			{0,1,0,1,0},
			{1,1,1,1,0},
			{0,1,1,1,1},
			{1,1,1,1,0},
			{0,1,0,0,0}
	};
	int[][] redPiece3 = {
			{0,1,1,0,1},
			{1,1,1,1,1},
			{0,1,1,1,0},
			{1,1,1,1,1},
			{1,0,0,1,1}
	};
	int[][] redPiece4 = {
			{0,0,1,0,0},
			{1,1,1,1,0},
			{0,1,1,1,1},
			{1,1,1,1,0},
			{0,0,1,0,0}
	};
	int[][] redPiece5 = {
			{0,0,1,1,0},
			{1,1,1,1,1},
			{0,1,1,1,0},
			{1,1,1,1,1},
			{1,0,1,0,0}
	};
	int[][] redPiece6 = {
			{0,1,1,0,0},
			{0,1,1,1,0},
			{1,1,1,1,1},
			{0,1,1,1,0},
			{1,1,0,1,1}
	};
	
	int[][] purplePiece1 = {
			{1,1,0,1,0},
			{1,1,1,1,0},
			{1,1,1,1,0},
			{0,1,1,1,1},
			{0,0,1,0,0}
	};
	int[][] purplePiece2 = {
			{0,0,0,1,1},
			{1,1,1,1,0},
			{1,1,1,1,1},
			{0,1,1,1,0},
			{0,1,0,1,0}
	};
	int[][] purplePiece3 = {
			{0,1,0,0,0},
			{1,1,1,1,0},
			{0,1,1,1,1},
			{1,1,1,1,0},
			{0,0,1,0,0}
	};
	int[][] purplePiece4 = {
			{1,1,0,1,1},
			{0,1,1,1,1},
			{1,1,1,1,0},
			{0,1,1,1,0},
			{0,1,0,1,0}
	};
	int[][] purplePiece5 = {
			{0,0,1,0,1},
			{0,1,1,1,1},
			{1,1,1,1,1},
			{1,1,1,1,0},
			{1,0,1,1,0}
	};
	int[][] purplePiece6 = {
			{0,1,0,1,1},
			{0,1,1,1,0},
			{0,1,1,1,1},
			{1,1,1,1,0},
			{1,1,0,1,0}
	};
	
	int[][] yellowPiece1 = {
			{0,0,1,0,0},
			{1,1,1,1,0},
			{0,1,1,1,1},
			{1,1,1,1,0},
			{0,1,0,1,0}
	};
	int[][] yellowPiece2 = {
			{0,0,1,0,1},
			{1,1,1,1,1},
			{0,1,1,1,0},
			{1,1,1,1,0},
			{0,1,0,1,0}
	};
	int[][] yellowPiece3 = {
			{0,0,1,0,1},
			{0,1,1,1,1},
			{1,1,1,1,0},
			{1,1,1,1,1},
			{1,0,1,0,0}
	};
	int[][] yellowPiece4 = {
			{1,0,1,0,1},
			{1,1,1,1,1},
			{0,1,1,1,0},
			{1,1,1,1,1},
			{1,0,1,0,0}
	};
	int[][] yellowPiece5 = {
			{0,0,1,0,0},
			{0,1,1,1,1},
			{1,1,1,1,0},
			{0,1,1,1,1},
			{1,1,0,1,0}
	};
	int[][] yellowPiece6 = {
			{0,1,0,1,0},
			{0,1,1,1,0},
			{1,1,1,1,1},
			{0,1,1,1,0},
			{0,1,0,1,1}
	};


	List<int[][]> yellowCubePieces = new LinkedList<>(Arrays.asList(yellowPiece1,yellowPiece2,yellowPiece3,yellowPiece4,yellowPiece5,yellowPiece6));
	List<int[][]> blueCubePieces = new LinkedList<>(Arrays.asList(bluePiece1,bluePiece2,bluePiece3,bluePiece4,bluePiece5,bluePiece6));
	List<int[][]> redCubePieces = new LinkedList<>(Arrays.asList(redPiece1,redPiece2,redPiece3,redPiece4,redPiece5,redPiece6));
	List<int[][]> purpleCubePieces = new LinkedList<>(Arrays.asList(purplePiece1,purplePiece2,purplePiece3,purplePiece4,purplePiece5,purplePiece6));

}