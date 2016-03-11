package com.xebia.tondeuse.service;

import java.util.Map;

public interface LireInstructionService {

	public Map<String, String> lireFichierInstruction(String nomFichier);
	
	public int[] getTailleSurface(String ligneFichier);
	
	public String[] getPositionOrientationTondeuse(String ligneFichier);
	
	public String getInstruction(String ligneFichier);
		
	
	
	
}
