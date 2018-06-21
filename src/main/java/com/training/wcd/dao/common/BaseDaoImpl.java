package com.training.wcd.dao.common;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.training.wcd.common.PersistenceManager;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

		private final String findAllNamedQuery = "SELECT obj FROM %s obj";
	
		protected Class<T> beanClass;
		
		// Tell JPA to inject a new entityManager
		@PersistenceContext(unitName = "wcd")
		protected EntityManager emByAnnotation;

		// OR create an entityManager from entityManagerFactory
		protected EntityManager em = PersistenceManager.retrieveEntityManagerFactory().createEntityManager();

		public T find(Integer id) {
			T object = null;
			try {
				object = em.find(this.beanClass, id);
			} finally {
				em.close();
			}
			return object;
		}

		@SuppressWarnings("unchecked")
		public List<T> findAll() {
			String targetFindAllNamedQuery = String.format(findAllNamedQuery, beanClass.getSimpleName());
			List<T> listResult;
			try {
				listResult = (List<T>) em.createQuery(targetFindAllNamedQuery).getResultList();

			} finally {
				em.close();
			}
			return listResult;
		}

		public void delete(Integer id) {
			try {
				T object = em.find(this.beanClass, id);
				if (object != null) {
					em.getTransaction().begin();
					em.remove(object);
					em.getTransaction().commit();
				}
			} finally {
				em.close();
			}
		}

		public T save(T object) {
			try {
				em.getTransaction().begin();
				object = em.merge(object);
				em.getTransaction().commit();
			} finally {
				em.close();
			}
			return object;
		}

	}

