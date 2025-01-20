create database fruit_shop;

use fruit_shop;

CREATE TABLE `fruit_shop`.`fruit` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `price` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

  
INSERT INTO fruit (`id`,`name`,`price`) VALUES (101,'apple',50);
INSERT INTO fruit (`id`,`name`,`price`) VALUES (102,'orange',20);
INSERT INTO fruit (`id`,`name`,`price`) VALUES (103,'grapes',25);
