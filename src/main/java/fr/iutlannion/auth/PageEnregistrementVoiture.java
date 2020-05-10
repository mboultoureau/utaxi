package fr.iutlannion.auth;

import fr.iutlannion.core.Window;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class PageEnregistrementVoiture extends Stage {

	private BorderPane root = new BorderPane();
	
	// Header
	private HBox header = new HBox();
	private Button backButton = new Button("Retour");
	private Label title = new Label("INSCRIPTION");
	private Label logo = new Label("UTaxi");

	//informations voiture
	private GridPane voiture = new GridPane();
	private Label imat = new Label("Immatriculation");
	private TextField fimat = new TextField();
	private Label marque = new Label("Marque");
	private TextField fmarque = new TextField();
	private Label tEss = new Label("Type Essence");
	private TextField ftEss = new TextField();
	private Label couleur = new Label("Couleur");
	private TextField fcouleur = new TextField();
	private Label type = new Label("Type");
	private TextField ftype = new TextField();
	private Button buttonSuivant = new Button("Next");

	public PageEnregistrementVoiture() {

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
		backButton.setStyle("-fx-background-color: #000; -fx-text-fill: #fff; -fx-border-color: #fff; -fx-border-width: 2;");
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

		voiture.add(imat, 0, 0);
		voiture.add(fimat, 0, 1);
		voiture.add(marque, 0, 2);
		voiture.add(fmarque, 0, 3);
		voiture.add(tEss, 0, 4);
		voiture.add(ftEss, 0, 5);
		voiture.add(type, 0, 6);
		voiture.add(ftype, 0, 7);
		voiture.add(buttonSuivant, 1, 9);

		GridPane.setHalignment(buttonSuivant, HPos.RIGHT);
		
		voiture.setPadding(new Insets(30, 30, 30, 30));
		voiture.setMinWidth(640);
		voiture.setHgap(30);
		voiture.setVgap(10);
		GridPane.setHgrow(imat, Priority.ALWAYS);

		root.setTop(header);
		root.setCenter(voiture);
		
		return root;

	}
}
