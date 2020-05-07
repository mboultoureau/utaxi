package fr.iutlannion.auth;

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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import fr.iutlannion.manager.Conducteurs;
import fr.iutlannion.manager.Passagers;
import fr.iutlannion.manager.Admins;

public class Connexion extends Stage {

    private Label label1 = new Label("Connexion à PStage");
    private Label label2 = new Label("Nom :");
    private Label label3 = new Label("Mot de passe :");

    private Button buttonAnnuler = new Button("Annuler");
    private Button buttonOk = new Button("OK");

    private TextField textField = new TextField();
    private PasswordField passwordField = new PasswordField();

    public Connexion() {

        buttonOk.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (Conducteurs.getInstance().verifConnexion(textField.getText(), passwordField.getText()) != null) {
                    System.out.println("Conducteur");
                } else if (Passagers.getInstance().verifConnexion(textField.getText(),
                        passwordField.getText()) != null) {
                    System.out.println("Passager");
                } else if (Admins.getInstance().verifConnexion(textField.getText(), passwordField.getText()) != null) {
                    System.out.println("Admin");
                } else {
                    System.out.println("Email/mot de passe invalide");
                }
            }
        }));
    }

    public Parent creerContenu() {

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        /* gridPane.setGridLinesVisible(true); */

        buttonAnnuler.setPrefWidth(70);
        buttonOk.setPrefWidth(70);

        gridPane.add(label1, 0, 0, 2, 1);
        gridPane.add(label2, 0, 1);
        gridPane.add(textField, 1, 1);
        gridPane.add(label3, 0, 2);
        gridPane.add(passwordField, 1, 2);
        gridPane.add(buttonOk, 1, 3);
        gridPane.add(buttonAnnuler, 1, 3);
        GridPane.setHalignment(buttonAnnuler, HPos.RIGHT);
        GridPane.setHalignment(label1, HPos.CENTER);

        return gridPane;
    }

}
