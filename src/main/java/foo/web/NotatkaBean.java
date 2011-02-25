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
	
	private String czyEdycja = "Notuj";
	
	
	
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
	
	public String getCzyEdycja() {
		return czyEdycja;
	}

	public void setCzyEdycja(String czyEdycja) {
		this.czyEdycja = czyEdycja;
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
		return "terminarz";
	}
	
	public String wykonajUsuwanie(long i){	
		notatkaManager.usunNotatke(i);
		return null;
	}
	
	public String wlaczEdycje(long i, Date d, String t) {
		id = i;
		data = d;
		tresc = t;
		czyEdycja = "Edytuj";
		return null;
	}
	
	public String wykonajEdycje(long i) {
		notatkaManager.edytujNotatke(i,data,tresc);
		id = 0;
		return null;
	}
	
	public String wykonaj(long i) {
		System.out.println(i);
		if(i == 0) wykonajDodawanie();
		else wykonajEdycje(i);
		return null;
	}
	
	public String getSuma(){
		return notatkaManager.suma(logBean.getLogin(), 3);
	}
	public String getSuma(String login){
		return notatkaManager.suma(login, 3);
	}
	public String getSumaArch(){
		return notatkaManager.suma(logBean.getLogin(), 1);
	}
	public String getSumaTerm(){
		return notatkaManager.suma(logBean.getLogin(), 2);
	}
	
}
