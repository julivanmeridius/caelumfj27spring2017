/**
 * 
 */
package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;

/**
 * Class PaymentData for ShoppingCart items
 * 
 * @author Julivan Meridius
 * @since 05/07/2017
 */
public class PaymentData {

	private BigDecimal value;

	
	public PaymentData(BigDecimal value) {
		this.value = value;
	}
	
	/**
	 * @return the value
	 */
	public BigDecimal getValue() {
		return value;
	}
}
