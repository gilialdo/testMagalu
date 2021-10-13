package br.com.magalutest.api.repository.querys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.magalutest.api.model.Cliente;
import br.com.magalutest.api.repository.filter.ClienteFilter;

public interface ClienteRepositoryQuery {

	 public Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable);

}

