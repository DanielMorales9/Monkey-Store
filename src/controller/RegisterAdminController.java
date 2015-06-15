package controller;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Admin;
import model.facade.AdminFacade;
import controller.session.AdminSessionController;

@ManagedBean(name="registerAdmin")
public class RegisterAdminController {
	@EJB(beanName="aFacade")
	private AdminFacade facade;

	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	

	private String registerError;

	@ManagedProperty(value="#{adminSession}")
	private AdminSessionController session;

	public String registerAdmin() {
		if(!facade.existsEmail(email)) {
			Admin admin = 
					facade.createAdmin(firstName, lastName, email, password);
			session.setAdmin(admin);
			return "adminArea.xhtml";
		}
		else {
			setRegisterError("Email already exists");
			return "registerAdmin.xhtml";
		}
	}	

	/**
	 * -----------------
	 * GETTER AND SETTER
	 * -----------------
	 */

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRegisterError() {
		return registerError;
	}

	public void setRegisterError(String registerError) {
		this.registerError = registerError;
	}

	public AdminSessionController getSession() {
		return session;
	}

	public void setSession(AdminSessionController session) {
		this.session = session;
	}
}
