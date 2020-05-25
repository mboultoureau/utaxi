package fr.iutlannion.auth;

import fr.iutlannion.core.Window;
import javafx.event.EventHandler;
<<<<<<< HEAD
import javafx.geometry.HPos;
=======
>>>>>>> a3ca3cb65cb8b71fa482619b122de8c13ab78311
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
<<<<<<< HEAD
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
=======
>>>>>>> a3ca3cb65cb8b71fa482619b122de8c13ab78311
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PagePassager extends Stage {

<<<<<<< HEAD
	
    
	// Header
    private HBox header = new HBox();
    private HBox bg = new HBox();
=======
	private BorderPane root = new BorderPane();

	// Header
	private HBox header = new HBox();
>>>>>>> a3ca3cb65cb8b71fa482619b122de8c13ab78311
	private Button backButton = new Button("Deconnexion");
	private Label title = new Label("Page Passager");
	private Label logo = new Label("UTaxi");

<<<<<<< HEAD
    private GridPane gridPane = new GridPane();
    private BorderPane root = new BorderPane();
    private TextField depart = new TextField();
    private TextField arrive = new TextField();
    private TextField prixMin = new TextField();
    private TextField prixMax = new TextField();
    private Button LetsGo = new Button("Let's GO !");
=======
	private GridPane gridPane = new GridPane();
>>>>>>> a3ca3cb65cb8b71fa482619b122de8c13ab78311

	public PagePassager() {

		backButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
<<<<<<< HEAD
				Window.getInstance().gotoPage("mainMenu");
=======
				Window.getInstance().gotoPage("connexion");
>>>>>>> a3ca3cb65cb8b71fa482619b122de8c13ab78311
			}
		}));

	}

	public Parent creerContenu() {

		// Header
		header.setMinWidth(640);
		header.setPadding(new Insets(0, 20, 0, 20));

		header.setPrefHeight(50);
		header.setStyle("-fx-background-color: #000;");
		header.setAlignment(Pos.CENTER);

		// Back
		backButton.setStyle(
				"-fx-background-color: #000; -fx-text-fill: #fff; -fx-border-color: #fff; -fx-border-width: 2;");
<<<<<<< HEAD
        backButton.setAlignment(Pos.CENTER_LEFT);

        bg.setMinWidth(640);
        bg.setPrefHeight(400);
        bg.setStyle("-fx-background-color;#000;");
        bg.setAlignment(Pos.CENTER);
        
=======
		backButton.setAlignment(Pos.CENTER_LEFT);
>>>>>>> a3ca3cb65cb8b71fa482619b122de8c13ab78311

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

<<<<<<< HEAD
        root.setTop(header);
        gridPane.setAlignment(Pos.TOP_CENTER);
        //Colonnes et Lignes
        gridPane.add(depart,0,1);
        gridPane.add(arrive,0,2);
        gridPane.add(prixMin,1,1);
        gridPane.add(prixMax,1,2);
        gridPane.add(LetsGo,2,2);
		return root;

	}
}
=======
		root.setTop(header);
		return root;

	}
}
>>>>>>> a3ca3cb65cb8b71fa482619b122de8c13ab78311
