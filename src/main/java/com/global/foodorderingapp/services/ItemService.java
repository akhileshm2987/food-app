package com.global.foodorderingapp.services;

import java.util.List;

import com.global.foodorderingapp.entity.Item;
import com.global.foodorderingapp.model.ItemModel;

public interface ItemService {

	public boolean addItemToCart(Item item);
	
	public List<Item> dynamicSearch(ItemModel itemModel);
	
	public List<Item> getAllItem();
	
	public boolean removeItemById(Integer itemId);
}
