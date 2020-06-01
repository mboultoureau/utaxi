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
	private TableColumn<String, String> jours = new TableColumn<String, String>("Jours");
	private TableColumn<String, Boolean> sept = new TableColumn<String, Boolean>("7h-8h");
	private TableColumn<String, Boolean> huit = new TableColumn<String, Boolean>("8h-9h");
	private TableColumn<String, Boolean> neuf = new TableColumn<String, Boolean>("9h-10h");
	private TableColumn<String, Boolean> dix = new TableColumn<String, Boolean>("10h-11h");
	private TableColumn<String, Boolean> onze = new TableColumn<String, Boolean>("11h-12h");
	private TableColumn<String, Boolean> midi = new TableColumn<String, Boolean>("12h-13h");
	private TableColumn<String, Boolean> treize = new TableColumn<String, Boolean>("13h-14h");
	private TableColumn<String, Boolean> quatorze = new TableColumn<String, Boolean>("14h-15h");
	private TableColumn<String, Boolean> quinze = new TableColumn<String, Boolean>("15h-16h");
	private TableColumn<String, Boolean> seize = new TableColumn<String, Boolean>("16h-17h");
	private TableColumn<String, Boolean> dixsept = new TableColumn<String, Boolean>("17h-18h");
	private TableColumn<String, Boolean> dixhuit = new TableColumn<String, Boolean>("18h-19h");
	private TableColumn<String, Boolean> dixneuf = new TableColumn<String, Boolean>("19h-20h");

	

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
		horaires.getColumns().addAll(heures, sept, huit, neuf, dix, onze, midi, treize, quatorze, quinze, seize, dixsept, dixhuit, dixneuf);

		root.setTop(header);
		root.setCenter(horaires);

		return root;

	}
}
