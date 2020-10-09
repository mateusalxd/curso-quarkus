package io.github.mateusalxd.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.github.mateusalxd.model.Bitcoin;

@Path("/bitcoins")
@RegisterRestClient
public interface BitcoinService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bitcoin> listar();

}
