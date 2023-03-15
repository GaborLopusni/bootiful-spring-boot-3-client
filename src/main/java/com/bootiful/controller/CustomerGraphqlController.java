package com.bootiful.controller;

import com.bootiful.client.CustomerClient;
import com.bootiful.record.Customer;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class CustomerGraphqlController {

    private final CustomerClient customerClient;

    public CustomerGraphqlController(CustomerClient customerClient) {
        this.customerClient = customerClient;
    }

    @QueryMapping
    Flux<Customer> customers() {
        return customerClient.all();
    }
    @QueryMapping
    Flux<Customer> customerByName(@Argument String name) {
        return customerClient.getByName(name);
    }
}
