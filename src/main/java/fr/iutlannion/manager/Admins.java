package fr.iutlannion.manager;

import java.util.ArrayList;
import fr.iutlannion.auth.Admin;

public class Admins {
	private ArrayList<Admin> admins;
	private static Admins instance;
	
	public Admins() {
		this.admins = new ArrayList<Admin>();
		instance = this;
	}
	
	public static Admins getInstance() {
		if (instance == null) {
			return new Admins();
		}
		return instance;
	}
	
	public void add(Admin a) {
		if (!this.admins.contains(a)) {
			this.admins.add(a);
		} else {
			System.out.println("Cette administrateur est déjà présent.");
		}
	}
	
	public void remove(Admin a) {
		if (this.admins.contains(a)) {
			this.admins.remove(a);
		} else {
			System.out.println("Cette administrateur n'est pas présent.");
		}
	}

}
