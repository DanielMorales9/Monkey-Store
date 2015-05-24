package model.facade;

import java.util.List;



import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import model.Customer;
import model.Order;

@Stateless(name="oFacade")
public class OrderFacade {
	
	@PersistenceContext(unitName="unit-project")
	private EntityManager em;
	
	public Order findOrderById(Long id) {
		Order order = this.em.find(Order.class, id);
		order.getOrderLines();				//ATTENZIONE:se l ordine è nullo da errore
		return order;
	}
	
	public List<Order> listOrders() {
		CriteriaQuery<Order> cq = em.getCriteriaBuilder().createQuery(Order.class);
		cq.select(cq.from(Order.class));
		List<Order> orders = em.createQuery(cq).getResultList();
		return orders;
	}
	
	public Order removeOrderById(Long id) {
		Order order = this.em.find(Order.class, id);
		this.em.remove(order);
		return order;
	}
	
	public Order createOrder(Long id) {
		Customer customer = this.em.find(Customer.class, id);
		Order order = new Order(customer);
		customer.addOrder(order);
		this.em.persist(order);
		this.em.merge(customer);
		return order;
	}

	public List<Order> listCustomerOrders(Long customerId) {
		Customer customer = this.em.find(Customer.class, customerId);
		return customer.getOrders();
	}
	
	public Customer getCustomerFromOrderId(Long id) throws Exception{
//		Order order = this.findOrderById(id);
		Order order = this.em.find(Order.class, id);
		if(order == null)
			return null;
		Customer customer = order.getCustomer();
		return customer;
	}
}
