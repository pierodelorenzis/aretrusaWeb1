package com.example.aretrusaWeb1.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import java.util.Date;

public class User {

    @Id
    private ObjectId idUser;
    @Indexed(unique = true)
    private String email;
    @Indexed(unique = true)
    private String username;
    private String password;
    @Indexed(unique = true)
    private String cf;
    private String name;
    private String surname;
    private Date birthdate;
    private String sex;
    private String city;
    private String address;
    @Indexed(unique = true)
    private String telephone;
    public enum Role {
        Admin, Empleyee, Customer
    }
    private Role role;


    public User(String email, String username, String password, String cf, String name, String surname, Date birthdate, String sex, String city, String address, String telephone, Role role) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.cf = cf;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.sex = sex;
        this.city = city;
        this.address = address;
        this.telephone = telephone;
        this.role = role;
    }

    public User()
    {

    }

    public User(String cf, String name, String surname) {
        this.cf = cf;
        this.name = name;
        this.surname = surname;
    }

    public ObjectId getIdUser() {
        return idUser;
    }

    public void setIdUser(ObjectId id) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}