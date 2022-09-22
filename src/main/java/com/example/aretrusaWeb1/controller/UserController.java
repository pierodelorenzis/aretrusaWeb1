package com.example.aretrusaWeb1.controller;

import com.example.aretrusaWeb1.facade.UserFacade;
import com.example.aretrusaWeb1.model.User;
import com.example.aretrusaWeb1.view.UiUser;
import org.bson.types.ObjectId;
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

    //Mostra UiUser per ID inserito
    @GetMapping({"/find/{id}"})
    public ResponseEntity<UiUser> read(@PathVariable("id") ObjectId id) {
        return userFacade.findById(id);
    }

    //Aggiungi nuovo user ricevendo un JSON
    @PostMapping({"/newUser"})
    public ResponseEntity<User> newUser (@RequestBody User newUser) {
        return this.userFacade.save(newUser);
    }

    //Elimina uno user per ID inserito
    @DeleteMapping("/delete/{id}")
    void deleteUser(@PathVariable("id") ObjectId id) {
        userFacade.deleteById(id);
    }

    //Sostituisce User per ID inserito e ricevendo un JSON
    @PutMapping("/edit/{id}")
    User editUser (@RequestBody User newUser, @PathVariable("id") ObjectId id) {
        return userFacade.editUser(id, newUser);
    }

}
