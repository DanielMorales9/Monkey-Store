package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Order;
import model.Product;
import model.facade.OrderFacade;
import model.facade.ProductFacade;

@ManagedBean(name="orderController")
public class OrderController {
	
	@EJB(beanName="oFacade")
	private OrderFacade orderFacade;
	@EJB(beanName="pFacade")
	private ProductFacade productFacade;
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	
	private List<Product> products;
	
	public String createOrder() {
		Order order = orderFacade.createOrder(id);
		id = order.getId();
		products = productFacade.listProducts();
		return "products";
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
