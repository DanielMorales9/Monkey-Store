package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Customer;
import model.Order;
import model.Product;

@ManagedBean(name="customerSession")
@SessionScoped
public class CustomerSessionController {
	
	private Customer customer;
	private Order order;
	private List<Product> products;
	
	
	/**
	 * -----------------
	 * GETTER AND SETTER
	 * ----------------- 
	 */

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
