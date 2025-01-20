package com.fruit.shop.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fruit.shop.model.Fruit;
import com.fruit.shop.repository.MysqlRepository;

@RestController
@RequestMapping("/fruit")
public class FruitController {
	
	@Autowired
	MysqlRepository mysqlrepository;
	
	@GetMapping("/list")
	public List<Fruit> getFruitDetails() {
		return mysqlrepository.findAll();
	}
	
	@GetMapping("/detail/{id}")
	public Fruit getSingleFruitDetail(@PathVariable("id")Integer id) {
		return mysqlrepository.findById(id).get();
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteFruit(@PathVariable("id")Integer id) {
		if( !mysqlrepository.findById(id).equals(Optional.empty())) {
			mysqlrepository.deleteById(id);
		}
		return true;
	}
	
	@PutMapping("/update/{id}")
	public Fruit updateFruit(@PathVariable("id")Integer id, @RequestBody Map<String, String>body) {
		Fruit fruit = mysqlrepository.findById(id).get();		
		fruit.setId(Integer.parseInt(body.get("id")));
		fruit.setName(body.get("name"));
		fruit.setPrice(Integer.parseInt(body.get("price")));
		mysqlrepository.save(fruit);
		return fruit;
	}
	
	@PostMapping("/add")
	public Fruit addFruit(@RequestBody Map<String, String>body) {		
		Integer id = Integer.parseInt(body.get("id"));
		String name = body.get("name");
		Integer price = Integer.parseInt(body.get("price"));
		Fruit fruit = new Fruit(id, name, price);
		mysqlrepository.save(fruit);
		return fruit;
	}
}
