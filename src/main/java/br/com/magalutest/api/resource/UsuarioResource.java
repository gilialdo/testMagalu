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

import br.com.magalutest.api.service.UsuarioService;
import br.com.magalutest.api.event.RecursoCriadoEvent;
import br.com.magalutest.api.model.Usuario;
import br.com.magalutest.api.repository.UsuarioRepository;
import br.com.magalutest.api.repository.filter.UsuarioFilter;

@RestController
@RequestMapping("/usuario_")
public class UsuarioResource {

 @Autowired
 private UsuarioRepository usuarioRepository;

 @Autowired
 private UsuarioService usuarioService;

 @Autowired
 private ApplicationEventPublisher publisher;

	//@ApiOperation(value = "Listar Usuario")
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_USUARIO_LISTAR')")
	public Page<Usuario> listar(UsuarioFilter usuarioFilter, Pageable pageable) {
		return usuarioRepository.filtrar(usuarioFilter, pageable);
	}

	//@ApiOperation(value = "Criar Usuario")
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_USUARIO_CRIAR')")
	public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario usuario, HttpServletResponse response) {
		Usuario usuarioSalva = usuarioRepository.save(usuario);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalva.getIdUsuario()));
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalva);
	}

	//@ApiOperation(value = "Buscar Usuario pelo IdUsuario")
	@GetMapping("/{idUsuario}")
	@PreAuthorize("hasAuthority('ROLE_USUARIO_LISTAR')")
	public ResponseEntity<Usuario> buscarPeloIdUsuario(@PathVariable Long idUsuario) {
		 Usuario usuario = usuarioRepository.findById(idUsuario).get();
		 return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
	}

	//@ApiOperation(value = "Apagar Usuario")
	@DeleteMapping("/{idUsuario}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_USUARIO_DELETAR')")
	public void remover(@PathVariable Long idUsuario) {
		usuarioRepository.deleteById(idUsuario);
	}

	//@ApiOperation(value = "Atualizar Usuario")
	@PutMapping("/{idUsuario}")
	@PreAuthorize("hasAuthority('ROLE_USUARIO_ATUALIZAR')")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long idUsuario, @Valid @RequestBody Usuario usuario) {
		Usuario usuarioSalva = usuarioService.atualizar(idUsuario, usuario);
		return ResponseEntity.ok(usuarioSalva);
	}

}

