package fr.iutlannion.auth;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PageEditionProfil extends Stage {
	GridPane gridPane = new GridPane();
	Label salut = new Label("Salut");
	
	public PageEditionProfil() {
		
	}
	
	public Parent creerContenu() {
		
		gridPane.getChildren().addAll(salut);
		
		return gridPane;
	}
}
