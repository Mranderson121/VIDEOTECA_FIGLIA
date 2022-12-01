package com.advancia.stage.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.advancia.stage.dao.VideotecaDao;
import com.advancia.stage.model.Regista;

@Path("/registi")
public class RegistaService {

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Regista> getEmployees_JSON() {
		List<Regista> listaRegisti = VideotecaDao.getAllRegisti();
		listaRegisti.forEach(regista -> regista.getListaFilm().forEach(film -> {
				film.setListaAttori(null);
			    film.setRegista(null);
			    film.setListaUtenti(null);
				
				}));
		
		return listaRegisti;
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Regista insertRegista(Regista Regista) {
		VideotecaDao dao = new VideotecaDao();
		return dao.insertRegista(Regista);
	}
	
}
