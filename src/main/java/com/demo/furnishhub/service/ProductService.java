package com.demo.furnishhub.service;

import com.demo.furnishhub.entity.Product;

import java.util.List;

public interface ProductService {
    Product getProduct(Long id);
    Product saveProduct(Product product);
    void deleteProduct(Long id);
    List<Product> getProducts();
}