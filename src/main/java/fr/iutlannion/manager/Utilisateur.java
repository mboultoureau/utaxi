package fr.iutlannion.manager;

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

	public void setPersonne(Admin a) {
		personne = a;
		instance = this;
	}

	public void setPersonne(Passager p) {
		personne = p;
		instance = this;
	}

	public void setPersonne(Conducteur c) {
		personne = c;
		instance = this;
	}

	public void destroyUtilisateur() {
		personne = null;
		instance = this;
	}
}
