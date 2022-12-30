package br.com.api.suporte.repositorio;

import org.springframework.data.repository.CrudRepository;
// import org.springframework.stereotype.Repository;

import br.com.api.suporte.modelo.SuporteModelo;

// @Repository
public interface SuporteRepositorio extends CrudRepository<SuporteModelo, Integer>{

}