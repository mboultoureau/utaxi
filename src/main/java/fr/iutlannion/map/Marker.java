package fr.iutlannion.map;

/**
 * Représente un marqueur
 */
public class Marker {

    private LatLng coords;
    private boolean simple = true;
    private Icon icon = null;

    /**
     * Créé un marqueur
     * @param coords Coordonnées du marqueur
     */
    public Marker(LatLng coords) {
        this.coords = coords;
    }

    /**
     * Retourne les coordonnées GPS du marqueur
     * @return Coordonnées GPS du marqueur
     */
    public LatLng getCoords() {
        return this.coords;
    }

    /**
     * Renvoie un booléan avec sa simplicité (avec icone ou non)
     * Utilisé en interne pour MapView
     * @return Simplicité du marqueur
     */
    public boolean isSimple() {
        return simple;
    }

    /**
     * Définit l'icone du marqueur
     * @param icon Icone du marqueur
     */
    public void setIcon(Icon icon) {
        this.icon = icon;
        simple = false;
    }

    /**
     * Retourne l'icone du marqueur
     * @return Icone du marqueur
     */
    public Icon getIcon() {
        return this.icon;
    }

    /**
     * Définit la position du marqueur
     * @param coords Coordonnées GPS du marqueur
     */
    public void setPosition(LatLng coords) {
        this.coords = coords;
    }

}
