package wb.store.service.impl;

import org.springframework.stereotype.Repository;

import wb.store.domain.User;
import wb.store.service.dao.UserDao;

@Repository("userDao")
public class UserDaoImpl extends HibernateDao<User, Long> implements UserDao {
	//no additional business operations at the moment
}
