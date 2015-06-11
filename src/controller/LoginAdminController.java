package controller;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import model.Admin;
import model.facade.AdminFacade;
import controller.session.AdminSessionController;

@ManagedBean(name="loginAdmin", eager=true)
public class LoginAdminController {
	
		
		@EJB(beanName="aFacade")
		private AdminFacade facade;
		
		@ManagedProperty(value="#{adminSession}")
		private AdminSessionController session;
		
		@ManagedProperty(value = "#{processOrderController}")
		private ProcessOrderController poc;
		

		private String email;
		private String password;
		
		private String loginError;

		
		public String loginAdmin() {
			try {
				Admin admin = facade.retrieveAdminByEmailAndPassword(email, password);
				session.setAdmin(admin);
				
			} catch (Exception e) {
				loginError = "Email or Password is not valid";
				return "loginAdmin.jsp";
			}
			return "adminArea.jsp";
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
		
		public String getLoginError() {
			return loginError;
		}
		public void setLoginError(String loginError) {
			this.loginError = loginError;
		}

		public AdminSessionController getSession() {
			return session;
		}

		public void setSession(AdminSessionController session) {
			this.session = session;
		}
		
		public ProcessOrderController getPoc() {
			return poc;
		}

		public void setPoc(ProcessOrderController poc) {
			this.poc = poc;
		}
}
