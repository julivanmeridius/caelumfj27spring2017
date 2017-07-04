/**
 * 
 */
package br.com.casadocodigo.loja.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.ProductDAO;
import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;
/**
 * Class Controller for Products
 * 
 * @author 	Julivan Meridius
 * @since	04/07/2017
 */
@Controller
@Transactional
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/form")
	public ModelAndView form(Product product){
		ModelAndView andView = new ModelAndView("products/form");
		andView.addObject("types", BookType.values());
		return andView;
	}
	
	@Transactional //-- pertence a especificacao JavaEE - JTA
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView save(@Valid Product product, BindingResult bindingResult, RedirectAttributes att){
		
		if(bindingResult.hasErrors()){
			return form(product);
		}
		productDAO.save(product);
		att.addFlashAttribute("msg", "Produto Cadastrado com Sucesso!");
		return new ModelAndView("redirect:products");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView("products/list");
		mav.addObject("products", productDAO.list());
		return mav;
	}
	
	/*@InitBinder //--Informando ao Spring da existencia de um Validator para Product
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new ProductValidator());
	}*/
}
