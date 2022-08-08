package com.ourbabies.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	
	@GetMapping("/home")
	public String index(HttpSession session) {
	//	session.setAttribute("usuario", "daniel");
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

	
	@GetMapping("/home-logado")
	public String logado(Model model, HttpSession session) {
		Doador doadorDados =  (Doador) session.getAttribute("doadorDados");
		System.out.println(doadorDados);
		if(doadorDados != null) {
		      model.addAttribute("doadorSessao", doadorDados);
		      return "home-logado";
		} else {
			return "redirect:/login";
		}
		
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
		//Verificação de e-mail cadastro no banco de dados,
	
		if(doadorDAO.existsByCpf(doador.getCpf())) {
			return "redirect:/cadastro-doador";
		}
		//Verificação das senhas de cadastro
		if(!doador.getSenha().equals(verificarSenha)) {
			return "redirect:/cadastro-doador";
		}
		
		doadorService.save(doador);
		return "redirect:/home";
	}
	
	

	
	
	
}
