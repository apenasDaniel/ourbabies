package com.ourbabies.springboot.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ourbabies.springboot.model.Usuario;
import com.ourbabies.springboot.service.UsuarioService;
import com.ourbabies.springboot.service.LoginService;


@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	
	
	
	//MÉTODO GET PÁGINA LOGIN
	@GetMapping("/login")
	public String login(Usuario usuario) {
		return "login";
	}


   //MÉTODO SAIR DA TELA, (DESLOGAR).
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("usuarioDados");
		return "redirect:/login";
	}

	
	//MÉTODO POST PARA FAZER LOGIN.
	@PostMapping("/efetuarLogin")
	public ModelAndView efetuarLogin(Usuario usuario, HttpSession session) {
		Usuario usuarioLogado = loginService.logar(usuario);
		ModelAndView modelAndView;
        
		try {
			if(usuarioLogado != null) {
				session.setAttribute("usuarioDados", usuarioLogado);
				modelAndView = new ModelAndView("redirect:/home-logado");
				return modelAndView;
			} else { throw new Exception();
			
			}
			
			
		} catch (Exception exc) {
			modelAndView = new ModelAndView("login");
			ArrayList<String> arrayList = new ArrayList();
			arrayList.add("Usuário não encontrado na base");
			modelAndView.addObject("usuarioerro", arrayList);
			return modelAndView;

		}
		
		
	}
}

	
	
	



