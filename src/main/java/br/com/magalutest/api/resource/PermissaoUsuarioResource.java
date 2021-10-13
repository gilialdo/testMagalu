//package br.com.magalutest.api.resource;
//
//
//import javax.servlet.http.HttpServletResponse;
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.ResponseStatus;
////import io.swagger.annotations.ApiOperation;
//
//import br.com.magalutest.api.service.PermissaoUsuarioService;
//import br.com.magalutest.api.event.RecursoCriadoEvent;
//import br.com.magalutest.api.model.PermissaoUsuario;
//import br.com.magalutest.api.repository.PermissaoUsuarioRepository;
//import br.com.magalutest.api.repository.filter.PermissaoUsuarioFilter;
//
//@RestController
//@RequestMapping("/permissaoUsuario_")
//public class PermissaoUsuarioResource {
//
// @Autowired
// private PermissaoUsuarioRepository permissaoUsuarioRepository;
//
// @Autowired
// private PermissaoUsuarioService permissaoUsuarioService;
//
// @Autowired
// private ApplicationEventPublisher publisher;
//
//	//@ApiOperation(value = "Listar PermissaoUsuario")
//	@GetMapping
//	@PreAuthorize("hasAuthority('ROLE_PERMISSAOUSUARIO_LISTAR')")
//	public Page<PermissaoUsuario> listar(PermissaoUsuarioFilter permissaoUsuarioFilter, Pageable pageable) {
//		return permissaoUsuarioRepository.filtrar(permissaoUsuarioFilter, pageable);
//	}
//
//	//@ApiOperation(value = "Criar PermissaoUsuario")
//	@PostMapping
//	@PreAuthorize("hasAuthority('ROLE_PERMISSAOUSUARIO_CRIAR')")
//	public ResponseEntity<PermissaoUsuario> criar(@Valid @RequestBody PermissaoUsuario permissaoUsuario, HttpServletResponse response) {
//		PermissaoUsuario permissaoUsuarioSalva = permissaoUsuarioRepository.save(permissaoUsuario);
//		publisher.publishEvent(new RecursoCriadoEvent(this, response, permissaoUsuarioSalva.getIdPermissaoUsuario()));
//		return ResponseEntity.status(HttpStatus.CREATED).body(permissaoUsuarioSalva);
//	}
//
//	//@ApiOperation(value = "Buscar PermissaoUsuario pelo IdPermissaoUsuario")
//	@GetMapping("/{idPermissaoUsuario}")
//	@PreAuthorize("hasAuthority('ROLE_PERMISSAOUSUARIO_LISTAR')")
//	public ResponseEntity<PermissaoUsuario> buscarPeloIdPermissaoUsuario(@PathVariable Long idPermissaoUsuario) {
//		 PermissaoUsuario permissaoUsuario = permissaoUsuarioRepository.findById(idPermissaoUsuario).get();
//		 return permissaoUsuario != null ? ResponseEntity.ok(permissaoUsuario) : ResponseEntity.notFound().build();
//	}
//
//	//@ApiOperation(value = "Apagar PermissaoUsuario")
//	@DeleteMapping("/{idPermissaoUsuario}")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	@PreAuthorize("hasAuthority('ROLE_PERMISSAOUSUARIO_DELETAR')")
//	public void remover(@PathVariable Long idPermissaoUsuario) {
//		permissaoUsuarioRepository.deleteById(idPermissaoUsuario);
//	}
//
//	//@ApiOperation(value = "Atualizar PermissaoUsuario")
//	@PutMapping("/{idPermissaoUsuario}")
//	@PreAuthorize("hasAuthority('ROLE_PERMISSAOUSUARIO_ATUALIZAR')")
//	public ResponseEntity<PermissaoUsuario> atualizar(@PathVariable Long idPermissaoUsuario, @Valid @RequestBody PermissaoUsuario permissaoUsuario) {
//		PermissaoUsuario permissaoUsuarioSalva = permissaoUsuarioService.atualizar(idPermissaoUsuario, permissaoUsuario);
//		return ResponseEntity.ok(permissaoUsuarioSalva);
//	}
//
//}
//
