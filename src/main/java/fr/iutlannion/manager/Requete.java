package fr.iutlannion.manager;

import java.util.Date;
/* Classe Requete c'est par elle qu'est formulée la demande d'un passager vers 
un conducteur pour effecuter un trajet
*/
public class Requete {
	private Passager passager;
	private Conducteur conducteur;
	private Date date;
	private double xClient;
	private double yClient;
	/* Ici, constructeur avec toutes les informations de la requete */
	Requete(Passager passager, Conducteur conducteur, Date date, double xClient, double yClient) {
		this.passager = passager;
		this.conducteur = conducteur;
		this.date = date;
		this.xClient = xClient;
		this.setyClient(yClient);
	}

	/* Ici, constructeur vide afin de pouvoir créer une requete sans parametre*/

	Requete() {
		this.passager = null;
		this.conducteur = null;
		this.date = null;
	}
	// Une fonction afin de changer les parametres, visant a pouvoir creer une requete vide et la modifier dans les classes ou dans les pages. ex: page passager

	public void setParametre(Passager passager, Conducteur conducteur, Date date, double xClient, double yClient) {
		this.passager = passager;
		this.conducteur = conducteur;
		this.date = date;
		this.xClient = xClient;
		this.setyClient(yClient);
	}

		//Ensemble de Getters
	public Passager getPassager() {
		return passager;
	}

	public Conducteur getConducteur() {
		return conducteur;
	}

	public double getxClient() {
		return xClient;
	}

	public double getyClient() {
		return yClient;
	}

	public void setyClient(double yClient) {
		this.yClient = yClient;
	}

	public Date getDate() {
		return date;
	}

	//ToString classique
	@Override
	public String toString() {
		return
			" Nom = " + getPassager().getNom() + "" +
			"\nPrenom = "+getPassager().getPrenom()+
			"\nConducteur=" + getConducteur().getNom() + " "
			+ getConducteur().getPrenom() + "" +
			"\nDate=" + getDate() + "";
	}
}