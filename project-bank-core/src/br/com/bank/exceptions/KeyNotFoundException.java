package br.com.bank.exceptions;

public class KeyNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public KeyNotFoundException(){
		super("Codigo não encontrado");
	}

}
