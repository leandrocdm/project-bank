package br.com.bank.exceptions;

@SuppressWarnings(value="serial")
public class TipoPessoaException extends Exception {

	public TipoPessoaException() {
		super("Opção invalida! [1] Pessoa Fisica ou [2] Pessoa Juridica!");
	}
}
