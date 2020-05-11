package fr.iutlannion.auth;

import fr.iutlannion.core.Window;
import fr.iutlannion.manager.Utilisateur;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.*;

public class PageEditionProfil extends Stage {
	//HEADER
	private BorderPane root = new BorderPane();
	private HBox header = new HBox();
	private Button backButton = new Button("Retour");
	private Label title = new Label("EDITION PROFIL");
	private Label logo = new Label("UTaxi");
	
	//CONTENU
	private GridPane gridPane = new GridPane();
	
	private Label label1 = new Label("Nom :");
	private Label label2 = new Label("Prénom :");
	private Label label3 = new Label("Mail :");
	private Label label4 = new Label("Mot de passe :");
	private Label actuel = new Label("actuel");
	private Label nv = new Label("nouveau");
	private Label erreur = new Label("Erreur de mot de passe");
	
	
	private TextField textField1 = new TextField();
	private TextField textField2 = new TextField();
	private TextField textField3 = new TextField();
	private PasswordField passwordField1 = new PasswordField();
	private PasswordField passwordField2 = new PasswordField();
	
	private Button buttonAnnuler = new Button("Annuler");
    private Button buttonOk = new Button("OK");
    
	public PageEditionProfil() {
		backButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Window.getInstance().gotoPage("mainMenu");
            }
        }));
		
		buttonAnnuler.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Window.getInstance().gotoPage("mainMenu");
            }
        }));
		
		buttonOk.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if(passwordField1.getText().compareTo(Utilisateur.getInstance().getPersonne().getMotDePasse())==0) {
					
					Utilisateur.getInstance().getPersonne().modifierInfo(textField1.getText(), textField2.getText(), textField3.getText(), passwordField2.getText());
				}else {
					root.setBottom(erreur);
				}
			}
		}));
	}
	
	public Parent creerContenu() {
		
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
		
		//
			erreur.setTextFill(Color.RED);
		
			Label nom = new Label(Utilisateur.getInstance().getPersonne().getNom());
			Label prenom =new Label(Utilisateur.getInstance().getPersonne().getPrenom());
			Label mail = new Label(Utilisateur.getInstance().getPersonne().getEmail());
		    GridPane gridPane = new GridPane();
	        gridPane.setPadding(new Insets(30));
	        gridPane.setVgap(5);
	        gridPane.setHgap(5);
	        gridPane.setAlignment(Pos.TOP_CENTER);
	        
	        buttonAnnuler.setPrefWidth(90);
	        buttonOk.setPrefWidth(70);
	       
	        gridPane.add(label1, 0,0);
	        gridPane.add(nom, 1,0);
	        gridPane.add(textField1, 2, 0);
	        gridPane.add(label2, 0,2);
	        gridPane.add(prenom, 1,2);
	        gridPane.add(textField2, 2,2);
	        gridPane.add(label3, 0,4);
	        gridPane.add(mail, 1,4);
	        gridPane.add(textField3, 2,4);
	        gridPane.add(label4, 0,6);
	        gridPane.add(actuel, 1,6);
	        gridPane.add(passwordField1, 2,6);
	        gridPane.add(nv, 1,7);
	        gridPane.add(passwordField2, 2,7);
	        gridPane.add(buttonOk, 1, 9);
	        gridPane.add(buttonAnnuler, 2, 9);
	        GridPane.setHalignment(buttonAnnuler, HPos.RIGHT);
	        GridPane.setHalignment(nom, HPos.RIGHT);
	        GridPane.setHalignment(prenom, HPos.RIGHT);
	        GridPane.setHalignment(mail, HPos.RIGHT);
	        GridPane.setHalignment(actuel, HPos.RIGHT);
	        GridPane.setHalignment(nv, HPos.RIGHT);
	        
		
	        root.setTop(header);
			root.setCenter(gridPane);
			
			return root;
	}
}

