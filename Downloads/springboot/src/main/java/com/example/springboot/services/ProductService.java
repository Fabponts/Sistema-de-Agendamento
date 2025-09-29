package com.example.springboot.services;

import com.example.springboot.model.Products;
import com.example.springboot.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Products> showProducts() {
        return productRepository.findAll();
    }

    public Optional<Products> findById(Long id) {
        return productRepository.findById(id);
    }

    public Products save(Products products) {
        return productRepository.save(products);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
}
