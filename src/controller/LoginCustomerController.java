package controller;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import exception.InvalidEmailException;
import exception.InvalidPasswordException;
import model.Customer;
import model.facade.CustomerFacade;

@ManagedBean
@SessionScoped
public class LoginCustomerController {
	
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Date bDay;
	
	
	@EJB(beanName="cFacade")
	private CustomerFacade facade;
	
	private Customer customer;

	private String loginError;
	private String registerError;
	
	public String loginCustomer() {
		try {
		customer = facade.loginCustomer(email, password);
		}
		catch (InvalidPasswordException | InvalidEmailException e) {
			loginError = "Email or Password is not valid";
			return "loginCustomer";
		}
		catch (Exception e) {
			return "error";
		}
		return "customerArea";
	}
	
	public String registerNewCustomer() {
		try {
		customer = facade.createNewCustomer(email, password, firstName, lastName, bDay);
		} catch (Exception e) {
			registerError ="Email already registered";
			return "signupCustomer";
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

	public Date getbDay() {
		return bDay;
	}

	public void setbDay(Date bDay) {
		this.bDay = bDay;
	}

	public String getRegisterError() {
		return registerError;
	}

	public void setRegisterError(String registerError) {
		this.registerError = registerError;
	}
	
}