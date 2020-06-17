package fr.iutlannion.manager;

import java.util.ArrayList;

public final class Utilisateurs {
    private static ArrayList<Personne> personnes = new ArrayList<Personne>();
    private static Personne currentUser = null;

    // Utilisateur courant

    /**
     * Définit l'utilisateur connecté
     * @param personne La personne connecté
     */
    public static void setPersonneCourante(Personne personne) {
        currentUser = personne;
    }

    /**
     * Retourne l'utilisateur connecté
     * @return l'utilisateur connecté ou null
     */
    public static Personne getPersonneCourante() {
        return currentUser;
    }

    /**
     * Déconnecte l'utilisateur connecté
     */
    public static void resetPersonneCourante() {
        currentUser = null;
    }

    // Personnes

    /**
     * Retourne la liste des utilisateurs
     * @return Un ArrayList des utilisateurs
     */
    public static ArrayList<Personne> getListUtilisateurs() {
        return personnes;
    }

    /**
     * Ajoute une personne
     * @param personne La personne à ajouter
     */
    public static void add(Personne personne) {
        if (personnes.contains(personne)) {
            System.out.println("Cette personne est déjà présent.");
        } else if (Utilisateurs.emailUtilise(personne.getEmail())) {
            System.out.println("Cette adresse email est déjà utilisé.");
        } else {
            personnes.add(personne);
        }
    }

    /**
     * Supprime une personne
     * @param personne La personne à supprimer
     */
    public static void remove(Personne personne) {
        if (!personnes.contains(personne)) {
            System.out.println("Cette personne n'est pas présente.");
        } else {
            personnes.remove(personne);
        }
    }

    /**
     * Permet de se connecter
     * @param email L'adresse email de l'utilisateur
     * @param mdp Le mot de passe de l'utilisateur
     * @return La personne ou null si il est introuvable avec l'email et le mot de passe fournit
     */
    public static Personne connexion(String email, String mdp) {
        Personne p = null;
        int i = 0;

        while (p == null && i < personnes.size()) {
            if (personnes.get(i).getEmail().equals(email) && personnes.get(i).getMotDePasse().equals(mdp)) {
                p = personnes.get(i);
            } else {
                i++;
            }
        }

        return p;
    }


    // Admins

    /**
     * Retourne la liste des administrateurs
     * @return Un ArrayList des administrateurs
     */
    public static ArrayList<Admin> getListAdmin() {
        ArrayList<Admin> admins = new ArrayList<Admin>();

        for (Personne p : personnes) {
            if (p instanceof Admin) {
                admins.add((Admin) p);
            }
        }

        return admins;
    }

    // Conducteurs

    /**
     * Retourne la liste des conducteurs
     * @return Un ArrayList des conducteurs
     */
    public static ArrayList<Conducteur> getListConducteur() {
        ArrayList<Conducteur> conducteurs = new ArrayList<Conducteur>();

        for (Personne p : personnes) {
            if (p instanceof Conducteur) {
                conducteurs.add((Conducteur) p);
            }
        }

        return conducteurs;
    }

    // Passagers
    /**
     * Retourne la liste des passagers
     * @return Un ArrayList des passagers
     */
    public static ArrayList<Passager> getListPassagers() {
        ArrayList<Passager> passagers = new ArrayList<Passager>();

        for (Personne p : personnes) {
            if (p instanceof Passager) {
                passagers.add((Passager) p);
            }
        }

        return passagers;
    }

    /**
     * Vérifie si l'adresse email est déjà utilisé
     * @return retourne vrai si l'adresse email est déjà utilisé
     */
    public static boolean emailUtilise(String email) {
        boolean utilise = false;
        int index = 0;

        while (!utilise && index < personnes.size()) {
            if (personnes.get(index).getEmail().equals(email)) {
                utilise = true;
            } else {
                index++;
            }
        }

        return utilise;
    }
}
