package br.com.magalutest.api.resource;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.magalutest.api.model.Produto;
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

