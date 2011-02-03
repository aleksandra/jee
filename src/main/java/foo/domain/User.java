package foo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQuery(name="user.all", query="from User")
public class User {
	
	private String login;
	private String imie;
	private String haslo;
	
	private List<Notatka> notatki;
	
	@Id
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
	
	public String getHaslo() {
		return haslo;
	}
	
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	@OneToMany(mappedBy="user", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	public List<Notatka> getNotatki() {
		return notatki;
	}

	public void setNotatki(List<Notatka> notatki) {
		this.notatki = notatki;
	}

}
