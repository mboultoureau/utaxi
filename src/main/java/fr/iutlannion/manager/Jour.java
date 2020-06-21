package fr.iutlannion.manager;

import java.util.ArrayList;

public class Jour {
    private String nom;
    private int heureD;
    private int heureF;

    public Jour(String nomJ, int heureDJ, int heureFJ){
        nom = nomJ;
        heureD = heureDJ;
        heureF = heureFJ;
    }

    public int getHeureD(){
        return heureD;
    }

    public int getHeureF(){
        return heureF;
    }

    public String getNom(){
        return nom;
    }
}