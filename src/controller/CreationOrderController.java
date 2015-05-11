package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Customer;

@ManagedBean
public class CreationOrderController {
	
	@ManagedProperty(value="#{param.customer}")
	private Customer customer;
	
	public String createNewOrder(Customer customer) {
		return "error";
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
