package com.example.aretrusaWeb1.controller;

import com.example.aretrusaWeb1.facade.UserFacade;
import com.example.aretrusaWeb1.view.UiUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserFacade userFacade;

    @GetMapping("/giveMeAUser")
    UiUser getUser() throws ParseException {
        return userFacade.createFakeUser();
    }

}
