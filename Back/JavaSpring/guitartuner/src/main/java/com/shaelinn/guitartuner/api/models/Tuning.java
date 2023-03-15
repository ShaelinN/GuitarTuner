package com.shaelinn.guitartuner.api.models;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Table(name = "Tuning")
public class Tuning {
    @Id 
    @GenericGenerator(name = "tuningIdGen", strategy = "increment")
    @GeneratedValue(generator = "tuningIdGen")
    @Column(name = "id")
    int id;


    @Column(name = "name") String name;
    @Column(name = "category") String category;
    @Column(name = "subcategory") String subCategory;


    @Column(name = "s1") int s1;
    @Column(name = "s2") int s2;
    @Column(name = "s3") int s3;
    @Column(name = "s4") int s4;
    @Column(name = "s5") int s5;
    @Column(name = "s6") int s6;

    // default constructor for hibernate
    public Tuning() {

    }

    public Tuning(String name, String category, String subCategory, List<Integer> notes) {
        this.name = name;
        this.category = category;
        this.subCategory = subCategory;
        this.s1 = notes.get(5);
        this.s2 = notes.get(4);
        this.s3 = notes.get(3);
        this.s4 = notes.get(2);
        this.s5 = notes.get(1);
        this.s6 = notes.get(0);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public int getS1() {
        return s1;
    }

    public int getS2() {
        return s2;
    }

    public int getS3() {
        return s3;
    }

    public int getS4() {
        return s4;
    }

    public int getS5() {
        return s5;
    }

    public int getS6() {
        return s6;
    }
    
}
