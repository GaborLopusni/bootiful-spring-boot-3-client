package com.bootiful.client;

import com.bootiful.record.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Flux;

public interface CustomerClient {

    @GetExchange("/customers")
    Flux<Customer> all();

    @GetExchange("/customers/{name}")
    Flux<Customer> getByName(@PathVariable String name);
}
