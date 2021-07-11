# JooqTestProject
This program is written in java using jooq's code generator to run SQL queries.
The following database was created using MySQL workbench 8.0 and used in the program.

CREATE DATABASE `test`;

USE `test`;

CREATE TABLE `student` (
  `id` int NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
