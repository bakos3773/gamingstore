package com.bakos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Friend {
    @Id
    private String id;
    private String username;
    private String surname;

    public Friend() {
    }

    public Friend(String id, String username, String surname) {
        this.id = id;
        this.username = username;
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
