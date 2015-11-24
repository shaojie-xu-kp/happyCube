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
		startIndexMap.put(2, new int[]{0,5});
		startIndexMap.put(3, new int[]{0,10});
		startIndexMap.put(4, new int[]{5,5});
		startIndexMap.put(5, new int[]{10,5});
		startIndexMap.put(6, new int[]{15,5});
	}
	
	public boolean  putPiece(int[][] piece, int position, int times, int[][] board){
		
		if(times > 8) {
			return false;
		}
		
		int [][] testBoard = new int[20][15];
		this.copyArray(board, testBoard);
		int[] startIndex = this.startIndexMap.get(position);
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				testBoard[startIndex[0] + i][startIndex[1] + j] = piece[i][j] + testBoard[startIndex[0] + i][startIndex[1] + j];
			}
		}
		
		if(isValid(testBoard,position)) {
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
		
		for(String permutation : permutations){
			
			int[][] board = new int[20][15];
			
			boolean flag = true;
			
			for(int i = 0; i < 6; i++) {
				flag = flag && this.putPiece(pieces.get(permutation.charAt(i)), i+1, 1, board);
			}
			
			if(flag && this.validate(board)) {
				Util.printTwoDimentionalArray(board);
			}
			
		}
		
		
	}
	
	private boolean validate(int[][] board) {
		return true;
	}

	private boolean isValid(int[][] board, int position) {
		
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				if(board[i][j] > 1) 
					return false;
			}
			
		}
		
		return true;
	}
	
	private void copyArray(int[][] board, int[][] testBoard) {
		for(int i=0; i<board.length; i++)
			  for(int j=0; j<board[i].length; j++)
				  testBoard[i][j]=board[i][j];
	}


	

}
