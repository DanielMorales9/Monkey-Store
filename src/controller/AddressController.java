package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Address;
import model.facade.AddressFacade;
import controller.session.CustomerSessionController;


@ManagedBean(name="addressController")
public class AddressController {
	

	@EJB(beanName="aFacade")
	private AddressFacade facade;
	
	/**
	 * Managed Properties
	 */
	@ManagedProperty(value="#{customerSession}")
	private CustomerSessionController session;
	
	private Address address;
	
	@ManagedProperty(value="#{param.id}")
	private String id;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	
	public String addAddress(){
		if(session.getCustomer().getAddress() == null)
			return "addAddress";
		else 
			return "addressDetails";									
	}
	
	public String createAddress(){				
		facade.createAddress(session.getCustomer().getId(), street, city, state, zipcode, country);
		return "addressDetails";
	}
	
	public CustomerSessionController getSession() {
		return session;
	}

	public void setSession(CustomerSessionController session) {
		this.session = session;
	}

	public AddressFacade getFacade() {
		return facade;
	}

	public void setFacade(AddressFacade facade) {
		this.facade = facade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
}
