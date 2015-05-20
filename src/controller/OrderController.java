package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import model.Order;
import model.Product;
import model.facade.OrderFacade;
import model.facade.ProductFacade;

@ManagedBean(name="orderController")
@SessionScoped
public class OrderController {
	
	@EJB(beanName="oFacade")
	private OrderFacade orderFacade;
	@EJB(beanName="pFacade")
	private ProductFacade productFacade;
		
	@ManagedProperty(value="#{session}")
	private CustomerSessionController session;
	
	private List<Product> products;
	
	private Integer quantity;
	
	private Product product;
	
	public String createOrder() {
		Order order = orderFacade.createOrder(session.getCustomer().getId());
		session.setOrder(order);
		products = productFacade.listProducts();
		return "chooseProducts";
	}


	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
