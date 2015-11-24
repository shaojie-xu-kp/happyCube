package it.shaojiexu.www.util;

import java.util.List;

public class Util {
	
	public static void printTwoDimentionalArray(int[][] array){
		
		StringBuffer stf = new StringBuffer("");
		
		for(int i = 0 ; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(array[i][j] == 0) {
					stf.append(" ");
				}else{
					stf.append("O");
				}
			}
			stf.append("\n");
		}
		
		System.out.println(stf.toString());

	}

	public static int[][] flip(int[][] piece) {
		
		final int M = piece.length;
		final int N = piece[0].length;
		int[][] ret = new int[N][M];
		
	    for (int i = 0; i < M; i++) {
	        for (int j = 0; j < N; j++) {
	        	ret[i][N - j - 1] = piece[i][j];
	        }
	    }

		return ret;
	}

	public static int[][] rotate(int[][] piece) {
		final int M = piece.length;
		final int N = piece[0].length;
		int[][] ret = new int[N][M];
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				ret[c][M - 1 - r] = piece[r][c];
			}
		}
		return ret;
	}
	
	public static void permutate(String s, List<String> perms) {
		permutate("", s, perms);
	}

	private static void permutate(String prefix, String s, List<String> perms) {
		int N = s.length();
		if (N == 0)
			perms.add(prefix);
		else {
			for (int i = 0; i < N; i++)
				permutate(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, N), perms);
		}

	}


}
