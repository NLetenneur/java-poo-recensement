package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.Application;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.utils.SaisieException;

/**
 * Recherche et affichage de toutes les villes d'un département dont la
 * population est comprise entre une valeur min et une valeur max renseignées
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService  extends MenuService  {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws SaisieException {

		System.out.println("Quel est le code du département recherché ? ");
		String choix = scanner.nextLine();

		System.out.println("Choississez une population minimum (en milliers d'habitants): ");
		String saisieMin = scanner.nextLine();

		System.out.println("Choississez une population maximum (en milliers d'habitants): ");
		String saisieMax = scanner.nextLine();

		// Initialisation du booléen qui décide si on lance la recherche ou pas
		Boolean erreurSaisie = false;

		// tester la saisie du nombre min
		int min = 0;
		try {
			min = Integer.parseInt(saisieMin) * 1000;
		} catch (Exception e) {
			System.out.println("Vous devez saisir un chiffre comme population minimale");
			erreurSaisie = true;
		}

		// tester la saisie du nombre max
		int max = 100000;
		try {
			max = Integer.parseInt(saisieMax) * 1000;
		} catch (Exception e) {
			System.out.println("Vous devez saisir un chiffre comme population maximale");
			erreurSaisie = true;
		}

		// tester si max est inférieur à min
		if (max < min) {
			System.out.println("Vous devez saisir une population maximale suppérieure à la population minimale");
			erreurSaisie = true;
		}

		if (erreurSaisie == false) {
			List<Ville> villes = rec.getVilles();
			for (Ville ville : villes) {
				if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
					if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
						System.out.println(ville);
					}
				}
			}
		}else {
			throw new SaisieException("Veuillez refaire votre saisie");
		}
	}

}
