package foo.web;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import foo.service.NotatkaManager;

@SessionScoped
@Named
public class Widok implements Serializable{

	private static final long serialVersionUID = 1L;


	@Inject
	NotatkaManager notatkaManager;

	
	private String widok = "aktualne";
	private List<String> widokList;
	private String[] widoki = {"aktualne","archiwum"};
	
	public Widok() {
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
	
}
