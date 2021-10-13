//package br.com.magalutest.api.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.stereotype.Service;
//
//import br.com.magalutest.api.model.PermissaoUsuario;
//import br.com.magalutest.api.repository.PermissaoUsuarioRepository;
//
//@Service
//public class PermissaoUsuarioService {
//
//	@Autowired
//	private PermissaoUsuarioRepository permissaoUsuarioRepository;
//
//	public PermissaoUsuario atualizar(Long idPermissaoUsuario, PermissaoUsuario permissaoUsuario) {
//		PermissaoUsuario permissaoUsuarioSalva = buscarPermissaoUsuarioPeloIdPermissaoUsuario(idPermissaoUsuario);
//
//		BeanUtils.copyProperties(permissaoUsuario, permissaoUsuarioSalva, "idPermissaoUsuario");
//		return permissaoUsuarioRepository.save(permissaoUsuarioSalva);
//	}
//
//	public PermissaoUsuario buscarPermissaoUsuarioPeloIdPermissaoUsuario(Long idPermissaoUsuario) {
//		PermissaoUsuario permissaoUsuarioSalva = permissaoUsuarioRepository.findById(idPermissaoUsuario).get();
//		if (permissaoUsuarioSalva == null) {
//			throw new EmptyResultDataAccessException(1);
//		} 
//		return permissaoUsuarioSalva;
//	}
//
//	public PermissaoUsuario salvar(PermissaoUsuario permissaoUsuario) {
//		return permissaoUsuarioRepository.save(permissaoUsuario);
//	}
//
//}
//
//
