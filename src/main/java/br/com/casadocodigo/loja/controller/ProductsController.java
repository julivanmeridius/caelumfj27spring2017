package br.com.casadocodigo.loja.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.ProductDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;

/**
 * Class Controller for Products
 * 
 * @author Julivan Meridius
 * @since 04/07/2017
 */
@Controller
@Transactional
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private FileSaver fileSaver;

	@RequestMapping("/form")
	public ModelAndView form(Product product) {
		ModelAndView andView = new ModelAndView("products/form");
		andView.addObject("types", BookType.values());
		return andView;
	}

	@CacheEvict(value="lastProducts")
	@Transactional // -- pertence a especificacao JavaEE - JTA
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(MultipartFile summary, @Valid Product product, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return form(product);
		}

		String webPath = fileSaver.write("uploaded-summaries", summary);
		product.setSummaryPath(webPath);
		productDAO.save(product);

		redirectAttributes.addFlashAttribute("msg", "Produto Cadastrado com Sucesso!");
		return new ModelAndView("redirect:products");
	}

	@RequestMapping(method = RequestMethod.GET)
	@Cacheable(value="lastProducts")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("products/list");
		mav.addObject("products", productDAO.list());
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ModelAndView show(@PathVariable("id") Integer id){
		ModelAndView modelAndView = new ModelAndView("products/show");
		modelAndView.addObject("product", productDAO.find(id));
		return modelAndView;
	}

	/*
	 * @InitBinder //--Informando ao Spring da existencia de um Validator para
	 * Product public void initBinder(WebDataBinder binder){
	 * binder.addValidators(new ProductValidator()); }
	 */
}
