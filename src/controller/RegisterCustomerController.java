package controller;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import controller.session.CustomerSessionController;
import model.Address;
import model.Customer;
import model.facade.CustomerFacade;


@ManagedBean(name="registerCustomer")
public class RegisterCustomerController {

	@EJB(beanName="cFacade")
	private CustomerFacade facade;

	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Date birthDay;
	private Address address;

	private String registerError;

	@ManagedProperty(value="#{customerSession}")
	private CustomerSessionController session;

	public String registerCustomer() {
		if(!facade.existsEmail(email)) {
			Customer customer = 
					facade.createCustomer(email, password, firstName, lastName, birthDay);
			session.setCustomer(customer);
			return "customerArea.jsp";
		}
		else {
			setRegisterError("Email already exists");
			return "registerCustomer";
		}
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

	public String getRegisterError() {
		return registerError;
	}

	public void setRegisterError(String registerError) {
		this.registerError = registerError;
	}

	public CustomerSessionController getSession() {
		return session;
	}

	public void setSession(CustomerSessionController session) {
		this.session = session;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
