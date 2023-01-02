package com.vinsguru.api;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class DataGenerator {
    private List<CardDetails> cardDetails = new ArrayList<>();

    @PostConstruct
    public void getProducts(){
        Faker faker = new Faker();
        for (int i = 1; i <= 1000; i++) {
            String creditCardExpiry = faker.business().creditCardExpiry();
            String cardNumber = faker.business().creditCardNumber();
            String creditCardType = faker.business().creditCardType();

            CardDetails cd = CardDetails.builder()
                    .id(i)
                    .creditCardNumber(cardNumber)
                    .cardType(creditCardType)
                    .creditCardExpiry(creditCardExpiry)
                    .build();

            cardDetails.add(cd);
        }
    }

    public CardDetails findCardDetail(){
        int i = ThreadLocalRandom.current().nextInt(1, 1000);
        return cardDetails.get(i);
    }
}