package wb.store.service.dao;

import java.util.List;
import java.util.Map;

import wb.store.domain.Cart;
import wb.store.domain.Product;
import wb.store.domain.ProductInCart;
import wb.store.service.GenericDao;
/**
 * DAO of Cart
 * @author William Bowen
 *
 */
public interface CartDao extends GenericDao<Cart, Long> {
	
	void addToCart(Cart cart, Map<Product, Integer> products);
	
	void updateCart(Cart cart, Map<Product, Integer> products);
	
	void removeFromCart(Cart cart, List<ProductInCart> cartItems);
	
	//no additional business operations at the moment
}
