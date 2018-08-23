package br.com.bank.console;

import java.util.Scanner;

import br.com.bank.exceptions.IsAtivoExeption;
import br.com.bank.exceptions.TipoPessoaException;

public class AccessControl {

	Scanner input = new Scanner(System.in);
	int tentativas = 0;

	public int telaPassword() {
		System.out.println("*****************************");
		System.out.println("Digite a senha de acesso");
		System.out.println("*****************************");
		return input.nextInt();
	}

	public void validarAcesso(int pass) throws TipoPessoaException, IsAtivoExeption {		
		MenuConsole console = new MenuConsole();
		
		if(pass == 123) {
			console.menu(console.opcoesMenu());
		}else {	
			tentativas++;
			if(tentativas <= 3) {
				validarAcesso(telaPassword());
			}else {
				System.out.println("Access Denied!");
				System.exit(0);
			}
		}
	}
}
