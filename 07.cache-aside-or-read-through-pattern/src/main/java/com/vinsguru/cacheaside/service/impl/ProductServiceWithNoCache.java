package com.vinsguru.cacheaside.service.impl;

import com.vinsguru.cacheaside.dto.ProductDto;
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
        return productRepository.findById(id)
                .map(EntityDtoUtil::toDto);
    }

    @Override
    public Mono<Void> updateProduct(Integer id, Mono<ProductDto> productDto) {
        return productRepository.findById(id)
                .zipWith(productDto)
                .doOnNext(t -> t.getT1().setQtyAvailable(t.getT1().getQtyAvailable()))
                .map(Tuple2::getT1)
                .flatMap(p -> productRepository.save(p))
                .then();
    }
}