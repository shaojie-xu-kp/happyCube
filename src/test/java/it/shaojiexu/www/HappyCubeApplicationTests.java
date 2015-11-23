package it.shaojiexu.www;

import it.shaojiexu.www.model.Cube;
import it.shaojiexu.www.model.CubeFactory;
import it.shaojiexu.www.service.CubeService;
import it.shaojiexu.www.util.Util;

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
	public void contextLoads() {
	}
	
	@Test
	public void testSolutionToString(){
	}
	
	@Test
	public void testBuildCube(){
		
		Cube cubeBlue = cubeFactory.getCube("blue");
		this.cubeService.buildCube(cubeBlue);
	}
	
	
	public void testArrayRotate(){
		Cube cubeBlue = cubeFactory.getCube("blue");
		Util.printTwoDimentionalArray(cubeBlue.getPiece3());
		System.out.println("***rotate****");
		Util.printTwoDimentionalArray(Util.rotate(cubeBlue.getPiece3()));
		System.out.println("***flip****");
		Util.printTwoDimentionalArray(Util.flip(cubeBlue.getPiece3()));
	}

}
