package it.shaojiexu.www;

import it.shaojiexu.www.model.Cube;
import it.shaojiexu.www.model.CubeSolution;
import it.shaojiexu.www.service.CubeFactory;
import it.shaojiexu.www.service.CubeService;
import it.shaojiexu.www.util.Util;

import java.util.Arrays;
import java.util.List;

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
		Cube cubeBlue = cubeFactory.getCubeByColor("red");
		this.cubeService.buildCube(cubeBlue);
	}
	
	@Test
	public void testArrayRotate(){
		
		Cube cubeBlue = cubeFactory.getCubeByColor("blue");
		int[][] piece1 =cubeBlue.getPieces().get(2);
		System.out.println(Util.convertArrayToString(piece1));
		int[][] piece1Rotated = Util.rotate(piece1);
		System.out.println(Util.convertArrayToString(piece1Rotated));
	}
	
	@Test
	public void testUniqueSolution(){
		
		CubeSolution solution1 = new CubeSolution("641523"); // 6,7,8
		CubeSolution solution2 = new CubeSolution("632514"); // 4,8,9
		CubeSolution solution3 = new CubeSolution("631254"); // 6,7,8
		CubeSolution solution4 = new CubeSolution("632154"); // 5,8,8
		
		System.out.println(solution1.equals(solution2));
		System.out.println(solution1.equals(solution3));
		System.out.println(solution2.equals(solution3));
		
		List<CubeSolution> solutions = Arrays.asList(solution1, solution2);
		System.out.println(solutions.contains(solution3));
		System.out.println(solutions.contains(solution4));
	}
	
	

}
