package sn.camaraka.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sn.camaraka.shoppingbackend.dao.CategoryDAO;
import sn.camaraka.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("sn.camaraka.shoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Laptop");
	 * category.setDescription("Description pour les laptops");
	 * category.setImageURL("CAT_105.png");
	 * 
	 * 
	 * assertEquals("La categorie a été ajoutée avec succès dans la table", true,
	 * categoryDAO.add(category));
	 * 
	 * }
	 */
	/*
	 * @Test public void testGetCategory() {
	 * 
	 * category = categoryDAO.get(3);
	 * 
	 * assertEquals("Extrait avec succès une seule catégorie de la table",
	 * "Télévision", category.getName());
	 * 
	 * }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(1); category.setName("Ordi Portable");
	 * 
	 * assertEquals("Modifié avec succès une catégorie de la table", true,
	 * categoryDAO.update(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * category = categoryDAO.get(4);
	 * 
	 * assertEquals("Suppression avec succès une catégorie de la table", true,
	 * categoryDAO.delete(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * 
	 * assertEquals("Récupération avec succès les catégories de la liste de la table"
	 * , 3, categoryDAO.list().size());
	 * 
	 * }
	 */

	@Test
	public void testCRUDCategory() {

		// Opération d'ajout
		category = new Category();

		category.setName("Laptop");
		category.setDescription("Description pour les laptops");
		category.setImageURL("CAT_101.png");
		assertEquals("La categorie a été ajoutée avec succès dans la table", true, categoryDAO.add(category));

		category = new Category();

		
		
		category.setName("Télévision");
		category.setDescription("Description pour les Télévisions");
		category.setImageURL("CAT_101.png");
		assertEquals("La catégorie a été ajoutée avec succès dans la table", true, categoryDAO.add(category));

		
		// Recherche et mise à jour de la catégorie
		category = categoryDAO.get(2);
		category.setName("TV");

		assertEquals("Modifié avec succès une catégorie de la table", true, categoryDAO.update(category));

		
		// Suppression de la catégirie		  
		  assertEquals("Suppression avec succès une catégorie de la table", true, categoryDAO.delete(category));
	
		  // Afficher la liste
		  assertEquals("Récupération avec succès les catégories de la liste de la table", 1, categoryDAO.list().size());
	}
	
	
	
	
	
	
	
	
	
	
	
	

}