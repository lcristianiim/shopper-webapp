package com.shopper.restControllers;

import com.shopper.models.Item;
import com.shopper.models.Person;
import com.shopper.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by internship on 19.09.2016.
 */
@RestController
public class PersonControllerImpl implements PersonController {
    @Autowired
    private PersonService personService;

    @Override
    public ResponseEntity getPersons() {
        return ResponseEntity.ok().body((List<Person>) personService.findAll());
    }

    @Override
    public ResponseEntity savePerson(@RequestBody List<Person> persons) {
        List<Person> addedPersons = personService.save(persons);
        return ResponseEntity.ok().body(addedPersons);
    }

    @Override
    public ResponseEntity getPersonsItems(@PathVariable("personName") String personName) {
        List<Item> personsItems = personService.getAllItems(personName);
        return ResponseEntity.ok().body((List<Item>) personsItems);
    }

    @Override
    public ResponseEntity savePersonsItem(@PathVariable("personName") String person, @RequestBody List<Item> items) {
        Person addedPerson = personService.saveItems(person, items);
        return ResponseEntity.ok().body(addedPerson);
    }
}