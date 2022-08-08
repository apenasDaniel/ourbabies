package com.ourbabies.springboot.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ourbabies.springboot.model.Usuario;
import com.ourbabies.springboot.service.UsuarioService;
import com.ourbabies.springboot.service.LoginService;


@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	

	@GetMapping("/login")
	public String login(Usuario usuario) {
	//	String usuario = (String) session.getAttribute("usuario");
	//	System.out.println(usuario);
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("usuarioDados");
		return "redirect:/login";
	}
  
	
    @PostMapping("/efetuarLogin")
    public String efetuarLogin(Usuario usuario, HttpSession session) {
//        System.out.println(doador.getCpf());
//        System.out.println(doador.getSenha());
    	Usuario usuarioLogado = loginService.logar(usuario);
    	System.out.println(usuarioLogado.getEmail());
    
    	
    	if (usuarioLogado != null) {
    		session.setAttribute("usuarioDados", usuarioLogado);
         	  return "redirect:/home-logado";
    	 } else {
    		 return "redirect:/login";
    	 } 
    }
   
}
	
	
	

	
	
	



