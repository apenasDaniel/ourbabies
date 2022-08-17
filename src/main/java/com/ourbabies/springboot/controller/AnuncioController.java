package com.ourbabies.springboot.controller;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ourbabies.springboot.model.Item;
import com.ourbabies.springboot.model.StatusServico;
import com.ourbabies.springboot.service.ItemService;

@Controller
public class AnuncioController {
	
	@Autowired
	private ItemService itemService;

	
	//MÉTODO GET DA TELA DE DOAÇÃO
	@GetMapping("/anuncio")
	public ModelAndView anuncio() {
		ModelAndView mv = new ModelAndView("anuncio");
		mv.addObject("statusServico", StatusServico.values());
		
		return mv;
	}
	
	//MÉTODO POST PARA ENVIAR A DOAÇÃO PARA TELA DE LOGADO
	@PostMapping("/salvar-item")
	public ModelAndView novoItem(@RequestParam("image") MultipartFile multipartFile, @Valid Item item, BindingResult bindingResult) throws IOException {
		if(bindingResult.hasErrors()) {

			ModelAndView mv = new ModelAndView("/anuncio");
			mv.addObject("statusServico", StatusServico.values());
			return mv;
		} else {
		      String path = "src/main/resources/static/images/";
		      File file = new File(path);
		      String filename = System.currentTimeMillis() + multipartFile.getOriginalFilename();
		      String absolutePath = file.getAbsolutePath() + "/" + filename;
		      multipartFile.transferTo(new File(absolutePath));
             System.out.println("OLA");
		      item.setImagem(filename);

		      itemService.save(item);
		      return new ModelAndView("redirect:/home-logado");

		}
	}
}
