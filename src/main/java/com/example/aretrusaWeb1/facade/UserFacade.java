package com.example.aretrusaWeb1.facade;

import com.example.aretrusaWeb1.model.User;
import com.example.aretrusaWeb1.service.UserService;
import com.example.aretrusaWeb1.view.UiUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserFacade {

    @Autowired
    UserService userService;

    public UiUser createFakeUser() throws ParseException {
        User fakeUser = userService.getFakeUser();
        return new UiUser(fakeUser);
    }


    //Cerca tutti gli UiUser
    public List<UiUser> findAll() {
        return userService.findAll().stream().map(UiUser::new).collect(Collectors.toList());
    }

    //Trova gli UiUser per ID
    public ResponseEntity<UiUser> findById(String cf) {
        final Optional<User> byId = userService.findById(cf);
        if (byId.isPresent()){
            return ResponseEntity.ok(new UiUser(byId.get()));
        } else {
            return  ResponseEntity.notFound().build();
        }
    }

    //aggiunge un nuovo user
    public ResponseEntity save(User newUser) {
        return ResponseEntity.ok(userService.createUser(newUser.getCf(), newUser.getName(), newUser.getSurname()));
    }

    //Elimina uno user per ID
    public void deleteById(String cf) {
        userService.deleteById(cf);
    }

    //Sostituisce uno user
    public User editUser(String cf, User newUser){
        return userService.editUser(cf, newUser);
    }
}
