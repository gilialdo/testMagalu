//package br.com.magalutest.api.repository.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.util.StringUtils;
//
//import br.com.magalutest.api.repository.querys.PermissaoUsuarioRepositoryQuery;
//import br.com.magalutest.api.model.PermissaoUsuario;
//import br.com.magalutest.api.model.abstracts.PermissaoUsuarioAbstractJPA;
//import br.com.magalutest.api.repository.filter.PermissaoUsuarioFilter;
//
//public class PermissaoUsuarioRepositoryImpl implements PermissaoUsuarioRepositoryQuery {
//
//	@PersistenceContext
//	private EntityManager manager;
//
//	@Override
//	public Page<PermissaoUsuario> filtrar(PermissaoUsuarioFilter permissaoUsuarioFilter, Pageable pageable) {
//		CriteriaBuilder builder = manager.getCriteriaBuilder();
//		CriteriaQuery<PermissaoUsuario> criteria = builder.createQuery(PermissaoUsuario.class);
//		Root<PermissaoUsuario> root = criteria.from(PermissaoUsuario.class);
//
//		Predicate[] predicates = criarRestricoes(permissaoUsuarioFilter, builder, root);
//		criteria.where(predicates);
//
//		TypedQuery<PermissaoUsuario> query = manager.createQuery(criteria);
//		adicionarRestricoesDePaginacao(query, pageable);
//
//		return new PageImpl<>(query.getResultList(), pageable, total(permissaoUsuarioFilter));
//	}
//
//	private Predicate[] criarRestricoes(PermissaoUsuarioFilter permissaoUsuarioFilter, CriteriaBuilder builder,
//			Root<PermissaoUsuario> root) {
//		List<Predicate> predicates = new ArrayList<>();
//
//		
//		if (!StringUtils.isEmpty(permissaoUsuarioFilter.getIdUsuario())) {
//			predicates.add(builder.equal(builder.lower(root.get("usuario").get("idUsuario")), permissaoUsuarioFilter.getIdUsuario() ));
//		}
//		if (!StringUtils.isEmpty(permissaoUsuarioFilter.getIdPermissao())) {
//			predicates.add(builder.equal(builder.lower(root.get("permissao").get("idPermissao")), permissaoUsuarioFilter.getIdPermissao() ));
//		}
//
//
//		return predicates.toArray(new Predicate[predicates.size()]);
//	}
//
//	private void adicionarRestricoesDePaginacao(TypedQuery<PermissaoUsuario> query, Pageable pageable) {
//		int paginaAtual = pageable.getPageNumber();
//		int totalRegistrosPorPagina = pageable.getPageSize();
//		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
//
//		query.setFirstResult(primeiroRegistroDaPagina);
//		query.setMaxResults(totalRegistrosPorPagina);
//	}
//
//	private Long total(PermissaoUsuarioFilter permissaoUsuarioFilter) {
//		CriteriaBuilder builder = manager.getCriteriaBuilder();
//		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
//		Root<PermissaoUsuario> root = criteria.from(PermissaoUsuario.class);
//
//		Predicate[] predicates = criarRestricoes(permissaoUsuarioFilter, builder, root);
//		criteria.where(predicates);
//
//		criteria.select(builder.count(root));
//		return manager.createQuery(criteria).getSingleResult();
//	}
//
//}
//
