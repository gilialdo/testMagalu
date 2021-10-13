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

import br.com.magalutest.api.repository.querys.PermissaoRepositoryQuery;
import br.com.magalutest.api.model.Permissao;
import br.com.magalutest.api.repository.filter.PermissaoFilter;

public class PermissaoRepositoryImpl implements PermissaoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Permissao> filtrar(PermissaoFilter permissaoFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Permissao> criteria = builder.createQuery(Permissao.class);
		Root<Permissao> root = criteria.from(Permissao.class);

		Predicate[] predicates = criarRestricoes(permissaoFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<Permissao> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(permissaoFilter));
	}

	private Predicate[] criarRestricoes(PermissaoFilter permissaoFilter, CriteriaBuilder builder,
			Root<Permissao> root) {
		List<Predicate> predicates = new ArrayList<>();

		


		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Permissao> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}

	private Long total(PermissaoFilter permissaoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Permissao> root = criteria.from(Permissao.class);

		Predicate[] predicates = criarRestricoes(permissaoFilter, builder, root);
		criteria.where(predicates);

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}

