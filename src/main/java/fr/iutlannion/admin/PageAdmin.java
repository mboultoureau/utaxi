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
    private Label label6 = new Label("Prenom :");
    private Label label7 = new Label("Email :");
    private Label label8 = new Label("Mot de passe :");
    private Label label9 = new Label("Tarif :");
    private Label label10 = new Label("Km parcourus :");
    private Label label11 = new Label("Immatriculation :");
    private Label label12 = new Label("Marque :");
    private Label label13 = new Label("Type essence :");
    private Label label14 = new Label("Couleur :");
    private Label label15 = new Label("Type :");

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
    private TextField textFieldPrenom = new TextField();
    private TextField textFieldEmail = new TextField();
    private TextField textFieldMotdepasse = new TextField();
    private TextField textFieldTarif = new TextField();
    private TextField textFieldKmParcourus = new TextField();
    private TextField textFieldImmatriculation = new TextField();
    private TextField textFieldMarque = new TextField();
    private TextField textFieldTypeEssence = new TextField();
    private TextField textFieldCouleur = new TextField();
    private TextField textFieldType = new TextField();

    private String TypeCurrentPersonne = null;

    public PageAdmin() {
        listViewAdmin.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TypeCurrentPersonne = "Admin";
                buttonSauvegarder.setDisable(false);
                textFieldTarif.setVisible(false);
                textFieldKmParcourus.setVisible(false);
                textFieldImmatriculation.setVisible(false);
                textFieldMarque.setVisible(false);
                textFieldTypeEssence.setVisible(false);
                textFieldCouleur.setVisible(false);
                textFieldType.setVisible(false);
                label9.setVisible(false);
                label10.setVisible(false);
                label11.setVisible(false);
                label12.setVisible(false);
                label13.setVisible(false);
                label14.setVisible(false);
                label15.setVisible(false);
                textFieldNom.setText(listViewAdmin.getSelectionModel().getSelectedItem().getNom());
                textFieldPrenom.setText(listViewAdmin.getSelectionModel().getSelectedItem().getPrenom());
                textFieldEmail.setText(listViewAdmin.getSelectionModel().getSelectedItem().getEmail());
                textFieldMotdepasse.setText(listViewAdmin.getSelectionModel().getSelectedItem().getMotDePasse());
            }
        });

        listViewPassager.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TypeCurrentPersonne = "Passager";
                buttonSauvegarder.setDisable(false);
                textFieldTarif.setVisible(false);
                textFieldKmParcourus.setVisible(false);
                textFieldImmatriculation.setVisible(false);
                textFieldMarque.setVisible(false);
                textFieldTypeEssence.setVisible(false);
                textFieldCouleur.setVisible(false);
                textFieldType.setVisible(false);
                label9.setVisible(false);
                label10.setVisible(false);
                label11.setVisible(false);
                label12.setVisible(false);
                label13.setVisible(false);
                label14.setVisible(false);
                label15.setVisible(false);
                textFieldNom.setText(listViewPassager.getSelectionModel().getSelectedItem().getNom());
                textFieldPrenom.setText(listViewPassager.getSelectionModel().getSelectedItem().getPrenom());
                textFieldEmail.setText(listViewPassager.getSelectionModel().getSelectedItem().getEmail());
                textFieldMotdepasse.setText(listViewPassager.getSelectionModel().getSelectedItem().getMotDePasse());
            }
        });

        listViewConducteur.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TypeCurrentPersonne = "Conducteur";
                buttonSauvegarder.setDisable(false);
                textFieldTarif.setVisible(true);
                textFieldKmParcourus.setVisible(true);
                textFieldImmatriculation.setVisible(true);
                textFieldMarque.setVisible(true);
                textFieldTypeEssence.setVisible(true);
                textFieldCouleur.setVisible(true);
                textFieldType.setVisible(true);
                label9.setVisible(true);
                label10.setVisible(true);
                label11.setVisible(true);
                label12.setVisible(true);
                label13.setVisible(true);
                label14.setVisible(true);
                label15.setVisible(true);
                textFieldNom.setText(listViewConducteur.getSelectionModel().getSelectedItem().getNom());
                textFieldPrenom.setText(listViewConducteur.getSelectionModel().getSelectedItem().getPrenom());
                textFieldEmail.setText(listViewConducteur.getSelectionModel().getSelectedItem().getEmail());
                textFieldMotdepasse.setText(listViewConducteur.getSelectionModel().getSelectedItem().getMotDePasse());
                textFieldTarif
                        .setText(String.valueOf(listViewConducteur.getSelectionModel().getSelectedItem().getTarif()));
                textFieldKmParcourus.setText(
                        String.valueOf(listViewConducteur.getSelectionModel().getSelectedItem().getNbKmParcourus()));
                textFieldImmatriculation.setText(String.valueOf(
                        listViewConducteur.getSelectionModel().getSelectedItem().getVoiture().getImmatriculation()));
                textFieldMarque.setText(String
                        .valueOf(listViewConducteur.getSelectionModel().getSelectedItem().getVoiture().getMarque()));
                textFieldTypeEssence.setText(String.valueOf(
                        listViewConducteur.getSelectionModel().getSelectedItem().getVoiture().getTypeEssence()));
                textFieldCouleur.setText(String
                        .valueOf(listViewConducteur.getSelectionModel().getSelectedItem().getVoiture().getCouleur()));
                textFieldType.setText(String
                        .valueOf(listViewConducteur.getSelectionModel().getSelectedItem().getVoiture().getType()));
            }
        });

        buttonSauvegarder.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (TypeCurrentPersonne.equals("Admin")) {
                    listViewAdmin.getSelectionModel().getSelectedItem().modifierInfo(textFieldNom.getText(),
                            textFieldPrenom.getText(), textFieldEmail.getText(), textFieldMotdepasse.getText());
                } else if (TypeCurrentPersonne.equals("Passager")) {
                    listViewPassager.getSelectionModel().getSelectedItem().modifierInfo(textFieldNom.getText(),
                            textFieldPrenom.getText(), textFieldEmail.getText(), textFieldMotdepasse.getText());
                } else if (TypeCurrentPersonne.equals("Conducteur")) {
                    listViewConducteur.getSelectionModel().getSelectedItem().modifierInfo(textFieldNom.getText(),
                            textFieldPrenom.getText(), textFieldEmail.getText(), textFieldMotdepasse.getText(),
                            Double.parseDouble(textFieldTarif.getText()),
                            Double.parseDouble(textFieldKmParcourus.getText()), textFieldImmatriculation.getText(),
                            textFieldMarque.getText(), textFieldTypeEssence.getText(), textFieldCouleur.getText(),
                            textFieldType.getText());
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
        listViewAdmin.setMaxHeight(380);
        listViewPassager.setMaxHeight(380);
        listViewConducteur.setMaxHeight(380);
        buttonSauvegarder.setDisable(true);
        textFieldTarif.setVisible(false);
        textFieldKmParcourus.setVisible(false);
        textFieldImmatriculation.setVisible(false);
        textFieldMarque.setVisible(false);
        textFieldTypeEssence.setVisible(false);
        textFieldCouleur.setVisible(false);
        textFieldType.setVisible(false);
        label9.setVisible(false);
        label10.setVisible(false);
        label11.setVisible(false);
        label12.setVisible(false);
        label13.setVisible(false);
        label14.setVisible(false);
        label15.setVisible(false);

        /*
         * Colonne, Ligne ronan@email.com
         */
        gridPane.add(label1, 0, 0);
        gridPane.add(label2, 0, 1);
        gridPane.add(label3, 1, 1);
        gridPane.add(label4, 2, 1);
        gridPane.add(listViewAdmin, 0, 2);
        gridPane.add(listViewPassager, 1, 2);
        gridPane.add(listViewConducteur, 2, 2);
        gridPane.add(label5, 0, 4);
        gridPane.add(label6, 1, 4);
        gridPane.add(label7, 2, 4);
        gridPane.add(label8, 0, 6);
        gridPane.add(label9, 1, 6);
        gridPane.add(label10, 2, 6);
        gridPane.add(label11, 0, 8);
        gridPane.add(label12, 1, 8);
        gridPane.add(label13, 2, 8);
        gridPane.add(label14, 0, 10);
        gridPane.add(label15, 1, 10);
        gridPane.add(textFieldNom, 0, 5);
        gridPane.add(textFieldPrenom, 1, 5);
        gridPane.add(textFieldEmail, 2, 5);
        gridPane.add(textFieldMotdepasse, 0, 7);
        gridPane.add(textFieldTarif, 1, 7);
        gridPane.add(textFieldKmParcourus, 2, 7);
        gridPane.add(textFieldImmatriculation, 0, 9);
        gridPane.add(textFieldMarque, 1, 9);
        gridPane.add(textFieldTypeEssence, 2, 9);
        gridPane.add(textFieldCouleur, 0, 11);
        gridPane.add(textFieldType, 1, 11);
        gridPane.add(buttonSauvegarder, 3, 11);

        gridPane.setHalignment(label2, HPos.CENTER);
        gridPane.setHalignment(label3, HPos.CENTER);
        gridPane.setHalignment(label4, HPos.CENTER);
        gridPane.setHalignment(buttonSauvegarder, HPos.RIGHT);

        return gridPane;
    }
}
