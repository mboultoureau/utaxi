package fr.iutlannion.manager;

public class Voiture {
	private String immatriculation;
	private String marque;
	private String typeEssence;
	private String couleur;
	private String type;

	public Voiture(String immatriculation, String marque, String typeEssence, String couleur, String type) {
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.typeEssence = typeEssence;
		this.couleur = couleur;
		this.type = type;
	}

	public String toString() {
		return "Immatriculation : " + immatriculation + "\nMarque : " + marque + "\nType essence : " + typeEssence
				+ "\nCouleur : " + couleur + "\nType : " + type;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public String getMarque() {
		return marque;
	}

	public String getTypeEssence() {
		return typeEssence;
	}

	public String getCouleur() {
		return couleur;
	}

	public String getType() {
		return type;
	}

	public Voiture modifierInfo(String immatriculation, String marque, String typeessence, String couleur,
			String type) {
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.typeEssence = typeessence;
		this.couleur = couleur;
		this.type = type;
		return this;
	}
}