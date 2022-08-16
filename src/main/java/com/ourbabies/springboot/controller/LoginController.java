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

	@GetMapping("/login")
	public String login(Usuario usuario) {
		// String usuario = (String) session.getAttribute("usuario");
		// System.out.println(usuario);
		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("usuarioDados");
		return "redirect:/login";
	}

	@PostMapping("/efetuarLogin")
	public ModelAndView efetuarLogin(Usuario usuario, HttpSession session) {
		Usuario usuarioLogado = loginService.logar(usuario);
		// System.out.println(usuarioLogado.getEmail());
		ModelAndView modelAndView;
        
		try {
			if(usuarioLogado != null) {
				session.setAttribute("usuarioDados", usuarioLogado);
				modelAndView = new ModelAndView("home-logado");
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

	
	
	



