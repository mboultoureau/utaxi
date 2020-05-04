import java.util.ArrayList;

public class Conducteur extends Personne {

    private double tarif;
    private double nbKmParcourus;

    private ArrayList<float>note;
    private Voiture voiture;

    Conducteur(String nom, String prenom, String email, String id, double tarif, double nbKmParcourus, float note, String immatriculation, String marque, String typeEssence, String couleur, String type){

        super(String nom, String prenom, String email, String id);
        
        ArrayList<float> note = new ArrayList<float>();
        this.tarif = tarif;
        this.nbKmParcourus = nbKmParcourus;
        this.note = note;
        Voiture voiture = new Voiture(String immatriculation, String marque, String typeEssence, String couleur, String type);
    }

    public double salaire() {

    }

    public float noteMoyenne() {
        float noteMoy = 0;
        for (int i = 0; i < note.size(); i++) {
            noteMoy += note.get(i);
        }
        return noteMoy / note.size();
    }
}