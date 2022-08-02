package com.ourbabies.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ourbabies.springboot.model.Doador;
import com.ourbabies.springboot.repository.DoadorRepository;
import com.ourbabies.springboot.service.DoadorService;

@Controller
public class HomeController {

	@Autowired
	private DoadorService doadorService;
	
	@Autowired
	private DoadorRepository doadorDAO;
	
	@GetMapping("/")
	public String index() {
		return "home";
	}
	
	@GetMapping("/somos")
	public String somos() {
		return "somos";
	}
	
	@GetMapping("/cadastro-doador")
	public String doador() {
		return "cadastro-doador";
	
	}
	
	@GetMapping("/cadastro-donatario")
	public String donatario() {
		return "cadastro-donatario";
	}

	
	@GetMapping("/home-logado")
	public String logado() {
		return "home-logado";
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	

	@GetMapping("/anuncio")
	public String anuncio() {
		return "anuncio";
	}
	

	@GetMapping("/esqueceu-senha")
	public String recuperar() {
		return "esqueceu-senha";
	}
	
	
	
	
	
	@PostMapping("/salvar-doador")
	public String novoDoador(Doador doador, String verificarSenha) {
		System.out.println("oi, cheguei");
		//Verificação de e-mail cadastro no banco de dados,
		if(doadorDAO.existsByTelefone(doador.getTelefone())) {
			return "redirect:/cadastro-doador";
		}
		if(doadorDAO.existsByCpf(doador.getCpf())) {
			return "redirect:/cadastro-doador";
		}
		//Verificação das senhas de cadastro
		if(!doador.getSenha().equals(verificarSenha)) {
			return "redirect:/cadastro-doador";
		}
		
		doadorService.save(doador);
		return "redirect:/";
	}
	
	
	
	
}
