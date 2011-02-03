package foo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.constraints.NotEmpty;

import foo.service.NotatkaManager;

@SessionScoped
@Named
public class LogBean implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Inject
	NotatkaManager notatkaManager;

	private String login;
	private String imie ;
	private String haslo;
	
	@NotEmpty(message="podaj login")
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	@NotEmpty(message="podaj has³o")
	public String getHaslo() {
		return haslo;
	}
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}
	
	public String loguj(){
		imie = notatkaManager.getUser(login).getImie();
		if (login.equals("admin"))
			return "admin";
		else
			return "terminarz";
		
	}
	
	public String wyloguj() {
		login=null;
		imie=null;
		haslo=null;
		return "first";
	}
	
	public boolean isLogged() {
		if(login!=null)
			return true;
		else
			return false;
	}
	
}
