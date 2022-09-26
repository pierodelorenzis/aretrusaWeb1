package com.example.aretusaWeb1.controller;

import com.example.aretusaWeb1.facade.UserFacade;
import com.example.aretusaWeb1.model.User;
import com.example.aretusaWeb1.view.UiUser;
import com.example.aretusaWeb1.view.networkUi.BasicResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
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
    public BasicResponse<UiUser> read(@PathVariable("id") ObjectId idUser) {
        BasicResponse<UiUser> uiUserBasicResponse = new BasicResponse<UiUser>(0, "ok", userFacade.findById(idUser).getBody());
        return uiUserBasicResponse;
    }

    //Aggiungi nuovo user ricevendo un JSON
    @PostMapping({"/newUser"})
    public BasicResponse<UiUser> newUser(@RequestBody User newUser) {
        BasicResponse<UiUser> uiUserBasicResponse = new BasicResponse<UiUser>(0, "ok", (UiUser) userFacade.save(newUser).getBody());
        return uiUserBasicResponse;
    }

    //Elimina uno user per ID inserito
    @DeleteMapping("/delete/{id}")
    void deleteUser(@PathVariable("id") ObjectId idUser) {
        userFacade.deleteById(idUser);
    }

    //Sostituisce User per ID inserito e ricevendo un JSON
    @PutMapping("/edit/{id}")
    User editUser (@RequestBody User newUser, @PathVariable("id") ObjectId idUser) {
        return userFacade.editUser(idUser, newUser);
    }

}
