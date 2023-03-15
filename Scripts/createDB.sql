CREATE DATABASE GuitarTunerDB;

USE GuitarTunerDB;

Create table Tuning (
    -> id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    -> category VARCHAR(255),
    -> subcategory VARCHAR(255),
    -> name VARCHAR(255),
    -> s1 TINYINT(255),
    -> s2 TINYINT(255),
    -> s3 TINYINT(255),
    -> s4 TINYINT(255),
    -> s5 TINYINT(255),
    -> s6 TINYINT(255)
    -> 
);
