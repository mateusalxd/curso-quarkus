package io.github.mateusalxd.resource;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import io.github.mateusalxd.model.Ordem;
import io.github.mateusalxd.service.OrdemService;

@Path("/ordens")
public class OrdemResource {

	@Inject
	OrdemService ordemService;

	@POST
	@RolesAllowed("user")
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(@Context SecurityContext seguranca, Ordem ordem) {
		ordemService.inserir(seguranca, ordem);
	}

	@GET
	@RolesAllowed("admin")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ordem> listar() {
		return ordemService.listar();
	}
}
