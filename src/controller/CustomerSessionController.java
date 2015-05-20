package controller;

import javax.faces.bean.ManagedBean;

import model.Customer;
import model.Order;

@ManagedBean(name="customerSession")
public class CustomerSessionController {
	
	private Customer customer;
	private Order order;

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

}
