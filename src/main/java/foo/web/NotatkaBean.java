package foo.web;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import foo.domain.Notatka;
import foo.service.NotatkaManager;

@SessionScoped
@Named
public class NotatkaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	NotatkaManager notatkaManager;
	
	private Date data;
	private String tresc;
	private long id;
	
	private Date dzis = new Date();
	
	
	
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
	public List<Notatka> getWszystkieNotatki() {
		return notatkaManager.pobierzWszystkieNotatki();
	}
	
	public List<Long> getWszystkieId() {
		return notatkaManager.pobierzWszystkieId();
	}
	
	public List<String> getWszystkieDaty() {
		return notatkaManager.pobierzWszystkieDaty();
	}
	
	public List<Notatka> getNotatkiWgDaty() {
		return notatkaManager.pobierzNotatki(data);
	}
	
	public String wykonajDodawanie(){
		
		
		notatkaManager.dodajNotatke(data,tresc);
		return null;
	}
	
	public String wykonajUsuwanie(){
		notatkaManager.usunNotatke(id);
		return null;
	}
	
	public String getSuma(){
		return notatkaManager.suma();
		
	}
	
	
	
}
