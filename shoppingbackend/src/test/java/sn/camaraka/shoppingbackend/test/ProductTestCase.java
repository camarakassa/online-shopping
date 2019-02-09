package sn.camaraka.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sn.camaraka.shoppingbackend.dao.ProductDAO;
import sn.camaraka.shoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("sn.camaraka.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	@Test
	public void testCRUDProduct() {
		
		product = new Product();
		
		product.setName("Oppo selfie S53");
		product.setMarque("Oppo");
		product.setDescription("Une petite description pour les telephones portable Oppo!");
		product.setUnitPrice(80000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setFournisseurid(3);
		
		assertEquals("quelque chose s'est mal passé lors de l'insertion d'un nouveau produit", 
				true, productDAO.add(product));
		
		// Lecture et mise à jour de la catégorie
		product = productDAO.get(2);
		product.setName("Samasung Galaxy S8");
		
		assertEquals("quelque chose s'est mal passé lors de la mise à jour du produit existant", 
				true, productDAO.update(product));
		
		assertEquals("quelque chose s'est mal passé lors de la suppression du produit existant", 
				true, productDAO.delete(product));
		
		// liste des produits
		assertEquals("quelque chose a mal tourné pendant la récupération des produits", 
				6, productDAO.list().size());	
		
	}
	
	
	
	
	/*@Test
	public void testListActiveproducts() {
		assertEquals("quelque chose a mal tourné pendant la récupération des produits", 
				5, productDAO.listActiveProducts().size());	
	}
	
	@Test
	public void testListActiveproductsByCategory() {
		assertEquals("quelque chose a mal tourné pendant la récupération des produits", 
				3, productDAO.listActiveProductsByCategory(3).size());	
		assertEquals("quelque chose a mal tourné pendant la récupération des produits", 
				2, productDAO.listActiveProductsByCategory(1).size());	
	}
	
	@Test
	public void testGetLatesActiveProducts() {
		assertEquals("quelque chose a mal tourné pendant la récupération des produits", 
				3, productDAO.getLatesActiveProducts(3).size());	
	}
	*/
	
}
