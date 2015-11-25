package it.shaojiexu.www;

import it.shaojiexu.www.model.Cube;
import it.shaojiexu.www.model.CubeSolution;
import it.shaojiexu.www.service.CubeFactory;
import it.shaojiexu.www.service.CubeService;
import it.shaojiexu.www.util.Util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger(CubeBuildRunner.class);

	@Autowired
	CubeService cubeService;
	
	@Autowired
	CubeFactory cubeFactory;
	
	@Value("${cube.color}")
	private String cubeColor;
	
	@Value("${cube.file.path}")
	private String cubeFilePath;
	
	@Value("${cube.file.name}")
	private String cubeFileName;
	
	@Override
	public void run(String... args) throws Exception {
		
		Cube cubeBlue = cubeFactory.getCubeByColor(cubeColor);
		List<CubeSolution> solutions = this.cubeService.buildCube(cubeBlue);
		
		logger.info(String.format("******* start building %s cube ************", cubeColor));
		
		try{
			
			FileWriter cubeFileWriter = new FileWriter(cubeFilePath + File.separator +cubeFileName);
			
			for(int i = 0; i < solutions.size(); i++){
				String output = String.format("Solution %d for %s cube : %s", i+1, cubeColor, solutions.get(i).toString());
				logger.info(output);
				cubeFileWriter.append(output);
				cubeFileWriter.append(Util.NEW_LINE);
			}
			
			cubeFileWriter.flush();
			cubeFileWriter.close();
			
			logger.info(String.format("solutions have been written to file %s", cubeFilePath + File.separator +cubeFileName));
			logger.info(String.format("******* end building %s cube ************", cubeColor));

		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}