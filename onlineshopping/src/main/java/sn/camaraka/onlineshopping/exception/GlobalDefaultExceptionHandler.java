package sn.camaraka.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException( ) {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "The page is not constructed!");
		mv.addObject("errorDescription", "La page dont vous faites allusion n'est pas disponible pour le moment!");
		mv.addObject("title", "404 Error Page");
		
		return mv;
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException( ) {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Produit non disponible!");
		mv.addObject("errorDescription", "Le product dont vous faites allusion n'est pas disponible pour le moment!");
		mv.addObject("title", "Product Unavailable!");
		
		return mv;
	}
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception exception ) {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Veuillez Contactez Votre Administrateur!");
		
		
		
		// seulement pour déboguer notre application
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		exception.printStackTrace(pw);
		
		
		mv.addObject("errorDescription", sw.toString());
		mv.addObject("title", "Error!");
		
		return mv;
	}
	
	
	
	
	
	
	
}
