package com.shopper.service;

import com.shopper.crudRepositories.FamilyRepo;
import com.shopper.models.Family;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by internship on 26.09.2016.
 */
@Service
public class FamilyService {
    @Autowired
    private FamilyRepo repo;

    public Iterable<Family> findAll() {
        return repo.findAll();
    }

    public Iterable<Family> save(Iterable<Family> families) {
        return repo.save(families);
    }
}
