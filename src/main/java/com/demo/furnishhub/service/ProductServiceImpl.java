package com.demo.furnishhub.service;

import com.demo.furnishhub.entity.Product;
import com.demo.furnishhub.exception.EntityNotFoundException;
import com.demo.furnishhub.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public Product getProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return unwrapProduct(product, id);
    }

    @Override
    public Product saveProduct(Product course) {
        return productRepository.save(course);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getProducts() {
        return (List<Product>)productRepository.findAll();
    }

    static Product unwrapProduct(Optional<Product> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Product.class);
    }
}

