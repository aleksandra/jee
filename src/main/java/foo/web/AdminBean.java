package foo.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import foo.domain.Notatka;
import foo.domain.User;
import foo.service.NotatkaManager;

@RequestScoped
@Named
public class AdminBean {

	@Inject
	NotatkaManager notatkaManager;
	
	private Date data;
	private String tresc;
	private long id;
	private String userLogin;
	private List<Long> idList;

	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
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
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	
	public List<Long> getIdList() {
		return idList;
	}
	public void setIdList(List<Long> idList) {
		this.idList = (List<Long>) idList;
	}
	//akcje
	public List<Notatka> getWszystkieNotatki() {
		return notatkaManager.pobierzWszystkieNotatki();
	}
	
	public List<Long> getWszystkieId() {
		return notatkaManager.pobierzWszystkieId();
	}
	public List<String> getWszystkieLoginy() {
		
		List<String> n = notatkaManager.pobierzWszystkieLoginy();
		n.remove(0);
		return n;
	}
	
	public String wykonajUsuwanie(){
		//for(Long i:idList){
			notatkaManager.usunNotatke(id);
		//}
		return null;
	}
	
	public String wykonajUsuwanieU(String l){
			notatkaManager.usunUsera(l);
		return null;
	}
	
	public String getSumaNotatek(){
		return notatkaManager.suma();
	}
	
	public String getSumaUserow(){
		return notatkaManager.sumaUserow();
	}
	
	public List<User> getWszyscyUser(){
		List<User> n= notatkaManager.pobierzUserow();
		n.remove(0);
		return n;
	}
	
}
