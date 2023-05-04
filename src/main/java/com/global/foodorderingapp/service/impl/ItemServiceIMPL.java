package com.global.foodorderingapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.global.foodorderingapp.entity.Item;
import com.global.foodorderingapp.globalexception.RecordNotFoundException;
import com.global.foodorderingapp.model.ItemModel;
import com.global.foodorderingapp.repository.ItemRepository;
import com.global.foodorderingapp.services.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

@Service
public class ItemServiceIMPL implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public boolean addItemToCart(Item item) {
		Item itemSaved = itemRepository.save(item);
		return null != itemSaved.getItemId();
	}

	public List<Item> dynamicSearch(ItemModel itemModel) {

		Item item = new Item();

		if (null != itemModel.getCategory() && !"".equals(itemModel.getCategory())) {
			item.setCategory(itemModel.getCategory());
		}

		if (null != itemModel.getItemName() && !"".equals(itemModel.getItemName())) {
			item.setItemName(itemModel.getItemName());
		}

		Example<Item> example = Example.of(item);
		List<Item> result = itemRepository.findAll(example);
		return result;
	}

	@Override
	public List<Item> getAllItem() {
		return itemRepository.findAll();

	}

	@Override
	public boolean removeItemById(Integer itemId) {
		try {
			itemRepository.deleteById(itemId);
			return true;
		} catch (Exception e) {
			throw new RecordNotFoundException("no record found to delete");
		}

	}

}
