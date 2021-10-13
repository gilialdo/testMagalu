package br.com.magalutest.api.resource;
import java.util.List;

//
//
//import javax.servlet.http.HttpServletResponse;
//import javax.validation.Valid;
//
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
////import io.swagger.annotations.ApiOperation;
//
//import br.com.magalutest.api.service.ProdutoService;
//import br.com.magalutest.api.event.RecursoCriadoEvent;
import br.com.magalutest.api.model.Produto;
//import br.com.magalutest.api.repository.ProdutoRepository;
import br.com.magalutest.api.util.RestProduto;

@RestController
@RequestMapping("/produto_")
public class ProdutoResource {

	//@ApiOperation(value = "Listar Produto")
	@GetMapping("/pagina/{pagina}")
	@PreAuthorize("hasAuthority('ROLE_PRODUTO_LISTAR')")
	public List<Produto> listar(@PathVariable String pagina) {
		String jsonProdutos = RestProduto.getProdutos(Integer.parseInt(pagina));
		return Produto.jsonToListProduto(jsonProdutos);
	}

	//@ApiOperation(value = "Buscar Produto pelo IdProduto")
	@GetMapping("/{idProduto}")
	@PreAuthorize("hasAuthority('ROLE_PRODUTO_LISTAR')")
	public ResponseEntity<Produto> buscarPeloIdProduto(@PathVariable String idProduto) {
		 Produto produto = Produto.jsonToProduto(RestProduto.getProduto(idProduto));
		 return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
	}

}

