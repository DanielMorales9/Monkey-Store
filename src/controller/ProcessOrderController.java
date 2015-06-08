package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Order;
import model.facade.OrderFacade;

@ManagedBean(name="processOrderController")
public class ProcessOrderController {
	
	@EJB(name="oFacade")
	private OrderFacade orderFacade;
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private Order order;
	private List<Order> ordersToProcess;
	
	public String findOrdersToProcess(){
		this.ordersToProcess = orderFacade.findOrdersToProcess();
		return "processOrder";
	}
	
	public String processOrder(){
		this.order = orderFacade.processOrder(id);
		return "orderProcessed";
	}

	public List<Order> getOrdersToProcess() {
		return ordersToProcess;
	}

	public void setOrdersToProcess(List<Order> ordersToProcess) {
		this.ordersToProcess = ordersToProcess;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
