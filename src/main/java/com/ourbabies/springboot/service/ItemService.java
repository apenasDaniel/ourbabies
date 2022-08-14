package com.ourbabies.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ourbabies.springboot.model.Item;
import com.ourbabies.springboot.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemDAO;
	//Salvar item
	public Item save(Item item) {
		return itemDAO.save(item);		
	}

}