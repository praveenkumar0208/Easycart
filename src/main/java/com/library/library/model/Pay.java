package com.library.library.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class   Pay {
    @Id
    @GeneratedValue
    public Long cid;
    public String name;
    public int cardnum;
    public int cardexp;
    public int ccv;

    public Pay() {
    }
    public Pay(String name, int cardnum, int cardexp, int ccv) {}

    public Long getId() {
        return cid;
    }

    public void setId(Long id) {
        this.cid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCardnum() {
        return cardnum;
    }

    public void setCardnum(int cardnum) {
        this.cardnum = cardnum;
    }

    public int getCardexp() {
        return cardexp;
    }

    public void setCardexp(int cardexp) {
        this.cardexp = cardexp;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }
}

