package fr.iutlannion.map;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.util.ArrayList;

/**
 * Un widget contenant une carte
 * Géré avec Leaflet
 */
public class MapView extends StackPane {

    private static final int DEFAULT_ZOOM = 7;

    private final WebView browser = new WebView();
    private final WebEngine webEngine = browser.getEngine();
    private final ProgressIndicator loader = new ProgressIndicator(0);
    private boolean loaded = false;
    private int routingMarker1;
    private int routingMarker2;
    public boolean enableRouting = false;

    private ArrayList<Marker> markers;

    /**
     * Créé le widget
     * @param mapOptions Les options de la carte
     */
    public MapView(MapOptions mapOptions) {
        getChildren().addAll(browser, loader);

        // Display the loader
        loader.setMaxHeight(100);
        loader.setMaxWidth(100);

        Worker<Void> worker = webEngine.getLoadWorker();
        loader.progressProperty().bind(worker.progressProperty());
        loader.setVisible(true);

        // Hide when loading finished
        worker.stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue,
                    Worker.State newValue) {
                if (newValue == Worker.State.SUCCEEDED) {
                    loaded = true;
                    loader.setVisible(false);

                    // Center map
                    setView(mapOptions.getCoords(), mapOptions.getZoom());

                    // Display markers
                    for (Marker m : markers) {
                        displayMarker(m);
                    }

                    // Display routing
                    displayRouting();

                }
            }
        });

        // Load the page
        webEngine.setJavaScriptEnabled(true);
        webEngine.load(getClass().getClassLoader().getResource("html/map.html").toExternalForm());

        // Markers
        markers = new ArrayList<Marker>();
    }

    /**
     * Définit les coordonnées et le zoom de la carte
     * @param coords Coordonnées GPS
     * @param zoom Zoom
     */
    public void setView(LatLng coords, int zoom) {
        if (!loaded)
            return;
        webEngine.executeScript("setView(" + coords.internalString() + ", " + zoom + ");");
    }

    /**
     * Refraichit la carte
     */
    public void refresh() {
        if (!loaded)
            return;
        webEngine.executeScript("window.location.reload();");
    }

    /**
     * Définit les coordonnées de la carte avec le zoom par défaut
     * @param coords Coordonnées GPS
     */
    public void setView(LatLng coords) {
        setView(coords, DEFAULT_ZOOM);
    }

    /**
     * Ajoute un marqueur
     * @param marker Le marqueur à ajouter
     */
    public void addMarker(Marker marker) {
        markers.add(marker);
        displayMarker(marker);
    }

    /**
     * Supprimer un marqueur
     * @param marker Le marqueur à supprimer
     */
    public void removeMarker(Marker marker) {
        int position = -1;

        if (markers.contains(marker)) {
            position = markers.indexOf(marker);
            markers.remove(marker);
        }

        if (position == -1)
            return;
        if (!loaded)
            return;

        webEngine.executeScript("removeMarker(" + position + ");");
    }

    /**
     * Déplace un marqueur
     * @param marker Le marqueur à déplacer
     * @param coords Les nouvelles coordonnées du marqueur
     */
    public void moveMarker(Marker marker, LatLng coords) {
        int position = -1;

        if (markers.contains(marker)) {
            position = markers.indexOf(marker);
            markers.get(position).setPosition(coords);
        }

        if (position == -1)
            return;
        if (!loaded)
            return;

        webEngine.executeScript("moveMarker(" + position + ", " + coords.internalString() + ");");
    }

    /**
     * Affiche un marqueur
     * @param marker Le marqueur à afficher
     */
    public void displayMarker(Marker marker) {
        if (!loaded)
            return;

        if (marker.isSimple()) {
            webEngine.executeScript("addMarker(" + marker.getCoords().internalString() + ");");
        } else {
            webEngine.executeScript(
                    "addMarker(" + marker.getCoords().internalString() + ", " + marker.getIcon().getObject() + ");");
        }
    }

    /**
     * Trace un trajet entre deux marqueurs
     * @param marker1 Le marqueur de départ
     * @param marker2 Le marqueur d'arrivée
     */
    public void traceRoute(Marker marker1, Marker marker2) {
        if (markers.contains(marker1) && markers.contains(marker2)) {
            routingMarker1 = markers.indexOf(marker1);
            routingMarker2 = markers.indexOf(marker2);
        } else {
            return;
        }

        enableRouting = true;
        if (!loaded)
            return;

        displayRouting();
    }

    /**
     * Affiche le trajet
     */
    private void displayRouting() {
        if (!enableRouting)
            return;
        webEngine.executeScript("traceRoute(" + routingMarker1 + ", " + routingMarker2 + ");");
    }

    /**
     * Supprime le trajet affiché
     */
    public void disableRouting() {
        if (enableRouting) {
            enableRouting = false;

            if (!loaded)
                return;
            webEngine.executeScript("removeRoute();");
        }
    }
}
