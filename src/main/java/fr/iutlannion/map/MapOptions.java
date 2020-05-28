package fr.iutlannion.map;

public class MapOptions {

    private double x;
    private double y;
    private int zoom;

    private static final double defaultX = 48.833;
    private static final double defaultY = 2.333;
    private static final int defaultZoom = 7;


    public MapOptions() {
        x = defaultX;
        y = defaultY;
        zoom = defaultZoom;
    }

    public MapOptions(double x, double y, int zoom) {
        this.x = x;
        this.y = y;
        this.zoom = zoom;
    }

    public MapOptions(double x, double y) {
        this.x = x;
        this.y = y;
        this.zoom = defaultZoom;
    }

    public void setCoordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getZoom() {
        return zoom;
    }

}
