package pacchetto.service;

import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



import pacchetto.dao.*;
import pacchetto.elementi.*;

@Path("/videoteca")
public class VideotecaService {
	// URI:
	// /contextPath/servletPath/videoteca/{film nome}

	@GET
	@Path("/{nome}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Film getFilm(@PathParam("nome") String nome) {
		VideotecaDao dao = new VideotecaDao();
		return dao.getFilm(nome);
	}

	// URI:
	// /contextPath/servletPath/videoteca/{regista nome}

	@GET
	@Path("/{nome}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Regista getRegista(@PathParam("nome") String nome) {
		VideotecaDao dao = new VideotecaDao();
		return dao.getRegista(nome);
	}
	
	// URI:
		// /contextPath/servletPath/videoteca/{attore nome}

		@GET
		@Path("/{nome}")
		@Produces({ MediaType.APPLICATION_JSON })
		public Attore getAttore(@PathParam("nome") String nome) {
			VideotecaDao dao = new VideotecaDao();
			return dao.getAttore(nome);
		}
}
