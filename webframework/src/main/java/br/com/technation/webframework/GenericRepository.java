package br.com.technation.webframework;

import java.util.List;

public interface GenericRepository<Entity extends IEntity<?>> {
	public List<Entity> findByQuery(String sql, Object... parameters);

	public Entity locateByQuery(String sql, Object... parameters);

	public void persistNewEntity(Entity entity);

	public void destroy(Entity entity);

	public void refresh(Entity entity);
}
