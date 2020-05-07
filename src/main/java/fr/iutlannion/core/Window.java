package fr.iutlannion.core;

import java.util.HashMap;

import fr.iutlannion.auth.Connexion;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Window extends Stage {

	private static Window instance;
	private static HashMap<String, Scene> scenes;

	private static MenuPrincipal menuPrincipal = new MenuPrincipal();
	private static Connexion connexion = new Connexion();

	static {
		scenes = new HashMap<String, Scene>();
		scenes.put("mainMenu", new Scene(menuPrincipal.creerContenu(), 300, 200));
		scenes.put("connexion", new Scene(connexion.creerContenu()));
	}

	public Window() {
		instance = this;

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