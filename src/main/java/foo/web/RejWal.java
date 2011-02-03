package foo.web;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import foo.service.NotatkaManager;


@RequestScoped
@ManagedBean
public class RejWal{

	@Inject
	NotatkaManager notatkaManager; 
	
	//@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		String login = (String) value;
		
			if(login.length() > 0 && notatkaManager.getUser(login)!=null) {
				((UIInput) component).setValid(false);
				FacesMessage message = new FacesMessage("U¿ytkownik o takim loginie jest ju¿ zarejestrowany.");
				context.addMessage(component.getClientId(), message);		
				throw new ValidatorException(message);
			}
	}

}
