create database java_28_db;
use java_28_db;
CREATE TABLE addresses (
     id int NOT NULL AUTO_INCREMENT,
     city varchar(20) NOT NULL,
     street varchar(50) NOT NULL,
     house_number int NOT NULL,
     corps int,
     apartment int,
     PRIMARY KEY(id)
     );