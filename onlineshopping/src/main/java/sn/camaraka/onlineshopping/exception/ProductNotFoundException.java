package sn.camaraka.onlineshopping.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public ProductNotFoundException() {
		 this("Ce produit n'est pas disponible!");
	}
	
	public ProductNotFoundException(String message) {
		 this.message = System.currentTimeMillis() + ": "+ message;
	}

	public String getMessage() {
		return message;
	}

	
	
	
}
