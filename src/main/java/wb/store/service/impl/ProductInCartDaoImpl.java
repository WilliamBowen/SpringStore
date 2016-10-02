package wb.store.service.impl;

import org.hibernate.SessionFactory;

import wb.store.domain.ProductInCart;
import wb.store.service.dao.ProductInCartDao;

public class ProductInCartDaoImpl extends HibernateDao<ProductInCart, Long> implements ProductInCartDao {

	public ProductInCartDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}
	//no additional business operations at the moment
}

