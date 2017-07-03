/**
 * 
 */
package br.com.casadocodigo.loja.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.controller.HomeController;

/**
 * Classe de configuracao.
 * @author 	Julivan Meridius
 * @since	03/07/2017
 */
@EnableWebMvc
@ComponentScan(basePackageClasses=HomeController.class)
public class AppWebConfiguration {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
