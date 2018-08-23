package br.com.bank.entity;

public class Gerente {
	
	private int id;
	
	private String nome;
	
	private boolean isAtivo;
	
	public Gerente() {}
	
	public Gerente(String nome, boolean isAtivo) {
		super();
		this.nome = nome;
		this.isAtivo = isAtivo;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAtivo() {
		return isAtivo;
	}

	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

}
