package fr.iutlannion.auth;

import fr.iutlannion.core.Window;
import fr.iutlannion.manager.*;
import fr.iutlannion.map.LatLng;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * PageInscription contient la première phase de l'inscription avec le
 * renseignement des informations de connexion.
 * 
 * 
 * @author mboultoureau
 * @version 1.0
 * 
 */
public class PageInscription extends Stage {

	private BorderPane root = new BorderPane();

	// Header
	private HBox headerPane = new HBox();
	private Button retourButton = new Button("Retour");
	private Label titreLabel = new Label("INSCRIPTION");
	private Label logoLabel = new Label("UTaxi");

	// Conducteur
	private GridPane gridPane = new GridPane();

	private HBox typePane = new HBox();
	private ToggleGroup typeGroup = new ToggleGroup();
	private Label typeLabel = new Label("Vous êtes :");
	private RadioButton passagerRadio = new RadioButton("Passager/ère");
	private RadioButton conducteurRadio = new RadioButton("Conducteur/trice");

	private Label nomLabel = new Label("Nom");
	private TextField nomField = new TextField();
	private Label nomError = new Label("Le nom est incorrect.");

	private Label prenomLabel = new Label("Prenom");
	private TextField prenomField = new TextField();
	private Label prenomError = new Label("Le prénom est incorrect.");

	private Label emailLabel = new Label("Email");
	private TextField emailField = new TextField();
	private Label emailError = new Label("");

	private Label mdpLabel = new Label("Mot de passe");
	private TextField mdpField = new PasswordField();
	private Label mdpError = new Label("Le mot de passe est incorrect.");

	private Label confirmationMdpLabel = new Label("Confirmer le mot de passe");
	private TextField confirmationMdpField = new PasswordField();
	private Label confirmationMdpError = new Label("Les mots de passe ne correspondent pas.");

	private Label tarifLabel = new Label("Tarif (en euros)");
	private TextField tarifField = new TextField();
	private Label tarifError = new Label("Le tarif est invalide.");

	private CheckBox majeurCheckbox = new CheckBox("Je reconnais être majeur dans le pays où je m'inscrit.");
	private CheckBox conditionsCheckbox = new CheckBox(
			"Je reconnais avoir lu les conditions générales d'utilisation et de ventes et les acceptent.");

	private Button connexionButton = new Button("J'ai déjà un compte");
	private Label conditionsError = new Label("Vous devez accepter les conditions d'utilisation et être majeur.");

	private Button suivantButton = new Button("Suivant");

	public PageInscription() {


		Window.getInstance().setMinHeight(550);
		Window.getInstance().setMaxHeight(550);
		Window.getInstance().setHeight(550);
		Window.getInstance().setMinWidth(660);
		Window.getInstance().setWidth(660);
		Window.getInstance().setResizable(true);

		// Événements
		retourButton.setOnAction(e -> {
			Utilisateurs.resetPersonneCourante();
			Window.getInstance().gotoPage("menuPrincipal");
		});

		connexionButton.setOnAction(e -> {
			Utilisateurs.resetPersonneCourante();
			Window.getInstance().gotoPage("connexion");
		});

		suivantButton.setOnAction(e -> {
			if (verifierPersonne()) {
				RadioButton selectionne = (RadioButton) typeGroup.getSelectedToggle();
				if (selectionne.getText().equals("Passager/ère")) {
					Passager p = new Passager(nomField.getText(), prenomField.getText(), emailField.getText(), mdpField.getText(), new LatLng(48.833, 2.333), null);
					Utilisateurs.setPersonneCourante(p);
					Window.getInstance().gotoPage("paiement");
				} else {
					Conducteur c = new Conducteur(nomField.getText(), prenomField.getText(), emailField.getText(), mdpField.getText(), Double.valueOf(tarifField.getText()), 0, null, new LatLng(48.833, 2.333));
					Utilisateurs.setPersonneCourante(c);
					Window.getInstance().gotoPage("enregistrementVoiture");
				}
			}
		});

		typeGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				RadioButton selectionne = (RadioButton) typeGroup.getSelectedToggle();
				afficherTarif(selectionne.getText().equals("Conducteur/trice"));
			}
		});
	}

	/**
	 * Vérifie si l'utilisateur a saisi tous les champs correctement.
	 * 
	 * @return Retourne vrai si tous les champs sont correctes
	 */
	private boolean verifierPersonne() {

		boolean valide = true;
		cacherErreurs();

		// On trime tous les champs
		nomField.setText(nomField.getText().trim());
		prenomField.setText(prenomField.getText().trim());
		emailField.setText(emailField.getText().trim());
		tarifField.setText(tarifField.getText().trim());

		// Nom
		if (nomField.getText().length() < 3 || nomField.getText().length() > 30) {
			nomError.setText("Le nom doit contenir entre 3 et 30 caractères.");
			nomError.setVisible(true);
			valide = false;
		} else if (!nomField.getText().matches("[a-zA-Zéèêà -]+")) {
			nomError.setText("Le nom doit contenir uniquement des lettres et des espaces.");
			nomError.setVisible(true);
			valide = false;
		}

		// Prénom
		if (prenomField.getText().length() < 3 || prenomField.getText().length() > 30) {
			prenomError.setText("Le nom doit contenir entre 3 et 30 caractères.");
			prenomError.setVisible(true);
			valide = false;
		} else if (!prenomField.getText().matches("[a-zA-Zéèêà -]+")) {
			prenomError.setText("Le prénom doit contenir uniquement des lettres et des espaces.");
			prenomError.setVisible(true);
			valide = false;
		}

		// Adresse email
		if (emailField.getText().trim().length() < 3 || emailField.getText().trim().length() > 120) {
			emailError.setText("L'adresse email doit contenir entre 3 et 120 caractères.");
			emailError.setVisible(true);
			valide = false;
		} else if (!emailField.getText().trim().matches("(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)")) {
			emailError.setText("L'adresse email doit être valide.");
			emailError.setVisible(true);
			valide = false;
		} else if (Utilisateurs.emailUtilise(emailField.getText())) {
			emailError.setText("Cette adresse email est déjà utilisé.");
			emailError.setVisible(true);
			valide = false;
		}

		// Mot de passe
		if (mdpField.getText().length() < 5 || mdpField.getText().length() > 120) {
			mdpError.setText("Le mot de passe doit contenir entre 5 et 120 caractères");
			mdpError.setVisible(true);
			valide = false;
		}

		// Confirmation de mot de passe
		if (!mdpField.getText().equals(confirmationMdpField.getText())) {
			confirmationMdpError.setText("Les mots de passe doivent être identiques.");
			confirmationMdpError.setVisible(true);
			valide = false;
		}

		// Tarif
		RadioButton selectionne = (RadioButton) typeGroup.getSelectedToggle();
		if (selectionne.getText().equals("Conducteur/trice")) {
			try {
				Double.parseDouble(tarifField.getText());
			} catch (NumberFormatException e) {
				tarifError.setText("Le tarif doit être valide (ex : 10.3).");
				tarifError.setVisible(true);
				valide = false;
			}
		}

		if (!majeurCheckbox.isSelected() || !conditionsCheckbox.isSelected()) {
			conditionsError.setText("Vous devez être majeur(e) et accepter les conditions.");
			conditionsError.setVisible(true);
			valide = false;
		}

		return valide;
	}

	/**
	 * Permet d'afficher ou de masquer le champ tarif
	 * @param afficher un booléen indiquant l'affichage ou non du champ
	 */
	private void afficherTarif(boolean afficher) {
		tarifLabel.setVisible(afficher);
		tarifField.setVisible(afficher);
	}

	/**
	 * Masque toutes les erreurs
	 */
	private void cacherErreurs() {
		nomError.setVisible(false);
		prenomError.setVisible(false);
		emailError.setVisible(false);
		mdpError.setVisible(false);
		confirmationMdpError.setVisible(false);
		tarifError.setVisible(false);
		conditionsError.setVisible(false);
	}

	public Parent creerContenu() {

		// HEADER
		headerPane.setMinWidth(640);
		headerPane.setPadding(new Insets(0, 20, 0, 20));

		headerPane.setPrefHeight(50);
		headerPane.setStyle("-fx-background-color: #000;");
		headerPane.setAlignment(Pos.CENTER);

		// Bouton retour
		retourButton.setStyle(
				"-fx-background-color: #000; -fx-text-fill: #fff; -fx-border-color: #fff; -fx-border-width: 2;");
		retourButton.setAlignment(Pos.CENTER_LEFT);

		// Titre
		titreLabel.setStyle("-fx-text-fill: #fff;");
		titreLabel.setAlignment(Pos.CENTER);
		titreLabel.setFont(new Font("Arial", 20));
		titreLabel.setMaxWidth(Double.MAX_VALUE);
		HBox.setHgrow(titreLabel, Priority.ALWAYS);

		// Logo
		logoLabel.setStyle("-fx-text-fill: #fff;");
		logoLabel.setAlignment(Pos.CENTER_RIGHT);

		headerPane.getChildren().addAll(retourButton, titreLabel, logoLabel);

		// Affichages des erreurs
		nomError.setTextFill(Color.RED);
		prenomError.setTextFill(Color.RED);
		emailError.setTextFill(Color.RED);
		mdpError.setTextFill(Color.RED);
		confirmationMdpError.setTextFill(Color.RED);
		tarifError.setTextFill(Color.RED);
		conditionsError.setTextFill(Color.RED);

		cacherErreurs();

		// RadioButtons ; sélectionner du type d'utilisateur
		typePane.getChildren().addAll(passagerRadio, conducteurRadio);
		HBox.setMargin(conducteurRadio, new Insets(0, 0, 10, 50));
		passagerRadio.setToggleGroup(typeGroup);
		conducteurRadio.setToggleGroup(typeGroup);
		passagerRadio.setSelected(true);

		// Buttons connexion et suivant
		connexionButton.setPrefWidth(150);
		connexionButton.setPrefHeight(50);

		suivantButton.setPrefWidth(150);
		suivantButton.setPrefHeight(50);

		// Conducteur
		gridPane.add(typeLabel, 0, 0);
		gridPane.add(typePane, 0, 1, 2, 1);

		gridPane.add(nomLabel, 0, 2);
		gridPane.add(nomField, 0, 3);
		gridPane.add(nomError, 0, 4);

		gridPane.add(prenomLabel, 0, 5);
		gridPane.add(prenomField, 0, 6);
		gridPane.add(prenomError, 0, 7);

		gridPane.add(emailLabel, 0, 8);
		gridPane.add(emailField, 0, 9);
		gridPane.add(emailError, 0, 10);

		gridPane.add(mdpLabel, 1, 2);
		gridPane.add(mdpField, 1, 3);
		gridPane.add(mdpError, 1, 4);

		gridPane.add(confirmationMdpLabel, 1, 5);
		gridPane.add(confirmationMdpField, 1, 6);
		gridPane.add(confirmationMdpError, 1, 7);

		gridPane.add(tarifLabel, 1, 8);
		gridPane.add(tarifField, 1, 9);
		gridPane.add(tarifError, 1, 10);

		gridPane.add(majeurCheckbox, 0, 11, 2, 1);
		gridPane.add(conditionsCheckbox, 0, 12, 2, 1);
		gridPane.add(conditionsError, 0, 13, 2, 1);

		gridPane.add(connexionButton, 0, 14);
		gridPane.add(suivantButton, 1, 14);

		GridPane.setHalignment(suivantButton, HPos.RIGHT);

		gridPane.setPadding(new Insets(20, 30, 30, 30));
		gridPane.setMinWidth(640);
		gridPane.setHgap(30);
		gridPane.setVgap(7);

		GridPane.setHgrow(nomLabel, Priority.ALWAYS);
		GridPane.setHgrow(mdpLabel, Priority.ALWAYS);
		
		// Autocomplétion en cas de retour
		if (Utilisateurs.getPersonneCourante() != null) {
			if (Utilisateurs.getPersonneCourante() instanceof Passager || Utilisateurs.getPersonneCourante() instanceof Conducteur) {
				Personne p = Utilisateurs.getPersonneCourante();
				nomField.setText(p.getNom());
				prenomField.setText(p.getPrenom());
				emailField.setText(p.getEmail());
				mdpField.setText(p.getMotDePasse());
				confirmationMdpField.setText(p.getMotDePasse());
				conditionsCheckbox.setSelected(true);
				majeurCheckbox.setSelected(true);
			}

			if (Utilisateurs.getPersonneCourante() instanceof Conducteur) {
				Conducteur c = (Conducteur) Utilisateurs.getPersonneCourante();
				tarifField.setText(String.valueOf(c.getTarif()));
			}
		}

		// Masquer le champ tarif
		afficherTarif(false);

		root.setMinHeight(480);
		root.setMinWidth(640);
		root.setTop(headerPane);
		root.setCenter(gridPane);

		return root;
	}
}
