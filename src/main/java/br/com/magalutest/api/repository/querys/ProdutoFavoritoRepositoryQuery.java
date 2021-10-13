package br.com.magalutest.api.repository.querys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.magalutest.api.model.ProdutoFavorito;
import br.com.magalutest.api.repository.filter.ProdutoFavoritoFilter;

public interface ProdutoFavoritoRepositoryQuery {

	 public Page<ProdutoFavorito> filtrar(ProdutoFavoritoFilter produtoFavoritoFilter, Pageable pageable);

}

