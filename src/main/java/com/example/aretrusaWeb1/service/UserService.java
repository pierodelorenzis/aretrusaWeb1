package com.example.aretrusaWeb1.service;

import com.example.aretrusaWeb1.model.User;
import com.example.aretrusaWeb1.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User getFakeUser()
    {
        Date date = new Date(2020-12-20);
        User fakeUser = new User("email@gmail.com", "user", "password", "jkahkghak23r89", "nome", "cognome", date, "sex", "city", "address", "31251516", User.Role.Admin);
        return fakeUser;
    }



    //Trova tutti gli user
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    //Trova gli user per ID
    public Optional<User> findById(ObjectId id) {
        Optional<User> foundUser = this.userRepository.findById(id);
        return foundUser.isEmpty() ? Optional.empty() : foundUser;
    }


    //aggiunge un nuovo user
    public User createUser(ObjectId id, String name, String lastName){
        User toCreate = new User();
        toCreate.setId(id);
        toCreate.setName(name.trim());
        toCreate.setSurname(lastName.trim());
        try {
            this.userRepository.save(toCreate);
        }catch (Exception e){
            return null;
        }
        return toCreate;
    }

    //Elimina uno user
    public void deleteById(ObjectId id) {
        userRepository.deleteById(id);
    }

    //Modifica uno user
    public User editUser(ObjectId id, User newUser) {
        return userRepository.findById(id)
                .map(author -> {
                    author.setName(newUser.getName());
                    author.setSurname(newUser.getSurname());
                    return userRepository.save(author);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return userRepository.save(newUser);
                });
    }

}
