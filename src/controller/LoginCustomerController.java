package controller;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Customer;
import model.facade.CustomerFacade;

@ManagedBean(name="loginCustomer")
@SessionScoped
public class LoginCustomerController {
	
	@EJB(beanName="cFacade")
	private CustomerFacade facade;
	
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Date birthDay;
	
	private String loginError;
	private String registerError;
	
	private Customer customer;
	
	public String loginCustomer() {
		try {
			customer = facade.retrieveCustomerByEmailAndPassword(email, password);
		} catch (Exception e) {
			loginError = "Email or Password is not valid";
			return "loginCustomer";
		}
		return "customerArea";
	}
	
	public String registerCustomer() {
		try {
		customer = facade.createCustomer(email, password, firstName, lastName, birthDay);
		} catch (Exception e) {
			registerError="Email already exists";
			return "registerCustomer";
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
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getBirthDay() {
		return birthDay;
	}
	
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getLoginError() {
		return loginError;
	}
	public void setLoginError(String loginError) {
		this.loginError = loginError;
	}

	public String getRegisterError() {
		return registerError;
	}

	public void setRegisterError(String registerError) {
		this.registerError = registerError;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
