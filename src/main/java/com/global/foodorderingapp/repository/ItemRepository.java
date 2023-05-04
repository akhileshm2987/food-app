package com.global.foodorderingapp.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.foodorderingapp.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Serializable> {

}
