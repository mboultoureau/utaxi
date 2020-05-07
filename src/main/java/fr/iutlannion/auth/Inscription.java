package fr.iutlannion.auth;

import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Inscription extends Stage {

	GridPane gridPane = new GridPane();

	public Inscription() {

	}

	public Parent creerContenu() {

		return gridPane;
	}
}
