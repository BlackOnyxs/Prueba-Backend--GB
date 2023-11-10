package com.microservice.people.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Person {

    private String firstName;
    private String lastname;

    private LocalDate bornDate;
    private String cip;


    public Person(String firstName, String lastname, LocalDate bornDate, String cip) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.bornDate = bornDate;
        this.cip = cip;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", bornDate=" + bornDate +
                ", cip='" + cip + '\'' +
                '}';
    }
}
