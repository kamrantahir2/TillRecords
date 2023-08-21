package com.example.TillRecords.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="tills")
public class Till {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="date_time")
    private String dateTime;

    @Column(name="till_name")
    private String tillName;

    @Column(name="coins_and_five_pounds")
    private double coinsAndFivePounds;

    @Column(name="remaining_notes")
    private double remainingNotes;

    @Column(name="over_under")
    private double overUnder;

//    Methods

    public void print() {
        System.out.println("date: " + this.dateTime);
        System.out.println("tillName: " + this.tillName);
        System.out.println("coinsAndFivePounds: " + this.coinsAndFivePounds);
        System.out.println("remainingNotes: " + this.remainingNotes);
        System.out.println("overUnder: " + this.overUnder);
    }



//    Constructors

    public Till(String tillName, double coinsAndFivePounds, double remainingNotes, double overUnder) {
        this.tillName = tillName;
        this.coinsAndFivePounds = coinsAndFivePounds;
        this.remainingNotes = remainingNotes;
        this.overUnder = overUnder;
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.dateTime = localDate.format(dateTimeFormatter);
    }

    public Till() {
    }

    //  GETTERS AND SETTERS

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getTillName() {
        return tillName;
    }

    public void setTillName(String tillName) {
        this.tillName = tillName;
    }

    public double getCoinsAndFivePounds() {
        return coinsAndFivePounds;
    }

    public void setCoinsAndFivePounds(double coinsAndFivePounds) {
        this.coinsAndFivePounds = coinsAndFivePounds;
    }

    public double getRemainingNotes() {
        return remainingNotes;
    }

    public void setRemainingNotes(double remainingNotes) {
        this.remainingNotes = remainingNotes;
    }

    public double getOverUnder() {
        return overUnder;
    }

    public void setOverUnder(double overUnder) {
        this.overUnder = overUnder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}