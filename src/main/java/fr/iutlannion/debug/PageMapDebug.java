package fr.iutlannion.debug;

import fr.iutlannion.core.Window;
import fr.iutlannion.map.Icon;
import fr.iutlannion.map.Marker;
import fr.iutlannion.map.MapOptions;
import fr.iutlannion.map.MapView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PageMapDebug extends Stage {

    private BorderPane root = new BorderPane();

    // Header
    private HBox header = new HBox();
    private Button backButton = new Button("Retour");
    private Label title = new Label("Page de débogage de carte");
    private Label logo = new Label("UTaxi");

    // Left Side
    private ScrollPane leftScroll = new ScrollPane();
    private VBox leftSide = new VBox();

    // Right Side
    private MapOptions mapOptions = new MapOptions();
    private MapView map;
    private ArrayList<Marker> markers;

    // Déplacement
    private Label moveLabel = new Label("Déplacement");
    private HBox move = new HBox();
    private Label x = new Label(" x: ");
    private TextField xField = new TextField("47.2186371");
    private Label y = new Label(" y: ");
    private TextField yField = new TextField("-1.5541362");
    private Label zoom = new Label(" zoom: ");
    private TextField zoomField = new TextField("13");
    private Button moveButton = new Button("Se déplacer");

    // Marqueurs
    private Button deleteButton = new Button("Supprimer le 3ème marqueur");
    private Marker marker1 = new Marker(48.833, 2.333);
    private Marker marker2 = new Marker(49.833, 2.333);
    private Marker marker3 = new Marker(50.833, 2.333);

    private Button moveMarkerButton = new Button("Bouger le marqueur");
    private Button disableRoutingButton = new Button("Désactiver le trajet");

    private Icon icon = new Icon("img/taxi.png", 40, 20);

    public PageMapDebug() {
        backButton.setOnAction(e -> Window.getInstance().gotoPage("debug"));
        moveButton.setOnAction(e -> map.setView(Double.valueOf(xField.getText()), Double.valueOf(yField.getText()), Integer.valueOf(zoomField.getText())));
        deleteButton.setOnAction(e -> map.removeMarker(marker3));
        moveMarkerButton.setOnAction(e -> map.moveMarker(marker1,51.833, 2.333));
        disableRoutingButton.setOnAction(e -> map.disableRouting());
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

        // Move
        xField.setPrefWidth(90);
        yField.setPrefWidth(90);
        zoomField.setPrefWidth(35);
        move.getChildren().addAll(x, xField, y, yField, zoom, zoomField);
        move.setAlignment(Pos.CENTER_LEFT);
        moveButton.setPrefWidth(300);

        // Left Side
        leftSide.getChildren().addAll(moveLabel, move, moveButton, deleteButton, moveMarkerButton, disableRoutingButton);
        leftScroll.setContent(leftSide);
        leftScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        leftScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        // Map
        mapOptions.setCoordinates(47.2186371, -1.5541362);
        mapOptions.setZoom(13);
        map = new MapView(mapOptions);
        map.addMarker(marker1);

        // Icon Marker
        marker2.setIcon(icon);
        map.addMarker(marker2);
        map.addMarker(marker3);
        map.traceRoute(marker2, marker3);


        root.setTop(header);
        root.setRight(map);
        root.setLeft(leftScroll);

        return root;

    }
}