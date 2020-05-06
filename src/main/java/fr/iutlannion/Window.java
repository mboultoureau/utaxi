package fr.iutlannion;

import fr.iutlannion.auth.Connexion;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Window extends Stage {

    private Label label = new Label("Page principal");
    private Connexion connexion = new Connexion(this);
    private Button buttonOk = new Button("OK");
    
    final Scene scenePrincipal = new Scene(principal(), 750, 500);
    final Scene sceneConnexion = new Scene(connexion.creerContenu(), 750, 500);

    public Window() {
        this.setTitle("Ma première fenêtre");
        this.setWidth(500);
        this.setHeight(150);
        this.setX(0);
        this.setY(0);
        
        this.setScene(scenePrincipal);
        
        final Window self = this;

        buttonOk.setOnMouseClicked((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("Hello World");
                self.setScene(sceneConnexion);
                self.setWidth(750);
                self.setHeight(500);
            }
        }));
    }

    
    public void goToPrincipal() {
    	this.setScene(scenePrincipal);
    }


    Parent principal() {

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