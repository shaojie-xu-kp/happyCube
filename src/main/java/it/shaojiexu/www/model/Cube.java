package it.shaojiexu.www.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Cube {
	
	private Map<Character, int[][]> pieces = new HashMap<>();
	
	
	public Cube(Queue<int[][]> pieces){
		
		for(int i = 1; i <= 6; i++){
			this.pieces.put(Integer.toString(i).charAt(0), pieces.poll());
		}
		
	}


	public Map<Character, int[][]> getPieces() {
				
		return pieces;
	}

	
	public void setPieces(Map<Character, int[][]> pieces) {
		this.pieces = pieces;
	}
	
}
