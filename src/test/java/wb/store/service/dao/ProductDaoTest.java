package wb.store.service.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import wb.store.DomainAwareBase;
import wb.store.domain.Product;

public class ProductDaoTest extends DomainAwareBase {

	@Autowired
	private ProductDao productDao;
	
	@Test
	@Rollback(true)
	public void testAdd() {
		int size = productDao.list().size();
		productDao.add(new Product("shirt", "description for shirt", 10.40));
		
		assertTrue(size + 1 == productDao.list().size());
	}
	
	@Test
	@Rollback(true)
	public void testUpdate() {
		Product product = new Product("shirt", "description for shirt", 10.40);
		productDao.add(product);
		product.setName("dress shirt");
		
		productDao.update(product);
		Product found = productDao.find(product.getId());
		assertEquals("dress shirt", found.getName());
	}
	
	@Test
	@Rollback(true)
	public void testFind() {
		Product product = new Product("shirt", "description for shirt", 10.40);
		productDao.add(product);
		
		Product found = productDao.find(product.getId());
		assertEquals(found, product);
	}
	
	@Test
	@Rollback(true)
	public void testList() {
		assertEquals(0, productDao.list().size());
		
		List<Product> products = Arrays.asList(
				new Product("shirt", "description for shirt", 10.40),
				new Product("pants", "description for pants", 15.55),
				new Product("shoes", "description for shoes", 49.99));
		for(Product product : products) {
			productDao.add(product);
		}
		
		List<Product> found = productDao.list();
		assertEquals(3, found.size());
		for(Product product : found) {
			assertTrue(products.contains(product));
		}
	}
	
	@Test
	@Rollback(true)
	public void testRemove() {
		Product product = new Product("shirt", "description for shirt", 10.40);
		productDao.add(product);
		
		// successfully added
		assertEquals(product, productDao.find(product.getId()));
		
		//try to remove
		productDao.remove(product);
		assertNull(productDao.find(product.getId()));
	}
}
