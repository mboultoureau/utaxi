package fr.iutlannion.auth;

import fr.iutlannion.core.Window;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class PagePaiement extends Stage {

	private BorderPane root = new BorderPane();

	// Header
	private HBox header = new HBox();
	private Button backButton = new Button("Retour");
	private Label title = new Label("INFORMATIONS DE PAIEMENT");
	private Label logo = new Label("UTaxi");

	// Informations de Paiement
	GridPane grid = new GridPane();
	private Label num = new Label("Numéro de la carte");
	private TextField numField = new TextField();
	private Label expiration = new Label("Date d'expiration");
	private TextField expirationField = new TextField();
	private Label cvc = new Label("CVC");
	private TextField cvcField = new TextField();
	private Label name = new Label("Nom inscrit sur la carte");
	private TextField nameField = new TextField();

	// Erreurs
	private Label numError = new Label();
	private Label expirationError = new Label();
	private Label cvcError = new Label();
	private Label nameError = new Label();

	
	// Carte de crédit
	// private Box backgroundCreditCard = new Box();
	private TriangleMesh mesh = new TriangleMesh();
	private PhongMaterial texture = new PhongMaterial();
	private StackPane creditCard = new StackPane();
	private Label numCard = new Label("0000 0000 0000 0000");
	private Label nameCard = new Label("DUPONT JEAN");
	private Label expirationCard = new Label("12/20");
	private Label cvcCard = new Label("000");

	// Valeurs
	private String numText = "";
	private String nameText = "";
	private String expirationText = "";
	
	public PagePaiement() {
		// Événements
		backButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Window.getInstance().gotoPage("mainMenu");
			}
		}));

		numField.textProperty().addListener(((observableValue, oldValue, newValue) -> {
			if (newValue.matches("^[0-9]{0,16}$")) {
				numText = newValue;
				update();
				numError.setVisible(false);
			} else {
				numError.setText("Vous devez saisir les 16 chiffres de votre carte.");
				numError.setVisible(true);
			}
		}));

		expirationField.textProperty().addListener((observableValue, oldValue, newValue) -> {
			if (newValue.matches("^(0[0-9]|1[0-2])\\/[2-3][0-9]$")) {
				expirationText = newValue;
				update();
				expirationError.setVisible(false);
			} else {
				expirationError.setText("Veuillez saisir une date d'expiration valide.");
				expirationError.setVisible(true);
			}
		});

		nameField.textProperty().addListener((observableValue, oldValue, newValue) -> {
			if (newValue.matches("^[a-zA-Zéèëàäï ]{3,100}$")) {
				nameText = newValue;
				update();
				nameError.setVisible(false);
			} else {
				nameError.setText("Veuillez saisir un nom valide (entre 3 et 100 lettres).");
				nameError.setVisible(true);
			}
		});
	}

	private void update() {
		if (numText.matches("^[0-9]{0,16}$")) {
			String[] digits = numText.split("(?<=\\G.{4})");
			String creditDigit = "";
			for (String digit : digits) {
				creditDigit += digit + " ";
			}

			numCard.setText(creditDigit);
		}

		if (nameText.matches("^[a-zA-Zéèëàäï ]{3,100}$")) {
			nameCard.setText(nameText.toUpperCase());
		}

		if (expirationText.matches("^(0[0-9]|1[0-2])\\/[2-3][0-9]$")) {
			expirationCard.setText(expirationText);
		}
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

		// Informations de paiement
		grid.add(num, 0, 0);
		grid.add(numField, 0, 1);
		grid.add(numError, 0, 2);
		grid.add(expiration, 0, 3);
		grid.add(expirationField, 0, 4);
		grid.add(expirationError, 0, 5);
		grid.add(cvc, 0, 6);
		grid.add(cvcField, 0, 7);
		grid.add(cvcError, 0, 8);
		grid.add(name, 0, 9);
		grid.add(nameField, 0, 10);
		grid.add(nameError, 0, 11);
		
		root.setMinHeight(480);
		root.setMinWidth(640);
		root.setTop(header);
		root.setLeft(grid);

		// Erreurs
		numError.setVisible(false);
		expirationError.setVisible(false);
		cvcError.setVisible(false);
		nameError.setVisible(false);

		numError.setTextFill(Color.RED);
		expirationError.setTextFill(Color.RED);
		cvcError.setTextFill(Color.RED);
		nameError.setTextFill(Color.RED);

		// Champs
		numField.setPromptText("0000111122223333");
		nameField.setPromptText("Dupont Jean");
		cvcField.setPromptText("123");
		expirationField.setPromptText("12/20");
		
		// Carte de crédit 3D		
		final float height = 54.0f * 3.5f;
		final float width = 85.0f * 3.5f;
		
		mesh.getPoints().addAll(
				0, 0, 0, // 0
				width, 0, 0, // 1
				width, height, 0, // 2
				0, height, 0, // 3
				
				0, 0, 1, // 4
				width, 0, 1, // 5
				width, height, 1, // 6
				0, height, 1 // 7
		);
		
		mesh.getTexCoords().addAll(
				0, 0, // 0
				0.5f, 0, // 1
				0.5f, 1, // 2
				0, 1, // 3
				1, 0, // 4
				1, 1 // 5
		);
		
		mesh.getFaces().addAll(
				0, 0, 2, 2, 1, 1, // Front 1
				0, 0, 3, 3, 2, 2, // Front 2
				4, 1, 5, 4, 6, 5, // Back 1
				4, 1, 6, 5, 7, 2 // Back 2
		);
		
		texture.setDiffuseMap(new Image("img/credit-card.png"));

		
		MeshView p = new MeshView(mesh);
		p.setDrawMode(DrawMode.FILL);
		p.setMaterial(texture);
		
		p.setRotationAxis(Rotate.Y_AXIS);
		p.setRotate(0.0);
		
		
		// Numéro de carte
		numCard.setStyle("-fx-text-fill: #fff;");
		numCard.setFont(new Font("Arial", 25));
		StackPane.setMargin(numCard, new Insets(30, 0, 0, 25));
		StackPane.setAlignment(numCard, Pos.CENTER);
		
		// Nom sur la carte
		nameCard.setStyle("-fx-text-fill: #fff;");
		nameCard.setFont(new Font("Arial", 12));
		numCard.setPrefWidth(width);
		StackPane.setMargin(nameCard, new Insets(90, 0, 0, 25));
		StackPane.setAlignment(nameCard, Pos.CENTER_LEFT);

		// CVC
		cvcCard.setStyle("-fx-text-fill: #222;");
		cvcCard.setFont(new Font("Arial", 15));
		StackPane.setAlignment(cvcCard, Pos.CENTER_LEFT);
		StackPane.setMargin(cvcCard, new Insets(0, 0, 62, 112));

		// Expiration
		expirationCard.setStyle("-fx-text-fill: #222;");
		expirationCard.setFont(new Font("Arial", 15));
		StackPane.setAlignment(expirationCard, Pos.CENTER_LEFT);
		StackPane.setMargin(expirationCard, new Insets(130, 0, 0, 240));
		
		
		creditCard.setPadding(new Insets(0, 50, 0, 20));
		creditCard.setPrefHeight(height);
		creditCard.setPrefWidth(width);
		creditCard.getChildren().addAll(p, numCard, nameCard, cvcCard, expirationCard);
		creditCard.setStyle("-fx-border-radius: 50px");

		root.setRight(creditCard);
		return root;
	}

}
