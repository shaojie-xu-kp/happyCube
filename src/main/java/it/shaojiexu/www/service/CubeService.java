package it.shaojiexu.www.service;

import it.shaojiexu.www.model.Cube;
import it.shaojiexu.www.util.Util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class CubeService {
	
	private Map<Integer, int[]> startIndexMap= new HashMap<>();
	
	private int[][] board = new int[17][13];
//	
//	private List<int[][]> matchedPieces;
//	
//	private int[][] solution = new int[20][15];
	
	@PostConstruct
	private void init(){
		startIndexMap.put(1, new int[]{0,4});
		startIndexMap.put(2, new int[]{4,0});
		startIndexMap.put(3, new int[]{4,4});
		startIndexMap.put(4, new int[]{4,8});
		startIndexMap.put(5, new int[]{8,4});
		startIndexMap.put(6, new int[]{12,4});
	}
	
	public boolean  putPiece(int[][] piece, int position, int times){
		
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
		
		if(isValid(testBoard,position)) {
			board = testBoard;
			return true;
		}else{
			times++;
			if(times == 4) {
				piece = Util.flip(piece);
			}else{
				piece = Util.rotate(piece);
			}
			return putPiece(piece,  position, times);
			
		}
		
	}
	
	public Queue<int[][]> buildCube(Cube cube){
		
		Queue<int[][]> pieces = new LinkedList<>(cube.getPieces().values());
		Queue<int[][]> results = new LinkedList<>();
		
		for(int i = 1; i <= 6; i++) {
			
			if( i > results.size() + 1) {
				pieces.add(pieces.poll());
				i--;
			}
			
			pieces.removeAll(results);
			for(int[][] piece : pieces) {
				if(this.putPiece(piece, i, 1)){
					results.add(piece);
					break;
				}
			}
		}
		
		Util.printTwoDimentionalArray(board);
		return results;
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
