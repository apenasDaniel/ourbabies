package com.ourbabies.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ourbabies.springboot.model.Doador;
import com.ourbabies.springboot.repository.DoadorRepository;

@Service
public class LoginService {

	@Autowired
	private DoadorRepository doadorDAO;
	//Salvar usuário
	public Doador logar (Doador doador) {
		return doadorDAO.findByCpfAndSenha(doador.getCpf(), doador.getSenha());		
	}

}
