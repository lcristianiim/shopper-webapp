package com.shopper.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by internship on 26.09.2016.
 */
@Entity
@Table(name =  "family")
@Getter
@Setter
@NoArgsConstructor
public class Family {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Person> personsList = new ArrayList<>();
}
