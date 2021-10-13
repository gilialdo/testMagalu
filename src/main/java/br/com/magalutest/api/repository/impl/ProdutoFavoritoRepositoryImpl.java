package br.com.magalutest.api.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import br.com.magalutest.api.repository.querys.ProdutoFavoritoRepositoryQuery;
import br.com.magalutest.api.model.ProdutoFavorito;
import br.com.magalutest.api.repository.filter.ProdutoFavoritoFilter;

public class ProdutoFavoritoRepositoryImpl implements ProdutoFavoritoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<ProdutoFavorito> filtrar(ProdutoFavoritoFilter produtoFavoritoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ProdutoFavorito> criteria = builder.createQuery(ProdutoFavorito.class);
		Root<ProdutoFavorito> root = criteria.from(ProdutoFavorito.class);

		Predicate[] predicates = criarRestricoes(produtoFavoritoFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<ProdutoFavorito> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(produtoFavoritoFilter));
	}

	private Predicate[] criarRestricoes(ProdutoFavoritoFilter produtoFavoritoFilter, CriteriaBuilder builder,
			Root<ProdutoFavorito> root) {
		List<Predicate> predicates = new ArrayList<>();

		
		if (!StringUtils.isEmpty(produtoFavoritoFilter.getIdCliente())) {
			predicates.add(builder.equal(builder.lower(root.get("cliente").get("idCliente")), produtoFavoritoFilter.getIdCliente() ));
		}


		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<ProdutoFavorito> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}

	private Long total(ProdutoFavoritoFilter produtoFavoritoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<ProdutoFavorito> root = criteria.from(ProdutoFavorito.class);

		Predicate[] predicates = criarRestricoes(produtoFavoritoFilter, builder, root);
		criteria.where(predicates);

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}

