package fr.iutlannion.map;

/**
 * Représente des coordonnées GPS
 */
public class LatLng {

    private double latitude;
    private double longitude;

    /**
     * Créé une nouvelle coordonnée GPS
     * @param latitude Latitude
     * @param longitude Longitude
     */
    public LatLng(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Retourne les coordonnées GPS sous forme de chaine de caractères
     * @return Coordonnées GPS sous forme de chaine de caractères
     */
    public String toString() {
        return "x: " + latitude + ", y : " + longitude;
    }

    /**
     * Retourne les coordonnées GPS sous forme de chaine de caractères
     * Utile pour l'utilisation avec Leaflet
     * @return Coordonnées GPS sous forme de chaine de caractères
     */
    public String internalString() {
        return latitude + ", " + longitude;
    }

    /**
     * Retourne la latitude
     * @return Latitude
     */
    public double getLatitude() {
        return this.latitude;
    }

    /**
     * Retourne la longitude
     * @return Longitude
     */
    public double getLongitude() {
        return this.longitude;
    }

}
