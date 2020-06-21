package fr.iutlannion.dashboard;

import fr.iutlannion.core.Window;
import fr.iutlannion.manager.Conducteur;
import fr.iutlannion.manager.Passager;
import fr.iutlannion.manager.Utilisateurs;
import fr.iutlannion.map.Adresse;
import fr.iutlannion.map.AdresseView;
import fr.iutlannion.map.Icon;
import fr.iutlannion.map.LatLng;
import fr.iutlannion.map.MapOptions;
import fr.iutlannion.map.MapView;
import fr.iutlannion.map.Marker;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PageConducteur extends Stage {
	//Création d'utilisateur courant pour l'affichage ainsi que l'affichage en lui meme
	private Conducteur c = (Conducteur) Utilisateurs.getPersonneCourante();
	private BorderPane root = new BorderPane();
	private AdresseView adresseView = new AdresseView();

	// Header
	//affichage
	private HBox header = new HBox();
	private Button backButton = new Button("Deconnexion");
	private Label title = new Label("Page Conducteur - Bienvenue " + Utilisateurs.getPersonneCourante().getPrenom());
	private final ObservableList<String> options = FXCollections.observableArrayList("Tableau de bord",
			"Édition de profil", "Édition de voiture");
	private final ComboBox selectionPage = new ComboBox(options);

	// Left Side

	private GridPane leftSide = new GridPane();
	private Button actif = new Button("actif");
	private Label requeteLabel = new Label("");

	// Right Side

	private MapOptions mapOptions = new MapOptions();
	private MapView map;
	private Icon icon = new Icon("img/taxi.png", 40, 20);

	//création de markeur et récuperation d'adresse du taxi
	private Marker markerCurrentPosition = new Marker(c.getMarker().getCoords());
	Adresse adresse = adresseView.getAdresse();
	
	//fonction permettant de changer le statut du taxi si le taxi est inactif il ne pourra pas conduire de personne
	public void changementStatus() {
		if (c.actif == true) {
			actif.setText("Inactif");
			c.actif = false;
		} else {
			actif.setText("Actif");
			c.actif = true;
		}

	}
	//création de la page 
	public PageConducteur() {
		//changement de statut et changement du bouton grace à la fonction
		actif.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				changementStatus();
			}
		}));
		//Retour lors du clic sur deconnexion à la page de connexion
		backButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Window.getInstance().gotoPage("connexion");
			}
		}));
		// Creation du menu déroulant pour acceder aux pages edition de voiture et profil
		selectionPage.setValue("Tableau de bord");

		selectionPage.valueProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				switch (newValue.toString()) {
					case "Édition de profil":
						Window.getInstance().gotoPage("editionProfil");
						break;
					case "Édition de voiture":
						Window.getInstance().gotoPage("editionVoiture");
						break;
				}
			}
		});
		//Si il n'y a pas de requete alors ce message s'affiche
		requeteLabel.setText("Pas de requête en cours");
		// System.out.println(Utilisateurs.getRequete().toString());

	}
	//Creation de la page lors de l'appelle de la classe creerContenu()
	public Parent creerContenu() {
		//notion de "decorum"
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
		leftSide.setHgap(15);
		
		leftSide.setMinWidth(300);
		leftSide.add(actif, 0, 1);
		leftSide.add(requeteLabel, 0, 2);
		//creation de la carte avec les marqueurs ainsi que les coordonnées de base de la ville et le zoom
		// Map
		mapOptions.setCoordinates(new LatLng(47.2186371, -1.5541362));
		mapOptions.setZoom(13);
		map = new MapView(mapOptions);

		for (Passager p : Utilisateurs.getListPassagers()) {
			map.addMarker(c.getMarker());
			c.getMarker().setIcon(icon);
		}
		root.setTop(header);
		root.setRight(map);
		root.setLeft(leftSide);
		map.addMarker(markerCurrentPosition);
		markerCurrentPosition.setIcon(icon);

		return root;

	}
}
