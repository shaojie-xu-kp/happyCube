package it.shaojiexu.www.util;

import java.util.List;

public class Util {
	
	public static final String ENCODING_SYMBOL = "o";
	
	public static final String NEW_LINE = "\n";
	
	public static final String EMPTY_SPACE = " ";
	
	public static String convertArrayToString(int[][] array){
		StringBuffer stf = new StringBuffer("");
		for(int i = 0 ; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(array[i][j] == 0) {
					stf.append(EMPTY_SPACE);
				}else{
					stf.append(ENCODING_SYMBOL);
				}
			}
			stf.append(NEW_LINE);
		}
		return stf.toString();
	}

	
	/**
	 * flip the two dimensional array based on longitudinal axis
	 * @param piece
	 * @return
	 */
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

	/**
	 * rotate the two dimensional array by 90 degree clockwise
	 * @param piece
	 * @return
	 */
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
	
	/**
	 * find out all the permutations of a string s
	 * @param s
	 * @param perms
	 */
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
	
	/**
	 * verify if the array contains any other position number except 0, 1
	 * @param board
	 * @return
	 */
	public static boolean arrayConstainsOnly0And1(int[][] board){
		
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				if(board[i][j] > 1) 
					return false;
			}
			
		}
		
		return true;
	}


}
