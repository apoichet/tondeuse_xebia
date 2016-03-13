package com.xebia.tondeuse.service.impl;

import org.apache.commons.lang3.StringUtils;

import com.xebia.tondeuse.commun.OrientationEnum;
import com.xebia.tondeuse.commun.TondeuseUtils;
import com.xebia.tondeuse.object.Surface;
import com.xebia.tondeuse.object.Tondeuse;
import com.xebia.tondeuse.service.ActionTondeuseService;

public class ActionTondeuseServiceImpl implements ActionTondeuseService {

	
	
	
	@Override
	public void bougerTondeuse(Tondeuse tondeuseMoove, Tondeuse tondeuseStatic,
			String instructions) {

		if (StringUtils.isNotEmpty(instructions)) {

			char tabInsctruct[] = instructions.toCharArray();

			for (char instruct : tabInsctruct) {
				
				traiterInstruct(tondeuseMoove, tondeuseStatic, instruct);

			}

		}

	}

	@Override
	public Tondeuse positionnerTondeuse(int numeroTondeuse, int positionX,
			int positionY, OrientationEnum orientation, Surface surface) {

		Tondeuse tondeuse = new Tondeuse(numeroTondeuse, positionX, positionY,
				orientation, surface);

		// On evite de faire déborder la tondeuse de la surface
		if (surface != null) {

			boolean depasseLargeur = depassement(positionX,
					surface.getLargeur());
			if (depasseLargeur) {
				tondeuse.setPositionX(surface.getLargeur());
			}

			boolean depasseLongeur = depassement(positionY,
					surface.getLongueur());
			if (depasseLongeur) {
				tondeuse.setPositionY(surface.getLongueur());
			}

		}

		return tondeuse;

	}

	protected void traiterInstruct(Tondeuse tondeuseMoove,
			Tondeuse tondeuseStatic, char instruction) {

		int coordonnee[] = new int[2];
		coordonnee[0] = tondeuseMoove.getPositionX();
		coordonnee[1] = tondeuseMoove.getPositionY();
		OrientationEnum orientation = tondeuseMoove.getOrientationEnum();

		switch (instruction) {
		case TondeuseUtils.CODE_AVANCER:

			coordonnee = avancerTondeuse(tondeuseMoove, tondeuseStatic);
			break;

		case TondeuseUtils.CODE_DROITE:

			orientation = OrientationEnum.getOrientationEnumRight(orientation);
			break;

		case TondeuseUtils.CODE_GAUCHE:

			orientation = OrientationEnum.getOrientationEnumLeft(orientation);
			break;
		}

		tondeuseMoove.setOrientationEnum(orientation);
		tondeuseMoove.setPositionX(coordonnee[0]);
		tondeuseMoove.setPositionY(coordonnee[1]);

	}

	protected int[] avancerTondeuse(Tondeuse tondeuseMoove, Tondeuse tondeuseStatic) {

		OrientationEnum orientation = tondeuseMoove.getOrientationEnum();
		int positionX = tondeuseMoove.getPositionX();
		int positionY = tondeuseMoove.getPositionY();
		
		int positionFinalX = tondeuseMoove.getPositionX();
		int positionFinalY = tondeuseMoove.getPositionY();

		if (OrientationEnum.NORD.equals(orientation)) {
			positionY++;

		} else if (OrientationEnum.SUD.equals(orientation)) {
			positionY--;

		} else if (OrientationEnum.WEST.equals(orientation)) {
			positionX--;
			
		} else if (OrientationEnum.EST.equals(orientation)) {
			positionX++;

		}
		
		if (isOkDeplacement(positionX, positionY, tondeuseMoove, tondeuseStatic)) {
			positionFinalX = positionX;
			positionFinalY = positionY;
		}
		
		int coordonne[] = {positionFinalX, positionFinalY};
		
		return coordonne;

	}
	
	protected boolean isOkDeplacement(int positionX, int positionY, Tondeuse tondeuseMoove, Tondeuse tondeuseStatic){
		
		boolean okFrontiere = isOkFrontiereSurface(positionX, positionY, tondeuseMoove);
		
		boolean pasColision = !isColision(positionX, positionY, tondeuseStatic);
		
		return okFrontiere && pasColision;
		
	}

	protected boolean isOkFrontiereSurface(int positionX, int positionY, Tondeuse tondeuseMoove) {

		Surface surface = tondeuseMoove.getSurface();
		
		boolean ok = false;

		if (surface != null) {

			boolean okLargeur = !depassement(positionX, surface.getLargeur());
			boolean okLongeur = !depassement(positionY, surface.getLongueur());

			ok = okLargeur && okLongeur;

		}

		return ok;
	}
	
	protected boolean isColision(int positionX, int positionY, Tondeuse tondeuseStatic){
		boolean colision = false;
		
		if (tondeuseStatic != null) {
			
			if (positionX == tondeuseStatic.getPositionX() && positionY == tondeuseStatic.getPositionY()) {
			
				System.out.println(TondeuseUtils.MSG_COLISION + StringUtils.SPACE + tondeuseStatic.getNumero());
				colision = true;
			}
			
		}
		
		return colision;
		
	}
	
	protected boolean depassement(int position, int surface) {
		boolean depasse = false;

		if (surface < position || position < 0) {

			depasse = true;

		}

		return depasse;
	}

}
