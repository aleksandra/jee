package foo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import foo.domain.Notatka;


@Stateless
public class NotatkaManager {

	@PersistenceContext
	EntityManager em;
	
	public void dodajNotatke(Date data, String tresc){
		Notatka notatka = new Notatka();
		
		notatka.setData(data);
		notatka.setTresc(tresc);
		
		em.persist(notatka);
	}
	
	public List<Notatka> pobierzWszystkieNotatki() {		
		return em.createQuery("SELECT n FROM Notatka n ORDER BY n.data").getResultList();
	}
	
	public List<Notatka> pobierzWszystkieNotatkiPrzeszle() {		
		return em.createQuery("SELECT n FROM Notatka n WHERE n.data < CURRENT_DATE ORDER BY n.data").getResultList();
	}
	
	public List<Notatka> pobierzWszystkieNotatkiPrzyszle() {		
		return em.createQuery("SELECT n FROM Notatka n WHERE n.data >= CURRENT_DATE ORDER BY n.data").getResultList();
	}
	
	public List<Long> pobierzWszystkieId() {		
		return em.createQuery("SELECT n.id FROM Notatka n ").getResultList();
	}
	
	public List<String> pobierzWszystkieDaty() {		
		return em.createQuery("SELECT n.data FROM Notatka n GROUP BY n.data").getResultList();
	}
	
	public List<Notatka> pobierzNotatki(Date data){		
		return em.createQuery("SELECT n FROM Notatka n WHERE n.data='" + data + "'").getResultList();		
	}
	
	public List<Notatka> pobierzNotatke(long id) {
		return em.createQuery("SELECT n FROM Notatka n where n.id='" + id + "'").getResultList();
	}
	
	public void usunNotatke(long id) {
		Notatka notatka = em.find(Notatka.class, id);
		em.remove(notatka);
	}
	
	public String suma(int i) {
		if (i == 3) {	//suma wszystkie
			return em.createQuery("SELECT Count(n) FROM Notatka n").getSingleResult().toString();
		}
		if (i== 2) {	//suma term
			return em.createQuery("SELECT Count(n) FROM Notatka n WHERE n.data >= CURRENT_DATE").getSingleResult().toString();
		}
		else  {//(i == 1) suma arch
			return em.createQuery("SELECT Count(n) FROM Notatka n WHERE n.data < CURRENT_DATE").getSingleResult().toString();
		}
	}	
	
	/*public String sumaArch() {
		return em.createQuery("SELECT Count(n) FROM Notatka n WHERE n.data < CURRENT_DATE").getSingleResult().toString();
	}
	public String sumaTerm() {
		return em.createQuery("SELECT Count(n) FROM Notatka n WHERE n.data >= CURRENT_DATE").getSingleResult().toString();
	}*/
	
	
	
}
