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
}