package fr.iutlannion.manager;

import java.util.ArrayList;

public class Voitures {
	private ArrayList<Voiture> voitures;
	private static Voitures instance;

	public Voitures() {
		this.voitures = new ArrayList<Voiture>();
		instance = this;
	}

	public static Voitures getInstance() {
		if (instance == null) {
			return new Voitures();
		}
		return instance;
	}

	public void add(Voiture v) {
		if (!this.voitures.contains(v)) {
			this.voitures.add(v);
		} else {
			System.out.println("Cette voiture est déjà présente.");
		}
	}

	public void remove(Voiture v) {
		if (this.voitures.contains(v)) {
			this.voitures.remove(v);
		} else {
			System.out.println("Cette voiture n'est pas présente.");
		}
	}
}
