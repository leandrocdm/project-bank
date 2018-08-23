package br.com.bank.console;

import br.com.bank.exceptions.IsAtivoExeption;
import br.com.bank.exceptions.OpcaoInvalidaException;
import br.com.bank.exceptions.TipoPessoaException;


public class TerminalCliente {

	public static void main(String[] args) throws TipoPessoaException, IsAtivoExeption, OpcaoInvalidaException {

		AccessControl access = new AccessControl();
		int pass = access.telaPassword();
		access.validarAcesso(pass);
		
	}
}