package com.example.aretusaWeb1.facade;

import com.example.aretusaWeb1.model.Customer;
import com.example.aretusaWeb1.service.CustomerService;
import com.example.aretusaWeb1.view.UiCustomer;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerFacade {

    @Autowired
    private CustomerService customerService;


    //Cerca tutti gli UiCustomer
    public List<UiCustomer> findAll() {
        return customerService.findAll().stream().map(UiCustomer::new).collect(Collectors.toList());
    }

    //Trova gli UiCustomer per ID
    public ResponseEntity<UiCustomer> findById(ObjectId idUser) {
        final Optional<Customer> byId = customerService.findById(idUser);
        if (byId.isPresent()){
            return ResponseEntity.ok(new UiCustomer(byId.get()));
        } else {
            return  ResponseEntity.notFound().build();
        }
    }

    //aggiunge un nuovo autore
    public ResponseEntity save(Customer newCustomer) {
        return ResponseEntity.ok(customerService.createCustomer(newCustomer.getName(), newCustomer.getSurname(), newCustomer.getEmail(), newCustomer.getUsername(), newCustomer.getUsername(), newCustomer.getPassword(), newCustomer.getBirthdate(), newCustomer.getCf(), newCustomer.getSex(), newCustomer.getCity(), newCustomer.getAddress(), newCustomer.getBalance(), newCustomer.getBookLost(), newCustomer.getBookDelay(), newCustomer.getBookDamage(), newCustomer.getEvaluation()));
    }

    //Elimina un cliente per ID
    public void deleteById(ObjectId idUser) {
        customerService.deleteById(idUser);
    }

    //Modifica un cliente
    public Customer editCustomer(ObjectId idUser, Customer newCustomer){
        return customerService.editCustomer(idUser, newCustomer);
    }


    public ResponseEntity<List<UiCustomer>> findBySurname(String surname) {
        final List<Customer> bysurname = customerService.findBySurname(surname);
        if (bysurname.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(bysurname.stream().map(UiCustomer::new).collect(Collectors.toList()));
        }
    }
}
