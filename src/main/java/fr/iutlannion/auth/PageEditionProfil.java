package fr.iutlannion.auth;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PageEditionProfil extends Stage {
	private GridPane gridPane = new GridPane();
	private Label salut = new Label("Salut");

	
	public PageEditionProfil() {
		
	}
	
	public Parent creerContenu() {
		
		gridPane.add(salut, 1, 1);
		
		return gridPane;
	}
}
