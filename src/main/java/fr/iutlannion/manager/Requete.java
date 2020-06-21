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

		//@Return passager renvoie le passager qui demande le taxi
	public Passager getPassager() {
		return passager;
	}
	//@Return conducteur renvoie le conducteur du taxi
	public Conducteur getConducteur() {
		return conducteur;
	}
//@Return xClient renvoie les coordonnées x (latitude) du client
	public double getxClient() {
		return xClient;
	}
//@Return yClient renvoie les coordonnées y (longitude) du client
	public double getyClient() {
		return yClient;
	}

	public void setyClient(double yClient) {
		this.yClient = yClient;
	}
//@return date retourne la date de la requete
	public Date getDate() {
		return date;
	}

	//ToString classique @return la chaine contenant les informations necessaire au taxi
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