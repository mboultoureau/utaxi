package fr.iutlannion.core;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class PageDebug {
	private BorderPane root = new BorderPane();
	
	private Label title = new Label("Page de débogage");
	
	private VBox buttons = new VBox();
	
	// Pages principales
	private Label pagesPrincipales = new Label("Pages principales");
	private HBox buttonsPrincipales = new HBox();
	private Button buttonMenuPrincipal = new Button("Menu principal");
	private Button buttonConducteur = new Button("Page conducteur");
	private Button buttonPassager = new Button("Page passager");
	
	// Pages d'authentification
	private Label pagesAuthentification = new Label("Pages d'authentification");
	private HBox buttonsAuthentification = new HBox();
    private Button buttonConnexion = new Button("Connexion");
    private Button buttonInscription = new Button("Incription");
    private Button buttonHoraires = new Button("Horaires");
    private Button buttonPaiement = new Button("Paiement");
    private Button buttonEnregistrementVoiture = new Button("Enregistrement voiture");
    
    // Pages d'édition
    private Label pagesEdition = new Label("Pages d'édition");
    private HBox buttonsEdition = new HBox();
    private Button buttonEditer = new Button("Editer profil");
    private Button buttonEditerVoiture = new Button("Editer voiture");
    
    // Pages d'administration et techniques
    private Label pagesAdmin = new Label("Pages d'administration et techniques");
    private HBox buttonsAdmin = new HBox();
    private Button buttonAdmin = new Button("Panel d'administration");
    private Button buttonDebug = new Button("Débug");

    public PageDebug() {
    	// Pages principales
    	buttonMenuPrincipal.setOnAction(e -> Window.getInstance().gotoPage("mainMenu"));
    	
    	// Pages d'authentification
    	buttonConnexion.setOnAction(e -> Window.getInstance().gotoPage("connexion"));
    	buttonInscription.setOnAction(e -> Window.getInstance().gotoPage("inscription"));
    	buttonHoraires.setOnAction(e -> Window.getInstance().gotoPage("horaires"));
    	buttonPaiement.setOnAction(e -> Window.getInstance().gotoPage("paiement"));
    	buttonEnregistrementVoiture.setOnAction(e -> Window.getInstance().gotoPage("enregistrementVoiture"));

    	// Pages d'édition
    	buttonEditer.setOnAction(e -> Window.getInstance().gotoPage("editionProfil"));
    	buttonEditerVoiture.setOnAction(e -> Window.getInstance().gotoPage("editionVoiture"));
    	
    	// Pages d'administration et techniques
    	buttonAdmin.setOnAction(e -> Window.getInstance().gotoPage("admin"));
    	buttonDebug.setOnAction(e -> Window.getInstance().gotoPage("debug"));
    }

    Parent creerContenu() {
    	// Title
    	title.setStyle("-fx-text-fill: #000;");
    	title.setTextAlignment(TextAlignment.CENTER);
    	title.setFont(new Font("Arial", 30));
    	title.setAlignment(Pos.CENTER);
    	title.setPadding(new Insets(10));
    	BorderPane.setAlignment(title, Pos.CENTER);
    	
    	// Disable buttons
    	buttonConducteur.setDisable(true);
    	buttonPassager.setDisable(true);
    	
    	
    	buttonsPrincipales.getChildren().addAll(buttonMenuPrincipal, buttonConducteur, buttonPassager);
    	buttonsPrincipales.setSpacing(10);
    	
    	buttonsAuthentification.getChildren().addAll(buttonConnexion, buttonInscription, buttonHoraires, buttonPaiement, buttonEnregistrementVoiture);
    	buttonsAuthentification.setSpacing(10);
    	
    	buttonsEdition.getChildren().addAll(buttonEditer, buttonEditerVoiture);
    	buttonsEdition.setSpacing(10);
    	
    	buttonsAdmin.getChildren().addAll(buttonAdmin, buttonDebug);
    	buttonsAdmin.setSpacing(10);
    	
    	buttons.setFillWidth(true);
    	buttons.setSpacing(20);
    	buttons.getChildren().addAll(pagesPrincipales, buttonsPrincipales, pagesAuthentification, buttonsAuthentification, pagesEdition, buttonsEdition, pagesAdmin, buttonsAdmin);
    	
        // BorderPane
        root.setTop(title);
        root.setCenter(buttons);
        root.setPadding(new Insets(30));

        return root;
    }

}
