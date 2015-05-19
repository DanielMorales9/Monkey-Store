package model.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import exception.InvalidEmailException;
import exception.InvalidPasswordException;
import model.Customer;
import model.Order;
import model.Product;

@Stateless(name="cFacade")
public class CustomerFacade {

	@PersistenceContext(unitName="unit-project")
	private EntityManager em;
	private Order currentOrder;

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

	public List<Product> getAllProducts() {
		CriteriaQuery<Product> cq = em.getCriteriaBuilder().createQuery(Product.class);
		cq.select(cq.from(Product.class));
		List<Product> products = em.createQuery(cq).getResultList();
		return products;
	}

	public Customer findCustomerById(Long idCustomer) {
		return this.em.find(Customer.class, idCustomer);
	}
	public List<Product> createNewOrder(Customer customer) {
		this.setCurrentOrder(new Order(customer));		
		return getAllProducts();
	}

	public Product getProduct(Long id) {
		Product product = em.find(Product.class, id);
		return product;
	}

	public Order getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}

	public void addProductToOrder(Long id, Integer quantity) {
		Product product = this.em.find(Product.class, id);
		currentOrder.createOrderLine(product, quantity);
	}


}
