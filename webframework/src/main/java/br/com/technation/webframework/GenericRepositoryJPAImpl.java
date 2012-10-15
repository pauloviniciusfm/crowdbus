package br.com.technation.webframework;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.google.inject.Inject;

public class GenericRepositoryJPAImpl<Entity extends IEntity<?>> implements GenericRepository<Entity> {
	@Inject
	private ISessionFactory sessionFactory;
	private Class<Entity> entityClass;

	public GenericRepositoryJPAImpl() {
		init();
	}

	@SuppressWarnings("unchecked")
	private void init() {
		entityClass = (Class<Entity>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public List<Entity> findByQuery(String sql, Object... parameters) {
		return QueryUtils.performQuery(sessionFactory.getEntityManager(), entityClass, sql, parameters);
	}

	public Entity locateByQuery(String sql, Object... parameters) {
		return QueryUtils.performSingleResultQuery(sessionFactory.getEntityManager(), entityClass, sql, parameters);
	}

	public void persistNewEntity(Entity entity) {
		sessionFactory.getEntityManager().persist(entity);
	}

	public void destroy(Entity entity) {
		sessionFactory.getEntityManager().remove(entity);
	}

	public void refresh(Entity entity) {
		sessionFactory.getEntityManager().refresh(entity);
	}
}
