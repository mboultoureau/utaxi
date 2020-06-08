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
	
	private Label labelNom = new Label("Nom");
	private Label labelPrenom = new Label("PrÃ©nom");
	private Label labelMail = new Label("Mail");
	private Label mdpActuel = new Label("Mot de passe actuel");
	private Label mdpNouveau = new Label("Nouveau mot de passe");
	private Label bottomText=new Label("");
	
	
	private TextField tfNom = new TextField();
	private TextField tfPrenom = new TextField();
	private TextField tfMail = new TextField();
	private PasswordField pfMdpActuel = new PasswordField();
	private PasswordField pfMdpNouveau = new PasswordField();
	
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
				if(pfMdpActuel.getText().compareTo(Utilisateur.getInstance().getPersonne().getMotDePasse())==0) {
					if(tfNom.getText().trim().isEmpty())
						tfNom.setText(Utilisateur.getInstance().getPersonne().getNom());
					if(tfPrenom.getText().trim().isEmpty())
						tfPrenom.setText(Utilisateur.getInstance().getPersonne().getPrenom());
					if(tfMail.getText().trim().isEmpty())
						tfMail.setText(Utilisateur.getInstance().getPersonne().getEmail());
					if(pfMdpNouveau.getText().trim().isEmpty())
						pfMdpNouveau.setText(Utilisateur.getInstance().getPersonne().getMotDePasse());
					Utilisateur.getInstance().getPersonne().modifierInfo(tfNom.getText(), tfPrenom.getText(), tfMail.getText(), pfMdpNouveau.getText());
					pfMdpActuel.setText(null);
					pfMdpNouveau.setText(null);
					bottomText.setText("Modifications validées");
					bottomText.setTextFill(Color.GREEN);
					root.setBottom(bottomText);
				}else {
					bottomText.setText("Erreur de mot de passe");
					bottomText.setTextFill(Color.RED);
					root.setBottom(bottomText);
					tfNom.setText(Utilisateur.getInstance().getPersonne().getNom());
					tfPrenom.setText(Utilisateur.getInstance().getPersonne().getPrenom());
					tfMail.setText(Utilisateur.getInstance().getPersonne().getEmail());
					pfMdpActuel.setText(null);
					pfMdpNouveau.setText(null);
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
			GridPane.setHgrow(labelNom, Priority.ALWAYS);
			
			tfNom.setText(Utilisateur.getInstance().getPersonne().getNom());
			tfPrenom.setText(Utilisateur.getInstance().getPersonne().getPrenom());
			tfMail.setText(Utilisateur.getInstance().getPersonne().getEmail());
			
	        buttonAnnuler.setPrefWidth(90);
	        buttonOk.setPrefWidth(70);
	       
	        gridPane.add(labelNom, 0,0);
	        gridPane.add(tfNom, 0,1);
	        gridPane.add(labelPrenom, 0,2);
	        gridPane.add(tfPrenom, 0,3);
	        gridPane.add(labelMail, 0,4);
	        gridPane.add(tfMail, 0,5);
	        gridPane.add(mdpActuel, 0,6);
	        gridPane.add(pfMdpActuel, 0,7);
	        gridPane.add(mdpNouveau, 0,8);
	        gridPane.add(pfMdpNouveau, 0,9);
	        gridPane.add(buttonOk, 0,10);
	        gridPane.add(buttonAnnuler, 1,10);
	        
	        GridPane.setHalignment(buttonAnnuler, HPos.RIGHT);
	        
		
	        root.setTop(header);
			root.setCenter(gridPane);
			root.setBottom(bottomText);
			
			return root;
	}
}

