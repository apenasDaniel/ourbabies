package com.ourbabies.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourbabies.springboot.model.Doador;
import com.ourbabies.springboot.repository.DoadorRepository;

@Service
public class DoadorService {

	@Autowired
	private DoadorRepository doadorDAO;
	//Salvar usuário
	public Doador save(Doador doador) {
		return doadorDAO.save(doador);		
	}
}
