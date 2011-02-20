package foo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import foo.domain.Notatka;
import foo.domain.User;

@Stateless
public class NotatkaManager {

	@PersistenceContext
	EntityManager em;
	
	//terminarz
	public void dodajNotatke(Date data, String tresc, String userLogin){
		User user = new User();
		user.setLogin(userLogin);
		
		Notatka notatka = new Notatka();
		notatka.setData(data);
		notatka.setTresc(tresc);
		
		List<Notatka> notatki = new ArrayList<Notatka>();
		notatki.add(notatka);
		
		user.setNotatki(notatki);
		notatka.setUser(user);
		
		em.persist(notatka);
	}
	
	public List<Notatka> pobierzWszystkieNotatki() {
		
		return em.createQuery("SELECT n FROM Notatka n WHERE ORDER BY n.user, n.data").getResultList();
	}
	
	public List<Notatka> pobierzWszystkieNotatkiPrzeszle(String login) {
		
		return em.createQuery("SELECT n FROM Notatka n WHERE n.user = '"+login+"' AND n.data < CURRENT_DATE ORDER BY n.data").getResultList();
	}
	
	public List<Notatka> pobierzWszystkieNotatkiPrzyszle(String login) {
		
		return em.createQuery("SELECT n FROM Notatka n WHERE n.user = '"+login+"' AND n.data >= CURRENT_DATE ORDER BY n.data").getResultList();
	}
	
	public List<Long> pobierzWszystkieId(String login) {		
		return em.createQuery("SELECT n.id FROM Notatka n WHERE n.user='"+login+"'").getResultList();
	}
		
	public void usunNotatke(long id) {
		Notatka notatka = em.find(Notatka.class, id);
		em.remove(notatka);
	}
	
	public void edytujNotatke(long id, Date data, String tresc) {
		Notatka notatka = em.find(Notatka.class, id);
		notatka.setTresc(tresc);
		notatka.setData(data);
		em.merge(notatka);
	}
	
	public String suma(String login, int i) {
		
		if (i == 3) {	//suma wszystkie
			return em.createQuery("SELECT Count(n) FROM Notatka n WHERE n.user ='"+login+"'").getSingleResult().toString();
		}
		if (i== 2) {	//suma term
			return em.createQuery("SELECT Count(n) FROM Notatka n WHERE n.user ='"+login+"' AND n.data >= CURRENT_DATE").getSingleResult().toString();
		}
		else  {//(i == 1) suma arch
			return em.createQuery("SELECT Count(n) FROM Notatka n WHERE n.user ='"+login+"' AND n.data < CURRENT_DATE").getSingleResult().toString();
		}
	}
	
	public List<Notatka> szukaj(String login, String fraza, String data) {
		return em.createQuery("SELECT n FROM Notatka n WHERE n.user ='"+login+"' AND n.tresc LIKE '%"+fraza+"%' AND n.data LIKE '%"+data+"%'").getResultList();
	}
	
	public List<Notatka> pobierzNotatkiWgId(List<Long> wyniki) {
		return em.createQuery("SELECT n FROM Notatka n WHERE n.id IN("+wyniki+")").getResultList();
	}
	
	/*public String sumaArch() {
		return em.createQuery("SELECT Count(n) FROM Notatka n WHERE n.data < CURRENT_DATE").getSingleResult().toString();
	}
	public String sumaTerm() {
		return em.createQuery("SELECT Count(n) FROM Notatka n WHERE n.data >= CURRENT_DATE").getSingleResult().toString();
	}*/
	
	//rejestracja, logowanie
	
	public void dodajUsera(String login, String imie, String haslo){
		User user = new User();
		
		user.setLogin(login);
		user.setImie(imie);
		user.setHaslo(haslo);
		
		em.persist(user);
	}
	
	public User getUser(String login){
		return em.find(User.class, login);	
	}
	
	
	//admin
	public List<User> pobierzUserow(){
		List resultList = em.createNamedQuery("user.all").getResultList();
		return resultList;
	}
	
	public List<Long> pobierzWszystkieId() {		
		return em.createQuery("SELECT n.id FROM Notatka n ").getResultList();
	}
	
	public List<String> pobierzWszystkieLoginy() {		
		return em.createQuery("SELECT u.login FROM User u ").getResultList();
	}
	
	public String suma() {
		return em.createQuery("SELECT Count(n) FROM Notatka n ").getSingleResult().toString();
	}
	
	public String sumaUserow() {
		return em.createQuery("SELECT Count(u) FROM User u ").getSingleResult().toString();
	}
	
	public void usunUsera(String login) {
		User user = em.find(User.class, login);
		em.remove(user);
	}
}
