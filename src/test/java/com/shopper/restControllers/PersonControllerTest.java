package com.shopper.restControllers;

import com.google.gson.Gson;
import com.shopper.ShoppingApplication;
import com.shopper.crudRepositories.PersonRepo;
import com.shopper.models.Item;
import com.shopper.models.Person;
import com.shopper.service.PersonService;
import org.h2.util.DateTimeUtils;
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

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

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
    private PersonRepo personRepo;

    @Before
    public void setUp() throws Exception {
        Person person1 = new Person("Cristian");
        Person person2 = new Person("Brighita");

        Calendar time = Calendar.getInstance();
        Calendar time2;


        Item item = new Item(100, "Alimentare motorina", 9, time);
        time.add(Calendar.MINUTE, 1);
        Item item1 = new Item(100, "Alimentare motorina 2", 9, time);
        time.add(Calendar.MINUTE, 1);
        Item item2 = new Item(160, "Cumparaturi Kaufland", 1, time);
        time.add(Calendar.MINUTE, 1);
        Item item3 = new Item(200, "Cumparaturi Real", 1, time);

        this.persons.add(person1);
        this.persons.add(person2);

        person1.getItems().add(item);
        person1.getItems().add(item1);
        person1.getItems().add(item2);

        person2.getItems().add(item3);

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

    @Test
    public void getPersonsItems() throws Exception {
        for (Person person : persons) {
            personService.save(persons);
        }

        String stringPath = "/" + persons.get(0).getName() + "/items";

        mockMvc.perform(get(stringPath)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andDo(print())
            .andExpect(jsonPath("$", hasSize(3)))
            .andExpect(status().isOk());
    }

    @Test
    public void savePersonsItem() throws Exception {

        personService.save(persons);

        List<Item> itemList = new ArrayList<>();

        Calendar time = Calendar.getInstance();

        Item itemTest = new Item(110, "Testing item", 2, time);
        itemList.add(itemTest);


        mockMvc.perform(post("/Cristian/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(itemList))
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(3)));
    }
}