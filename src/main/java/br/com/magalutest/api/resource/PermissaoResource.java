package br.com.magalutest.api.resource;


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

import br.com.magalutest.api.service.PermissaoService;
import br.com.magalutest.api.event.RecursoCriadoEvent;
import br.com.magalutest.api.model.Permissao;
import br.com.magalutest.api.repository.PermissaoRepository;
import br.com.magalutest.api.repository.filter.PermissaoFilter;

@RestController
@RequestMapping("/permissao_")
public class PermissaoResource {

 @Autowired
 private PermissaoRepository permissaoRepository;

 @Autowired
 private PermissaoService permissaoService;

 @Autowired
 private ApplicationEventPublisher publisher;

	//@ApiOperation(value = "Listar Permissao")
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PERMISSAO_LISTAR')")
	public Page<Permissao> listar(PermissaoFilter permissaoFilter, Pageable pageable) {
		return permissaoRepository.filtrar(permissaoFilter, pageable);
	}

	//@ApiOperation(value = "Criar Permissao")
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_PERMISSAO_CRIAR')")
	public ResponseEntity<Permissao> criar(@Valid @RequestBody Permissao permissao, HttpServletResponse response) {
		Permissao permissaoSalva = permissaoRepository.save(permissao);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, permissaoSalva.getIdPermissao()));
		return ResponseEntity.status(HttpStatus.CREATED).body(permissaoSalva);
	}

	//@ApiOperation(value = "Buscar Permissao pelo IdPermissao")
	@GetMapping("/{idPermissao}")
	@PreAuthorize("hasAuthority('ROLE_PERMISSAO_LISTAR')")
	public ResponseEntity<Permissao> buscarPeloIdPermissao(@PathVariable Long idPermissao) {
		 Permissao permissao = permissaoRepository.findById(idPermissao).get();
		 return permissao != null ? ResponseEntity.ok(permissao) : ResponseEntity.notFound().build();
	}

	//@ApiOperation(value = "Apagar Permissao")
	@DeleteMapping("/{idPermissao}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_PERMISSAO_DELETAR')")
	public void remover(@PathVariable Long idPermissao) {
		permissaoRepository.deleteById(idPermissao);
	}

	//@ApiOperation(value = "Atualizar Permissao")
	@PutMapping("/{idPermissao}")
	@PreAuthorize("hasAuthority('ROLE_PERMISSAO_ATUALIZAR')")
	public ResponseEntity<Permissao> atualizar(@PathVariable Long idPermissao, @Valid @RequestBody Permissao permissao) {
		Permissao permissaoSalva = permissaoService.atualizar(idPermissao, permissao);
		return ResponseEntity.ok(permissaoSalva);
	}

}

