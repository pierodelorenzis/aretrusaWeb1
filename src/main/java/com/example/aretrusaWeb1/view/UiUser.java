package com.example.aretrusaWeb1.view;

import com.example.aretrusaWeb1.model.User;
import com.example.aretrusaWeb1.service.UserService;

import java.util.Date;

public class UiUser {

    public String email;
    public String username;
    public String password;
    public String cf;

    public String name;
    public String surname;
    public Date birthdate;
    public String sex;
    public String city;
    public String address;
    public String telephone;
    public String role;

    public UiUser()
    {

    }

    public UiUser(User user) {
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.cf = user.getCf();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.birthdate = user.getBirthdate();
        this.sex = user.getSex();
        this.city = user.getCity();
        this.address = user.getAddress();
        this.telephone = user.getTelephone();
        this.role = user.getRole();
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCf() {
        return cf;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getSex() {
        return sex;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getRole() {
        return role;
    }
}
