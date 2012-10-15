package br.com.technation.webframework;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class QueryUtils {

	private static <T> TypedQuery<T> createBasicQuery(EntityManager em, Class<T> returnClass, String query, Object[] parameters) {
		return em.createQuery(query, returnClass);
	}

	public static <T> List<T> performQuery(EntityManager em, Class<T> returnClass, String query, Object... parameters) {
		TypedQuery<T> rootQuery = createBasicQuery(em, returnClass, query, parameters);
		return rootQuery.getResultList();
	}

	public static <T> T performSingleResultQuery(EntityManager em, Class<T> returnClass, String query, Object... parameters) {
		TypedQuery<T> rootQuery = em.createQuery(query, returnClass);
		return rootQuery.getSingleResult();
	}
}
