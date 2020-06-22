package fr.iutlannion.core;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * Classe du menu principal avec les boutons de connexion, d'inscription et de
 * debug si activé
 */

public class PageMenuPrincipal extends Stage {

	private BorderPane root = new BorderPane();
	private Label title = new Label("Bienvenue sur UTAXI");
	private Label authors = new Label(
			"Par Manon Goasguen, Erwan Leflot, Rémi Bastille, Ronan Renoux et Mathis Boultoureau");
	private ImageView image;

	private VBox bottom = new VBox();
	private HBox buttons = new HBox();
	private Button login = new Button("Connexion");
	private Button register = new Button("Inscription");
	private Button debug = new Button("Debug");
	private Region space = new Region();

	public PageMenuPrincipal() {
		Window.getInstance().setResizable(false);

		Window.getInstance().setWidth(640);
		Window.getInstance().setHeight(480);

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

		// Bottom
		authors.setTextAlignment(TextAlignment.CENTER);
		authors.setAlignment(Pos.CENTER);
		bottom.setAlignment(Pos.CENTER);
		bottom.getChildren().addAll(buttons, authors);

		// BorderPane
		root.setPadding(new Insets(30, 0, 10, 0));
		root.setTop(title);
		root.setCenter(image);
		root.setBottom(bottom);

		root.setStyle("-fx-background-color: #fff");

		return root;
	}
}
