package it.shaojiexu.www.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public interface CubePiece {
	
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

	Queue<int[][]> blueCublePieces = new LinkedList<>(Arrays.asList(bluePiece1,bluePiece2,bluePiece3,bluePiece4,bluePiece5,bluePiece6));
	Queue<int[][]> redCublePieces = new LinkedList<>(Arrays.asList(redPiece1,redPiece2,redPiece3,redPiece4,redPiece5,redPiece6));

}
