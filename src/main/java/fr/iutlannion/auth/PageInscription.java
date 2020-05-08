package fr.iutlannion.auth;

import fr.iutlannion.core.Window;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PageInscription extends Stage {

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
	private Label cPrenom = new Label("Prenom");
	private TextField cPrenomField = new TextField();
	private Label cEmail = new Label("Email");
	private TextField cEmailField = new TextField();
	private Label cMdp = new Label("Mot de passe");
	private TextField cMdpField = new PasswordField();
	private Label cConfirmerMdp = new Label("Confirmer le mot de passe");
	private TextField cConfirmerMdpField = new PasswordField();
	private Label cTarif = new Label("Tarif (en euros)");
	private TextField cTarifField = new TextField();
	private CheckBox cMajeur = new CheckBox("Je reconnais être majeur dans le pays où je m'inscrit.");
	private CheckBox cConditions = new CheckBox("Je reconnais avoir lu les conditions générales d'utilisation et de ventes et les acceptent.");
	private Button cConnexion = new Button("J'ai déjà un compte");
	private Button cNext = new Button("Suivant");
	
	// Passager
	private GridPane passagerPane = new GridPane();
	private Label pNom = new Label("Nom");
	private TextField pNomField = new TextField();
	private Label pPrenom = new Label("Prenom");
	private TextField pPrenomField = new TextField();
	private Label pEmail = new Label("Email");
	private TextField pEmailField = new TextField();
	private Label pMdp = new Label("Mot de passe");
	private TextField pMdpField = new PasswordField();
	private Label pConfirmerMdp = new Label("Confirmer le mot de passe");
	private TextField pConfirmerMdpField = new PasswordField();
	private CheckBox pMajeur = new CheckBox("Je reconnais être majeur dans le pays où je m'inscrit.");
	private CheckBox pConditions = new CheckBox("Je reconnais avoir lu les conditions générales d'utilisation et de ventes et les acceptent.");
	private Button pConnexion = new Button("J'ai déjà un compte");
	private Button pNext = new Button("Suivant");
	
	

	public PageInscription() {		
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
	}

	public Parent creerContenu() {
		
		// Header
		header.setMinWidth(640);
		header.setPadding(new Insets(0, 20, 0, 20));
		
		header.setPrefHeight(50);
		header.setStyle("-fx-background-color: #000;");
		header.setAlignment(Pos.CENTER);
	
		// Back
		backButton.setStyle("-fx-background-color: #000; -fx-text-fill: #fff; -fx-border-color: #fff; -fx-border-width: 2;");
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
		
		
		// Conducteur
		conducteurPane.add(cNom, 0, 0);
		conducteurPane.add(cNomField, 0, 1);
		conducteurPane.add(cPrenom, 0, 2);
		conducteurPane.add(cPrenomField, 0, 3);
		conducteurPane.add(cEmail, 0, 4);
		conducteurPane.add(cEmailField, 0, 5);
		conducteurPane.add(cMdp, 1, 0);
		conducteurPane.add(cMdpField, 1, 1);
		conducteurPane.add(cConfirmerMdp, 1, 2);
		conducteurPane.add(cConfirmerMdpField, 1, 3);
		conducteurPane.add(cTarif, 1, 4);
		conducteurPane.add(cTarifField, 1, 5);
		conducteurPane.add(cMajeur, 0, 8, 2, 1);
		conducteurPane.add(cConditions, 0, 9, 2, 1);
		conducteurPane.add(cConnexion, 0, 12);
		conducteurPane.add(cNext, 1, 12);

		GridPane.setHalignment(cNext, HPos.RIGHT);
		
		conducteurPane.setPadding(new Insets(30, 30, 30, 30));
		conducteurPane.setMinWidth(640);
		conducteurPane.setHgap(30);
		conducteurPane.setVgap(10);
		
		GridPane.setHgrow(cNom, Priority.ALWAYS);
		GridPane.setHgrow(cMdp, Priority.ALWAYS);
		
		conducteurTab.setText("Conducteur");
		conducteurTab.setContent(conducteurPane);
		
		
		// Passager
		passagerPane.add(pNom, 0, 0);
		passagerPane.add(pNomField, 0, 1);
		passagerPane.add(pPrenom, 0, 2);
		passagerPane.add(pPrenomField, 0, 3);
		passagerPane.add(pEmail, 0, 4);
		passagerPane.add(pEmailField, 0, 5);
		passagerPane.add(pMdp, 1, 0);
		passagerPane.add(pMdpField, 1, 1);
		passagerPane.add(pConfirmerMdp, 1, 2);
		passagerPane.add(pConfirmerMdpField, 1, 3);
		passagerPane.add(pMajeur, 0, 8, 2, 1);
		passagerPane.add(pConditions, 0, 9, 2, 1);
		passagerPane.add(pConnexion, 0, 12);
		passagerPane.add(pNext, 1, 12);
		
		GridPane.setHalignment(pNext, HPos.RIGHT);
		
		// passagerPane.setGridLinesVisible(true);
		passagerPane.setPadding(new Insets(30, 30, 30, 30));
		passagerPane.setMinWidth(640);
		passagerPane.setHgap(30);
		passagerPane.setVgap(10);
		
		GridPane.setHgrow(pNom, Priority.ALWAYS);
		GridPane.setHgrow(pMdp, Priority.ALWAYS);
		
		passagerTab.setText("Passager");
		passagerTab.setContent(passagerPane);
		

		// Tabs
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		tabPane.getTabs().addAll(passagerTab, conducteurTab);
		tabPane.setMinHeight(405);
		
		root.setTop(header);
		root.setCenter(tabPane);
		
		return root;
	}
}
