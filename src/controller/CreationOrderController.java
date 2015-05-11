package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Customer;
import model.Product;
import model.facade.CustomerFacade;

@ManagedBean
public class CreationOrderController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	@ManagedProperty(value="#{param.customer}")
	private Customer customer;
	
	@EJB(beanName="cFacade")
	private CustomerFacade customerFacade;

	private List<Product> products;
	private Product product;
	private Integer quantity;
	
	public String createNewOrder(Customer customer) {
		products = customerFacade.createNewOrder(customer);
		return "products";
	}
	
	public String findProductById(Long id) {
		setProduct(customerFacade.getProduct(id));
		return "product";
	}
	
	public String addNewProductToOrder(Long id) {
		
		return "products";
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
	
}
