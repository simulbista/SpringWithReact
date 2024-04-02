package com.simul.wisdompet.web.rest;


import com.simul.wisdompet.data.services.CustomerService;
import com.simul.wisdompet.web.errors.BadRequestException;
import com.simul.wisdompet.web.models.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {


    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<Customer> getAll(@RequestParam(name = "email", required = false) String email){
        return this.customerService.getAllCustomers(email);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer){
        return this.customerService.createOrUpdateCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") long id){
        return this.customerService.getCustomer(id);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer){

        if(id!=customer.getCustomerId()){
            throw new BadRequestException("Id in path and body do not match!");
        }
        return this.customerService.createOrUpdateCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") long id){
        this.customerService.deleteCustomer(id);
    }
}
