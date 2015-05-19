package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="orders")
public class Order {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Temporal(value=TemporalType.TIMESTAMP)
	private Date creationDate;

	private Date evasionDate;

	private Date closingDate;

	@ManyToOne
	private Customer customer;

	@OneToMany(fetch=FetchType.EAGER, 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name="orders_id")
	private List<OrderLine> orderLines;

	public Order() {

	}

	public Order(Customer customer) {
		this.customer = customer;
		this.creationDate = new Date();
		this.orderLines = new ArrayList<OrderLine>();
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getEvasionDate() {
		return evasionDate;
	}
	public void setEvasionDate(Date evasionDate) {
		this.evasionDate = evasionDate;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public OrderLine createOrderLine(Product product, Integer quantity) {
		OrderLine ol = new OrderLine(product, quantity);
		this.orderLines.add(ol);
		return ol;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public void addOrderLine(OrderLine ol) {
		this.orderLines.add(ol);
	}


}
