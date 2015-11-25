package it.shaojiexu.www.service;

import it.shaojiexu.www.model.Cube;
import it.shaojiexu.www.model.CubeSolution;

import java.util.List;

public interface CubeService {
	
	public List<CubeSolution> buildCube(Cube cube);

}
