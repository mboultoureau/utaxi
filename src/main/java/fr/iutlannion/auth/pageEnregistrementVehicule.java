package fr.iutlannion.auth;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class pageEnregistrementVehicule extends Stage {
	
	GridPane gridPane = new GridPane();

	private Label label1 = new Label();
	private Label label2 = new Label();
	
	public Parent creerContenu() {
		
		
		return gridPane;
	}
}
