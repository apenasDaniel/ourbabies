package com.ourbabies.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourbabies.springboot.model.Item;
import com.ourbabies.springboot.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	//Salvar item escolhido
	public Item save(Item item) {
		return itemRepository.save(item);		
	}
	
	public List<Item> getAllItem(){
	    return itemRepository.findAll();
	  }

}
