/**
 * 
 */
package br.com.casadocodigo.loja.viewresolver;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * Class responsible for solving JSONViewResolver
 * 
 * @author 	Julivan Meridius
 * @since 	06/07/2017
 */
public class JSONViewResolver implements ViewResolver {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.ViewResolver#resolveViewName(java.lang.String, java.util.Locale)
	 */
	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		view.setPrettyPrint(true); //--fazendo com que o JSON fique mais apresentavel para leitura
		return view;
	}
}
