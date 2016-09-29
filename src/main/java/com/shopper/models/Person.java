package com.shopper.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by internship on 19.09.2016.
 */
@Entity
@Table (name = "person")
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    public Person (String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Item> items = new ArrayList<>();
}