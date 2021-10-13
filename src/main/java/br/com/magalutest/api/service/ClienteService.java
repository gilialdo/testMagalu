package br.com.magalutest.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.magalutest.api.model.Cliente;
import br.com.magalutest.api.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente atualizar(Long idCliente, Cliente cliente) {
		Cliente clienteSalva = buscarClientePeloIdCliente(idCliente);

		BeanUtils.copyProperties(cliente, clienteSalva, "idCliente");
		return clienteRepository.save(clienteSalva);
	}

	public Cliente buscarClientePeloIdCliente(Long idCliente) {
		Cliente clienteSalva = clienteRepository.findById(idCliente).get();
		if (clienteSalva == null) {
			throw new EmptyResultDataAccessException(1);
		} 
		return clienteSalva;
	}

	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

}


