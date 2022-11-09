package pacchetto.dao;

import javax.persistence.EntityManager;

import pacchetto.dao.*;
import pacchetto.elementi.*;

public class FilmDao {
	private static EntityManager entityManager = null;
	
	private void injectEntityManager() {
		if (null == entityManager) {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		}
	}
	
	public Film getFilm(String nome) {
		injectEntityManager();
		Film response = entityManager.find(Film.class, nome);
		return response;
	}
	
	public Attore getAttore(String nome) {
		injectEntityManager();
		Attore response = entityManager.find(Attore.class, nome);
		return response;
	}
	
	public Regista getRegista(String nome) {
		injectEntityManager();
		Regista response = entityManager.find(Regista.class, nome);
		return response;
	}
	

}
