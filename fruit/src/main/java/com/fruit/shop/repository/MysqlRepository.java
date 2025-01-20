package com.fruit.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fruit.shop.model.Fruit;

@Repository
public interface MysqlRepository extends JpaRepository<Fruit,  Integer>{

}
