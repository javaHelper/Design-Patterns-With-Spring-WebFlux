package com.vinsguru.cacheaside.service.impl;

import com.vinsguru.cacheaside.dto.ProductDto;
import com.vinsguru.cacheaside.entity.Product;
import com.vinsguru.cacheaside.repository.ProductRepository;
import com.vinsguru.cacheaside.service.ProductService;
import com.vinsguru.cacheaside.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Service
@ConditionalOnProperty(name = "cache.enabled", havingValue = "false")
public class ProductServiceWithNoCache implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Mono<ProductDto> getProduct(Integer id) {
        return this.productRepository.findById(id)
                .map(EntityDtoUtil::toDto);
    }

    @Override
    public Mono<Void> updateProduct(Integer id, Mono<ProductDto> mono) {
        return this.productRepository.findById(id)
                .zipWith(mono)
                .doOnNext(t -> {
                    Product p = t.getT1();
                    p.setQtyAvailable(t.getT2().getQuantityAvailable());
                    p.setDescription(t.getT2().getDescription());
                    p.setPrice(t.getT2().getPrice());
                })
                .map(Tuple2::getT1)
                .flatMap(this.productRepository::save)
                .then();
    }
}