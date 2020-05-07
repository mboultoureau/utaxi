package fr.iutlannion.manager;

import java.util.ArrayList;
import fr.iutlannion.auth.Passager;

public class Passagers {
	private ArrayList<Passager> passagers;
	private static Passagers instance;

	public Passagers() {
		this.passagers = new ArrayList<Passager>();
		instance = this;
	}

	public ArrayList<Passager> getListPassager() {
		return this.passagers;
	}

	public static Passagers getInstance() {
		if (instance == null) {
			return new Passagers();
		}
		return instance;
	}

	public void add(Passager p) {
		if (!this.passagers.contains(p)) {
			this.passagers.add(p);
		} else {
			System.out.println("Ce passager est déjà présent.");
		}
	}

	public void remove(Passager p) {
		if (this.passagers.contains(p)) {
			this.passagers.remove(p);
		} else {
			System.out.println("Ce passager n'est pas présent.");
		}
	}

	public Passager verifConnexion(String mail, String mdp) {
		Passager res = null;

		for (int i = 0; i < passagers.size(); i++) {
			if (passagers.get(i).getEmail().equals(mail) && passagers.get(i).getMotDePasse().equals(mdp)) {
				res = passagers.get(i);
			}
		}
		return res;
	}
}
