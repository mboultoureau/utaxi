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
    private Button buttonOk = new Button("OK");
    
 
    
    public MenuPrincipal() {   	
        buttonOk.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("Hello World");
                Window.getInstance().gotoPage("connexion");
                Window.getInstance().setWidth(750);
                Window.getInstance().setHeight(500);
            }
        }));
    }

    Parent creerContenu() {

        GridPane gridPane1 = new GridPane();
        gridPane1.setPadding(new Insets(10));
        gridPane1.setAlignment(Pos.CENTER);
        gridPane1.setVgap(5);
        gridPane1.setHgap(5);
        gridPane1.add(label, 0, 0);
        gridPane1.add(buttonOk, 50, 0);

        return gridPane1;
    }

}
