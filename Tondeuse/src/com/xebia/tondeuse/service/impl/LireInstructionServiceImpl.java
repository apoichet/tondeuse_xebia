package com.xebia.tondeuse.service.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.xebia.tondeuse.commun.TondeuseException;
import com.xebia.tondeuse.commun.TondeuseUtils;
import com.xebia.tondeuse.service.LireInstructionService;

public class LireInstructionServiceImpl implements LireInstructionService {

	@Override
	public Map<String, String> lireFichierInstruction(String nomFichier) {

		Map<String, String> mapInstructions = new HashMap<>();

		try {

			InputStream ips = new FileInputStream(nomFichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;

			while ((ligne = br.readLine()) != null) {

				ligne = StringUtils.strip(ligne);

				ligne = StringUtils.upperCase(ligne);

				ligne = StringUtils.replace(ligne, StringUtils.SPACE,
						StringUtils.EMPTY);

				if (ligne.length() == 2 && isContainNumber(ligne)) {

					mapInstructions.putIfAbsent(TondeuseUtils.KEY_SURFACE, ligne);

				} else if (ligne.length() == 3 && isContainNumber(ligne)) {

					if (mapInstructions.containsKey(TondeuseUtils.KEY_COORDONNEE_1)) {

						mapInstructions.putIfAbsent(TondeuseUtils.KEY_COORDONNEE_2, ligne);

					} else {

						mapInstructions.put(TondeuseUtils.KEY_COORDONNEE_1, ligne);

					}

				} else if (StringUtils.isNotEmpty(ligne)) {

					if (mapInstructions.containsKey(TondeuseUtils.INSTRUCTION_1)) {

						mapInstructions.putIfAbsent(TondeuseUtils.INSTRUCTION_2, ligne);

					} else {

						mapInstructions.put(TondeuseUtils.INSTRUCTION_1, ligne);

					}
				}
			}

			br.close();
		} catch (Exception e) {

			throw new TondeuseException(1, "fichier ilisible ou introuvable");

		}

		return mapInstructions;
	}

	@Override
	public int[] getTailleSurface(String ligneFichier) {
		int[] tabTailleSurface = {TondeuseUtils.LARGEUR_SURFACE_DEFAUT,
				TondeuseUtils.LONGUEUR_SURFACE_DEFAUT };// Par défaut

		if (StringUtils.isNotEmpty(ligneFichier)) {
			String tabStr[] = ligneFichier.split(StringUtils.EMPTY);

			if (tabStr.length == 2) {

				tabTailleSurface[0] = TondeuseUtils.formatingCaractere(tabStr[0]);
				tabTailleSurface[1] = TondeuseUtils.formatingCaractere(tabStr[1]);
				
			}

		}

		return tabTailleSurface;
	}

	@Override
	public String[] getPositionOrientationTondeuse(String ligneFichier) {
		String[] tabCoordonnee = { TondeuseUtils.POSITION_X_DEFAUT, TondeuseUtils.POSITION_Y_DEFAUT,
				TondeuseUtils.ORIENTATION_DEFAUT };// Par défaut

		if (StringUtils.isNotEmpty(ligneFichier)) {
			char tabChar[] = ligneFichier.toCharArray();

			if (tabChar.length == 3) {
				
				tabCoordonnee[0] = Character.toString(tabChar[0]);
				tabCoordonnee[1] = Character.toString(tabChar[1]);
				tabCoordonnee[2] = Character.toString(tabChar[2]);

			}

		}

		return tabCoordonnee;
	}

	@Override
	public String getInstruction(String ligneFichier) {
		return ligneFichier;
	}
	
	protected boolean isContainNumber(String chaine){
		char tabChar[] = chaine.toCharArray();
		boolean presenceNumber = false;
		
		for (char c : tabChar) {
			
			if (Character.isDigit(c)) {
				
				presenceNumber = true;
				
			}
			
		}
		
		return presenceNumber;
	}

}
