package fr.iutlannion.auth;

import fr.iutlannion.exceptions.TextFieldException;

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
	
	public void setNom(String n) throws TextFieldException {
		n = n.trim();
		
		if (n.length() < 3 || n.length() > 30) {
			throw new TextFieldException("Le nom doit contenir entre 3 et 30 caractères");
		} else if (!n.matches("[a-zA-Zéèêà -]+")) {
			throw new TextFieldException("Le nom doit contenir uniquement des lettres et des espaces.");
		} else {
			this.nom = n;
		}
	}

	public String getPrenom() {
		return this.prenom;
	}
	
	public void setPrenom(String p) throws TextFieldException {
		p = p.trim();
		
		if (p.length() < 3 || p.length() > 30) {
			throw new TextFieldException("Le prénom doit contenir entre 3 et 30 caractères");
		} else if (!p.matches("[a-zA-Zéèêà -]+")) {
			throw new TextFieldException("Le prénom doit contenir uniquement des lettres et des espaces.");
		} else {
			this.prenom = p;
		}
	}

	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String e) throws TextFieldException {
		e = e.trim();
		
		if (e.length() < 3 || e.length() > 120) {
			throw new TextFieldException("Votre adresse email doit contenir entre 3 et 120 caractères");
		} else if (!e.matches("(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)")) {
			throw new TextFieldException("L'adresse email doit être valide.");
		} else {
			this.email = e;
		}
	}

	public int getId() {
		return this.id;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}
	
	public void setPassword(String p) throws TextFieldException {
		if (p.length() < 5 || p.length() > 120) {
			throw new TextFieldException("Le mot de passe doit contenir entre 5 et 120 caractères");
		} else {
			this.motDePasse = p;
		}
	}

	public void modifierInfo(String nom, String prenom, String email, String motdepasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motdepasse;
	}
}