package sn.camaraka.shoppingbackend.dao;

import java.util.List;

import sn.camaraka.shoppingbackend.dto.Product;

public interface ProductDAO {

	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	// méthodes commerciales
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatesActiveProducts(int count);
	
}
