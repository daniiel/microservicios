package com.webservices.restfulwebservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class Person {

    private String name;
    private LocalDate birthday;
    @JsonIgnore
    private String city;

    public Person(String name, LocalDate birthday, String city) {
        this.name = name;
        this.birthday = birthday;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("Person { name = %s, birthday %s, city = %s}", name, birthday, city);
    }
}
