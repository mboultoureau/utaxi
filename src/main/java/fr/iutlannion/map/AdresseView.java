package fr.iutlannion.map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Un widget pour chercher et sélectioner facilement une adresse
 */
public class AdresseView extends GridPane {

    private Label error = new Label("");
    private ObservableList<String> adresses = FXCollections.observableArrayList("");
    private final ComboBox comboBox = new ComboBox(adresses);
    private Button okButton = new Button("OK");
    private HashMap<String, Adresse> propositions;

    /**
     * Le constructeur d'AdresseView
     */
    public AdresseView() {
        propositions = new HashMap<String, Adresse>();

        comboBox.setPromptText("Rechercher une adresse...");
        comboBox.setEditable(true);

        error.setTextFill(Color.RED);
        error.setVisible(false);

        add(comboBox, 0, 0);
        add(okButton, 1, 0);
        add(error, 0, 1, 2, 1);

        comboBox.setOnKeyReleased(e -> updateList());
    }

    /**
     * Retourne le bouton OK Utile pour écouter des événements dessus
     * 
     * @return Bouton OK
     */
    public Button getOKButton() {
        return okButton;
    }

    /**
     * Obtient l'adresse la plus pertinente
     * 
     * @return L'adresse la plus pertinente ou null
     */
    public Adresse getAdresse() {
        // Proposition valide
        if (propositions.containsKey(comboBox.getEditor().getText())) {
            return propositions.get(comboBox.getEditor().getText());
        }

        // Recherche de la proposition
        ArrayList<Adresse> answers = new ArrayList<Adresse>();
        answers = AdresseAPI.getAdresses(comboBox.getEditor().getText());

        if (answers.size() != 0)
            return answers.get(0);

        return null;
    }

    /**
     * Désactive le widget
     */
    public void disable() {
        comboBox.setDisable(true);
        okButton.setDisable(true);
    }

    /**
     * Active le widget
     */
    public void enable() {
        comboBox.setDisable(false);
        okButton.setDisable(false);
    }

    /**
     * Met à jour la liste à partir de l'entrée saisie dans la ComboBox
     */
    public void updateList() {
        if (!comboBox.isDisabled()) {
            ArrayList<Adresse> answers = new ArrayList<Adresse>();
            answers = AdresseAPI.getAdresses(comboBox.getEditor().getText());
            propositions.clear();
            adresses.clear();

            for (Adresse answer : answers) {
                propositions.put(answer.toString(), answer);
                adresses.add(answer.toString());
            }

            System.out.println(propositions.size());
            if (propositions.isEmpty()) {
                error.setVisible(true);
                error.setText("Aucune correspondance");
            } else {
                error.setVisible(false);
                error.setText("");
            }
        }
    }
}
