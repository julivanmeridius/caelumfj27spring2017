/**
 * 
 */
package br.com.casadocodigo.loja.models;

/**
 * Entity Class for Products
 * 
 * @author Julivan Meridius
 * @since 03/07/2017
 */
public class Product {

	private String title;
	private String description;
	private int numberOfPages;

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

	@Override
	public String toString() {
		return "Product [title=" + title + ", description=" + description + ", numberOfPages=" + numberOfPages + "]";
	}
}
