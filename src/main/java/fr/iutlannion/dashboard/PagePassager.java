package fr.iutlannion.dashboard;

import fr.iutlannion.core.Window;
import fr.iutlannion.manager.Conducteur;
import fr.iutlannion.manager.Conducteurs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import fr.iutlannion.map.MapOptions;
import fr.iutlannion.map.MapView;
import fr.iutlannion.map.Icon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PagePassager extends Stage {

	private BorderPane root = new BorderPane();

	// Header
	private HBox header = new HBox();
	private Button backButton = new Button("Deconnexion");
	private Label title = new Label("Page Passager");
	private Label logo = new Label("UTaxi");

	// Left Side
	private GridPane leftSide = new GridPane();

	// Right Side
	private MapOptions mapOptions = new MapOptions();
	private MapView map;
	private Icon icon = new Icon("img/taxi.png", 40, 20);

	private ObservableList<Conducteur> conducteurs = FXCollections
			.observableArrayList(Conducteurs.getInstance().getListConducteur());
	private ListView<Conducteur> listViewConducteur = new ListView<Conducteur>(conducteurs);

	public PagePassager() {

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
		leftSide.add(listViewConducteur, 0, 0, 1, 1);
		leftSide.setMinWidth(300);

		// Map
		mapOptions.setCoordinates(47.2186371, -1.5541362);
		mapOptions.setZoom(13);
		map = new MapView(mapOptions);

		for (Conducteur c : Conducteurs.getInstance().getListConducteur()) {
			map.addMarker(c.getMarker());
			c.getMarker().setIcon(icon);
		}

		root.setTop(header);
		root.setRight(map);
		root.setLeft(leftSide);

		return root;

	}
}