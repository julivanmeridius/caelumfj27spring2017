/**
 * 
 */
package br.com.casadocodigo.loja.viewresolver;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;

/**
 * Class responsible for solving XMLViewResolver
 * 
 * @author 	Julivan Meridius
 * @since 	06/07/2017
 */
public class XMLViewResolver implements ViewResolver {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.ViewResolver#resolveViewName(java.lang.String, java.util.Locale)
	 */
	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		MappingJackson2XmlView view = new MappingJackson2XmlView();
		//--view.setPrettyPrint(true); //--não funciona
		return view;
	}
}
