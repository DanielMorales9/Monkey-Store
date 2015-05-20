package model.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import model.Customer;


@Stateless(name="cFacade")
public class CustomerFacade {

	@PersistenceContext(unitName="unit-project")
	private EntityManager em;

	public Customer retrieveCustomerByEmailAndPassword(String email, String password)
			throws Exception {
		TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c where c.email =:email", Customer.class);
		query.setParameter("email", email);
		Customer customer = query.getSingleResult();
		if (customer == null) {
			throw new Exception();
		}
		customer.checkPassword(password);
		customer.getOrders();
		return customer;	
	}

	public Customer createCustomer(String email, String password, String firstName, String lastName, Date bDay) {
		Customer customer = new Customer(firstName, lastName, email, password, bDay);
		this.em.persist(customer);
		return customer;
	}

	public Customer findCustomerById(Long idCustomer) {
		return this.em.find(Customer.class, idCustomer);
	}

	public void removeCustomer(Customer customer) {
		this.em.remove(customer);
	}

	public List<Customer> listCustomers() {	
		CriteriaQuery<Customer> cq = em.getCriteriaBuilder().createQuery(Customer.class);
		cq.select(cq.from(Customer.class));
		List<Customer> customers = em.createQuery(cq).getResultList();
		return customers;
	}

	public boolean existsEmail(String email) {
			TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c where c.email =:email", Customer.class);
			query.setParameter("email", email);
			return query.getResultList().size() != 0;
 	}


}
