package com.xebia.tondeuse.commun;

import org.apache.commons.lang3.StringUtils;

public enum OrientationEnum {

	NORD(TondeuseUtils.CODE_ORIENTATION_NORD, TondeuseUtils.CODE_ORIENTATION_EST, TondeuseUtils.CODE_ORIENTATION_WEST),

	SUD(TondeuseUtils.CODE_ORIENTATION_SUD, TondeuseUtils.CODE_ORIENTATION_WEST, TondeuseUtils.CODE_ORIENTATION_EST),

	EST(TondeuseUtils.CODE_ORIENTATION_EST, TondeuseUtils.CODE_ORIENTATION_SUD, TondeuseUtils.CODE_ORIENTATION_NORD),

	WEST(TondeuseUtils.CODE_ORIENTATION_WEST, TondeuseUtils.CODE_ORIENTATION_NORD, TondeuseUtils.CODE_ORIENTATION_SUD);

	private String orientation;

	private String orientationRight;

	private String orientationLeft;

	public String getOrientation() {
		return orientation;
	}

	public String getOrientationRight() {
		return orientationRight;
	}

	public String getOrientationLeft() {
		return orientationLeft;
	}

	private OrientationEnum(String orientation, String orientationRight,
			String orientationLeft) {
		this.orientation = orientation;
		this.orientationRight = orientationRight;
		this.orientationLeft = orientationLeft;
	}

	public static OrientationEnum getOrientationEnum(String orientation) {
		OrientationEnum orientationEnum = null;

		if (StringUtils.isNotEmpty(orientation)) {

			for (OrientationEnum enumeration : OrientationEnum.values()) {

				if (orientation.equals(enumeration.getOrientation())) {

					return enumeration;
				}
			}
		}

		return orientationEnum;
	}

	public static OrientationEnum getOrientationEnumRight(
			OrientationEnum orientationEnum) {

		OrientationEnum orientationRetour = null;

		if (orientationEnum != null) {

			String orientationRight = orientationEnum.getOrientationRight();

			orientationRetour = getOrientationEnum(orientationRight);

		}

		return orientationRetour;
	}

	public static OrientationEnum getOrientationEnumLeft(
			OrientationEnum orientationEnum) {

		OrientationEnum orientationRetour = null;

		if (orientationEnum != null) {

			String orientationLeft = orientationEnum.getOrientationLeft();

			orientationRetour = getOrientationEnum(orientationLeft);

		}

		return orientationRetour;
	}

}
