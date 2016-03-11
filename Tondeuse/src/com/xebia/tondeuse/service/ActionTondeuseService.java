package com.xebia.tondeuse.service;

import com.xebia.tondeuse.commun.OrientationEnum;
import com.xebia.tondeuse.object.Surface;
import com.xebia.tondeuse.object.Tondeuse;

public interface ActionTondeuseService {

	public void bougerTondeuse(Tondeuse tondeuseMoove, Tondeuse tondeuseStatic, String instructions);
	
	public Tondeuse positionnerTondeuse(int numeroTondeuse, int positionX, int positionY, OrientationEnum orientation, Surface surface);
	
}
