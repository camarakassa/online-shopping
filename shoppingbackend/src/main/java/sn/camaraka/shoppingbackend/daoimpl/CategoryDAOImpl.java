package sn.camaraka.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sn.camaraka.shoppingbackend.dao.CategoryDAO;
import sn.camaraka.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> list() {

		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		
		return query.getResultList();
	}

	/*
	 * Obtenir une seule catégorie en fonction de l'id
	 */
	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {

		try {
			// Ajout d'une categorie dans la base de données
			sessionFactory.getCurrentSession().persist(category);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean update(Category category) {
		try {
			// Modification d'une categorie dans la base de données
			sessionFactory.getCurrentSession().update(category);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		
		try {
			// Suppresion d'une categorie dans la base de données
			sessionFactory.getCurrentSession().update(category);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}