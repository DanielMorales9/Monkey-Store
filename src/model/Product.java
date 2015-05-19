package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Product {
	
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@JoinColumn(nullable = false)
	private String name;
	
	@JoinColumn(nullable = false)
	private String description;
	
	@JoinColumn(nullable = false)
	private Float price;
	
	@JoinColumn(nullable = false)
	private String code;
	
	@JoinColumn(nullable = false)
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@ManyToMany(mappedBy="products")
	private List<Provider> providers;
	
	public Product() {
		
	}
	
	public Product(String name, String description, String code, Float price) {
		this.name = name;
		this.description = description;
		this.code = code;
		this.price = price;
		this.creationDate = new Date();
		this.providers = new ArrayList<>();
	}
	
	public List<Provider> getProviders() {
		return providers;
	}
	
	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
