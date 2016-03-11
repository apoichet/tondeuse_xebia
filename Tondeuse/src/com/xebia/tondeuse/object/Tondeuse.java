package com.xebia.tondeuse.object;

import org.apache.commons.lang3.*;

import com.xebia.tondeuse.commun.OrientationEnum;
import com.xebia.tondeuse.commun.TondeuseUtils;

public class Tondeuse {

	private int numero;

	private int positionX;

	private int positionY;

	private OrientationEnum orientationEnum;

	private Surface surface;

	public Tondeuse() {

	}

	public Tondeuse(int numero, int positionX, int positionY,
			OrientationEnum orientationEnum, Surface surface) {
		this.surface = surface;
		this.numero = numero;
		this.positionX = positionX;
		this.positionY = positionY;
		this.orientationEnum = orientationEnum;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public OrientationEnum getOrientationEnum() {
		return orientationEnum;
	}

	public void setOrientationEnum(OrientationEnum orientationEnum) {
		this.orientationEnum = orientationEnum;
	}

	public Surface getSurface() {
		return surface;
	}

	public void setSurface(Surface surface) {
		this.surface = surface;
	}

	@Override
	public String toString() {

		StringBuilder sbTondeuse = new StringBuilder(StringUtils.EMPTY);
		sbTondeuse.append(this.getPositionX());
		sbTondeuse.append(StringUtils.SPACE);
		sbTondeuse.append(this.getPositionY());
		sbTondeuse.append(StringUtils.SPACE);
		if (this.getOrientationEnum() != null) {
			sbTondeuse.append(this.getOrientationEnum().getOrientation());
		}
		sbTondeuse.append(TondeuseUtils.SAUT_DE_LIGNE);

		return sbTondeuse.toString();
	}

}
