package com.shopper.restControllers;

import com.shopper.models.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.condition.MediaTypeExpression;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by internship on 19.09.2016.
 */
@RequestMapping(value = "/")
public interface PersonController {
    @RequestMapping(value = "persons", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    ResponseEntity getPersons();

    @RequestMapping(value = "persons", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    ResponseEntity savePerson(List <Person> persons);
}
