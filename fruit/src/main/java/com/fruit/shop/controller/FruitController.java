package com.fruit.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fruit.shop.model.Fruit;
import com.fruit.shop.repository.MysqlRepository;

@RestController
public class FruitController {
	
	@Autowired
	MysqlRepository mysqlrepository;
	
	@GetMapping("/fruits-list")
	public List<Fruit> getFruitDetails() {
		return mysqlrepository.findAll();
	}
}
