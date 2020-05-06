package fr.iutlannion.auth;

import java.util.ArrayList;

import fr.iutlannion.core.Voiture;

public class Conducteur extends Personne {

    private double tarif;
    private double nbKmParcourus;

    private ArrayList<Float>notes;
    private Voiture voiture;

    public Conducteur(String nom, String prenom, String email, String motDePasse, double tarif, double nbKmParcourus, Voiture voiture){

        super(nom, prenom, email, motDePasse);
        
        this.notes = new ArrayList<Float>();
        this.tarif = tarif;
        this.nbKmParcourus = nbKmParcourus;
        this.voiture = voiture;
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

	public double getNbKmParcourus() {
		return nbKmParcourus;
	}

	public Voiture getVoiture() {
		return voiture;
	}
}