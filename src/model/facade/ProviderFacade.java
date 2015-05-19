package model.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import model.Provider;

@Stateless(name="prFacade")
public class ProviderFacade {

	@PersistenceContext(unitName="unit-project")
	private EntityManager em;
	
	public Provider createProvider(Long vatin, String phoneNumber, String email, String name) {
		Provider provider = new Provider(vatin, phoneNumber, email, name);
		this.em.persist(provider);
		return provider; 
	}
	
	public List<Provider> listProviders()  {
		CriteriaQuery<Provider> cq = em.getCriteriaBuilder().createQuery(Provider.class);
		cq.select(cq.from(Provider.class));
		List<Provider> providers = em.createQuery(cq).getResultList();
		return providers;
	}
	
	public Provider removeProvider(Provider provider) {
		this.em.remove(provider);
		return provider;
	}
	
	public Provider removeProviderById(Long id) {
		Provider provider = this.em.find(Provider.class, id);
		this.em.remove(provider);
		return provider;
	}
	
	public Provider findProviderById(Long id) {
		Provider provider = this.em.find(Provider.class, id);
		return provider;
	}
	
}
