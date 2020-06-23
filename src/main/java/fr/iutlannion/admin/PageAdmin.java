package fr.iutlannion.admin;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.geometry.*;
import javafx.scene.input.MouseEvent;
import javafx.collections.*;
import javafx.event.EventHandler;
import fr.iutlannion.manager.*;

import java.util.Optional;

import fr.iutlannion.core.Window;

/**
 * PageAdmin contient le pannel d'administration
 * 
 * @author ronanren
 * @version 1.0
 * 
 */

public class PageAdmin extends Stage {

    // Header
    private HBox header = new HBox();
    private Button backButton = new Button("Deconnexion");
    private Label title = new Label("ADMIN");
    private Label logo = new Label("UTaxi");

    private BorderPane root = new BorderPane();
    private GridPane gridPane = new GridPane();
    private Label labelAdmin = new Label("Liste des Admins");
    private Label labelPassager = new Label("Liste des Passagers");
    private Label labelConducteur = new Label("Liste des Conducteurs");
    private Label labelNom = new Label("Nom :");
    private Label labelPrenom = new Label("Prenom :");
    private Label labelEmail = new Label("Email :");
    private Label labelMdp = new Label("Mot de passe :");
    private Label labelTarif = new Label("Tarif :");
    private Label labelKms = new Label("Km parcourus :");
    private Label labelImmatriculation = new Label("Immatriculation :");
    private Label labelMarque = new Label("Marque :");
    private Label labelTypeEssence = new Label("Type essence :");
    private Label labelCouleur = new Label("Couleur :");
    private Label labelType = new Label("Type :");
    private Label labelErreur = new Label("");

    private ObservableList<Admin> admins = FXCollections.observableArrayList(Utilisateurs.getListAdmin());
    private ListView<Admin> listViewAdmin = new ListView<Admin>(admins);

    private ObservableList<Passager> passagers = FXCollections.observableArrayList(Utilisateurs.getListPassagers());
    private ListView<Passager> listViewPassager = new ListView<Passager>(passagers);

    private ObservableList<Conducteur> conducteurs = FXCollections
            .observableArrayList(Utilisateurs.getListConducteur());
    private ListView<Conducteur> listViewConducteur = new ListView<Conducteur>(conducteurs);

    private HBox boutons = new HBox();
    private Region space1 = new Region();
    private Region space2 = new Region();
    private Region space3 = new Region();
    private Button buttonSauvegarder = new Button("Sauvegarder");
    private Button buttonSupprimer = new Button("Supprimer");
    private Button buttonAjouterAdmin = new Button("Ajouter Admin");
    private Button buttonAnnuler = new Button("Annuler");
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

        Window.getInstance().setResizable(true);
        Window.getInstance().setMinHeight(600);
        Window.getInstance().setMaxHeight(1000);
        Window.getInstance().setHeight(700);

        Window.getInstance().setMinWidth(700);
        Window.getInstance().setMaxWidth(2000);
        Window.getInstance().setWidth(700);

        /**
         * Événement sur la liste des admins
         */
        listViewAdmin.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TypeCurrentPersonne = "Admin";
                labelErreur.setText("");
                buttonAjouterAdmin.setDisable(true);
                buttonSauvegarder.setDisable(false);
                buttonSupprimer.setDisable(false);
                buttonAnnuler.setDisable(false);
                textFieldTarif.setVisible(false);
                textFieldKmParcourus.setVisible(false);
                textFieldImmatriculation.setVisible(false);
                textFieldMarque.setVisible(false);
                textFieldTypeEssence.setVisible(false);
                textFieldCouleur.setVisible(false);
                textFieldType.setVisible(false);
                labelTarif.setVisible(false);
                labelKms.setVisible(false);
                labelImmatriculation.setVisible(false);
                labelMarque.setVisible(false);
                labelTypeEssence.setVisible(false);
                labelCouleur.setVisible(false);
                labelType.setVisible(false);
                textFieldNom.setText(listViewAdmin.getSelectionModel().getSelectedItem().getNom());
                textFieldPrenom.setText(listViewAdmin.getSelectionModel().getSelectedItem().getPrenom());
                textFieldEmail.setText(listViewAdmin.getSelectionModel().getSelectedItem().getEmail());
                textFieldMotdepasse.setText(listViewAdmin.getSelectionModel().getSelectedItem().getMotDePasse());
            }
        });

        /**
         * Événement sur la liste des passagers
         */
        listViewPassager.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TypeCurrentPersonne = "Passager";
                labelErreur.setText("");
                buttonAjouterAdmin.setDisable(true);
                buttonSauvegarder.setDisable(false);
                buttonSupprimer.setDisable(false);
                buttonAnnuler.setDisable(false);
                textFieldTarif.setVisible(false);
                textFieldKmParcourus.setVisible(false);
                textFieldImmatriculation.setVisible(false);
                textFieldMarque.setVisible(false);
                textFieldTypeEssence.setVisible(false);
                textFieldCouleur.setVisible(false);
                textFieldType.setVisible(false);
                labelTarif.setVisible(false);
                labelKms.setVisible(false);
                labelImmatriculation.setVisible(false);
                labelMarque.setVisible(false);
                labelTypeEssence.setVisible(false);
                labelCouleur.setVisible(false);
                labelType.setVisible(false);
                textFieldNom.setText(listViewPassager.getSelectionModel().getSelectedItem().getNom());
                textFieldPrenom.setText(listViewPassager.getSelectionModel().getSelectedItem().getPrenom());
                textFieldEmail.setText(listViewPassager.getSelectionModel().getSelectedItem().getEmail());
                textFieldMotdepasse.setText(listViewPassager.getSelectionModel().getSelectedItem().getMotDePasse());
            }
        });

        /**
         * Événement sur la liste des conducteurs
         */
        listViewConducteur.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TypeCurrentPersonne = "Conducteur";
                labelErreur.setText("");
                buttonAjouterAdmin.setDisable(true);
                buttonSauvegarder.setDisable(false);
                buttonSupprimer.setDisable(false);
                buttonAnnuler.setDisable(false);
                textFieldTarif.setVisible(true);
                textFieldKmParcourus.setVisible(true);
                textFieldImmatriculation.setVisible(true);
                textFieldMarque.setVisible(true);
                textFieldTypeEssence.setVisible(true);
                textFieldCouleur.setVisible(true);
                textFieldType.setVisible(true);
                labelTarif.setVisible(true);
                labelKms.setVisible(true);
                labelImmatriculation.setVisible(true);
                labelMarque.setVisible(true);
                labelTypeEssence.setVisible(true);
                labelCouleur.setVisible(true);
                labelType.setVisible(true);
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

        /**
         * Événement sur le bouton "Sauvegarder" afin d'enregistrer les modifications
         * d'un utilisateur
         */
        buttonSauvegarder.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                buttonSauvegarder.setDisable(true);
                buttonSupprimer.setDisable(true);
                buttonAnnuler.setDisable(true);
                buttonAjouterAdmin.setDisable(false);
                textFieldTarif.setVisible(false);
                textFieldKmParcourus.setVisible(false);
                textFieldImmatriculation.setVisible(false);
                textFieldMarque.setVisible(false);
                textFieldTypeEssence.setVisible(false);
                textFieldCouleur.setVisible(false);
                textFieldType.setVisible(false);
                labelTarif.setVisible(false);
                labelKms.setVisible(false);
                labelImmatriculation.setVisible(false);
                labelMarque.setVisible(false);
                labelTypeEssence.setVisible(false);
                labelCouleur.setVisible(false);
                labelType.setVisible(false);
                if (TypeCurrentPersonne.equals("Admin")) {
                    if (textFieldNom.getText().compareTo("") == 0 || textFieldPrenom.getText().compareTo("") == 0
                            || textFieldEmail.getText().compareTo("") == 0
                            || textFieldMotdepasse.getText().compareTo("") == 0) {
                        labelErreur.setText("Erreur, champ(s) vide");
                    } else {
                        labelErreur.setText("");
                        listViewAdmin.getSelectionModel().getSelectedItem().modifierInfo(textFieldNom.getText(),
                                textFieldPrenom.getText(), textFieldEmail.getText(), textFieldMotdepasse.getText());
                        listViewAdmin.getSelectionModel().clearSelection();
                        listViewPassager.getSelectionModel().clearSelection();
                        listViewConducteur.getSelectionModel().clearSelection();
                        textFieldNom.setText("");
                        textFieldPrenom.setText("");
                        textFieldEmail.setText("");
                        textFieldMotdepasse.setText("");
                        textFieldTarif.setText("");
                        textFieldKmParcourus.setText("");
                        textFieldImmatriculation.setText("");
                        textFieldMarque.setText("");
                        textFieldTypeEssence.setText("");
                        textFieldCouleur.setText("");
                        textFieldType.setText("");
                    }
                } else if (TypeCurrentPersonne.equals("Passager")) {
                    if (textFieldNom.getText().compareTo("") == 0 || textFieldPrenom.getText().compareTo("") == 0
                            || textFieldEmail.getText().compareTo("") == 0
                            || textFieldMotdepasse.getText().compareTo("") == 0) {
                        labelErreur.setText("Erreur, champs vide(s)");
                    } else {
                        labelErreur.setText("");
                        listViewPassager.getSelectionModel().getSelectedItem().modifierInfo(textFieldNom.getText(),
                                textFieldPrenom.getText(), textFieldEmail.getText(), textFieldMotdepasse.getText());
                        listViewAdmin.getSelectionModel().clearSelection();
                        listViewPassager.getSelectionModel().clearSelection();
                        listViewConducteur.getSelectionModel().clearSelection();
                        textFieldNom.setText("");
                        textFieldPrenom.setText("");
                        textFieldEmail.setText("");
                        textFieldMotdepasse.setText("");
                        textFieldTarif.setText("");
                        textFieldKmParcourus.setText("");
                        textFieldImmatriculation.setText("");
                        textFieldMarque.setText("");
                        textFieldTypeEssence.setText("");
                        textFieldCouleur.setText("");
                        textFieldType.setText("");
                    }
                } else if (TypeCurrentPersonne.equals("Conducteur")) {
                    if (textFieldNom.getText().compareTo("") == 0 || textFieldPrenom.getText().compareTo("") == 0
                            || textFieldEmail.getText().compareTo("") == 0
                            || textFieldMotdepasse.getText().compareTo("") == 0
                            || textFieldTarif.getText().compareTo("") == 0
                            || textFieldKmParcourus.getText().compareTo("") == 0
                            || textFieldImmatriculation.getText().compareTo("") == 0
                            || textFieldMarque.getText().compareTo("") == 0
                            || textFieldTypeEssence.getText().compareTo("") == 0
                            || textFieldType.getText().compareTo("") == 0
                            || textFieldCouleur.getText().compareTo("") == 0) {
                        labelErreur.setText("Erreur, champs vide(s)");
                    } else {
                        labelErreur.setText("");
                        listViewConducteur.getSelectionModel().getSelectedItem().modifierInfoAdmin(
                                textFieldNom.getText(), textFieldPrenom.getText(), textFieldEmail.getText(),
                                textFieldMotdepasse.getText(), Double.parseDouble(textFieldTarif.getText()),
                                Double.parseDouble(textFieldKmParcourus.getText()), textFieldImmatriculation.getText(),
                                textFieldMarque.getText(), textFieldTypeEssence.getText(), textFieldCouleur.getText(),
                                textFieldType.getText());
                        listViewAdmin.getSelectionModel().clearSelection();
                        listViewPassager.getSelectionModel().clearSelection();
                        listViewConducteur.getSelectionModel().clearSelection();
                        textFieldNom.setText("");
                        textFieldPrenom.setText("");
                        textFieldEmail.setText("");
                        textFieldMotdepasse.setText("");
                        textFieldTarif.setText("");
                        textFieldKmParcourus.setText("");
                        textFieldImmatriculation.setText("");
                        textFieldMarque.setText("");
                        textFieldTypeEssence.setText("");
                        textFieldCouleur.setText("");
                        textFieldType.setText("");
                    }
                }
            }
        }));

        /**
         * Événement sur le bouton "Supprimer" afin de supprimer un utilisateur
         */
        buttonSupprimer.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Alert confirmation = new Alert(AlertType.CONFIRMATION);
                Optional<ButtonType> result = confirmation.showAndWait();

                if (result.get() == ButtonType.OK) {
                    labelErreur.setText("");
                    textFieldNom.setText("");
                    textFieldPrenom.setText("");
                    textFieldEmail.setText("");
                    textFieldMotdepasse.setText("");
                    textFieldTarif.setText("");
                    textFieldKmParcourus.setText("");
                    textFieldImmatriculation.setText("");
                    textFieldMarque.setText("");
                    textFieldTypeEssence.setText("");
                    textFieldCouleur.setText("");
                    textFieldType.setText("");
                    buttonSauvegarder.setDisable(true);
                    buttonSupprimer.setDisable(true);
                    buttonAnnuler.setDisable(true);
                    buttonAjouterAdmin.setDisable(false);
                    textFieldTarif.setVisible(false);
                    textFieldKmParcourus.setVisible(false);
                    textFieldImmatriculation.setVisible(false);
                    textFieldMarque.setVisible(false);
                    textFieldTypeEssence.setVisible(false);
                    textFieldCouleur.setVisible(false);
                    textFieldType.setVisible(false);
                    labelTarif.setVisible(false);
                    labelKms.setVisible(false);
                    labelImmatriculation.setVisible(false);
                    labelMarque.setVisible(false);
                    labelTypeEssence.setVisible(false);
                    labelCouleur.setVisible(false);
                    labelType.setVisible(false);
                    if (TypeCurrentPersonne.equals("Admin")) {
                        Utilisateurs.remove(listViewAdmin.getSelectionModel().getSelectedItem());
                        admins.remove(listViewAdmin.getSelectionModel().getSelectedItem());
                        listViewAdmin.setItems(admins);
                    } else if (TypeCurrentPersonne.equals("Passager")) {
                        Utilisateurs.remove(listViewPassager.getSelectionModel().getSelectedItem());
                        passagers.remove(listViewPassager.getSelectionModel().getSelectedItem());
                        listViewPassager.setItems(passagers);
                    } else if (TypeCurrentPersonne.equals("Conducteur")) {
                        Utilisateurs.remove(listViewConducteur.getSelectionModel().getSelectedItem());
                        conducteurs.remove(listViewConducteur.getSelectionModel().getSelectedItem());
                        listViewConducteur.setItems(conducteurs);
                    }
                    listViewAdmin.getSelectionModel().clearSelection();
                    listViewPassager.getSelectionModel().clearSelection();
                    listViewConducteur.getSelectionModel().clearSelection();
                }
            }
        }));

        /**
         * Événement sur le bouton "Ajouter Admin" afin d'ajouter un nouvel
         * administrateur
         */
        buttonAjouterAdmin.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (textFieldNom.getText().compareTo("") == 0 || textFieldPrenom.getText().compareTo("") == 0
                        || textFieldEmail.getText().compareTo("") == 0
                        || textFieldMotdepasse.getText().compareTo("") == 0) {
                    labelErreur.setText("Erreur, champs vide(s)");
                } else {
                    labelErreur.setText("");
                    Admin newAdmin = new Admin(textFieldNom.getText(), textFieldPrenom.getText(),
                            textFieldEmail.getText(), textFieldMotdepasse.getText());
                    Utilisateurs.add(newAdmin);
                    listViewAdmin.getItems().add(newAdmin);
                    listViewAdmin.getSelectionModel().select(newAdmin);
                }
            }
        }));

        /**
         * Événement sur le bouton "Annuler" afin d'annuler les modifications en cours
         */
        buttonAnnuler.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                buttonSauvegarder.setDisable(true);
                buttonSupprimer.setDisable(true);
                buttonAnnuler.setDisable(true);
                buttonAjouterAdmin.setDisable(false);
                textFieldTarif.setVisible(false);
                textFieldKmParcourus.setVisible(false);
                textFieldImmatriculation.setVisible(false);
                textFieldMarque.setVisible(false);
                textFieldTypeEssence.setVisible(false);
                textFieldCouleur.setVisible(false);
                textFieldType.setVisible(false);
                labelTarif.setVisible(false);
                labelKms.setVisible(false);
                labelImmatriculation.setVisible(false);
                labelMarque.setVisible(false);
                labelTypeEssence.setVisible(false);
                labelCouleur.setVisible(false);
                labelType.setVisible(false);
                listViewAdmin.getSelectionModel().clearSelection();
                listViewPassager.getSelectionModel().clearSelection();
                listViewConducteur.getSelectionModel().clearSelection();
                textFieldNom.setText("");
                textFieldPrenom.setText("");
                textFieldEmail.setText("");
                textFieldMotdepasse.setText("");
                textFieldTarif.setText("");
                textFieldKmParcourus.setText("");
                textFieldImmatriculation.setText("");
                textFieldMarque.setText("");
                textFieldTypeEssence.setText("");
                textFieldCouleur.setText("");
                textFieldType.setText("");
                labelErreur.setText("");
            }
        }));

        /**
         * Événement sur le bouton "Deconnexion" pour se déconnecter
         */
        backButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Window.getInstance().gotoPage("connexion");
            }
        }));

    }

    public Parent creerContenu() {

        header.setPadding(new Insets(0, 20, 0, 20));

        header.setPrefHeight(50);
        header.setStyle("-fx-background-color: #000;");
        header.setAlignment(Pos.CENTER);

        // Back
        backButton.setStyle(
                "-fx-background-color: #000; -fx-text-fill: #fff; -fx-border-color: #fff; -fx-border-width: 2;");
        backButton.setAlignment(Pos.CENTER_LEFT);

        // Title
        title.setStyle("-fx-text-fill: #fff;");
        title.setAlignment(Pos.CENTER);
        title.setFont(new Font("Arial", 20));
        title.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(title, Priority.ALWAYS);

        // Logo
        logo.setStyle("-fx-text-fill: #fff;");
        logo.setAlignment(Pos.CENTER_RIGHT);

        header.getChildren().addAll(backButton, title, logo);

        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        labelErreur.setTextFill(Color.RED);
        labelErreur.setFont(new Font(20));
        /* gridPane.setGridLinesVisible(true); */

        listViewAdmin.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listViewPassager.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listViewConducteur.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listViewAdmin.setMaxHeight(380);
        listViewPassager.setMaxHeight(380);
        listViewConducteur.setMaxHeight(380);
        buttonSauvegarder.setDisable(true);
        buttonSupprimer.setDisable(true);
        buttonAnnuler.setDisable(true);
        textFieldTarif.setVisible(false);
        textFieldKmParcourus.setVisible(false);
        textFieldImmatriculation.setVisible(false);
        textFieldMarque.setVisible(false);
        textFieldTypeEssence.setVisible(false);
        textFieldCouleur.setVisible(false);
        textFieldType.setVisible(false);
        labelTarif.setVisible(false);
        labelKms.setVisible(false);
        labelImmatriculation.setVisible(false);
        labelMarque.setVisible(false);
        labelTypeEssence.setVisible(false);
        labelCouleur.setVisible(false);
        labelType.setVisible(false);

        /* BOUTONS */
        boutons.getChildren().addAll(buttonSauvegarder, space1, buttonSupprimer, space2, buttonAjouterAdmin, space3, buttonAnnuler);
        HBox.setHgrow(space1, Priority.ALWAYS);
        HBox.setHgrow(space2, Priority.ALWAYS);
        HBox.setHgrow(space3, Priority.ALWAYS);

        buttonSauvegarder.setMinWidth(100);
        buttonSupprimer.setMinWidth(100);
        buttonAjouterAdmin.setMinWidth(100);
        buttonAnnuler.setMinWidth(100);


        /* Colonne, Ligne */
        gridPane.add(labelAdmin, 0, 1);
        gridPane.add(labelPassager, 1, 1);
        gridPane.add(labelConducteur, 2, 1);
        gridPane.add(listViewAdmin, 0, 2);
        gridPane.add(listViewPassager, 1, 2);
        gridPane.add(listViewConducteur, 2, 2);
        gridPane.add(labelNom, 0, 4);
        gridPane.add(labelPrenom, 1, 4);
        gridPane.add(labelEmail, 2, 4);
        gridPane.add(labelMdp, 0, 6);
        gridPane.add(labelTarif, 1, 6);
        gridPane.add(labelKms, 2, 6);
        gridPane.add(labelImmatriculation, 0, 8);
        gridPane.add(labelMarque, 1, 8);
        gridPane.add(labelTypeEssence, 2, 8);
        gridPane.add(labelCouleur, 0, 10);
        gridPane.add(labelType, 1, 10);
        gridPane.add(labelErreur, 1, 13, 1, 1);
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
        gridPane.add(boutons, 0, 12, 4, 1);


        GridPane.setHalignment(labelAdmin, HPos.CENTER);
        GridPane.setHalignment(labelPassager, HPos.CENTER);
        GridPane.setHalignment(labelConducteur, HPos.CENTER);
        GridPane.setHalignment(buttonSauvegarder, HPos.LEFT);
        GridPane.setHalignment(buttonAnnuler, HPos.RIGHT);
        GridPane.setHalignment(buttonSupprimer, HPos.RIGHT);
        GridPane.setHalignment(buttonAjouterAdmin, HPos.LEFT);

        root.setTop(header);
        root.setCenter(gridPane);

        return root;
    }
}
