package fr.iutlannion.auth;

abstract public class Personne {

	protected String nom;
	protected String prenom;
	protected String email;
	protected String motDePasse;
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

	public String toString() {
		return "Id : " + id + "\nNom : " + nom + "\nPrenom : " + prenom + "\nEmail : " + email + "\nMot de passe : "
				+ motDePasse;
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

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void modifierInfo(String nom, String prenom, String email, String motdepasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motdepasse;
	}
}