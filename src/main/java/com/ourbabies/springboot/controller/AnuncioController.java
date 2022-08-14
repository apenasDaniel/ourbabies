package com.ourbabies.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ourbabies.springboot.model.Item;
import com.ourbabies.springboot.model.StatusServico;
import com.ourbabies.springboot.service.ItemService;

import ch.qos.logback.core.util.StatusPrinter;

@Controller
public class AnuncioController {
	
	@Autowired
	private ItemService itemService;

	@GetMapping("/anuncio")
	public ModelAndView anuncio() {
		ModelAndView mv = new ModelAndView("anuncio");
		mv.addObject("statusServico", StatusServico.values());
		
		return mv;
	}
	
	@PostMapping("/salvar-item")
	public String novoItem(Item item) {
		itemService.save(item);
		
		return "redirect:/home";
		
	}
	
	
}
