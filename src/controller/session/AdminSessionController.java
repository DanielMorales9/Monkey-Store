package controller.session;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Admin;
import model.Order;
import model.Product;



@ManagedBean(name="adminSession")
@SessionScoped
public class AdminSessionController {

	private Admin admin;
	
	private Product product;
	
	private List<Product> products; 
	
	private List<Order> ordersToProcess;
	
	
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

	public List<Order> getOrdersToProcess() {
		return ordersToProcess;
	}

	public void setOrdersToProcess(List<Order> ordersToProcess) {
		this.ordersToProcess = ordersToProcess;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
//	public void removeOrder(Long id) {
//		for (Order o : this.ordersToProcess) {
//			if (o.getId().equals(id)) {
//				this.ordersToProcess.remove(o);
//			}
//		}
//	}

}
