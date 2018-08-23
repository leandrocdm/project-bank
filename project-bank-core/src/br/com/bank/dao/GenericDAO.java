package br.com.bank.dao;

import java.util.List;

import br.com.bank.exceptions.CommitException;
import br.com.bank.exceptions.KeyNotFoundException;

public interface GenericDAO<T,K> {
	
	 void inserir(T entidade);
	
	 void atualizar(T entidade);
	
	 void remover (K codigo) throws KeyNotFoundException;
	
	 T pesquisar(K codigo);
	
	 void commit() throws CommitException;
	 
	 List<T> listar(T entidade);

}
