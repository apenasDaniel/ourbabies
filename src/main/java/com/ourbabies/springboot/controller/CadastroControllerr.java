package com.ourbabies.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ourbabies.springboot.model.Item;
import com.ourbabies.springboot.model.Usuario;
import com.ourbabies.springboot.repository.UsuarioRepository;
import com.ourbabies.springboot.service.ItemService;
import com.ourbabies.springboot.service.UsuarioService;

@Controller
public class CadastroControllerr {

	

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioRepository usuarioRepository;

	
	// MÉTODO GET DA PÁGINA DE CADASTRO.
	@GetMapping("/cadastro-usuario")
	public String usuario() {
		return "cadastro-usuario";
	}

	

	// MÉTODO POST, VERIFICA SE USUÁRIO EXISTE, E ALGUMAS VALIDAÇÕES.
	@PostMapping("/salvar-usuario")
	public ModelAndView novoUsuario(String verificarSenha, @Valid @ModelAttribute(value = "Usuario") Usuario usuario,
			BindingResult result, Model model) {
		
		// Verificação de e-mail cadastro no banco de dados,
		ModelAndView modelAndView;
		System.out.println(verificarSenha);
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("cadastro-usuario");
			modelAndView.addObject("usuario", usuario);
			ArrayList<String> listaErros = new ArrayList<String>();
			for (ObjectError objectError : result.getAllErrors()) {
				listaErros.add(objectError.getDefaultMessage());
			}
			if (!usuario.getSenha().equals(verificarSenha)) {
				listaErros.add("A senha não combina");
			}
			modelAndView.addObject("msg", listaErros);
			return modelAndView;
		} else {
			if (usuarioRepository.existsByCpf(usuario.getCpf())) {
				modelAndView = new ModelAndView("cadastro-usuario");
				return modelAndView;
			}
			
			// Verificação das senhas de cadastro

			usuarioService.save(usuario);
			modelAndView = new ModelAndView("/login");
			return modelAndView;
		}

	}

}
