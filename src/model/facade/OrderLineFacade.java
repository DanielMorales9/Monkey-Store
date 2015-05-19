package model.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Order;
import model.OrderLine;
import model.Product;

@Stateless(name="olFacade")
public class OrderLineFacade {

	@PersistenceContext(unitName="unit-project")
	private EntityManager em;
	
	public List<OrderLine> listOrderLines(Long id) {
		List<OrderLine> orderLines = 
				this.em.find(Order.class, id).getOrderLines();
		return orderLines;
	}
	
	public OrderLine addOrderLineToOrder(Long id, Product product, Integer quantity) {
		OrderLine ol = new OrderLine(product, quantity);
		Order order = this.em.find(Order.class, id);
		order.addOrderLine(ol);
		this.em.persist(order);
		return ol;
	}
	
	public OrderLine removeOrderLines(OrderLine orderLine) {
		this.em.remove(orderLine);
		return orderLine;
	}
	
	
}
