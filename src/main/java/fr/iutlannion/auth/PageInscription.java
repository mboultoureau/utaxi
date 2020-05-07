package fr.iutlannion.auth;

import fr.iutlannion.core.Window;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PageInscription extends Stage {

	private GridPane gridPane = new GridPane();
	
	private Label labelLastName = new Label("Nom");
	private TextField fieldLastName = new TextField();
	
	private Label labelFirstName = new Label("Prénom");
	private TextField fieldFirstName = new TextField();
	
	private Label labelEmail = new Label("Email");
	private TextField fieldEmail = new TextField();

	public PageInscription() {

	}

	public Parent creerContenu() {
		
		Window.getInstance().setTitle("Inscription");
		Window.getInstance().setMinHeight(480);
		Window.getInstance().setMinWidth(640);
		

		
		gridPane.add(labelLastName, 1, 2);
		gridPane.add(labelLastName, 1, 2);

		gridPane.add(labelLastName, 1, 2);
		gridPane.add(labelLastName, 1, 2);

		gridPane.add(labelLastName, 1, 2);
		gridPane.add(labelLastName, 1, 2);

		
		return gridPane;
	}
}
