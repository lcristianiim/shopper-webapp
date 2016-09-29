package com.shopper.restControllers;

import com.shopper.models.Item;
import com.shopper.models.Person;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.condition.MediaTypeExpression;

import java.util.List;

/**
 * Created by internship on 19.09.2016.
 */
@RequestMapping(value = "/")
public interface PersonController {
    @RequestMapping(value = "persons", method = RequestMethod.GET)
    ResponseEntity getPersons();

    @RequestMapping(value = "persons", method = RequestMethod.POST)
    ResponseEntity savePerson(List <Person> persons);

    @RequestMapping(value = "{personName}/items", method = RequestMethod.GET)
    ResponseEntity getPersonsItems(String personName);

    @RequestMapping(value = "{personName}/items", method = RequestMethod.POST)
    ResponseEntity savePersonsItem(String personName, List <Item> items);
}
