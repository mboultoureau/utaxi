package fr.iutlannion.manager;

import java.util.ArrayList;

public class Jour {
    private ArrayList<Boolean> heures;
    private String nom;

    public Jour(String nomJ){
        nom = nomJ;
        heures = new ArrayList<Boolean>(13);
        for(int i = 0; i<heures.size(); i++){
            heures.set(i, false);
        }
    }

    public Boolean getIndex(int i){
        return heures.get(i);
    }

    public void modifHeures(int i, Boolean b){
        heures.set(i, b);
    }

    public String getNom(){
        return nom;
    }
}