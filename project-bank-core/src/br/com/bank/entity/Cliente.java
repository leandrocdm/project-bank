package br.com.bank.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_BANCO_CLIENTE")
@SequenceGenerator(name="cliente", sequenceName="SQ_T_BANCO_CLIENTE", allocationSize=1)
public class Cliente {

	@Id
	@Column
	@GeneratedValue(generator="cliente", strategy=GenerationType.SEQUENCE)
	private int codigo;

	@Column
	private String nome;

	@Column
	private String cpfoucnpj;

	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;

	@Column
	private boolean isAtivo;
	
	@Column(name="datacadastro")
	private Calendar dtCadastro;

	public Cliente() {}

	public Cliente(String nome, TipoPessoa tipoPessoa, boolean isAtivo, Calendar dtCadastro) {
		super();
		this.nome = nome;
		this.tipoPessoa = tipoPessoa;
		this.isAtivo = isAtivo;
		this.dtCadastro = dtCadastro;
	}

	public int getId() {
		return codigo;
	}

	public void setId(int id) {
		this.codigo = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpfoucnpj() {
		return cpfoucnpj;
	}

	public void setCpfoucnpj(String cpfoucnpj) {
		this.cpfoucnpj = cpfoucnpj;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public boolean getIsAtivo() {
		return isAtivo;
	}


	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public Calendar getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public String validarCpfOuCnpj(TipoPessoa tipoPessoa) {
		String retorno;
		if(tipoPessoa.equals(TipoPessoa.PESSOA_FISICA)) {
			retorno =  "CPF:";			
		}else {
			retorno = "CNPJ:";
		}
		return retorno;		
	}

}
