package fr.iutlannion.auth;

abstract public class Personne {

    private String nom;
    private String prenom;
    private String email;
    private String id;

    Personne(String nom, String prenom, String email, String id) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.id = id;
    }

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getEmail() {
		return email;
	}

	public String getId() {
		return id;
	}
}