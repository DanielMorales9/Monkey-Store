package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Product;
import model.facade.CustomerFacade;
import model.facade.ProductFacade;

@ManagedBean
public class ProductDetailsController {
	
	
	@EJB(beanName="pFacade")
	private ProductFacade productFacade;
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private Product product;
	private Integer quantity;
	@EJB(beanName="cFacade")
	private CustomerFacade customerFacade;


	public String findProductById() {
		setProduct(productFacade.findProductById(id));
		return "productDetails";
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	public Product getProduct() {
		return product;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getQuantity() {
		return quantity;
	}
	
	
	public String addNewProductToOrder() {
		customerFacade.addProductToOrder(id, quantity);
		return "customerArea";
	}
}
