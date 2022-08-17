package com.ourbabies.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ourbabies.springboot.model.Usuario;
import com.ourbabies.springboot.repository.UsuarioRepository;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	//Salvar usuário
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);		
	}
	
	
	
}

