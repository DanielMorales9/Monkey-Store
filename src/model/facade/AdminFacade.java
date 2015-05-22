package model.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import model.Admin;


@Stateless(name="aFacade")
public class AdminFacade {
	
	@PersistenceContext(unitName="unit-project")
	private EntityManager em;
	
	public Admin createAdmin(String firstName, String lastName, String email, String password) {
		Admin admin = new Admin(firstName, lastName, email, password);
		this.em.persist(admin);
		return admin;
	}
	
	public List<Admin> listAdmin() {
		CriteriaQuery<Admin> cq = em.getCriteriaBuilder().createQuery(Admin.class);
		cq.select(cq.from(Admin.class));
		List<Admin> adminList = em.createQuery(cq).getResultList();
		return adminList;
	}
	
	public Admin retrieveAdminByEmailAndPassword(String email, String password)
			throws Exception {
		TypedQuery<Admin> query = em.createQuery(
				"SELECT a FROM Admin a where a.email =:email", Admin.class);
		query.setParameter("email", email);
		Admin admin = query.getSingleResult();
		if (admin == null) {
			throw new Exception();
		}
		admin.checkPassword(password);
		return admin;	
	}
	
	public Admin findAdminById(Long id) {
		Admin admin = this.em.find(Admin.class, id);
		return admin;
	}
	
	public Admin removeAdmin(Admin admin) {
		this.em.remove(admin);
		return admin;
	}
	
	public Admin removeAdminById(Long id) {
		Admin admin = this.em.find(Admin.class, id);
		this.em.remove(admin);
		return admin;
	}
	
	public boolean existsEmail(String email) {
		TypedQuery<Admin> query = em.createQuery("SELECT a FROM Admin a where a.email =:email", Admin.class);
		query.setParameter("email", email);
		return query.getResultList().size() != 0;
	}
}
