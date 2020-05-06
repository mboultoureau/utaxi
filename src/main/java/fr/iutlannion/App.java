package fr.iutlannion;

import fr.iutlannion.auth.Admin;
import fr.iutlannion.database.Database;
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
    	Database db = new Database();
    	
    	// Admin
    	Admin manon = new Admin("Goasguen", "Manon", "manon@email.com", "manon");
    	Admin ronan = new Admin("Renoux", "Ronan", "ronan@email.com", "ronan");
    	Admin erwan = new Admin("Le Flot", "Erwan", "erwan@email.com", "erwan");
    	Admin remi = new Admin("Bastille", "Rémi", "remi@email.com", "remi");
    	Admin mathis = new Admin("Boultoureau", "Mathis", "mathis@email.com", "mathis");
    	
    	// Voitures
    	
    	
    	
    	
    	
        System.out.println( "Hello World!" );
        launch();
    }
}
