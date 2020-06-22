package fr.iutlannion.core;

import fr.iutlannion.admin.PageAdmin;
import fr.iutlannion.dashboard.PageConducteur;
import fr.iutlannion.auth.PageConnexion;
import fr.iutlannion.auth.PageEditionProfil;
import fr.iutlannion.auth.PageEditionVoiture;
import fr.iutlannion.auth.PageEnregistrementVoiture;
import fr.iutlannion.auth.PageHoraires;
import fr.iutlannion.auth.PageInscription;
import fr.iutlannion.auth.PagePaiement;
import fr.iutlannion.auth.PageReview;
import fr.iutlannion.dashboard.PagePassager;
import fr.iutlannion.debug.PageDebug;
import fr.iutlannion.debug.PageMapDebug;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Cette classe permet la gestion de la fenêtre et de son contenu
 */
public class Window extends Stage {

	private static Window instance;

	private String currentPage;
	private Stage currentStage;
	private Scene currentScene;

	public Window() {
		instance = this;

		this.setTitle("UTaxi");
		this.setMinHeight(480);
		this.setMinWidth(640);
		this.getIcons().add(new Image("img/taxi-icon.png"));

		this.gotoPage("menuPrincipal");
	}

	public static Window getInstance() {
		if (instance == null) {
			return new Window();
		}
		return instance;
	}

	public void gotoPage(String page) {

		String previousPage = currentPage;
		currentPage = page;

		switch (page) {
			case "menuPrincipal":
				currentStage = new PageMenuPrincipal();
				currentScene = new Scene(((PageMenuPrincipal) currentStage).creerContenu());
				break;
			case "conducteur":
				currentStage = new PageConducteur();
				currentScene = new Scene(((PageConducteur) currentStage).creerContenu());
				break;
			case "passager":
				currentStage = new PagePassager();
				currentScene = new Scene(((PagePassager) currentStage).creerContenu());
				break;

			case "connexion":
				currentStage = new PageConnexion();
				currentScene = new Scene(((PageConnexion) currentStage).creerContenu());
				break;
			case "inscription":
				currentStage = new PageInscription();
				currentScene = new Scene(((PageInscription) currentStage).creerContenu());
				break;
			case "enregistrementVoiture":
				currentStage = new PageEnregistrementVoiture();
				currentScene = new Scene(((PageEnregistrementVoiture) currentStage).creerContenu());
				break;
			case "horaires":
				currentStage = new PageHoraires();
				currentScene = new Scene(((PageHoraires) currentStage).creerContenu());
				break;
			case "paiement":
				currentStage = new PagePaiement();
				currentScene = new Scene(((PagePaiement) currentStage).creerContenu());
				break;
			case "review":
				currentStage = new PageReview();
				currentScene = new Scene(((PageReview) currentStage).creerContenu());
				break;

			case "admin":
				currentStage = new PageAdmin();
				currentScene = new Scene(((PageAdmin) currentStage).creerContenu());
				break;

			case "editionProfil":
				currentStage = new PageEditionProfil();
				currentScene = new Scene(((PageEditionProfil) currentStage).creerContenu());
				break;
			case "editionVoiture":
				currentStage = new PageEditionVoiture();
				currentScene = new Scene(((PageEditionVoiture) currentStage).creerContenu());
				break;

			case "debug":
				currentStage = new PageDebug();
				currentScene = new Scene(((PageDebug) currentStage).creerContenu());
				break;
			case "mapDebug":
				currentStage = new PageMapDebug();
				currentScene = new Scene(((PageMapDebug) currentStage).creerContenu());
				break;

			default:
				System.out.println("Page invalide");
				currentPage = previousPage;
				break;
		}

		this.setScene(currentScene);
	}

	public String getCurrentPage() {
		return currentPage;
	}

}