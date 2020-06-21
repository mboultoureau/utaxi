package fr.iutlannion.auth;

import fr.iutlannion.core.Window;
import fr.iutlannion.manager.Conducteur;
import fr.iutlannion.manager.Utilisateurs;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Cette page permet d'éditer sa voiture
 */
public class PageEditionVoiture extends Stage{
	//HEADER
		private BorderPane root = new BorderPane();
		private HBox header = new HBox();
		private Button backButton = new Button("Retour");
		private Label title = new Label("EDITION VOITURE");
		private Label logo = new Label("UTaxi");
		
		//CONTENU
		private GridPane gridPane = new GridPane();
		
		private Label tarif = new Label("Tarif");
		private Label nbkm = new Label("Nombre de km");
		private Label immat = new Label("Immatriculation");
		private Label marque = new Label("Marque");
		private Label tEss = new Label("Type Essence");
		private Label couleur = new Label("Couleur");
		private Label type = new Label("Type");
		private Label mdp = new Label("Mot de passe");
		
		private TextField ftarif = new TextField();
		private TextField fnbkm = new TextField();
		private TextField fimmat = new TextField();
		private TextField fmarque = new TextField();
		private TextField ftEss = new TextField();
		private TextField fcouleur = new TextField();
		private TextField ftype = new TextField();
		private PasswordField fmdp = new PasswordField();
		
		private Button buttonAnnuler = new Button("Annuler");
	    private Button buttonOk = new Button("OK");
	    
	    private Alert erreur = new Alert(AlertType.ERROR);
	    private Alert modifOk = new Alert(AlertType.INFORMATION);
	    
	    Conducteur c = (Conducteur) Utilisateurs.getPersonneCourante();
	    
		public PageEditionVoiture() {
			backButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
	            public void handle(MouseEvent event) {
	                Window.getInstance().gotoPage("conducteur");
	            }
	        }));
			
			buttonAnnuler.setOnMouseClicked((new EventHandler<MouseEvent>() {
	            public void handle(MouseEvent event) {
	                Window.getInstance().gotoPage("conducteur");
	            }
	        }));
			
			buttonOk.setOnMouseClicked((new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					if(fmdp.getText().compareTo(Utilisateurs.getPersonneCourante().getMotDePasse())==0) {
						if(ftarif.getText().trim().isEmpty())
							ftarif.setText(String.valueOf(c.getTarif()));
						if(fnbkm.getText().trim().isEmpty())
							fnbkm.setText(String.valueOf(c.getNbKmParcourus()));
						if(fimmat.getText().trim().isEmpty())
							fimmat.setText(c.getVoiture().getImmatriculation());
						if(fmarque.getText().trim().isEmpty())
							fmarque.setText(c.getVoiture().getMarque());
						if(ftEss.getText().trim().isEmpty())
							ftEss.setText(c.getVoiture().getTypeEssence());
						if(fcouleur.getText().trim().isEmpty())
							fcouleur.setText(c.getVoiture().getCouleur());
						if(ftype.getText().trim().isEmpty())
							ftype.setText(c.getVoiture().getType());
						
						c.modifierInfoVoiture(Double.valueOf(ftarif.getText()), Double.valueOf(fnbkm.getText()),fimmat.getText(), fmarque.getText(), ftEss.getText(), fcouleur.getText(), ftype.getText());
						
						fmdp.setText(null);
						modifOk.show();
					}else {
						erreur.show();
						
						ftarif.setText(String.valueOf(c.getTarif()));
						fnbkm.setText(String.valueOf(c.getNbKmParcourus()));
						fimmat.setText(c.getVoiture().getImmatriculation());
						fmarque.setText(c.getVoiture().getMarque());
						ftEss.setText(c.getVoiture().getTypeEssence());
						fcouleur.setText(c.getVoiture().getCouleur());
						ftype.setText(c.getVoiture().getType());
						fmdp.setText(null);
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
		        gridPane.setPadding(new Insets(30));
		        gridPane.setVgap(10);
		        gridPane.setHgap(10);
				GridPane.setHgrow(tarif, Priority.ALWAYS);
				
				ftarif.setText(String.valueOf(c.getTarif()));
				fnbkm.setText(String.valueOf(c.getNbKmParcourus()));
				fimmat.setText(c.getVoiture().getImmatriculation());
				fmarque.setText(c.getVoiture().getMarque());
				ftEss.setText(c.getVoiture().getTypeEssence());
				fcouleur.setText(c.getVoiture().getCouleur());
				ftype.setText(c.getVoiture().getType());
				
		        buttonAnnuler.setPrefWidth(90);
		        buttonOk.setPrefWidth(70);
		        
		        erreur.setTitle("Erreur de mot de passe");
				erreur.setHeaderText("Le mot de passe actuel n'est pas le bon, les modifications n'ont pas été apportées.");
				
				modifOk.setTitle("Mofication effectuées");
				modifOk.setHeaderText("Les modifications ont bien été effectuées.");
		       
		        gridPane.add(tarif, 0,0);
		        gridPane.add(ftarif, 0,1);
		        gridPane.add(nbkm, 0,2);
		        gridPane.add(fnbkm, 0,3);
		        gridPane.add(immat, 0,4);
		        gridPane.add(fimmat, 0,5);
		        gridPane.add(marque, 0,6);
		        gridPane.add(fmarque, 0,7);
		        gridPane.add(tEss, 0,8);
		        gridPane.add(ftEss, 0,9);
		        gridPane.add(couleur, 0,10);
		        gridPane.add(fcouleur, 0,11);
		        gridPane.add(type, 0,12);
		        gridPane.add(ftype, 0,13);
		        gridPane.add(mdp, 0, 14);
		        gridPane.add(fmdp, 0, 15);
		        gridPane.add(buttonOk, 0,16);
		        gridPane.add(buttonAnnuler, 1,16);
		        
		        GridPane.setHalignment(buttonAnnuler, HPos.RIGHT);
		        
			
		        root.setTop(header);
				root.setCenter(gridPane);
				
				return root;
		}
	}


