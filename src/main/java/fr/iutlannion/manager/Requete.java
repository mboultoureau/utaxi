package fr.iutlannion.manager;

import java.util.Date;

public class Requete {
	private Passager passager;
	private Conducteur conducteur;
	private Date date;
	private double xClient;
	private double yClient;

	Requete(Passager passager, Conducteur conducteur, Date date, double xClient, double yClient) {
		this.passager = passager;
		this.conducteur = conducteur;
		this.date = date;
		this.xClient = xClient;
		this.setyClient(yClient);
	}

	Requete() {
		this.passager = null;
		this.conducteur = null;
		this.date = null;
	}

	public void setParametre(Passager passager, Conducteur conducteur, Date date, double xClient, double yClient) {
		this.passager = passager;
		this.conducteur = conducteur;
		this.date = date;
		this.xClient = xClient;
		this.setyClient(yClient);
	}

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