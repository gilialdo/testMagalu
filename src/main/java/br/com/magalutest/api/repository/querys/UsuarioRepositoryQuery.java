package br.com.magalutest.api.repository.querys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.magalutest.api.model.Usuario;
import br.com.magalutest.api.repository.filter.UsuarioFilter;

public interface UsuarioRepositoryQuery {

	 public Page<Usuario> filtrar(UsuarioFilter usuarioFilter, Pageable pageable);

}

