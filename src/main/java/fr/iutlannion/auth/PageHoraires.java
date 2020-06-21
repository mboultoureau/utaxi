package fr.iutlannion.auth;

import fr.iutlannion.core.Window;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;

public class PageHoraires extends Stage {

	private BorderPane root = new BorderPane();

	// Header
	private HBox header = new HBox();
	private Button backButton = new Button("Retour");
	private Label title = new Label("INSCRIPTION");
	private Label logo = new Label("UTaxi");

	// horaies
	private GridPane horaires = new GridPane();

	private Label lundi = new Label("Lundi");
	private ComboBox<int> lundiD;
	private ComboBox<int> lundiF;

	private Label mardi = new Label("Mardi");
	private ComboBox<int> mardiD;
	private ComboBox<int> mardiF;

	private Label mercredi = new Label("Mercredi");
	private ComboBox<int> mercrediD;
	private ComboBox<int> mercrediF;

	private Label jeudi = new Label("Jeudi");
	private ComboBox<int> jeudiD;
	private ComboBox<int> jeudiF;

	private Label vendredi = new Label("Vendredi");
	private ComboBox<int> vendrediD;
	private ComboBox<int> vendrediF;

	private Label samedi = new Label("Samedi");
	private ComboBox<int> samediD;
	private ComboBox<int> samediF;

	private Label dimanche = new Label("Dimanche");
	private ComboBox<int> dimancheD;
	private ComboBox<int> dimancheF;
	

	private Button annuler = new Button("Annuler");
	private Button endButton = new Button("Terminer");

	

	public PageHoraires() {

		backButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Window.getInstance().gotoPage("menuPrincipal");
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

		//comboboxes
		lundiD = new ComboBox<int>();
		lundiD.getItems().addAll(7,8,9,10,11,12,13,14,15,16,17,18,19);

		lundiF = new ComboBox<int>();
		lundiF.getItems().addAll(8,9,10,11,12,13,14,15,16,17,18,19,20);

		mardiD = new ComboBox<int>();
		mardiD.getItems().addAll(7,8,9,10,11,12,13,14,15,16,17,18,19);

		mardiF = new ComboBox<int>();
		mardiF.getItems().addAll(8,9,10,11,12,13,14,15,16,17,18,19,20);

		mercrediD = new ComboBox<int>();
		mercrediD.getItems().addAll(7,8,9,10,11,12,13,14,15,16,17,18,19);

		mercrediF = new ComboBox<int>();
		mercrediF.getItems().addAll(8,9,10,11,12,13,14,15,16,17,18,19,20);

		jeudiD = new ComboBox<int>();
		jeudiD.getItems().addAll(7,8,9,10,11,12,13,14,15,16,17,18,19);

		jeudiF = new ComboBox<int>();
		jeudiF.getItems().addAll(8,9,10,11,12,13,14,15,16,17,18,19,20);

		vendrediD = new ComboBox<int>();
		vendrediD.getItems().addAll(7,8,9,10,11,12,13,14,15,16,17,18,19);

		vendrediF = new ComboBox<int>();
		vendrediF.getItems().addAll(8,9,10,11,12,13,14,15,16,17,18,19,20);

		samediD = new ComboBox<int>();
		lundiD.getItems().addAll(7,8,9,10,11,12,13,14,15,16,17,18,19);

		samediF = new ComboBox<int>();
		lundiF.getItems().addAll(8,9,10,11,12,13,14,15,16,17,18,19,20);

		dimancheD = new ComboBox<int>();
		lundiD.getItems().addAll(7,8,9,10,11,12,13,14,15,16,17,18,19);

		dimancheF = new ComboBox<int>();
		lundiF.getItems().addAll(8,9,10,11,12,13,14,15,16,17,18,19,20);		

		horaires.add(lundi, 0, 0);
		horaires.add(lundiD, 0, 1);
		horaires.add(lundiF, 2, 1);

		horaires.add(mardi, 0, 2);
		horaires.add(mardiD, 0, 3);
		horaires.add(mardiF, 2, 3);

		horaires.add(mercredi, 0, 4);
		horaires.add(mercrediD, 0, 5);
		horaires.add(mercrediF, 2, 5);

		horaires.add(jeudi, 0, 6);
		horaires.add(jeudiD, 0, 7);
		horaires.add(jeudiF, 2, 7);

		horaires.add(vendredi, 0, 8);
		horaires.add(vendrediD, 0, 9);
		horaires.add(vendrediF, 2, 9);

		horaires.add(samedi, 0, 10);
		horaires.add(samediD, 0, 11);
		horaires.add(samediF, 2, 11);

		horaires.add(dimanche, 0, 12);
		horaires.add(dimancheD, 0, 13);
		horaires.add(dimancheF, 2, 13);

		horaires.add(annuler, 0, 14);
		horaires.add(endButton, 1, 14);

		GridPane.setHalignment(endButton, HPos.RIGHT);

		horaires.setPadding(new Insets(30, 30, 30, 30));
		horaires.setMinWidth(640);
		horaires.setHgap(30);
		horaires.setVgap(10);
		GridPane.setHgrow(lundi, Priority.ALWAYS);

		root.setTop(header);
		root.setCenter(horaires);

		return root;

	}
}
