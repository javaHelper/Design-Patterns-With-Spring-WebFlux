package com.vinsguru.cacheaside.repository;

import com.vinsguru.cacheaside.entity.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<Product, Integer> {
}