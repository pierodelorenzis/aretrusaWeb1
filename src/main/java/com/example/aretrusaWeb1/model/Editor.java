package com.example.aretrusaWeb1.model;


public class Editor {

    private int idEditor;
    private String name;
    private String city;
    private String address;
    private String telephone;

    public Editor(int idEditor, String name, String city, String address, String telephone){
        this.idEditor = idEditor;
        this.name = name;
        this.city = city;
        this.address = address;
        this.telephone = telephone;
    }

    public int getIdEditor() {
        return idEditor;
    }

    public void setIdEditor(int idEditor) {
        this.idEditor = idEditor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}

