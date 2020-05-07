package fr.iutlannion.admin;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.input.MouseEvent;
import javafx.collections.*;
import javafx.event.EventHandler;
import fr.iutlannion.manager.*;
import fr.iutlannion.auth.*;

public class PageAdmin extends Stage {

    private GridPane gridPane = new GridPane();
    private Label label1 = new Label("Page admin");

    private ObservableList<Admin> admins = FXCollections.observableArrayList(Admins.getInstance().getListAdmin());
    private ListView<Admin> listViewAdmin = new ListView<Admin>(admins);

    private ObservableList<Passager> passagers = FXCollections
            .observableArrayList(Passagers.getInstance().getListPassager());
    private ListView<Passager> listViewPassager = new ListView<Passager>(passagers);

    private ObservableList<Conducteur> conducteurs = FXCollections
            .observableArrayList(Conducteurs.getInstance().getListConducteur());
    private ListView<Conducteur> listViewConducteur = new ListView<Conducteur>(conducteurs);

    private Button buttonEditAdmin = new Button("Edit Admin info");
    private Button buttonEditPassager = new Button("Edit Passager info");

    public PageAdmin() {
        buttonEditAdmin.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println(listViewAdmin.getSelectionModel().getSelectedItem());
            }
        }));
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
        gridPane.add(buttonEditAdmin, 1, 1);
        gridPane.add(buttonEditPassager, 1, 2);

        return gridPane;
    }
}
