package it.shaojiexu.www.model;

import java.util.HashMap;
import java.util.Map;

public class Cube {
	
	private Map<String, int[][]> pieces = new HashMap<>();
	
	private int[][] piece1 = new int[5][];
	
	private int[][] piece2 = new int[5][];
	
	private int[][] piece3 = new int[5][];
	
	private int[][] piece4 = new int[5][];
	
	private int[][] piece5 = new int[5][];
	
	private int[][] piece6 = new int[5][];
	
	public Cube(int[][] ... pieces){
		if(pieces.length == 6){
			piece1 = pieces[0];
			piece2 = pieces[1];
			piece3 = pieces[2];
			piece4 = pieces[3];
			piece5 = pieces[4];
			piece6 = pieces[5];
		}
	}

	public int[][] getPiece1() {
		return piece1;
	}

	public void setPiece1(int[][] piece1) {
		this.piece1 = piece1;
	}

	public int[][] getPiece2() {
		return piece2;
	}

	public void setPiece2(int[][] piece2) {
		this.piece2 = piece2;
	}

	public int[][] getPiece3() {
		return piece3;
	}

	public void setPiece3(int[][] piece3) {
		this.piece3 = piece3;
	}

	public int[][] getPiece4() {
		return piece4;
	}

	public void setPiece4(int[][] piece4) {
		this.piece4 = piece4;
	}

	public int[][] getPiece5() {
		return piece5;
	}

	public void setPiece5(int[][] piece5) {
		this.piece5 = piece5;
	}

	public int[][] getPiece6() {
		return piece6;
	}

	public void setPiece6(int[][] piece6) {
		this.piece6 = piece6;
	}

	public Map<String, int[][]> getPieces() {
		
		if(this.pieces.size() != 6) {
			loadPieces();
		}
		
		return pieces;
	}

	private void loadPieces() {
		this.pieces.put("piece1", piece1);
		this.pieces.put("piece2", piece2);
		this.pieces.put("piece3", piece3);
		this.pieces.put("piece4", piece4);
		this.pieces.put("piece5", piece5);
		this.pieces.put("piece6", piece6);
		
	}

	public void setPieces(Map<String, int[][]> pieces) {
		this.pieces = pieces;
	}
	
}
