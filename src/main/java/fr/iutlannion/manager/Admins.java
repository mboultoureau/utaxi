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

	public ArrayList<Admin> getListAdmin() {
		return this.admins;
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

	public Admin verifConnexion(String mail, String mdp) {
		Admin res = null;

		for (int i = 0; i < admins.size(); i++) {
			if (admins.get(i).getEmail().equals(mail) && admins.get(i).getMotDePasse().equals(mdp)) {
				res = admins.get(i);
			}
		}
		return res;
	}

	public Admin getAdmin(int index) {
		return admins.get(index);
	}

}
