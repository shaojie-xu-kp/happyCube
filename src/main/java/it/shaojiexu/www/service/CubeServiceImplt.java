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
public class CubeServiceImplt implements CubeService {
	
	private Map<Integer, int[]> startIndexOnBoardMap= new HashMap<>(); // start index on board to be used for building the cube
	private Map<Integer, int[]> startIndexOnSolutionBoardMap= new HashMap<>(); //  start index on board to be displayed as final solution
	
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
	
	
	/**
	 * recursively put one piece into the board
	 * if not fit for time k, in time k+1, rotate or flip the piece, max 8 times rotate or flip
	 * @param piece
	 * @param position
	 * @param times
	 * @param board
	 * @param solutionBoard
	 * @return
	 */
	private boolean  putPiece(int[][] piece, int position, int times, int[][] board, int[][] solutionBoard){
		
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
	

	/**
	 * put the correctly matched piece into solution board based on the position
	 * @param piece
	 * @param solutionBoard
	 * @param position
	 */
	private void fillOutSolutionBoard(int[][] piece, int[][] solutionBoard,int position) {
		
		int[] startIndex = this.startIndexOnSolutionBoardMap.get(position);
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				solutionBoard[startIndex[0] + i][startIndex[1] + j] = piece[i][j];
			}
		}

	}

	
	/**
	 * entrance method to build a cube based on the pieces
	 * the main idea is 
	 * first of all, get all permutations of 6 pieces on 6 positions, that would be 6*5*4*3*2*1 = 720 permutations
	 * in this program, the 6 positions are as follows
	 * 
	 * 123
	 *  4
	 *  5
	 *  6
	 *  
	 *  based on the number of each position, put the corresponding piece
	 *  each piece has 8 orientations, 1 original one, 3 rotated one, 1 flipped one, and 3 flipped rotated one
	 *	take into consideration of all, there will be 6*8*6*5*4*3*2*1 = 34560 combinations
	 *  
	 */
	public List<CubeSolution> buildCube(Cube cube){
		
		List<String> permutations = new ArrayList<>();
		Util.permutate(POSITIONS,permutations);
		
		List<CubeSolution> solutions = new ArrayList<>();
		
		//loop for each piece
		for(int pieceNumber = 1; pieceNumber <= 6 ; pieceNumber++){
			
			//loop for each rotate time
			for(int rotateTime = 0; rotateTime <= 8; rotateTime ++) {
				
				if(rotateTime >= 1) cube.rotatePieceByNumber(pieceNumber);
				if(rotateTime == 4) cube.flipPieceByNumber(pieceNumber);
				
				Map<Integer, int[][]> pieces = cube.getPieces();
				
				//loop for each permutation, each permutation represents the positions of each piece
				for(String permutation : permutations){
					
					//board to be used for building the cube
					int[][] board = new int[17][13];
					
					//board to be displayed as a final solution
					int[][] solutionBoard = new int[20][15];
					
					boolean successful_put_flag = true;
					
					for(int position = 1; position <= 6; position++) {
						successful_put_flag = successful_put_flag && this.putPiece(pieces.get(Character.getNumericValue(permutation.charAt(position-1))), position, 0, board, solutionBoard);
					}
					
					// all 6 pieces have been successfully put into the board
					if(successful_put_flag) {
						CubeSolution solution = new CubeSolution(permutation, solutionBoard);
						// add only the unique solution
						if(!solutions.contains(solution)){
							solutions.add(solution);
						}
					}
				}
			}
		}
		
		return solutions;
	}
	

	/**
	 * validate the board based on the position
	 * start to check only from 4, because for the first three position, the criteria is no number bigger than 1 validated in method Util.arrayConstainsOnly0And1()
	 * @param board
	 * @param position
	 * @return
	 */
	private boolean validate(int[][] board, int position) {
		
		boolean flag = true;
		
		if(position == 4) {
			flag = flag && (board[4][4] == 1);
			flag = flag && (board[4][3] + board[5][4] == 1);
			flag = flag && (board[4][2] + board[6][4] == 1);
			flag = flag && (board[4][1] + board[7][4] == 1);
			flag = flag && (board[4][0] + board[8][4] <= 1);
			
			flag = flag && (board[4][8] == 1);
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

	/**
	 * copy array from boardFrom to boardTo
	 * @param boardFrom
	 * @param boardTo
	 */
	private void copyArray(int[][] boardFrom, int[][] boardTo) {
		for(int i=0; i<boardFrom.length; i++)
			  for(int j=0; j<boardFrom[i].length; j++)
				  boardTo[i][j]=boardFrom[i][j];
	}


}
