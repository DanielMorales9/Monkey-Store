package model.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import model.Address;
import model.Customer;

@Stateless(name="addressFacade")
public class AddressFacade {
	
	@PersistenceContext(unitName="unit-project")
	private EntityManager em;
	
	public Address findAddressById(Long id) {
		Address address = this.em.find(Address.class, id);
		return address;
	}
	

	public List<Address> listAddreses() {
		CriteriaQuery<Address> cq = em.getCriteriaBuilder().createQuery(Address.class);
		cq.select(cq.from(Address.class));
		List<Address> addresses = em.createQuery(cq).getResultList();
		return addresses;
	}
	
	public Address removeAddressById(Long id) {
		Address address = this.em.find(Address.class, id);
		this.em.remove(address);
		return address;
	}
	
	public Customer createAddress(Long id, String street, String city, String state, String zipcode, String country) {
		Customer customer = this.em.find(Customer.class, id);
		Address address = new Address(street, city, state, zipcode, country);
		customer.setAddress(address);
		this.em.persist(address);
		return customer;
	}

}
