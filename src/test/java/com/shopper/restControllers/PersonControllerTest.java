package com.shopper.restControllers;

import com.google.gson.Gson;
import com.shopper.ShoppingApplication;
import com.shopper.models.Person;
import com.shopper.service.PersonService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.ws.rs.core.MediaType;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Created by internship on 19.09.2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoppingApplication.class)
public class PersonControllerTest {

    @Autowired
    private PersonService personService;

    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @Autowired
    private WebApplicationContext context;

    private List<Person> persons = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        Person person1 = new Person("Cristian");
        Person person2 = new Person("Brighita");

        this.persons.add(person1);
        this.persons.add(person2);

        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @After
    public void tearDown() throws Exception {
        personService.deleteAll();
    }

    @Test
    public void savePerson() throws Exception {
        mockMvc.perform(post("/persons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(persons))
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void getPersons() throws Exception {
        for (Person person : persons) {
            personService.save(persons);
        }

        mockMvc.perform(get("/persons")
                .accept(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(status().isOk());
    }
}