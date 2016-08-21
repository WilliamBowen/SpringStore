package wb.store.service.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import wb.store.domain.Cart;
import wb.store.domain.Product;
import wb.store.domain.ProductInCart;
import wb.store.service.dao.CartDao;
import wb.store.service.dao.ProductDao;
import wb.store.service.dao.ProductInCartDao;

@Repository("cartDao")
public class CartDaoImpl extends HibernateDao<Cart, Long> implements CartDao {

	private ProductInCartDao productInCartDao;
	@Override
	public void addToCart(Cart cart, Map<Product, Integer> products) {
		for(Product product : products.keySet()){
			Query query = currentSession().createQuery(
					"from ProductInCart where product_id = :pid and cart_id = :cid");
			query.setParameter("pid", product.getId());
			query.setParameter("cid", cart.getId());
			//if product exists in cart
			if(!query.list().isEmpty()) {
				List<ProductInCart> pic = query.list();
				query = currentSession().createQuery(
						"update ProductInCart set quantity = :quantity " +
						"where product_id = :pid and cart_id = :cid");
				query.setParameter("quantity", pic.get(0).getQuantity() + products.get(product));
				query.setParameter("pid", product.getId());
				query.setParameter("cid", cart.getId());
			}
			//if product is not already in cart
			ProductInCart pic = new ProductInCart(product, cart, products.get(product));
			productInCartDao.add(pic);
		}
	}

	@Override
	public void updateCart(Cart cart, Map<Product, Integer> products) {
		for(Product product : products.keySet()) {
			Query query = currentSession().createQuery(
					"update ProductInCart set quantity = :quantity " +
					"where product_id = :pid and cart_id = :cid");
			query.setParameter("quantity", products.get(product));
			query.setParameter("pid", product.getId());
			query.setParameter("cid", cart.getId());
		}
		
	}

	@Override
	public void removeFromCart(Cart cart, List<ProductInCart> cartItems) {
		for(ProductInCart cartItem : cartItems) {
			productInCartDao.remove(cartItem);
		}
		
	}
}
