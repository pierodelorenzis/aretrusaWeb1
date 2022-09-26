package com.example.aretusaWeb1.view;

import com.example.aretusaWeb1.model.Borrow;

import java.util.Date;

public class UiBorrow {

    public Date startDate;
    public Date endDate;
    public Date startReservation;
    public Date endReservation;

    public UiBorrow ()
    {

    }
    public UiBorrow(Borrow borrow) {
        this.startDate = borrow.getStartDate();
        this.endDate = borrow.getEndDate();
        this.startReservation = borrow.getStartReservation();
        this.endReservation = borrow.getEndReservation();
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartReservation() {
        return startReservation;
    }

    public Date getEndReservation() {
        return endReservation;
    }

}
