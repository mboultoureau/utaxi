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

public class PageReview extends Stage {
    // HEADER
    private BorderPane root = new BorderPane();
    private HBox header = new HBox();
    private Label title = new Label("Course fini");
    private Label logo = new Label("UTaxi");

    // CONTENU
    private GridPane gridPane = new GridPane();

    private Label label1 = new Label("");

    private Label label2 = new Label("Note : ");

    private Button buttonOk = new Button("Valider");

    public PageReview() {
        buttonOk.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Window.getInstance().gotoPage("mainMenu");
            }
        }));

    }

    public Parent creerContenu() {

        header.setPadding(new Insets(0, 20, 0, 20));

        header.setPrefHeight(50);
        header.setStyle("-fx-background-color: #000;");
        header.setAlignment(Pos.CENTER);

        // Title
        title.setStyle("-fx-text-fill: #fff;");
        title.setAlignment(Pos.CENTER);
        title.setFont(new Font("Arial", 20));
        title.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(title, Priority.ALWAYS);

        // Logo
        logo.setStyle("-fx-text-fill: #fff;");
        logo.setAlignment(Pos.CENTER_RIGHT);

        header.getChildren().addAll(title, logo);

        gridPane.setPadding(new Insets(30));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        GridPane.setHgrow(label1, Priority.ALWAYS);

        label1.setText("Note et pourboire pour le conducteur " + Utilisateur.getInstance().getPersonne().getNom());
        label1.setFont(new Font("Arial", 16));

        buttonOk.setPrefWidth(70);
        // column, row
        gridPane.add(label1, 0, 0, 1, 1);
        gridPane.add(label2, 0, 1);
        gridPane.add(buttonOk, 1, 2);

        root.setTop(header);
        root.setCenter(gridPane);

        return root;
    }
}
