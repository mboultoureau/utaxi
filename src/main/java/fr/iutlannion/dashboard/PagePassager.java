package fr.iutlannion.dashboard;

import java.util.Timer;
import java.util.TimerTask;

import fr.iutlannion.core.Window;
import fr.iutlannion.manager.*;
import fr.iutlannion.map.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
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

	Passager user = (Passager) Utilisateurs.getPersonneCourante();

	// Header
	private HBox header = new HBox();
	private Button backButton = new Button("Deconnexion");
	private Label title = new Label("Page Passager - Bienvenue " + Utilisateurs.getPersonneCourante().getPrenom());
	private Label logo = new Label("UTaxi");

	// Left Side
	private GridPane leftSide = new GridPane();

	// Right Side
	private MapOptions mapOptions = new MapOptions();
	private MapView map;
	private Marker markerCurrentPosition = new Marker(user.getMarker().getCoords());
	// Mettre la location du passager courant
	private Marker markerLocationWant = new Marker(new LatLng(0, 0));
	private Icon icon = new Icon("img/taxi.png", 40, 20);
	private Icon iconSelected = new Icon("img/taxi-selected.png", 40, 20);

	// https://github.com/pointhi/leaflet-color-markers
	private Icon iconHome = new Icon("img/iconHome.png", 25, 41, 12, 41, 1, -34);

	private ObservableList<Conducteur> conducteurs = FXCollections
			.observableArrayList(Utilisateurs.getListConducteur());
	private ListView<Conducteur> listViewConducteur = new ListView<Conducteur>(conducteurs);

	private Label ChoisirUtaxiLabel = new Label("Choisissez un Utaxi :");
	private Label ChoisirCoordLabel = new Label("Choisissez où vous voulez aller :");
	private Label infoSituation = new Label("");
	private Button Annuler = new Button("Annuler");
	private Button commanderUtaxiButton = new Button("Commander le Utaxi");
	// Geocoding pour récuperer l'adresse en lat/long avec une API
	private AdresseView adresseView = new AdresseView();

	public PagePassager() {
		backButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Window.getInstance().gotoPage("connexion");
			}
		}));

		listViewConducteur.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				for (Conducteur c : Utilisateurs.getListConducteur()) {
					c.getMarker().setIcon(icon);
				}
				listViewConducteur.getSelectionModel().getSelectedItem().getMarker().setIcon(iconSelected);
				map.refresh();
			}
		});

		adresseView.getOKButton().setOnAction(e -> confirmAdresse());

		Annuler.setOnMouseClicked(e -> {
			Adresse adresse = adresseView.getAdresse();
			adresseView.enable();
			map.moveMarker(markerLocationWant, new LatLng(0, 0));
			commanderUtaxiButton.setDisable(true);
			Annuler.setDisable(true);
		});

		commanderUtaxiButton.setOnAction(e -> {

			map.disableRouting();
			Annuler.setDisable(true);
			Adresse adresse = adresseView.getAdresse();
			map.moveMarker(markerLocationWant, adresse.getCoords());
			map.traceRoute(markerCurrentPosition, markerLocationWant);
			infoSituation.setText("Le Utaxi viens vous chercher...");
			commanderUtaxiButton.setDisable(true);
			listViewConducteur.setMouseTransparent(true);
			listViewConducteur.setFocusTraversable(false);

			Timer myTimer = new Timer();
			myTimer.schedule(new TimerTask() {
				@Override
				public void run() {
					Platform.runLater(() -> {
						infoSituation.setText("Votre Utaxi est arrivé, vous pouvez monter");
						map.moveMarker(listViewConducteur.getSelectionModel().getSelectedItem().getMarker(),
								user.getMarker().getCoords());
					});

				}
			}, 8000);

			myTimer.schedule(new TimerTask() {
				@Override
				public void run() {
					Platform.runLater(() -> {
						infoSituation.setText("Trajet en cours...");

					});

				}
			}, 16000);

			myTimer.schedule(new TimerTask() {
				@Override
				public void run() {
					Platform.runLater(() -> {
						infoSituation.setText("Arrivé à destination !");
						map.disableRouting();
						Adresse adresse = adresseView.getAdresse();
						map.moveMarker(listViewConducteur.getSelectionModel().getSelectedItem().getMarker(),
								adresse.getCoords());
						map.moveMarker(markerCurrentPosition, adresse.getCoords());
						user.getMarker().setPosition(adresse.getCoords());
						listViewConducteur.setMouseTransparent(false);
						listViewConducteur.setFocusTraversable(true);
						adresseView.enable();
						map.moveMarker(markerLocationWant, new LatLng(0, 0));
					});

				}
			}, 30000);

		});
	}

	private void confirmAdresse() {
		Adresse adresse = adresseView.getAdresse();
		if (adresse != null) {
			adresseView.disable();
			map.moveMarker(markerLocationWant, adresse.getCoords());
			commanderUtaxiButton.setDisable(false);
			Annuler.setDisable(false);
		}
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
		leftSide.add(adresseView, 0, 3);
		leftSide.add(Annuler, 0, 4);
		leftSide.add(commanderUtaxiButton, 0, 4);
		leftSide.add(infoSituation, 0, 6, 1, 1);
		leftSide.setMinWidth(300);
		infoSituation.setStyle("-fx-font: 16 arial;");
		ChoisirUtaxiLabel.setStyle("-fx-font: 24 arial;");
		ChoisirUtaxiLabel.setPadding(new Insets(15, 0, 15, 0));
		ChoisirCoordLabel.setStyle("-fx-font: 24 arial;");
		ChoisirCoordLabel.setPadding(new Insets(15, 0, 15, 0));

		listViewConducteur.setMinWidth(300);
		listViewConducteur.setMaxHeight(250);
		GridPane.setHalignment(commanderUtaxiButton, HPos.CENTER);
		GridPane.setHalignment(infoSituation, HPos.CENTER);
		commanderUtaxiButton.setDisable(true);
		Annuler.setDisable(true);

		// Map
		mapOptions.setCoordinates(new LatLng(47.2186371, -1.5541362));
		mapOptions.setZoom(13);
		map = new MapView(mapOptions);

		for (Conducteur c : Utilisateurs.getListConducteur()) {
			map.addMarker(c.getMarker());
			c.getMarker().setIcon(icon);
		}

		map.addMarker(markerCurrentPosition);
		map.addMarker(markerLocationWant);
		markerCurrentPosition.setIcon(iconHome);
		listViewConducteur.getSelectionModel().select(0);

		mapOptions.setZoom(13);

		root.setTop(header);
		root.setRight(map);
		root.setLeft(leftSide);

		return root;

	}
}