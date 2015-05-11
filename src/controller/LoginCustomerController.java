package controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import model.Customer;

@ManagedBean
@SessionScoped
public class LoginCustomerController {
	
	private String email;
	
	private String password;
	
	@EJB(beanName="cFacade")
	private CustomerFacade facade;
	
	private Customer customer;

	private String loginError;
	
	public String loginCustomer() {
		try {
		customer = facade.loginCustomer(email, password);
		}
		catch (DBException e) {
			return "error";
		} 
		catch (InvalidPasswordException | InvalidEmailException e) {
			loginError = "Email or Password is not valid";
			return "loginCustomer";
		}
		return "customerArea";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String getLoginError() {
		return loginError;
	}
	
	public void setLoginError(String loginError) {
		this.loginError = loginError;
	}
	
}