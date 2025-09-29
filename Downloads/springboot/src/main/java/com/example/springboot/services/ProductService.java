package com.example.springboot.services;

import com.example.springboot.exeception.ItemNotFound;
import com.example.springboot.model.Products;
import com.example.springboot.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Products> showProducts() {
        return productRepository.findAll();
    }

    public Products findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ItemNotFound("Product with: " + id + " not found"));
    }

    public Products save(Products products) {
        return productRepository.save(products);
    }

    public void deleteById(Long id){
        if(! productRepository.existsById(id)){
            throw new ItemNotFound("Product with: " + id + " not found");
        }
        productRepository.deleteById(id);
    }
}
