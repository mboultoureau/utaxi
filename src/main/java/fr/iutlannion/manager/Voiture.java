package fr.iutlannion.manager;

import fr.iutlannion.exceptions.FormatException;

public class Voiture {
	private String immatriculation;
	private String marque;
	private String typeEssence;
	private String couleur;
	private String type;
	private Double nbKms;

	public Voiture(String immatriculation, String marque, String typeEssence, String couleur, String type) {
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.typeEssence = typeEssence;
		this.couleur = couleur;
		this.type = type;
	}

	public Voiture(){
		this(null, null, null, null, null);
	}

	public String toString() {
		return "Immatriculation : " + immatriculation + "\nMarque : " + marque + "\nType essence : " + typeEssence
				+ "\nCouleur : " + couleur + "\nType : " + type;
	}

	public void setImmatriculation(String n) throws FormatException {
		n = n.trim();
		
		if (n.length() < 1 || n.length() > 30) {
			throw new FormatException("L'immatriculation doit contenir entre 1 et 30 caractères");
		}else {
			this.immatriculation = n;
			this.immatriculation = immatriculation.toUpperCase();
		}
	}

	public String getImmatriculation() {
		return immatriculation;
	}

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

	public void setTypeEssence(String n) throws FormatException {
		n = n.trim();
		
		if (n.length() < 1 || n.length() > 30) {
			throw new FormatException("Le type d'essence doit contenir entre 1 et 30 caractères");
		}else {
			this.typeEssence = n;
		}
	}

	public String getTypeEssence() {
		return typeEssence;
	}

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