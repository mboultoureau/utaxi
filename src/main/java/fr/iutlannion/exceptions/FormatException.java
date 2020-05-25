package fr.iutlannion.exceptions;

/**
 * TextFieldException est une exception si un champ de texte est incorrect.
 * 
 * @author mboultoureau
 * @version 1
 *
 */
public class FormatException extends Exception {

	private static final long serialVersionUID = 1L;

	public FormatException(String message) {
		super(message);
	}
	
}
