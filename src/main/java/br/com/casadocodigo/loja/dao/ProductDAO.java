/**
 * 
 */
package br.com.casadocodigo.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Product;

/**
 * Class DAO for products
 * 
 * @author 	Julivan Meridius
 * @since	03/07/2017
 */
@Repository
public class ProductDAO {

	@PersistenceContext
	private EntityManager manager;
	
	/**
	 * Method responsible for saving the Product object on DataBase.
	 * @param product Object Product to be saved
	 */
	public void save(Product product){
		manager.persist(product);
	}
}
