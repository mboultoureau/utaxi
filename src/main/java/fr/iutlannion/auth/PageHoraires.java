package fr.iutlannion.auth;

import java.util.spi.CalendarNameProvider;

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

public class PageHoraires extends Stage {

	private BorderPane root = new BorderPane();

	// Header
	private HBox header = new HBox();
	private Button backButton = new Button("Retour");
	private Label title = new Label("INSCRIPTION");
	private Label logo = new Label("UTaxi");

	// calendrier
	private GridPane calendar = new GridPane();

	private Button annuler = new Button("Annuler");
	private Button buttonSuivant = new Button("Next");

	// Tableau
	private TableView<String> horaires = new TableView<String>();
	private TableColumn<String, Boolean> heures = new TableColumn<String, Boolean>("Horaires");
	private TableColumn<String, Boolean> lundi = new TableColumn<String, Boolean>("Lundi");
	private TableColumn<String, Boolean> mardi = new TableColumn<String, Boolean>("Mardi");
	private TableColumn<String, Boolean> mercredi = new TableColumn<String, Boolean>("Mercredi");
	private TableColumn<String, Boolean> jeudi = new TableColumn<String, Boolean>("Jeudi");
	private TableColumn<String, Boolean> vendredi = new TableColumn<String, Boolean>("Vendredi");
	private TableColumn<String, Boolean> samedi = new TableColumn<String, Boolean>("Samedi");
	private TableColumn<String, Boolean> dimanche = new TableColumn<String, Boolean>("Dimanche");

	

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
		horaires.getColumns().addAll(heures, lundi, mardi, mercredi, jeudi, vendredi, samedi, dimanche);

		root.setTop(header);
		root.setCenter(horaires);

		return root;

	}
}
