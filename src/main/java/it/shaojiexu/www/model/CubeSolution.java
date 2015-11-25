package it.shaojiexu.www.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CubeSolution {
	
	private String permutation;
	
	private List<Integer> nonAdjacentFaceValues = new ArrayList<>();
	
	public CubeSolution(String permutation){
		this.permutation = permutation;
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

	public boolean equals(Object o){
		
		if(o instanceof CubeSolution){
			CubeSolution sol = (CubeSolution)o;
			boolean flag = this.nonAdjacentFaceValues.equals(sol.getNonAdjacentFaceValues());
			return flag;
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
	
	

}
