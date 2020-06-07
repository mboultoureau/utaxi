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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import fr.iutlannion.manager.Conducteurs;
import fr.iutlannion.manager.Passagers;
import fr.iutlannion.manager.Admins;
import fr.iutlannion.core.Window;

public class PageConnexion extends Stage {

    private Label connexionLabel = new Label("Connexion à PStage");
    private Label nomLabel = new Label("Nom :");
    private Label mdpLabel = new Label("Mot de passe :");
    private Label erreurLabel = new Label("");

    private Button buttonAnnuler = new Button("Annuler");
    private Button buttonOk = new Button("OK");

    private TextField textField = new TextField();
    private PasswordField passwordField = new PasswordField();

    private GridPane root = new GridPane();

    public PageConnexion() {

        Window.getInstance().setResizable(true);

        buttonOk.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (Conducteurs.getInstance().verifConnexion(textField.getText(), passwordField.getText()) != null) {
                    Window.getInstance().gotoPage("conducteur");
                    erreurLabel.setText("");
                    textField.setText("");
                    passwordField.setText("");
                } else if (Passagers.getInstance().verifConnexion(textField.getText(),
                        passwordField.getText()) != null) {
                    Window.getInstance().gotoPage("passager");
                    erreurLabel.setText("");
                    textField.setText("");
                    passwordField.setText("");
                } else if (Admins.getInstance().verifConnexion(textField.getText(), passwordField.getText()) != null) {
                    erreurLabel.setText("");
                    textField.setText("");
                    passwordField.setText("");
                    Window.getInstance().gotoPage("admin");
                } else if (textField.getText().compareTo("") == 0 || passwordField.getText().compareTo("") == 0) {
                    erreurLabel.setText("Erreur, champs vide(s)");
                } else {
                    erreurLabel.setText("Email/mot de passe invalide");
                }
            }
        }));

        buttonAnnuler.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Window.getInstance().gotoPage("menuPrincipal");
            }
        }));
    }

    public Parent creerContenu() {
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        root.setVgap(5);
        root.setHgap(5);
        root.setMinWidth(640);
        root.setMinHeight(455);

        buttonAnnuler.setPrefWidth(70);
        buttonOk.setPrefWidth(70);
        erreurLabel.setTextFill(Color.RED);

        root.add(connexionLabel, 0, 0, 2, 1);
        root.add(nomLabel, 0, 1);
        root.add(textField, 1, 1);
        root.add(mdpLabel, 0, 2);
        root.add(passwordField, 1, 2);
        root.add(buttonOk, 1, 3);
        root.add(buttonAnnuler, 1, 3);
        root.add(erreurLabel, 1, 4, 2, 1);
        GridPane.setHalignment(buttonAnnuler, HPos.RIGHT);
        GridPane.setHalignment(connexionLabel, HPos.CENTER);
        GridPane.setHalignment(erreurLabel, HPos.CENTER);

        return root;
    }

}
