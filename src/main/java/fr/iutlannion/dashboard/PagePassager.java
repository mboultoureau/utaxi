package fr.iutlannion.dashboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;

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
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
	private Marker markerCurrentPosition = new Marker(47.211720, -1.560180);
	// Mettre la location du passager courant
	private Marker markerLocationWant = new Marker(47.228752, -1.541096);
	private Icon icon = new Icon("img/taxi.png", 40, 20);
	private Icon iconSelected = new Icon("img/taxiSelected.png", 40, 20);

	private ObservableList<Conducteur> conducteurs = FXCollections
			.observableArrayList(Conducteurs.getInstance().getListConducteur());
	private ListView<Conducteur> listViewConducteur = new ListView<Conducteur>(conducteurs);

	private Label ChoisirUtaxiLabel = new Label("Choisissez un Utaxi :");
	private Label ChoisirCoordLabel = new Label("Choisissez où vous voulez aller :");
	private Label infoSituation = new Label("");
	private Button commanderUtaxiButton = new Button("Commander le Utaxi");
	// Besoin de Geocoding pour récuperer l'adresse en lat/long
	private TextField xField = new TextField("47.228752");
	private TextField yField = new TextField("-1.541096");
	

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

		commanderUtaxiButton.setOnAction(e -> {

			map.disableRouting();
			map.moveMarker(markerLocationWant, Double.parseDouble(xField.getText()),
					Double.parseDouble(yField.getText()));
			map.traceRoute(markerCurrentPosition, markerLocationWant);
			infoSituation.setText("Le Utaxi viens vous chercher...");
			commanderUtaxiButton.setDisable(true);
			long startTime = System.currentTimeMillis();
			long elapsedTime = 0L;

			while (elapsedTime < 1*5*1000) {
				elapsedTime = (new Date()).getTime() - startTime;
				
			}
			infoSituation.setText("OMW Votre taxi est arrivé");
		});
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
		leftSide.setVgap(15);
		leftSide.add(ChoisirUtaxiLabel, 0, 0);
		leftSide.add(listViewConducteur, 0, 1);
		leftSide.add(ChoisirCoordLabel, 0, 2);
		leftSide.add(xField, 0, 3);
		leftSide.add(yField, 0, 3);
		leftSide.add(commanderUtaxiButton, 0, 4);
		leftSide.add(infoSituation, 0, 5);
		leftSide.setMinWidth(300);
		infoSituation.setStyle("-fx-font: 16 arial;");
		ChoisirUtaxiLabel.setStyle("-fx-font: 24 arial;");
		ChoisirUtaxiLabel.setPadding(new Insets(15, 0, 15, 0));
		ChoisirCoordLabel.setStyle("-fx-font: 24 arial;");
		ChoisirCoordLabel.setPadding(new Insets(15, 0, 15, 0));

		listViewConducteur.setMinWidth(300);
		listViewConducteur.setMaxHeight(250);
		xField.setMaxWidth(160);
		yField.setMaxWidth(160);
		GridPane.setHalignment(yField, HPos.RIGHT);
		GridPane.setHalignment(commanderUtaxiButton, HPos.CENTER);

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