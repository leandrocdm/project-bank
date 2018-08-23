package br.com.bank.entity;

public class Conta {
	
	private int id;
	
	private int numero;
	
	private char digito;
	
	private double saldo;
	
	private Gerente gerente;
	
	public Conta() {}
	
	public Conta(int numero, char digito, double saldo, Gerente gerente) {
		super();
		this.numero = numero;
		this.digito = digito;
		this.saldo = saldo;
		this.gerente = gerente;
	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public char getDigito() {
		return digito;
	}

	public void setDigito(char digito) {
		this.digito = digito;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	
	
	

}
