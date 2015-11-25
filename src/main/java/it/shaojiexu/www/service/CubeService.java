package it.shaojiexu.www.service;

import it.shaojiexu.www.model.Cube;
import it.shaojiexu.www.model.CubeSolution;
import it.shaojiexu.www.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class CubeService {
	
	private Map<Integer, int[]> startIndexOnBoardMap= new HashMap<>();
	private Map<Integer, int[]> startIndexOnSolutionBoardMap= new HashMap<>();
	
	private static final String POSITIONS = "123456";
	
	@PostConstruct
	private void init(){
		startIndexOnBoardMap.put(1, new int[]{0,0});
		startIndexOnBoardMap.put(2, new int[]{0,4});
		startIndexOnBoardMap.put(3, new int[]{0,8});
		startIndexOnBoardMap.put(4, new int[]{4,4});
		startIndexOnBoardMap.put(5, new int[]{8,4});
		startIndexOnBoardMap.put(6, new int[]{12,4});
		
		startIndexOnSolutionBoardMap.put(1, new int[]{0,0});
		startIndexOnSolutionBoardMap.put(2, new int[]{0,5});
		startIndexOnSolutionBoardMap.put(3, new int[]{0,10});
		startIndexOnSolutionBoardMap.put(4, new int[]{5,5});
		startIndexOnSolutionBoardMap.put(5, new int[]{10,5});
		startIndexOnSolutionBoardMap.put(6, new int[]{15,5});

	}
	
	public boolean  putPiece(int[][] piece, int position, int times, int[][] board, int[][] solutionBoard){
		
		if(times > 8) {
			return false;
		}
		
		int [][] testBoard = new int[17][13];
		this.copyArray(board, testBoard);
		int[] startIndex = this.startIndexOnBoardMap.get(position);
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				testBoard[startIndex[0] + i][startIndex[1] + j] = piece[i][j] + testBoard[startIndex[0] + i][startIndex[1] + j];
			}
		}
		
		if(Util.arrayConstainsOnly0And1(testBoard)&&this.validate(testBoard, position)) {
			this.copyArray(testBoard, board);
			this.fillOutSolutionBoard(piece, solutionBoard, position);
			return true;
		}else{
			times++;
			piece = Util.rotate(piece);
			if(times == 4) {
				piece = Util.flip(piece);
			}
			return putPiece(piece,  position, times, board, solutionBoard);
		}
		
	}
	

	private void fillOutSolutionBoard(int[][] piece, int[][] solutionBoard,int position) {
		
		int[] startIndex = this.startIndexOnSolutionBoardMap.get(position);
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				solutionBoard[startIndex[0] + i][startIndex[1] + j] = piece[i][j];
			}
		}

	}

	public void buildCube(Cube cube){
		
		List<String> permutations = new ArrayList<>();
		Util.permutate(POSITIONS,permutations);
		
		Map<Integer, int[][]> pieces = cube.getPieces();
		
		List<CubeSolution> solutions = new ArrayList<>();
		
		int k = 0;
		for(int pieceNumber = 1; pieceNumber <= 6 ; pieceNumber++){
			
			for(int rotateTime = 0; rotateTime <= 8; rotateTime ++) {
				
				if(rotateTime > 1) cube.rotatePieceByNumber(pieceNumber);
				if(rotateTime == 4) cube.flipPieceByNumber(pieceNumber);
				
				for(String permutation : permutations){
					
					int[][] board = new int[17][13];
					int[][] solutionBoard = new int[20][15];
					
					boolean flag = true;
					
					for(int i = 1; i <= 6; i++) {
						flag = flag && this.putPiece(pieces.get(Character.getNumericValue(permutation.charAt(i-1))), i, 1, board, solutionBoard);
					}
					
					if(flag && !solutions.contains(new CubeSolution(permutation))) {
						CubeSolution solution = new CubeSolution(permutation);
						solutions.add(solution);
						System.out.println(String.format("Solution %d -> %s: \n%s", k++, permutation, Util.convertArrayToString(solutionBoard)));
					}
				}
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
