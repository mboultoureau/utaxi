package fr.iutlannion.auth;

import fr.iutlannion.core.Window;
import fr.iutlannion.manager.CarteBancaire;
import fr.iutlannion.manager.Passager;
import fr.iutlannion.manager.Utilisateurs;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
	private Image frontCard = new Image("img/credit-card-front.png");
	private Image backCard = new Image("img/credit-card-back.png");
	private ImageView imageView = new ImageView(frontCard);
	private StackPane creditCard = new StackPane();
	private Label numCard = new Label("0000 0000 0000 0000");
	private Label nameCard = new Label("DUPONT JEAN");
	private Label expirationCard = new Label("12/20");
	private Label cvcCard = new Label("000");

	// Bouton suivant et précédent
	private HBox buttons = new HBox();
	private Button previousButton = new Button("Précédent");
	private Button nextButton = new Button("Suivant");
	private Region space = new Region();

	// Valeurs
	private String numText = "";
	private String nameText = "";
	private String expirationText = "";
	private String cvcText = "";

	public PagePaiement() {
		Window.getInstance().setMinWidth(700);

		// Événements
		backButton.setOnAction(e -> Window.getInstance().gotoPage("inscription"));

		nextButton.setOnAction(e -> {
			if (numText.matches("^[0-9]{0,16}$") && expirationText.matches("^(0[0-9]|1[0-2])\\/[2-3][0-9]$")
					&& nameText.matches("^[a-zA-Zéèëàäï ]{3,100}$") && cvcText.matches("^[0-9]{3}$")) {
				CarteBancaire cb = new CarteBancaire(numText, expirationText, cvcText, nameText);
				Passager p = (Passager) Utilisateurs.getPersonneCourante();
				p.setCb(cb);
				Utilisateurs.setPersonneCourante(p);
				Utilisateurs.add(p);
				Window.getInstance().gotoPage("passager");
			} else {
				nameError.setVisible(true);
				nameError.setText("Veuillez rentrer tous les champs pour continuer");
			}
		});

		numField.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
				displayFront();
			}
		});

		expirationField.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
				displayFront();
			}
		});

		nameField.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
				displayFront();
			}
		});

		cvcField.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
				displayBack();
			}
		});

		// Erreurs dynamiques
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

		cvcField.textProperty().addListener((observableValue, oldValue, newValue) -> {
			if (newValue.matches("^[0-9]{3}$")) {
				cvcText = newValue;
				update();
				cvcError.setVisible(false);
			} else {
				cvcError.setText("Veuillez saisir un CVC valide (3 chiffres).");
				cvcError.setVisible(true);
			}
		});
	}

	private void displayFront() {
		imageView.setImage(frontCard);
		nameCard.setVisible(true);
		numCard.setVisible(true);
		expirationCard.setVisible(true);
		cvcCard.setVisible(false);
	}

	private void displayBack() {
		imageView.setImage(backCard);
		nameCard.setVisible(false);
		numCard.setVisible(false);
		expirationCard.setVisible(false);
		cvcCard.setVisible(true);
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

		if (cvcText.matches("^[0-9]{3}$")) {
			cvcCard.setText(cvcText);
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

		grid.setPadding(new Insets(40, 20, 0, 20));

		// Carte de crédit
		final float height = 54.0f * 3.5f;
		final float width = 85.0f * 3.5f;

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
		cvcCard.setVisible(false);
		cvcCard.setStyle("-fx-text-fill: #222;");
		cvcCard.setFont(new Font("Arial", 15));
		StackPane.setAlignment(cvcCard, Pos.CENTER_LEFT);
		StackPane.setMargin(cvcCard, new Insets(0, 0, 62, 162));

		// Expiration
		expirationCard.setStyle("-fx-text-fill: #222;");
		expirationCard.setFont(new Font("Arial", 15));
		StackPane.setAlignment(expirationCard, Pos.CENTER_LEFT);
		StackPane.setMargin(expirationCard, new Insets(130, 0, 0, 240));

		creditCard.setPadding(new Insets(0, 50, 0, 50));
		creditCard.setPrefHeight(height);
		creditCard.setPrefWidth(width);
		creditCard.getChildren().addAll(imageView, numCard, nameCard, cvcCard, expirationCard);
		creditCard.setStyle("-fx-border-radius: 50px");

		root.setRight(creditCard);

		// Buttons
		HBox.setHgrow(space, Priority.ALWAYS);

		previousButton.setPrefWidth(150);
		previousButton.setPrefHeight(50);

		nextButton.setPrefWidth(150);
		nextButton.setPrefHeight(50);

		buttons.setPadding(new Insets(0, 50, 25, 50));
		buttons.setSpacing(40);
		buttons.getChildren().addAll(previousButton, space, nextButton);

		root.setBottom(buttons);

		return root;
	}

}
