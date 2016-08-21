package wb.store.service.dao;

import wb.store.domain.Product;
import wb.store.service.GenericDao;
/**
 * DAO of Product
 * @author William Bowen
 *
 */
public interface ProductDao extends GenericDao<Product, Long> {
	//no additional business operations at the moment
}
