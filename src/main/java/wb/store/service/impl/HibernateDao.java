package wb.store.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import wb.store.service.GenericDao;
/**
 * Basic DAO operations dependent with Hibernate's specific classes
 * @author William Bowen
 *
 * @param <E> Entity from wb.store.domain
 * @param <K> Key used to identify the entity, such as ID number
 */

public class HibernateDao<E, K extends Serializable> implements GenericDao<E, K> {
	
	private SessionFactory sessionFactory;
	protected Class<E> daoType;
	
	//determine which class we are dealing with
	@Autowired
	public HibernateDao(SessionFactory sessionFactory) {
		daoType = (Class<E>) ((ParameterizedType) getClass()
				.getGenericSuperclass())
				.getActualTypeArguments()[0];
		this.sessionFactory = sessionFactory;
	}

	
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void add(E entity) {
		currentSession().save(entity);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(E entity) {
		currentSession().saveOrUpdate(entity);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void remove(E entity) {
		currentSession().delete(entity);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public E find(K key) {
		return (E) currentSession().get(daoType,  key);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public List<E> list() {
		return currentSession().createCriteria(daoType).list();
	}
}