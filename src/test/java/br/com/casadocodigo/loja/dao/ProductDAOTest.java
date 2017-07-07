package br.com.casadocodigo.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.casadocodigo.loja.conf.JPAConfiguration;
import br.com.casadocodigo.loja.models.BookType;
import br.com.casadocodigo.loja.models.Product;
import br.com.casadocodigo.testes.ProductBuilder;

/**
 * Classe de testes do contexto de Produtos.
 * 
 * @author 	Julivan Meridius
 * @since 	07/07/2017
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProductDAO.class, JPAConfiguration.class, DataSourceConfigurationTest.class})
@ActiveProfiles("test")
public class ProductDAOTest {

	@Autowired
	ProductDAO productDAO;
	
	@Transactional
	@Test
	public void shouldSummAllPricesOfEachBookPerType() {
		List<Product> printedBooks = ProductBuilder.newProduct(BookType.PRINTED, BigDecimal.TEN).more(4).builAll();
		printedBooks.stream().forEach(productDAO::save);
		
		List<Product> ebooks = ProductBuilder.newProduct(BookType.EBOOK, BigDecimal.TEN).more(4).builAll();
		ebooks.stream().forEach(productDAO::save);
		
		BigDecimal value = productDAO.sumPricesPerType(BookType.PRINTED);

		Assert.assertEquals(new BigDecimal(50).setScale(2), value);
	}
}
