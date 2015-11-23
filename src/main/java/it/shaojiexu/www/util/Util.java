package it.shaojiexu.www.util;

public class Util {
	
	public static void printTwoDimentionalArray(int[][] array){
		
		StringBuffer stf = new StringBuffer("");
		
		for(int i = 0 ; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(array[i][j] == 0) {
					stf.append(array[i][j]);
				}else{
					stf.append(array[i][j]);
				}
			}
			stf.append("\n");
		}
		
		System.out.println(stf.toString());

	}

}
