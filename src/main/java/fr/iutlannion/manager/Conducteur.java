package fr.iutlannion.manager;

import java.util.ArrayList;

import fr.iutlannion.core.Window;
import fr.iutlannion.exceptions.FormatException;
import fr.iutlannion.map.LatLng;
import fr.iutlannion.map.Marker;
import java.util.ArrayList;

/**
 * Représente un conducteur
 */
public class Conducteur extends Personne {

    private double tarif;
    private double nbKmParcourus;
    private boolean actif;
    private ArrayList<Double> notes;
    private ArrayList<Jour> jours;
    private Voiture voiture;
    private Marker marker;


    public Conducteur(String nom, String prenom, String email, String motDePasse, double tarif, double nbKmParcourus,
            Voiture voiture, LatLng coords) {

        super(nom, prenom, email, motDePasse);
        this.actif = true;
        this.notes = new ArrayList<Double>();
        this.tarif = tarif;
        this.nbKmParcourus = nbKmParcourus;
        this.voiture = voiture;
        this.marker = new Marker(coords);
    }

    public Conducteur() {
        super(null, null, null, null);
    }

    public String toString() {
        String res = "";
        if (Window.getInstance().getCurrentPage().compareTo("admin") == 0) {
            res = super.toString() + "\nNotes : " + getNoteMoyenne() + "\nTarif : " + tarif + "\nNombre Km : "
                    + nbKmParcourus + "\n" + voiture.toString();
        } else if (Window.getInstance().getCurrentPage().compareTo("passager") == 0) {
            res = this.getPrenom() + " " + this.getNom() + "\nTarif : " + this.getTarif() + "€" + "\nNotes moyenne : "
                    + this.getNoteMoyenne() + "\nVoiture : " + this.voiture.getMarque() + " de couleur "
                    + this.voiture.getCouleur();
        }
        return res;
    }

    public double getSalaire() {
        return 0.0;
    }

    public Marker getMarker() {
        return this.marker;
    }

    public float getNoteMoyenne() {
        float noteMoy = 0;
        for (int i = 0; i < notes.size(); i++) {
            noteMoy += notes.get(i);
        }
        return noteMoy / notes.size();
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(String t) throws FormatException {
        try {
            this.tarif = Double.valueOf(t);
        } catch (NumberFormatException e) {
            throw new FormatException("Le tarif doit être valide (ex : 10.3).");
        }
    }

    public double getNbKmParcourus() {
        return nbKmParcourus;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void ajouterNote(double note) {
        notes.add(note);
    }

    public void modifierInfoVoiture(double tarif, double kmParcourus, String immatriculation, String marque,
            String typeessence, String couleur, String type) {
        this.tarif = tarif;
        this.nbKmParcourus = kmParcourus;
        this.voiture = this.voiture.modifierInfo(kmParcourus, immatriculation, marque, typeessence, couleur, type);
    }

    public void modifierInfoAdmin(String nom, String prenom, String email, String motdepasse, double tarif,
            double kmParcourus, String immatriculation, String marque, String typeessence, String couleur,
            String type) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motdepasse;
        this.tarif = tarif;
        this.nbKmParcourus = kmParcourus;
        this.voiture = this.voiture.modifierInfo(kmParcourus, immatriculation, marque, typeessence, couleur, type);
    }

    public void addJour(Jour j){
        jours.add(j);
    }

    public Jour getJour(int i) {
        return jours.get(i);
    }

}