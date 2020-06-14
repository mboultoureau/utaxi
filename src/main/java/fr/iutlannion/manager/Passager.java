package fr.iutlannion.manager;

import fr.iutlannion.map.LatLng;
import fr.iutlannion.map.Marker;

/**
 * Définit un passager
 */
public class Passager extends Personne {

    private Marker marker;
    private CarteBancaire cb;

    private static final LatLng DEFAULT_LOCATION = new LatLng(47.220829, -1.565942);

    /**
     * Créé un nouveau passager
     * @param nom Le nom de famille
     * @param prenom Le prénom
     * @param email L'adresse e-mail
     * @param motDePasse Le mot de passe
     * @param localisation La localisation
     * @param cb La carte bancaire
     */
    public Passager(String nom, String prenom, String email, String motDePasse, LatLng localisation, CarteBancaire cb) {
        super(nom, prenom, email, motDePasse);
        this.marker = new Marker(localisation);
        this.cb = cb;
    }

    /**
     * Créé un passager vide
     */
    public Passager() {
        super(null, null, null, null);
        this.marker = new Marker(DEFAULT_LOCATION);
        this.cb = null;
    }

    /**
     * Définit la carte bancaire du passager
     * @param cb La nouvelle carte bancaire
     */
    public void setCb(CarteBancaire cb) {
        this.cb = cb;
    }

    /**
     * Récupère le marqueur avec la localisation actuelle du passager
     * @return Le marqueur avec la localisation du passager
     */
    public Marker getMarker() {
        return this.marker;
    }
}