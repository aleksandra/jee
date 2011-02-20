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
public class WidokAdmin implements Serializable{

	private static final long serialVersionUID = 1L;


	@Inject
	NotatkaManager notatkaManager;

	
	private String widok = "notatki";
	private List<String> widokList;
	private String[] widoki = {"notatki","u¿ytkownicy"};
	
	
	
	public WidokAdmin() {
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
