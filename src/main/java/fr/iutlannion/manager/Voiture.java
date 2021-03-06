package fr.iutlannion.manager;

import fr.iutlannion.exceptions.FormatException;

/**
 * classe descriptive de voiture
 */
public class Voiture {
	private String immatriculation;
	private String marque;
	private String typeEssence;
	private String couleur;
	private String type;
	private Double nbKms;

	//initialistation des caractèristiques de la voiture
	public Voiture(String immatriculation, String marque, String typeEssence, String couleur, String type) {
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.typeEssence = typeEssence;
		this.couleur = couleur;
		this.type = type;
	}

	//initialisation d'une voiture à null
	public Voiture(){
		this(null, null, null, null, null);
	}

	//création d'une chaine afin d'afficher les caractéristiques de la voiture
	public String toString() {
		return "Immatriculation : " + immatriculation + "\nMarque : " + marque + "\nType essence : " + typeEssence
				+ "\nCouleur : " + couleur + "\nType : " + type;
	}

	//vérification de la validité de l'immatriculation
	public void setImmatriculation(String n) throws FormatException {
		n = n.trim();
		
		if (n.length() < 1 || n.length() > 30) {
			throw new FormatException("L'immatriculation doit contenir entre 1 et 30 caractères");
		}else {
			n=n.toUpperCase();
			this.immatriculation = n;
		}
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	//vérification de la validité de la marque
	public void setMarque(String n) throws FormatException {
		n = n.trim();
		
		if (n.length() < 1 || n.length() > 30) {
			throw new FormatException("La marque doit contenir entre 1 et 30 caractères");
		} else if (!n.matches("[a-zA-Zéèêàë -]+")) {
			throw new FormatException("La Marque doit contenir uniquement des lettres et des espaces.");
		}else {
			this.marque = n;
		}
	}

	public String getMarque() {
		return marque;
	}

	public String getTypeEssence() {
		return typeEssence;
	}

	//vérification de la validité du type
	public void setType(String n) throws FormatException {
		n = n.trim();
		
		if (n.length() < 1 || n.length() > 30) {
			throw new FormatException("Le type doit contenir entre 1 et 30 caractères");
		} else if (!n.matches("[a-zA-Zéèêàë -]+")) {
			throw new FormatException("Le type doit contenir uniquement des lettres et des espaces.");
		}else {
			this.type = n;
		}
	}

	public String getType() {
		return type;
	}

	//vérification de la validité de la couleur
	public void setCouleur(String n) throws FormatException {
		n = n.trim();
		
		if (n.length() < 1 || n.length() > 30) {
			throw new FormatException("La couleur doit contenir entre 1 et 30 caractères");
		} else if (!n.matches("[a-zA-Zéèêàë -]+")) {
			throw new FormatException("La couleur doit contenir uniquement des lettres et des espaces.");
		}else {
			this.couleur = n;
		}
	}

	public String getCouleur() {
		return couleur;
	}

	public Double getNbKms(){
		return nbKms;
	}

	//Méthode de modification de la voiture
	public Voiture modifierInfo(Double nbKm, String immatriculation, String marque, String typeessence, String couleur,
			String type) {
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.typeEssence = typeessence;
		this.couleur = couleur;
		this.type = type;
		this.nbKms = nbKm;
		return this;
	}
}