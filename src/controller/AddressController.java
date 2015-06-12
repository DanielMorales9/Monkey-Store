package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Address;
import model.Customer;
import model.facade.AddressFacade;
import controller.session.CustomerSessionController;


@ManagedBean(name="addressController")
public class AddressController {
	

	@EJB(beanName="addressFacade")
	private AddressFacade addressFacade;
	
	/**
	 * Managed Properties
	 */
	@ManagedProperty(value="#{customerSession}")
	private CustomerSessionController session;
	
	private Address address;
	
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String country;

	
	public String createAddress(){				
		Long id = session.getCustomer().getId();
		Customer customer = addressFacade.
				createAddress(id, street, city, state, zipcode, country);
		session.setCustomer(customer);
		return "customerArea.jsp";
	}


	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	public CustomerSessionController getSession() {
		return session;
	}
	
	public void setSession(CustomerSessionController session) {
		this.session = session;
	}
}
