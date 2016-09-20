package com.shopper.restControllers;

import com.shopper.models.Person;
import com.shopper.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
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
}