package com.shopper.service;

import com.shopper.crudRepositories.PersonRepo;
import com.shopper.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by internship on 19.09.2016.
 */
@Service
public class PersonService {
    @Autowired
    private PersonRepo repo;

    public Person save(Person person) {
            return repo.save(person);
    }

    public Iterable<Person> findAll() {
        return repo.findAll();
    }

    public void deleteAll() {
        repo.deleteAll();
    }
}
