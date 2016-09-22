package com.shopper.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;

/**
 * Created by internship on 19.09.2016.
 */
@Entity
@Table(name = "item")
@Getter
@Setter
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue
    private int id;
    private double price;
    private String details;
    private int category;
    private Calendar time;

    public Item(double price, String details, int category, Calendar time) {
        this.price = price;
        this.details = details;
        this.category = category;
        this.time = time;
    }
}