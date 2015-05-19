package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Provider {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JoinColumn(nullable = false)
	private Long vatin;
	
	
	private String phoneNumber;
	
	@JoinColumn(nullable = false)
	private String email;

	@JoinColumn(nullable = false)
	private String name;
	
	@OneToOne
	private Address address;
	
	@ManyToMany
	private List<Product> products;
	
	public Provider() {
		
	}
	
	public Provider(Long vatin, String phoneNumber, String email, String name) {
		this.vatin = vatin;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.name = name;
		this.products = new ArrayList<>();
	}
	
	public Long getVatin() {
		return vatin;
	}

	public void setVatin(Long vatin) {
		this.vatin = vatin;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
