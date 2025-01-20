package com.fruit.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fruit.shop.model.Fruit;

public interface MysqlRepository extends JpaRepository<Fruit,  Integer>{}
