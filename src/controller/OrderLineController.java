package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import controller.session.CustomerSessionController;
import model.Order;
import model.OrderLine;
import model.facade.OrderFacade;
import model.facade.OrderLineFacade;
import model.facade.ProductFacade;

@ManagedBean(name="orderLineController", eager=true)
public class OrderLineController {
	
	@EJB(beanName="pFacade")
	private ProductFacade productFacade;
	@EJB(beanName="oFacade")
	private OrderFacade orderFacade;
	@EJB(beanName="olFacade")
	private OrderLineFacade orderLineFacade;
	
	@ManagedProperty(value="#{customerSession}")
	private CustomerSessionController session;

	@ManagedProperty(value="#{param.productId}")
	private Long productId;
	
	@ManagedProperty(value="#{param.orderLineId}")
	private Long orderLineId;

	private Integer quantity;
	
	public String findProductById() {
		session.setProduct(productFacade.findProductById(productId));
		return "addOrderLine.xhtml";
	}
	
	public String findOrderLineById() {
		OrderLine ol = orderLineFacade.findOrderLineById(orderLineId);
		session.setOrderLine(ol);
		return "orderLineDetails.xhtml";
	}

	
	public String cancelOrderLine() {
		orderLineFacade.removeOrderLineFromOrder(session.getOrder().getId(),
				orderLineId);
		Order order = orderFacade.findOrderById(session.getOrder().getId());
		session.setOrder(order);
		return "confirmOrder";
	}
	
	public String addOrderLineToOrder() {
		orderLineFacade.addOrderLineToOrder(session.getOrder().getId(),
				session.getProduct(), quantity);
		listProducts();
		return "chooseProducts";
	}
	
	public String updateOrderLineQuantity() {
		orderLineFacade.updateOrderLineQuantity(session.getOrderLine().getId(), 
				quantity);
		session.setOrder(orderFacade.findOrderById(session.getOrder().getId()));
		return "confirmOrder";	
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
	
	public Long getProductId() {
		return productId;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public Long getOrderLineId() {
		return orderLineId;
	}
	
	public void setOrderLineId(Long orderLineId) {
		this.orderLineId = orderLineId;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
