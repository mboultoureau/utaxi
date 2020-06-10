package fr.iutlannion.map;

public class Adresse {
    private String rue;
    private String ville;
    private String codePostal;
    private String numero;
    private LatLng coords;

    Adresse(String numero, String rue, String ville, String codePostal) {
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.numero = numero;
    }

    public String toString() {
    	return numero + " " + rue + ", " + codePostal + " " + ville;
	}

	public String getRue() {
		return rue;
	}

	public String getVille() {
		return ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCoords(LatLng coords) {
    	this.coords = coords;
	}
}