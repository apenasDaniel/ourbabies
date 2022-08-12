package com.ourbabies.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ourbabies.springboot.model.Item;
import com.ourbabies.springboot.service.ItemService;

@Controller
public class AnuncioController {
	
	private ItemService itemService;

	@GetMapping("/anuncio")
	public String anuncio() {
		return "anuncio";
	}
	
	@PostMapping("/salvar-item")
	public String novoItem(Item item) {
		
		itemService.save(item);
		
		return "redirect:/home";
		
	}
	
	
}
