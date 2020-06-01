package fr.iutlannion.map;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.util.ArrayList;

public class MapView extends StackPane {

    private final WebView browser = new WebView();
    private final WebEngine webEngine = browser.getEngine();
    private final ProgressIndicator loader = new ProgressIndicator(0);
    private boolean loaded = false;
    private int routingMarker1;
    private int routingMarker2;
    public boolean enableRouting = false;

    private ArrayList<Marker> markers;

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
            public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                if (newValue == Worker.State.SUCCEEDED) {
                    loaded = true;
                    loader.setVisible(false);

                    // Center map
                    setView(mapOptions.getX(), mapOptions.getY(), mapOptions.getZoom());

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

    public void setView(double x, double y, int zoom) {
        if(!loaded) return;
        webEngine.executeScript("setView(" + x + ", " + y + ", " + zoom + ");");
    }

    public void setView(double x, double y) {
        setView(x, y, 7);
    }

    public void addMarker(Marker marker) {
        markers.add(marker);
        displayMarker(marker);
    }

    public void removeMarker(Marker marker) {
        int position = -1;

        if (markers.contains(marker)) {
            position = markers.indexOf(marker);
            markers.remove(marker);
        }

        if (position == -1) return;
        if (!loaded) return;

        webEngine.executeScript("removeMarker(" + position + ");");
    }

    public void moveMarker(Marker marker, double x, double y) {
        int position = -1;

        if (markers.contains(marker)) {
            position = markers.indexOf(marker);
            markers.get(position).setPosition(x, y);
        }

        if (position == -1) return;
        if (!loaded) return;

        webEngine.executeScript("moveMarker(" + position + ", " + x + ", " + y + ");");
    }

    public void displayMarker(Marker marker) {
        if(!loaded) return;

        if (marker.isSimple()) {
            webEngine.executeScript("addMarker(" + marker.getX() + ", " + marker.getY() + ");");
        }
        else {
            webEngine.executeScript("addMarker(" + marker.getX() + ", " + marker.getY() + ", " + marker.getIcon().getObject() + ");");
        }
    }

    public void traceRoute(Marker marker1, Marker marker2) {
        if (markers.contains(marker1) && markers.contains(marker2)) {
            routingMarker1 = markers.indexOf(marker1);
            routingMarker2 = markers.indexOf(marker2);
        } else {
            return;
        }

        enableRouting = true;
        if (!loaded) return;

        displayRouting();
    }

    private void displayRouting() {
        if (!enableRouting) return;
        webEngine.executeScript("traceRoute(" + routingMarker1 + ", " + routingMarker2 + ");");
    }

    public void disableRouting() {
        enableRouting = false;

        if(!loaded) return;
        webEngine.executeScript("removeRoute();");
    }
}