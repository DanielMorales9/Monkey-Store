package controller;


import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Customer;
import model.facade.CustomerFacade;
import model.facade.OrderFacade;

@ManagedBean
public class RetrieveCustomerController {

	@ManagedProperty(value="#{param.id}")
	private Long id;	
	
	private String error;	
	
	@EJB(beanName="oFacade")
	private OrderFacade orderFacade;
	
	@EJB(beanName="cFacade")
	private CustomerFacade customerFacade;
	
	private Customer customer;
	
	public String findCustomer(){		
		try {
			customer = orderFacade.getCustomerFromOrderId(id);
			if (customer == null){
				return "error";
			}
		}
		catch (Exception e) {
			error = "Order doesn't exist";
			return "retrieveCustomer.jsp";
		}
		return "customerDetails.xhtml";
		
	}
	
	public String retrieveAddress(){
		this.customer = customerFacade.findCustomerById(id);
		return "retrieveAddress.xhtml";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrderFacade getOrdersFacade() {
		return orderFacade;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Customer getCustomer() {
		return customer;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}