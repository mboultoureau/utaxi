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
    private Label label2 = new Label("Liste des Admins");
    private Label label3 = new Label("Liste des Passagers");
    private Label label4 = new Label("Liste des Conducteurs");
    private Label label5 = new Label("Nom :");

    private ObservableList<Admin> admins = FXCollections.observableArrayList(Admins.getInstance().getListAdmin());
    private ListView<Admin> listViewAdmin = new ListView<Admin>(admins);

    private ObservableList<Passager> passagers = FXCollections
            .observableArrayList(Passagers.getInstance().getListPassager());
    private ListView<Passager> listViewPassager = new ListView<Passager>(passagers);

    private ObservableList<Conducteur> conducteurs = FXCollections
            .observableArrayList(Conducteurs.getInstance().getListConducteur());
    private ListView<Conducteur> listViewConducteur = new ListView<Conducteur>(conducteurs);

    private Button buttonSauvegarder = new Button("Sauvegarder");
    private TextField textFieldNom = new TextField();

    private String TypeCurrentPersonne = null;

    public PageAdmin() {
        listViewAdmin.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TypeCurrentPersonne = "Admin";
                buttonSauvegarder.setDisable(false);
                textFieldNom.setText(listViewAdmin.getSelectionModel().getSelectedItem().getNom());
            }
        });

        listViewPassager.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TypeCurrentPersonne = "Passager";
                buttonSauvegarder.setDisable(false);
                textFieldNom.setText(listViewPassager.getSelectionModel().getSelectedItem().getNom());
            }
        });

        listViewConducteur.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TypeCurrentPersonne = "Conducteur";
                buttonSauvegarder.setDisable(false);
                textFieldNom.setText(listViewConducteur.getSelectionModel().getSelectedItem().getNom());
            }
        });

        buttonSauvegarder.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (TypeCurrentPersonne.equals("Admin")) {
                    listViewAdmin.getSelectionModel().getSelectedItem().modifierInfo(textFieldNom.getText());
                } else if (TypeCurrentPersonne.equals("Passager")) {
                    listViewPassager.getSelectionModel().getSelectedItem().modifierInfo(textFieldNom.getText());
                } else if (TypeCurrentPersonne.equals("Conducteur")) {
                    listViewConducteur.getSelectionModel().getSelectedItem().modifierInfo(textFieldNom.getText());
                }
            }
        }));

    }

    public Parent creerContenu() {
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setGridLinesVisible(true);

        listViewAdmin.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listViewPassager.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listViewConducteur.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        buttonSauvegarder.setDisable(true);

        /* Colonne, Ligne */
        gridPane.add(label1, 0, 0);
        gridPane.add(label2, 0, 1);
        gridPane.add(label3, 1, 1);
        gridPane.add(label4, 2, 1);
        gridPane.add(listViewAdmin, 0, 2);
        gridPane.add(listViewPassager, 1, 2);
        gridPane.add(listViewConducteur, 2, 2);
        gridPane.add(label5, 0, 4);
        gridPane.add(textFieldNom, 0, 5);
        gridPane.add(buttonSauvegarder, 3, 6);

        gridPane.setHalignment(label2, HPos.CENTER);
        gridPane.setHalignment(label3, HPos.CENTER);
        gridPane.setHalignment(label4, HPos.CENTER);

        return gridPane;
    }
}
