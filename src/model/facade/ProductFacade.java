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
		Product product = new Product(name, code, description, price);
		em.persist(product);
		return product;
	}
	
	public Product getProduct(Long id) {
	    Product product = em.find(Product.class, id);
		return product;
	}
	
	public List<Product> getAllProducts() {
        CriteriaQuery<Product> cq = em.getCriteriaBuilder().createQuery(Product.class);
        cq.select(cq.from(Product.class));
        List<Product> products = em.createQuery(cq).getResultList();
		return products;
	}
}
