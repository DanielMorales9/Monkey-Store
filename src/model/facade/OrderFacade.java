package model.facade;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Customer;
import model.Order;


@Stateless(name = "oFacade")
public class OrderFacade {
	
	@PersistenceContext(unitName="unit-project")
	private EntityManager em;
	
	public Order getOrder(Long id){
		Order order = em.find(Order.class, id);
		return order;
	}
	
	public Customer getCustomer(Long id){
		Order order = this.getOrder(id); 
		Customer customer = order.getCustomer();
		return customer;
		
	}
}