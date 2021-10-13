package br.com.magalutest.api.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.magalutest.api.model.Usuario;
import br.com.magalutest.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario atualizar(Long idUsuario, Usuario usuario) {
		Usuario usuarioSalva = buscarUsuarioPeloIdUsuario(idUsuario);

		BeanUtils.copyProperties(usuario, usuarioSalva, "idUsuario");
		return usuarioRepository.save(usuarioSalva);
	}

	public Usuario buscarUsuarioPeloIdUsuario(Long idUsuario) {
		Usuario usuarioSalva = usuarioRepository.findById(idUsuario).get();
		if (usuarioSalva == null) {
			throw new EmptyResultDataAccessException(1);
		} 
		return usuarioSalva;
	}

	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}


