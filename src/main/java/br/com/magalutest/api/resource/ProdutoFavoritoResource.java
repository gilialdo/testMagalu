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

import br.com.magalutest.api.service.ProdutoFavoritoService;
import br.com.magalutest.api.util.RestProduto;
import br.com.magalutest.api.event.RecursoCriadoEvent;
import br.com.magalutest.api.model.Cliente;
import br.com.magalutest.api.model.Produto;
import br.com.magalutest.api.model.ProdutoFavorito;
import br.com.magalutest.api.repository.ClienteRepository;
import br.com.magalutest.api.repository.ProdutoFavoritoRepository;
//import br.com.magalutest.api.repository.ProdutoRepository;
import br.com.magalutest.api.repository.filter.ProdutoFavoritoFilter;

@RestController
@RequestMapping("/produtoFavorito_")
public class ProdutoFavoritoResource {

	 @Autowired
	 private ProdutoFavoritoRepository produtoFavoritoRepository;
	
	 @Autowired
	 private ClienteRepository clienteRepository;
	 
	 @Autowired
	 private ProdutoFavoritoService produtoFavoritoService;
	
	 @Autowired
	 private ApplicationEventPublisher publisher;

	//@ApiOperation(value = "Listar ProdutoFavorito")
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PRODUTOFAVORITO_LISTAR')")
	public Page<ProdutoFavorito> listar(ProdutoFavoritoFilter produtoFavoritoFilter, Pageable pageable) {
		return produtoFavoritoRepository.filtrar(produtoFavoritoFilter, pageable);
	}

	//@ApiOperation(value = "Criar ProdutoFavorito")
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_PRODUTOFAVORITO_CRIAR')")
	public ResponseEntity<ProdutoFavorito> criar(@Valid @RequestBody ProdutoFavorito produtoFavorito, HttpServletResponse response) {
		
		Produto produto = Produto.jsonToProduto(RestProduto.getProduto(produtoFavorito.getIdProduto()));
		if (produto == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(null);	
		} 
		Optional<Cliente> cliente = clienteRepository.findByIdCliente(produtoFavorito.getCliente().getIdCliente());
		if (cliente.isEmpty()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
		}
		
		ProdutoFavorito produtoFavoritoSalva = produtoFavoritoRepository.save(produtoFavorito);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, produtoFavoritoSalva.getIdProdutoFavorito()));
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoFavoritoSalva);
	}

	//@ApiOperation(value = "Buscar ProdutoFavorito pelo IdProdutoFavorito")
	@GetMapping("/{idProdutoFavorito}")
	@PreAuthorize("hasAuthority('ROLE_PRODUTOFAVORITO_LISTAR')")
	public ResponseEntity<ProdutoFavorito> buscarPeloIdProdutoFavorito(@PathVariable Long idProdutoFavorito) {
		 ProdutoFavorito produtoFavorito = produtoFavoritoRepository.findById(idProdutoFavorito).get();
		 return produtoFavorito != null ? ResponseEntity.ok(produtoFavorito) : ResponseEntity.notFound().build();
	}

	//@ApiOperation(value = "Apagar ProdutoFavorito")
	@DeleteMapping("/{idProdutoFavorito}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_PRODUTOFAVORITO_DELETAR')")
	public void remover(@PathVariable Long idProdutoFavorito) {
		produtoFavoritoRepository.deleteById(idProdutoFavorito);
	}

	//@ApiOperation(value = "Atualizar ProdutoFavorito")
	@PutMapping("/{idProdutoFavorito}")
	@PreAuthorize("hasAuthority('ROLE_PRODUTOFAVORITO_ATUALIZAR')")
	public ResponseEntity<ProdutoFavorito> atualizar(@PathVariable Long idProdutoFavorito, @Valid @RequestBody ProdutoFavorito produtoFavorito) {
		Produto produto = Produto.jsonToProduto(RestProduto.getProduto(produtoFavorito.getIdProduto()));
		if (produto == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(null);	
		} 
		ProdutoFavorito produtoFavoritoSalva = produtoFavoritoService.atualizar(idProdutoFavorito, produtoFavorito);
		return ResponseEntity.ok(produtoFavoritoSalva);
	}

}

