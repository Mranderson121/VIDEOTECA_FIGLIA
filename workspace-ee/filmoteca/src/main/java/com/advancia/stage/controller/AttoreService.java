package com.advancia.stage.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.advancia.stage.dao.VideotecaDao;
import com.advancia.stage.model.Attore;

@Path("/attori")
public class AttoreService {

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Attore> getEmployees_JSON() {
		List<Attore> listaAttori = VideotecaDao.getAllActors();
		listaAttori.forEach(attore -> attore.getListaFilm().forEach(film -> {
				film.setListaAttori(null);
				film.setListaUtenti(null);
				film.setRegista(null);
				}));
		
		return listaAttori;
	}

}
