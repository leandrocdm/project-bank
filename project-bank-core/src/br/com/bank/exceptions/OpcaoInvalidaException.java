package br.com.bank.exceptions;

@SuppressWarnings("serial")
public class OpcaoInvalidaException extends Exception{

	public OpcaoInvalidaException() {
		super("Opcao invalida!");
	}
}
