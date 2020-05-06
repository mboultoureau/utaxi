package fr.iutlannion.auth;

abstract public class Personne {

    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private static int nb = 0;
    private int id;

    Personne(String nom, String prenom, String email, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        
        nb++;
        this.id = nb;
    }

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public String getEmail() {
		return this.email;
	}

	public int getId() {
		return this.id;
	}
}