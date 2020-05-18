package fr.iutlannion.auth;

import fr.iutlannion.core.Window;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PagePaiement extends Stage {

	
	private BorderPane root = new BorderPane();
	
	// Header
	private HBox header = new HBox();
	private Button backButton = new Button("Retour");
	private Label title = new Label("INFORMATIONS DE PAIEMENT");
	private Label logo = new Label("UTaxi");
	
	// Informations de Paiement
	GridPane grid = new GridPane();
	private Label num = new Label("Numéro de la carte");
	private TextField numField = new TextField();
	private Label expiration = new Label("Date d'expiration");
	private TextField expirationField = new TextField();
	private Label cvc = new Label("CVC");
	private TextField cvcField = new TextField();
	private Label name = new Label("Nom inscrit sur la carte");
	private TextField nameField = new TextField();
	
	public PagePaiement() {
		// Événements
		backButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Window.getInstance().gotoPage("mainMenu");
			}
		}));
	}
	
	
	public Parent creerContenu() {

		// Header
		header.setMinWidth(640);
		header.setPadding(new Insets(0, 20, 0, 20));

		header.setPrefHeight(50);
		header.setStyle("-fx-background-color: #000;");
		header.setAlignment(Pos.CENTER);

		// Back
		backButton.setStyle(
				"-fx-background-color: #000; -fx-text-fill: #fff; -fx-border-color: #fff; -fx-border-width: 2;");
		backButton.setAlignment(Pos.CENTER_LEFT);

		// Title
		title.setStyle("-fx-text-fill: #fff;");
		title.setAlignment(Pos.CENTER);
		title.setFont(new Font("Arial", 20));
		title.setMaxWidth(Double.MAX_VALUE);
		HBox.setHgrow(title, Priority.ALWAYS);

		// Logo
		logo.setStyle("-fx-text-fill: #fff;");
		logo.setAlignment(Pos.CENTER_RIGHT);

		header.getChildren().addAll(backButton, title, logo);
		
		
		// Informations de paiement
		grid.add(num, 0, 0);
		grid.add(numField, 0, 1);
		grid.add(expiration, 0, 2);
		grid.add(expirationField, 0, 3);
		grid.add(cvc, 0, 4);
		grid.add(cvcField, 0, 5);
		grid.add(name, 0, 6);
		grid.add(nameField, 0, 7);
		
		
		root.setMinHeight(480);
		root.setMinWidth(640);
		root.setTop(header);
		root.setCenter(grid);
		return root;
	}
	
}
