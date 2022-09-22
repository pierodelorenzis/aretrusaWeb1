package com.example.aretrusaWeb1.controller;

import com.example.aretrusaWeb1.facade.AuthorFacade;
import com.example.aretrusaWeb1.facade.CustomerFacade;
import com.example.aretrusaWeb1.model.Author;
import com.example.aretrusaWeb1.model.Customer;
import com.example.aretrusaWeb1.view.UiAuthor;
import com.example.aretrusaWeb1.view.UiCustomer;
import com.example.aretrusaWeb1.view.networkUi.BasicResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/customer"})
public class CustomerController {

    @Autowired
    private CustomerFacade customerFacade;

    //Mostra tutti i clienti
    @GetMapping({""})
    public List<UiCustomer> all() {
        return this.customerFacade.findAll();
    }

    //Mostra UiAutore per ID inserito
    @GetMapping({"/find/{id}"})
    public BasicResponse<UiCustomer> read(@PathVariable("id") ObjectId id) {
        BasicResponse<UiCustomer> uiCustomerBasicResponse = new BasicResponse<UiCustomer>(0, "ok", customerFacade.findById(id).getBody());
        return uiCustomerBasicResponse;
    }

    //Aggiungi nuovo cliente ricevendo un JSON
    @PostMapping({"/newCustomer"})
    public BasicResponse<UiCustomer> newCustomer(@RequestBody Customer newCustomer) {
        BasicResponse<UiCustomer> uiCustomerBasicResponse = new BasicResponse<UiCustomer>(0, "ok", (UiCustomer) customerFacade.save(newCustomer).getBody());
        return uiCustomerBasicResponse;
    }

    //Elimina un cliente per ID inserito
    @DeleteMapping("/delete/{id}")
    void deleteCustomer(@PathVariable ObjectId id) {
        customerFacade.deleteById(id);
    }

    //Sostituisce Cliente per ID inserito e ricevendo un JSON
    @PutMapping("/edit/{id}")
    Customer editCustomer (@RequestBody Customer newCustomer, @PathVariable ObjectId id) {
        return customerFacade.editCustomer(id, newCustomer);
    }


    @GetMapping({"/get/{surname}"})
    public BasicResponse<List<UiCustomer>> read(@PathVariable("surname") String surname) {
        BasicResponse<List<UiCustomer>> uiCustomerBasicResponse = new BasicResponse<List<UiCustomer>>(0, "ok", customerFacade.findBySurname(surname).getBody());
        return uiCustomerBasicResponse;
    }
}
