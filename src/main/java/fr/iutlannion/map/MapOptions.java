package fr.iutlannion.map;

/**
 * Contient les options initiales de la carte
 */
public class MapOptions {

    private LatLng coords;
    private int zoom;

    private static final LatLng defaultCoordonnees = new LatLng(48.833, 2.333);
    private static final int defaultZoom = 7;


    /**
     * Définit les options initiales de la carte
     */
    public MapOptions() {
        coords = defaultCoordonnees;
        zoom = defaultZoom;
    }

    /**
     * Définit les options initiales de la carte
     * @param coords Les coordonnées initiales
     * @param zoom Le zoom initial
     */
    public MapOptions(LatLng coords, int zoom) {
        this.coords = coords;
        this.zoom = zoom;
    }

    /**
     * Définit les options initiales de la carte
     * @param coords Coordonnées initiales
     */
    public MapOptions(LatLng coords) {
        this.coords = coords;
        this.zoom = defaultZoom;
    }

    /**
     * Définit les coordonnées initiales de la carte
     * @param coords Coordonnées initiales de la carte
     */
    public void setCoordinates(LatLng coords) {
        this.coords = coords;
    }

    /**
     * Définit le zoom initial de la carte
     * @param zoom Zoom initial de la carte
     */
    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    /**
     * Retourne les coordonnées initiales de la carte
     * @return Coordonnées initiales de la carte
     */
    public LatLng getCoords() {
        return this.coords;
    }

    /**
     * Retourne le zoom initial de la carte
     * @return Zoom initial de la carte
     */
    public int getZoom() {
        return zoom;
    }

}
