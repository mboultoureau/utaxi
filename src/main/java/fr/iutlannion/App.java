package fr.iutlannion;

import fr.iutlannion.auth.Admin;
import fr.iutlannion.database.Database;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    public void start(Stage primaryStage) {
        primaryStage = new Window();
        primaryStage.show();
    }

    public static void main(String[] args) {
        Database db = new Database();

        // Admin
        Admin manon = new Admin("Goasguen", "Manon", "manon@email.com", "manon");
        Admin ronan = new Admin("Renoux", "Ronan", "ronan@email.com", "ronan");
        Admin erwan = new Admin("Le Flot", "Erwan", "erwan@email.com", "erwan");
        Admin remi = new Admin("Bastille", "Rémi", "remi@email.com", "remi");
        Admin mathis = new Admin("Boultoureau", "Mathis", "mathis@email.com", "mathis");

        // Voitures

        System.out.println("Hello World!");
        launch();
    }
}
