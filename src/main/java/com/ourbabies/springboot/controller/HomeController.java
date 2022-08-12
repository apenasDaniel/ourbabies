package com.ourbabies.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ourbabies.springboot.model.Usuario;
import com.ourbabies.springboot.repository.UsuarioRepository;
import com.ourbabies.springboot.service.UsuarioService;

@Controller
public class HomeController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioDAO;
	
	
	@GetMapping("/home")
	public String index(HttpSession session) {
	//	session.setAttribute("usuario", "daniel");
		return "home";
	}
	
	@GetMapping("/somos")
	public String somos() {
		return "somos";
	}
	
	@GetMapping("/cadastro-usuario")
	public String usuario() {
		return "cadastro-usuario";
	
	}

	
	@GetMapping("/home-logado")
	public String logado(Model model, HttpSession session) {
		Usuario usuarioDados =  (Usuario) session.getAttribute("usuarioDados");
		System.out.println(usuarioDados);
		if(usuarioDados != null) {
		      model.addAttribute("usuarioSessao", usuarioDados);
		      return "home-logado";
		} else {
			return "redirect:/login";
		}
		
	}
	

	
	

	@GetMapping("/esqueceu-senha")
	public String recuperar() {
		return "esqueceu-senha";
	}
	
	
	@PostMapping("/salvar-usuario")
	public String novoUsuario(Usuario usuario, String verificarSenha) {
		//Verificação de e-mail cadastro no banco de dados,
	
		if(usuarioDAO.existsByCpf(usuario.getCpf())) {
			return "redirect:/cadastro-usuario";
		}
		//Verificação das senhas de cadastro
		if(!usuario.getSenha().equals(verificarSenha)) {
			return "redirect:/cadastro-usuario";
		}
		
		usuarioService.save(usuario);
		return "redirect:/home";
	}
	
	

	
	
	
}
