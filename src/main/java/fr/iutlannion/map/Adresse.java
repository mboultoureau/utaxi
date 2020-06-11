package fr.iutlannion.map;

/**
 * Représente une adresse
 */
public class Adresse {
    private String rue;
    private String ville;
    private String codePostal;
    private String numero;
    private LatLng coords;

	/**
	 * Créé une adresse
	 * @param numero Numéro de la maison / appartement
	 * @param rue Nom de la rue
	 * @param ville Nom de la ville
	 * @param codePostal Code postal
	 */
    Adresse(String numero, String rue, String ville, String codePostal) {
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.numero = numero;
    }

	/**
	 * Retourne l'adresse sous forme de chaine de caractères
	 * @return l'adresse sous forme de chaine de caractères
	 */
	public String toString() {
    	return numero + " " + rue + ", " + codePostal + " " + ville;
	}

	/**
	 * Retourne le numéro de la maison / appartement
	 * @return Numéro de la maison / appartement
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Retourne le nom de la rue
	 * @return Nom de la rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * Retourne le nom de la ville
	 * @return Nom de la ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Retourne le code postal
	 * @return Code postal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * Retourne les coordonnées GPS de l'adresse
	 * @return Coordonnées GPS de l'adresse
	 */
	public LatLng getCoords() {
    	return coords;
	}

	/**
	 * Définit les coordonnées GPS de l'adresse
	 * @param coords Coordonnées GPS de l'adresse
	 */
	public void setCoords(LatLng coords) {
    	this.coords = coords;
	}
}