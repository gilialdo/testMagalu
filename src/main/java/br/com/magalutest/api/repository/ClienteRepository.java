package br.com.magalutest.api.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.magalutest.api.model.Cliente;
import br.com.magalutest.api.repository.filter.ClienteFilter;
import br.com.magalutest.api.repository.querys.ClienteRepositoryQuery;

public interface ClienteRepository extends JpaRepository<Cliente, Long>, ClienteRepositoryQuery {

    public Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable);

    public Optional<Cliente> findByIdCliente(Long idCliente);
    public Optional<Cliente> findByNome(String nome);
    public Optional<Cliente> findByEmail(String email);

}
