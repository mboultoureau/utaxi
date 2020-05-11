package fr.iutlannion.core;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class MenuPrincipal {
    private Label label = new Label("Page principal");
    private Button buttonConnexion = new Button("Connexion");
    private Button buttonInscription = new Button("Incription");
    private Button buttonEditer = new Button("Editer profil");
    private Button buttonEnregistrerVoiture = new Button("Enregistrer Voiture");
    private Button buttonHoraires = new Button("Horaires");

    
    public MenuPrincipal() {
        buttonConnexion.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Window.getInstance().gotoPage("connexion");
            }
        }));
        
        buttonInscription.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Window.getInstance().gotoPage("inscription");
            }
        }));
        
        buttonEditer.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Window.getInstance().gotoPage("editionProfil");
            }
        }));

        buttonEnregistrerVoiture.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Window.getInstance().gotoPage("enregistrementVoiture");
            }
        }));
        
        buttonHoraires.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Window.getInstance().gotoPage("horaires");
            }
        }));
    }

    Parent creerContenu() {

        buttonConnexion.setMinSize(50, 50);
        buttonInscription.setMinSize(50, 50);

        GridPane gridPane1 = new GridPane();
        gridPane1.setPadding(new Insets(10));
        gridPane1.setAlignment(Pos.CENTER);
        gridPane1.setVgap(5);
        gridPane1.setHgap(5);
        gridPane1.add(label, 0, 0);
        label.setAlignment(Pos.CENTER);
        gridPane1.add(buttonConnexion, 0, 1);
        gridPane1.add(buttonInscription, 1, 1);
        gridPane1.add(buttonEditer, 1, 2);
        gridPane1.add(buttonEnregistrerVoiture, 1, 3);
        gridPane1.add(buttonHoraires, 1, 4);

        return gridPane1;
    }

}
