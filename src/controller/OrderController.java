package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Order;
import model.Product;
import model.facade.OrderFacade;
import model.facade.OrderLineFacade;
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
	@EJB(beanName="olFacade")
	private OrderLineFacade orderLineFacade;
		
	/**
	 * Managed Properties
	 */
	@ManagedProperty(value="#{customerSession}")
	private CustomerSessionController session;
	
	@ManagedProperty(value="#{param.productId}")
	private Long productId;
	
	private Integer quantity;
	
	public String createOrder() {
		Order order = orderFacade.createOrder(session.getCustomer().getId());
		session.setOrder(order);
		listProducts();
		return "chooseProducts";
	}


	public String addOrderLineToOrder() {
		Product product = productFacade.findProductById(productId);
		orderLineFacade.addOrderLineToOrder(session.getOrder().getId(), product, quantity);
		listProducts();
		return "chooseProducts";
	}

	private void listProducts() {
		session.setProducts(productFacade.listProducts());
	}
	
	/**
	 * -----------------
	 * GETTER AND SETTER
	 * -----------------
	 */

	public Long getProductId() {
		return productId;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public CustomerSessionController getSession() {
		return session;
	}
	
	public void setSession(CustomerSessionController session) {
		this.session = session;
	}
}
