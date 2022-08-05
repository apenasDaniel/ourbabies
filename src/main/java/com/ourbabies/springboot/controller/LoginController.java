package com.ourbabies.springboot.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ourbabies.springboot.model.Doador;
import com.ourbabies.springboot.service.DoadorService;
import com.ourbabies.springboot.service.LoginService;


@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	

	@GetMapping("/login")
	public String login(Doador doador) {
	//	String usuario = (String) session.getAttribute("usuario");
	//	System.out.println(usuario);
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("doadorDados");
		return "logout";
	}
  
	
    @PostMapping("/efetuarLogin")
    public String efetuarLogin(Doador doador, HttpSession session) {
//        System.out.println(doador.getCpf());
//        System.out.println(doador.getSenha());
    	Doador doadorLogado = loginService.logar(doador);
    	System.out.println(doadorLogado.getEmail());
    
    	
    	if (doadorLogado != null) {
    		session.setAttribute("doadorDados", doadorLogado);
         	  return "redirect:/home-logado";
    	 } else {
    		 return "redirect:/login";
    	 } 
    }
   
}
	
	
	

	
	
	



