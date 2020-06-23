package fr.iutlannion.auth;

import fr.iutlannion.core.Window;
import fr.iutlannion.exceptions.FormatException;
import fr.iutlannion.manager.Conducteur;
import fr.iutlannion.manager.Utilisateurs;
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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;

/**
 * PageEnregistrementVoiture contient la deuxième phase de l'inscription pour le conducteur avec le
 * renseignement des informations de sa voiture.
 * 
 * 
 * @author rbastille
 * @version 1.0
 * 
 */
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

	private Label kmParcourus = new Label("Nombre de kilometres parcourus");
	private TextField fkmParcourus = new TextField();
	private Label kmParcourusError = new Label("");

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

	private HBox boutons = new HBox();
	private Button annuler = new Button("Annuler");
	private Button buttonSuivant = new Button("Next");
	private Region space = new Region();

	public PageEnregistrementVoiture() {

		Window.getInstance().setMinHeight(700);
		Window.getInstance().setMaxHeight(700);
		Window.getInstance().setHeight(700);

		Window.getInstance().setMinWidth(660);
		Window.getInstance().setMaxWidth(660);
		Window.getInstance().setWidth(660);

		Window.getInstance().setResizable(false);

		backButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Window.getInstance().gotoPage("inscription");
			}
		}));

		annuler.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Window.getInstance().gotoPage("menuPrincipal");
			}
		}));

		buttonSuivant.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (!checkVoiture()){ // si il n'y a pas d'erreurs, modification des inforamtions de la voiture du conducteur actuellement crée
					Conducteur c = (Conducteur) Utilisateurs.getPersonneCourante();
					c.getVoiture().modifierInfo(Double.parseDouble(fkmParcourus.getText()), fimat.getText(), marque.getText(), ftEss.getValue(), fcouleur.getText(), ftype.getText());
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

	 /**
	 * Vérifie si l'utilisateur a saisi tous les champs correctement.
	 * 
	 * @return Retourne vrai si tous les champs sont correctes
	 */
	private boolean checkVoiture(){

		boolean hasErrors = false;

		hideErrors();

		//immatriculation
		try {
			v.setImmatriculation(fimat.getText());
		} catch (FormatException e) {
			imatError.setVisible(true);
			imatError.setText(e.getMessage());
			hasErrors = true;
		}

		//marque
		try {
			v.setMarque(fmarque.getText());
		} catch (FormatException e) {
			marqueError.setVisible(true);
			marqueError.setText(e.getMessage());
			hasErrors = true;
		}

		//type
		try {
			v.setType(ftype.getText());
		} catch (FormatException e) {
			typeError.setVisible(true);
			typeError.setText(e.getMessage());
			hasErrors = true;
		}

		//couleur
		try {
			v.setCouleur(fcouleur.getText());
		} catch (FormatException e) {
			couleurError.setVisible(true);
			couleurError.setText(e.getMessage());
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

		hideErrors();

		//Erreurs
		kmParcourusError.setTextFill(Color.RED);
		imatError.setTextFill(Color.RED);
		marqueError.setTextFill(Color.RED);
		tEssError.setTextFill(Color.RED);
		typeError.setTextFill(Color.RED);
		couleurError.setTextFill(Color.RED);

		//combobox type essences
		ftEss = new ComboBox<String>();
		ftEss.getItems().addAll(
			"diesel",
			"hydrogène",
			"98",
			"95",
			"autre"
		);
		ftEss.getSelectionModel().selectFirst();

		//affichage des champs pour la voiture
		voiture.add(kmParcourus, 0, 0);
		voiture.add(fkmParcourus, 0, 1);
		voiture.add(kmParcourusError, 0, 2);

		voiture.add(imat, 0, 3);
		voiture.add(fimat, 0, 4);
		voiture.add(imatError, 0, 5);
		
		voiture.add(marque, 0, 6);
		voiture.add(fmarque, 0, 7);
		voiture.add(marqueError, 0, 8);

		voiture.add(tEss, 0, 9);
		voiture.add(ftEss, 0, 10);
		voiture.add(tEssError, 0, 11);
		ftEss.setMinWidth(510);

		voiture.add(type, 0, 12);
		voiture.add(ftype, 0, 13);
		voiture.add(typeError, 0, 14);

		voiture.add(couleur, 0, 15);
		voiture.add(fcouleur, 0, 16);
		voiture.add(couleurError, 0, 17);

		boutons.getChildren().addAll(annuler, space, buttonSuivant);
		HBox.setHgrow(space, Priority.ALWAYS);

		voiture.add(boutons, 0, 18);

		GridPane.setHalignment(buttonSuivant, HPos.RIGHT);

		ftEss.setPrefWidth(600);

		voiture.setPadding(new Insets(30, 30, 30, 30));
		voiture.setMinWidth(640);
		voiture.setHgap(20);
		voiture.setVgap(10);
		GridPane.setHgrow(imat, Priority.ALWAYS);

		root.setTop(header);
		root.setCenter(voiture);

		return root;

	}
}
