package com.advancia.stage.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.advancia.stage.model.Attore;
import com.advancia.stage.model.Film;
import com.advancia.stage.model.Regista;
import com.advancia.stage.model.Utente;

public class VideotecaDao {
	
	public static Utente getUtenteByUsernamePassword(String username, String password) {
		List<Utente> listaUtenti = new ArrayList();

		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		TypedQuery<Utente> query = em.createQuery(
				"select u from Utente u where u.username = :username and u.password = :password", Utente.class);
		query.setParameter("username", username);
		query.setParameter("password", password);
		listaUtenti = query.getResultList();
		return listaUtenti.isEmpty() ? null : listaUtenti.get(0);
	}
	
	
	private static EntityManager entityManager = null;
	
	private static void injectEntityManager() {
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

	public static List<Attore> getAllActors() {
		injectEntityManager();
		List<Attore> listaAttori = new ArrayList();
		TypedQuery<Attore> query = entityManager.createQuery("select a from Attore a", Attore.class);
		listaAttori = query.getResultList();
		return listaAttori;
	}
	

}
