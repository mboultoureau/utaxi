package fr.iutlannion.manager;

public class CarteBancaire {

    private String numero;
    private String expiration;
    private String cvc;
    private String nom;

    public CarteBancaire(String numero, String expiration, String cvc, String nom) {
        this.numero = numero;
        this.expiration = expiration;
        this.cvc = cvc;
        this.nom = nom;
    }

    public String getNumero() {
        return numero;
    }

    public String getExpiration() {
        return expiration;
    }

    public String getCvc() {
        return cvc;
    }

    public String getNom() {
        return nom;
    }

}
