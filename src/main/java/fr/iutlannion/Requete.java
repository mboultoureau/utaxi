package fr.iutlannion;

public class Requete {
    private Passager passager;
    private Conducteur conducteur;
    private String date;
    private double xClient;
    private double yClient;

    Requete(Passager passager, Conducteur conducteur, String date, double xClient, double yClient) {
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

	public String getDate() {
		return date;
	}
}