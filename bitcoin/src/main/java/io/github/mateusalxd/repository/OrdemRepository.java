package io.github.mateusalxd.repository;

import javax.enterprise.context.ApplicationScoped;

import io.github.mateusalxd.model.Ordem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class OrdemRepository implements PanacheRepository<Ordem> {

}
