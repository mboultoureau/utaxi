package fr.iutlannion.auth;

import fr.iutlannion.core.Window;
import fr.iutlannion.exceptions.FormatException;
import fr.iutlannion.manager.Conducteur;
import fr.iutlannion.manager.Utilisateur;
import fr.iutlannion.manager.Voiture;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;

public class PageEnregistrementVoiture extends Stage {

	private Voiture v = new Voiture();
	
	private BorderPane root = new BorderPane();

	// Header
	private HBox header = new HBox();
	private Button backButton = new Button("Retour");
	private Label title = new Label("ENREGISTREMENT DU VÉHICULE");
	private Label logo = new Label("UTaxi");

	// informations voiture
	private GridPane voiture = new GridPane();

	private Label tarif = new Label("Tarif");
	private TextField ftarif = new TextField();
	private Label tarifError = new Label();

	private Label kmParcourus = new Label("Nombre de kilometres parcourus");
	private TextField fkmParcourus = new TextField();
	private Label kmParcourusError = new Label();

	private Label imat = new Label("Immatriculation");
	private TextField fimat = new TextField();
	private Label imatError = new Label("");

	private Label marque = new Label("Marque");
	private TextField fmarque = new TextField();
	private Label marqueError = new Label("");

	private Label tEss = new Label("Type Essence");
	private ComboBox<String> ftEss;
	private Label tEssError = new Label("");

	private Label type = new Label("Type");
	private TextField ftype = new TextField();
	private Label typeError = new Label("");

	private Label couleur = new Label("Couleur");
	private TextField fcouleur = new TextField();
	private Label couleurError = new Label("");

	private Button annuler = new Button("Annuler");

	private Button buttonSuivant = new Button("Next");

	public PageEnregistrementVoiture() {

		backButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Window.getInstance().gotoPage("menuPrincipal");
			}
		}));

		annuler.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Window.getInstance().gotoPage("menuPrincipal");
			}
		}));

		buttonSuivant.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (!checkVoiture()){
					Conducteur c = (Conducteur) Utilisateur.getInstance().getPersonne();
					c.modifierInfoVoiture(Double.parseDouble(ftarif.getText()), Double.parseDouble(fkmParcourus.getText()), fimat.getText(), marque.getText(), ftEss.getValue(), fcouleur.getText(), ftype.getText());
					Window.getInstance().gotoPage("horaires");
				}
			}
		}));
	}

	private void hideErrors(){
		imatError.setVisible(false);
		marqueError.setVisible(false);
		tEssError.setVisible(false);
		typeError.setVisible(false);
		couleurError.setVisible(false);
	}

	private boolean checkVoiture(){

		boolean hasErrors = false;

		hideErrors();

		try {
			v.setImmatriculation(fimat.getText());
		} catch (FormatException e) {
			imatError.setVisible(true);
			imatError.setText(e.getMessage());
			hasErrors = true;
		}

		try {
			v.setMarque(fmarque.getText());
		} catch (FormatException e) {
			marqueError.setVisible(true);
			marqueError.setText(e.getMessage());
			hasErrors = true;
		}

		try {
			v.setTypeEssence(ftEss.getValue());
		} catch (FormatException e) {
			tEssError.setVisible(true);
			tEssError.setText(e.getMessage());
			hasErrors = true;
		}

		try {
			v.setType(ftype.getText());
		} catch (FormatException e) {
			typeError.setVisible(true);
			typeError.setText(e.getMessage());
			hasErrors = true;
		}

		return hasErrors;

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

		//combobox type essences
		ftEss = new ComboBox<String>();
		ftEss.getItems().addAll(
			"diesel",
			"hydrogène",
			"98",
			"95",
			"autre"
		);

		voiture.add(imat, 0, 0);
		voiture.add(fimat, 0, 1);
		voiture.add(marque, 0, 2);
		voiture.add(fmarque, 0, 3);
		voiture.add(tEss, 0, 4);
		voiture.add(ftEss, 0, 5);
		voiture.add(type, 0, 6);
		voiture.add(ftype, 0, 7);
		voiture.add(couleur, 0, 8);
		voiture.add(fcouleur, 0, 9);
		voiture.add(annuler, 0, 10);
		voiture.add(buttonSuivant, 1, 10);

		GridPane.setHalignment(buttonSuivant, HPos.RIGHT);

		voiture.setPadding(new Insets(30, 30, 30, 30));
		voiture.setMinWidth(640);
		voiture.setHgap(30);
		voiture.setVgap(10);
		GridPane.setHgrow(imat, Priority.ALWAYS);

		root.setTop(header);
		root.setCenter(voiture);

		return root;

	}
}
