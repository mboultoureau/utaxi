package fr.iutlannion.map;

public class Marker {

    private double x;
    private double y;
    private boolean simple = true;

    public Marker(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isSimple() {
        return simple;
    }

}
