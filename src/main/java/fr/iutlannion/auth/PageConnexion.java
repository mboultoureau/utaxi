package fr.iutlannion.auth;

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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import fr.iutlannion.manager.Conducteurs;
import fr.iutlannion.manager.Passagers;
import fr.iutlannion.manager.Admins;
import fr.iutlannion.core.Window;

public class PageConnexion extends Stage {

    private BorderPane root = new BorderPane();

    // Header
    private HBox header = new HBox();
    private Button backButton = new Button("Retour");
    private Label title = new Label("Connexion");
    private Label logo = new Label("UTaxi");

    // Center
    private Label connexionLabel = new Label("Connexion à UTaxi");
    private Label emailLabel = new Label("Adresse e-mail :");
    private Label mdpLabel = new Label("Mot de passe :");
    private Label erreurLabel = new Label("");
    private TextField textField = new TextField();
    private PasswordField passwordField = new PasswordField();

    // Buttons
    private HBox buttons = new HBox();
    private Button buttonAnnuler = new Button("Annuler");
    private Region space = new Region();
    private Button buttonOk = new Button("OK");

    private GridPane center = new GridPane();

    public PageConnexion() {

        Window.getInstance().setResizable(true);

        buttonOk.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (Conducteurs.getInstance().verifConnexion(textField.getText(), passwordField.getText()) != null) {
                    Window.getInstance().gotoPage("conducteur");
                    Utilisateur.getInstance().setPersonne(Conducteurs.getInstance().verifConnexion(textField.getText(), passwordField.getText()));
                } else if (Passagers.getInstance().verifConnexion(textField.getText(),
                        passwordField.getText()) != null) {
                    Window.getInstance().gotoPage("passager");
                    Utilisateur.getInstance().setPersonne(Passagers.getInstance().verifConnexion(textField.getText(), passwordField.getText()));
                } else if (Admins.getInstance().verifConnexion(textField.getText(), passwordField.getText()) != null) {
                    Window.getInstance().gotoPage("admin");
                    Utilisateur.getInstance().setPersonne(Admins.getInstance().verifConnexion(textField.getText(), passwordField.getText()));
                } else if (textField.getText().compareTo("") == 0 || passwordField.getText().compareTo("") == 0) {
                    erreurLabel.setText("Erreur, champs vide(s)");
                } else {
                    erreurLabel.setText("Email/mot de passe invalide");
                }
            }
        }));

        buttonAnnuler.setOnAction(e -> Window.getInstance().gotoPage("menuPrincipal"));

        backButton.setOnAction(e -> Window.getInstance().gotoPage("menuPrincipal"));
    }

    public Parent creerContenu() {

        // Header
        header.setMinWidth(640);
        header.setPadding(new Insets(0, 20, 0, 20));

        header.setPrefHeight(50);
        header.setStyle("-fx-background-color: #000;");
        header.setAlignment(Pos.CENTER);

        // Bouton retour
        backButton.setStyle(
                "-fx-background-color: #000; -fx-text-fill: #fff; -fx-border-color: #fff; -fx-border-width: 2;");
        backButton.setAlignment(Pos.CENTER_LEFT);

        // Titre
        title.setStyle("-fx-text-fill: #fff;");
        title.setAlignment(Pos.CENTER);
        title.setFont(new Font("Arial", 20));
        title.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(title, Priority.ALWAYS);

        // Logo
        logo.setStyle("-fx-text-fill: #fff;");
        logo.setAlignment(Pos.CENTER_RIGHT);

        header.getChildren().addAll(backButton, title, logo);

        // Center
        center.setPadding(new Insets(10));
        center.setAlignment(Pos.CENTER);
        center.setVgap(25);
        center.setHgap(5);
        center.setMinWidth(640);
        center.setMinHeight(305);

        // Title
        connexionLabel.setStyle("-fx-text-fill: #000;");
        connexionLabel.setTextAlignment(TextAlignment.CENTER);
        connexionLabel.setFont(new Font("Arial", 30));
        connexionLabel.setAlignment(Pos.CENTER);

        buttonAnnuler.setPrefWidth(70);
        buttonOk.setPrefWidth(70);
        erreurLabel.setTextFill(Color.RED);

        center.add(connexionLabel, 0, 0, 2, 1);
        center.add(emailLabel, 0, 1);
        center.add(textField, 1, 1);
        center.add(mdpLabel, 0, 2);
        center.add(passwordField, 1, 2);
        center.add(erreurLabel, 1, 3, 2, 1);
        GridPane.setHalignment(erreurLabel, HPos.CENTER);

        // Buttons
        // OK
        buttonOk.setAlignment(Pos.CENTER);
        buttonOk.setPrefWidth(150);
        buttonOk.setPrefHeight(50);

        // Annuler
        buttonAnnuler.setAlignment(Pos.CENTER);
        buttonAnnuler.setPrefWidth(150);
        buttonAnnuler.setPrefHeight(50);

        HBox.setHgrow(space, Priority.ALWAYS);

        buttons.getChildren().addAll(buttonAnnuler, space, buttonOk);

        buttons.setPadding(new Insets(25, 50, 25, 50));
        buttons.setSpacing(40);

        root.setTop(header);
        root.setCenter(center);
        root.setBottom(buttons);

        return root;
    }

}
