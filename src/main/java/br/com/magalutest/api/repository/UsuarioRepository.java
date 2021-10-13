package br.com.magalutest.api.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magalutest.api.model.Usuario;
import br.com.magalutest.api.repository.filter.UsuarioFilter;
import br.com.magalutest.api.repository.querys.UsuarioRepositoryQuery;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioRepositoryQuery {

    public Page<Usuario> filtrar(UsuarioFilter usuarioFilter, Pageable pageable);

    public Optional<Usuario> findByIdUsuario(Long idUsuario);
    public Optional<Usuario> findByNome(String nome);
    public Optional<Usuario> findByEmail(String email);
    public Optional<Usuario> findBySenha(String senha);

}
