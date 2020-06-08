package fr.iutlannion.manager;

import fr.iutlannion.map.LatLng;
import fr.iutlannion.map.Marker;

public class Passager extends Personne {

    private Marker marker;

    public Passager(String nom, String prenom, String email, String motDePasse, LatLng coords) {
        super(nom, prenom, email, motDePasse);
        this.marker = new Marker(coords);
    }

    public Passager() {
        super(null, null, null, null);
    }

    public Marker getMarker() {
        return this.marker;
    }

    public void reserver() {

    }

}