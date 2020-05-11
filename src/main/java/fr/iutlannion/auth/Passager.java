package fr.iutlannion.auth;

public class Passager extends Personne {

    public Passager(String nom, String prenom, String email, String motDePasse) {
        super(nom, prenom, email, motDePasse);
    }

    public Passager() {
		super(null, null, null, null);
	}

	public void reserver() {

    }

}