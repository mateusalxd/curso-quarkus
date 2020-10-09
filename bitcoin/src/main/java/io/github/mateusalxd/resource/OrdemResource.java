package io.github.mateusalxd.resource;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.github.mateusalxd.model.Ordem;
import io.github.mateusalxd.repository.OrdemRepository;

@Path("/ordens")
public class OrdemResource {

	@Inject
	private OrdemRepository ordemRepository;

	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Ordem ordem) {
		ordem.setData(LocalDate.now());
		ordem.setStatus("ENVIADA");
		ordemRepository.persist(ordem);
	}

}
