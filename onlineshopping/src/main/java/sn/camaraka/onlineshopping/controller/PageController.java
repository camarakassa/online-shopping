package sn.camaraka.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sn.camaraka.shoppingbackend.dao.CategoryDAO;
import sn.camaraka.shoppingbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		// Passer la liste des catégories
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "A Propos");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Nous Contacter");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	
	/*
	 * Method Pour charger tous les produits en fonction de la categorie
	 */
	@RequestMapping(value = { "/show/all/products"})
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Tous Produits");
		
		// Passer la liste des catégories
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	
	
	
	 // Method Pour charger tous les produits en fonction de la categorie
	 
	@RequestMapping(value = { "/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		
		 // categoryDAO pour chercher une seule catégorie
		Category category = null;
		
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName()); 
		
		// Passer la liste des catégories
		mv.addObject("categories", categoryDAO.list());
		
		// passer l'objet de la catégorie unique
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}


}
