//package br.com.magalutest.api.repository;
//
//import java.util.Optional;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import br.com.magalutest.api.model.PermissaoUsuario;
//import br.com.magalutest.api.repository.filter.PermissaoUsuarioFilter;
//import br.com.magalutest.api.repository.querys.PermissaoUsuarioRepositoryQuery;
//
//public interface PermissaoUsuarioRepository extends JpaRepository<PermissaoUsuario, Long>, PermissaoUsuarioRepositoryQuery {
//
//    public Page<PermissaoUsuario> filtrar(PermissaoUsuarioFilter permissaoUsuarioFilter, Pageable pageable);
//
//    public Optional<PermissaoUsuario> findByIdPermissaoUsuario(Long idPermissaoUsuario);
//
//}
