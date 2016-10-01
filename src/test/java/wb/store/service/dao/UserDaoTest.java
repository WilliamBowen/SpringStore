package wb.store.service.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import wb.store.DomainAwareBase;
import wb.store.domain.User;

@ContextConfiguration(locations = "/persistence-beans.xml")
public class UserDaoTest extends DomainAwareBase {
	
	@Autowired
	private UserDao userDao;

	@Test
	public void testAdd() {
		int size = userDao.list().size();
		userDao.add(new User("William", "Bowen", "wbowen", "test", "wbowen@mail.com"));
		
		assertTrue(size + 1 == userDao.list().size());
	}
	
	@Test
	public void testUpdate() {
		User user = new User("William", "Bowen", "wbowen", "test", "wbowen@mail.com");
		userDao.add(user);
		user.setFirstName("Liam");
		
		userDao.update(user);
		User found = userDao.find(user.getId());
		assertEquals("Liam", found.getFirstName());
	}
	
	@Test
	public void testFind() {
		User user = new User("William", "Bowen", "wbowen", "test", "wbowen@mail.com");
		userDao.add(user);
		
		User found = userDao.find(user.getId());
		assertEquals(found, user);
	}
	
	@Test
	public void testList() {
		assertEquals(0, userDao.list().size());
		
		List<User> users = Arrays.asList(
				new User("William", "Bowen", "wbowen", "test", "wbowen@mail.com"),
				new User("Tam", "Bowen", "bowen", "test2", "tbowen@mail.com"),
				new User("Ethan", "Bowen", "ebowen", "test3", "ebowen@mail.com"));
		for(User user : users) {
			userDao.add(user);
		}
		
		List<User> found = userDao.list();
		assertEquals(3, found.size());
		for(User user : found) {
			assertTrue(users.contains(user));
		}
	}
	
	@Test
	public void testRemove() {
		User user = new User("William", "Bowen", "wbowen", "test", "wbowen@mail.com");
		userDao.add(user);
		
		// successfully added
		assertEquals(user, userDao.find(user.getId()));
		
		//try to remove
		userDao.remove(user);
		assertNull(userDao.find(user.getId()));
	}
}
