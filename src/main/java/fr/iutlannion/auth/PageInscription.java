package fr.iutlannion.auth;

import fr.iutlannion.core.Window;
import fr.iutlannion.exceptions.FormatException;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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

	private Conducteur c = new Conducteur();
	private Passager p = new Passager();

	private BorderPane root = new BorderPane();

	// Header
	private HBox header = new HBox();
	private Button backButton = new Button("Retour");
	private Label title = new Label("INSCRIPTION");
	private Label logo = new Label("UTaxi");

	// Tabs
	private TabPane tabPane = new TabPane();
	private Tab passagerTab = new Tab();
	private Tab conducteurTab = new Tab();

	// Conducteur
	private GridPane conducteurPane = new GridPane();
	
	private Label cNom = new Label("Nom");
	private TextField cNomField = new TextField();
	private Label cNomError = new Label("");
	
	private Label cPrenom = new Label("Prenom");
	private TextField cPrenomField = new TextField();
	private Label cPrenomError = new Label("");
	
	private Label cEmail = new Label("Email");
	private TextField cEmailField = new TextField();
	private Label cEmailError = new Label("");
	
	private Label cMdp = new Label("Mot de passe");
	private TextField cMdpField = new PasswordField();
	private Label cMdpError = new Label("");
	
	private Label cConfirmerMdp = new Label("Confirmer le mot de passe");
	private TextField cConfirmerMdpField = new PasswordField();
	private Label cConfirmerMdpError = new Label("");
	
	private Label cTarif = new Label("Tarif (en euros)");
	private TextField cTarifField = new TextField();
	private Label cTarifError = new Label("");
	
	private CheckBox cMajeur = new CheckBox("Je reconnais être majeur dans le pays où je m'inscrit.");
	private CheckBox cConditions = new CheckBox(
			"Je reconnais avoir lu les conditions générales d'utilisation et de ventes et les acceptent.");
	private Button cConnexion = new Button("J'ai déjà un compte");
	private Label cConditionsError = new Label("");
	
	private Button cNext = new Button("Suivant");

	// Passager
	private GridPane passagerPane = new GridPane();
	
	private Label pNom = new Label("Nom");
	private TextField pNomField = new TextField();
	private Label pNomError = new Label("");
	
	private Label pPrenom = new Label("Prenom");
	private TextField pPrenomField = new TextField();
	private Label pPrenomError = new Label("");
	
	private Label pEmail = new Label("Email");
	private TextField pEmailField = new TextField();
	private Label pEmailError = new Label("");
	
	private Label pMdp = new Label("Mot de passe");
	private TextField pMdpField = new PasswordField();
	private Label pMdpError = new Label("");
	
	private Label pConfirmerMdp = new Label("Confirmer le mot de passe");
	private TextField pConfirmerMdpField = new PasswordField();
	private Label pConfirmerMdpError = new Label("");
	
	private CheckBox pMajeur = new CheckBox("Je reconnais être majeur dans le pays où je m'inscrit.");
	private CheckBox pConditions = new CheckBox(
			"Je reconnais avoir lu les conditions générales d'utilisation et de ventes et les acceptent.");
	private Label pConditionsError = new Label("");
	
	private Button pConnexion = new Button("J'ai déjà un compte");
	private Button pNext = new Button("Suivant");

	public PageInscription() {

		// Événements
		backButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Window.getInstance().gotoPage("mainMenu");
			}
		}));

		pConnexion.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Window.getInstance().gotoPage("connexion");
			}
		}));

		cConnexion.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Window.getInstance().gotoPage("connexion");
			}
		}));

		// Suivant
		pNext.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (!checkPassager()) {
					Window.getInstance().gotoPage("paiement");
				}
			}
		}));
		
		// Suivant
		cNext.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if (!checkConducteur()) {
					Window.getInstance().gotoPage("enregistrementVoiture");
				}
			}
		}));
	}

	
	private void hideErrors() {
		cNomError.setVisible(false);
		cPrenomError.setVisible(false);
		cEmailError.setVisible(false);
		cMdpError.setVisible(false);
		cConfirmerMdpError.setVisible(false);
		cTarifError.setVisible(false);
		cConditionsError.setVisible(false);
		
		pNomError.setVisible(false);
		pPrenomError.setVisible(false);
		pEmailError.setVisible(false);
		pMdpError.setVisible(false);
		pConfirmerMdpError.setVisible(false);
		pConditionsError.setVisible(false);
	}
	
	/**
	 * Vérifie si le conducteur a saisi tous les champs correctement.
	 * 
	 * @return Retourne vrai si possède des erreurs
	 */
	private boolean checkConducteur() {
		
		boolean hasErrors = false;
		
		hideErrors();

		try {
			c.setNom(pNomField.getText());
		} catch (FormatException e) {
			cNomError.setVisible(true);
			cNomError.setText(e.getMessage());
			hasErrors = true;
		}

		try {
			c.setPrenom(pPrenomField.getText());
		} catch (FormatException e) {
			cPrenomError.setVisible(true);
			cPrenomError.setText(e.getMessage());
			hasErrors = true;
		}

		try {
			c.setEmail(pEmailField.getText());
		} catch (FormatException e) {
			cEmailError.setVisible(true);
			cEmailError.setText(e.getMessage());
			hasErrors = true;
		}

		if (cMdpField.getText().equals(cConfirmerMdpField.getText())) {
			try {
				c.setPassword(cMdpField.getText());
			} catch (FormatException e) {
				cMdpError.setVisible(true);
				cMdpError.setText(e.getMessage());
				hasErrors = true;
			}
		} else {
			cConfirmerMdpError.setVisible(true);
			cConfirmerMdpError.setText("Les mots de passe doivent être identiques.");
			hasErrors = true;
		}
		

		try {
			c.setTarif(cTarifField.getText());
		} catch(FormatException e) {
			cTarifError.setVisible(true);
			cTarifError.setText(e.getMessage());
			hasErrors = true;
		}
		
		if (!cMajeur.isSelected() || !cConditions.isSelected()) {
			cConditionsError.setVisible(true);
			cConditionsError.setText("Vous devez être majeur et accepté les conditions.");
			hasErrors = true;
		}
		
		return hasErrors;
	}
	


	/**
	 * Vérifie si le passager a saisi tous les champs correctement.
	 * 
	 * @return Retourne vrai si possède des erreurs.
	 */
	private boolean checkPassager() {
		
		boolean hasErrors = false;

		hideErrors();

		try {
			p.setNom(pNomField.getText());
		} catch (FormatException e) {
			pNomError.setVisible(true);
			pNomError.setText(e.getMessage());
			hasErrors = true;
		}

		try {
			p.setPrenom(pPrenomField.getText());
		} catch (FormatException e) {
			pPrenomError.setVisible(true);
			pPrenomError.setText(e.getMessage());
			hasErrors = true;
		}

		try {
			p.setEmail(pEmailField.getText());
		} catch (FormatException e) {
			pEmailError.setVisible(true);
			pEmailError.setText(e.getMessage());
			hasErrors = true;
		}

		if (pMdpField.getText().equals(pConfirmerMdpField.getText())) {
			try {
				p.setPassword(pMdpField.getText());
			} catch (FormatException e) {
				pMdpError.setVisible(true);
				pMdpError.setText(e.getMessage());
				hasErrors = true;
			}
		} else {
			pConfirmerMdpError.setVisible(true);
			pConfirmerMdpError.setText("Les mots de passe doivent être identiques.");
			hasErrors = true;
		}
		
		if (!pMajeur.isSelected() || !pConditions.isSelected()) {
			pConditionsError.setVisible(true);
			pConditionsError.setText("Vous devez être majeur et accepté les conditions.");
			hasErrors = true;
		}
		
		return hasErrors;
	}

	public Parent creerContenu() {

		// HEADER
		header.setMinWidth(640);
		header.setPadding(new Insets(0, 20, 0, 20));

		header.setPrefHeight(50);
		header.setStyle("-fx-background-color: #000;");
		header.setAlignment(Pos.CENTER);

		// Bouton retour
		backButton.setStyle(
				"-fx-background-color: #000; -fx-text-fill: #fff; -fx-border-color: #fff; -fx-border-width: 2;");
		backButton.setAlignment(Pos.CENTER_LEFT);

		// Titre
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
		
		
		// Errors conducteurs
		cNomError.setTextFill(Color.RED);
		cPrenomError.setTextFill(Color.RED);
		cEmailError.setTextFill(Color.RED);
		cMdpError.setTextFill(Color.RED);
		cConfirmerMdpError.setTextFill(Color.RED);
		cTarifError.setTextFill(Color.RED);
		cConditionsError.setTextFill(Color.RED);

		// Conducteur
		conducteurPane.add(cNom, 0, 0);
		conducteurPane.add(cNomField, 0, 1);
		conducteurPane.add(cNomError, 0, 2);
		
		conducteurPane.add(cPrenom, 0, 3);
		conducteurPane.add(cPrenomField, 0, 4);
		conducteurPane.add(cPrenomError, 0, 5);
		
		conducteurPane.add(cEmail, 0, 6);
		conducteurPane.add(cEmailField, 0, 7);
		conducteurPane.add(cEmailError, 0, 8);
		
		conducteurPane.add(cMdp, 1, 0);
		conducteurPane.add(cMdpField, 1, 1);
		conducteurPane.add(cMdpError, 1, 2);
		
		conducteurPane.add(cConfirmerMdp, 1, 3);
		conducteurPane.add(cConfirmerMdpField, 1, 4);
		conducteurPane.add(cConfirmerMdpError, 1, 5);
		
		conducteurPane.add(cTarif, 1, 6);
		conducteurPane.add(cTarifField, 1, 7);
		conducteurPane.add(cTarifError, 1, 8);
		
		conducteurPane.add(cMajeur, 0, 9, 2, 1);
		conducteurPane.add(cConditions, 0, 10, 2, 1);
		conducteurPane.add(cConditionsError, 0, 11, 2, 1);
		
		conducteurPane.add(cConnexion, 0, 12);
		conducteurPane.add(cNext, 1, 12);

		GridPane.setHalignment(cNext, HPos.RIGHT);

		conducteurPane.setPadding(new Insets(20, 30, 10, 30));
		conducteurPane.setMinWidth(640);
		conducteurPane.setHgap(30);
		conducteurPane.setVgap(7);

		GridPane.setHgrow(cNom, Priority.ALWAYS);
		GridPane.setHgrow(cMdp, Priority.ALWAYS);

		conducteurTab.setText("Conducteur");
		conducteurTab.setContent(conducteurPane);
		
		
		// Errors passager
		pNomError.setTextFill(Color.RED);
		pPrenomError.setTextFill(Color.RED);
		pEmailError.setTextFill(Color.RED);
		pMdpError.setTextFill(Color.RED);
		pConfirmerMdpError.setTextFill(Color.RED);
		pConditionsError.setTextFill(Color.RED);
		
		// Passager
		passagerPane.add(pNom, 0, 0);
		passagerPane.add(pNomField, 0, 1);
		passagerPane.add(pNomError, 0, 2);
		
		passagerPane.add(pPrenom, 0, 3);
		passagerPane.add(pPrenomField, 0, 4);
		passagerPane.add(pPrenomError, 0, 5);
		
		passagerPane.add(pEmail, 0, 6);
		passagerPane.add(pEmailField, 0, 7);
		passagerPane.add(pEmailError, 0, 8);
		
		passagerPane.add(pMdp, 1, 0);
		passagerPane.add(pMdpField, 1, 1);
		passagerPane.add(pMdpError, 1, 2);
		
		passagerPane.add(pConfirmerMdp, 1, 3);
		passagerPane.add(pConfirmerMdpField, 1, 4);
		passagerPane.add(pConfirmerMdpError, 1, 5);
		
		passagerPane.add(pMajeur, 0, 9, 2, 1);
		passagerPane.add(pConditions, 0, 10, 2, 1);
		passagerPane.add(pConditionsError, 0, 11, 2, 1);
		
		passagerPane.add(pConnexion, 0, 12);
		passagerPane.add(pNext, 1, 12);

		GridPane.setHalignment(pNext, HPos.RIGHT);

		// passagerPane.setGridLinesVisible(true);
		passagerPane.setPadding(new Insets(20, 30, 30, 30));
		passagerPane.setMinWidth(640);
		passagerPane.setHgap(30);
		passagerPane.setVgap(7);

		GridPane.setHgrow(pNom, Priority.ALWAYS);
		GridPane.setHgrow(pMdp, Priority.ALWAYS);

		passagerTab.setText("Passager");
		passagerTab.setContent(passagerPane);

		
		
		
		// Tabs
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		tabPane.getTabs().addAll(passagerTab, conducteurTab);
		tabPane.setMinHeight(300);

		
		root.setMinHeight(480);
		root.setMinWidth(640);
		root.setTop(header);
		root.setCenter(tabPane);

		return root;
	}
}
