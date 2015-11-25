package it.shaojiexu.www.model;

import it.shaojiexu.www.util.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cube {
	
	private Map<Integer, int[][]> pieces = new HashMap<>();
	
	public Cube(List<int[][]> pieces){
		
		for(int i = 0; i < 6; i++){
			this.pieces.put(i+1, pieces.get(i));
		}
		
	}
	
	public Cube(){
		
	}

	public Map<Integer, int[][]> getPieces() {
		return pieces;
	}


	public void setPieces(Map<Integer, int[][]> pieces) {
		this.pieces = pieces;
	}

	public void rotatePieceByNumber(int pieceNumber) {
		int[][] piece = this.pieces.get(pieceNumber);
		piece = Util.rotate(piece);
		this.pieces.put(pieceNumber, piece);
	}
	
	public void flipPieceByNumber(int pieceNumber) {
		int[][] piece = this.pieces.get(pieceNumber);
		piece = Util.flip(piece);
		this.pieces.put(pieceNumber, piece);
	}
	
}
