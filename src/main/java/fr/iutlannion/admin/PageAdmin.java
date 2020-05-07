package fr.iutlannion.admin;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.collections.*;

import fr.iutlannion.manager.Admins;
import fr.iutlannion.auth.Admin;

public class PageAdmin extends Stage {

    private GridPane gridPane = new GridPane();
    private Label label1 = new Label("Page admin");

    ObservableList<Admin> admins = FXCollections.observableArrayList(Admins.getInstance().getListAdmin());
    ListView<Admin> listViewAdmin = new ListView<Admin>(admins);

    private ListView listViewPassager = new ListView();
    private ListView listViewConducteur = new ListView();
    private Button button = new Button("Edit Admin info");

    public PageAdmin() {

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
