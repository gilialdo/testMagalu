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

import br.com.magalutest.api.repository.querys.UsuarioRepositoryQuery;
import br.com.magalutest.api.model.Usuario;
import br.com.magalutest.api.model.abstracts.UsuarioAbstractJPA;
import br.com.magalutest.api.repository.filter.UsuarioFilter;

public class UsuarioRepositoryImpl implements UsuarioRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Page<Usuario> filtrar(UsuarioFilter usuarioFilter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
		Root<Usuario> root = criteria.from(Usuario.class);

		Predicate[] predicates = criarRestricoes(usuarioFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<Usuario> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total(usuarioFilter));
	}

	private Predicate[] criarRestricoes(UsuarioFilter usuarioFilter, CriteriaBuilder builder,
			Root<Usuario> root) {
		List<Predicate> predicates = new ArrayList<>();

		


		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Usuario> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}

	private Long total(UsuarioFilter usuarioFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Usuario> root = criteria.from(Usuario.class);

		Predicate[] predicates = criarRestricoes(usuarioFilter, builder, root);
		criteria.where(predicates);

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}

