package fr.iutlannion.auth;

import fr.iutlannion.core.Window;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class PageHoraires extends Stage {

	private BorderPane root = new BorderPane();
	
	// Header
	private HBox header = new HBox();
	private Button backButton = new Button("Retour");
	private Label title = new Label("INSCRIPTION");
	private Label logo = new Label("UTaxi");

	//calendrier
	private GridPane calendar = new GridPane();

	TableView<String> table = new TableView<String>();
	TableColumn<String, String> hotairesCol = new TableColumn<String, String>("Horaires");
	TableColumn<String, String> lundi = new TableColumn<String, String>("Lundi");
	TableColumn<String, String> mardi = new TableColumn<String, String>("Mercredi");
	TableColumn<String, String> mercredi = new TableColumn<String, String>("Jeudi");
	TableColumn<String, String> jeudi = new TableColumn<String, String>("Vendredi");
	TableColumn<String, String> vendredi = new TableColumn<String, String>("Samedi");
	TableColumn<String, String> samedi = new TableColumn<String, String>("Dimanche");


	private Button annuler = new Button("Annuler");
	private Button buttonSuivant = new Button("Next");

	public PageHoraires() {

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

		calendar.add(annuler, 0, 9);
		calendar.add(buttonSuivant, 1, 9);

		GridPane.setHalignment(buttonSuivant, HPos.RIGHT);
		
		calendar.setPadding(new Insets(30, 30, 30, 30));
		calendar.setMinWidth(640);
		calendar.setHgap(30);
		calendar.setVgap(10);

		root.setTop(header);
		root.setCenter(calendar);
		
		return root;

	}
}