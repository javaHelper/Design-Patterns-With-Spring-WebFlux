package com.vinsguru.service;

import com.vinsguru.client.ProductClient;
import com.vinsguru.client.PromotionClient;
import com.vinsguru.client.ReviewClient;
import com.vinsguru.dto.Price;
import com.vinsguru.dto.ProductAggregate;
import com.vinsguru.dto.ProductResponse;
import com.vinsguru.dto.PromotionResponse;
import com.vinsguru.dto.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProductAggregatorService {
    @Autowired
    private ProductClient productClient;

    @Autowired
    private PromotionClient promotionClient;

    @Autowired
    private ReviewClient reviewClient;

    public Mono<ProductAggregate> aggregate(Integer id) {
        return Mono.zip(
                        this.productClient.getProduct(id),
                        this.promotionClient.getPromotion(id),
                        this.reviewClient.getReviews(id)
                )
                .map(t -> toDto(t.getT1(), t.getT2(), t.getT3()));
    }

    private ProductAggregate toDto(ProductResponse product, PromotionResponse promotion, List<Review> reviews) {
        Double amountSaved = product.getPrice() * promotion.getDiscount() / 100;
        Double discountedPrice = product.getPrice() - amountSaved;

        Price price = new Price(product.getPrice(), promotion.getDiscount(), discountedPrice,amountSaved,promotion.getEndDate());

        return ProductAggregate.create(product.getId(), product.getCategory(), product.getDescription(), price, reviews);
    }
}