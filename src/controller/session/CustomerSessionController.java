package controller.session;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Customer;
import model.Order;
import model.OrderLine;
import model.Product;

@ManagedBean(name="customerSession")
@SessionScoped
public class CustomerSessionController {
	
	private Customer customer;
	
	private Order order;
	private OrderLine orderLine;

	private List<Product> products;
	private Product product;

	private List<Order> orders;
	
	/**
	 * -----------------
	 * GETTER AND SETTER
	 * ----------------- 
	 */

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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

	public OrderLine getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(OrderLine orderLine) {
		this.orderLine = orderLine;
	}

	public List<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
