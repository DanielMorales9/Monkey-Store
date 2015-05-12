package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Customer;
import model.Product;
import model.facade.CustomerFacade;

@ManagedBean
public class OrderController {

	@EJB(beanName="cFacade")
	private CustomerFacade facade;
	
	private Customer customer;
	@ManagedProperty(value="#{param.idCustomer}")
	private Long idCustomer;
	
	private Integer quantity;
	@ManagedProperty(value="#{param.id}")
	private Long id;
	
	private List<Product> products;
	
	public String createNewOrder() {
		customer = facade.findCustomerById(idCustomer);
		setProducts(facade.createNewOrder(customer));
		return "chooseProducts";
	}
	
	public String addNewProductToOrder() {
		facade.addProductToOrder(id, quantity);
		products = facade.getAllProducts();
		return "chooseProducts";
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Long getIdCustomer() {
		return idCustomer;
	}
	
	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}