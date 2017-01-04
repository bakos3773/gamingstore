package com.bakos.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Game {

    @Id
    private String id;
    private String name;
    private String publisher;
    private String description;
    private String languageVersion;
    private String state;
    private String owner;
    private String ownerId;
    @CreatedDate
    private Date createdDate;
    private int amount;
    private float price;
    private boolean exchange;

    public Game() {
    }

    public Game(String name, String publisher, String description, String languageVersion, String state, String owner, String ownerId, Date createdDate, int amount, float price, boolean exchange) {
        this.name = name;
        this.publisher = publisher;
        this.description = description;
        this.languageVersion = languageVersion;
        this.state = state;
        this.owner = owner;
        this.ownerId = ownerId;
        this.createdDate = createdDate;
        this.amount = amount;
        this.price = price;
        this.exchange = exchange;
    }

    public Game(String id, String name, String publisher, String description, String languageVersion, String state, String owner, String ownerId, Date createdDate, int amount, float price, boolean exchange) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
        this.description = description;
        this.languageVersion = languageVersion;
        this.state = state;
        this.owner = owner;
        this.ownerId = ownerId;
        this.createdDate = createdDate;
        this.amount = amount;
        this.price = price;
        this.exchange = exchange;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getLanguageVersion() {
        return languageVersion;
    }

    public void setLanguageVersion(String languageVersion) {
        this.languageVersion = languageVersion;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isExchange() {
        return exchange;
    }

    public void setExchange(boolean exchange) {
        this.exchange = exchange;
    }
}
