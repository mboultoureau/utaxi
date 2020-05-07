package fr.iutlannion.auth;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PageEditionProfil extends Stage {
	GridPane gridPane = new GridPane();
	Label titre = new Label("Edition de profil :");
	Label label1 = new Label("Nom :");
	Label label2 = new Label("Prénom :");
	Label label3 = new Label("Mail :");
	Label label4 = new Label("Mot de passe :");
	Label label5 = new Label("");
	
	Label actuel = new Label("actuel");
	Label nv = new Label("nouveau");
	
	private TextField textField1 = new TextField();
	private TextField textField2 = new TextField();
	private TextField textField3 = new TextField();
	private PasswordField passwordField1 = new PasswordField();
	private PasswordField passwordField2 = new PasswordField();
	
	private Button buttonAnnuler = new Button("Annuler");
    private Button buttonOk = new Button("OK");
    
	public PageEditionProfil() {
		
	}
	
	public Parent creerContenu() {
			Label nom = new Label("nom");
			Label prenom =new Label("prenom");
			Label mail = new Label("mail");
		 GridPane gridPane = new GridPane();
	        gridPane.setPadding(new Insets(10));
	        gridPane.setVgap(5);
	        gridPane.setHgap(5);
	        
	        buttonAnnuler.setPrefWidth(90);
	        buttonOk.setPrefWidth(70);
	        
	        
	        gridPane.add(titre, 0, 0);
	        gridPane.add(label1, 0,1);
	        gridPane.add(nom, 0,1);
	        gridPane.add(textField1, 1, 1);
	        gridPane.add(label2, 0,3);
	        gridPane.add(prenom, 0,3);
	        gridPane.add(textField2, 1,3);
	        gridPane.add(label3, 0,5);
	        gridPane.add(mail, 0,5);
	        gridPane.add(textField3, 1,5);
	        gridPane.add(label4, 0,7);
	        gridPane.add(actuel, 0,8);
	        gridPane.add(passwordField1, 1,8);
	        gridPane.add(nv, 0,9);
	        gridPane.add(passwordField2, 1,9);
	        gridPane.add(buttonOk, 1, 10);
	        gridPane.add(buttonAnnuler, 1, 10);
	        GridPane.setHalignment(buttonAnnuler, HPos.RIGHT);
	        GridPane.setHalignment(nom, HPos.RIGHT);
	        GridPane.setHalignment(prenom, HPos.RIGHT);
	        GridPane.setHalignment(mail, HPos.RIGHT);
	        GridPane.setHalignment(actuel, HPos.RIGHT);
	        GridPane.setHalignment(nv, HPos.RIGHT);
	        GridPane.setHalignment(titre, HPos.CENTER);

		
		return gridPane;
	}
}

