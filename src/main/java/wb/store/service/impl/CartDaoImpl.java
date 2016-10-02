package wb.store.service.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import wb.store.domain.Cart;
import wb.store.domain.Product;
import wb.store.domain.ProductInCart;
import wb.store.service.dao.CartDao;
import wb.store.service.dao.ProductInCartDao;

@Repository("cartDao")
public class CartDaoImpl extends HibernateDao<Cart, Long> implements CartDao {

	public CartDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	private ProductInCartDao productInCartDao;

	@Override
	public void addToCart(Cart cart, Map<Product, Integer> products) {
		List<ProductInCart> picList = cart.getCartItems();
		for (Product product : products.keySet()) {
			boolean productFound = false;
			for (ProductInCart prodInCart : picList) {

				if (product.getId() == prodInCart.getProduct().getId()) {
					int quantity = prodInCart.getQuantity();
					prodInCart.setQuantity(quantity + products.get(product));
					productInCartDao.update(prodInCart);
					productFound = true;
					break;
				}
			}

			if (!productFound) {
				ProductInCart productInCart = new ProductInCart(product, cart, products.get(product));
				productInCartDao.add(productInCart);
			}

		}
	}

	@Override
	public void updateCart(Cart cart, Map<Product, Integer> products) {
		List<ProductInCart> picList = cart.getCartItems();
		assert(picList.size() > products.size());
		for(Product product : products.keySet()) {
			for (ProductInCart prodInCart : picList) {

				if (product.getId() == prodInCart.getProduct().getId()) {
					prodInCart.setQuantity(products.get(product));
					productInCartDao.update(prodInCart);
					
				}
			}
		}
	}

	@Override
	public void removeFromCart(Cart cart, List<ProductInCart> cartItems) {
		List<ProductInCart> currentList = cart.getCartItems();
		for (ProductInCart cartItem : cartItems) {
			currentList.remove(cartItem);
		}
		cart.setCartItems(currentList);
		update(cart);

	}
}
