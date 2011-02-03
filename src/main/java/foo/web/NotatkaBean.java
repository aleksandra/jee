package foo.web;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import foo.domain.Notatka;
import foo.service.NotatkaManager;

@RequestScoped
@Named
public class NotatkaBean {//implements Serializable {

//	private static final long serialVersionUID = 1L;

	@Inject
	NotatkaManager notatkaManager;
	
	@Inject
	LogBean logBean;
	
	private Date data;
	private String tresc;
	private long id;
	private String userLogin;
	
	private Date dzis = new Date();
	private String widok = "aktualne";
	private List<String> widokList;
	private String[] widoki = {"aktualne","archiwum"};
	
	public NotatkaBean() {
		widokList = new ArrayList<String>();
		for(String w:widoki){
			widokList.add(w);
		}
		
	}
	
	public List<String> getWidokList() {
		return widokList;
	}
	
	public String getWidok() {
		return widok;
	}

	public void setWidok(String widok) {
		this.widok = widok;
	}

	public Date getDzis() {
		return dzis;
	}
	
	@NotNull(message="podaj datê.")
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	@NotEmpty (message="po co Ci pusta notatka?")
	public String getTresc() {
		return tresc;
	}
	public void setTresc(String tresc) {
		this.tresc = tresc;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	//akcje
	
	
	public List<Notatka> getWszystkieNotatkiPrzyszle() {
		return notatkaManager.pobierzWszystkieNotatkiPrzyszle(logBean.getLogin());
	}
	
	public List<Notatka> getWszystkieNotatkiPrzeszle() {
		return notatkaManager.pobierzWszystkieNotatkiPrzeszle(logBean.getLogin());
	}
	
	public List<Long> getWszystkieId() {
		return notatkaManager.pobierzWszystkieId(logBean.getLogin());
	}
	
	public String wykonajDodawanie(){
		notatkaManager.dodajNotatke(data, tresc, logBean.getLogin());
		return null;
	}
	
	public String wykonajUsuwanie(){	
		notatkaManager.usunNotatke(id);
		return null;
	}
	
	public String getSuma(){
		return notatkaManager.suma(logBean.getLogin(), 3);
	}
	public String getSumaArch(){
		return notatkaManager.suma(logBean.getLogin(), 1);
	}
	public String getSumaTerm(){
		return notatkaManager.suma(logBean.getLogin(), 2);
	}
	
}
