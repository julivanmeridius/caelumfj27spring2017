/**
 * 
 */
package br.com.casadocodigo.loja.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.loja.dao.ProductDAO;
import br.com.casadocodigo.loja.models.Product;

/**
 * Class Controller for Products
 * 
 * @author 	Julivan Meridius
 * @since	03/07/2017
 */
@Controller
@Transactional
public class ProductsController {

	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping
	public String form(){
		return "products/form";  //--caminho fisico do jsp
	}
	
	@Transactional //-- pertence a especificacao JavaEE - JTA
	@RequestMapping("/products")
	public String save(Product product){
		System.out.println("Cadastrando o Produto...");
		System.out.println(product.toString());
		productDAO.save(product);
		return "products/ok";
	}
}
