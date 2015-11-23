package it.shaojiexu.www;

import it.shaojiexu.www.model.Cube;
import it.shaojiexu.www.model.CubeFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HappyCubeApplication.class)
public class TestCubeFactory {
	
	@Autowired
	CubeFactory cubeFactory;
	
	@Test
	public void testBlueGeneration() {
		Cube cube = cubeFactory.getCube("BLUE");
		cube.getPieces().entrySet().forEach(entry -> {
			int[][] piece = entry.getValue();
			for(int i = 0; i < piece.length; i ++ )
				for(int j = 0; j< piece[i].length; j++){
					System.out.println(String.format("%s : %s", entry.getKey(), piece[i][j]));
				}
		});
	}

}
