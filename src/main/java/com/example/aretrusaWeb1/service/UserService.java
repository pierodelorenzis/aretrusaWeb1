package com.example.aretrusaWeb1.service;

import com.example.aretrusaWeb1.model.User;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserService {

    public User getFakeUser()
    {
        Date date = new Date(2020-12-20);
        User fakeUser = new User("email@gmail.com", "user", "password", "jkahkghak23r89", "nome", "cognome", date, "sex", "city", "address", "31251516", "role");
        return fakeUser;
    }
}
