package fr.iutlannion.core;

import fr.iutlannion.manager.Admin;
import fr.iutlannion.manager.Conducteur;
import fr.iutlannion.manager.Passager;

import java.util.Date;

import fr.iutlannion.manager.*;
import fr.iutlannion.map.LatLng;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Classe principale
 */
public class App extends Application {

	/**
	 * Active ou non le mode Debug (le bouton apparaîtra ou non sur le menu
	 * principal).
	 */
	public static final boolean DEBUG = true;

	/**
	 * Affiche l'interface graphique
	 * 
	 * @param primaryStage Le stage principale
	 */
	public void start(Stage primaryStage) {
		primaryStage = new Window();
		primaryStage.show();
	}

	/**
	 * Fonction principale, créé des données de tests et lance l'affichage graphique
	 * 
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		// Admins
		Admin manon = new Admin("Goasguen", "Manon", "manon@email.com", "manon");
		Admin ronan = new Admin("Renoux", "Ronan", "ronan@email.com", "ronan");
		Admin erwan = new Admin("Le Flot", "Erwan", "erwan@email.com", "erwan");
		Admin remi = new Admin("Bastille", "Rémi", "remi@email.com", "remi");
		Admin mathis = new Admin("Boultoureau", "Mathis", "mathis@email.com", "mathis");

		Utilisateurs.add(manon);
		Utilisateurs.add(ronan);
		Utilisateurs.add(erwan);
		Utilisateurs.add(remi);
		Utilisateurs.add(mathis);

		// Voitures
		Voiture v1 = new Voiture("AA-111-AA", "Tesla", "Electrique", "Noir", "Sportive");
		Voiture v2 = new Voiture("BB-222-BBB", "Peugeot", "Gazole", "Bleu", "Citadine");
		Voiture v3 = new Voiture("CCC-333-CC", "Citroen", "SP95", "Blanc", "Citadine");

		// Conducteurs
		Conducteur c1 = new Conducteur("Dupond", "Georges", "georges@email.com", "georges", 10.2, 1000, v1,
				new LatLng(47.219860, -1.545304));
		Conducteur c2 = new Conducteur("Dupond", "Patrick", "patrick@email.com", "patrick", 3.2, 10000, v2,
				new LatLng(47.219364, -1.556202));

		Utilisateurs.add(c1);
		Utilisateurs.add(c2);
		c1.ajouterNote(4.5);
		c1.ajouterNote(4.8);

		c2.ajouterNote(4.0);

		// Cartes bancaires des passagers
		CarteBancaire cb1 = new CarteBancaire("1111111111111111", "12/21", "000", "Daniel Balavoine");
		CarteBancaire cb2 = new CarteBancaire("2222333344445555", "09/21", "111", "Lorde Queen");

		// Localisations des passagers
		LatLng l1 = new LatLng(47.220829, -1.565942);
		LatLng l2 = new LatLng(47.213782, -1.554903);

		// Passagers
		Passager p1 = new Passager("Balavoine", "Daniel", "daniel@email.com", "daniel", l1, cb1);
		Passager p2 = new Passager("Queen", "Lorde", "lorde@email.com", "lorde", l2, cb2);

		Utilisateurs.add(p1);
		Utilisateurs.add(p2);

		// Tests purpose only
		Utilisateurs.setPersonneCourante(c2);

		launch();
	}
}
