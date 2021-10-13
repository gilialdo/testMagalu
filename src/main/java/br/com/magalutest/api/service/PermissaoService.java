package br.com.magalutest.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.magalutest.api.model.Permissao;
import br.com.magalutest.api.repository.PermissaoRepository;

@Service
public class PermissaoService {

	@Autowired
	private PermissaoRepository permissaoRepository;

	public Permissao atualizar(Long idPermissao, Permissao permissao) {
		Permissao permissaoSalva = buscarPermissaoPeloIdPermissao(idPermissao);

		BeanUtils.copyProperties(permissao, permissaoSalva, "idPermissao");
		return permissaoRepository.save(permissaoSalva);
	}

	public Permissao buscarPermissaoPeloIdPermissao(Long idPermissao) {
		Permissao permissaoSalva = permissaoRepository.findById(idPermissao).get();
		if (permissaoSalva == null) {
			throw new EmptyResultDataAccessException(1);
		} 
		return permissaoSalva;
	}

	public Permissao salvar(Permissao permissao) {
		return permissaoRepository.save(permissao);
	}

}


