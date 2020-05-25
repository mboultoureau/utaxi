package fr.iutlannion.auth;

import java.util.ArrayList;

import fr.iutlannion.core.Voiture;
import fr.iutlannion.exceptions.FormatException;

public class Conducteur extends Personne {

    private double tarif;
    private double nbKmParcourus;

    private ArrayList<Float> notes;
    private Voiture voiture;

    public Conducteur(String nom, String prenom, String email, String motDePasse, double tarif, double nbKmParcourus,
            Voiture voiture) {

        super(nom, prenom, email, motDePasse);

        this.notes = new ArrayList<Float>();
        this.tarif = tarif;
        this.nbKmParcourus = nbKmParcourus;
        this.voiture = voiture;
    }

    public Conducteur() {
        super(null, null, null, null);
    }

    public String toString() {
        return super.toString() + "\nNotes : " + getNoteMoyenne() + "\nTarif : " + tarif + "\nNombre Km : "
                + nbKmParcourus + "\n" + voiture.toString();
    }

    public double getSalaire() {
        return 0.0;
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

    public Voiture getVoiture() {
        return voiture;
    }

    public void ajouterNote(float note) {
        notes.add(note);
    }

    public void modifierInfoVoiture(double tarif, double kmParcourus, String immatriculation, String marque,
            String typeessence, String couleur, String type) {
        this.tarif = tarif;
        this.nbKmParcourus = kmParcourus;
        this.voiture = this.voiture.modifierInfo(immatriculation, marque, typeessence, couleur, type);
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
        this.voiture = this.voiture.modifierInfo(immatriculation, marque, typeessence, couleur, type);
    }

}