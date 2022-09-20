package com.example.aretrusaWeb1.view;

import com.example.aretrusaWeb1.model.Customer;

public class UiCustomer extends UiUser {

    public float balance;
    public int bookLost;
    public int bookDelay;
    public int bookDamage;
    public int evaluation;

    public UiCustomer(Customer customer ) {
        this.balance = customer.getBalance();
        this.bookLost = customer.getBookLost();
        this.bookDelay = customer.getBookDelay();
        this.bookDamage = customer.getBookDamage();
        this.evaluation = customer.getEvaluation();
    }

    public UiCustomer() {
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getBookLost() {
        return bookLost;
    }

    public void setBookLost(int bookLost) {
        this.bookLost = bookLost;
    }

    public int getBookDelay() {
        return bookDelay;
    }

    public void setBookDelay(int bookDelay) {
        this.bookDelay = bookDelay;
    }

    public int getBookDamage() {
        return bookDamage;
    }

    public void setBookDamage(int bookDamage) {
        this.bookDamage = bookDamage;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }
}
