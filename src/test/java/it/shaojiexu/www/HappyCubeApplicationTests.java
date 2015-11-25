package it.shaojiexu.www;

import it.shaojiexu.www.model.Cube;
import it.shaojiexu.www.service.CubeFactory;
import it.shaojiexu.www.service.CubeService;
import it.shaojiexu.www.util.Util;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HappyCubeApplication.class)
public class HappyCubeApplicationTests {
	
	@Autowired
	CubeService cubeService;
	
	@Autowired
	CubeFactory cubeFactory;
		
	@Test
	public void testBuildCube(){
//		int[][] board = new int[20][15];
		Cube cubeBlue = cubeFactory.getCubeByColor("purple");
//		this.cubeService.putPiece(cubeBlue.getPiece1(), 1, 1, board);
//		this.cubeService.putPiece(Util.rotate(cubeBlue.getPiece2()), 5, 1, board);
//		this.cubeService.putPiece(cubeBlue.getPiece3(), 6, 1, board);
//		this.cubeService.putPiece(cubeBlue.getPiece6(), 2, 1, board);
//		int[][] pieces4Rotated = Util.rotate(Util.rotate(Util.rotate(Util.flip(cubeBlue.getPiece4()))));
//		this.cubeService.putPiece(pieces4Rotated, 4, 1, board);
//		int[][] pieces5Rotated = Util.rotate(Util.rotate(Util.flip(cubeBlue.getPiece5())));
//		this.cubeService.putPiece(pieces5Rotated, 3, 1, board);
		this.cubeService.buildCube(cubeBlue);
	}
	
	
	public void testArrayRotate(){
		
		Queue<int[][]> result = new LinkedList<>();
		
		Cube cubeBlue = cubeFactory.getCubeByColor("blue");
		int[][] piece1 =cubeBlue.getPieces().get('1');
		System.out.println(Util.convertArrayToString(piece1));
		result.add(piece1);
		int[][] piece1Rotated = Util.rotate(piece1);
		System.out.println(result.contains(piece1Rotated));
	}

}
