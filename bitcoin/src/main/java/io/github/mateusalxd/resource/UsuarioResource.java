package io.github.mateusalxd.resource;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import io.github.mateusalxd.model.Usuario;

@Path("/usuarios")
public class UsuarioResource {

	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Usuario usuario) {
		Usuario.persist(usuario);
	}

}
