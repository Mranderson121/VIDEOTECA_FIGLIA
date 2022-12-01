package com.advancia.stage.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



import com.advancia.stage.dao.VideotecaDao;

import com.advancia.stage.model.Film;

@Path("/film")
public class FilmService {

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Film> getEmployees_JSON() {
		List<Film> listaFilm = VideotecaDao.getAllFilm();
		listaFilm.forEach(film -> film.getListaAttori().forEach(attore -> {
			attore.setListaFilm(null);
		    
			
			}));
		
		return listaFilm;
	}
	
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Film insertFilm(Film film) {
		VideotecaDao dao = new VideotecaDao();
		return dao.insertFilm(film);
	}

}
