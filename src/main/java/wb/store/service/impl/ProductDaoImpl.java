package wb.store.service.impl;

import org.springframework.stereotype.Repository;

import wb.store.domain.Product;
import wb.store.service.dao.ProductDao;

@Repository("productDao")
public class ProductDaoImpl extends HibernateDao<Product, Long> implements ProductDao {
	//no additional business operations at the moment
}
