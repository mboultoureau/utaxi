package fr.iutlannion;

import fr.iutlannion.map.LatLng;
import org.junit.Test;

import fr.iutlannion.manager.Passager;
import fr.iutlannion.exceptions.FormatException;
import junit.framework.TestCase;

public class PassagerTest extends TestCase {

	private Passager p;

	public PassagerTest() {
		p = new Passager("Nom", "Prenom", "email@mail.com", "password", new LatLng(47.219860, -1.545304), null);
	}

	// NOM

	@Test
	public void testNomTropCourt() {
		try {
			p.setNom("A");
			fail("Le nom est trop court et doit retourner une exception");
		} catch (FormatException e) {
			assertEquals(e.getMessage(), "Le nom doit contenir entre 3 et 30 caractères");
		}
	}

	@Test
	public void testNomTropLong() {
		try {
			p.setNom("AAAAABBBBBCCCCCDDDDDEEEEEFFFFFG");
			fail("Le nom est trop long et doit retourner une exception");
		} catch (FormatException e) {
			assertEquals(e.getMessage(), "Le nom doit contenir entre 3 et 30 caractères");
		}
	}

	@Test
	public void testCaracteresInvalides() {
		try {
			p.setNom("Nom invalide !");
			fail("Le nom contient un ou plusieurs caractères invalides et doit retourner une exception");
		} catch (FormatException e) {
			assertEquals(e.getMessage(), "Le nom doit contenir uniquement des lettres et des espaces.");
		}
	}

}
