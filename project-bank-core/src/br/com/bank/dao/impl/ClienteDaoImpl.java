package br.com.bank.dao.impl;

import javax.persistence.EntityManager;

import br.com.bank.dao.ClienteDAO;
import br.com.bank.entity.Cliente;

public class ClienteDaoImpl extends GenericDaoImpl<Cliente, Integer> implements ClienteDAO {

	public ClienteDaoImpl(EntityManager em) {
		super(em);
	}

}
