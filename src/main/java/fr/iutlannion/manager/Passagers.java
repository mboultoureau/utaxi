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
}
