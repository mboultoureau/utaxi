package fr.iutlannion.manager;

import java.util.ArrayList;
import fr.iutlannion.auth.Conducteur;

public class Conducteurs {
	private ArrayList<Conducteur> conducteurs;
	private static Conducteurs instance;

	public Conducteurs() {
		this.conducteurs = new ArrayList<Conducteur>();
		instance = this;
	}

	public ArrayList<Conducteur> getListConducteur() {
		return this.conducteurs;
	}

	public static Conducteurs getInstance() {
		if (instance == null) {
			return new Conducteurs();
		}
		return instance;
	}

	public void add(Conducteur c) {
		if (!this.conducteurs.contains(c)) {
			this.conducteurs.add(c);
		} else {
			System.out.println("Ce conducteur est déjà présent.");
		}
	}

	public void remove(Conducteur c) {
		if (this.conducteurs.contains(c)) {
			this.conducteurs.remove(c);
		} else {
			System.out.println("Ce conducteur n'est pas présent.");
		}
	}

	public Conducteur verifConnexion(String mail, String mdp) {
		Conducteur res = null;

		for (int i = 0; i < conducteurs.size(); i++) {
			if (conducteurs.get(i).getEmail().equals(mail) && conducteurs.get(i).getMotDePasse().equals(mdp)) {
				res = conducteurs.get(i);
			}
		}
		return res;
	}
}
