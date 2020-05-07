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

    public MenuPrincipal() {
        buttonConnexion.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Window.getInstance().gotoPage("connexion");
                Window.getInstance().setWidth(750);
                Window.getInstance().setHeight(500);
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

        return gridPane1;
    }

}
