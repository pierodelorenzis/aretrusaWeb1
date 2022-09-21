package com.example.aretrusaWeb1.service;

import com.example.aretrusaWeb1.model.Aisle;
import com.example.aretrusaWeb1.model.Customer;
import com.example.aretrusaWeb1.repository.CustomerRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    //Trova tutti i clienti
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    //Trova i clienti per ID
    public Optional<Customer> findById(String cf) {
        Optional<Customer> foundCustomer = this.customerRepository.findById(cf);
        return foundCustomer.isEmpty() ? Optional.empty() : foundCustomer;
    }
}
