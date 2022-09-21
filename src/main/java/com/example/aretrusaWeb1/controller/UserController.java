package com.example.aretrusaWeb1.controller;

import com.example.aretrusaWeb1.facade.UserFacade;
import com.example.aretrusaWeb1.model.User;
import com.example.aretrusaWeb1.view.UiUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserFacade userFacade;

    @GetMapping("/giveMeAUser")
    UiUser getUser() throws ParseException {
        return userFacade.createFakeUser();
    }

    @GetMapping({""})
    public List<UiUser> all() {
        return this.userFacade.findAll();
    }

    //Mostra UiAutore per ID inserito
    @GetMapping({"/find/{cf}"})
    public ResponseEntity<UiUser> read(@PathVariable("cf") String cf) {
        return userFacade.findById(cf);
    }

    //Aggiungi nuovo autore ricevendo un JSON
    @PostMapping({"/newUser"})
    public ResponseEntity<User> newUser (@RequestBody User newUser) {
        return this.userFacade.save(newUser);
    }

    //Elimina un autore per ID inserito
    @DeleteMapping("/delete/{cf}")
    void deleteUser(@PathVariable("cf") String cf) {
        userFacade.deleteById(cf);
    }

    //Sostituisce Autore per ID inserito e ricevendo un JSON
    @PutMapping("/substitute/{cf}")
    User editUser (@RequestBody User newUser, @PathVariable("cf") String cf) {
        return userFacade.editUser(cf, newUser);
    }

}
