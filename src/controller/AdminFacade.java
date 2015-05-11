package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Product;


//TODO x Daniel: spostala nel package opportuno
@Stateless(name="adminFacade")
public class AdminFacade {
	
	@PersistenceContext(unitName="unit-project")
	private EntityManager em;
	
//	private Admin currentAdmin;
	
	public Product createNewProduct(String name, String description, String code,
			Float price/*, Admin currentAdmin*/) {
		Product p = new Product(name, description, code, price/*, currentAdmin*/);
		return p;
	}
}
