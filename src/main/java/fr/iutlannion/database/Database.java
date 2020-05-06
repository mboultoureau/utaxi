package fr.iutlannion.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import fr.iutlannion.auth.Conducteur;
import fr.iutlannion.auth.Passager;
import fr.iutlannion.auth.Admin;
import fr.iutlannion.Voiture;


public class Database implements Serializable {
	
	private ArrayList<Conducteur> conducteurs;
	private ArrayList<Passager> passagers;
	private ArrayList<Admin> admins;
	private ArrayList<Voiture> voitures;
	
	private String dbName = "db.data";
	
	public Database() {
		this.conducteurs = new ArrayList<Conducteur>();
		this.passagers = new ArrayList<Passager>();
		this.admins = new ArrayList<Admin>();
		this.voitures = new ArrayList<Voiture>();
	}
	
	public void save(Database db) {
		try {
			FileOutputStream f = new FileOutputStream(new File(this.dbName));
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			o.writeObject(db);
			
			o.close();
			f.close();
			
		} catch(FileNotFoundException e) {
			System.out.println("Fichier de base de données introuvable");
		} catch (IOException e) {
			System.out.println("Impossible d'initialiser le stream de la base données");
		}
	}
	
	public Database read() {
		
		Database db = new Database();
		
		try {
			FileInputStream f = new FileInputStream(new File(this.dbName));
			ObjectInputStream o = new ObjectInputStream(f);
			
			db = (Database) o.readObject();
			
			o.close();
			f.close();
			
		} catch(FileNotFoundException e) {
			System.out.println("Fichier de base de données introuvable");
		} catch (IOException e) {
			System.out.println("Impossible d'initialiser le stream de la base données");
		} catch(ClassNotFoundException e) {
			System.out.println("Classe introuvable");
		}
		
		return db;
	}
	
	public void addAdmin(Admin admin) {
		if (!this.admins.contains(admin)) {
			this.admins.add(admin);
		}
	}
	
}
