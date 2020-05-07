package fr.iutlannion.auth;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PageEnregistrementVoiture extends Stage {

	private Label label0 = new Label("ENREGISTREMENT VOITURE");
	private Button buttonPrecedant = new Button("Back");

	private Label label1 = new Label("Immatriculation");
	private TextField textField2 = new TextField();

	private Label label2 = new Label("Marque");
	private TextField textField3 = new TextField();

	private Label label3 = new Label("Type Essence");
	private TextField textField4 = new TextField();

	private Label label4 = new Label("Couleur");
	private TextField textField5 = new TextField();

	private Label label5 = new Label("Type");
	private TextField textField6 = new TextField();

	private Button buttonSuivant = new Button("Next");

	public PageEnregistrementVoiture() {

	}

	public Parent creerContenu() {

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(5);

		return gridPane;

	}
}
