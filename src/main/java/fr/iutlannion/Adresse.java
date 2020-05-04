package fr.iutlannion;

public class Adresse {
    private String rue;
    private String ville;
    private String etat;
    private String codePostal;
    private String pays;

    Adresse(String rue, String ville, String etat, String codePostal, String pays) {
        this.rue = rue;
        this.ville = ville;
        this.etat = etat;
        this.codePostal = codePostal;
        this.pays = pays;
    }

	public String getRue() {
		return rue;
	}

	public String getVille() {
		return ville;
	}

	public String getEtat() {
		return etat;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public String getPays() {
		return pays;
	}
}