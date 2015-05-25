package controller.session;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Admin;
import model.Product;



@ManagedBean(name="adminSession")
@SessionScoped
public class AdminSessionController {

	private Admin admin;
	
	private List<Product> products; 
	
	
	/**
	 * -----------------
	 * GETTER AND SETTER
	 * -----------------
	 **/
	

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;	
	}
	
	

}
