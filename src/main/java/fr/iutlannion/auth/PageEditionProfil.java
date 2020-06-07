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
	
	private Label label1 = new Label("Nom");
	private Label label2 = new Label("PrÃ©nom");
	private Label label3 = new Label("Mail");
	private Label actuel = new Label("Mot de passe actuel");
	private Label nv = new Label("Nouveau mot de passe");
	private Label bottomText=new Label("");
	
	
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
                Window.getInstance().gotoPage("menuPrincipal");
            }
        }));
		
		buttonAnnuler.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Window.getInstance().gotoPage("menuPrincipal");
            }
        }));
		
		buttonOk.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if(passwordField1.getText().compareTo(Utilisateur.getInstance().getPersonne().getMotDePasse())==0) {
					Utilisateur.getInstance().getPersonne().modifierInfo(textField1.getText(), textField2.getText(), textField3.getText(), passwordField2.getText());
					textField1.setText(Utilisateur.getInstance().getPersonne().getNom());
					textField2.setText(Utilisateur.getInstance().getPersonne().getPrenom());
					textField3.setText(Utilisateur.getInstance().getPersonne().getEmail());
					passwordField1.setText(null);
					passwordField2.setText(null);
					bottomText= new Label("Modifications validées");
					bottomText.setTextFill(Color.GREEN);
					root.setBottom(bottomText);
				}else {
					bottomText= new Label("Erreur de mot de passe");
					bottomText.setTextFill(Color.RED);
					root.setBottom(bottomText);
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
			bottomText.setTextFill(Color.WHITE);
	
	        gridPane.setPadding(new Insets(30));
	        gridPane.setVgap(10);
	        gridPane.setHgap(10);
			GridPane.setHgrow(label1, Priority.ALWAYS);
			
			textField1.setText(Utilisateur.getInstance().getPersonne().getNom());
			textField2.setText(Utilisateur.getInstance().getPersonne().getPrenom());
			textField3.setText(Utilisateur.getInstance().getPersonne().getEmail());
			
	        buttonAnnuler.setPrefWidth(90);
	        buttonOk.setPrefWidth(70);
	       
	        gridPane.add(label1, 0,0);
	        gridPane.add(textField1, 0,1);
	        gridPane.add(label2, 0,2);
	        gridPane.add(textField2, 0,3);
	        gridPane.add(label3, 0,4);
	        gridPane.add(textField3, 0,5);
	        gridPane.add(actuel, 0,6);
	        gridPane.add(passwordField1, 0,7);
	        gridPane.add(nv, 0,8);
	        gridPane.add(passwordField2, 0,9);
	        gridPane.add(buttonOk, 0,10);
	        gridPane.add(buttonAnnuler, 1,10);
	        
	        GridPane.setHalignment(buttonAnnuler, HPos.RIGHT);
	        
		
	        root.setTop(header);
			root.setCenter(gridPane);
			
			return root;
	}
}

