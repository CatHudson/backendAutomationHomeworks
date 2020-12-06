package com.geekbrains.BackendAutomation.controllers;

import com.geekbrains.BackendAutomation.entities.Product;
import com.geekbrains.BackendAutomation.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts () {
        return productRepository.findAll();
    }

    @PostMapping("/save")
    public String addNewProduct (@RequestBody Product product) {
        product.setId(null);
        productRepository.save(product);
        return ("Product " + product.getTitle() + " has been saved correctly!") ;
    }

    @GetMapping("/filtered")
    public List<Product> getAllProductsPriceMoreThan (@RequestParam int min_price) {
        return productRepository.findAllProductsPriceMoreThan(min_price);
    }

    @GetMapping("/delete/{id}")
    public String deleteById (@PathVariable Long id) {
        productRepository.deleteById(id);
        return "Product#" + id + " has been deleted.";
    }

    @Transactional
    @PutMapping("/{id}/change_title")
    public void changeTitleById (@PathVariable Long id, @RequestParam String title) {
        productRepository.updateProductTitleById(title, id);
    }

}
