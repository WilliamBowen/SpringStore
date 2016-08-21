package wb.store.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

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
@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
public class HibernateDao<E, K extends Serializable> implements GenericDao<E, K> {
	
	private SessionFactory sessionFactory;
	protected Class<E> daoType;
	
	//determine which class we are dealing with
	public HibernateDao() {
	daoType = (Class<E>) ((ParameterizedType) getClass()
				.getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void add(E entity) {
		currentSession().save(entity);
		
	}

	@Override
	public void update(E entity) {
		currentSession().saveOrUpdate(entity);
		
	}

	@Override
	public void remove(E entity) {
		currentSession().delete(entity);
		
	}

	@Override
	public E find(K key) {
		return (E) currentSession().get(daoType,  key);
	}

	@Override
	public List<E> list() {
		EntityManager em = currentSession().getEntityManagerFactory().createEntityManager();
		CriteriaQuery<E> criteriaQuery = currentSession().getCriteriaBuilder().createQuery(daoType);
		return em.createQuery(criteriaQuery).getResultList();
	}
}