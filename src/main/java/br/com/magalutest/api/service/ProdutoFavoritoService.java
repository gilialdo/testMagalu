package br.com.magalutest.api.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.magalutest.api.model.ProdutoFavorito;
import br.com.magalutest.api.repository.ProdutoFavoritoRepository;

@Service
public class ProdutoFavoritoService {

	@Autowired
	private ProdutoFavoritoRepository produtoFavoritoRepository;

	public ProdutoFavorito atualizar(Long idProdutoFavorito, ProdutoFavorito produtoFavorito) {
		ProdutoFavorito produtoFavoritoSalva = buscarProdutoFavoritoPeloIdProdutoFavorito(idProdutoFavorito);

		BeanUtils.copyProperties(produtoFavorito, produtoFavoritoSalva, "idProdutoFavorito");
		return produtoFavoritoRepository.save(produtoFavoritoSalva);
	}

	public ProdutoFavorito buscarProdutoFavoritoPeloIdProdutoFavorito(Long idProdutoFavorito) {
		ProdutoFavorito produtoFavoritoSalva = produtoFavoritoRepository.findById(idProdutoFavorito).get();
		if (produtoFavoritoSalva == null) {
			throw new EmptyResultDataAccessException(1);
		} 
		return produtoFavoritoSalva;
	}

	public ProdutoFavorito salvar(ProdutoFavorito produtoFavorito) {
		return produtoFavoritoRepository.save(produtoFavorito);
	}

}


