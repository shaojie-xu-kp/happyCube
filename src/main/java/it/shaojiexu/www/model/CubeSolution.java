package it.shaojiexu.www.model;

import it.shaojiexu.www.util.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CubeSolution {
	
	private String permutation;
	
	private List<Integer> nonAdjacentFaceValues = new ArrayList<>();
	
	private int[][] solutionBoard;
	
	public CubeSolution(String permutation, int[][] solutionBoard){
		this.permutation = permutation;
		this.solutionBoard = solutionBoard;
		nonAdjacentFaceValues.add(Character.getNumericValue(permutation.charAt(0)) + Character.getNumericValue(permutation.charAt(2)));
		nonAdjacentFaceValues.add(Character.getNumericValue(permutation.charAt(1)) + Character.getNumericValue(permutation.charAt(4)));
		nonAdjacentFaceValues.add(Character.getNumericValue(permutation.charAt(3)) + Character.getNumericValue(permutation.charAt(5)));
		Collections.sort(nonAdjacentFaceValues);
	}

	public String getPermutation() {
		return permutation;
	}

	public List<Integer> getNonAdjacentFaceValues() {
		return nonAdjacentFaceValues;
	}
	

	public int[][] getSolutionBoard() {
		return solutionBoard;
	}

	public boolean equals(Object o){
		
		if(o instanceof CubeSolution){
			CubeSolution sol = (CubeSolution)o;
			return this.nonAdjacentFaceValues.equals(sol.getNonAdjacentFaceValues());
		}
		
		return false;
	}
	
	public int hashCode(){
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((permutation == null) ? 0 : permutation.hashCode());
		
		for(Integer value : nonAdjacentFaceValues) {
			result = prime * result + value;
		}
		
		return result;
	}
	
	
	public String toString(){
		return String.format("Non-Adjacent Face Pairs: {[%c, %c],[%c, %c],[%c, %c]} :\n%s", permutation.charAt(0), permutation.charAt(2), permutation.charAt(1), permutation.charAt(4), permutation.charAt(3), permutation.charAt(5), Util.convertArrayToString(solutionBoard));
	}
	
	

}
