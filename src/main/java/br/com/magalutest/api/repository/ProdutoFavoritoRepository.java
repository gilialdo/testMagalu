package br.com.magalutest.api.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magalutest.api.model.ProdutoFavorito;
import br.com.magalutest.api.repository.filter.ProdutoFavoritoFilter;
import br.com.magalutest.api.repository.querys.ProdutoFavoritoRepositoryQuery;

public interface ProdutoFavoritoRepository extends JpaRepository<ProdutoFavorito, Long>, ProdutoFavoritoRepositoryQuery {

    public Page<ProdutoFavorito> filtrar(ProdutoFavoritoFilter produtoFavoritoFilter, Pageable pageable);

    public Optional<ProdutoFavorito> findByIdProdutoFavorito(Long idProdutoFavorito);
    public Optional<ProdutoFavorito> findByIdProduto(String idProduto);

}
