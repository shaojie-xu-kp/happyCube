package it.shaojiexu.www;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class CubeFactory {
	
	private Map<Integer, Integer> cubeBlue1 = new HashMap<>();
	private Map<Integer, Integer> cubeBlue2 = new HashMap<>();
	private Map<Integer, Integer> cubeBlue3 = new HashMap<>();
	private Map<Integer, Integer> cubeBlue4 = new HashMap<>();
	private Map<Integer, Integer> cubeBlue5 = new HashMap<>();
	private Map<Integer, Integer> cubeBlue6 = new HashMap<>();

	
	
	@PostConstruct
	private void init(){
		
		cubeBlue1.put(1, 00100);
		cubeBlue1.put(2, 00100);
		cubeBlue1.put(3, 00100);
		cubeBlue1.put(4, 00100);
		cubeBlue1.put(5, 00100);
		cubeBlue1.put(6, 00100);
		cubeBlue1.put(7, 00100);
		cubeBlue1.put(8, 00100);
		
		cubeBlue2.put(1, 10101);
		cubeBlue2.put(2, 11011);
		cubeBlue2.put(3, 10101);
		cubeBlue2.put(4, 11011);
		cubeBlue2.put(5, 10101);
		cubeBlue2.put(6, 11011);
		cubeBlue2.put(7, 10101);
		cubeBlue2.put(8, 11011);

		cubeBlue3.put(1, 00100);
		cubeBlue3.put(2, 01010);
		cubeBlue3.put(3, 00100);
		cubeBlue3.put(4, 00100);
		cubeBlue3.put(5, 00100);
		cubeBlue3.put(6, 01010);
		cubeBlue3.put(7, 00100);
		cubeBlue3.put(8, 00100);

		cubeBlue4.put(1, 11010);
		cubeBlue4.put(2, 00100);
		cubeBlue4.put(3, 01010);
		cubeBlue4.put(4, 01011);
		cubeBlue4.put(5, 01011);
		cubeBlue4.put(6, 00100);
		cubeBlue4.put(7, 01010);
		cubeBlue4.put(8, 11010);
		
	}

}
