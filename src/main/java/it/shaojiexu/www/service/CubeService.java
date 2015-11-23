package it.shaojiexu.www.service;

import it.shaojiexu.www.model.Cube;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class CubeService {
	
	private Map<Integer, int[]> startIndexMap= new HashMap<>();
	
//	private int[][] board = new int[17][13];
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
	
	public void  putPiece(int[][] piece, int[][] board, int position){
		int[] startIndex = this.startIndexMap.get(position);
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				board[startIndex[0] + i][startIndex[1] + j] = piece[i][j] + board[startIndex[0] + i][startIndex[1] + j];
			}
		}
	}
	
	public int[][] buildCube(Cube cube){
		
		int[][] board = new int[17][13];
		int i = 0;
		for(int[][] piece : cube.getPieces().values()){
			this.putPiece(piece, board, ++i);
		}
		
		return board;
	}
	

}
