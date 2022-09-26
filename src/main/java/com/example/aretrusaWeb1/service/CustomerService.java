package com.example.aretrusaWeb1.service;

import com.example.aretrusaWeb1.model.Customer;
import com.example.aretrusaWeb1.repository.CustomerRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    //Trova tutti i clienti
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    //Trova i clienti per ID
    public Optional<Customer> findById(ObjectId idUser) {
        Optional<Customer> foundCustomer = this.customerRepository.findById(idUser);
        return foundCustomer.isEmpty() ? Optional.empty() : foundCustomer;
    }

    //aggiunge un nuovo cliente
    public Customer createCustomer(String name, String surname, String email, String username, String password, String cf, Date birthdate, String sex, String city, String address, String telephone, float balance, int bookLost, int bookDelay, int bookDamage, int evaluation){
        Customer toCreate = new Customer();
        toCreate.setName(name.trim());
        toCreate.setSurname(surname.trim());
        toCreate.setEmail(email.trim());
        toCreate.setUsername(username.trim());
        toCreate.setPassword(password.trim());
        toCreate.setCf(cf.trim());
        toCreate.setBirthdate(birthdate);
        toCreate.setSex(sex.trim());
        toCreate.setCity(city.trim());
        toCreate.setAddress(address.trim());
        toCreate.setTelephone(telephone.trim());
        toCreate.setBalance(balance);
        toCreate.setBookLost(bookLost);
        toCreate.setBookDelay(bookDelay);
        toCreate.setBookDamage(bookDamage);
        toCreate.setEvaluation(evaluation);
        try {
            this.customerRepository.save(toCreate);
        }catch (Exception e){
            return null;
        }
        return toCreate;
    }

    //Elimina un cliente
    public void deleteById(ObjectId idUser) {
        customerRepository.deleteById(idUser);
    }

    //Modifica un cliente
    public Customer editCustomer(ObjectId idUser, Customer newCustomer) {
        return customerRepository.findById(idUser)
                .map(customer -> {
                    customer.setName(newCustomer.getName());
                    customer.setSurname(newCustomer.getSurname());
                    customer.setEmail(newCustomer.getEmail());
                    customer.setUsername(newCustomer.getUsername());
                    customer.setPassword(newCustomer.getPassword());
                    customer.setBirthdate(newCustomer.getBirthdate());
                    customer.setSex(newCustomer.getSex());
                    customer.setCity(newCustomer.getCity());
                    customer.setAddress(newCustomer.getAddress());
                    customer.setTelephone(newCustomer.getTelephone());
                    customer.setBalance(newCustomer.getBalance());
                    customer.setBookLost(newCustomer.getBookLost());
                    customer.setBookDelay(newCustomer.getBookDelay());
                    customer.setBookDamage(newCustomer.getBookDamage());
                    customer.setEvaluation(newCustomer.getEvaluation());
                    return customerRepository.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setIdUser(idUser);
                    return customerRepository.save(newCustomer);
                });
    }


    public List<Customer> findBySurname(String surname) {
        return customerRepository.findAll().stream().filter(customer -> customer.getSurname().equals(surname)).map(Customer::new).collect(Collectors.toList());
    }
}
