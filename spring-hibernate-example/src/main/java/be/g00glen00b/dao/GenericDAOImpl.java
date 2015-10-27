package be.g00glen00b.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private Class<T> persistentClass;

	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	protected Class<T> getPersistentClass() {
		return this.persistentClass;
	}
	
	protected HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Override
	@Transactional(readOnly = false)
	public void persist(T entity) {
		getHibernateTemplate().persist(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void remove(T entity) {
		getHibernateTemplate().delete(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public T merge(T entity) {
		return getHibernateTemplate().merge(entity);
	}

	@Override
	public T findById(ID id) {
		return getHibernateTemplate().get(getPersistentClass(), id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		 return (List<T>) getHibernateTemplate().find("from " + getPersistentClass().getName());
	}

	@Override
	@Transactional(readOnly = false)
	public T flush(T entity) {
		getHibernateTemplate().flush();
		return entity;
	}
}
