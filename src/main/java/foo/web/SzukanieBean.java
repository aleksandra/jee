package foo.web;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import foo.domain.Notatka;
import foo.service.NotatkaManager;


@SessionScoped
@Named
public class SzukanieBean implements Serializable{

	private static final long serialVersionUID = 1L;


	@Inject
	NotatkaManager notatkaManager;
	
	@Inject
	LogBean logBean;

	private String fraza;
	private String data;
	
	public String getFraza() {
		return fraza;
	}

	public void setFraza(String fraza) {
		this.fraza = fraza;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Notatka> getWykonajSzukanie() {
		return notatkaManager.szukaj(logBean.getLogin(), fraza, data);
	}

}
