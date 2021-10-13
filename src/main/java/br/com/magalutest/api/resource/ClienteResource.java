package br.com.magalutest.api.resource;


import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
//import io.swagger.annotations.ApiOperation;

import br.com.magalutest.api.service.ClienteService;
import br.com.magalutest.api.event.RecursoCriadoEvent;
import br.com.magalutest.api.model.Cliente;
import br.com.magalutest.api.repository.ClienteRepository;
import br.com.magalutest.api.repository.filter.ClienteFilter;

@RestController
@RequestMapping("/cliente_")
public class ClienteResource {

 @Autowired
 private ClienteRepository clienteRepository;

 @Autowired
 private ClienteService clienteService;

 @Autowired
 private ApplicationEventPublisher publisher;

	//@ApiOperation(value = "Listar Cliente")
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_CLIENTE_LISTAR')")
	public Page<Cliente> listar(ClienteFilter clienteFilter, Pageable pageable) {
		return clienteRepository.filtrar(clienteFilter, pageable);
	}

	//@ApiOperation(value = "Criar Cliente")
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CLIENTE_CRIAR')")
	public ResponseEntity<Cliente> criar(@Valid @RequestBody Cliente cliente, HttpServletResponse response) {
		Optional<Cliente> clientePesq = clienteRepository.findByEmail(cliente.getEmail());
		if (clientePesq.isEmpty()) {
			Cliente clienteSalva = clienteRepository.save(cliente);
			publisher.publishEvent(new RecursoCriadoEvent(this, response, clienteSalva.getIdCliente()));
			return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalva);
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(clientePesq.get());
		}
	}

	//@ApiOperation(value = "Buscar Cliente pelo IdCliente")
	@GetMapping("/{idCliente}")
	@PreAuthorize("hasAuthority('ROLE_CLIENTE_LISTAR')")
	public ResponseEntity<Cliente> buscarPeloIdCliente(@PathVariable Long idCliente) {
		 Cliente cliente = clienteRepository.findById(idCliente).get();
		 return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
	}

	//@ApiOperation(value = "Apagar Cliente")
	@DeleteMapping("/{idCliente}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_CLIENTE_DELETAR')")
	public void remover(@PathVariable Long idCliente) {
		clienteRepository.deleteById(idCliente);
	}

	//@ApiOperation(value = "Atualizar Cliente")
	@PutMapping("/{idCliente}")
	@PreAuthorize("hasAuthority('ROLE_CLIENTE_ATUALIZAR')")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long idCliente, @Valid @RequestBody Cliente cliente) {
		Optional<Cliente> clientePesq = clienteRepository.findById(cliente.getIdCliente());
		if (clientePesq.isPresent()) {
			String emailAnterior = clientePesq.get().getEmail();
			clientePesq = clienteRepository.findByEmail(emailAnterior);
			if (!clientePesq.isEmpty()) {
				if (!(clientePesq.get().getIdCliente().longValue() == idCliente.longValue())) {
					return ResponseEntity.status(HttpStatus.CONFLICT).body(clientePesq.get());
				}
			}
		}
		Cliente clienteSalva = clienteService.atualizar(idCliente, cliente);
		return ResponseEntity.ok(clienteSalva);
	}

}

