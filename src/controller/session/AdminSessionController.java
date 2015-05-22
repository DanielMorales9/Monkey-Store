package controller.session;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Admin;



@ManagedBean(name="adminSession")
@SessionScoped
public class AdminSessionController {

	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	

}
