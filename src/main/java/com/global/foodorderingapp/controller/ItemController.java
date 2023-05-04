package com.global.foodorderingapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.foodorderingapp.entity.Item;
import com.global.foodorderingapp.model.ItemModel;
import com.global.foodorderingapp.service.impl.ItemServiceIMPL;

@RestController
@RequestMapping(value = "/food/order")
public class ItemController {

	@Autowired
	private ItemServiceIMPL itemServiceIMPL;

	public static final String item_saved_Y = "item_saved";
	public static final String item_saved_N = "item_failed";
	private static final Logger log = LoggerFactory.getLogger(ItemController.class);

	@PostMapping
	public ResponseEntity<String> addItemToCart(Item item) {
		try {
			boolean savedItem = itemServiceIMPL.addItemToCart(item);
			if (savedItem) {
				log.info("item saved successfully");
				return new ResponseEntity<String>(item_saved_Y, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			log.error("error ocurred in saveItem method" + e.getMessage());
		}
		log.info("item not saved successfully");
		return new ResponseEntity<String>(item_saved_N, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("/dynamicSearchItem")
	public List<Item> dynamicSearch(@RequestBody ItemModel itemModel) {
		List<Item> list = itemServiceIMPL.dynamicSearch(itemModel);
		return list;
	}

	@GetMapping
	public ResponseEntity<List<Item>> getAllItem() {
		log.debug("getAllContacts method started");
		List<Item> allItem = null;
		try {
			allItem = itemServiceIMPL.getAllItem();
			if (allItem.isEmpty()) {
				log.info("item is not available...plz check database");
			}
		} catch (Exception e) {
			log.error("getAllItem method not working as expected" + e.getMessage());
		}
		log.debug("getAllItem method ended");
		return new ResponseEntity<List<Item>>(allItem, HttpStatus.OK);
	}

	@DeleteMapping("/deleteItem")
	public ResponseEntity<String> removeItemById(Integer itemId) {
		log.debug("** deleteItemById() -  method started ** ");
		ResponseEntity<String> responseEntity = null;
		try {
			boolean isDeleted = itemServiceIMPL.removeItemById(itemId);
			if (isDeleted)
				log.info("**removeItemById()**- record deleted successfullu");
			responseEntity = new ResponseEntity<>("deleted successfull" + "y", HttpStatus.OK);
		} catch (Exception e) {
			log.error("**Exception occured**" + e.getMessage());
		}
		log.debug("** removeItemById() -  method ended ** ");
		responseEntity = new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		return responseEntity;
	}
}
