package com.example.aretrusaWeb1.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Borrow {

    @Id
    private ObjectId idBorrow;

    private Date startDate;
    private Date endDate;
    private Date startReservation;
    private Date endReservation;
    private int idCustomer;
    private int idFeedback;
    public enum StateBorrow {
        pending, inProgress, finished
    };
    private StateBorrow stateBorrow;

    public Borrow(ObjectId idBorrow, Date startDate, Date endDate, Date startReservation, Date endReservation, int idCustomer, int idFeedback, StateBorrow stateBorrow) {
        this.idBorrow = idBorrow;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startReservation = startReservation;
        this.endReservation = endReservation;
        this.idCustomer = idCustomer;
        this.idFeedback = idFeedback;
        this.stateBorrow = stateBorrow;
    }

    public Borrow() {
    }

    public ObjectId getIdBorrow() {
        return idBorrow;
    }

    public void setIdBorrow(ObjectId idBorrow) {
        this.idBorrow = idBorrow;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartReservation() {
        return startReservation;
    }

    public void setStartReservation(Date startReservation) {
        this.startReservation = startReservation;
    }

    public Date getEndReservation() {
        return endReservation;
    }

    public void setEndReservation(Date endReservation) {
        this.endReservation = endReservation;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(int idFeedback) {
        this.idFeedback = idFeedback;
    }


    public StateBorrow getStateBorrow() {
        return stateBorrow;
    }

    public void setStateBorrow(StateBorrow stateBorrow) {
        this.stateBorrow = stateBorrow;
    }
}
