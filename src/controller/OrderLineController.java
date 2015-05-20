package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.facade.ProductFacade;

@ManagedBean(name="orderLineController", eager=true)
public class OrderLineController {
	
	@EJB(beanName="pFacade")
	private ProductFacade productFacade;
	
	@ManagedProperty(value="#{customerSession}")
	private CustomerSessionController session;

	@ManagedProperty(value="#{param.productId}")
	private Long productId;
	
	public String findProductById() {
		session.setProduct(productFacade.findProductById(productId));
		return "addOrderLine";
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
}
