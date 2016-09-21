package com.shopper.service;

import com.shopper.crudRepositories.PersonRepo;
import com.shopper.models.Item;
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

    public Person save(Person person) {
        repo.save(person);
        return person;
    }

    public Iterable<Person> findAll() {
        return repo.findAll();
    }

    public void deleteAll() {
        repo.deleteAll();
    }

    public Person saveItems(String personName, List<Item> items) {
        Person person = repo.findByName(personName);
        List<Item> personsItems = person.getItems();

        for (int i = 0; i < items.size(); i++) {
            person.getItems().add(items.get(i));
        }
        repo.save(person);
        return person;
    }

    public List<Item> getAllItems(String personName) {
        Person person = repo.findByName(personName);
        return person.getItems();
    }
}