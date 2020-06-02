package fr.iutlannion.auth;

import fr.iutlannion.core.Window;
import fr.iutlannion.manager.Conducteur;
import fr.iutlannion.manager.Utilisateur;
import fr.iutlannion.manager.Personne;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

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
    private Label label3 = new Label("");
    private Label label4 = new Label("Pourboire : ");
    private Label label5 = new Label("");
    private Button buttonOk = new Button("Valider");
    Slider sliderNote = new Slider();
    Slider sliderPourboire = new Slider();

    public PageReview() {
        buttonOk.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Conducteur c = (Conducteur) Utilisateur.getInstance().getInstance().getPersonne();
                c.ajouterNote(sliderNote.getValue());
                Window.getInstance().gotoPage("mainMenu");
            }
        }));

        sliderNote.valueProperty()
                .addListener((obs, oldval, newVal) -> sliderNote.setValue(Math.round(newVal.doubleValue())));

        sliderPourboire.valueProperty()
                .addListener((obs, oldval, newVal) -> sliderPourboire.setValue(Math.round(newVal.doubleValue())));

        sliderNote.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                    Number oldValue, Number newValue) {

                label3.setText(newValue + "/5");
            }
        });

        sliderPourboire.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, //
                    Number oldValue, Number newValue) {

                label5.setText(newValue + "€");
            }
        });

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

        label1.setText("Note et pourboire pour " + Utilisateur.getInstance().getPersonne().getNom());
        label1.setFont(new Font("Arial", 16));

        sliderNote.setMin(0);
        sliderNote.setMax(5);
        sliderNote.setValue(2.5);
        sliderNote.setShowTickLabels(true);
        sliderNote.setShowTickMarks(true);
        sliderNote.setMajorTickUnit(2.5);
        sliderNote.setMinorTickCount(1);
        sliderNote.setBlockIncrement(1);

        sliderPourboire.setMin(0);
        sliderPourboire.setMax(25);
        sliderPourboire.setValue(0);
        sliderPourboire.setShowTickLabels(true);
        sliderPourboire.setShowTickMarks(true);
        sliderPourboire.setMajorTickUnit(12.5);
        sliderPourboire.setMinorTickCount(1);
        sliderPourboire.setBlockIncrement(1);

        buttonOk.setPrefWidth(70);
        buttonOk.setPrefHeight(50);

        gridPane.add(label1, 0, 0, 1, 1);
        gridPane.add(label2, 0, 1);
        gridPane.add(sliderNote, 1, 1);
        gridPane.add(label3, 2, 1);
        gridPane.add(label4, 0, 2);
        gridPane.add(sliderPourboire, 1, 2);
        gridPane.add(label5, 2, 2);
        gridPane.add(buttonOk, 3, 3);

        root.setTop(header);
        root.setCenter(gridPane);

        return root;
    }
}
