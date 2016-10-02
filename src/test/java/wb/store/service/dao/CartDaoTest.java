package wb.store.service.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import wb.store.DomainAwareBase;
import wb.store.domain.Product;

public class CartDaoTest extends DomainAwareBase{
	@Autowired
	private CartDao cartDao;
	
	@Test
	@Rollback(true)
	public void testAdd() {
		
	}
	
	@Test
	@Rollback(true)
	public void testUpdate() {
		
	}
	
	@Test
	@Rollback(true)
	public void testFind() {
		
	}
	
	@Test
	@Rollback(true)
	public void testList() {
		
		
	}
	
	@Test
	@Rollback(true)
	public void testRemove() {
		
	}
	
	@Test
	@Rollback(true)
	public void testAddToCart() {
		
	}
	
	@Test
	@Rollback(true)
	public void testUpdateCart() {
		
	}
	
	@Test
	@Rollback(true)
	public void testRemoveFromCart() {
		
	}
}
