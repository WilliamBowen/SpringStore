package wb.store.service.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import wb.store.DomainAwareBase;
import wb.store.domain.Product;

public class ProductDaoTest extends DomainAwareBase {

	@Autowired
	private ProductDao productDao;
	
	@Test
	public void testAdd() {
		int size = productDao.list().size();
		productDao.add(new Product("shirt", "description for shirt", 10.40));
		
		assertTrue(size + 1 == productDao.list().size());
	}
}
