package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class OrderLine {

	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@JoinColumn(nullable= false)
	private Product product;

	@JoinColumn(nullable = false)
	private Integer quantity;

	public OrderLine() {

	}

	public OrderLine(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
