package be.g00glen00b.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface GenericDAO<T, ID extends Serializable> {

	@Transactional(readOnly = false)
	public abstract void persist(T entity);

	@Transactional(readOnly = false)
	public abstract void remove(T entity);

	@Transactional(readOnly = false)
	public abstract T merge(T entity);

	public abstract T findById(ID id);

	public abstract List<T> findAll();

	@Transactional(readOnly = false)
	public abstract T flush(T entity);

}