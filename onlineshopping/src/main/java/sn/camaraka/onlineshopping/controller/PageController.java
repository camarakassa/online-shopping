package sn.camaraka.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sn.camaraka.onlineshopping.exception.ProductNotFoundException;
import sn.camaraka.shoppingbackend.dao.CategoryDAO;
import sn.camaraka.shoppingbackend.dao.ProductDAO;
import sn.camaraka.shoppingbackend.dto.Category;
import sn.camaraka.shoppingbackend.dto.Product;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		logger.info("Dans la méthode index de PageController - INFO");
		logger.debug("Dans la méthode index de PageController - DÉBOGUER ");
		
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

	
	// Affichage d'un seul produit
	
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		if(product == null) {
			throw new ProductNotFoundException();
		}
		
		// mettre à jour le nombre de vues
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		//----------------------
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true);
		
		
		
		return mv;
		
	}
	
	
	

}
