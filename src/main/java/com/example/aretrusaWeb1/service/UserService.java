package com.example.aretrusaWeb1.service;

import com.example.aretrusaWeb1.model.Author;
import com.example.aretrusaWeb1.model.User;
import com.example.aretrusaWeb1.repository.AuthorRepository;
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
        User fakeUser = new User("email@gmail.com", "user", "password", "jkahkghak23r89", "nome", "cognome", date, "sex", "city", "address", "31251516", "role");
        return fakeUser;
    }



    //Trova tutti gli autori
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    //Trova gli autori per ID
    public Optional<User> findById(String cf) {
        Optional<User> foundUser = this.userRepository.findById(cf);
        return foundUser.isEmpty() ? Optional.empty() : foundUser;
    }


    //aggiunge un nuovo autore
    public User createUser(String cf, String name, String lastName){
        User toCreate = new User();
        toCreate.setCf(cf.trim());
        toCreate.setName(name.trim());
        toCreate.setSurname(lastName.trim());
        try {
            this.userRepository.save(toCreate);
        }catch (Exception e){
            return null;
        }
        return toCreate;
    }

    //Elimina un autore
    public void deleteById(String cf) {
        userRepository.deleteById(cf);
    }

    //Sostituisce un autore
    public User editUser(String cf, User newUser) {
        return userRepository.findById(cf)
                .map(author -> {
                    author.setName(newUser.getName());
                    author.setSurname(newUser.getSurname());
                    return userRepository.save(author);
                })
                .orElseGet(() -> {
                    newUser.setCf(cf);
                    return userRepository.save(newUser);
                });
    }

}
