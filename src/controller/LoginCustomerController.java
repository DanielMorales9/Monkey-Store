package controller;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import model.Customer;
import model.facade.CustomerFacade;
import exception.InvalidEmailException;
import exception.InvalidPasswordException;

@ManagedBean
public class LoginCustomerController {
	
	@EJB(beanName="cFacade")
	private CustomerFacade customerFacade;
	private String password;
	private String email;
	private Customer customer;
	private String loginError;
	private String firstName;
	private String lastName;
	private Date bDay;
	private String registerError;
	
	public String loginCustomer() {
		try {
			setCustomer(customerFacade.loginCustomer(email, password));
		}
		catch (InvalidPasswordException | InvalidEmailException e) {
			setLoginError("Email or Password is not valid");
			return "loginCustomer";
		}
		catch (Exception e) {
			return "error";
		}
		return "customerArea";
	}
	
	public String registerNewCustomer() {
		try {
			customer = customerFacade.createNewCustomer(email, password, firstName, lastName, bDay);
		} catch (Exception e) {
			registerError ="Email already registered";
			return "signupCustomer";
		}
		return "customerArea";
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
	
	public Date getbDay() {
		return bDay;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getRegisterError() {
		return registerError;
	}

	public void setbDay(Date bDay) {
		this.bDay = bDay;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setCustomerFacade(CustomerFacade customerFacade) {
		this.customerFacade = customerFacade;
	}
	public void setRegisterError(String registerError) {
		this.registerError = registerError;
	}

}
