package br.com.magalutest.api.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magalutest.api.model.Permissao;
import br.com.magalutest.api.repository.filter.PermissaoFilter;
import br.com.magalutest.api.repository.querys.PermissaoRepositoryQuery;

public interface PermissaoRepository extends JpaRepository<Permissao, Long>, PermissaoRepositoryQuery {

    public Page<Permissao> filtrar(PermissaoFilter permissaoFilter, Pageable pageable);

    public Optional<Permissao> findByIdPermissao(Long idPermissao);
    public Optional<Permissao> findByDescricao(String descricao);

}
