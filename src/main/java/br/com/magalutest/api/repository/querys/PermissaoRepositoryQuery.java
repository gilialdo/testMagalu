package br.com.magalutest.api.repository.querys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.magalutest.api.model.Permissao;
import br.com.magalutest.api.repository.filter.PermissaoFilter;

public interface PermissaoRepositoryQuery {

	 public Page<Permissao> filtrar(PermissaoFilter permissaoFilter, Pageable pageable);

}

