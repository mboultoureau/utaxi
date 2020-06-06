package fr.iutlannion.dashboard;

import fr.iutlannion.core.Window;
import fr.iutlannion.manager.Conducteur;
import fr.iutlannion.manager.Conducteurs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import fr.iutlannion.map.MapOptions;
import fr.iutlannion.map.MapView;
import fr.iutlannion.map.Marker;
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

import fr.iutlannion.auth.PageConnexion;

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
	private Marker markerCurrentPosition = new Marker(47.211720, -1.560180);
	private Marker markerLocationWant = new Marker(47.214205, -1.538352);
	private Icon icon = new Icon("img/taxi.png", 40, 20);
	private Icon iconSelected = new Icon("img/taxiSelected.png", 40, 20);
	private Icon iconLocationCurrent = new Icon("img/pinCurrentLocation.png", 40, 20);
	private Icon iconLocation = new Icon("img/pinLocation.png", 40, 20);

	private ObservableList<Conducteur> conducteurs = FXCollections
			.observableArrayList(Conducteurs.getInstance().getListConducteur());
	private ListView<Conducteur> listViewConducteur = new ListView<Conducteur>(conducteurs);

	private Label ChoisirUtaxiLabel = new Label("Choisissez un Utaxi :");
	private Button commanderUtaxiButton = new Button("Commander le Utaxi");

	public PagePassager() {
		backButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Window.getInstance().gotoPage("connexion");
			}
		}));

		listViewConducteur.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				for (Conducteur c : Conducteurs.getInstance().getListConducteur()) {
					c.getMarker().setIcon(icon);
				}
				listViewConducteur.getSelectionModel().getSelectedItem().getMarker().setIcon(iconSelected);
				map.refresh();
			}
		});

		commanderUtaxiButton.setOnAction(e -> map.traceRoute(markerCurrentPosition, markerLocationWant));
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
		leftSide.add(ChoisirUtaxiLabel, 0, 0);
		leftSide.add(listViewConducteur, 0, 1);
		leftSide.add(commanderUtaxiButton, 0, 2, 1, 1);
		leftSide.setMinWidth(300);
		ChoisirUtaxiLabel.setStyle("-fx-font: 24 arial;");
		ChoisirUtaxiLabel.setPadding(new Insets(15, 0, 15, 0));

		listViewConducteur.setMinWidth(300);
		listViewConducteur.setMaxHeight(250);

		// Map
		mapOptions.setCoordinates(47.2186371, -1.5541362);
		mapOptions.setZoom(13);
		map = new MapView(mapOptions);

		for (Conducteur c : Conducteurs.getInstance().getListConducteur()) {
			map.addMarker(c.getMarker());
			c.getMarker().setIcon(icon);
		}

		map.addMarker(markerCurrentPosition);
		map.addMarker(markerLocationWant);

		mapOptions.setZoom(13);

		root.setTop(header);
		root.setRight(map);
		root.setLeft(leftSide);

		return root;

	}
}