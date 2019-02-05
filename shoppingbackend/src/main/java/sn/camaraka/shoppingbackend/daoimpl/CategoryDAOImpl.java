package sn.camaraka.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sn.camaraka.shoppingbackend.dao.CategoryDAO;
import sn.camaraka.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {

		
		// Categorie 1
		Category category = new Category();
		category.setId(1);
		category.setName("Ordinamteur");
		category.setDescription("Description pour les Ordinateur");
		category.setImageURL("CAT_1.png");
		categories.add(category);

		// Deuxieme Categorie

		category = new Category();
		category.setId(2);
		category.setName("Télévision");
		category.setDescription("Description pour les télévision");
		category.setImageURL("CAT_2.png");
		categories.add(category);

		//  3 Categorie
		category = new Category();

		category.setId(3);
		category.setName("Portable");
		category.setDescription("Description pour les téléphone");
		category.setImageURL("CAT_3.png");
		categories.add(category);
	}

	@Override
	public List<Category> list() {

		return categories;
	}

	@Override
	public Category get(int id) {
		
		// On enchaine pour la boucle
		for(Category category : categories) {
			
			if(category.getId() == id) {
				return category;
			}
		}
		return null;
	}

}
