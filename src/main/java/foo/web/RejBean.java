package foo.web;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import foo.service.NotatkaManager;
import foo.domain.User;


@RequestScoped
@Named
public class RejBean{

	
	@Inject
	NotatkaManager notatkaManager;
	
	private String login;
	private String imie;
	private String haslo;
	
	@NotEmpty(message="podaj login.")
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	@NotEmpty(message="podaj imi�.")
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	
	@Length(min=5, max=10, message="podaj has�o (od 5 do 10 znak�w).")
	public String getHaslo() {
		return haslo;
	}
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	
	//akcje
	public String wykonajDodawanie(){
		notatkaManager.dodajUsera(login, imie.replaceFirst(imie.substring(0,1), imie.substring(0,1).toUpperCase()), haslo);
		return "first";
	}
	
	public List<User> getWszystkie(){
		return notatkaManager.pobierzUserow();
	}
	
}
