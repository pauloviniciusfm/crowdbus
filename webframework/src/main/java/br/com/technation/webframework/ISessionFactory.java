package br.com.technation.webframework;

import javax.persistence.EntityManager;

public interface ISessionFactory {
	public EntityManager getEntityManager();
}
