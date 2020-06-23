package fr.iutlannion.dashboard;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

import fr.iutlannion.core.Window;
import fr.iutlannion.manager.*;
import fr.iutlannion.map.*;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * Classe de la page passager avec la map des Utaxi, la possibilité de commander
 * un Utaxi et modifier son compte
 */

public class PagePassager extends Stage {

	private BorderPane root = new BorderPane();

	Passager user = (Passager) Utilisateurs.getPersonneCourante();

	// Header
	private HBox header = new HBox();
	private Button backButton = new Button("Deconnexion");
	private Label title = new Label("Bienvenue " + Utilisateurs.getPersonneCourante().getPrenom());
	private final ObservableList<String> options = FXCollections.observableArrayList("Tableau de bord",
			"Édition de profil");
	private final ComboBox selectionPage = new ComboBox(options);

	// Left Side
	private GridPane leftSide = new GridPane();

	// Right Side
	private MapOptions mapOptions = new MapOptions();
	private MapView map;
	private Marker markerCurrentPosition = new Marker(user.getMarker().getCoords());
	private Marker markerLocationWant = new Marker(new LatLng(0, 0));
	private Icon icon = new Icon("img/taxi.png", 40, 20);
	private Icon iconSelected = new Icon("img/taxi-selected.png", 40, 20);

	// https://github.com/pointhi/leaflet-color-markers
	private Icon iconHome = new Icon("img/icon-home.png", 25, 41, 12, 41, 1, -34);

	private ObservableList<Conducteur> conducteurs = FXCollections
			.observableArrayList(Utilisateurs.getListConducteur());
	private ListView<Conducteur> listViewConducteur = new ListView<Conducteur>(conducteurs);

	private Label choisirUtaxiLabel = new Label("Choisissez un Utaxi :");
	private Label choisirCoordLabel = new Label("Choisissez où vous voulez aller :");
	private Label infoSituation = new Label("");
	private Button annuler = new Button("Annuler");
	private Button moveTaxi = new Button("Déplacer les Utaxi");
	private Button commanderUtaxiButton = new Button("Commander le Utaxi");
	// Geocoding pour récuperer l'adresse en lat/long avec une API
	private AdresseView adresseView = new AdresseView();

	public PagePassager() {

		Window.getInstance().setMinWidth(1200);
		Window.getInstance().setMaxWidth(3000);
		Window.getInstance().setWidth(1200);

		Window.getInstance().setMinHeight(700);
		Window.getInstance().setMaxHeight(2000);
		Window.getInstance().setHeight(700);

		/**
		 * Événement sur le bouton "Deconnexion" pour se déconnecter de son compte
		 */
		backButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Window.getInstance().gotoPage("connexion");
			}
		}));

		/**
		 * Gestion des 2 onglets : "Tableau de bord" et "Édition de profil"
		 */
		selectionPage.setValue("Tableau de bord");

		selectionPage.valueProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				switch (newValue.toString()) {
					case "Édition de profil":
						Window.getInstance().gotoPage("editionProfil");
						break;
				}
			}
		});

		/**
		 * Événement sur la liste des conducteurs Utaxi afin de les visualiser sur la
		 * map
		 */
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

		/**
		 * Événement sur le bouton "Ok" pour confirmer l'adresse
		 */

		adresseView.getOKButton().setOnAction(e -> confirmAdresse());

		/**
		 * Événement sur le bouton "Annuler" pour annuler la confirmation de l'adresse
		 */
		annuler.setOnMouseClicked(e -> {
			Adresse adresse = adresseView.getAdresse();
			adresseView.enable();
			map.moveMarker(markerLocationWant, new LatLng(0, 0));
			commanderUtaxiButton.setDisable(true);
			annuler.setDisable(true);
		});

		/**
		 * Événement sur le bouton "Déplacer les Utaxi" pour déplacer les Utaxi afin de
		 * simuler le déplacement des Utaxi
		 */
		moveTaxi.setOnMouseClicked(e -> {
			double randomLat;
			double randomLong;
			for (Conducteur c : Utilisateurs.getListConducteur()) {
				randomLat = ThreadLocalRandom.current().nextDouble(-0.001, 0.001);
				randomLong = ThreadLocalRandom.current().nextDouble(-0.001, 0.001);
				map.moveMarker(c.getMarker(), new LatLng(c.getMarker().getCoords().getLatitude() + randomLat,
						c.getMarker().getCoords().getLongitude() + randomLong));
			}

		});

		/**
		 * Événement sur le bouton "Commander le Utaxi" pour commander le Utaxi
		 */

		commanderUtaxiButton.setOnAction(e -> {

			if (listViewConducteur.getSelectionModel().getSelectedItem().isActif()) {
				Utilisateurs.getRequete().setParametre((Passager) Utilisateurs.getPersonneCourante(),
						listViewConducteur.getSelectionModel().getSelectedItem(), new Date(),
						markerCurrentPosition.getCoords().getLatitude(),
						markerCurrentPosition.getCoords().getLongitude());
				map.disableRouting();
				annuler.setDisable(true);
				moveTaxi.setDisable(true);
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
							moveTaxi.setDisable(false);
						});

					}
				}, 30000);

				myTimer.schedule(new TimerTask() {
					@Override
					public void run() {
						Platform.runLater(() -> {
							Window.getInstance().gotoPage("review");
						});
					}
				}, 31000);
			} else {
				infoSituation.setText("Le chauffeur est indisponible, il termine sa course...");
			}

		});
	}

	/**
	 * Confirme l'adresse renseigné
	 * 
	 */
	private void confirmAdresse() {
		Adresse adresse = adresseView.getAdresse();
		if (adresse != null) {
			adresseView.disable();
			map.moveMarker(markerLocationWant, adresse.getCoords());
			commanderUtaxiButton.setDisable(false);
			annuler.setDisable(false);
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

		header.getChildren().addAll(backButton, title, selectionPage);

		// Left Side
		leftSide.setVgap(15);
		leftSide.add(choisirUtaxiLabel, 0, 0);
		leftSide.add(listViewConducteur, 0, 1);
		leftSide.add(choisirCoordLabel, 0, 2);
		leftSide.add(adresseView, 0, 3);
		leftSide.add(annuler, 0, 4);
		leftSide.add(commanderUtaxiButton, 0, 4);
		leftSide.add(moveTaxi, 0, 5);
		leftSide.add(infoSituation, 0, 6, 1, 1);
		leftSide.setMinWidth(300);
		infoSituation.setStyle("-fx-font: 16 arial;");
		choisirUtaxiLabel.setStyle("-fx-font: 24 arial;");
		choisirUtaxiLabel.setPadding(new Insets(15, 0, 15, 0));
		choisirCoordLabel.setStyle("-fx-font: 24 arial;");
		choisirCoordLabel.setPadding(new Insets(15, 0, 15, 0));

		listViewConducteur.setMinWidth(385);
		listViewConducteur.setMaxHeight(250);
		GridPane.setHalignment(commanderUtaxiButton, HPos.CENTER);
		GridPane.setHalignment(infoSituation, HPos.CENTER);
		GridPane.setHgrow(adresseView, Priority.ALWAYS);
		commanderUtaxiButton.setDisable(true);
		annuler.setDisable(true);

		// Centrage
		choisirUtaxiLabel.setTextAlignment(TextAlignment.CENTER);
		choisirCoordLabel.setTextAlignment(TextAlignment.CENTER);
		GridPane.setHalignment(choisirUtaxiLabel, HPos.CENTER);
		GridPane.setHalignment(choisirCoordLabel, HPos.CENTER);

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