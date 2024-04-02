package com.simul.wisdompet.data.services;

import com.simul.wisdompet.data.entities.CustomerEntity;
import com.simul.wisdompet.data.repositories.CustomerRepository;
import com.simul.wisdompet.web.errors.NotFoundException;
import com.simul.wisdompet.web.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(String filterEmail) {
        List<Customer> customers = new ArrayList<>();

        if (StringUtils.hasLength(filterEmail)) {
            CustomerEntity customerEntity = this.customerRepository.findByEmail(filterEmail);
            customers.add(translateDBToWeb(customerEntity));
        } else {
            Iterable<CustomerEntity> entities = this.customerRepository.findAll();

            entities.forEach(entity -> {
                customers.add(translateDBToWeb(entity));
            });
        }

        return customers;
    }


    public Customer getCustomer(Long customerId) {

        Optional<CustomerEntity> optional = this.customerRepository.findById(customerId);
        if (optional.isEmpty()) {
            throw new NotFoundException("Customer with id " + customerId + " not found!");
        } else {
            return translateDBToWeb(optional.get());
        }
    }

    public Customer createOrUpdateCustomer(Customer customer) {
        CustomerEntity entity = translateWebToDB(customer);
        entity = this.customerRepository.save(entity);
        return translateDBToWeb(entity);
    }

    public void deleteCustomer(Long id) {
        if (this.customerRepository.existsById(id)) {
            this.customerRepository.deleteById(id);
        }
    }

    //convert web entity(Customer) to db entity(Customer Entity)
    private CustomerEntity translateWebToDB(Customer customer) {
        CustomerEntity entity = new CustomerEntity();

        entity.setId(customer.getCustomerId());
        entity.setFirstName(customer.getFirstName());
        entity.setLastName(customer.getLastName());
        entity.setEmail(customer.getEmailAddress());
        entity.setPhone(customer.getPhoneNumber());
        entity.setAddress(customer.getAddress());

        return entity;
    }

    //convert db entity(Customer Entity) to web entity(Customer)
    private Customer translateDBToWeb(CustomerEntity customerEntity) {
        return new Customer(customerEntity.getId(), customerEntity.getFirstName(),
                customerEntity.getLastName(), customerEntity.getEmail(),
                customerEntity.getPhone(), customerEntity.getAddress());
    }

}
