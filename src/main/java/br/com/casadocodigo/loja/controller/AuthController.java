package br.com.casadocodigo.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class responsible for the Authentication
 * 
 * @author 	Julivan Meridius
 * @since	07/07/017
 */
@Controller
public class AuthController {
	
	@RequestMapping("/login")
	public String loginPage() {
		return "auth/login";
	}
}
