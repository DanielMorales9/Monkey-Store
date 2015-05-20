package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Customer {

	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false, unique=true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	@Temporal(value=TemporalType.DATE)
	private Date birthDay;
		
	@Column(nullable = false)
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date registrationDate;
	
	@OneToMany(mappedBy="customer")
	private List<Order> orders;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	private Address address;

	public Customer() {

	}

	public Customer(String firstName, String lastName, String email, String password, Date birthDay ) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.birthDay = birthDay;
		this.registrationDate = new Date();
		this.orders = new ArrayList<Order>();		
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

	public Date getBirthDay() {
		return birthDay;
	}
	
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void checkPassword(String password) throws Exception {
		if (!this.password.equals(password)) {
			throw new Exception();
		}
	}

	public void addOrder(Order order) {
		this.orders.add(order);
	}


}
