package fr.iutlannion.auth;

import fr.iutlannion.core.Window;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import fr.iutlannion.manager.Conducteur;
import fr.iutlannion.manager.Utilisateurs;
import fr.iutlannion.manager.Jour;
import javafx.geometry.HPos;

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
	private ComboBox<Integer> lundiD;
	private ComboBox<Integer> lundiF;

	private Label mardi = new Label("Mardi");
	private ComboBox<Integer> mardiD;
	private ComboBox<Integer> mardiF;

	private Label mercredi = new Label("Mercredi");
	private ComboBox<Integer> mercrediD;
	private ComboBox<Integer> mercrediF;

	private Label jeudi = new Label("Jeudi");
	private ComboBox<Integer> jeudiD;
	private ComboBox<Integer> jeudiF;

	private Label vendredi = new Label("Vendredi");
	private ComboBox<Integer> vendrediD;
	private ComboBox<Integer> vendrediF;

	private Label samedi = new Label("Samedi");
	private ComboBox<Integer> samediD;
	private ComboBox<Integer> samediF;

	private Label dimanche = new Label("Dimanche");
	private ComboBox<Integer> dimancheD;
	private ComboBox<Integer> dimancheF;

	private Button annuler = new Button("Annuler");
	private Button endButton = new Button("Terminer");

	public PageHoraires() {

		backButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Window.getInstance().gotoPage("enregistrementVoiture");
			}
		}));

		annuler.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Window.getInstance().gotoPage("menuPrincipal");
			}
		}));

		endButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Conducteur c = (Conducteur) Utilisateurs.getPersonneCourante();

				Jour lundiJ = new Jour("Lundi", lundiD.getValue(), lundiF.getValue());
				Jour mardiJ = new Jour("Mardi", mardiD.getValue(), mardiF.getValue());
				Jour mercrediJ = new Jour("Mercredi", mercrediD.getValue(), mercrediF.getValue());
				Jour jeudiJ = new Jour("Jeudi", jeudiD.getValue(), jeudiF.getValue());
				Jour vendrediJ = new Jour("Vendredi", vendrediD.getValue(), vendrediF.getValue());
				Jour samediJ = new Jour("Samedi", samediD.getValue(), samediF.getValue());
				Jour dimancheJ = new Jour("Dimanche", dimancheD.getValue(), dimancheF.getValue());

				c.addJour(lundiJ);
				c.addJour(mardiJ);
				c.addJour(mercrediJ);
				c.addJour(jeudiJ);
				c.addJour(vendrediJ);
				c.addJour(samediJ);
				c.addJour(dimancheJ);

				Window.getInstance().gotoPage("connexion");
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

		// comboboxes
		lundiD = new ComboBox<Integer>();
		lundiD.getItems().addAll(7,8,9,10,11,12,13,14,15,16,17,18,19);
		lundiD.getSelectionModel().selectFirst();
		lundiD.setMinWidth(300);

		lundiF = new ComboBox<Integer>();
		lundiF.getItems().addAll(8,9,10,11,12,13,14,15,16,17,18,19,20);
		lundiF.getSelectionModel().selectLast();
		lundiF.setMinWidth(300);

		mardiD = new ComboBox<Integer>();
		mardiD.getItems().addAll(7,8,9,10,11,12,13,14,15,16,17,18,19);
		mardiD.getSelectionModel().selectFirst();
		mardiD.setMinWidth(300);

		mardiF = new ComboBox<Integer>();
		mardiF.getItems().addAll(8,9,10,11,12,13,14,15,16,17,18,19,20);
		mardiF.getSelectionModel().selectLast();
		mardiF.setMinWidth(300);

		mercrediD = new ComboBox<Integer>();
		mercrediD.getItems().addAll(7,8,9,10,11,12,13,14,15,16,17,18,19);
		mercrediD.getSelectionModel().selectFirst();
		mercrediD.setMinWidth(300);

		mercrediF = new ComboBox<Integer>();
		mercrediF.getItems().addAll(8,9,10,11,12,13,14,15,16,17,18,19,20);
		mercrediF.getSelectionModel().selectLast();
		mercrediF.setMinWidth(300);

		jeudiD = new ComboBox<Integer>();
		jeudiD.getItems().addAll(7,8,9,10,11,12,13,14,15,16,17,18,19);
		jeudiD.getSelectionModel().selectFirst();
		jeudiD.setMinWidth(300);

		jeudiF = new ComboBox<Integer>();
		jeudiF.getItems().addAll(8,9,10,11,12,13,14,15,16,17,18,19,20);
		jeudiF.getSelectionModel().selectLast();
		jeudiF.setMinWidth(300);

		vendrediD = new ComboBox<Integer>();
		vendrediD.getItems().addAll(7,8,9,10,11,12,13,14,15,16,17,18,19);
		vendrediD.getSelectionModel().selectFirst();
		vendrediD.setMinWidth(300);

		vendrediF = new ComboBox<Integer>();
		vendrediF.getItems().addAll(8,9,10,11,12,13,14,15,16,17,18,19,20);
		vendrediF.getSelectionModel().selectLast();
		vendrediF.setMinWidth(300);

		samediD = new ComboBox<Integer>();
		samediD.getItems().addAll(7,8,9,10,11,12,13,14,15,16,17,18,19);
		samediD.getSelectionModel().selectFirst();
		samediD.setMinWidth(300);

		samediF = new ComboBox<Integer>();
		samediF.getItems().addAll(8,9,10,11,12,13,14,15,16,17,18,19,20);
		samediF.getSelectionModel().selectLast();
		samediF.setMinWidth(300);

		dimancheD = new ComboBox<Integer>();
		dimancheD.getItems().addAll(7,8,9,10,11,12,13,14,15,16,17,18,19);
		dimancheD.getSelectionModel().selectFirst();
		dimancheD.setMinWidth(300);

		dimancheF = new ComboBox<Integer>();
		dimancheF.getItems().addAll(8,9,10,11,12,13,14,15,16,17,18,19,20);	
		dimancheF.getSelectionModel().selectLast();
		dimancheF.setMinWidth(300);	


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
		horaires.add(endButton, 2, 14);

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
