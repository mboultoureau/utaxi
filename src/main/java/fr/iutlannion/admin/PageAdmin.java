package fr.iutlannion.admin;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.input.MouseEvent;
import javafx.collections.*;
import javafx.event.EventHandler;
import fr.iutlannion.manager.*;
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
    private Label label16 = new Label("");

    private ObservableList<Admin> admins = FXCollections.observableArrayList(Utilisateurs.getListAdmin());
    private ListView<Admin> listViewAdmin = new ListView<Admin>(admins);

    private ObservableList<Passager> passagers = FXCollections.observableArrayList(Utilisateurs.getListPassagers());
    private ListView<Passager> listViewPassager = new ListView<Passager>(passagers);

    private ObservableList<Conducteur> conducteurs = FXCollections
            .observableArrayList(Utilisateurs.getListConducteur());
    private ListView<Conducteur> listViewConducteur = new ListView<Conducteur>(conducteurs);

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
        listViewAdmin.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                TypeCurrentPersonne = "Admin";
                label16.setText("");
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
                label16.setText("");
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
                label16.setText("");
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
                label9.setVisible(false);
                label10.setVisible(false);
                label11.setVisible(false);
                label12.setVisible(false);
                label13.setVisible(false);
                label14.setVisible(false);
                label15.setVisible(false);
                if (TypeCurrentPersonne.equals("Admin")) {
                    if (textFieldNom.getText().compareTo("") == 0 || textFieldPrenom.getText().compareTo("") == 0
                            || textFieldEmail.getText().compareTo("") == 0
                            || textFieldMotdepasse.getText().compareTo("") == 0) {
                        label16.setText("Erreur, champ(s) vide");
                    } else {
                        label16.setText("");
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
                        label16.setText("Erreur, champs vide(s)");
                    } else {
                        label16.setText("");
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
                        label16.setText("Erreur, champs vide(s)");
                    } else {
                        label16.setText("");
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

        buttonSupprimer.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                label16.setText("");
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
                label9.setVisible(false);
                label10.setVisible(false);
                label11.setVisible(false);
                label12.setVisible(false);
                label13.setVisible(false);
                label14.setVisible(false);
                label15.setVisible(false);
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
        }));

        buttonAjouterAdmin.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (textFieldNom.getText().compareTo("") == 0 || textFieldPrenom.getText().compareTo("") == 0
                        || textFieldEmail.getText().compareTo("") == 0
                        || textFieldMotdepasse.getText().compareTo("") == 0) {
                    label16.setText("Erreur, champs vide(s)");
                } else {
                    label16.setText("");
                    Admin newAdmin = new Admin(textFieldNom.getText(), textFieldPrenom.getText(),
                            textFieldEmail.getText(), textFieldMotdepasse.getText());
                    Utilisateurs.add(newAdmin);
                    listViewAdmin.getItems().add(newAdmin);
                    listViewAdmin.getSelectionModel().select(newAdmin);
                }
            }
        }));

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
                label9.setVisible(false);
                label10.setVisible(false);
                label11.setVisible(false);
                label12.setVisible(false);
                label13.setVisible(false);
                label14.setVisible(false);
                label15.setVisible(false);
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
                label16.setText("");
            }
        }));

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
        label16.setTextFill(Color.RED);
        label16.setFont(new Font(20));
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
        label9.setVisible(false);
        label10.setVisible(false);
        label11.setVisible(false);
        label12.setVisible(false);
        label13.setVisible(false);
        label14.setVisible(false);
        label15.setVisible(false);

        /* Colonne, Ligne */
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
        gridPane.add(label16, 1, 13, 1, 1);
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
        gridPane.add(buttonSauvegarder, 2, 11);
        gridPane.add(buttonSupprimer, 2, 11);
        gridPane.add(buttonAjouterAdmin, 2, 12);
        gridPane.add(buttonAnnuler, 2, 12);

        GridPane.setHalignment(label2, HPos.CENTER);
        GridPane.setHalignment(label3, HPos.CENTER);
        GridPane.setHalignment(label4, HPos.CENTER);
        GridPane.setHalignment(buttonSauvegarder, HPos.LEFT);
        GridPane.setHalignment(buttonAnnuler, HPos.LEFT);
        GridPane.setHalignment(buttonSupprimer, HPos.RIGHT);
        GridPane.setHalignment(buttonAjouterAdmin, HPos.RIGHT);

        root.setTop(header);
        root.setCenter(gridPane);

        return root;
    }
}
