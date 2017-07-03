/**
 * 
 */
package br.com.casadocodigo.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.loja.models.Product;

/**
 * Class Controller for Products
 * 
 * @author 	Julivan Meridius
 * @since	03/07/2017
 */
@Controller
public class ProductsController {

	@RequestMapping
	public String form(){
		return "products/form";  //--caminho fisico do jsp
	}
	
	@RequestMapping("/products")
	public String save(Product product){
		System.out.println("Cadastrando o Produto...");
		System.out.println(product.toString());
		return "products/ok";
	}
}
