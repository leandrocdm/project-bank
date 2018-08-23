package br.com.bank.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import br.com.bank.dao.GenericDAO;
import br.com.bank.exceptions.CommitException;
import br.com.bank.exceptions.KeyNotFoundException;


public class GenericDaoImpl <T,K> implements GenericDAO<T, K> {


	private EntityManager em;

	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public GenericDaoImpl(EntityManager em) {
		this.em = em;
		clazz = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void inserir(T entidade) {
		em.persist(entidade);
	}

	@Override
	public void atualizar(T entidade) {
		em.merge(entidade);
	}

	@Override
	public void remover(K codigo) throws KeyNotFoundException {
		T entidade = pesquisar(codigo);
		if (entidade == null) {
			throw new KeyNotFoundException();
		}
		em.remove(entidade);
	}

	@Override
	public T pesquisar(K codigo) {
		return em.find(clazz, codigo);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException();
		}
	}

	@Override
	public List<T> listar(T entidade) {
		TypedQuery<T> query = em.createQuery("from " 
				+ clazz.getName(),clazz);
		return query.getResultList();
	}

}
