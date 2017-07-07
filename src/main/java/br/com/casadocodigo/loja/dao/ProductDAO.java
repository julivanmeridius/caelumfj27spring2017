package br.com.casadocodigo.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;

/**
 * Class DAO for products
 * 
 * @author Julivan Meridius
 * @since 03/07/2017
 */
@Repository
public class ProductDAO {

	@PersistenceContext
	private EntityManager manager;

	/**
	 * Method responsible for saving the Product object on DataBase.
	 * 
	 * @param product
	 *            Object Product to be saved
	 */
	public void save(Product product) {
		manager.persist(product);
	}

	public List<Product> list() {
		return manager.createQuery("select distinct(p) from Product p join fetch p.prices", Product.class)
				.getResultList();
	}

	public Product find(Integer id) {
		return manager
				.createQuery("	select distinct(p) "
							+ "	from Product p join fetch p.prices "
							+ "	where p.id = :id", Product.class)
				.setParameter("id", id).getSingleResult();
	}

	public BigDecimal sumPricesPerType(BookType bookType) {
		TypedQuery<BigDecimal> query = manager.createQuery(
			"	select sum(price.value) "
			+ "	from Product p join p.prices price"
			+ "	where price.bookType = :bookType", BigDecimal.class);
			query.setParameter("bookType", bookType);
		return query.getSingleResult();
	}
}
