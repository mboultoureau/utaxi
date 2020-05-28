package fr.iutlannion.core;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class PageMenuPrincipal {
	
	private BorderPane root = new BorderPane();
	private Label title = new Label("UTAXI");
	private ImageView image;
	
	private HBox buttons = new HBox();
	private Button login = new Button("Connexion");
	private Button register = new Button("Inscription");
	private Button debug = new Button("Debug");
	private Region space = new Region();
	
	public PageMenuPrincipal() {
		login.setOnAction(e -> Window.getInstance().gotoPage("connexion"));
		register.setOnAction(e -> Window.getInstance().gotoPage("inscription"));
		debug.setOnAction(e -> Window.getInstance().gotoPage("debug"));
	}
	
    Parent creerContenu() {
    	// Title
    	title.setStyle("-fx-text-fill: #000;");
    	title.setTextAlignment(TextAlignment.CENTER);
    	title.setFont(new Font("Arial", 30));
    	title.setAlignment(Pos.CENTER);
    	BorderPane.setAlignment(title, Pos.CENTER);
    	
    	// Image
    	image = new ImageView(new Image("img/taxi-order.png"));
    	image.setPreserveRatio(true);
    	image.setFitWidth(350);
    	
    	// Login
    	login.setAlignment(Pos.CENTER);
    	login.setPrefWidth(150);
    	login.setPrefHeight(50);
    	
    	// Register
    	register.setAlignment(Pos.CENTER);
    	register.setPrefWidth(150);
    	register.setPrefHeight(50);
    	
    	// Debug
    	debug.setAlignment(Pos.CENTER);
    	debug.setPrefWidth(150);
    	debug.setPrefHeight(50);
    	
    	// Buttons
    	HBox.setHgrow(space, Priority.ALWAYS);
    	
    	buttons.setPadding(new Insets(25, 50, 25, 50));
    	buttons.setSpacing(40);
    	
    	if (!App.DEBUG)
    		buttons.getChildren().addAll(login, space, register);
    	else
    		buttons.getChildren().addAll(login, register, debug);


    	// BorderPane
    	root.setPadding(new Insets(30, 0, 10, 0));
    	root.setTop(title);
    	root.setCenter(image);
    	root.setBottom(buttons);
 
    	
    	root.setStyle("-fx-background-color: #fff");
    	
		return root;
    }
}
