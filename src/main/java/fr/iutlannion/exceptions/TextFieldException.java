package fr.iutlannion.exceptions;

/**
 * TextFieldException est une exception si un champ de texte est incorrect.
 * 
 * @author mboultoureau
 * @version 1
 *
 */
public class TextFieldException extends Exception {

	private static final long serialVersionUID = 1L;

	public TextFieldException(String message) {
		super(message);
	}
	
}
