package com.ourbabies.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ourbabies.springboot.model.Item;
import com.ourbabies.springboot.model.Usuario;
import com.ourbabies.springboot.service.ItemService;



@Controller
public class LogadoController {

	@Autowired
	private ItemService itemService;
	

	// GUARDA OS DADOS DO USUÁRIO AO SE CADASTRAR, USANDO A SESSION.
	@GetMapping("/home-logado")
	public String logado(Model model, HttpSession session) {
		Usuario usuarioDados = (Usuario) session.getAttribute("usuarioDados");

		List<Item> listaItens = itemService.getAllItem();

		if (usuarioDados != null) {
			model.addAttribute("usuarioSessao", usuarioDados);
			model.addAttribute("itens", listaItens);
			return "home-logado";
		} else {
			return "redirect:/login";
		}
	}
	
	
	
	
}
