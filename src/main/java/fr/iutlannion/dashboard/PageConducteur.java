package fr.iutlannion.dashboard;

import fr.iutlannion.core.Window;
import fr.iutlannion.map.MapOptions;
import fr.iutlannion.map.MapView;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PageConducteur extends Stage {

	private BorderPane root = new BorderPane();

	// Header
	private HBox header = new HBox();
	private Button backButton = new Button("Deconnexion");
    private Label title = new Label("Page Conducteur");
	private Label logo = new Label("UTaxi");

	// Left Side
	private GridPane leftSide = new GridPane();
	private Label soon = new Label("Prochainement");

	// Right Side
    private MapOptions mapOptions = new MapOptions();
	private MapView map;


	public PageConducteur() {

		backButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
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

		// Left Side
		leftSide.add(soon, 0, 0);
		leftSide.setMinWidth(300);

		// Map
        mapOptions.setCoordinates(47.2186371, -1.5541362);
        mapOptions.setZoom(13);
        map = new MapView(mapOptions);

		root.setTop(header);
		root.setRight(map);
		root.setLeft(leftSide);

		return root;

	}
}
