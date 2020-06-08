package fr.iutlannion.map;

public class MapOptions {

    private LatLng coords;
    private int zoom;

    private static final LatLng defaultCoordonnees = new LatLng(48.833, 2.333);
    private static final int defaultZoom = 7;


    public MapOptions() {
        coords = defaultCoordonnees;
        zoom = defaultZoom;
    }

    public MapOptions(LatLng coords, int zoom) {
        this.coords = coords;
        this.zoom = zoom;
    }

    public MapOptions(LatLng coords) {
        this.coords = coords;
        this.zoom = defaultZoom;
    }

    public void setCoordinates(LatLng coords) {
        this.coords = coords;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public LatLng getCoords() {
        return this.coords;
    }

    public int getZoom() {
        return zoom;
    }

}
