package foo.web;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;

import foo.service.NotatkaManager;

@RequestScoped
@ManagedBean
public class LogWal {
	
	@Inject
	NotatkaManager notatkaManager;

	public void validateLoginHaslo(ComponentSystemEvent e) {
		
		UIForm form = (UIForm) e.getComponent();
		
		UIInput loginInput = (UIInput) form.findComponent("login");
		UIInput hasloInput = (UIInput) form.findComponent("haslo");
		
		String login = (String) loginInput.getValue();
		String haslo = (String) hasloInput.getValue();
				
		if(login != null && notatkaManager.getUser(login)==null) {
			loginInput.setValid(false);
			FacesContext fc = FacesContext.getCurrentInstance();
			  FacesMessage message = new FacesMessage("Takiego loginu nie ma w bazie (zarejestruj siê).");
			  fc.addMessage(loginInput.getClientId(), message);	  
		}	
		else if(login != null && haslo != null && !notatkaManager.getUser(login).getHaslo().equals(haslo) ) {
			hasloInput.setValid(false);
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage("Niepoprawne has³o.");
			fc.addMessage(hasloInput.getClientId(), message);	
		}
	}
}