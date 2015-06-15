package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import controller.session.CustomerSessionController;
import model.Order;
import model.facade.CustomerFacade;
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
	@EJB(beanName="cFacade")
	private CustomerFacade customerFacade;

	/**
	 * Managed Properties
	 */
	@ManagedProperty(value="#{customerSession}")
	private CustomerSessionController session;
	@ManagedProperty(value="#{param.orderId}")
	private Long orderId;
	
	private List<Order> orders;
	
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
	
	public String findOrderById() {
		Order order = orderFacade.findOrderById(orderId);
		session.setOrder(order);
		return "orderLines.jsp";
	}

	public String confirmOrder() {
		List<Order> orders = orderFacade.listCustomerOrders(session.getCustomer().getId());
		session.setOrders(orders);
		return "customerArea";
	}
	
	public String listOrders() {
		session.setOrders(orderFacade.listCustomerOrders(session.getCustomer().getId()));
		return "orders";
	}

	@PostConstruct
	public void listMyOrders() {
		this.orders = orderFacade.listCustomerOrders(session.getCustomer().getId());
	}
	
	/**
	 * -----------------
	 * GETTER AND SETTER
	 * -----------------
	 */

	
	public Long getOrderId() {
		return orderId;
	}
	
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public CustomerSessionController getSession() {
		return session;
	}

	public void setSession(CustomerSessionController session) {
		this.session = session;
	}

}
