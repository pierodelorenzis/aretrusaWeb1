package com.example.aretrusaWeb1.facade;

import com.example.aretrusaWeb1.model.User;
import com.example.aretrusaWeb1.service.UserService;
import com.example.aretrusaWeb1.view.UiUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {

    @Autowired
    UserService userService;

    public UiUser createFakeUser()
    {
        User fakeUser = userService.getFakeUser();
        return new UiUser(fakeUser);
    }
}
