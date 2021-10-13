//package br.com.magalutest.api.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.stereotype.Service;
//
//import br.com.magalutest.api.model.Produto;
//import br.com.magalutest.api.repository.ProdutoRepository;
//
//@Service
//public class ProdutoService {
//
//	@Autowired
//	private ProdutoRepository produtoRepository;
//
//	public Produto atualizar(Long idProduto, Produto produto) {
//		Produto produtoSalva = buscarProdutoPeloIdProduto(idProduto);
//
//		BeanUtils.copyProperties(produto, produtoSalva, "idProduto");
//		return produtoRepository.save(produtoSalva);
//	}
//
//	public Produto buscarProdutoPeloIdProduto(Long idProduto) {
//		Produto produtoSalva = produtoRepository.findById(idProduto).get();
//		if (produtoSalva == null) {
//			throw new EmptyResultDataAccessException(1);
//		} 
//		return produtoSalva;
//	}
//
//	public Produto salvar(Produto produto) {
//		return produtoRepository.save(produto);
//	}
//
//}
//
//
