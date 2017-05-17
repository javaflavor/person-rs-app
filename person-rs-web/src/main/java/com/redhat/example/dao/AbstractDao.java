package com.redhat.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractDao<T,K> {
	protected Class<T> entityClass;

	public AbstractDao(T... dummy) {
		@SuppressWarnings("unchecked")
		Class<T> type = (Class<T>)dummy.getClass().getComponentType();
		entityClass = type;
	}

	public abstract EntityManager getEntityManager();

	public void create(T entity) {
		getEntityManager().persist(entity);
	}
	
	public List<T> findAll() {
		CriteriaQuery<T> query = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
		query.select(query.from(entityClass));
		return getEntityManager().createQuery(query).getResultList();
	}

	public T find(K id) {
		return getEntityManager().find(entityClass, id);
	}

	public void update(T entity) {
		getEntityManager().merge(entity);
	}

	public void remove(K id) {
		T ref = getEntityManager().getReference(entityClass, id);
		getEntityManager().remove(ref);
	}

}
