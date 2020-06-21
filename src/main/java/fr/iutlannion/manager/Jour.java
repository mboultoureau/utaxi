package fr.iutlannion.manager;

import java.util.ArrayList;


//classe représentant les horaires d'une journée
public class Jour {
    private String nom;
    private int heureD;
    private int heureF;

    //initialisation de la journée
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