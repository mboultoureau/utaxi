package fr.iutlannion.admin;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class PageAdmin extends Stage {

    private GridPane gridPane = new GridPane();
    private Label label1 = new Label("Page admin");
    private ListView listViewAdmin = new ListView();
    private ListView listViewPassager = new ListView();
    private ListView listViewConducteur = new ListView();
    private Button button = new Button("Read Selected Value");

    public PageAdmin() {

        listViewAdmin.getItems().add("Item 1");
        listViewAdmin.getItems().add("Item 2");
        listViewAdmin.getItems().add("Item 1");

    }

    public Parent creerContenu() {
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER_LEFT);
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setGridLinesVisible(true);

        listViewAdmin.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listViewPassager.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listViewConducteur.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        /* Colonne, Ligne */
        gridPane.add(label1, 0, 0);
        gridPane.add(listViewAdmin, 0, 1);
        gridPane.add(listViewPassager, 0, 2);
        gridPane.add(listViewConducteur, 0, 3);
        gridPane.add(button, 1, 2);

        return gridPane;
    }
}
