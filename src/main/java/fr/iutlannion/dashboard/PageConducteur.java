package fr.iutlannion.dashboard;

import fr.iutlannion.core.Window;
import fr.iutlannion.manager.Conducteur;
import fr.iutlannion.manager.Utilisateurs;
import fr.iutlannion.map.LatLng;
import fr.iutlannion.map.MapOptions;
import fr.iutlannion.map.MapView;
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
	private Conducteur c = (Conducteur) Utilisateurs.getPersonneCourante();
	private BorderPane root = new BorderPane();

	// Header
	private HBox header = new HBox();
	private Button backButton = new Button("Deconnexion");
	private Label title = new Label(
			"Page Conducteur - Bienvenue " + Utilisateurs.getPersonneCourante().getPrenom());
	private final ObservableList<String> options = FXCollections.observableArrayList(
			"Tableau de bord",
			"Édition de profil",
			"Édition de voiture"
	);
	private final ComboBox selectionPage = new ComboBox(options);

	// Left Side
	private GridPane leftSide = new GridPane();
	private Label soon = new Label("Prochainement");
	private Button actif = new Button("Inactif"); 

	// Right Side
	private MapOptions mapOptions = new MapOptions();
	private MapView map;

	public void changementStatus(){
		if (c.actif==true){
			actif.setText("Inactif");
			c.actif=false;
			System.out.println(c.actif);
		}
		else{
			actif.setText("Actif");
			c.actif=true;
			System.out.println(c.actif);
		}
		
	}
	
	public PageConducteur() {
		actif.setOnMouseClicked((new EventHandler<MouseEvent>(){
			public void handle(MouseEvent event){
				changementStatus();
			}
		}));
		backButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Window.getInstance().gotoPage("connexion");
			}
		}));

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
		leftSide.setHgap(15);
		leftSide.add(soon, 0, 0);
		leftSide.setMinWidth(300);
		leftSide.add(actif,0,1);

		// Map
		mapOptions.setCoordinates(new LatLng(47.2186371, -1.5541362));
		mapOptions.setZoom(13);
		map = new MapView(mapOptions);

		root.setTop(header);
		root.setRight(map);
		root.setLeft(leftSide);

		return root;

	}
}
