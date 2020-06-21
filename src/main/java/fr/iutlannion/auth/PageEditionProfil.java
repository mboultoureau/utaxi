package fr.iutlannion.auth;

import java.util.Optional;

import fr.iutlannion.core.Window;
import fr.iutlannion.manager.Conducteur;
import fr.iutlannion.manager.Passager;
import fr.iutlannion.manager.Personne;
import fr.iutlannion.manager.Utilisateurs;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

/* La page Edition profil permet la modification du profil d'un utilisateur deja créé
 */
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
	private Label mdpActuel = new Label("Mot de passe actuel *");
	private Label mdpNouveau = new Label("Nouveau mot de passe");
	private Label bottomText=new Label("* champ obligatoire");
	
	
	private TextField tfNom = new TextField();
	private TextField tfPrenom = new TextField();
	private TextField tfMail = new TextField();
	private PasswordField pfMdpActuel = new PasswordField();
	private PasswordField pfMdpNouveau = new PasswordField();
	
	private Button buttonAnnuler = new Button("Annuler");
    private Button buttonOk = new Button("OK");
    private Button suppButton = new Button("Supprimer le compte");
	
	//Erreurs
    private Alert alert= new Alert(AlertType.CONFIRMATION);
    private Alert erreur = new Alert(AlertType.ERROR);
    private Alert modifOk = new Alert(AlertType.INFORMATION);
    
	public PageEditionProfil() {
		suppButton.setOnAction(e ->{
			Optional<ButtonType> option = alert.showAndWait();
			 //Bouton permettant de supprimer son compte ramenant a la page connexion
		      if (option.get() == ButtonType.OK) {
		    	  Utilisateurs.remove(Utilisateurs.getPersonneCourante());
		      	  Window.getInstance().gotoPage("connexion");
		      }      
		
		});
		//Bouton de retour à la page précédente
		backButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
            	Personne personne = Utilisateurs.getPersonneCourante();
            	if(personne instanceof Conducteur)
            		Window.getInstance().gotoPage("conducteur");
            	if(personne instanceof Passager)
            		Window.getInstance().gotoPage("passager");
            }
        }));
		//Bouton de retour à la page précédente avec annulation des modifications (equivalent au précédent)
		buttonAnnuler.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
            	Personne personne = Utilisateurs.getPersonneCourante();
            	if(personne instanceof Conducteur)
            		Window.getInstance().gotoPage("conducteur");
            	if(personne instanceof Passager)
            		Window.getInstance().gotoPage("passager");
            }
        }));
	// Bouton de validation permet de changer les informations par celles entrées ou d'afficher une ou plusieurs erreurs selon les vérifications situées ci-dessous
		buttonOk.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if(pfMdpActuel.getText().compareTo(Utilisateurs.getPersonneCourante().getMotDePasse())==0) {
					if(tfNom.getText().trim().isEmpty())
						tfNom.setText(Utilisateurs.getPersonneCourante().getNom());
					
					if(tfPrenom.getText().trim().isEmpty())
						tfPrenom.setText(Utilisateurs.getPersonneCourante().getPrenom());
					
					if(tfMail.getText().trim().isEmpty())
						tfMail.setText(Utilisateurs.getPersonneCourante().getEmail());
					
					if(pfMdpNouveau.getText().trim().isEmpty())
						pfMdpNouveau.setText(Utilisateurs.getPersonneCourante().getMotDePasse());
					
					Utilisateurs.getPersonneCourante().modifierInfo(tfNom.getText(), tfPrenom.getText(), tfMail.getText(), pfMdpNouveau.getText());
					pfMdpActuel.setText(null);
					pfMdpNouveau.setText(null);
					modifOk.show();
				}else {
					erreur.show();
					tfNom.setText(Utilisateurs.getPersonneCourante().getNom());
					tfPrenom.setText(Utilisateurs.getPersonneCourante().getPrenom());
					tfMail.setText(Utilisateurs.getPersonneCourante().getEmail());
					pfMdpActuel.setText(null);
					pfMdpNouveau.setText(null);
				}
			}
		}));
	}

	//Création du contenu de la page

	public Parent creerContenu() {

		//HEADER

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
		
		//Affichage selon l'utilisateur et implémentation des messages d'erreurs
	
	        gridPane.setPadding(new Insets(30));
	        gridPane.setVgap(10);
	        gridPane.setHgap(10);
			GridPane.setHgrow(labelNom, Priority.ALWAYS);
			
			tfNom.setText(Utilisateurs.getPersonneCourante().getNom());
			tfPrenom.setText(Utilisateurs.getPersonneCourante().getPrenom());
			tfMail.setText(Utilisateurs.getPersonneCourante().getEmail());
			
	        buttonAnnuler.setPrefWidth(90);
	        buttonOk.setPrefWidth(70);
	        suppButton.setPrefWidth(200);
	        
			alert.setTitle("Supprimer le compte");
			alert.setHeaderText("Etes-vous sûr de vouloir supprimer votre compte ?");
			
			erreur.setTitle("Erreur de mot de passe");
			erreur.setHeaderText("Le mot de passe actuel n'est pas le bon, les modifications n'ont pas été apportées.");
			
			modifOk.setTitle("Mofication effectuées");
			modifOk.setHeaderText("Les modifications ont bien été effectuées.");
	       
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
	        gridPane.add(suppButton, 0, 12);
	        
	        GridPane.setHalignment(buttonAnnuler, HPos.RIGHT);
	        
		
	        root.setTop(header);
			root.setCenter(gridPane);
			root.setBottom(bottomText);
			
			return root;
	}
}

