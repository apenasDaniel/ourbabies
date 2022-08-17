package com.ourbabies.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticController {
	
	
	 //PÁGINAS ESTÁTICAS.
	
	
	   //MÉTODO GET DA HOME.
		@GetMapping("/home")
		public String index(HttpSession session) {
			return "home";
		}

		
		//MÉTODO GET DE QUEM SOMOS.
		@GetMapping("/somos")
		public String somos() {
			return "somos";
		}

		
	   //MÉTODO GET DE PÁGINA DE ERRO.
		@GetMapping("/error")
		public String errorPage() {
			return "redirect:/error";
		  }

			
		//MÉTODO GET DA PÁGINA RECUPERAÇÃO DE SENHA.
		@GetMapping("/esqueceu-senha")
		public String recuperar() {
			return "esqueceu-senha";
		}
		
}

	
	
	
	
	
	
	
	
	
	
	
	
	

