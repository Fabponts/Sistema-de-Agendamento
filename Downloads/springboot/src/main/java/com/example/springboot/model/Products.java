package com.example.springboot.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_PRODUCTS")

public class Products implements Serializable {
    private static final long serialVersionUID = 1L;

    //Entities of the BDG
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private BigDecimal value;

    //Getters and Setters
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
