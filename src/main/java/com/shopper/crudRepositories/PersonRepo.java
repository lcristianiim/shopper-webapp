package com.shopper.crudRepositories;

import com.shopper.models.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by internship on 19.09.2016.
 */
public interface PersonRepo extends CrudRepository<Person, Long> {
    @Query("select a from Person a where a.name = :name")
    Person findByName(@Param("name") String name);
}