package it.shaojiexu.www.service;

import it.shaojiexu.www.model.Cube;
import it.shaojiexu.www.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class CubeService {
	
	private Map<Integer, int[]> startIndexMap= new HashMap<>();
	
	@PostConstruct
	private void init(){
		startIndexMap.put(1, new int[]{0,0});
		startIndexMap.put(2, new int[]{0,4});
		startIndexMap.put(3, new int[]{0,8});
		startIndexMap.put(4, new int[]{4,4});
		startIndexMap.put(5, new int[]{8,4});
		startIndexMap.put(6, new int[]{12,4});
	}
	
	public boolean  putPiece(int[][] piece, int position, int times, int[][] board){
		
		if(times > 8) {
			return false;
		}
		
		int [][] testBoard = new int[17][13];
		this.copyArray(board, testBoard);
		int[] startIndex = this.startIndexMap.get(position);
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				testBoard[startIndex[0] + i][startIndex[1] + j] = piece[i][j] + testBoard[startIndex[0] + i][startIndex[1] + j];
			}
		}
		
		if(Util.arrayConstainsOnly0And1(testBoard)&&this.validate(testBoard, position)) {
			this.copyArray(testBoard, board);
			return true;
		}else{
			times++;
			if(times == 4) {
				piece = Util.flip(piece);
			}else{
				piece = Util.rotate(piece);
			}
			return putPiece(piece,  position, times, board);
			
		}
		
	}
	
	
	public void buildCube(Cube cube){
		
		List<String> permutations = new ArrayList<>();
		Util.permutate("123456",permutations);
		
		Map<Character, int[][]> pieces = cube.getPieces();
		
		int k = 0;
		for(String permutation : permutations){
			
			int[][] board = new int[17][13];
			
			boolean flag = true;
			
			for(int i = 0; i < 6; i++) {
				flag = flag && this.putPiece(pieces.get(permutation.charAt(i)), i+1, 1, board);
			}
			
			if(flag) {
				System.out.println(String.format("Solution : %d -> %s: \n%s", k++, permutation, Util.convertArrayToString(board)));
			}
			
		}
		
		
	}
	
	private boolean validate(int[][] board, int position) {
		
		boolean flag = true;
		
		if(position == 4) {
			flag = flag && board[4][4] == 1;
			flag = flag && (board[4][3] + board[5][4] == 1);
			flag = flag && (board[4][2] + board[6][4] == 1);
			flag = flag && (board[4][1] + board[7][4] == 1);
			flag = flag && (board[4][0] + board[8][4] <= 1);
			
			flag = flag && board[4][8] == 1;
			flag = flag && (board[5][8] + board[4][9] == 1);
			flag = flag && (board[6][8] + board[4][10] == 1);
			flag = flag && (board[7][8] + board[4][11] == 1);
			flag = flag && (board[8][8] + board[4][12] <= 1);
		}
		
		if(position == 5) {
			flag = flag && (board[4][0] + board[8][4] == 1);
			flag = flag && (board[3][0] + board[9][4] == 1);
			flag = flag && (board[2][0] + board[10][4] == 1);
			flag = flag && (board[1][0] + board[11][4] == 1);
			flag = flag && (board[0][0] + board[12][4] <= 1);
			
			flag = flag && (board[8][8] + board[4][12] == 1);
			flag = flag && (board[9][8] + board[3][12] == 1);
			flag = flag && (board[10][8] + board[2][12] == 1);
			flag = flag && (board[11][8] + board[1][12] == 1);
			flag = flag && (board[12][8] + board[0][12] <= 1);
		}
		
		if(position == 6) {
			flag = flag && (board[0][0] + board[12][4] == 1);
			flag = flag && (board[0][1] + board[13][4] == 1);
			flag = flag && (board[0][2] + board[14][4] == 1);
			flag = flag && (board[0][3] + board[15][4] == 1);
			flag = flag && (board[0][4] + board[16][4] == 1);

			flag = flag && (board[12][8] + board[0][12] == 1);
			flag = flag && (board[13][8] + board[0][11] == 1);
			flag = flag && (board[14][8] + board[0][10] == 1);
			flag = flag && (board[15][8] + board[0][9] == 1);
			flag = flag && (board[16][8] + board[0][8] == 1);
			
		}
		
		return flag;
	}

	
	private void copyArray(int[][] board, int[][] testBoard) {
		for(int i=0; i<board.length; i++)
			  for(int j=0; j<board[i].length; j++)
				  testBoard[i][j]=board[i][j];
	}


	

}
