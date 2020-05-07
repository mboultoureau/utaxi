package fr.iutlannion.core;

import fr.iutlannion.auth.Admin;
import fr.iutlannion.auth.Conducteur;
import fr.iutlannion.auth.Passager;
import fr.iutlannion.manager.Admins;
import fr.iutlannion.manager.Conducteurs;
import fr.iutlannion.manager.Passagers;
import fr.iutlannion.manager.Voitures;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
	public void start(Stage primaryStage) {
		primaryStage = new Window();
		primaryStage.show();
	}

	public static void main(String[] args) {
		// Admins
		Admin manon = new Admin("Goasguen", "Manon", "manon@email.com", "manon");
		Admin ronan = new Admin("Renoux", "Ronan", "ronan@email.com", "ronan");
		Admin erwan = new Admin("Le Flot", "Erwan", "erwan@email.com", "erwan");
		Admin remi = new Admin("Bastille", "Rémi", "remi@email.com", "remi");
		Admin mathis = new Admin("Boultoureau", "Mathis", "mathis@email.com", "mathis");

		Admins.getInstance().add(manon);
		Admins.getInstance().add(ronan);
		Admins.getInstance().add(erwan);
		Admins.getInstance().add(remi);
		Admins.getInstance().add(mathis);

		// Voitures
		Voiture v1 = new Voiture("AA-111-AA", "Tesla", "Electrique", "Noir", "Sportive");
		Voiture v2 = new Voiture("BB-222-BBB", "Peugeot", "Gazole", "Bleu", "Citadine");
		Voiture v3 = new Voiture("CCC-333-CC", "Citroen", "SP95", "Blanc", "Citadine");

		Voitures.getInstance().add(v1);
		Voitures.getInstance().add(v2);
		Voitures.getInstance().add(v3);

		// Conducteurs
		Conducteur c1 = new Conducteur("Dupond", "Georges", "georges@email.com", "georges", 10.2, 1000, v1);
		Conducteur c2 = new Conducteur("Dupond", "Patrick", "patrick@email.com", "georges", 3.2, 10000, v2);

		Conducteurs.getInstance().add(c1);
		Conducteurs.getInstance().add(c2);

		// Passagers
		Passager p1 = new Passager("Balavoine", "Daniel", "daniel@email", "daniel");
		Passager p2 = new Passager("Queen", "Lorde", "lorde@email.com", "lorde");

		Passagers.getInstance().add(p1);
		Passagers.getInstance().add(p2);

		launch();
	}
}
