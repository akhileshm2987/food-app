package com.global.foodorderingapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemModel {

	private String itemName;
    private String category;
	private Integer quantity;
	private Double cost;
	
}
