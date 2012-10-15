package br.com.technation.webframework;

import javax.inject.Inject;

public class GenericBO<Entity extends IEntity<?>, Dao extends GenericRepository<Entity>> {
	@Inject
	protected Dao dao;

	public GenericBO() {
		super();
	}

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}
}
