package com.shopper.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

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

    @Temporal(TemporalType.DATE)
    private Date time;

    public Item(double price, String details, int category, Date time) {
        this.price = price;
        this.details = details;
        this.category = category;
        this.time = time;
    }
}