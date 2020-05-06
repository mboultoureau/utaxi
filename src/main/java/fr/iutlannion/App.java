package fr.iutlannion;

import java.util.ArrayList;

import fr.iutlannion.auth.Admin;
import fr.iutlannion.auth.Conducteur;
import fr.iutlannion.auth.Passager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class App extends Application
{
    @Override
    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Scene scene = new Scene(new StackPane(l), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main( String[] args )
    {
    	ArrayList<Admin> admins = new ArrayList<Admin>();
    	ArrayList<Conducteur> conducteurs = new ArrayList<Conducteur>();
    	ArrayList<Passager> passagers = new ArrayList<Passager>();
    	ArrayList<Voiture> voitures = new ArrayList<Voiture>();
    	
    	// Admins
    	Admin manon = new Admin("Goasguen", "Manon", "manon@email.com", "manon");
    	Admin ronan = new Admin("Renoux", "Ronan", "ronan@email.com", "ronan");
    	Admin erwan = new Admin("Le Flot", "Erwan", "erwan@email.com", "erwan");
    	Admin remi = new Admin("Bastille", "Rémi", "remi@email.com", "remi");
    	Admin mathis = new Admin("Boultoureau", "Mathis", "mathis@email.com", "mathis");
    	
    	admins.add(manon);
    	admins.add(ronan);
    	admins.add(erwan);
    	admins.add(remi);
    	admins.add(mathis);
    	
    	// Voitures
    	Voiture v1 = new Voiture("AA-111-AA", "Tesla", "Electrique", "Noir", "Sportive");
    	Voiture v2 = new Voiture("BB-222-BBB", "Peugeot", "Gazole", "Bleu", "Citadine");
    	Voiture v3 = new Voiture("CCC-333-CC", "Citroen", "SP95", "Blanc", "Citadine");
    	
    	voitures.add(v1);
    	voitures.add(v2);
    	voitures.add(v3);
    	
    	// Conducteurs
    	Conducteur c1 = new Conducteur("Dupond", "Georges", "georges@email.com", "georges", 10.2, 1000, v1);
    	Conducteur c2 = new Conducteur("Dupond", "Patrick", "patrick@email.com", "georges", 3.2, 10000, v2);
    	
    	conducteurs.add(c1);
    	conducteurs.add(c2);
    	
    	// Passagers
    	Passager p1 = new Passager("Balavoine", "Daniel", "daniel@email", "daniel");
    	Passager p2 = new Passager("Queen", "Lorde", "lorde@email.com", "lorde");
    	
    	passagers.add(p1);
    	passagers.add(p2);

        System.out.println( "Hello World!" );
        launch();
    }
}
