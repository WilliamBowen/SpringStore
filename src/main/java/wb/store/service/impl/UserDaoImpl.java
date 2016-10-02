package wb.store.service.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import wb.store.domain.User;
import wb.store.service.dao.UserDao;

@Repository("userDao")
public class UserDaoImpl extends HibernateDao<User, Long> implements UserDao {

	public UserDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}
	//no additional business operations at the moment
}
