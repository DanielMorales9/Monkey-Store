package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.OrderLine;
import model.facade.OrderLineFacade;
import controller.session.CustomerSessionController;

@ManagedBean(name="orderLineDetails")
public class OrderLineDetailsController {

	@EJB(name="olFacade")
	private OrderLineFacade facade;
	
	@ManagedProperty(value="#{customerSession}")
	private CustomerSessionController session;
	@ManagedProperty(value="#{param.id}")
	private Long id;
	
	
	public String findOrderLineById() {
		OrderLine ol = facade.findOrderLineById(id);
		session.setOrderLine(ol);
		return "orderLine.xhtml";
	}
	
	/**
	 * -----------------
	 * GETTER AND SETTER
	 * -----------------
	 */
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public CustomerSessionController getSession() {
		return session;
	}
	
	public void setSession(CustomerSessionController session) {
		this.session = session;
	}
}
