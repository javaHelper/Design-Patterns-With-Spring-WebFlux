package com.vinsguru.sink;

import com.vinsguru.api.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class StreamController {

    @Autowired
    private Flux<Product> flux;

    @GetMapping(value = "product-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> getJoke(){
        return flux;
    }

}