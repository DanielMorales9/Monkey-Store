package controller;


import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import controller.session.CustomerSessionController;
import model.Customer;
import model.facade.CustomerFacade;

@ManagedBean(name="loginCustomer", eager=true)
public class LoginCustomerController {
	
	@EJB(beanName="cFacade")
	private CustomerFacade facade;
	
	@ManagedProperty(value="#{customerSession}")
	private CustomerSessionController session;
	
	private String email;
	private String password;
	
	private String loginError;
	
	public String loginCustomer() {
		try {
			Customer customer = facade.retrieveCustomerByEmailAndPassword(email, password);
			session.setCustomer(customer);
			
		} catch (Exception e) {
			loginError = "Email or Password is not valid";
			return "loginCustomer.xhtml";
		}
		return "customerArea.jsp";
	}

	/**
	 * -----------------
	 * GETTER AND SETTER
	 * -----------------
	 */
	
	
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
	
	public String getLoginError() {
		return loginError;
	}
	public void setLoginError(String loginError) {
		this.loginError = loginError;
	}

	public CustomerSessionController getSession() {
		return session;
	}

	public void setSession(CustomerSessionController session) {
		this.session = session;
	}
}
