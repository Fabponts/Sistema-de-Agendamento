package com.example.springboot.controller;

import com.example.springboot.model.Products;
import com.example.springboot.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Products> listProducts(){
        return productService.showProducts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Long id){
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Products createProduct(@RequestBody Products product){
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long id){
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
