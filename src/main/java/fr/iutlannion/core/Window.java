package fr.iutlannion.core;

import java.util.HashMap;

import fr.iutlannion.auth.PageConnexion;
import fr.iutlannion.auth.PageEditionProfil;
import fr.iutlannion.auth.PageEnregistrementVoiture;
import fr.iutlannion.auth.PageInscription;
import fr.iutlannion.admin.PageAdmin;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Window extends Stage {

	private static Window instance;
	private static HashMap<String, Scene> scenes;

	private static MenuPrincipal menuPrincipal = new MenuPrincipal();
	private static PageEditionProfil pageEditionProfil = new PageEditionProfil();
	private static PageEnregistrementVoiture pageEnregistrementVoiture = new PageEnregistrementVoiture();
	private static PageConnexion connexion = new PageConnexion();
	private static PageInscription inscription = new PageInscription();
	private static PageAdmin admin = new PageAdmin();

	static {
		scenes = new HashMap<String, Scene>();
		scenes.put("mainMenu", new Scene(menuPrincipal.creerContenu(), 300, 200));
		scenes.put("connexion", new Scene(connexion.creerContenu(), 640, 480));
		scenes.put("inscription", new Scene(inscription.creerContenu()));
		scenes.put("enregistrementVoiture", new Scene(pageEnregistrementVoiture.creerContenu()));
		scenes.put("editionProfil", new Scene(pageEditionProfil.creerContenu(), 1200, 800));
		scenes.put("admin", new Scene(admin.creerContenu(), 1200, 800));
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