package model.facade;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import exception.InvalidEmailException;
import exception.InvalidPasswordException;
import model.Customer;

@Stateless(name="cFacade")
public class CustomerFacade {
	
	@PersistenceContext(unitName="unit-project")
	private EntityManager em;
	
	public Customer loginCustomer(String email, String password)
			throws InvalidEmailException, InvalidPasswordException {
		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c where c.email =:email", Customer.class);
		query.setParameter("email", email);
		Customer customer = query.getSingleResult();
		if (customer == null) {
			throw new InvalidEmailException();
		}
		customer.checkPassword(password);
		return customer;	
	}
	
	public Customer createNewCustomer(String email, String password, String firstName, String lastName, Date bDay) {
		Customer customer = new Customer(firstName, lastName, email, password, bDay);
		this.em.persist(customer);
		return customer;
	}
	
}
