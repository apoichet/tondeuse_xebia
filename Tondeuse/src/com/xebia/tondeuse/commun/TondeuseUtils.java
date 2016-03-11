package com.xebia.tondeuse.commun;

public class TondeuseUtils {

	public final static String SAUT_DE_LIGNE = "\r";

	public final static String MSG_EXCEPTION_NON_REPERTORIEE = "Exception non répertoriée";

	public final static String MSG_EXCEPTION_FORMAT_NOMBRE = "Exception non répertoriée";

	public final static String MSG_EXCEPTION_FICHIER = "Problème avec le fichier instruction : ";
	
	public static final String CODE_ORIENTATION_NORD = "N";
	
	public static final String CODE_ORIENTATION_SUD = "S";
	
	public static final String CODE_ORIENTATION_EST = "E";
	
	public static final String CODE_ORIENTATION_WEST = "W";

	public static final char CODE_AVANCER = 'A';

	public static final char CODE_DROITE = 'D';

	public static final char CODE_GAUCHE = 'G';

	public static final String MSG_COLISION = "Attention colision !";
	
	public static final String KEY_SURFACE = "Surface de jeu";

	public static final String KEY_COORDONNEE_1 = "Coordonne 1ère tondeuse";

	public static final String KEY_COORDONNEE_2 = "Coordonne 2ème tondeuse";

	public static final String INSTRUCTION_1 = "Instruction 1ère tondeuse";

	public static final String INSTRUCTION_2 = "Instruction 2ème tondeuse";

	public static final String NOM_FICHIER = "instructions.txt";

	public static final int LARGEUR_SURFACE_DEFAUT = 5;

	public static final int LONGUEUR_SURFACE_DEFAUT = 5;

	public static final String POSITION_X_DEFAUT = "0";

	public static final String POSITION_Y_DEFAUT = "0";

	public static final String ORIENTATION_DEFAUT = CODE_ORIENTATION_NORD;

	public static final int formatingCaractere(String lettre) {

		int retour = 0;

		try {

			retour = Integer.parseInt(lettre);

		} catch (NumberFormatException e) {

			throw new TondeuseException(1, lettre);

		}

		return retour;
	}

}
