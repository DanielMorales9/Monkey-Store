package controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import model.Order;
import model.facade.OrderFacade;

@ManagedBean(name="processOrderController")
@RequestScoped  //recreated on every new request 
public class ProcessOrderController {
	
	@EJB(name="oFacade")
	private OrderFacade orderFacade;
	
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	
	private List<Order> ordersToProcess;
	
	@PostConstruct //fetches the orders to process as soon as is injected
	public void findOrdersToProcess() {
		this.ordersToProcess = orderFacade.findOrdersToProcess();
	}
	
	public String processOrder() {
		this.id = orderFacade.processOrder(id);
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


}
