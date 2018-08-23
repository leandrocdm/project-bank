package br.com.bank.entity;

public class Beneficios {

	private int id;

	private String descricao;

	private boolean isAtivo;

	public Beneficios() {}
	
	public Beneficios(String descricao, boolean isAtivo) {
		super();
		this.descricao = descricao;
		this.isAtivo = isAtivo;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public boolean isAtivo() {
		return isAtivo;
	}

	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

}
