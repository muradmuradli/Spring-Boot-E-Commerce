package com.demo.furnishhub.repository;

import com.demo.furnishhub.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
