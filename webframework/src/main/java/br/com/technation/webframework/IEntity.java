package br.com.technation.webframework;

public interface IEntity<T> {
	public T getId();
	public void setId(T pkey);
}
