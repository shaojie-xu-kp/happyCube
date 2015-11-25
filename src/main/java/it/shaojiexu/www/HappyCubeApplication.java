package it.shaojiexu.www;

import it.shaojiexu.www.model.Cube;
import it.shaojiexu.www.model.CubeSolution;
import it.shaojiexu.www.service.CubeFactory;
import it.shaojiexu.www.service.CubeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class HappyCubeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HappyCubeApplication.class, args);
    }
}


@Component
class CubeBuildRunner implements CommandLineRunner {

	
	@Autowired
	CubeService cubeService;
	
	@Autowired
	CubeFactory cubeFactory;
	
	@Value("${cube.color}")
	private String cubeColor;
	
	@Override
	public void run(String... args) throws Exception {
		
		Cube cubeBlue = cubeFactory.getCubeByColor(cubeColor);
		List<CubeSolution> solutions = this.cubeService.buildCube(cubeBlue);
		solutions.forEach(solution -> System.out.println(solution));
		
	}
	
	
}