package fr.iutlannion.core;

import java.util.HashMap;

import fr.iutlannion.admin.PageAdmin;
import fr.iutlannion.dashboard.PageConducteur;
import fr.iutlannion.auth.PageConnexion;
import fr.iutlannion.auth.PageEditionProfil;
import fr.iutlannion.auth.PageEditionVoiture;
import fr.iutlannion.auth.PageEnregistrementVoiture;
import fr.iutlannion.auth.PageHoraires;
import fr.iutlannion.auth.PageInscription;
import fr.iutlannion.auth.PagePaiement;
import fr.iutlannion.dashboard.PagePassager;
import fr.iutlannion.debug.PageDebug;
import fr.iutlannion.debug.PageMapDebug;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Window extends Stage {

	private static Window instance;
	private static HashMap<String, Scene> scenes;

	// Pages principales
	private static PageMenuPrincipal menuPrincipal = new PageMenuPrincipal();
	private static PageConducteur conducteur = new PageConducteur();
	private static PagePassager passager = new PagePassager();

	// Pages d'authentification
	private static PageConnexion connexion = new PageConnexion();
	private static PageEnregistrementVoiture enregistrementVoiture = new PageEnregistrementVoiture();
	private static PageInscription inscription = new PageInscription();
	private static PageHoraires horaires = new PageHoraires();
	private static PagePaiement paiement = new PagePaiement();

	// Pages d'administration
	private static PageAdmin admin = new PageAdmin();

	// Pages d'édition
	private static PageEditionProfil editionProfil = new PageEditionProfil();
	private static PageEditionVoiture editionVoiture = new PageEditionVoiture();

	// Debug page
	private static PageDebug debug = new PageDebug();
	private static PageMapDebug mapDebug = new PageMapDebug();

	static {
		scenes = new HashMap<String, Scene>();
		scenes.put("mainMenu", new Scene(menuPrincipal.creerContenu()));
		scenes.put("conducteur", new Scene(conducteur.creerContenu()));
		scenes.put("passager", new Scene(passager.creerContenu()));

		scenes.put("connexion", new Scene(connexion.creerContenu()));
		scenes.put("inscription", new Scene(inscription.creerContenu()));
		scenes.put("enregistrementVoiture", new Scene(enregistrementVoiture.creerContenu()));
		scenes.put("horaires", new Scene(horaires.creerContenu(), 640, 480));
		scenes.put("paiement", new Scene(paiement.creerContenu()));

		scenes.put("admin", new Scene(admin.creerContenu(), 1200, 800));

		scenes.put("editionProfil", new Scene(editionProfil.creerContenu(), 1200, 800));
		scenes.put("editionVoiture", new Scene(editionVoiture.creerContenu(), 1200, 800));

		scenes.put("debug", new Scene(debug.creerContenu()));
		scenes.put("mapDebug", new Scene(mapDebug.creerContenu()));
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

	public void gotoPage(String page) {
		this.setScene(scenes.get(page));
	}

}