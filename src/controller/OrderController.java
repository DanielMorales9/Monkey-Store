package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Order;
import model.facade.OrderFacade;
import model.facade.ProductFacade;

@ManagedBean(name="orderController")
public class OrderController {

	/**
	 * 	EJB facades 
	 */
	@EJB(beanName="oFacade")
	private OrderFacade orderFacade;
	@EJB(beanName="pFacade")
	private ProductFacade productFacade;

	/**
	 * Managed Properties
	 */
	@ManagedProperty(value="#{customerSession}")
	private CustomerSessionController session;


	public String createOrder() {
		Order order = orderFacade.createOrder(session.getCustomer().getId());
		session.setOrder(order);
		listProducts();
		return "chooseProducts";
	}

	public String endOrder() {
		Order order = orderFacade.findOrderById(session.getOrder().getId());
		session.setOrder(order);
		return "confirmOrder";
	}

	public String cancelOrder() {
		orderFacade.removeOrderById(session.getOrder().getId());
		return "customerArea";
	}

	private void listProducts() {
		session.setProducts(productFacade.listProducts());
	}

	/**
	 * -----------------
	 * GETTER AND SETTER
	 * -----------------
	 */

	public CustomerSessionController getSession() {
		return session;
	}

	public void setSession(CustomerSessionController session) {
		this.session = session;
	}

}
