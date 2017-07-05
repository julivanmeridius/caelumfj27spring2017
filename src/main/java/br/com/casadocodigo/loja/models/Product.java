package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Entity Class for Products
 * 
 * @author Julivan Meridius
 * @since 03/07/2017
 */
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	private String title;

	@Lob
	@NotBlank
	private String description;

	@Min(30)
	private int numberOfPages;

	@ElementCollection
	private List<Price> prices = new ArrayList<Price>();

	@DateTimeFormat
	private Calendar releaseDate;

	private String summaryPath;

	/**
	 * @return the prices
	 */
	public List<Price> getPrices() {
		return prices;
	}

	/**
	 * @return the summaryPath
	 */
	public String getSummaryPath() {
		return summaryPath;
	}

	/**
	 * @param summaryPath
	 *            the summaryPath to set
	 */
	public void setSummaryPath(String summaryPath) {
		this.summaryPath = summaryPath;
	}

	/**
	 * @return the releaseDate
	 */
	public Calendar getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate
	 *            the releaseDate to set
	 */
	public void setReleaseDate(Calendar releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * @param prices
	 *            the prices to set
	 */
	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", description=" + description + ", numberOfPages="
				+ numberOfPages + ", prices=" + prices + ", releaseDate=" + releaseDate + ", summaryPath=" + summaryPath
				+ "]";
	}

	public BigDecimal priceFor(BookType bookType) {
		return prices.stream().filter(price -> price.getBookType().equals(bookType)).findFirst().get().getValue();
	}
}
