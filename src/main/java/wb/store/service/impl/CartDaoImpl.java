package wb.store.service.impl;

import org.springframework.stereotype.Repository;

import wb.store.domain.Cart;
import wb.store.service.dao.CartDao;

@Repository("cartDao")
public class CartDaoImpl extends HibernateDao<Cart, Long> implements CartDao {
	//no additional business operations at the moment
}
