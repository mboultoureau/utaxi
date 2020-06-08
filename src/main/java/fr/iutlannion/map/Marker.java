package fr.iutlannion.map;

public class Marker {

    private LatLng coords;
    private boolean simple = true;
    private Icon icon = null;

    public Marker(LatLng coords) {
        this.coords = coords;
    }

    public LatLng getCoords() {
        return this.coords;
    }

    public boolean isSimple() {
        return simple;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
        simple = false;
    }

    public Icon getIcon() {
        return this.icon;
    }

    public void setPosition(LatLng coords) {
        this.coords = coords;
    }

}
