package fr.iutlannion.core;

import java.util.HashMap;

import fr.iutlannion.admin.PageAdmin;
import fr.iutlannion.auth.PageConducteur;
import fr.iutlannion.auth.PageConnexion;
import fr.iutlannion.auth.PageEditionProfil;
import fr.iutlannion.auth.PageEditionVoiture;
import fr.iutlannion.auth.PageEnregistrementVoiture;
import fr.iutlannion.auth.PageHoraires;
import fr.iutlannion.auth.PageInscription;
import fr.iutlannion.auth.PagePaiement;
import fr.iutlannion.auth.PagePassager;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Window extends Stage {

	private static Window instance;
	private static HashMap<String, Scene> scenes;

	private static PageDebug debug = new PageDebug();
	private static PageMenuPrincipal menuPrincipal = new PageMenuPrincipal();
	private static PageEditionProfil pageEditionProfil = new PageEditionProfil();
	private static PageEnregistrementVoiture enregistrementVoiture = new PageEnregistrementVoiture();
	private static PageConnexion connexion = new PageConnexion();
	private static PageInscription inscription = new PageInscription();
	private static PageAdmin admin = new PageAdmin();
	private static PageHoraires horaires = new PageHoraires();
	private static PagePaiement paiement = new PagePaiement();
	private static PageConducteur conducteur = new PageConducteur();
	private static PagePassager passager = new PagePassager();
	private static PageEditionVoiture editionVoiture = new PageEditionVoiture();

	static {
		scenes = new HashMap<String, Scene>();
		scenes.put("mainMenu", new Scene(menuPrincipal.creerContenu()));
		scenes.put("debug", new Scene(debug.creerContenu()));
		scenes.put("connexion", new Scene(connexion.creerContenu(), 640, 480));
		scenes.put("inscription", new Scene(inscription.creerContenu()));
		scenes.put("enregistrementVoiture", new Scene(enregistrementVoiture.creerContenu()));
		scenes.put("editionProfil", new Scene(pageEditionProfil.creerContenu(), 1200, 800));
		scenes.put("admin", new Scene(admin.creerContenu(), 1200, 800));
		scenes.put("horaires", new Scene(horaires.creerContenu(), 640, 480));
		scenes.put("paiement", new Scene(paiement.creerContenu()));
		scenes.put("conducteur", new Scene(conducteur.creerContenu(), 1200, 800));
		scenes.put("passager", new Scene(passager.creerContenu(), 1200, 800));
		scenes.put("editionVoiture", new Scene(editionVoiture.creerContenu(), 1200, 800));
	}

	public Window() {
		instance = this;

		this.setTitle("UTaxi");
		this.setMinHeight(480);
		this.setMinWidth(640);

		this.gotoPage("mainMenu");
	}

	public static Window getInstance() {
		if (instance == null) {
			return new Window();
		}
		return instance;
	}

	public void gotoPage(String s) {
		this.setScene(scenes.get(s));
	}

}