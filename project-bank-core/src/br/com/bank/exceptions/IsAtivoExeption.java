package br.com.bank.exceptions;

@SuppressWarnings(value="serial")
public class IsAtivoExeption extends Exception {

	public IsAtivoExeption() {
		super("Opcao invalida! [1] Ativo ou [2] Inativo");
	}
	
}
