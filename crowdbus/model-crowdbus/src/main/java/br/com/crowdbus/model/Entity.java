package br.com.crowdbus.model;

public interface Entity<T> {
	public T getId();
	public void setId(T id);
}
