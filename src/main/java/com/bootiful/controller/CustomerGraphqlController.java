package com.bootiful.controller;

import com.bootiful.client.CustomerClient;
import com.bootiful.record.Customer;
import com.bootiful.record.Profile;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @SchemaMapping(typeName = "Customer")
    Mono<Profile> profile(Customer customer) {
        return Mono.just(new Profile(customer.id()));
    }
}
