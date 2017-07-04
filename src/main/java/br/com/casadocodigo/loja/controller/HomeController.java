/**
 * 
 */
package br.com.casadocodigo.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Classe centralizadora do Projeto.
 * @author 	Julivan Meridius
 * @since	03/07/2017
 */
@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(){
		System.out.println("Invocando a Página Inicial da Aplicação...");
		return "index";
	}
}
