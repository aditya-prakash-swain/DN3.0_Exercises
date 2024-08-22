package com.bookstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String address) {

        Customer customer = new Customer(id, name, email, address);
        // Assuming a method to save the customer exists
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }
}
