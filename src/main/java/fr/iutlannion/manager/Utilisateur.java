package fr.iutlannion.manager;

import fr.iutlannion.auth.Admin;
import fr.iutlannion.auth.Conducteur;
import fr.iutlannion.auth.Passager;
import fr.iutlannion.auth.Personne;

public class Utilisateur {
	
	private static Utilisateur instance;
	private Personne personne;
	
	public Utilisateur(Admin a) {
		personne = a;
		instance = this;
	}
	
	public Utilisateur(Passager p) {
		personne = p;
		instance = this;
	}
	
	public Utilisateur(Conducteur c) {
		personne = c;
		instance = this;
	}
	
	public static Utilisateur getInstance() {
		return instance;
	}
	
	public Personne getPersonne() {
		return this.personne;
	}
}
