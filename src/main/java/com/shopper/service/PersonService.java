package com.shopper.service;

import com.shopper.crudRepositories.PersonRepo;
import com.shopper.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by internship on 19.09.2016.
 */
@Service
public class PersonService {
    @Autowired
    private PersonRepo repo;

    public List<Person> save(List<Person> persons) {
        List<Person> addedPersons = new ArrayList<>();

        for (int i = 0; i < persons.size(); i++) {
            repo.save(persons.get(i));
            addedPersons.add(persons.get(i));
        }

        return addedPersons;
    }

    public Iterable<Person> findAll() {
        return repo.findAll();
    }

    public void deleteAll() {
        repo.deleteAll();
    }
}
