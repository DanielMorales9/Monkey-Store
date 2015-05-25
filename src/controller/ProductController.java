package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import controller.session.AdminSessionController;
import model.Product;
import model.facade.AdminFacade;
import model.facade.ProductFacade;

@ManagedBean
public class ProductController {
	
	@EJB(beanName="adminFacade")
	private AdminFacade adminFacade;
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String name;
	private String description;
	private Float price;
	private String code;
	
	private String error;
	

	private Product product;
	private List<Product> products;
	
	@EJB(beanName="pFacade")
	private ProductFacade productFacade;
	
	@ManagedProperty(value="#{adminSession}")
	private AdminSessionController adminSession;
	
	public String createProduct() {
		this.product = productFacade.createProduct(name, code, price, description);
		return "product"; 
	}
	
	public String listProducts() {
		adminSession.setProducts( productFacade.listProducts());
		return "products"; 
	}

	public String findProduct() {
		this.product = productFacade.findProductById(id);
		return "productDetails";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Float getPrice() {
		return price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public AdminSessionController getAdminSession() {
		return adminSession;
	}
	
	public void setAdminSession(AdminSessionController adminSession) {
		this.adminSession = adminSession;
	}
	
}
