package io.github.mateusalxd.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;

import io.github.mateusalxd.model.Ordem;
import io.github.mateusalxd.model.Usuario;
import io.github.mateusalxd.repository.OrdemRepository;

@ApplicationScoped
public class OrdemService {

	@Inject
	OrdemRepository ordemRepository;

	public void inserir(SecurityContext seguranca, Ordem ordem) {
		Optional<Usuario> usuarioOpcional = Usuario.findByIdOptional(ordem.getUserId());
		usuarioOpcional.orElseThrow();
		if (!usuarioOpcional.get().getUsername().equals(seguranca.getUserPrincipal().getName())) {
			throw new RuntimeException("Usuário informado é diferente do usuário logado.");
		}
		ordem.setData(LocalDate.now());
		ordem.setStatus("ENVIADA");
		ordemRepository.persist(ordem);
	}

	public List<Ordem> listar() {
		return ordemRepository.listAll();
	}

}
