package fr.iutlannion;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Window extends Stage {

    private Label label1 = new Label("Connexion à PStage");
    private Label label2 = new Label("Nom :");
    private Label label3 = new Label("Mot de passe :");
    private Label label4 = new Label("Page principal");

    private Button buttonAnnuler = new Button("Annuler");
    private Button buttonOk = new Button("OK");

    private TextField textField = new TextField();
    private PasswordField passwordField = new PasswordField();

    public Window() {
        this.setTitle("Ma première fenêtre");
        this.setWidth(300);
        this.setHeight(150);
        this.setMinWidth(250);
        this.setMinHeight(250);
        this.setX(0);
        this.setY(0);
        this.setResizable(false);
        final Scene scenePrincipal = new Scene(principal(), 750, 500);
        Scene sceneConnexion = new Scene(connexion(), 220, 200);

        this.setScene(sceneConnexion);
        final Window self = this;

        buttonOk.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("Hello World");
                self.setScene(scenePrincipal);
                self.setWidth(750);
                self.setHeight(500);
            }
        }));
    }

    Parent connexion() {

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
        gridPane.setHalignment(buttonAnnuler, HPos.RIGHT);
        gridPane.setHalignment(label1, HPos.CENTER);

        return gridPane;
    }

    Parent principal() {

        GridPane gridPane1 = new GridPane();
        gridPane1.setPadding(new Insets(10));
        gridPane1.setAlignment(Pos.CENTER);
        gridPane1.setVgap(5);
        gridPane1.setHgap(5);
        gridPane1.add(label4, 0, 0);

        return gridPane1;
    }

}