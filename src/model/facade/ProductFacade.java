package model.facade;

import model.Product;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
@Stateless(name="pFacade")
public class ProductFacade {
	
	@PersistenceContext(unitName = "unit-project")
    private EntityManager em;
    
	public Product createProduct(String name, String code, Float price, String description) {
		Product product = new Product(name, description, code, price);
		em.persist(product);
		return product;
	}
	
	public Product findProductById(Long id) {
	    Product product = em.find(Product.class, id);
		return product;
	}
	
	public List<Product> listProducts() {
        CriteriaQuery<Product> cq = em.getCriteriaBuilder().createQuery(Product.class);
        cq.select(cq.from(Product.class));
        List<Product> products = em.createQuery(cq).getResultList();
		return products;
	}
	
	public Product removeProduct(Product product) {
		this.em.remove(product);
		return product;
	}
	
	public Product removeProductById(Long id) {
		Product product = this.em.find(Product.class, id);
		this.em.remove(product);
		return product;
	}
	
}
