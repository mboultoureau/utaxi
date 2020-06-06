package fr.iutlannion.manager;

import fr.iutlannion.map.Marker;

public class Passager extends Personne {

    private Marker marker;

    public Passager(String nom, String prenom, String email, String motDePasse, double x, double y) {
        super(nom, prenom, email, motDePasse);
        this.marker = new Marker(x, y);
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